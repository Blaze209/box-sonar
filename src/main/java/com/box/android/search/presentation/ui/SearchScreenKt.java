package com.box.android.search.presentation.ui;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.rounded.AccessTimeKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SnackbarHostKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.compose.BoxListViewItemKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.ComposeUtilsKt;
import com.box.android.base.compose.ItemStateScreensKt;
import com.box.android.base.compose.ItemsStateConfig;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.divider.BoxSelectionAwareDividerKt;
import com.box.android.base.compose.progressbar.BoxCircularProgressBarKt;
import com.box.android.base.models.ClickActionsConfig;
import com.box.android.base.models.ListItemInfo;
import com.box.android.base.models.SecondaryActionType;
import com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt;
import com.box.android.base.utilities.OfflineManagerExtensionsKt;
import com.box.android.browse.cpl.itemsList.ItemReducer;
import com.box.android.browse.search.component.FilesSearchInputFieldKt;
import com.box.android.browse.utilities.TestTagUtilsKt;
import com.box.android.cpl.IdentifiedList;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.cpl.Wrapped;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.models.DomainErrorKt;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.ItemsScreenMode;
import com.box.android.domain.models.boxai.AiRecentSession;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.models.search.FilesSearchFilters;
import com.box.android.domain.models.search.SearchMode;
import com.box.android.hubs.presentation.HubReducer;
import com.box.android.hubs.presentation.HubsScreenKt;
import com.box.android.notes.presentation.cpl.NotesItemViewData;
import com.box.android.notes.presentation.cpl.NotesItemViewDataKt;
import com.box.android.search.R;
import com.box.android.search.presentation.cpl.FilesSearchReducer;
import com.box.android.search.presentation.cpl.SearchItemReducer;
import com.box.android.search.presentation.cpl.SearchModeState;
import com.box.android.search.presentation.cpl.SearchModeStateKt;
import com.box.android.search.presentation.cpl.SearchReducer;
import com.box.android.search.presentation.ui.components.AskBoxAiRowKt;
import com.box.android.search.presentation.ui.components.SearchRecentsComponentsKt;
import com.box.android.search.presentation.ui.components.SearchResultsHeaderKt;
import com.box.brownfieldApi.featuresNavigator.AiCenterInitialContext;
import com.box.brownfieldApi.featuresNavigator.HubDetailsInitialContext;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.jvm.KClassesJvm;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SearchScreen.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000¼\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u009e\u0002\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2<\b\u0002\u0010\n\u001a6\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00132%\b\u0002\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00132(\b\u0002\u0010\u0016\u001a\"\b\u0001\u0012\u0004\u0012\u00020\u0017\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010\u000b2<\b\u0002\u0010\u001a\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0002\u0010\u001d\u001aÆ\u0003\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00100%2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020)0%2\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020.0%2\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00072\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u00070\u00132\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00070\u00132\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00010\t2 \u00106\u001a\u001c\u0012\u0004\u0012\u00020\u0010\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u000207\u0018\u00010\u00030\u00132\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u00132\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00010\u00132\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0014\b\u0002\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u00132\u0014\b\u0002\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u00132!\u0010=\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00010\u00132\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u000e\b\u0002\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0014\b\u0002\u0010@\u001a\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020\u00010\u00132\u0010\b\u0002\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010C\u001a5\u0010D\u001a\u00020\u00012\u0013\u0010E\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¢\u0006\u0002\bF2\u0011\u0010G\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\bFH\u0003¢\u0006\u0002\u0010H\u001a1\u0010I\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u00072\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0010\b\u0002\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tH\u0003¢\u0006\u0002\u0010J\u001a\u009a\u0001\u0010K\u001a\u00020\u00012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010*\u001a\u00020\u00072\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00010\t2 \u00106\u001a\u001c\u0012\u0004\u0012\u00020\u0010\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u000207\u0018\u00010\u00030\u00132\u0006\u0010/\u001a\u00020\u00072\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u00070\u00132\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00070\u00132\u0015\b\u0002\u0010E\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¢\u0006\u0002\bFH\u0003¢\u0006\u0002\u0010L\u001a\r\u0010M\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010N\u001a1\u0010O\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020Q0\u00032\u0006\u0010/\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010S\u001aO\u0010T\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010U\u001a\u00020\u00102\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u00132\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u000e\b\u0002\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0003¢\u0006\u0002\u0010V\u001a3\u0010W\u001a\u00020\u00012\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020\u00102\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\\\u001ay\u0010]\u001a\u00020\u00012\b\u0010^\u001a\u0004\u0018\u00010\u00102\b\u0010_\u001a\u0004\u0018\u00010\u00102\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00100%2\u0012\u0010`\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u00132\u0012\u0010a\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u00132\f\u0010(\u001a\b\u0012\u0004\u0012\u00020)0%2\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u0013H\u0003¢\u0006\u0002\u0010c\u001a\r\u0010d\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010N\u001a\r\u0010e\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010N¨\u0006f²\u0006\n\u0010g\u001a\u00020\u0004X\u008a\u0084\u0002²\u0006\n\u0010h\u001a\u00020iX\u008a\u0084\u0002²\u0006\n\u0010j\u001a\u00020&X\u008a\u0084\u0002²\u0006\n\u0010k\u001a\u00020PX\u008a\u0084\u0002²\u0006\n\u0010l\u001a\u00020\u0010X\u008a\u008e\u0002"}, d2 = {"SearchScreen", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/search/presentation/cpl/SearchReducer$State;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action;", "isRedesignedVersion", "", "onDismissSearch", "Lkotlin/Function0;", "onOpenItem", "Lkotlin/Function2;", "Lcom/box/android/domain/models/item/ItemModel;", "Lkotlin/ParameterName;", "name", "item", "", "accessibleSharedLink", "onOpenItemMoreActionsMenu", "Lkotlin/Function1;", "onOpenHub", HubDetailsInitialContext.HUB_ID_KEY, "onOpenFilesFiltersForResult", "Lcom/box/android/domain/models/search/FilesSearchFilters;", "Lkotlin/coroutines/Continuation;", "", "onOpenAiCenter", "sessionId", AiCenterInitialContext.INITIAL_PROMPT_KEY, "(Lcom/box/android/cpl/Store;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SearchScreenContent", "searchBarText", "searchModeState", "Lcom/box/android/search/presentation/cpl/SearchModeState;", "screenState", "Lcom/box/android/search/presentation/cpl/SearchReducer$ScreenState;", "resultList", "", "Lcom/box/android/search/presentation/cpl/SearchItemReducer$State;", "recentQueries", "recentAiSessions", "Lcom/box/android/domain/models/boxai/AiRecentSession;", "canLoadMore", "snackbarHostState", "Landroidx/compose/material3/SnackbarHostState;", "enabledTabs", "Lcom/box/android/domain/models/search/SearchMode;", "isSelecting", "isAiEnabled", "isItemSelected", "Lcom/box/android/domain/models/ItemId$Remote;", "isHubSelected", "onRetry", "onLoadMore", "scopedStoreProvider", "Lcom/box/android/search/presentation/cpl/SearchItemReducer$Action;", "onSearchBarTextUpdated", "onSearchModeChanged", "onSearchSubmitted", "onDeleteRecentQuery", "onRecentQuerySelected", "onRecentAiSessionClicked", "onAskBoxAiClicked", "onFiltersButtonClick", "onRemoveFilesFilter", "Lcom/box/android/domain/models/search/FilesSearchFilters$FilterType;", "onClearFilters", "(Ljava/lang/String;Lcom/box/android/search/presentation/cpl/SearchModeState;Lcom/box/android/search/presentation/cpl/SearchReducer$ScreenState;Ljava/util/List;Ljava/util/List;Ljava/util/List;ZLandroidx/compose/material3/SnackbarHostState;Ljava/util/List;ZZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;IIII)V", "ScrollableStateScreenWithHeader", BoxAnalyticsParams.CTA_LOCATION_HEADER, "Landroidx/compose/runtime/Composable;", "content", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "EmptyResultsSearchScreen", "(ZZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "BoxSearchListingContent", "(Ljava/util/List;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SearchLoadMoreItem", "(Landroidx/compose/runtime/Composer;I)V", "FileItem", "Lcom/box/android/browse/cpl/itemsList/ItemReducer$State;", "Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action;", "isSelected", "(Lcom/box/android/cpl/Store;ZZLandroidx/compose/runtime/Composer;I)V", "SearchBar", "searchBarHintText", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "EmptyQuerySearchScreen", "iconDrawableResource", "", "mainText", "secondaryText", "(ILjava/lang/String;Ljava/lang/String;ZLandroidx/compose/runtime/Composer;II)V", "SearchRecentsScreen", "recentSearchesTitle", "recentAiSessionsTitle", "onQuerySelected", "onDeleteQuery", "onAiSessionSelected", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "SearchScreenPreview", "SearchRecentsScreenPreview", "search_generalProdRelease", "state", "currentTimeMillis", "", "searchItemState", "itemState", "text"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SearchScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxSearchListingContent$lambda$2(List list, boolean z, Function0 function0, Function1 function1, boolean z2, Function1 function2, Function1 function3, Function2 function4, int i, int i2, Composer composer, int i3) {
        BoxSearchListingContent(list, z, function0, function1, z2, function2, function3, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EmptyQuerySearchScreen$lambda$0(int i, String str, String str2, boolean z, int i2, int i3, Composer composer, int i4) {
        EmptyQuerySearchScreen(i, str, str2, z, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EmptyResultsSearchScreen$lambda$1(boolean z, boolean z2, Function0 function0, int i, int i2, Composer composer, int i3) {
        EmptyResultsSearchScreen(z, z2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FileItem$lambda$7(Store store, boolean z, boolean z2, int i, Composer composer, int i2) {
        FileItem(store, z, z2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScrollableStateScreenWithHeader$lambda$2(Function2 function2, Function2 function3, int i, Composer composer, int i2) {
        ScrollableStateScreenWithHeader(function2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchBar$lambda$2(String str, String str2, Function1 function1, Function0 function0, Function0 function2, int i, int i2, Composer composer, int i3) {
        SearchBar(str, str2, function1, function0, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchLoadMoreItem$lambda$1(int i, Composer composer, int i2) {
        SearchLoadMoreItem(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String SearchRecentsScreen$lambda$0$0$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object SearchRecentsScreen$lambda$0$0$1(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchRecentsScreen$lambda$1(String str, String str2, List list, Function1 function1, Function1 function2, List list2, Function1 function3, int i, Composer composer, int i2) {
        SearchRecentsScreen(str, str2, list, function1, function2, list2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchRecentsScreenPreview$lambda$0(int i, Composer composer, int i2) {
        SearchRecentsScreenPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchScreen$lambda$24(Store store, boolean z, Function0 function0, Function2 function2, Function1 function1, Function1 function3, Function2 function4, Function2 function5, int i, int i2, Composer composer, int i3) {
        SearchScreen(store, z, function0, function2, function1, function3, function4, function5, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchScreenContent$lambda$7(String str, SearchModeState searchModeState, SearchReducer.ScreenState screenState, List list, List list2, List list3, boolean z, SnackbarHostState snackbarHostState, List list4, boolean z2, boolean z3, Function1 function1, Function1 function2, Function0 function0, Function0 function3, Function1 function4, Function1 function5, Function0 function6, Function1 function7, Function0 function8, Function1 function9, Function1 function10, Function1 function11, Function0 function12, Function0 function13, Function1 function14, Function0 function15, boolean z4, int i, int i2, int i3, int i4, Composer composer, int i5) {
        SearchScreenContent(str, searchModeState, screenState, list, list2, list3, z, snackbarHostState, list4, z2, z3, function1, function2, function0, function3, function4, function5, function6, function7, function8, function9, function10, function11, function12, function13, function14, function15, z4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchScreenPreview$lambda$15(int i, Composer composer, int i2) {
        SearchScreenPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SearchScreenPreview$lambda$4$0(ItemId.Remote remote) {
        Intrinsics.checkNotNullParameter(remote, "<unused var>");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SearchScreenPreview$lambda$5$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Store SearchScreenPreview$lambda$8$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchScreen$lambda$0$0(String str, String str2) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0129  */
    /* JADX WARN: Code duplicated, block: B:103:0x013b  */
    /* JADX WARN: Code duplicated, block: B:105:0x014a  */
    /* JADX WARN: Code duplicated, block: B:108:0x0152  */
    /* JADX WARN: Code duplicated, block: B:111:0x017f  */
    /* JADX WARN: Code duplicated, block: B:112:0x0183  */
    /* JADX WARN: Code duplicated, block: B:115:0x0196  */
    /* JADX WARN: Code duplicated, block: B:118:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:119:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:122:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:124:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:127:0x01da  */
    /* JADX WARN: Code duplicated, block: B:128:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:131:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:135:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:138:0x022d  */
    /* JADX WARN: Code duplicated, block: B:139:0x0230  */
    /* JADX WARN: Code duplicated, block: B:142:0x0238  */
    /* JADX WARN: Code duplicated, block: B:146:0x0249  */
    /* JADX WARN: Code duplicated, block: B:149:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:150:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:153:0x02af  */
    /* JADX WARN: Code duplicated, block: B:154:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:157:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:158:0x02be  */
    /* JADX WARN: Code duplicated, block: B:161:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:162:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:165:0x02de  */
    /* JADX WARN: Code duplicated, block: B:166:0x02e1  */
    /* JADX WARN: Code duplicated, block: B:169:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:173:0x0307  */
    /* JADX WARN: Code duplicated, block: B:176:0x0369  */
    /* JADX WARN: Code duplicated, block: B:178:0x0380  */
    /* JADX WARN: Code duplicated, block: B:179:0x0383  */
    /* JADX WARN: Code duplicated, block: B:181:0x0387  */
    /* JADX WARN: Code duplicated, block: B:184:0x03bf  */
    /* JADX WARN: Code duplicated, block: B:186:0x03c7  */
    /* JADX WARN: Code duplicated, block: B:189:0x03ec  */
    /* JADX WARN: Code duplicated, block: B:191:0x03f4  */
    /* JADX WARN: Code duplicated, block: B:194:0x040e  */
    /* JADX WARN: Code duplicated, block: B:195:0x0411  */
    /* JADX WARN: Code duplicated, block: B:198:0x041a  */
    /* JADX WARN: Code duplicated, block: B:200:0x0422  */
    /* JADX WARN: Code duplicated, block: B:203:0x0439  */
    /* JADX WARN: Code duplicated, block: B:204:0x043c  */
    /* JADX WARN: Code duplicated, block: B:207:0x0453  */
    /* JADX WARN: Code duplicated, block: B:208:0x0456  */
    /* JADX WARN: Code duplicated, block: B:211:0x045d  */
    /* JADX WARN: Code duplicated, block: B:213:0x0465  */
    /* JADX WARN: Code duplicated, block: B:216:0x047b  */
    /* JADX WARN: Code duplicated, block: B:217:0x047e  */
    /* JADX WARN: Code duplicated, block: B:220:0x0485  */
    /* JADX WARN: Code duplicated, block: B:222:0x048d  */
    /* JADX WARN: Code duplicated, block: B:225:0x04a5  */
    /* JADX WARN: Code duplicated, block: B:226:0x04a8  */
    /* JADX WARN: Code duplicated, block: B:229:0x04af  */
    /* JADX WARN: Code duplicated, block: B:231:0x04b7  */
    /* JADX WARN: Code duplicated, block: B:234:0x04d6  */
    /* JADX WARN: Code duplicated, block: B:235:0x04d9  */
    /* JADX WARN: Code duplicated, block: B:238:0x04e0  */
    /* JADX WARN: Code duplicated, block: B:23:0x0051  */
    /* JADX WARN: Code duplicated, block: B:240:0x04e8  */
    /* JADX WARN: Code duplicated, block: B:243:0x0504  */
    /* JADX WARN: Code duplicated, block: B:244:0x0507  */
    /* JADX WARN: Code duplicated, block: B:247:0x050f  */
    /* JADX WARN: Code duplicated, block: B:249:0x0517  */
    /* JADX WARN: Code duplicated, block: B:252:0x0533  */
    /* JADX WARN: Code duplicated, block: B:253:0x0536  */
    /* JADX WARN: Code duplicated, block: B:256:0x053e  */
    /* JADX WARN: Code duplicated, block: B:258:0x0546  */
    /* JADX WARN: Code duplicated, block: B:25:0x0057  */
    /* JADX WARN: Code duplicated, block: B:261:0x055e  */
    /* JADX WARN: Code duplicated, block: B:262:0x0561  */
    /* JADX WARN: Code duplicated, block: B:265:0x0568  */
    /* JADX WARN: Code duplicated, block: B:267:0x0570  */
    /* JADX WARN: Code duplicated, block: B:26:0x005a  */
    /* JADX WARN: Code duplicated, block: B:270:0x0588  */
    /* JADX WARN: Code duplicated, block: B:271:0x058b  */
    /* JADX WARN: Code duplicated, block: B:274:0x0592  */
    /* JADX WARN: Code duplicated, block: B:276:0x059a  */
    /* JADX WARN: Code duplicated, block: B:279:0x05b2  */
    /* JADX WARN: Code duplicated, block: B:280:0x05b5  */
    /* JADX WARN: Code duplicated, block: B:283:0x05bc  */
    /* JADX WARN: Code duplicated, block: B:285:0x05c4  */
    /* JADX WARN: Code duplicated, block: B:288:0x05dc  */
    /* JADX WARN: Code duplicated, block: B:289:0x05df  */
    /* JADX WARN: Code duplicated, block: B:292:0x05e6  */
    /* JADX WARN: Code duplicated, block: B:294:0x05ee  */
    /* JADX WARN: Code duplicated, block: B:297:0x0606  */
    /* JADX WARN: Code duplicated, block: B:298:0x0609  */
    /* JADX WARN: Code duplicated, block: B:301:0x0610  */
    /* JADX WARN: Code duplicated, block: B:303:0x0618  */
    /* JADX WARN: Code duplicated, block: B:307:0x0631  */
    /* JADX WARN: Code duplicated, block: B:30:0x0061  */
    /* JADX WARN: Code duplicated, block: B:310:0x0639  */
    /* JADX WARN: Code duplicated, block: B:312:0x0641  */
    /* JADX WARN: Code duplicated, block: B:315:0x0674  */
    /* JADX WARN: Code duplicated, block: B:317:0x0682  */
    /* JADX WARN: Code duplicated, block: B:31:0x0064  */
    /* JADX WARN: Code duplicated, block: B:320:0x0695  */
    /* JADX WARN: Code duplicated, block: B:322:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x0068  */
    /* JADX WARN: Code duplicated, block: B:35:0x0070  */
    /* JADX WARN: Code duplicated, block: B:36:0x0073  */
    /* JADX WARN: Code duplicated, block: B:41:0x007d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0080  */
    /* JADX WARN: Code duplicated, block: B:44:0x0084  */
    /* JADX WARN: Code duplicated, block: B:46:0x008c  */
    /* JADX WARN: Code duplicated, block: B:47:0x008f  */
    /* JADX WARN: Code duplicated, block: B:52:0x009c  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:58:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:63:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:67:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:72:0x00da  */
    /* JADX WARN: Code duplicated, block: B:73:0x00df  */
    /* JADX WARN: Code duplicated, block: B:75:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:77:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:78:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:82:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:83:0x0101  */
    /* JADX WARN: Code duplicated, block: B:86:0x010a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:87:0x010c  */
    /* JADX WARN: Code duplicated, block: B:88:0x010f  */
    /* JADX WARN: Code duplicated, block: B:90:0x0113  */
    /* JADX WARN: Code duplicated, block: B:91:0x0116  */
    /* JADX WARN: Code duplicated, block: B:93:0x011a  */
    /* JADX WARN: Code duplicated, block: B:95:0x011d  */
    /* JADX WARN: Code duplicated, block: B:96:0x0120  */
    /* JADX WARN: Code duplicated, block: B:98:0x0124  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void SearchScreen(final Store<SearchReducer.State, SearchReducer.Action> store, boolean z, final Function0<Unit> onDismissSearch, Function2<? super ItemModel, ? super String, Unit> function2, Function1<? super ItemModel, Unit> function1, Function1<? super String, Unit> function3, Function2<? super FilesSearchFilters, ? super Continuation<? super FilesSearchFilters>, ? extends Object> function4, Function2<? super String, ? super String, Unit> function5, Composer composer, final int i, final int i2) {
        int i3;
        boolean z2;
        int i4;
        Function2<? super ItemModel, ? super String, Unit> function6;
        int i5;
        int i6;
        Function1<? super ItemModel, Unit> function7;
        int i7;
        int i8;
        int i9;
        int i10;
        Function2<? super FilesSearchFilters, ? super Continuation<? super FilesSearchFilters>, ? extends Object> function8;
        int i11;
        int i12;
        int i13;
        boolean z3;
        final Function2<? super String, ? super String, Unit> function9;
        final boolean z4;
        Composer composer2;
        final Function2<? super ItemModel, ? super String, Unit> function10;
        final Function2<? super FilesSearchFilters, ? super Continuation<? super FilesSearchFilters>, ? extends Object> function11;
        final Function1<? super ItemModel, Unit> function12;
        final Function1<? super String, Unit> function13;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z5;
        Function2<? super ItemModel, ? super String, Unit> function14;
        Function1<? super String, Unit> function15;
        Function2<? super String, ? super String, Unit> function16;
        int i14;
        State stateCollectAsStateWithLifecycle;
        SearchModeState searchModeState;
        FilesSearchReducer.State state;
        Object objRememberedValue;
        SnackbarHostState snackbarHostState;
        int i15;
        boolean z6;
        Object objRememberedValue2;
        boolean z7;
        SearchScreenKt$SearchScreen$2$1 searchScreenKt$SearchScreen$2$1RememberedValue;
        String strStringResource;
        boolean z8;
        boolean z9;
        SearchScreenKt$SearchScreen$3$1 searchScreenKt$SearchScreen$3$1;
        LifecycleCoroutineScope lifecycleScope;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        final Store<SearchReducer.State, SearchReducer.Action> store2;
        Function2<? super FilesSearchFilters, ? super Continuation<? super FilesSearchFilters>, ? extends Object> function17;
        Function2<? super String, ? super String, Unit> function18;
        Function1<? super String, Unit> function19;
        int i16;
        final State state2;
        Composer composer3;
        Function1<? super ItemModel, Unit> function20;
        Function2<? super ItemModel, ? super String, Unit> function21;
        int i17;
        SearchScreenKt$SearchScreen$4$1 searchScreenKt$SearchScreen$4$1;
        Long totalCount;
        boolean z16;
        SearchReducer.State stateSearchScreen$lambda$1;
        boolean zChanged;
        SearchScreenKt$SearchScreen$6$1 searchScreenKt$SearchScreen$6$1RememberedValue;
        SearchReducer.State stateSearchScreen$lambda$2;
        boolean zChanged2;
        SearchScreenKt$SearchScreen$7$1 searchScreenKt$SearchScreen$7$1RememberedValue;
        boolean z17;
        Object objRememberedValue3;
        Function0 function0;
        Function0 function22;
        boolean z18;
        Object objRememberedValue4;
        boolean z19;
        Object objRememberedValue5;
        boolean z20;
        Object objRememberedValue6;
        int i18;
        boolean z21;
        Object objRememberedValue7;
        boolean z22;
        boolean z23;
        Object objRememberedValue8;
        boolean z24;
        boolean z25;
        Object objRememberedValue9;
        boolean z26;
        Object objRememberedValue10;
        boolean z27;
        Object objRememberedValue11;
        boolean z28;
        Object objRememberedValue12;
        boolean z29;
        Object objRememberedValue13;
        boolean z30;
        Object objRememberedValue14;
        boolean z31;
        Object objRememberedValue15;
        int i19;
        Object objRememberedValue16;
        int i20;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(onDismissSearch, "onDismissSearch");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1463316607);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SearchScreen)N(store,isRedesignedVersion,onDismissSearch,onOpenItem,onOpenItemMoreActionsMenu,onOpenHub,onOpenFilesFiltersForResult,onOpenAiCenter)103@5427L11,105@5472L29,108@5609L32,110@5743L153,118@5923L61,118@5902L82,122@6009L54,123@6101L172,123@6068L205,130@6320L7,131@6375L1099,131@6347L1127,168@8042L20,169@8088L20,207@9688L76,170@8128L70,173@8221L72,177@8379L79,185@8663L48,188@8743L187,180@8488L147,193@8962L90,196@9086L90,199@9213L63,200@9306L52,201@9391L116,204@9539L122,156@7479L2377:SearchScreen.kt#vkhrzj");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i21 = i2 & 2;
        if (i21 == 0) {
            if ((i & 48) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if (composerStartRestartGroup.changedInstance(onDismissSearch)) {
                    i20 = 256;
                } else {
                    i20 = 128;
                }
                i3 |= i20;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    function6 = function2;
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((i & 24576) == 0) {
                        function7 = function1;
                        if (composerStartRestartGroup.changedInstance(function7)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 32;
                    if (i8 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 64;
                    if (i10 != 0) {
                        i3 |= 1572864;
                        function8 = function4;
                    } else {
                        function8 = function4;
                        if ((i & 1572864) == 0) {
                            if (composerStartRestartGroup.changedInstance(function8)) {
                                i11 = 1048576;
                            } else {
                                i11 = 524288;
                            }
                            i3 |= i11;
                        }
                    }
                    i12 = i2 & 128;
                    if (i12 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function5)) {
                            i13 = 8388608;
                        } else {
                            i13 = 4194304;
                        }
                        i3 |= i13;
                    }
                    if ((i3 & 4793491) != 4793490) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        if (i21 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (i4 != 0) {
                            function14 = null;
                        } else {
                            function14 = function6;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        }
                        if (i8 != 0) {
                            function15 = null;
                        } else {
                            function15 = function3;
                        }
                        if (i10 != 0) {
                            function8 = null;
                        }
                        if (i12 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792936852, "CC(remember):SearchScreen.kt#9igjgp");
                            objRememberedValue16 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue16 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue16 = new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda47
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return SearchScreenKt.SearchScreen$lambda$0$0((String) obj, (String) obj2);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue16);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function16 = (Function2) objRememberedValue16;
                        } else {
                            function16 = function5;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1463316607, i3, -1, "com.box.android.search.presentation.ui.SearchScreen (SearchScreen.kt:104)");
                        }
                        i14 = i3;
                        stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                        searchModeState = SearchScreen$lambda$1(stateCollectAsStateWithLifecycle).getSearchModeState();
                        if (searchModeState instanceof FilesSearchReducer.State) {
                            state = (FilesSearchReducer.State) searchModeState;
                        } else {
                            state = null;
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792931007, "CC(remember):SearchScreen.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new SnackbarHostState();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        snackbarHostState = (SnackbarHostState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792926598, "CC(remember):SearchScreen.kt#9igjgp");
                        i15 = i14 & 14;
                        if (i15 == 4) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (z6 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda54
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return SearchScreenKt.SearchScreen$lambda$3$0(store, (String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        Function1 function23 = (Function1) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Unit unit = Unit.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792920930, "CC(remember):SearchScreen.kt#9igjgp");
                        if (i15 == 4) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        searchScreenKt$SearchScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z7 || searchScreenKt$SearchScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            searchScreenKt$SearchScreen$2$1RememberedValue = new SearchScreenKt$SearchScreen$2$1(store, null);
                            composerStartRestartGroup.updateRememberedValue(searchScreenKt$SearchScreen$2$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) searchScreenKt$SearchScreen$2$1RememberedValue, composerStartRestartGroup, 6);
                        strStringResource = StringResources_androidKt.stringResource(R.string.search_generic_error_sub_text, composerStartRestartGroup, 0);
                        Boolean boolValueOf = Boolean.valueOf(SearchScreen$lambda$1(stateCollectAsStateWithLifecycle).getErrorShown());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792915123, "CC(remember):SearchScreen.kt#9igjgp");
                        boolean zChanged3 = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | composerStartRestartGroup.changed(strStringResource);
                        if (i15 == 4) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        z9 = z8 | zChanged3;
                        Object objRememberedValue17 = composerStartRestartGroup.rememberedValue();
                        if (!z9 || objRememberedValue17 == Composer.INSTANCE.getEmpty()) {
                            searchScreenKt$SearchScreen$3$1 = new SearchScreenKt$SearchScreen$3$1(snackbarHostState, strStringResource, store, stateCollectAsStateWithLifecycle, null);
                            composerStartRestartGroup.updateRememberedValue(searchScreenKt$SearchScreen$3$1);
                        } else {
                            searchScreenKt$SearchScreen$3$1 = objRememberedValue17;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) searchScreenKt$SearchScreen$3$1, composerStartRestartGroup, 0);
                        ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume = composerStartRestartGroup.consume(localLifecycleOwner);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        lifecycleScope = LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) objConsume);
                        SearchReducer.SearchRoute route = SearchScreen$lambda$1(r57).getRoute();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792905428, "CC(remember):SearchScreen.kt#9igjgp");
                        boolean zChanged4 = composerStartRestartGroup.changed(r57);
                        if ((i14 & 7168) == 2048) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        boolean z32 = z10 | zChanged4;
                        if ((57344 & i14) == 16384) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        boolean z33 = z32 | z11;
                        if ((458752 & i14) == 131072) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        boolean zChangedInstance = z33 | z12 | composerStartRestartGroup.changedInstance(function8) | composerStartRestartGroup.changed(state) | composerStartRestartGroup.changedInstance(lifecycleScope);
                        if (i15 == 4) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        boolean z34 = zChangedInstance | z13;
                        if ((29360128 & i14) == 8388608) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        z15 = z34 | z14;
                        Object objRememberedValue18 = composerStartRestartGroup.rememberedValue();
                        if (!z15 || objRememberedValue18 == Composer.INSTANCE.getEmpty()) {
                            store2 = store;
                            function17 = function8;
                            function18 = function16;
                            function19 = function15;
                            i16 = i14;
                            state2 = r57;
                            composer3 = composerStartRestartGroup;
                            function20 = function7;
                            function21 = function14;
                            i17 = 0;
                            searchScreenKt$SearchScreen$4$1 = new SearchScreenKt$SearchScreen$4$1(function21, function20, function19, function17, state, lifecycleScope, function18, store2, state2, null);
                            composer3.updateRememberedValue(searchScreenKt$SearchScreen$4$1);
                        } else {
                            store2 = store;
                            searchScreenKt$SearchScreen$4$1 = objRememberedValue18;
                            function17 = function8;
                            i16 = i14;
                            function18 = function16;
                            function19 = function15;
                            state2 = stateCollectAsStateWithLifecycle;
                            composer3 = composerStartRestartGroup;
                            function20 = function7;
                            function21 = function14;
                            i17 = 0;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        EffectsKt.LaunchedEffect(route, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) searchScreenKt$SearchScreen$4$1, composer3, i17);
                        String query = SearchScreen$lambda$1(state2).getQuery();
                        SearchModeState searchModeState2 = SearchScreen$lambda$1(state2).getSearchModeState();
                        SearchReducer.ScreenState screenState = SearchScreen$lambda$1(state2).getScreenState();
                        List<String> recentQueries = SearchScreen$lambda$1(state2).getRecentQueries();
                        List<AiRecentSession> recentAiSessions = SearchScreen$lambda$1(state2).getRecentAiSessions();
                        IdentifiedList<String, SearchItemReducer.State> searchItems = SearchScreen$lambda$1(state2).getSearchItems();
                        totalCount = SearchScreen$lambda$1(state2).getTotalCount();
                        if (totalCount != null) {
                            if (SearchScreen$lambda$1(state2).getOffset() < totalCount.longValue()) {
                                i19 = 1;
                            } else {
                                i19 = i17;
                            }
                            z16 = i19;
                        } else {
                            z16 = i17;
                        }
                        List<SearchMode> enabledTabs = SearchScreen$lambda$1(state2).getEnabledTabs();
                        boolean zIsSelecting = SearchScreen$lambda$1(state2).isSelecting();
                        boolean zIsAiAtSearchEnabled = SearchScreen$lambda$1(state2).isAiAtSearchEnabled();
                        stateSearchScreen$lambda$1 = SearchScreen$lambda$1(state2);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1792853163, "CC(remember):SearchScreen.kt#9igjgp");
                        zChanged = composer3.changed(stateSearchScreen$lambda$1);
                        searchScreenKt$SearchScreen$6$1RememberedValue = composer3.rememberedValue();
                        if (zChanged || searchScreenKt$SearchScreen$6$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            searchScreenKt$SearchScreen$6$1RememberedValue = new SearchScreenKt$SearchScreen$6$1(stateSearchScreen$lambda$1);
                            composer3.updateRememberedValue(searchScreenKt$SearchScreen$6$1RememberedValue);
                        }
                        KFunction kFunction = (KFunction) searchScreenKt$SearchScreen$6$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        stateSearchScreen$lambda$2 = SearchScreen$lambda$1(state2);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1792851691, "CC(remember):SearchScreen.kt#9igjgp");
                        zChanged2 = composer3.changed(stateSearchScreen$lambda$2);
                        searchScreenKt$SearchScreen$7$1RememberedValue = composer3.rememberedValue();
                        if (zChanged2 || searchScreenKt$SearchScreen$7$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            searchScreenKt$SearchScreen$7$1RememberedValue = new SearchScreenKt$SearchScreen$7$1(stateSearchScreen$lambda$2);
                            composer3.updateRememberedValue(searchScreenKt$SearchScreen$7$1RememberedValue);
                        }
                        KFunction kFunction2 = (KFunction) searchScreenKt$SearchScreen$7$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1792800435, "CC(remember):SearchScreen.kt#9igjgp");
                        if (i15 == 4) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        objRememberedValue3 = composer3.rememberedValue();
                        if (z17 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda56
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return SearchScreenKt.SearchScreen$lambda$10$0(store2);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue3);
                        }
                        function0 = (Function0) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        if (SearchScreen$lambda$1(state2).getHasAppliedFilters()) {
                            function22 = function0;
                        } else {
                            function22 = null;
                        }
                        IdentifiedList<String, SearchItemReducer.State> identifiedList = searchItems;
                        Function1 function24 = (Function1) kFunction;
                        Function1 function25 = (Function1) kFunction2;
                        ComposerKt.sourceInformationMarkerStart(composer3, -1792850361, "CC(remember):SearchScreen.kt#9igjgp");
                        if (i15 == 4) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        objRememberedValue4 = composer3.rememberedValue();
                        if (z18 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda57
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return SearchScreenKt.SearchScreen$lambda$12$0(store2);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue4);
                        }
                        Function0 function26 = (Function0) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1792847383, "CC(remember):SearchScreen.kt#9igjgp");
                        if (i15 == 4) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        objRememberedValue5 = composer3.rememberedValue();
                        if (z19 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda58
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return SearchScreenKt.SearchScreen$lambda$13$0(store2);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue5);
                        }
                        Function0 function27 = (Function0) objRememberedValue5;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1792842320, "CC(remember):SearchScreen.kt#9igjgp");
                        if (i15 == 4) {
                            z20 = true;
                        } else {
                            z20 = false;
                        }
                        objRememberedValue6 = composer3.rememberedValue();
                        if (z20 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda59
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return SearchScreenKt.SearchScreen$lambda$14$0(store2, (String) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue6);
                        }
                        Function1 function28 = (Function1) objRememberedValue6;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1792833263, "CC(remember):SearchScreen.kt#9igjgp");
                        i18 = i16;
                        if ((i18 & 896) == 256) {
                            z21 = true;
                        } else {
                            z21 = false;
                        }
                        objRememberedValue7 = composer3.rememberedValue();
                        if (z21 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue7 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda60
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return SearchScreenKt.SearchScreen$lambda$15$0(onDismissSearch);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue7);
                        }
                        Function0 function29 = (Function0) objRememberedValue7;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1792830564, "CC(remember):SearchScreen.kt#9igjgp");
                        boolean zChanged5 = composer3.changed(state2);
                        if (i15 == 4) {
                            z22 = true;
                        } else {
                            z22 = false;
                        }
                        z23 = zChanged5 | z22;
                        objRememberedValue8 = composer3.rememberedValue();
                        if (z23 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue8 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda61
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return SearchScreenKt.SearchScreen$lambda$16$0(store2, state2, (SearchMode) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue8);
                        }
                        Function1 function30 = (Function1) objRememberedValue8;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1792838764, "CC(remember):SearchScreen.kt#9igjgp");
                        boolean zChanged6 = composer3.changed(state2);
                        if (i15 == 4) {
                            z24 = true;
                        } else {
                            z24 = false;
                        }
                        z25 = zChanged6 | z24;
                        objRememberedValue9 = composer3.rememberedValue();
                        if (z25 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue9 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda62
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return SearchScreenKt.SearchScreen$lambda$17$0(store2, state2);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue9);
                        }
                        Function0 function31 = (Function0) objRememberedValue9;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1792823653, "CC(remember):SearchScreen.kt#9igjgp");
                        if (i15 == 4) {
                            z26 = true;
                        } else {
                            z26 = false;
                        }
                        objRememberedValue10 = composer3.rememberedValue();
                        if (z26 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue10 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda63
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return SearchScreenKt.SearchScreen$lambda$18$0(store2, (String) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue10);
                        }
                        Function1 function32 = (Function1) objRememberedValue10;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1792819685, "CC(remember):SearchScreen.kt#9igjgp");
                        if (i15 == 4) {
                            z27 = true;
                        } else {
                            z27 = false;
                        }
                        objRememberedValue11 = composer3.rememberedValue();
                        if (z27 || objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue11 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda48
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return SearchScreenKt.SearchScreen$lambda$19$0(store2, (String) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue11);
                        }
                        Function1 function33 = (Function1) objRememberedValue11;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1792815648, "CC(remember):SearchScreen.kt#9igjgp");
                        if (i15 == 4) {
                            z28 = true;
                        } else {
                            z28 = false;
                        }
                        objRememberedValue12 = composer3.rememberedValue();
                        if (z28 || objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue12 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda49
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return SearchScreenKt.SearchScreen$lambda$20$0(store2, (String) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue12);
                        }
                        Function1 function34 = (Function1) objRememberedValue12;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1792812683, "CC(remember):SearchScreen.kt#9igjgp");
                        if (i15 == 4) {
                            z29 = true;
                        } else {
                            z29 = false;
                        }
                        objRememberedValue13 = composer3.rememberedValue();
                        if (z29 || objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue13 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda50
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return SearchScreenKt.SearchScreen$lambda$21$0(store2);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue13);
                        }
                        Function0 function35 = (Function0) objRememberedValue13;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1792809899, "CC(remember):SearchScreen.kt#9igjgp");
                        if (i15 == 4) {
                            z30 = true;
                        } else {
                            z30 = false;
                        }
                        objRememberedValue14 = composer3.rememberedValue();
                        if (z30 || objRememberedValue14 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue14 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda51
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return SearchScreenKt.SearchScreen$lambda$22$0(store2);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue14);
                        }
                        Function0 function36 = (Function0) objRememberedValue14;
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1792805157, "CC(remember):SearchScreen.kt#9igjgp");
                        z31 = i15 == 4;
                        objRememberedValue15 = composer3.rememberedValue();
                        if (z31 || objRememberedValue15 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue15 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda52
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return SearchScreenKt.SearchScreen$lambda$23$0(store2, (FilesSearchFilters.FilterType) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue15);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Composer composer4 = composer3;
                        SearchScreenContent(query, searchModeState2, screenState, identifiedList, recentQueries, recentAiSessions, z16, snackbarHostState, enabledTabs, zIsSelecting, zIsAiAtSearchEnabled, function24, function25, function26, function27, function23, function28, function29, function30, function31, function32, function33, function34, function35, function36, (Function1) objRememberedValue15, function22, z5, composer4, 12582912, 0, (i18 << 18) & 29360128, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function13 = function19;
                        composer2 = composer4;
                        function9 = function18;
                        function12 = function20;
                        function11 = function17;
                        z4 = z5;
                        function10 = function21;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        function9 = function5;
                        z4 = z2;
                        composer2 = composerStartRestartGroup;
                        function10 = function6;
                        function11 = function8;
                        function12 = function7;
                        function13 = function3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda53
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SearchScreenKt.SearchScreen$lambda$24(store, z4, onDismissSearch, function10, function12, function13, function11, function9, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                function7 = function1;
                i8 = i2 & 32;
                if (i8 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 64;
                if (i10 != 0) {
                    i3 |= 1572864;
                    function8 = function4;
                } else {
                    function8 = function4;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function8)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    }
                }
                i12 = i2 & 128;
                if (i12 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i13 = 8388608;
                    } else {
                        i13 = 4194304;
                    }
                    i3 |= i13;
                }
                if ((i3 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    if (i21 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i4 != 0) {
                        function14 = null;
                    } else {
                        function14 = function6;
                    }
                    if (i6 != 0) {
                        function7 = null;
                    }
                    if (i8 != 0) {
                        function15 = null;
                    } else {
                        function15 = function3;
                    }
                    if (i10 != 0) {
                        function8 = null;
                    }
                    if (i12 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792936852, "CC(remember):SearchScreen.kt#9igjgp");
                        objRememberedValue16 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue16 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue16 = new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda47
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SearchScreenKt.SearchScreen$lambda$0$0((String) obj, (String) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue16);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function16 = (Function2) objRememberedValue16;
                    } else {
                        function16 = function5;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1463316607, i3, -1, "com.box.android.search.presentation.ui.SearchScreen (SearchScreen.kt:104)");
                    }
                    i14 = i3;
                    stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    searchModeState = SearchScreen$lambda$1(stateCollectAsStateWithLifecycle).getSearchModeState();
                    if (searchModeState instanceof FilesSearchReducer.State) {
                        state = (FilesSearchReducer.State) searchModeState;
                    } else {
                        state = null;
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792931007, "CC(remember):SearchScreen.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new SnackbarHostState();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    snackbarHostState = (SnackbarHostState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792926598, "CC(remember):SearchScreen.kt#9igjgp");
                    i15 = i14 & 14;
                    if (i15 == 4) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z6) {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda54
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$3$0(store, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda54
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$3$0(store, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    Function1 function210 = (Function1) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Unit unit2 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792920930, "CC(remember):SearchScreen.kt#9igjgp");
                    if (i15 == 4) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    searchScreenKt$SearchScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z7) {
                        searchScreenKt$SearchScreen$2$1RememberedValue = new SearchScreenKt$SearchScreen$2$1(store, null);
                        composerStartRestartGroup.updateRememberedValue(searchScreenKt$SearchScreen$2$1RememberedValue);
                    } else {
                        searchScreenKt$SearchScreen$2$1RememberedValue = new SearchScreenKt$SearchScreen$2$1(store, null);
                        composerStartRestartGroup.updateRememberedValue(searchScreenKt$SearchScreen$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) searchScreenKt$SearchScreen$2$1RememberedValue, composerStartRestartGroup, 6);
                    strStringResource = StringResources_androidKt.stringResource(R.string.search_generic_error_sub_text, composerStartRestartGroup, 0);
                    Boolean boolValueOf2 = Boolean.valueOf(SearchScreen$lambda$1(stateCollectAsStateWithLifecycle).getErrorShown());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792915123, "CC(remember):SearchScreen.kt#9igjgp");
                    boolean zChanged7 = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | composerStartRestartGroup.changed(strStringResource);
                    if (i15 == 4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    z9 = z8 | zChanged7;
                    Object objRememberedValue19 = composerStartRestartGroup.rememberedValue();
                    if (z9) {
                        searchScreenKt$SearchScreen$3$1 = new SearchScreenKt$SearchScreen$3$1(snackbarHostState, strStringResource, store, stateCollectAsStateWithLifecycle, null);
                        composerStartRestartGroup.updateRememberedValue(searchScreenKt$SearchScreen$3$1);
                    } else {
                        searchScreenKt$SearchScreen$3$1 = new SearchScreenKt$SearchScreen$3$1(snackbarHostState, strStringResource, store, stateCollectAsStateWithLifecycle, null);
                        composerStartRestartGroup.updateRememberedValue(searchScreenKt$SearchScreen$3$1);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(boolValueOf2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) searchScreenKt$SearchScreen$3$1, composerStartRestartGroup, 0);
                    ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner2 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(localLifecycleOwner2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    lifecycleScope = LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) objConsume2);
                    SearchReducer.SearchRoute route2 = SearchScreen$lambda$1(r57).getRoute();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792905428, "CC(remember):SearchScreen.kt#9igjgp");
                    boolean zChanged8 = composerStartRestartGroup.changed(r57);
                    if ((i14 & 7168) == 2048) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    boolean z35 = z10 | zChanged8;
                    if ((57344 & i14) == 16384) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    boolean z36 = z35 | z11;
                    if ((458752 & i14) == 131072) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    boolean zChangedInstance2 = z36 | z12 | composerStartRestartGroup.changedInstance(function8) | composerStartRestartGroup.changed(state) | composerStartRestartGroup.changedInstance(lifecycleScope);
                    if (i15 == 4) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    boolean z37 = zChangedInstance2 | z13;
                    if ((29360128 & i14) == 8388608) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    z15 = z37 | z14;
                    Object objRememberedValue110 = composerStartRestartGroup.rememberedValue();
                    if (z15) {
                        store2 = store;
                        function17 = function8;
                        function18 = function16;
                        function19 = function15;
                        i16 = i14;
                        state2 = r57;
                        composer3 = composerStartRestartGroup;
                        function20 = function7;
                        function21 = function14;
                        i17 = 0;
                        searchScreenKt$SearchScreen$4$1 = new SearchScreenKt$SearchScreen$4$1(function21, function20, function19, function17, state, lifecycleScope, function18, store2, state2, null);
                        composer3.updateRememberedValue(searchScreenKt$SearchScreen$4$1);
                    } else {
                        store2 = store;
                        function17 = function8;
                        function18 = function16;
                        function19 = function15;
                        i16 = i14;
                        state2 = r57;
                        composer3 = composerStartRestartGroup;
                        function20 = function7;
                        function21 = function14;
                        i17 = 0;
                        searchScreenKt$SearchScreen$4$1 = new SearchScreenKt$SearchScreen$4$1(function21, function20, function19, function17, state, lifecycleScope, function18, store2, state2, null);
                        composer3.updateRememberedValue(searchScreenKt$SearchScreen$4$1);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    EffectsKt.LaunchedEffect(route2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) searchScreenKt$SearchScreen$4$1, composer3, i17);
                    String query2 = SearchScreen$lambda$1(state2).getQuery();
                    SearchModeState searchModeState3 = SearchScreen$lambda$1(state2).getSearchModeState();
                    SearchReducer.ScreenState screenState2 = SearchScreen$lambda$1(state2).getScreenState();
                    List<String> recentQueries2 = SearchScreen$lambda$1(state2).getRecentQueries();
                    List<AiRecentSession> recentAiSessions2 = SearchScreen$lambda$1(state2).getRecentAiSessions();
                    IdentifiedList<String, SearchItemReducer.State> searchItems2 = SearchScreen$lambda$1(state2).getSearchItems();
                    totalCount = SearchScreen$lambda$1(state2).getTotalCount();
                    if (totalCount != null) {
                        if (SearchScreen$lambda$1(state2).getOffset() < totalCount.longValue()) {
                            i19 = 1;
                        } else {
                            i19 = i17;
                        }
                        z16 = i19;
                    } else {
                        z16 = i17;
                    }
                    List<SearchMode> enabledTabs2 = SearchScreen$lambda$1(state2).getEnabledTabs();
                    boolean zIsSelecting2 = SearchScreen$lambda$1(state2).isSelecting();
                    boolean zIsAiAtSearchEnabled2 = SearchScreen$lambda$1(state2).isAiAtSearchEnabled();
                    stateSearchScreen$lambda$1 = SearchScreen$lambda$1(state2);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792853163, "CC(remember):SearchScreen.kt#9igjgp");
                    zChanged = composer3.changed(stateSearchScreen$lambda$1);
                    searchScreenKt$SearchScreen$6$1RememberedValue = composer3.rememberedValue();
                    if (zChanged) {
                        searchScreenKt$SearchScreen$6$1RememberedValue = new SearchScreenKt$SearchScreen$6$1(stateSearchScreen$lambda$1);
                        composer3.updateRememberedValue(searchScreenKt$SearchScreen$6$1RememberedValue);
                    } else {
                        searchScreenKt$SearchScreen$6$1RememberedValue = new SearchScreenKt$SearchScreen$6$1(stateSearchScreen$lambda$1);
                        composer3.updateRememberedValue(searchScreenKt$SearchScreen$6$1RememberedValue);
                    }
                    KFunction kFunction3 = (KFunction) searchScreenKt$SearchScreen$6$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    stateSearchScreen$lambda$2 = SearchScreen$lambda$1(state2);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792851691, "CC(remember):SearchScreen.kt#9igjgp");
                    zChanged2 = composer3.changed(stateSearchScreen$lambda$2);
                    searchScreenKt$SearchScreen$7$1RememberedValue = composer3.rememberedValue();
                    if (zChanged2) {
                        searchScreenKt$SearchScreen$7$1RememberedValue = new SearchScreenKt$SearchScreen$7$1(stateSearchScreen$lambda$2);
                        composer3.updateRememberedValue(searchScreenKt$SearchScreen$7$1RememberedValue);
                    } else {
                        searchScreenKt$SearchScreen$7$1RememberedValue = new SearchScreenKt$SearchScreen$7$1(stateSearchScreen$lambda$2);
                        composer3.updateRememberedValue(searchScreenKt$SearchScreen$7$1RememberedValue);
                    }
                    KFunction kFunction4 = (KFunction) searchScreenKt$SearchScreen$7$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792800435, "CC(remember):SearchScreen.kt#9igjgp");
                    if (i15 == 4) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    objRememberedValue3 = composer3.rememberedValue();
                    if (z17) {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda56
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$10$0(store2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda56
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$10$0(store2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue3);
                    }
                    function0 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    if (SearchScreen$lambda$1(state2).getHasAppliedFilters()) {
                        function22 = function0;
                    } else {
                        function22 = null;
                    }
                    IdentifiedList<String, SearchItemReducer.State> identifiedList2 = searchItems2;
                    Function1 function211 = (Function1) kFunction3;
                    Function1 function212 = (Function1) kFunction4;
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792850361, "CC(remember):SearchScreen.kt#9igjgp");
                    if (i15 == 4) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    objRememberedValue4 = composer3.rememberedValue();
                    if (z18) {
                        objRememberedValue4 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda57
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$12$0(store2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda57
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$12$0(store2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue4);
                    }
                    Function0 function213 = (Function0) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792847383, "CC(remember):SearchScreen.kt#9igjgp");
                    if (i15 == 4) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    objRememberedValue5 = composer3.rememberedValue();
                    if (z19) {
                        objRememberedValue5 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda58
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$13$0(store2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda58
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$13$0(store2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue5);
                    }
                    Function0 function214 = (Function0) objRememberedValue5;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792842320, "CC(remember):SearchScreen.kt#9igjgp");
                    if (i15 == 4) {
                        z20 = true;
                    } else {
                        z20 = false;
                    }
                    objRememberedValue6 = composer3.rememberedValue();
                    if (z20) {
                        objRememberedValue6 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda59
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$14$0(store2, (String) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue6);
                    } else {
                        objRememberedValue6 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda59
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$14$0(store2, (String) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue6);
                    }
                    Function1 function215 = (Function1) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792833263, "CC(remember):SearchScreen.kt#9igjgp");
                    i18 = i16;
                    if ((i18 & 896) == 256) {
                        z21 = true;
                    } else {
                        z21 = false;
                    }
                    objRememberedValue7 = composer3.rememberedValue();
                    if (z21) {
                        objRememberedValue7 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda60
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$15$0(onDismissSearch);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue7);
                    } else {
                        objRememberedValue7 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda60
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$15$0(onDismissSearch);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue7);
                    }
                    Function0 function216 = (Function0) objRememberedValue7;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792830564, "CC(remember):SearchScreen.kt#9igjgp");
                    boolean zChanged9 = composer3.changed(state2);
                    if (i15 == 4) {
                        z22 = true;
                    } else {
                        z22 = false;
                    }
                    z23 = zChanged9 | z22;
                    objRememberedValue8 = composer3.rememberedValue();
                    if (z23) {
                        objRememberedValue8 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda61
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$16$0(store2, state2, (SearchMode) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue8);
                    } else {
                        objRememberedValue8 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda61
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$16$0(store2, state2, (SearchMode) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue8);
                    }
                    Function1 function37 = (Function1) objRememberedValue8;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792838764, "CC(remember):SearchScreen.kt#9igjgp");
                    boolean zChanged10 = composer3.changed(state2);
                    if (i15 == 4) {
                        z24 = true;
                    } else {
                        z24 = false;
                    }
                    z25 = zChanged10 | z24;
                    objRememberedValue9 = composer3.rememberedValue();
                    if (z25) {
                        objRememberedValue9 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda62
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$17$0(store2, state2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue9);
                    } else {
                        objRememberedValue9 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda62
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$17$0(store2, state2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue9);
                    }
                    Function0 function38 = (Function0) objRememberedValue9;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792823653, "CC(remember):SearchScreen.kt#9igjgp");
                    if (i15 == 4) {
                        z26 = true;
                    } else {
                        z26 = false;
                    }
                    objRememberedValue10 = composer3.rememberedValue();
                    if (z26) {
                        objRememberedValue10 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda63
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$18$0(store2, (String) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue10);
                    } else {
                        objRememberedValue10 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda63
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$18$0(store2, (String) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue10);
                    }
                    Function1 function39 = (Function1) objRememberedValue10;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792819685, "CC(remember):SearchScreen.kt#9igjgp");
                    if (i15 == 4) {
                        z27 = true;
                    } else {
                        z27 = false;
                    }
                    objRememberedValue11 = composer3.rememberedValue();
                    if (z27) {
                        objRememberedValue11 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda48
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$19$0(store2, (String) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue11);
                    } else {
                        objRememberedValue11 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda48
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$19$0(store2, (String) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue11);
                    }
                    Function1 function310 = (Function1) objRememberedValue11;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792815648, "CC(remember):SearchScreen.kt#9igjgp");
                    if (i15 == 4) {
                        z28 = true;
                    } else {
                        z28 = false;
                    }
                    objRememberedValue12 = composer3.rememberedValue();
                    if (z28) {
                        objRememberedValue12 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda49
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$20$0(store2, (String) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue12);
                    } else {
                        objRememberedValue12 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda49
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$20$0(store2, (String) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue12);
                    }
                    Function1 function311 = (Function1) objRememberedValue12;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792812683, "CC(remember):SearchScreen.kt#9igjgp");
                    if (i15 == 4) {
                        z29 = true;
                    } else {
                        z29 = false;
                    }
                    objRememberedValue13 = composer3.rememberedValue();
                    if (z29) {
                        objRememberedValue13 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda50
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$21$0(store2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue13);
                    } else {
                        objRememberedValue13 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda50
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$21$0(store2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue13);
                    }
                    Function0 function312 = (Function0) objRememberedValue13;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792809899, "CC(remember):SearchScreen.kt#9igjgp");
                    if (i15 == 4) {
                        z30 = true;
                    } else {
                        z30 = false;
                    }
                    objRememberedValue14 = composer3.rememberedValue();
                    if (z30) {
                        objRememberedValue14 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda51
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$22$0(store2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue14);
                    } else {
                        objRememberedValue14 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda51
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$22$0(store2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue14);
                    }
                    Function0 function313 = (Function0) objRememberedValue14;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792805157, "CC(remember):SearchScreen.kt#9igjgp");
                    if (i15 == 4) {
                    }
                    objRememberedValue15 = composer3.rememberedValue();
                    if (z31) {
                        objRememberedValue15 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda52
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$23$0(store2, (FilesSearchFilters.FilterType) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue15);
                    } else {
                        objRememberedValue15 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda52
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$23$0(store2, (FilesSearchFilters.FilterType) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue15);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Composer composer5 = composer3;
                    SearchScreenContent(query2, searchModeState3, screenState2, identifiedList2, recentQueries2, recentAiSessions2, z16, snackbarHostState, enabledTabs2, zIsSelecting2, zIsAiAtSearchEnabled2, function211, function212, function213, function214, function210, function215, function216, function37, function38, function39, function310, function311, function312, function313, (Function1) objRememberedValue15, function22, z5, composer5, 12582912, 0, (i18 << 18) & 29360128, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function13 = function19;
                    composer2 = composer5;
                    function9 = function18;
                    function12 = function20;
                    function11 = function17;
                    z4 = z5;
                    function10 = function21;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    function9 = function5;
                    z4 = z2;
                    composer2 = composerStartRestartGroup;
                    function10 = function6;
                    function11 = function8;
                    function12 = function7;
                    function13 = function3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda53
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SearchScreenKt.SearchScreen$lambda$24(store, z4, onDismissSearch, function10, function12, function13, function11, function9, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            function6 = function2;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    function7 = function1;
                    if (composerStartRestartGroup.changedInstance(function7)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 64;
                if (i10 != 0) {
                    i3 |= 1572864;
                    function8 = function4;
                } else {
                    function8 = function4;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function8)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    }
                }
                i12 = i2 & 128;
                if (i12 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i13 = 8388608;
                    } else {
                        i13 = 4194304;
                    }
                    i3 |= i13;
                }
                if ((i3 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    if (i21 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i4 != 0) {
                        function14 = null;
                    } else {
                        function14 = function6;
                    }
                    if (i6 != 0) {
                        function7 = null;
                    }
                    if (i8 != 0) {
                        function15 = null;
                    } else {
                        function15 = function3;
                    }
                    if (i10 != 0) {
                        function8 = null;
                    }
                    if (i12 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792936852, "CC(remember):SearchScreen.kt#9igjgp");
                        objRememberedValue16 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue16 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue16 = new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda47
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SearchScreenKt.SearchScreen$lambda$0$0((String) obj, (String) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue16);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function16 = (Function2) objRememberedValue16;
                    } else {
                        function16 = function5;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1463316607, i3, -1, "com.box.android.search.presentation.ui.SearchScreen (SearchScreen.kt:104)");
                    }
                    i14 = i3;
                    stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    searchModeState = SearchScreen$lambda$1(stateCollectAsStateWithLifecycle).getSearchModeState();
                    if (searchModeState instanceof FilesSearchReducer.State) {
                        state = (FilesSearchReducer.State) searchModeState;
                    } else {
                        state = null;
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792931007, "CC(remember):SearchScreen.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new SnackbarHostState();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    snackbarHostState = (SnackbarHostState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792926598, "CC(remember):SearchScreen.kt#9igjgp");
                    i15 = i14 & 14;
                    if (i15 == 4) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z6) {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda54
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$3$0(store, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda54
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$3$0(store, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    Function1 function217 = (Function1) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Unit unit3 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792920930, "CC(remember):SearchScreen.kt#9igjgp");
                    if (i15 == 4) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    searchScreenKt$SearchScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z7) {
                        searchScreenKt$SearchScreen$2$1RememberedValue = new SearchScreenKt$SearchScreen$2$1(store, null);
                        composerStartRestartGroup.updateRememberedValue(searchScreenKt$SearchScreen$2$1RememberedValue);
                    } else {
                        searchScreenKt$SearchScreen$2$1RememberedValue = new SearchScreenKt$SearchScreen$2$1(store, null);
                        composerStartRestartGroup.updateRememberedValue(searchScreenKt$SearchScreen$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) searchScreenKt$SearchScreen$2$1RememberedValue, composerStartRestartGroup, 6);
                    strStringResource = StringResources_androidKt.stringResource(R.string.search_generic_error_sub_text, composerStartRestartGroup, 0);
                    Boolean boolValueOf3 = Boolean.valueOf(SearchScreen$lambda$1(stateCollectAsStateWithLifecycle).getErrorShown());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792915123, "CC(remember):SearchScreen.kt#9igjgp");
                    boolean zChanged11 = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | composerStartRestartGroup.changed(strStringResource);
                    if (i15 == 4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    z9 = z8 | zChanged11;
                    Object objRememberedValue111 = composerStartRestartGroup.rememberedValue();
                    if (z9) {
                        searchScreenKt$SearchScreen$3$1 = new SearchScreenKt$SearchScreen$3$1(snackbarHostState, strStringResource, store, stateCollectAsStateWithLifecycle, null);
                        composerStartRestartGroup.updateRememberedValue(searchScreenKt$SearchScreen$3$1);
                    } else {
                        searchScreenKt$SearchScreen$3$1 = new SearchScreenKt$SearchScreen$3$1(snackbarHostState, strStringResource, store, stateCollectAsStateWithLifecycle, null);
                        composerStartRestartGroup.updateRememberedValue(searchScreenKt$SearchScreen$3$1);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(boolValueOf3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) searchScreenKt$SearchScreen$3$1, composerStartRestartGroup, 0);
                    ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner3 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume3 = composerStartRestartGroup.consume(localLifecycleOwner3);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    lifecycleScope = LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) objConsume3);
                    SearchReducer.SearchRoute route3 = SearchScreen$lambda$1(r57).getRoute();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792905428, "CC(remember):SearchScreen.kt#9igjgp");
                    boolean zChanged12 = composerStartRestartGroup.changed(r57);
                    if ((i14 & 7168) == 2048) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    boolean z38 = z10 | zChanged12;
                    if ((57344 & i14) == 16384) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    boolean z39 = z38 | z11;
                    if ((458752 & i14) == 131072) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    boolean zChangedInstance3 = z39 | z12 | composerStartRestartGroup.changedInstance(function8) | composerStartRestartGroup.changed(state) | composerStartRestartGroup.changedInstance(lifecycleScope);
                    if (i15 == 4) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    boolean z310 = zChangedInstance3 | z13;
                    if ((29360128 & i14) == 8388608) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    z15 = z310 | z14;
                    Object objRememberedValue112 = composerStartRestartGroup.rememberedValue();
                    if (z15) {
                        store2 = store;
                        function17 = function8;
                        function18 = function16;
                        function19 = function15;
                        i16 = i14;
                        state2 = r57;
                        composer3 = composerStartRestartGroup;
                        function20 = function7;
                        function21 = function14;
                        i17 = 0;
                        searchScreenKt$SearchScreen$4$1 = new SearchScreenKt$SearchScreen$4$1(function21, function20, function19, function17, state, lifecycleScope, function18, store2, state2, null);
                        composer3.updateRememberedValue(searchScreenKt$SearchScreen$4$1);
                    } else {
                        store2 = store;
                        function17 = function8;
                        function18 = function16;
                        function19 = function15;
                        i16 = i14;
                        state2 = r57;
                        composer3 = composerStartRestartGroup;
                        function20 = function7;
                        function21 = function14;
                        i17 = 0;
                        searchScreenKt$SearchScreen$4$1 = new SearchScreenKt$SearchScreen$4$1(function21, function20, function19, function17, state, lifecycleScope, function18, store2, state2, null);
                        composer3.updateRememberedValue(searchScreenKt$SearchScreen$4$1);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    EffectsKt.LaunchedEffect(route3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) searchScreenKt$SearchScreen$4$1, composer3, i17);
                    String query3 = SearchScreen$lambda$1(state2).getQuery();
                    SearchModeState searchModeState4 = SearchScreen$lambda$1(state2).getSearchModeState();
                    SearchReducer.ScreenState screenState3 = SearchScreen$lambda$1(state2).getScreenState();
                    List<String> recentQueries3 = SearchScreen$lambda$1(state2).getRecentQueries();
                    List<AiRecentSession> recentAiSessions3 = SearchScreen$lambda$1(state2).getRecentAiSessions();
                    IdentifiedList<String, SearchItemReducer.State> searchItems3 = SearchScreen$lambda$1(state2).getSearchItems();
                    totalCount = SearchScreen$lambda$1(state2).getTotalCount();
                    if (totalCount != null) {
                        if (SearchScreen$lambda$1(state2).getOffset() < totalCount.longValue()) {
                            i19 = 1;
                        } else {
                            i19 = i17;
                        }
                        z16 = i19;
                    } else {
                        z16 = i17;
                    }
                    List<SearchMode> enabledTabs3 = SearchScreen$lambda$1(state2).getEnabledTabs();
                    boolean zIsSelecting3 = SearchScreen$lambda$1(state2).isSelecting();
                    boolean zIsAiAtSearchEnabled3 = SearchScreen$lambda$1(state2).isAiAtSearchEnabled();
                    stateSearchScreen$lambda$1 = SearchScreen$lambda$1(state2);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792853163, "CC(remember):SearchScreen.kt#9igjgp");
                    zChanged = composer3.changed(stateSearchScreen$lambda$1);
                    searchScreenKt$SearchScreen$6$1RememberedValue = composer3.rememberedValue();
                    if (zChanged) {
                        searchScreenKt$SearchScreen$6$1RememberedValue = new SearchScreenKt$SearchScreen$6$1(stateSearchScreen$lambda$1);
                        composer3.updateRememberedValue(searchScreenKt$SearchScreen$6$1RememberedValue);
                    } else {
                        searchScreenKt$SearchScreen$6$1RememberedValue = new SearchScreenKt$SearchScreen$6$1(stateSearchScreen$lambda$1);
                        composer3.updateRememberedValue(searchScreenKt$SearchScreen$6$1RememberedValue);
                    }
                    KFunction kFunction5 = (KFunction) searchScreenKt$SearchScreen$6$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    stateSearchScreen$lambda$2 = SearchScreen$lambda$1(state2);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792851691, "CC(remember):SearchScreen.kt#9igjgp");
                    zChanged2 = composer3.changed(stateSearchScreen$lambda$2);
                    searchScreenKt$SearchScreen$7$1RememberedValue = composer3.rememberedValue();
                    if (zChanged2) {
                        searchScreenKt$SearchScreen$7$1RememberedValue = new SearchScreenKt$SearchScreen$7$1(stateSearchScreen$lambda$2);
                        composer3.updateRememberedValue(searchScreenKt$SearchScreen$7$1RememberedValue);
                    } else {
                        searchScreenKt$SearchScreen$7$1RememberedValue = new SearchScreenKt$SearchScreen$7$1(stateSearchScreen$lambda$2);
                        composer3.updateRememberedValue(searchScreenKt$SearchScreen$7$1RememberedValue);
                    }
                    KFunction kFunction6 = (KFunction) searchScreenKt$SearchScreen$7$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792800435, "CC(remember):SearchScreen.kt#9igjgp");
                    if (i15 == 4) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    objRememberedValue3 = composer3.rememberedValue();
                    if (z17) {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda56
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$10$0(store2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda56
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$10$0(store2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue3);
                    }
                    function0 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    if (SearchScreen$lambda$1(state2).getHasAppliedFilters()) {
                        function22 = function0;
                    } else {
                        function22 = null;
                    }
                    IdentifiedList<String, SearchItemReducer.State> identifiedList3 = searchItems3;
                    Function1 function218 = (Function1) kFunction5;
                    Function1 function219 = (Function1) kFunction6;
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792850361, "CC(remember):SearchScreen.kt#9igjgp");
                    if (i15 == 4) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    objRememberedValue4 = composer3.rememberedValue();
                    if (z18) {
                        objRememberedValue4 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda57
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$12$0(store2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda57
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$12$0(store2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue4);
                    }
                    Function0 function2110 = (Function0) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792847383, "CC(remember):SearchScreen.kt#9igjgp");
                    if (i15 == 4) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    objRememberedValue5 = composer3.rememberedValue();
                    if (z19) {
                        objRememberedValue5 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda58
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$13$0(store2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda58
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$13$0(store2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue5);
                    }
                    Function0 function2111 = (Function0) objRememberedValue5;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792842320, "CC(remember):SearchScreen.kt#9igjgp");
                    if (i15 == 4) {
                        z20 = true;
                    } else {
                        z20 = false;
                    }
                    objRememberedValue6 = composer3.rememberedValue();
                    if (z20) {
                        objRememberedValue6 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda59
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$14$0(store2, (String) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue6);
                    } else {
                        objRememberedValue6 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda59
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$14$0(store2, (String) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue6);
                    }
                    Function1 function2112 = (Function1) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792833263, "CC(remember):SearchScreen.kt#9igjgp");
                    i18 = i16;
                    if ((i18 & 896) == 256) {
                        z21 = true;
                    } else {
                        z21 = false;
                    }
                    objRememberedValue7 = composer3.rememberedValue();
                    if (z21) {
                        objRememberedValue7 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda60
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$15$0(onDismissSearch);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue7);
                    } else {
                        objRememberedValue7 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda60
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$15$0(onDismissSearch);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue7);
                    }
                    Function0 function2113 = (Function0) objRememberedValue7;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792830564, "CC(remember):SearchScreen.kt#9igjgp");
                    boolean zChanged13 = composer3.changed(state2);
                    if (i15 == 4) {
                        z22 = true;
                    } else {
                        z22 = false;
                    }
                    z23 = zChanged13 | z22;
                    objRememberedValue8 = composer3.rememberedValue();
                    if (z23) {
                        objRememberedValue8 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda61
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$16$0(store2, state2, (SearchMode) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue8);
                    } else {
                        objRememberedValue8 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda61
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$16$0(store2, state2, (SearchMode) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue8);
                    }
                    Function1 function314 = (Function1) objRememberedValue8;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792838764, "CC(remember):SearchScreen.kt#9igjgp");
                    boolean zChanged14 = composer3.changed(state2);
                    if (i15 == 4) {
                        z24 = true;
                    } else {
                        z24 = false;
                    }
                    z25 = zChanged14 | z24;
                    objRememberedValue9 = composer3.rememberedValue();
                    if (z25) {
                        objRememberedValue9 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda62
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$17$0(store2, state2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue9);
                    } else {
                        objRememberedValue9 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda62
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$17$0(store2, state2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue9);
                    }
                    Function0 function315 = (Function0) objRememberedValue9;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792823653, "CC(remember):SearchScreen.kt#9igjgp");
                    if (i15 == 4) {
                        z26 = true;
                    } else {
                        z26 = false;
                    }
                    objRememberedValue10 = composer3.rememberedValue();
                    if (z26) {
                        objRememberedValue10 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda63
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$18$0(store2, (String) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue10);
                    } else {
                        objRememberedValue10 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda63
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$18$0(store2, (String) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue10);
                    }
                    Function1 function316 = (Function1) objRememberedValue10;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792819685, "CC(remember):SearchScreen.kt#9igjgp");
                    if (i15 == 4) {
                        z27 = true;
                    } else {
                        z27 = false;
                    }
                    objRememberedValue11 = composer3.rememberedValue();
                    if (z27) {
                        objRememberedValue11 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda48
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$19$0(store2, (String) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue11);
                    } else {
                        objRememberedValue11 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda48
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$19$0(store2, (String) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue11);
                    }
                    Function1 function317 = (Function1) objRememberedValue11;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792815648, "CC(remember):SearchScreen.kt#9igjgp");
                    if (i15 == 4) {
                        z28 = true;
                    } else {
                        z28 = false;
                    }
                    objRememberedValue12 = composer3.rememberedValue();
                    if (z28) {
                        objRememberedValue12 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda49
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$20$0(store2, (String) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue12);
                    } else {
                        objRememberedValue12 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda49
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$20$0(store2, (String) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue12);
                    }
                    Function1 function318 = (Function1) objRememberedValue12;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792812683, "CC(remember):SearchScreen.kt#9igjgp");
                    if (i15 == 4) {
                        z29 = true;
                    } else {
                        z29 = false;
                    }
                    objRememberedValue13 = composer3.rememberedValue();
                    if (z29) {
                        objRememberedValue13 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda50
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$21$0(store2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue13);
                    } else {
                        objRememberedValue13 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda50
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$21$0(store2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue13);
                    }
                    Function0 function319 = (Function0) objRememberedValue13;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792809899, "CC(remember):SearchScreen.kt#9igjgp");
                    if (i15 == 4) {
                        z30 = true;
                    } else {
                        z30 = false;
                    }
                    objRememberedValue14 = composer3.rememberedValue();
                    if (z30) {
                        objRememberedValue14 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda51
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$22$0(store2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue14);
                    } else {
                        objRememberedValue14 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda51
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$22$0(store2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue14);
                    }
                    Function0 function3110 = (Function0) objRememberedValue14;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792805157, "CC(remember):SearchScreen.kt#9igjgp");
                    if (i15 == 4) {
                    }
                    objRememberedValue15 = composer3.rememberedValue();
                    if (z31) {
                        objRememberedValue15 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda52
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$23$0(store2, (FilesSearchFilters.FilterType) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue15);
                    } else {
                        objRememberedValue15 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda52
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$23$0(store2, (FilesSearchFilters.FilterType) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue15);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Composer composer6 = composer3;
                    SearchScreenContent(query3, searchModeState4, screenState3, identifiedList3, recentQueries3, recentAiSessions3, z16, snackbarHostState, enabledTabs3, zIsSelecting3, zIsAiAtSearchEnabled3, function218, function219, function2110, function2111, function217, function2112, function2113, function314, function315, function316, function317, function318, function319, function3110, (Function1) objRememberedValue15, function22, z5, composer6, 12582912, 0, (i18 << 18) & 29360128, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function13 = function19;
                    composer2 = composer6;
                    function9 = function18;
                    function12 = function20;
                    function11 = function17;
                    z4 = z5;
                    function10 = function21;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    function9 = function5;
                    z4 = z2;
                    composer2 = composerStartRestartGroup;
                    function10 = function6;
                    function11 = function8;
                    function12 = function7;
                    function13 = function3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda53
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SearchScreenKt.SearchScreen$lambda$24(store, z4, onDismissSearch, function10, function12, function13, function11, function9, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            function7 = function1;
            i8 = i2 & 32;
            if (i8 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i3 |= i9;
            }
            i10 = i2 & 64;
            if (i10 != 0) {
                i3 |= 1572864;
                function8 = function4;
            } else {
                function8 = function4;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function8)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
            }
            i12 = i2 & 128;
            if (i12 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i13 = 8388608;
                } else {
                    i13 = 4194304;
                }
                i3 |= i13;
            }
            if ((i3 & 4793491) != 4793490) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                if (i21 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (i4 != 0) {
                    function14 = null;
                } else {
                    function14 = function6;
                }
                if (i6 != 0) {
                    function7 = null;
                }
                if (i8 != 0) {
                    function15 = null;
                } else {
                    function15 = function3;
                }
                if (i10 != 0) {
                    function8 = null;
                }
                if (i12 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792936852, "CC(remember):SearchScreen.kt#9igjgp");
                    objRememberedValue16 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue16 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue16 = new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda47
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SearchScreenKt.SearchScreen$lambda$0$0((String) obj, (String) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue16);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function16 = (Function2) objRememberedValue16;
                } else {
                    function16 = function5;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1463316607, i3, -1, "com.box.android.search.presentation.ui.SearchScreen (SearchScreen.kt:104)");
                }
                i14 = i3;
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                searchModeState = SearchScreen$lambda$1(stateCollectAsStateWithLifecycle).getSearchModeState();
                if (searchModeState instanceof FilesSearchReducer.State) {
                    state = (FilesSearchReducer.State) searchModeState;
                } else {
                    state = null;
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792931007, "CC(remember):SearchScreen.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new SnackbarHostState();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                snackbarHostState = (SnackbarHostState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792926598, "CC(remember):SearchScreen.kt#9igjgp");
                i15 = i14 & 14;
                if (i15 == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z6) {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda54
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$3$0(store, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda54
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$3$0(store, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Function1 function2114 = (Function1) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Unit unit4 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792920930, "CC(remember):SearchScreen.kt#9igjgp");
                if (i15 == 4) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                searchScreenKt$SearchScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (z7) {
                    searchScreenKt$SearchScreen$2$1RememberedValue = new SearchScreenKt$SearchScreen$2$1(store, null);
                    composerStartRestartGroup.updateRememberedValue(searchScreenKt$SearchScreen$2$1RememberedValue);
                } else {
                    searchScreenKt$SearchScreen$2$1RememberedValue = new SearchScreenKt$SearchScreen$2$1(store, null);
                    composerStartRestartGroup.updateRememberedValue(searchScreenKt$SearchScreen$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) searchScreenKt$SearchScreen$2$1RememberedValue, composerStartRestartGroup, 6);
                strStringResource = StringResources_androidKt.stringResource(R.string.search_generic_error_sub_text, composerStartRestartGroup, 0);
                Boolean boolValueOf4 = Boolean.valueOf(SearchScreen$lambda$1(stateCollectAsStateWithLifecycle).getErrorShown());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792915123, "CC(remember):SearchScreen.kt#9igjgp");
                boolean zChanged15 = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | composerStartRestartGroup.changed(strStringResource);
                if (i15 == 4) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                z9 = z8 | zChanged15;
                Object objRememberedValue113 = composerStartRestartGroup.rememberedValue();
                if (z9) {
                    searchScreenKt$SearchScreen$3$1 = new SearchScreenKt$SearchScreen$3$1(snackbarHostState, strStringResource, store, stateCollectAsStateWithLifecycle, null);
                    composerStartRestartGroup.updateRememberedValue(searchScreenKt$SearchScreen$3$1);
                } else {
                    searchScreenKt$SearchScreen$3$1 = new SearchScreenKt$SearchScreen$3$1(snackbarHostState, strStringResource, store, stateCollectAsStateWithLifecycle, null);
                    composerStartRestartGroup.updateRememberedValue(searchScreenKt$SearchScreen$3$1);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) searchScreenKt$SearchScreen$3$1, composerStartRestartGroup, 0);
                ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner4 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume4 = composerStartRestartGroup.consume(localLifecycleOwner4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                lifecycleScope = LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) objConsume4);
                SearchReducer.SearchRoute route4 = SearchScreen$lambda$1(r57).getRoute();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792905428, "CC(remember):SearchScreen.kt#9igjgp");
                boolean zChanged16 = composerStartRestartGroup.changed(r57);
                if ((i14 & 7168) == 2048) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                boolean z311 = z10 | zChanged16;
                if ((57344 & i14) == 16384) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                boolean z312 = z311 | z11;
                if ((458752 & i14) == 131072) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                boolean zChangedInstance4 = z312 | z12 | composerStartRestartGroup.changedInstance(function8) | composerStartRestartGroup.changed(state) | composerStartRestartGroup.changedInstance(lifecycleScope);
                if (i15 == 4) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                boolean z313 = zChangedInstance4 | z13;
                if ((29360128 & i14) == 8388608) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                z15 = z313 | z14;
                Object objRememberedValue114 = composerStartRestartGroup.rememberedValue();
                if (z15) {
                    store2 = store;
                    function17 = function8;
                    function18 = function16;
                    function19 = function15;
                    i16 = i14;
                    state2 = r57;
                    composer3 = composerStartRestartGroup;
                    function20 = function7;
                    function21 = function14;
                    i17 = 0;
                    searchScreenKt$SearchScreen$4$1 = new SearchScreenKt$SearchScreen$4$1(function21, function20, function19, function17, state, lifecycleScope, function18, store2, state2, null);
                    composer3.updateRememberedValue(searchScreenKt$SearchScreen$4$1);
                } else {
                    store2 = store;
                    function17 = function8;
                    function18 = function16;
                    function19 = function15;
                    i16 = i14;
                    state2 = r57;
                    composer3 = composerStartRestartGroup;
                    function20 = function7;
                    function21 = function14;
                    i17 = 0;
                    searchScreenKt$SearchScreen$4$1 = new SearchScreenKt$SearchScreen$4$1(function21, function20, function19, function17, state, lifecycleScope, function18, store2, state2, null);
                    composer3.updateRememberedValue(searchScreenKt$SearchScreen$4$1);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                EffectsKt.LaunchedEffect(route4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) searchScreenKt$SearchScreen$4$1, composer3, i17);
                String query4 = SearchScreen$lambda$1(state2).getQuery();
                SearchModeState searchModeState5 = SearchScreen$lambda$1(state2).getSearchModeState();
                SearchReducer.ScreenState screenState4 = SearchScreen$lambda$1(state2).getScreenState();
                List<String> recentQueries4 = SearchScreen$lambda$1(state2).getRecentQueries();
                List<AiRecentSession> recentAiSessions4 = SearchScreen$lambda$1(state2).getRecentAiSessions();
                IdentifiedList<String, SearchItemReducer.State> searchItems4 = SearchScreen$lambda$1(state2).getSearchItems();
                totalCount = SearchScreen$lambda$1(state2).getTotalCount();
                if (totalCount != null) {
                    if (SearchScreen$lambda$1(state2).getOffset() < totalCount.longValue()) {
                        i19 = 1;
                    } else {
                        i19 = i17;
                    }
                    z16 = i19;
                } else {
                    z16 = i17;
                }
                List<SearchMode> enabledTabs4 = SearchScreen$lambda$1(state2).getEnabledTabs();
                boolean zIsSelecting4 = SearchScreen$lambda$1(state2).isSelecting();
                boolean zIsAiAtSearchEnabled4 = SearchScreen$lambda$1(state2).isAiAtSearchEnabled();
                stateSearchScreen$lambda$1 = SearchScreen$lambda$1(state2);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792853163, "CC(remember):SearchScreen.kt#9igjgp");
                zChanged = composer3.changed(stateSearchScreen$lambda$1);
                searchScreenKt$SearchScreen$6$1RememberedValue = composer3.rememberedValue();
                if (zChanged) {
                    searchScreenKt$SearchScreen$6$1RememberedValue = new SearchScreenKt$SearchScreen$6$1(stateSearchScreen$lambda$1);
                    composer3.updateRememberedValue(searchScreenKt$SearchScreen$6$1RememberedValue);
                } else {
                    searchScreenKt$SearchScreen$6$1RememberedValue = new SearchScreenKt$SearchScreen$6$1(stateSearchScreen$lambda$1);
                    composer3.updateRememberedValue(searchScreenKt$SearchScreen$6$1RememberedValue);
                }
                KFunction kFunction7 = (KFunction) searchScreenKt$SearchScreen$6$1RememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                stateSearchScreen$lambda$2 = SearchScreen$lambda$1(state2);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792851691, "CC(remember):SearchScreen.kt#9igjgp");
                zChanged2 = composer3.changed(stateSearchScreen$lambda$2);
                searchScreenKt$SearchScreen$7$1RememberedValue = composer3.rememberedValue();
                if (zChanged2) {
                    searchScreenKt$SearchScreen$7$1RememberedValue = new SearchScreenKt$SearchScreen$7$1(stateSearchScreen$lambda$2);
                    composer3.updateRememberedValue(searchScreenKt$SearchScreen$7$1RememberedValue);
                } else {
                    searchScreenKt$SearchScreen$7$1RememberedValue = new SearchScreenKt$SearchScreen$7$1(stateSearchScreen$lambda$2);
                    composer3.updateRememberedValue(searchScreenKt$SearchScreen$7$1RememberedValue);
                }
                KFunction kFunction8 = (KFunction) searchScreenKt$SearchScreen$7$1RememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792800435, "CC(remember):SearchScreen.kt#9igjgp");
                if (i15 == 4) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                objRememberedValue3 = composer3.rememberedValue();
                if (z17) {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda56
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$10$0(store2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda56
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$10$0(store2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue3);
                }
                function0 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                if (SearchScreen$lambda$1(state2).getHasAppliedFilters()) {
                    function22 = function0;
                } else {
                    function22 = null;
                }
                IdentifiedList<String, SearchItemReducer.State> identifiedList4 = searchItems4;
                Function1 function2115 = (Function1) kFunction7;
                Function1 function2116 = (Function1) kFunction8;
                ComposerKt.sourceInformationMarkerStart(composer3, -1792850361, "CC(remember):SearchScreen.kt#9igjgp");
                if (i15 == 4) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                objRememberedValue4 = composer3.rememberedValue();
                if (z18) {
                    objRememberedValue4 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda57
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$12$0(store2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda57
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$12$0(store2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue4);
                }
                Function0 function2117 = (Function0) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792847383, "CC(remember):SearchScreen.kt#9igjgp");
                if (i15 == 4) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                objRememberedValue5 = composer3.rememberedValue();
                if (z19) {
                    objRememberedValue5 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda58
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$13$0(store2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda58
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$13$0(store2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue5);
                }
                Function0 function2118 = (Function0) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792842320, "CC(remember):SearchScreen.kt#9igjgp");
                if (i15 == 4) {
                    z20 = true;
                } else {
                    z20 = false;
                }
                objRememberedValue6 = composer3.rememberedValue();
                if (z20) {
                    objRememberedValue6 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda59
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$14$0(store2, (String) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda59
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$14$0(store2, (String) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue6);
                }
                Function1 function2119 = (Function1) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792833263, "CC(remember):SearchScreen.kt#9igjgp");
                i18 = i16;
                if ((i18 & 896) == 256) {
                    z21 = true;
                } else {
                    z21 = false;
                }
                objRememberedValue7 = composer3.rememberedValue();
                if (z21) {
                    objRememberedValue7 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda60
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$15$0(onDismissSearch);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue7);
                } else {
                    objRememberedValue7 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda60
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$15$0(onDismissSearch);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue7);
                }
                Function0 function21110 = (Function0) objRememberedValue7;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792830564, "CC(remember):SearchScreen.kt#9igjgp");
                boolean zChanged17 = composer3.changed(state2);
                if (i15 == 4) {
                    z22 = true;
                } else {
                    z22 = false;
                }
                z23 = zChanged17 | z22;
                objRememberedValue8 = composer3.rememberedValue();
                if (z23) {
                    objRememberedValue8 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda61
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$16$0(store2, state2, (SearchMode) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue8);
                } else {
                    objRememberedValue8 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda61
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$16$0(store2, state2, (SearchMode) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue8);
                }
                Function1 function3111 = (Function1) objRememberedValue8;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792838764, "CC(remember):SearchScreen.kt#9igjgp");
                boolean zChanged18 = composer3.changed(state2);
                if (i15 == 4) {
                    z24 = true;
                } else {
                    z24 = false;
                }
                z25 = zChanged18 | z24;
                objRememberedValue9 = composer3.rememberedValue();
                if (z25) {
                    objRememberedValue9 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda62
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$17$0(store2, state2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue9);
                } else {
                    objRememberedValue9 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda62
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$17$0(store2, state2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue9);
                }
                Function0 function3112 = (Function0) objRememberedValue9;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792823653, "CC(remember):SearchScreen.kt#9igjgp");
                if (i15 == 4) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                objRememberedValue10 = composer3.rememberedValue();
                if (z26) {
                    objRememberedValue10 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda63
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$18$0(store2, (String) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue10);
                } else {
                    objRememberedValue10 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda63
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$18$0(store2, (String) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue10);
                }
                Function1 function3113 = (Function1) objRememberedValue10;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792819685, "CC(remember):SearchScreen.kt#9igjgp");
                if (i15 == 4) {
                    z27 = true;
                } else {
                    z27 = false;
                }
                objRememberedValue11 = composer3.rememberedValue();
                if (z27) {
                    objRememberedValue11 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda48
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$19$0(store2, (String) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue11);
                } else {
                    objRememberedValue11 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda48
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$19$0(store2, (String) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue11);
                }
                Function1 function3114 = (Function1) objRememberedValue11;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792815648, "CC(remember):SearchScreen.kt#9igjgp");
                if (i15 == 4) {
                    z28 = true;
                } else {
                    z28 = false;
                }
                objRememberedValue12 = composer3.rememberedValue();
                if (z28) {
                    objRememberedValue12 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda49
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$20$0(store2, (String) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue12);
                } else {
                    objRememberedValue12 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda49
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$20$0(store2, (String) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue12);
                }
                Function1 function3115 = (Function1) objRememberedValue12;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792812683, "CC(remember):SearchScreen.kt#9igjgp");
                if (i15 == 4) {
                    z29 = true;
                } else {
                    z29 = false;
                }
                objRememberedValue13 = composer3.rememberedValue();
                if (z29) {
                    objRememberedValue13 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda50
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$21$0(store2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue13);
                } else {
                    objRememberedValue13 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda50
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$21$0(store2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue13);
                }
                Function0 function3116 = (Function0) objRememberedValue13;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792809899, "CC(remember):SearchScreen.kt#9igjgp");
                if (i15 == 4) {
                    z30 = true;
                } else {
                    z30 = false;
                }
                objRememberedValue14 = composer3.rememberedValue();
                if (z30) {
                    objRememberedValue14 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda51
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$22$0(store2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue14);
                } else {
                    objRememberedValue14 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda51
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$22$0(store2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue14);
                }
                Function0 function3117 = (Function0) objRememberedValue14;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792805157, "CC(remember):SearchScreen.kt#9igjgp");
                if (i15 == 4) {
                }
                objRememberedValue15 = composer3.rememberedValue();
                if (z31) {
                    objRememberedValue15 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda52
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$23$0(store2, (FilesSearchFilters.FilterType) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue15);
                } else {
                    objRememberedValue15 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda52
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$23$0(store2, (FilesSearchFilters.FilterType) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue15);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                Composer composer7 = composer3;
                SearchScreenContent(query4, searchModeState5, screenState4, identifiedList4, recentQueries4, recentAiSessions4, z16, snackbarHostState, enabledTabs4, zIsSelecting4, zIsAiAtSearchEnabled4, function2115, function2116, function2117, function2118, function2114, function2119, function21110, function3111, function3112, function3113, function3114, function3115, function3116, function3117, (Function1) objRememberedValue15, function22, z5, composer7, 12582912, 0, (i18 << 18) & 29360128, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function13 = function19;
                composer2 = composer7;
                function9 = function18;
                function12 = function20;
                function11 = function17;
                z4 = z5;
                function10 = function21;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                function9 = function5;
                z4 = z2;
                composer2 = composerStartRestartGroup;
                function10 = function6;
                function11 = function8;
                function12 = function7;
                function13 = function3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda53
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SearchScreenKt.SearchScreen$lambda$24(store, z4, onDismissSearch, function10, function12, function13, function11, function9, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        z2 = z;
        if ((i & 384) == 0) {
            if (composerStartRestartGroup.changedInstance(onDismissSearch)) {
                i20 = 256;
            } else {
                i20 = 128;
            }
            i3 |= i20;
        }
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                function6 = function2;
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    function7 = function1;
                    if (composerStartRestartGroup.changedInstance(function7)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 64;
                if (i10 != 0) {
                    i3 |= 1572864;
                    function8 = function4;
                } else {
                    function8 = function4;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function8)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    }
                }
                i12 = i2 & 128;
                if (i12 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i13 = 8388608;
                    } else {
                        i13 = 4194304;
                    }
                    i3 |= i13;
                }
                if ((i3 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    if (i21 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i4 != 0) {
                        function14 = null;
                    } else {
                        function14 = function6;
                    }
                    if (i6 != 0) {
                        function7 = null;
                    }
                    if (i8 != 0) {
                        function15 = null;
                    } else {
                        function15 = function3;
                    }
                    if (i10 != 0) {
                        function8 = null;
                    }
                    if (i12 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792936852, "CC(remember):SearchScreen.kt#9igjgp");
                        objRememberedValue16 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue16 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue16 = new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda47
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return SearchScreenKt.SearchScreen$lambda$0$0((String) obj, (String) obj2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue16);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function16 = (Function2) objRememberedValue16;
                    } else {
                        function16 = function5;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1463316607, i3, -1, "com.box.android.search.presentation.ui.SearchScreen (SearchScreen.kt:104)");
                    }
                    i14 = i3;
                    stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    searchModeState = SearchScreen$lambda$1(stateCollectAsStateWithLifecycle).getSearchModeState();
                    if (searchModeState instanceof FilesSearchReducer.State) {
                        state = (FilesSearchReducer.State) searchModeState;
                    } else {
                        state = null;
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792931007, "CC(remember):SearchScreen.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new SnackbarHostState();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    snackbarHostState = (SnackbarHostState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792926598, "CC(remember):SearchScreen.kt#9igjgp");
                    i15 = i14 & 14;
                    if (i15 == 4) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z6) {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda54
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$3$0(store, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda54
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$3$0(store, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    Function1 function21111 = (Function1) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Unit unit5 = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792920930, "CC(remember):SearchScreen.kt#9igjgp");
                    if (i15 == 4) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    searchScreenKt$SearchScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z7) {
                        searchScreenKt$SearchScreen$2$1RememberedValue = new SearchScreenKt$SearchScreen$2$1(store, null);
                        composerStartRestartGroup.updateRememberedValue(searchScreenKt$SearchScreen$2$1RememberedValue);
                    } else {
                        searchScreenKt$SearchScreen$2$1RememberedValue = new SearchScreenKt$SearchScreen$2$1(store, null);
                        composerStartRestartGroup.updateRememberedValue(searchScreenKt$SearchScreen$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit5, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) searchScreenKt$SearchScreen$2$1RememberedValue, composerStartRestartGroup, 6);
                    strStringResource = StringResources_androidKt.stringResource(R.string.search_generic_error_sub_text, composerStartRestartGroup, 0);
                    Boolean boolValueOf5 = Boolean.valueOf(SearchScreen$lambda$1(stateCollectAsStateWithLifecycle).getErrorShown());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792915123, "CC(remember):SearchScreen.kt#9igjgp");
                    boolean zChanged19 = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | composerStartRestartGroup.changed(strStringResource);
                    if (i15 == 4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    z9 = z8 | zChanged19;
                    Object objRememberedValue115 = composerStartRestartGroup.rememberedValue();
                    if (z9) {
                        searchScreenKt$SearchScreen$3$1 = new SearchScreenKt$SearchScreen$3$1(snackbarHostState, strStringResource, store, stateCollectAsStateWithLifecycle, null);
                        composerStartRestartGroup.updateRememberedValue(searchScreenKt$SearchScreen$3$1);
                    } else {
                        searchScreenKt$SearchScreen$3$1 = new SearchScreenKt$SearchScreen$3$1(snackbarHostState, strStringResource, store, stateCollectAsStateWithLifecycle, null);
                        composerStartRestartGroup.updateRememberedValue(searchScreenKt$SearchScreen$3$1);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(boolValueOf5, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) searchScreenKt$SearchScreen$3$1, composerStartRestartGroup, 0);
                    ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner5 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume5 = composerStartRestartGroup.consume(localLifecycleOwner5);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    lifecycleScope = LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) objConsume5);
                    SearchReducer.SearchRoute route5 = SearchScreen$lambda$1(r57).getRoute();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792905428, "CC(remember):SearchScreen.kt#9igjgp");
                    boolean zChanged110 = composerStartRestartGroup.changed(r57);
                    if ((i14 & 7168) == 2048) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    boolean z314 = z10 | zChanged110;
                    if ((57344 & i14) == 16384) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    boolean z315 = z314 | z11;
                    if ((458752 & i14) == 131072) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    boolean zChangedInstance5 = z315 | z12 | composerStartRestartGroup.changedInstance(function8) | composerStartRestartGroup.changed(state) | composerStartRestartGroup.changedInstance(lifecycleScope);
                    if (i15 == 4) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    boolean z316 = zChangedInstance5 | z13;
                    if ((29360128 & i14) == 8388608) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    z15 = z316 | z14;
                    Object objRememberedValue116 = composerStartRestartGroup.rememberedValue();
                    if (z15) {
                        store2 = store;
                        function17 = function8;
                        function18 = function16;
                        function19 = function15;
                        i16 = i14;
                        state2 = r57;
                        composer3 = composerStartRestartGroup;
                        function20 = function7;
                        function21 = function14;
                        i17 = 0;
                        searchScreenKt$SearchScreen$4$1 = new SearchScreenKt$SearchScreen$4$1(function21, function20, function19, function17, state, lifecycleScope, function18, store2, state2, null);
                        composer3.updateRememberedValue(searchScreenKt$SearchScreen$4$1);
                    } else {
                        store2 = store;
                        function17 = function8;
                        function18 = function16;
                        function19 = function15;
                        i16 = i14;
                        state2 = r57;
                        composer3 = composerStartRestartGroup;
                        function20 = function7;
                        function21 = function14;
                        i17 = 0;
                        searchScreenKt$SearchScreen$4$1 = new SearchScreenKt$SearchScreen$4$1(function21, function20, function19, function17, state, lifecycleScope, function18, store2, state2, null);
                        composer3.updateRememberedValue(searchScreenKt$SearchScreen$4$1);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    EffectsKt.LaunchedEffect(route5, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) searchScreenKt$SearchScreen$4$1, composer3, i17);
                    String query5 = SearchScreen$lambda$1(state2).getQuery();
                    SearchModeState searchModeState6 = SearchScreen$lambda$1(state2).getSearchModeState();
                    SearchReducer.ScreenState screenState5 = SearchScreen$lambda$1(state2).getScreenState();
                    List<String> recentQueries5 = SearchScreen$lambda$1(state2).getRecentQueries();
                    List<AiRecentSession> recentAiSessions5 = SearchScreen$lambda$1(state2).getRecentAiSessions();
                    IdentifiedList<String, SearchItemReducer.State> searchItems5 = SearchScreen$lambda$1(state2).getSearchItems();
                    totalCount = SearchScreen$lambda$1(state2).getTotalCount();
                    if (totalCount != null) {
                        if (SearchScreen$lambda$1(state2).getOffset() < totalCount.longValue()) {
                            i19 = 1;
                        } else {
                            i19 = i17;
                        }
                        z16 = i19;
                    } else {
                        z16 = i17;
                    }
                    List<SearchMode> enabledTabs5 = SearchScreen$lambda$1(state2).getEnabledTabs();
                    boolean zIsSelecting5 = SearchScreen$lambda$1(state2).isSelecting();
                    boolean zIsAiAtSearchEnabled5 = SearchScreen$lambda$1(state2).isAiAtSearchEnabled();
                    stateSearchScreen$lambda$1 = SearchScreen$lambda$1(state2);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792853163, "CC(remember):SearchScreen.kt#9igjgp");
                    zChanged = composer3.changed(stateSearchScreen$lambda$1);
                    searchScreenKt$SearchScreen$6$1RememberedValue = composer3.rememberedValue();
                    if (zChanged) {
                        searchScreenKt$SearchScreen$6$1RememberedValue = new SearchScreenKt$SearchScreen$6$1(stateSearchScreen$lambda$1);
                        composer3.updateRememberedValue(searchScreenKt$SearchScreen$6$1RememberedValue);
                    } else {
                        searchScreenKt$SearchScreen$6$1RememberedValue = new SearchScreenKt$SearchScreen$6$1(stateSearchScreen$lambda$1);
                        composer3.updateRememberedValue(searchScreenKt$SearchScreen$6$1RememberedValue);
                    }
                    KFunction kFunction9 = (KFunction) searchScreenKt$SearchScreen$6$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    stateSearchScreen$lambda$2 = SearchScreen$lambda$1(state2);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792851691, "CC(remember):SearchScreen.kt#9igjgp");
                    zChanged2 = composer3.changed(stateSearchScreen$lambda$2);
                    searchScreenKt$SearchScreen$7$1RememberedValue = composer3.rememberedValue();
                    if (zChanged2) {
                        searchScreenKt$SearchScreen$7$1RememberedValue = new SearchScreenKt$SearchScreen$7$1(stateSearchScreen$lambda$2);
                        composer3.updateRememberedValue(searchScreenKt$SearchScreen$7$1RememberedValue);
                    } else {
                        searchScreenKt$SearchScreen$7$1RememberedValue = new SearchScreenKt$SearchScreen$7$1(stateSearchScreen$lambda$2);
                        composer3.updateRememberedValue(searchScreenKt$SearchScreen$7$1RememberedValue);
                    }
                    KFunction kFunction10 = (KFunction) searchScreenKt$SearchScreen$7$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792800435, "CC(remember):SearchScreen.kt#9igjgp");
                    if (i15 == 4) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    objRememberedValue3 = composer3.rememberedValue();
                    if (z17) {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda56
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$10$0(store2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda56
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$10$0(store2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue3);
                    }
                    function0 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    if (SearchScreen$lambda$1(state2).getHasAppliedFilters()) {
                        function22 = function0;
                    } else {
                        function22 = null;
                    }
                    IdentifiedList<String, SearchItemReducer.State> identifiedList5 = searchItems5;
                    Function1 function21112 = (Function1) kFunction9;
                    Function1 function21113 = (Function1) kFunction10;
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792850361, "CC(remember):SearchScreen.kt#9igjgp");
                    if (i15 == 4) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    objRememberedValue4 = composer3.rememberedValue();
                    if (z18) {
                        objRememberedValue4 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda57
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$12$0(store2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda57
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$12$0(store2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue4);
                    }
                    Function0 function21114 = (Function0) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792847383, "CC(remember):SearchScreen.kt#9igjgp");
                    if (i15 == 4) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    objRememberedValue5 = composer3.rememberedValue();
                    if (z19) {
                        objRememberedValue5 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda58
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$13$0(store2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda58
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$13$0(store2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue5);
                    }
                    Function0 function21115 = (Function0) objRememberedValue5;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792842320, "CC(remember):SearchScreen.kt#9igjgp");
                    if (i15 == 4) {
                        z20 = true;
                    } else {
                        z20 = false;
                    }
                    objRememberedValue6 = composer3.rememberedValue();
                    if (z20) {
                        objRememberedValue6 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda59
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$14$0(store2, (String) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue6);
                    } else {
                        objRememberedValue6 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda59
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$14$0(store2, (String) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue6);
                    }
                    Function1 function21116 = (Function1) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792833263, "CC(remember):SearchScreen.kt#9igjgp");
                    i18 = i16;
                    if ((i18 & 896) == 256) {
                        z21 = true;
                    } else {
                        z21 = false;
                    }
                    objRememberedValue7 = composer3.rememberedValue();
                    if (z21) {
                        objRememberedValue7 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda60
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$15$0(onDismissSearch);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue7);
                    } else {
                        objRememberedValue7 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda60
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$15$0(onDismissSearch);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue7);
                    }
                    Function0 function21117 = (Function0) objRememberedValue7;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792830564, "CC(remember):SearchScreen.kt#9igjgp");
                    boolean zChanged111 = composer3.changed(state2);
                    if (i15 == 4) {
                        z22 = true;
                    } else {
                        z22 = false;
                    }
                    z23 = zChanged111 | z22;
                    objRememberedValue8 = composer3.rememberedValue();
                    if (z23) {
                        objRememberedValue8 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda61
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$16$0(store2, state2, (SearchMode) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue8);
                    } else {
                        objRememberedValue8 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda61
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$16$0(store2, state2, (SearchMode) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue8);
                    }
                    Function1 function3118 = (Function1) objRememberedValue8;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792838764, "CC(remember):SearchScreen.kt#9igjgp");
                    boolean zChanged112 = composer3.changed(state2);
                    if (i15 == 4) {
                        z24 = true;
                    } else {
                        z24 = false;
                    }
                    z25 = zChanged112 | z24;
                    objRememberedValue9 = composer3.rememberedValue();
                    if (z25) {
                        objRememberedValue9 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda62
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$17$0(store2, state2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue9);
                    } else {
                        objRememberedValue9 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda62
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$17$0(store2, state2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue9);
                    }
                    Function0 function3119 = (Function0) objRememberedValue9;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792823653, "CC(remember):SearchScreen.kt#9igjgp");
                    if (i15 == 4) {
                        z26 = true;
                    } else {
                        z26 = false;
                    }
                    objRememberedValue10 = composer3.rememberedValue();
                    if (z26) {
                        objRememberedValue10 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda63
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$18$0(store2, (String) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue10);
                    } else {
                        objRememberedValue10 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda63
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$18$0(store2, (String) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue10);
                    }
                    Function1 function31110 = (Function1) objRememberedValue10;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792819685, "CC(remember):SearchScreen.kt#9igjgp");
                    if (i15 == 4) {
                        z27 = true;
                    } else {
                        z27 = false;
                    }
                    objRememberedValue11 = composer3.rememberedValue();
                    if (z27) {
                        objRememberedValue11 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda48
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$19$0(store2, (String) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue11);
                    } else {
                        objRememberedValue11 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda48
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$19$0(store2, (String) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue11);
                    }
                    Function1 function31111 = (Function1) objRememberedValue11;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792815648, "CC(remember):SearchScreen.kt#9igjgp");
                    if (i15 == 4) {
                        z28 = true;
                    } else {
                        z28 = false;
                    }
                    objRememberedValue12 = composer3.rememberedValue();
                    if (z28) {
                        objRememberedValue12 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda49
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$20$0(store2, (String) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue12);
                    } else {
                        objRememberedValue12 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda49
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$20$0(store2, (String) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue12);
                    }
                    Function1 function31112 = (Function1) objRememberedValue12;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792812683, "CC(remember):SearchScreen.kt#9igjgp");
                    if (i15 == 4) {
                        z29 = true;
                    } else {
                        z29 = false;
                    }
                    objRememberedValue13 = composer3.rememberedValue();
                    if (z29) {
                        objRememberedValue13 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda50
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$21$0(store2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue13);
                    } else {
                        objRememberedValue13 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda50
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$21$0(store2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue13);
                    }
                    Function0 function31113 = (Function0) objRememberedValue13;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792809899, "CC(remember):SearchScreen.kt#9igjgp");
                    if (i15 == 4) {
                        z30 = true;
                    } else {
                        z30 = false;
                    }
                    objRememberedValue14 = composer3.rememberedValue();
                    if (z30) {
                        objRememberedValue14 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda51
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$22$0(store2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue14);
                    } else {
                        objRememberedValue14 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda51
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SearchScreenKt.SearchScreen$lambda$22$0(store2);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue14);
                    }
                    Function0 function31114 = (Function0) objRememberedValue14;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1792805157, "CC(remember):SearchScreen.kt#9igjgp");
                    if (i15 == 4) {
                    }
                    objRememberedValue15 = composer3.rememberedValue();
                    if (z31) {
                        objRememberedValue15 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda52
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$23$0(store2, (FilesSearchFilters.FilterType) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue15);
                    } else {
                        objRememberedValue15 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda52
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreen$lambda$23$0(store2, (FilesSearchFilters.FilterType) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue15);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Composer composer8 = composer3;
                    SearchScreenContent(query5, searchModeState6, screenState5, identifiedList5, recentQueries5, recentAiSessions5, z16, snackbarHostState, enabledTabs5, zIsSelecting5, zIsAiAtSearchEnabled5, function21112, function21113, function21114, function21115, function21111, function21116, function21117, function3118, function3119, function31110, function31111, function31112, function31113, function31114, (Function1) objRememberedValue15, function22, z5, composer8, 12582912, 0, (i18 << 18) & 29360128, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function13 = function19;
                    composer2 = composer8;
                    function9 = function18;
                    function12 = function20;
                    function11 = function17;
                    z4 = z5;
                    function10 = function21;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    function9 = function5;
                    z4 = z2;
                    composer2 = composerStartRestartGroup;
                    function10 = function6;
                    function11 = function8;
                    function12 = function7;
                    function13 = function3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda53
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SearchScreenKt.SearchScreen$lambda$24(store, z4, onDismissSearch, function10, function12, function13, function11, function9, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            function7 = function1;
            i8 = i2 & 32;
            if (i8 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i3 |= i9;
            }
            i10 = i2 & 64;
            if (i10 != 0) {
                i3 |= 1572864;
                function8 = function4;
            } else {
                function8 = function4;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function8)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
            }
            i12 = i2 & 128;
            if (i12 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i13 = 8388608;
                } else {
                    i13 = 4194304;
                }
                i3 |= i13;
            }
            if ((i3 & 4793491) != 4793490) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                if (i21 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (i4 != 0) {
                    function14 = null;
                } else {
                    function14 = function6;
                }
                if (i6 != 0) {
                    function7 = null;
                }
                if (i8 != 0) {
                    function15 = null;
                } else {
                    function15 = function3;
                }
                if (i10 != 0) {
                    function8 = null;
                }
                if (i12 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792936852, "CC(remember):SearchScreen.kt#9igjgp");
                    objRememberedValue16 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue16 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue16 = new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda47
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SearchScreenKt.SearchScreen$lambda$0$0((String) obj, (String) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue16);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function16 = (Function2) objRememberedValue16;
                } else {
                    function16 = function5;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1463316607, i3, -1, "com.box.android.search.presentation.ui.SearchScreen (SearchScreen.kt:104)");
                }
                i14 = i3;
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                searchModeState = SearchScreen$lambda$1(stateCollectAsStateWithLifecycle).getSearchModeState();
                if (searchModeState instanceof FilesSearchReducer.State) {
                    state = (FilesSearchReducer.State) searchModeState;
                } else {
                    state = null;
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792931007, "CC(remember):SearchScreen.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new SnackbarHostState();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                snackbarHostState = (SnackbarHostState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792926598, "CC(remember):SearchScreen.kt#9igjgp");
                i15 = i14 & 14;
                if (i15 == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z6) {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda54
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$3$0(store, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda54
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$3$0(store, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Function1 function21118 = (Function1) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Unit unit6 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792920930, "CC(remember):SearchScreen.kt#9igjgp");
                if (i15 == 4) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                searchScreenKt$SearchScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (z7) {
                    searchScreenKt$SearchScreen$2$1RememberedValue = new SearchScreenKt$SearchScreen$2$1(store, null);
                    composerStartRestartGroup.updateRememberedValue(searchScreenKt$SearchScreen$2$1RememberedValue);
                } else {
                    searchScreenKt$SearchScreen$2$1RememberedValue = new SearchScreenKt$SearchScreen$2$1(store, null);
                    composerStartRestartGroup.updateRememberedValue(searchScreenKt$SearchScreen$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit6, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) searchScreenKt$SearchScreen$2$1RememberedValue, composerStartRestartGroup, 6);
                strStringResource = StringResources_androidKt.stringResource(R.string.search_generic_error_sub_text, composerStartRestartGroup, 0);
                Boolean boolValueOf6 = Boolean.valueOf(SearchScreen$lambda$1(stateCollectAsStateWithLifecycle).getErrorShown());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792915123, "CC(remember):SearchScreen.kt#9igjgp");
                boolean zChanged113 = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | composerStartRestartGroup.changed(strStringResource);
                if (i15 == 4) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                z9 = z8 | zChanged113;
                Object objRememberedValue117 = composerStartRestartGroup.rememberedValue();
                if (z9) {
                    searchScreenKt$SearchScreen$3$1 = new SearchScreenKt$SearchScreen$3$1(snackbarHostState, strStringResource, store, stateCollectAsStateWithLifecycle, null);
                    composerStartRestartGroup.updateRememberedValue(searchScreenKt$SearchScreen$3$1);
                } else {
                    searchScreenKt$SearchScreen$3$1 = new SearchScreenKt$SearchScreen$3$1(snackbarHostState, strStringResource, store, stateCollectAsStateWithLifecycle, null);
                    composerStartRestartGroup.updateRememberedValue(searchScreenKt$SearchScreen$3$1);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf6, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) searchScreenKt$SearchScreen$3$1, composerStartRestartGroup, 0);
                ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner6 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume6 = composerStartRestartGroup.consume(localLifecycleOwner6);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                lifecycleScope = LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) objConsume6);
                SearchReducer.SearchRoute route6 = SearchScreen$lambda$1(r57).getRoute();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792905428, "CC(remember):SearchScreen.kt#9igjgp");
                boolean zChanged114 = composerStartRestartGroup.changed(r57);
                if ((i14 & 7168) == 2048) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                boolean z317 = z10 | zChanged114;
                if ((57344 & i14) == 16384) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                boolean z318 = z317 | z11;
                if ((458752 & i14) == 131072) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                boolean zChangedInstance6 = z318 | z12 | composerStartRestartGroup.changedInstance(function8) | composerStartRestartGroup.changed(state) | composerStartRestartGroup.changedInstance(lifecycleScope);
                if (i15 == 4) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                boolean z319 = zChangedInstance6 | z13;
                if ((29360128 & i14) == 8388608) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                z15 = z319 | z14;
                Object objRememberedValue118 = composerStartRestartGroup.rememberedValue();
                if (z15) {
                    store2 = store;
                    function17 = function8;
                    function18 = function16;
                    function19 = function15;
                    i16 = i14;
                    state2 = r57;
                    composer3 = composerStartRestartGroup;
                    function20 = function7;
                    function21 = function14;
                    i17 = 0;
                    searchScreenKt$SearchScreen$4$1 = new SearchScreenKt$SearchScreen$4$1(function21, function20, function19, function17, state, lifecycleScope, function18, store2, state2, null);
                    composer3.updateRememberedValue(searchScreenKt$SearchScreen$4$1);
                } else {
                    store2 = store;
                    function17 = function8;
                    function18 = function16;
                    function19 = function15;
                    i16 = i14;
                    state2 = r57;
                    composer3 = composerStartRestartGroup;
                    function20 = function7;
                    function21 = function14;
                    i17 = 0;
                    searchScreenKt$SearchScreen$4$1 = new SearchScreenKt$SearchScreen$4$1(function21, function20, function19, function17, state, lifecycleScope, function18, store2, state2, null);
                    composer3.updateRememberedValue(searchScreenKt$SearchScreen$4$1);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                EffectsKt.LaunchedEffect(route6, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) searchScreenKt$SearchScreen$4$1, composer3, i17);
                String query6 = SearchScreen$lambda$1(state2).getQuery();
                SearchModeState searchModeState7 = SearchScreen$lambda$1(state2).getSearchModeState();
                SearchReducer.ScreenState screenState6 = SearchScreen$lambda$1(state2).getScreenState();
                List<String> recentQueries6 = SearchScreen$lambda$1(state2).getRecentQueries();
                List<AiRecentSession> recentAiSessions6 = SearchScreen$lambda$1(state2).getRecentAiSessions();
                IdentifiedList<String, SearchItemReducer.State> searchItems6 = SearchScreen$lambda$1(state2).getSearchItems();
                totalCount = SearchScreen$lambda$1(state2).getTotalCount();
                if (totalCount != null) {
                    if (SearchScreen$lambda$1(state2).getOffset() < totalCount.longValue()) {
                        i19 = 1;
                    } else {
                        i19 = i17;
                    }
                    z16 = i19;
                } else {
                    z16 = i17;
                }
                List<SearchMode> enabledTabs6 = SearchScreen$lambda$1(state2).getEnabledTabs();
                boolean zIsSelecting6 = SearchScreen$lambda$1(state2).isSelecting();
                boolean zIsAiAtSearchEnabled6 = SearchScreen$lambda$1(state2).isAiAtSearchEnabled();
                stateSearchScreen$lambda$1 = SearchScreen$lambda$1(state2);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792853163, "CC(remember):SearchScreen.kt#9igjgp");
                zChanged = composer3.changed(stateSearchScreen$lambda$1);
                searchScreenKt$SearchScreen$6$1RememberedValue = composer3.rememberedValue();
                if (zChanged) {
                    searchScreenKt$SearchScreen$6$1RememberedValue = new SearchScreenKt$SearchScreen$6$1(stateSearchScreen$lambda$1);
                    composer3.updateRememberedValue(searchScreenKt$SearchScreen$6$1RememberedValue);
                } else {
                    searchScreenKt$SearchScreen$6$1RememberedValue = new SearchScreenKt$SearchScreen$6$1(stateSearchScreen$lambda$1);
                    composer3.updateRememberedValue(searchScreenKt$SearchScreen$6$1RememberedValue);
                }
                KFunction kFunction11 = (KFunction) searchScreenKt$SearchScreen$6$1RememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                stateSearchScreen$lambda$2 = SearchScreen$lambda$1(state2);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792851691, "CC(remember):SearchScreen.kt#9igjgp");
                zChanged2 = composer3.changed(stateSearchScreen$lambda$2);
                searchScreenKt$SearchScreen$7$1RememberedValue = composer3.rememberedValue();
                if (zChanged2) {
                    searchScreenKt$SearchScreen$7$1RememberedValue = new SearchScreenKt$SearchScreen$7$1(stateSearchScreen$lambda$2);
                    composer3.updateRememberedValue(searchScreenKt$SearchScreen$7$1RememberedValue);
                } else {
                    searchScreenKt$SearchScreen$7$1RememberedValue = new SearchScreenKt$SearchScreen$7$1(stateSearchScreen$lambda$2);
                    composer3.updateRememberedValue(searchScreenKt$SearchScreen$7$1RememberedValue);
                }
                KFunction kFunction12 = (KFunction) searchScreenKt$SearchScreen$7$1RememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792800435, "CC(remember):SearchScreen.kt#9igjgp");
                if (i15 == 4) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                objRememberedValue3 = composer3.rememberedValue();
                if (z17) {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda56
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$10$0(store2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda56
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$10$0(store2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue3);
                }
                function0 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                if (SearchScreen$lambda$1(state2).getHasAppliedFilters()) {
                    function22 = function0;
                } else {
                    function22 = null;
                }
                IdentifiedList<String, SearchItemReducer.State> identifiedList6 = searchItems6;
                Function1 function21119 = (Function1) kFunction11;
                Function1 function211110 = (Function1) kFunction12;
                ComposerKt.sourceInformationMarkerStart(composer3, -1792850361, "CC(remember):SearchScreen.kt#9igjgp");
                if (i15 == 4) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                objRememberedValue4 = composer3.rememberedValue();
                if (z18) {
                    objRememberedValue4 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda57
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$12$0(store2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda57
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$12$0(store2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue4);
                }
                Function0 function211111 = (Function0) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792847383, "CC(remember):SearchScreen.kt#9igjgp");
                if (i15 == 4) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                objRememberedValue5 = composer3.rememberedValue();
                if (z19) {
                    objRememberedValue5 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda58
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$13$0(store2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda58
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$13$0(store2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue5);
                }
                Function0 function211112 = (Function0) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792842320, "CC(remember):SearchScreen.kt#9igjgp");
                if (i15 == 4) {
                    z20 = true;
                } else {
                    z20 = false;
                }
                objRememberedValue6 = composer3.rememberedValue();
                if (z20) {
                    objRememberedValue6 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda59
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$14$0(store2, (String) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda59
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$14$0(store2, (String) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue6);
                }
                Function1 function211113 = (Function1) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792833263, "CC(remember):SearchScreen.kt#9igjgp");
                i18 = i16;
                if ((i18 & 896) == 256) {
                    z21 = true;
                } else {
                    z21 = false;
                }
                objRememberedValue7 = composer3.rememberedValue();
                if (z21) {
                    objRememberedValue7 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda60
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$15$0(onDismissSearch);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue7);
                } else {
                    objRememberedValue7 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda60
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$15$0(onDismissSearch);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue7);
                }
                Function0 function211114 = (Function0) objRememberedValue7;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792830564, "CC(remember):SearchScreen.kt#9igjgp");
                boolean zChanged115 = composer3.changed(state2);
                if (i15 == 4) {
                    z22 = true;
                } else {
                    z22 = false;
                }
                z23 = zChanged115 | z22;
                objRememberedValue8 = composer3.rememberedValue();
                if (z23) {
                    objRememberedValue8 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda61
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$16$0(store2, state2, (SearchMode) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue8);
                } else {
                    objRememberedValue8 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda61
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$16$0(store2, state2, (SearchMode) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue8);
                }
                Function1 function31115 = (Function1) objRememberedValue8;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792838764, "CC(remember):SearchScreen.kt#9igjgp");
                boolean zChanged116 = composer3.changed(state2);
                if (i15 == 4) {
                    z24 = true;
                } else {
                    z24 = false;
                }
                z25 = zChanged116 | z24;
                objRememberedValue9 = composer3.rememberedValue();
                if (z25) {
                    objRememberedValue9 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda62
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$17$0(store2, state2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue9);
                } else {
                    objRememberedValue9 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda62
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$17$0(store2, state2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue9);
                }
                Function0 function31116 = (Function0) objRememberedValue9;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792823653, "CC(remember):SearchScreen.kt#9igjgp");
                if (i15 == 4) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                objRememberedValue10 = composer3.rememberedValue();
                if (z26) {
                    objRememberedValue10 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda63
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$18$0(store2, (String) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue10);
                } else {
                    objRememberedValue10 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda63
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$18$0(store2, (String) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue10);
                }
                Function1 function31117 = (Function1) objRememberedValue10;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792819685, "CC(remember):SearchScreen.kt#9igjgp");
                if (i15 == 4) {
                    z27 = true;
                } else {
                    z27 = false;
                }
                objRememberedValue11 = composer3.rememberedValue();
                if (z27) {
                    objRememberedValue11 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda48
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$19$0(store2, (String) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue11);
                } else {
                    objRememberedValue11 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda48
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$19$0(store2, (String) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue11);
                }
                Function1 function31118 = (Function1) objRememberedValue11;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792815648, "CC(remember):SearchScreen.kt#9igjgp");
                if (i15 == 4) {
                    z28 = true;
                } else {
                    z28 = false;
                }
                objRememberedValue12 = composer3.rememberedValue();
                if (z28) {
                    objRememberedValue12 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda49
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$20$0(store2, (String) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue12);
                } else {
                    objRememberedValue12 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda49
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$20$0(store2, (String) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue12);
                }
                Function1 function31119 = (Function1) objRememberedValue12;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792812683, "CC(remember):SearchScreen.kt#9igjgp");
                if (i15 == 4) {
                    z29 = true;
                } else {
                    z29 = false;
                }
                objRememberedValue13 = composer3.rememberedValue();
                if (z29) {
                    objRememberedValue13 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda50
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$21$0(store2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue13);
                } else {
                    objRememberedValue13 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda50
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$21$0(store2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue13);
                }
                Function0 function311110 = (Function0) objRememberedValue13;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792809899, "CC(remember):SearchScreen.kt#9igjgp");
                if (i15 == 4) {
                    z30 = true;
                } else {
                    z30 = false;
                }
                objRememberedValue14 = composer3.rememberedValue();
                if (z30) {
                    objRememberedValue14 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda51
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$22$0(store2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue14);
                } else {
                    objRememberedValue14 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda51
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$22$0(store2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue14);
                }
                Function0 function311111 = (Function0) objRememberedValue14;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792805157, "CC(remember):SearchScreen.kt#9igjgp");
                if (i15 == 4) {
                }
                objRememberedValue15 = composer3.rememberedValue();
                if (z31) {
                    objRememberedValue15 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda52
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$23$0(store2, (FilesSearchFilters.FilterType) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue15);
                } else {
                    objRememberedValue15 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda52
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$23$0(store2, (FilesSearchFilters.FilterType) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue15);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                Composer composer9 = composer3;
                SearchScreenContent(query6, searchModeState7, screenState6, identifiedList6, recentQueries6, recentAiSessions6, z16, snackbarHostState, enabledTabs6, zIsSelecting6, zIsAiAtSearchEnabled6, function21119, function211110, function211111, function211112, function21118, function211113, function211114, function31115, function31116, function31117, function31118, function31119, function311110, function311111, (Function1) objRememberedValue15, function22, z5, composer9, 12582912, 0, (i18 << 18) & 29360128, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function13 = function19;
                composer2 = composer9;
                function9 = function18;
                function12 = function20;
                function11 = function17;
                z4 = z5;
                function10 = function21;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                function9 = function5;
                z4 = z2;
                composer2 = composerStartRestartGroup;
                function10 = function6;
                function11 = function8;
                function12 = function7;
                function13 = function3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda53
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SearchScreenKt.SearchScreen$lambda$24(store, z4, onDismissSearch, function10, function12, function13, function11, function9, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        function6 = function2;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                function7 = function1;
                if (composerStartRestartGroup.changedInstance(function7)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            i8 = i2 & 32;
            if (i8 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i3 |= i9;
            }
            i10 = i2 & 64;
            if (i10 != 0) {
                i3 |= 1572864;
                function8 = function4;
            } else {
                function8 = function4;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function8)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
            }
            i12 = i2 & 128;
            if (i12 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i13 = 8388608;
                } else {
                    i13 = 4194304;
                }
                i3 |= i13;
            }
            if ((i3 & 4793491) != 4793490) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                if (i21 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (i4 != 0) {
                    function14 = null;
                } else {
                    function14 = function6;
                }
                if (i6 != 0) {
                    function7 = null;
                }
                if (i8 != 0) {
                    function15 = null;
                } else {
                    function15 = function3;
                }
                if (i10 != 0) {
                    function8 = null;
                }
                if (i12 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792936852, "CC(remember):SearchScreen.kt#9igjgp");
                    objRememberedValue16 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue16 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue16 = new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda47
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SearchScreenKt.SearchScreen$lambda$0$0((String) obj, (String) obj2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue16);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function16 = (Function2) objRememberedValue16;
                } else {
                    function16 = function5;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1463316607, i3, -1, "com.box.android.search.presentation.ui.SearchScreen (SearchScreen.kt:104)");
                }
                i14 = i3;
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                searchModeState = SearchScreen$lambda$1(stateCollectAsStateWithLifecycle).getSearchModeState();
                if (searchModeState instanceof FilesSearchReducer.State) {
                    state = (FilesSearchReducer.State) searchModeState;
                } else {
                    state = null;
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792931007, "CC(remember):SearchScreen.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new SnackbarHostState();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                snackbarHostState = (SnackbarHostState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792926598, "CC(remember):SearchScreen.kt#9igjgp");
                i15 = i14 & 14;
                if (i15 == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z6) {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda54
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$3$0(store, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda54
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$3$0(store, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Function1 function211115 = (Function1) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Unit unit7 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792920930, "CC(remember):SearchScreen.kt#9igjgp");
                if (i15 == 4) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                searchScreenKt$SearchScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (z7) {
                    searchScreenKt$SearchScreen$2$1RememberedValue = new SearchScreenKt$SearchScreen$2$1(store, null);
                    composerStartRestartGroup.updateRememberedValue(searchScreenKt$SearchScreen$2$1RememberedValue);
                } else {
                    searchScreenKt$SearchScreen$2$1RememberedValue = new SearchScreenKt$SearchScreen$2$1(store, null);
                    composerStartRestartGroup.updateRememberedValue(searchScreenKt$SearchScreen$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit7, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) searchScreenKt$SearchScreen$2$1RememberedValue, composerStartRestartGroup, 6);
                strStringResource = StringResources_androidKt.stringResource(R.string.search_generic_error_sub_text, composerStartRestartGroup, 0);
                Boolean boolValueOf7 = Boolean.valueOf(SearchScreen$lambda$1(stateCollectAsStateWithLifecycle).getErrorShown());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792915123, "CC(remember):SearchScreen.kt#9igjgp");
                boolean zChanged117 = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | composerStartRestartGroup.changed(strStringResource);
                if (i15 == 4) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                z9 = z8 | zChanged117;
                Object objRememberedValue119 = composerStartRestartGroup.rememberedValue();
                if (z9) {
                    searchScreenKt$SearchScreen$3$1 = new SearchScreenKt$SearchScreen$3$1(snackbarHostState, strStringResource, store, stateCollectAsStateWithLifecycle, null);
                    composerStartRestartGroup.updateRememberedValue(searchScreenKt$SearchScreen$3$1);
                } else {
                    searchScreenKt$SearchScreen$3$1 = new SearchScreenKt$SearchScreen$3$1(snackbarHostState, strStringResource, store, stateCollectAsStateWithLifecycle, null);
                    composerStartRestartGroup.updateRememberedValue(searchScreenKt$SearchScreen$3$1);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf7, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) searchScreenKt$SearchScreen$3$1, composerStartRestartGroup, 0);
                ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner7 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume7 = composerStartRestartGroup.consume(localLifecycleOwner7);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                lifecycleScope = LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) objConsume7);
                SearchReducer.SearchRoute route7 = SearchScreen$lambda$1(r57).getRoute();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792905428, "CC(remember):SearchScreen.kt#9igjgp");
                boolean zChanged118 = composerStartRestartGroup.changed(r57);
                if ((i14 & 7168) == 2048) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                boolean z3110 = z10 | zChanged118;
                if ((57344 & i14) == 16384) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                boolean z3111 = z3110 | z11;
                if ((458752 & i14) == 131072) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                boolean zChangedInstance7 = z3111 | z12 | composerStartRestartGroup.changedInstance(function8) | composerStartRestartGroup.changed(state) | composerStartRestartGroup.changedInstance(lifecycleScope);
                if (i15 == 4) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                boolean z3112 = zChangedInstance7 | z13;
                if ((29360128 & i14) == 8388608) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                z15 = z3112 | z14;
                Object objRememberedValue1110 = composerStartRestartGroup.rememberedValue();
                if (z15) {
                    store2 = store;
                    function17 = function8;
                    function18 = function16;
                    function19 = function15;
                    i16 = i14;
                    state2 = r57;
                    composer3 = composerStartRestartGroup;
                    function20 = function7;
                    function21 = function14;
                    i17 = 0;
                    searchScreenKt$SearchScreen$4$1 = new SearchScreenKt$SearchScreen$4$1(function21, function20, function19, function17, state, lifecycleScope, function18, store2, state2, null);
                    composer3.updateRememberedValue(searchScreenKt$SearchScreen$4$1);
                } else {
                    store2 = store;
                    function17 = function8;
                    function18 = function16;
                    function19 = function15;
                    i16 = i14;
                    state2 = r57;
                    composer3 = composerStartRestartGroup;
                    function20 = function7;
                    function21 = function14;
                    i17 = 0;
                    searchScreenKt$SearchScreen$4$1 = new SearchScreenKt$SearchScreen$4$1(function21, function20, function19, function17, state, lifecycleScope, function18, store2, state2, null);
                    composer3.updateRememberedValue(searchScreenKt$SearchScreen$4$1);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                EffectsKt.LaunchedEffect(route7, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) searchScreenKt$SearchScreen$4$1, composer3, i17);
                String query7 = SearchScreen$lambda$1(state2).getQuery();
                SearchModeState searchModeState8 = SearchScreen$lambda$1(state2).getSearchModeState();
                SearchReducer.ScreenState screenState7 = SearchScreen$lambda$1(state2).getScreenState();
                List<String> recentQueries7 = SearchScreen$lambda$1(state2).getRecentQueries();
                List<AiRecentSession> recentAiSessions7 = SearchScreen$lambda$1(state2).getRecentAiSessions();
                IdentifiedList<String, SearchItemReducer.State> searchItems7 = SearchScreen$lambda$1(state2).getSearchItems();
                totalCount = SearchScreen$lambda$1(state2).getTotalCount();
                if (totalCount != null) {
                    if (SearchScreen$lambda$1(state2).getOffset() < totalCount.longValue()) {
                        i19 = 1;
                    } else {
                        i19 = i17;
                    }
                    z16 = i19;
                } else {
                    z16 = i17;
                }
                List<SearchMode> enabledTabs7 = SearchScreen$lambda$1(state2).getEnabledTabs();
                boolean zIsSelecting7 = SearchScreen$lambda$1(state2).isSelecting();
                boolean zIsAiAtSearchEnabled7 = SearchScreen$lambda$1(state2).isAiAtSearchEnabled();
                stateSearchScreen$lambda$1 = SearchScreen$lambda$1(state2);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792853163, "CC(remember):SearchScreen.kt#9igjgp");
                zChanged = composer3.changed(stateSearchScreen$lambda$1);
                searchScreenKt$SearchScreen$6$1RememberedValue = composer3.rememberedValue();
                if (zChanged) {
                    searchScreenKt$SearchScreen$6$1RememberedValue = new SearchScreenKt$SearchScreen$6$1(stateSearchScreen$lambda$1);
                    composer3.updateRememberedValue(searchScreenKt$SearchScreen$6$1RememberedValue);
                } else {
                    searchScreenKt$SearchScreen$6$1RememberedValue = new SearchScreenKt$SearchScreen$6$1(stateSearchScreen$lambda$1);
                    composer3.updateRememberedValue(searchScreenKt$SearchScreen$6$1RememberedValue);
                }
                KFunction kFunction13 = (KFunction) searchScreenKt$SearchScreen$6$1RememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                stateSearchScreen$lambda$2 = SearchScreen$lambda$1(state2);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792851691, "CC(remember):SearchScreen.kt#9igjgp");
                zChanged2 = composer3.changed(stateSearchScreen$lambda$2);
                searchScreenKt$SearchScreen$7$1RememberedValue = composer3.rememberedValue();
                if (zChanged2) {
                    searchScreenKt$SearchScreen$7$1RememberedValue = new SearchScreenKt$SearchScreen$7$1(stateSearchScreen$lambda$2);
                    composer3.updateRememberedValue(searchScreenKt$SearchScreen$7$1RememberedValue);
                } else {
                    searchScreenKt$SearchScreen$7$1RememberedValue = new SearchScreenKt$SearchScreen$7$1(stateSearchScreen$lambda$2);
                    composer3.updateRememberedValue(searchScreenKt$SearchScreen$7$1RememberedValue);
                }
                KFunction kFunction14 = (KFunction) searchScreenKt$SearchScreen$7$1RememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792800435, "CC(remember):SearchScreen.kt#9igjgp");
                if (i15 == 4) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                objRememberedValue3 = composer3.rememberedValue();
                if (z17) {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda56
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$10$0(store2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda56
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$10$0(store2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue3);
                }
                function0 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                if (SearchScreen$lambda$1(state2).getHasAppliedFilters()) {
                    function22 = function0;
                } else {
                    function22 = null;
                }
                IdentifiedList<String, SearchItemReducer.State> identifiedList7 = searchItems7;
                Function1 function211116 = (Function1) kFunction13;
                Function1 function211117 = (Function1) kFunction14;
                ComposerKt.sourceInformationMarkerStart(composer3, -1792850361, "CC(remember):SearchScreen.kt#9igjgp");
                if (i15 == 4) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                objRememberedValue4 = composer3.rememberedValue();
                if (z18) {
                    objRememberedValue4 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda57
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$12$0(store2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda57
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$12$0(store2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue4);
                }
                Function0 function211118 = (Function0) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792847383, "CC(remember):SearchScreen.kt#9igjgp");
                if (i15 == 4) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                objRememberedValue5 = composer3.rememberedValue();
                if (z19) {
                    objRememberedValue5 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda58
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$13$0(store2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda58
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$13$0(store2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue5);
                }
                Function0 function211119 = (Function0) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792842320, "CC(remember):SearchScreen.kt#9igjgp");
                if (i15 == 4) {
                    z20 = true;
                } else {
                    z20 = false;
                }
                objRememberedValue6 = composer3.rememberedValue();
                if (z20) {
                    objRememberedValue6 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda59
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$14$0(store2, (String) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda59
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$14$0(store2, (String) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue6);
                }
                Function1 function2111110 = (Function1) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792833263, "CC(remember):SearchScreen.kt#9igjgp");
                i18 = i16;
                if ((i18 & 896) == 256) {
                    z21 = true;
                } else {
                    z21 = false;
                }
                objRememberedValue7 = composer3.rememberedValue();
                if (z21) {
                    objRememberedValue7 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda60
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$15$0(onDismissSearch);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue7);
                } else {
                    objRememberedValue7 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda60
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$15$0(onDismissSearch);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue7);
                }
                Function0 function2111111 = (Function0) objRememberedValue7;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792830564, "CC(remember):SearchScreen.kt#9igjgp");
                boolean zChanged119 = composer3.changed(state2);
                if (i15 == 4) {
                    z22 = true;
                } else {
                    z22 = false;
                }
                z23 = zChanged119 | z22;
                objRememberedValue8 = composer3.rememberedValue();
                if (z23) {
                    objRememberedValue8 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda61
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$16$0(store2, state2, (SearchMode) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue8);
                } else {
                    objRememberedValue8 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda61
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$16$0(store2, state2, (SearchMode) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue8);
                }
                Function1 function311112 = (Function1) objRememberedValue8;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792838764, "CC(remember):SearchScreen.kt#9igjgp");
                boolean zChanged1110 = composer3.changed(state2);
                if (i15 == 4) {
                    z24 = true;
                } else {
                    z24 = false;
                }
                z25 = zChanged1110 | z24;
                objRememberedValue9 = composer3.rememberedValue();
                if (z25) {
                    objRememberedValue9 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda62
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$17$0(store2, state2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue9);
                } else {
                    objRememberedValue9 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda62
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$17$0(store2, state2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue9);
                }
                Function0 function311113 = (Function0) objRememberedValue9;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792823653, "CC(remember):SearchScreen.kt#9igjgp");
                if (i15 == 4) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                objRememberedValue10 = composer3.rememberedValue();
                if (z26) {
                    objRememberedValue10 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda63
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$18$0(store2, (String) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue10);
                } else {
                    objRememberedValue10 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda63
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$18$0(store2, (String) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue10);
                }
                Function1 function311114 = (Function1) objRememberedValue10;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792819685, "CC(remember):SearchScreen.kt#9igjgp");
                if (i15 == 4) {
                    z27 = true;
                } else {
                    z27 = false;
                }
                objRememberedValue11 = composer3.rememberedValue();
                if (z27) {
                    objRememberedValue11 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda48
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$19$0(store2, (String) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue11);
                } else {
                    objRememberedValue11 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda48
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$19$0(store2, (String) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue11);
                }
                Function1 function311115 = (Function1) objRememberedValue11;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792815648, "CC(remember):SearchScreen.kt#9igjgp");
                if (i15 == 4) {
                    z28 = true;
                } else {
                    z28 = false;
                }
                objRememberedValue12 = composer3.rememberedValue();
                if (z28) {
                    objRememberedValue12 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda49
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$20$0(store2, (String) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue12);
                } else {
                    objRememberedValue12 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda49
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$20$0(store2, (String) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue12);
                }
                Function1 function311116 = (Function1) objRememberedValue12;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792812683, "CC(remember):SearchScreen.kt#9igjgp");
                if (i15 == 4) {
                    z29 = true;
                } else {
                    z29 = false;
                }
                objRememberedValue13 = composer3.rememberedValue();
                if (z29) {
                    objRememberedValue13 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda50
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$21$0(store2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue13);
                } else {
                    objRememberedValue13 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda50
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$21$0(store2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue13);
                }
                Function0 function311117 = (Function0) objRememberedValue13;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792809899, "CC(remember):SearchScreen.kt#9igjgp");
                if (i15 == 4) {
                    z30 = true;
                } else {
                    z30 = false;
                }
                objRememberedValue14 = composer3.rememberedValue();
                if (z30) {
                    objRememberedValue14 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda51
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$22$0(store2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue14);
                } else {
                    objRememberedValue14 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda51
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SearchScreenKt.SearchScreen$lambda$22$0(store2);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue14);
                }
                Function0 function311118 = (Function0) objRememberedValue14;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -1792805157, "CC(remember):SearchScreen.kt#9igjgp");
                if (i15 == 4) {
                }
                objRememberedValue15 = composer3.rememberedValue();
                if (z31) {
                    objRememberedValue15 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda52
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$23$0(store2, (FilesSearchFilters.FilterType) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue15);
                } else {
                    objRememberedValue15 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda52
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreen$lambda$23$0(store2, (FilesSearchFilters.FilterType) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue15);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                Composer composer10 = composer3;
                SearchScreenContent(query7, searchModeState8, screenState7, identifiedList7, recentQueries7, recentAiSessions7, z16, snackbarHostState, enabledTabs7, zIsSelecting7, zIsAiAtSearchEnabled7, function211116, function211117, function211118, function211119, function211115, function2111110, function2111111, function311112, function311113, function311114, function311115, function311116, function311117, function311118, (Function1) objRememberedValue15, function22, z5, composer10, 12582912, 0, (i18 << 18) & 29360128, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function13 = function19;
                composer2 = composer10;
                function9 = function18;
                function12 = function20;
                function11 = function17;
                z4 = z5;
                function10 = function21;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                function9 = function5;
                z4 = z2;
                composer2 = composerStartRestartGroup;
                function10 = function6;
                function11 = function8;
                function12 = function7;
                function13 = function3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda53
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SearchScreenKt.SearchScreen$lambda$24(store, z4, onDismissSearch, function10, function12, function13, function11, function9, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        function7 = function1;
        i8 = i2 & 32;
        if (i8 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i9 = 131072;
            } else {
                i9 = 65536;
            }
            i3 |= i9;
        }
        i10 = i2 & 64;
        if (i10 != 0) {
            i3 |= 1572864;
            function8 = function4;
        } else {
            function8 = function4;
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function8)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
        }
        i12 = i2 & 128;
        if (i12 != 0) {
            i3 |= 12582912;
        } else if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(function5)) {
                i13 = 8388608;
            } else {
                i13 = 4194304;
            }
            i3 |= i13;
        }
        if ((i3 & 4793491) != 4793490) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            if (i21 != 0) {
                z5 = false;
            } else {
                z5 = z2;
            }
            if (i4 != 0) {
                function14 = null;
            } else {
                function14 = function6;
            }
            if (i6 != 0) {
                function7 = null;
            }
            if (i8 != 0) {
                function15 = null;
            } else {
                function15 = function3;
            }
            if (i10 != 0) {
                function8 = null;
            }
            if (i12 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792936852, "CC(remember):SearchScreen.kt#9igjgp");
                objRememberedValue16 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue16 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue16 = new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda47
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SearchScreenKt.SearchScreen$lambda$0$0((String) obj, (String) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue16);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                function16 = (Function2) objRememberedValue16;
            } else {
                function16 = function5;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1463316607, i3, -1, "com.box.android.search.presentation.ui.SearchScreen (SearchScreen.kt:104)");
            }
            i14 = i3;
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            searchModeState = SearchScreen$lambda$1(stateCollectAsStateWithLifecycle).getSearchModeState();
            if (searchModeState instanceof FilesSearchReducer.State) {
                state = (FilesSearchReducer.State) searchModeState;
            } else {
                state = null;
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792931007, "CC(remember):SearchScreen.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            snackbarHostState = (SnackbarHostState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792926598, "CC(remember):SearchScreen.kt#9igjgp");
            i15 = i14 & 14;
            if (i15 == 4) {
                z6 = true;
            } else {
                z6 = false;
            }
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z6) {
                objRememberedValue2 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda54
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SearchScreenKt.SearchScreen$lambda$3$0(store, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda54
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SearchScreenKt.SearchScreen$lambda$3$0(store, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function1 function2111112 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Unit unit8 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792920930, "CC(remember):SearchScreen.kt#9igjgp");
            if (i15 == 4) {
                z7 = true;
            } else {
                z7 = false;
            }
            searchScreenKt$SearchScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z7) {
                searchScreenKt$SearchScreen$2$1RememberedValue = new SearchScreenKt$SearchScreen$2$1(store, null);
                composerStartRestartGroup.updateRememberedValue(searchScreenKt$SearchScreen$2$1RememberedValue);
            } else {
                searchScreenKt$SearchScreen$2$1RememberedValue = new SearchScreenKt$SearchScreen$2$1(store, null);
                composerStartRestartGroup.updateRememberedValue(searchScreenKt$SearchScreen$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(unit8, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) searchScreenKt$SearchScreen$2$1RememberedValue, composerStartRestartGroup, 6);
            strStringResource = StringResources_androidKt.stringResource(R.string.search_generic_error_sub_text, composerStartRestartGroup, 0);
            Boolean boolValueOf8 = Boolean.valueOf(SearchScreen$lambda$1(stateCollectAsStateWithLifecycle).getErrorShown());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792915123, "CC(remember):SearchScreen.kt#9igjgp");
            boolean zChanged1111 = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | composerStartRestartGroup.changed(strStringResource);
            if (i15 == 4) {
                z8 = true;
            } else {
                z8 = false;
            }
            z9 = z8 | zChanged1111;
            Object objRememberedValue1111 = composerStartRestartGroup.rememberedValue();
            if (z9) {
                searchScreenKt$SearchScreen$3$1 = new SearchScreenKt$SearchScreen$3$1(snackbarHostState, strStringResource, store, stateCollectAsStateWithLifecycle, null);
                composerStartRestartGroup.updateRememberedValue(searchScreenKt$SearchScreen$3$1);
            } else {
                searchScreenKt$SearchScreen$3$1 = new SearchScreenKt$SearchScreen$3$1(snackbarHostState, strStringResource, store, stateCollectAsStateWithLifecycle, null);
                composerStartRestartGroup.updateRememberedValue(searchScreenKt$SearchScreen$3$1);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf8, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) searchScreenKt$SearchScreen$3$1, composerStartRestartGroup, 0);
            ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner8 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume8 = composerStartRestartGroup.consume(localLifecycleOwner8);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            lifecycleScope = LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) objConsume8);
            SearchReducer.SearchRoute route8 = SearchScreen$lambda$1(r57).getRoute();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792905428, "CC(remember):SearchScreen.kt#9igjgp");
            boolean zChanged1112 = composerStartRestartGroup.changed(r57);
            if ((i14 & 7168) == 2048) {
                z10 = true;
            } else {
                z10 = false;
            }
            boolean z3113 = z10 | zChanged1112;
            if ((57344 & i14) == 16384) {
                z11 = true;
            } else {
                z11 = false;
            }
            boolean z3114 = z3113 | z11;
            if ((458752 & i14) == 131072) {
                z12 = true;
            } else {
                z12 = false;
            }
            boolean zChangedInstance8 = z3114 | z12 | composerStartRestartGroup.changedInstance(function8) | composerStartRestartGroup.changed(state) | composerStartRestartGroup.changedInstance(lifecycleScope);
            if (i15 == 4) {
                z13 = true;
            } else {
                z13 = false;
            }
            boolean z3115 = zChangedInstance8 | z13;
            if ((29360128 & i14) == 8388608) {
                z14 = true;
            } else {
                z14 = false;
            }
            z15 = z3115 | z14;
            Object objRememberedValue1112 = composerStartRestartGroup.rememberedValue();
            if (z15) {
                store2 = store;
                function17 = function8;
                function18 = function16;
                function19 = function15;
                i16 = i14;
                state2 = r57;
                composer3 = composerStartRestartGroup;
                function20 = function7;
                function21 = function14;
                i17 = 0;
                searchScreenKt$SearchScreen$4$1 = new SearchScreenKt$SearchScreen$4$1(function21, function20, function19, function17, state, lifecycleScope, function18, store2, state2, null);
                composer3.updateRememberedValue(searchScreenKt$SearchScreen$4$1);
            } else {
                store2 = store;
                function17 = function8;
                function18 = function16;
                function19 = function15;
                i16 = i14;
                state2 = r57;
                composer3 = composerStartRestartGroup;
                function20 = function7;
                function21 = function14;
                i17 = 0;
                searchScreenKt$SearchScreen$4$1 = new SearchScreenKt$SearchScreen$4$1(function21, function20, function19, function17, state, lifecycleScope, function18, store2, state2, null);
                composer3.updateRememberedValue(searchScreenKt$SearchScreen$4$1);
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            EffectsKt.LaunchedEffect(route8, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) searchScreenKt$SearchScreen$4$1, composer3, i17);
            String query8 = SearchScreen$lambda$1(state2).getQuery();
            SearchModeState searchModeState9 = SearchScreen$lambda$1(state2).getSearchModeState();
            SearchReducer.ScreenState screenState8 = SearchScreen$lambda$1(state2).getScreenState();
            List<String> recentQueries8 = SearchScreen$lambda$1(state2).getRecentQueries();
            List<AiRecentSession> recentAiSessions8 = SearchScreen$lambda$1(state2).getRecentAiSessions();
            IdentifiedList<String, SearchItemReducer.State> searchItems8 = SearchScreen$lambda$1(state2).getSearchItems();
            totalCount = SearchScreen$lambda$1(state2).getTotalCount();
            if (totalCount != null) {
                if (SearchScreen$lambda$1(state2).getOffset() < totalCount.longValue()) {
                    i19 = 1;
                } else {
                    i19 = i17;
                }
                z16 = i19;
            } else {
                z16 = i17;
            }
            List<SearchMode> enabledTabs8 = SearchScreen$lambda$1(state2).getEnabledTabs();
            boolean zIsSelecting8 = SearchScreen$lambda$1(state2).isSelecting();
            boolean zIsAiAtSearchEnabled8 = SearchScreen$lambda$1(state2).isAiAtSearchEnabled();
            stateSearchScreen$lambda$1 = SearchScreen$lambda$1(state2);
            ComposerKt.sourceInformationMarkerStart(composer3, -1792853163, "CC(remember):SearchScreen.kt#9igjgp");
            zChanged = composer3.changed(stateSearchScreen$lambda$1);
            searchScreenKt$SearchScreen$6$1RememberedValue = composer3.rememberedValue();
            if (zChanged) {
                searchScreenKt$SearchScreen$6$1RememberedValue = new SearchScreenKt$SearchScreen$6$1(stateSearchScreen$lambda$1);
                composer3.updateRememberedValue(searchScreenKt$SearchScreen$6$1RememberedValue);
            } else {
                searchScreenKt$SearchScreen$6$1RememberedValue = new SearchScreenKt$SearchScreen$6$1(stateSearchScreen$lambda$1);
                composer3.updateRememberedValue(searchScreenKt$SearchScreen$6$1RememberedValue);
            }
            KFunction kFunction15 = (KFunction) searchScreenKt$SearchScreen$6$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            stateSearchScreen$lambda$2 = SearchScreen$lambda$1(state2);
            ComposerKt.sourceInformationMarkerStart(composer3, -1792851691, "CC(remember):SearchScreen.kt#9igjgp");
            zChanged2 = composer3.changed(stateSearchScreen$lambda$2);
            searchScreenKt$SearchScreen$7$1RememberedValue = composer3.rememberedValue();
            if (zChanged2) {
                searchScreenKt$SearchScreen$7$1RememberedValue = new SearchScreenKt$SearchScreen$7$1(stateSearchScreen$lambda$2);
                composer3.updateRememberedValue(searchScreenKt$SearchScreen$7$1RememberedValue);
            } else {
                searchScreenKt$SearchScreen$7$1RememberedValue = new SearchScreenKt$SearchScreen$7$1(stateSearchScreen$lambda$2);
                composer3.updateRememberedValue(searchScreenKt$SearchScreen$7$1RememberedValue);
            }
            KFunction kFunction16 = (KFunction) searchScreenKt$SearchScreen$7$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerStart(composer3, -1792800435, "CC(remember):SearchScreen.kt#9igjgp");
            if (i15 == 4) {
                z17 = true;
            } else {
                z17 = false;
            }
            objRememberedValue3 = composer3.rememberedValue();
            if (z17) {
                objRememberedValue3 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda56
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SearchScreenKt.SearchScreen$lambda$10$0(store2);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda56
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SearchScreenKt.SearchScreen$lambda$10$0(store2);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue3);
            }
            function0 = (Function0) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            if (SearchScreen$lambda$1(state2).getHasAppliedFilters()) {
                function22 = function0;
            } else {
                function22 = null;
            }
            IdentifiedList<String, SearchItemReducer.State> identifiedList8 = searchItems8;
            Function1 function2111113 = (Function1) kFunction15;
            Function1 function2111114 = (Function1) kFunction16;
            ComposerKt.sourceInformationMarkerStart(composer3, -1792850361, "CC(remember):SearchScreen.kt#9igjgp");
            if (i15 == 4) {
                z18 = true;
            } else {
                z18 = false;
            }
            objRememberedValue4 = composer3.rememberedValue();
            if (z18) {
                objRememberedValue4 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda57
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SearchScreenKt.SearchScreen$lambda$12$0(store2);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda57
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SearchScreenKt.SearchScreen$lambda$12$0(store2);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue4);
            }
            Function0 function2111115 = (Function0) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerStart(composer3, -1792847383, "CC(remember):SearchScreen.kt#9igjgp");
            if (i15 == 4) {
                z19 = true;
            } else {
                z19 = false;
            }
            objRememberedValue5 = composer3.rememberedValue();
            if (z19) {
                objRememberedValue5 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda58
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SearchScreenKt.SearchScreen$lambda$13$0(store2);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda58
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SearchScreenKt.SearchScreen$lambda$13$0(store2);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue5);
            }
            Function0 function2111116 = (Function0) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerStart(composer3, -1792842320, "CC(remember):SearchScreen.kt#9igjgp");
            if (i15 == 4) {
                z20 = true;
            } else {
                z20 = false;
            }
            objRememberedValue6 = composer3.rememberedValue();
            if (z20) {
                objRememberedValue6 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda59
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SearchScreenKt.SearchScreen$lambda$14$0(store2, (String) obj);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue6);
            } else {
                objRememberedValue6 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda59
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SearchScreenKt.SearchScreen$lambda$14$0(store2, (String) obj);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue6);
            }
            Function1 function2111117 = (Function1) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerStart(composer3, -1792833263, "CC(remember):SearchScreen.kt#9igjgp");
            i18 = i16;
            if ((i18 & 896) == 256) {
                z21 = true;
            } else {
                z21 = false;
            }
            objRememberedValue7 = composer3.rememberedValue();
            if (z21) {
                objRememberedValue7 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda60
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SearchScreenKt.SearchScreen$lambda$15$0(onDismissSearch);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue7);
            } else {
                objRememberedValue7 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda60
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SearchScreenKt.SearchScreen$lambda$15$0(onDismissSearch);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue7);
            }
            Function0 function2111118 = (Function0) objRememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerStart(composer3, -1792830564, "CC(remember):SearchScreen.kt#9igjgp");
            boolean zChanged1113 = composer3.changed(state2);
            if (i15 == 4) {
                z22 = true;
            } else {
                z22 = false;
            }
            z23 = zChanged1113 | z22;
            objRememberedValue8 = composer3.rememberedValue();
            if (z23) {
                objRememberedValue8 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda61
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SearchScreenKt.SearchScreen$lambda$16$0(store2, state2, (SearchMode) obj);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue8);
            } else {
                objRememberedValue8 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda61
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SearchScreenKt.SearchScreen$lambda$16$0(store2, state2, (SearchMode) obj);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue8);
            }
            Function1 function311119 = (Function1) objRememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerStart(composer3, -1792838764, "CC(remember):SearchScreen.kt#9igjgp");
            boolean zChanged1114 = composer3.changed(state2);
            if (i15 == 4) {
                z24 = true;
            } else {
                z24 = false;
            }
            z25 = zChanged1114 | z24;
            objRememberedValue9 = composer3.rememberedValue();
            if (z25) {
                objRememberedValue9 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda62
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SearchScreenKt.SearchScreen$lambda$17$0(store2, state2);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue9);
            } else {
                objRememberedValue9 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda62
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SearchScreenKt.SearchScreen$lambda$17$0(store2, state2);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue9);
            }
            Function0 function3111110 = (Function0) objRememberedValue9;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerStart(composer3, -1792823653, "CC(remember):SearchScreen.kt#9igjgp");
            if (i15 == 4) {
                z26 = true;
            } else {
                z26 = false;
            }
            objRememberedValue10 = composer3.rememberedValue();
            if (z26) {
                objRememberedValue10 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda63
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SearchScreenKt.SearchScreen$lambda$18$0(store2, (String) obj);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue10);
            } else {
                objRememberedValue10 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda63
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SearchScreenKt.SearchScreen$lambda$18$0(store2, (String) obj);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue10);
            }
            Function1 function3111111 = (Function1) objRememberedValue10;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerStart(composer3, -1792819685, "CC(remember):SearchScreen.kt#9igjgp");
            if (i15 == 4) {
                z27 = true;
            } else {
                z27 = false;
            }
            objRememberedValue11 = composer3.rememberedValue();
            if (z27) {
                objRememberedValue11 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda48
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SearchScreenKt.SearchScreen$lambda$19$0(store2, (String) obj);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue11);
            } else {
                objRememberedValue11 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda48
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SearchScreenKt.SearchScreen$lambda$19$0(store2, (String) obj);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue11);
            }
            Function1 function3111112 = (Function1) objRememberedValue11;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerStart(composer3, -1792815648, "CC(remember):SearchScreen.kt#9igjgp");
            if (i15 == 4) {
                z28 = true;
            } else {
                z28 = false;
            }
            objRememberedValue12 = composer3.rememberedValue();
            if (z28) {
                objRememberedValue12 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda49
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SearchScreenKt.SearchScreen$lambda$20$0(store2, (String) obj);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue12);
            } else {
                objRememberedValue12 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda49
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SearchScreenKt.SearchScreen$lambda$20$0(store2, (String) obj);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue12);
            }
            Function1 function3111113 = (Function1) objRememberedValue12;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerStart(composer3, -1792812683, "CC(remember):SearchScreen.kt#9igjgp");
            if (i15 == 4) {
                z29 = true;
            } else {
                z29 = false;
            }
            objRememberedValue13 = composer3.rememberedValue();
            if (z29) {
                objRememberedValue13 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda50
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SearchScreenKt.SearchScreen$lambda$21$0(store2);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue13);
            } else {
                objRememberedValue13 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda50
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SearchScreenKt.SearchScreen$lambda$21$0(store2);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue13);
            }
            Function0 function3111114 = (Function0) objRememberedValue13;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerStart(composer3, -1792809899, "CC(remember):SearchScreen.kt#9igjgp");
            if (i15 == 4) {
                z30 = true;
            } else {
                z30 = false;
            }
            objRememberedValue14 = composer3.rememberedValue();
            if (z30) {
                objRememberedValue14 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda51
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SearchScreenKt.SearchScreen$lambda$22$0(store2);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue14);
            } else {
                objRememberedValue14 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda51
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SearchScreenKt.SearchScreen$lambda$22$0(store2);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue14);
            }
            Function0 function3111115 = (Function0) objRememberedValue14;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerStart(composer3, -1792805157, "CC(remember):SearchScreen.kt#9igjgp");
            if (i15 == 4) {
            }
            objRememberedValue15 = composer3.rememberedValue();
            if (z31) {
                objRememberedValue15 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda52
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SearchScreenKt.SearchScreen$lambda$23$0(store2, (FilesSearchFilters.FilterType) obj);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue15);
            } else {
                objRememberedValue15 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda52
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SearchScreenKt.SearchScreen$lambda$23$0(store2, (FilesSearchFilters.FilterType) obj);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue15);
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            Composer composer11 = composer3;
            SearchScreenContent(query8, searchModeState9, screenState8, identifiedList8, recentQueries8, recentAiSessions8, z16, snackbarHostState, enabledTabs8, zIsSelecting8, zIsAiAtSearchEnabled8, function2111113, function2111114, function2111115, function2111116, function2111112, function2111117, function2111118, function311119, function3111110, function3111111, function3111112, function3111113, function3111114, function3111115, (Function1) objRememberedValue15, function22, z5, composer11, 12582912, 0, (i18 << 18) & 29360128, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function13 = function19;
            composer2 = composer11;
            function9 = function18;
            function12 = function20;
            function11 = function17;
            z4 = z5;
            function10 = function21;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            function9 = function5;
            z4 = z2;
            composer2 = composerStartRestartGroup;
            function10 = function6;
            function11 = function8;
            function12 = function7;
            function13 = function3;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda53
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchScreenKt.SearchScreen$lambda$24(store, z4, onDismissSearch, function10, function12, function13, function11, function9, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Store SearchScreen$lambda$3$0(Store store, String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return store.scope(new PropertyReference1Impl() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$SearchScreen$scopedStoreProvider$1$1$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((SearchReducer.State) obj).getSearchItems();
            }
        }, id, SearchScreenKt$SearchScreen$scopedStoreProvider$1$1$2.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchScreen$lambda$12$0(Store store) {
        store.send(SearchReducer.Action.PerformSearch.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchScreen$lambda$13$0(Store store) {
        store.send(SearchReducer.Action.LoadMoreResults.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchScreen$lambda$14$0(Store store, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        store.send(new SearchReducer.Action.SearchQueryChanged(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchScreen$lambda$17$0(Store store, State state) {
        if (!StringsKt.isBlank(SearchScreen$lambda$1(state).getQuery())) {
            store.send(new SearchReducer.Action.SaveSearchQuery(SearchScreen$lambda$1(state).getQuery()));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchScreen$lambda$15$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchScreen$lambda$16$0(Store store, State state, SearchMode searchMode) {
        Intrinsics.checkNotNullParameter(searchMode, "searchMode");
        if (!Intrinsics.areEqual(searchMode, SearchModeStateKt.toSearchMode(SearchScreen$lambda$1(state).getSearchModeState()))) {
            store.send(new SearchReducer.Action.UpdateSearchMode(searchMode));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchScreen$lambda$18$0(Store store, String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        store.send(new SearchReducer.Action.DeleteRecentQuery(query));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchScreen$lambda$19$0(Store store, String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        store.send(new SearchReducer.Action.RecentItemClicked(query));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchScreen$lambda$20$0(Store store, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        store.send(new SearchReducer.Action.RecentAiSessionClicked(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchScreen$lambda$21$0(Store store) {
        store.send(SearchReducer.Action.AskBoxAiClicked.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchScreen$lambda$22$0(Store store) {
        store.send(new SearchReducer.Action.FilesSearch(FilesSearchReducer.Action.FiltersButtonClicked.INSTANCE));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchScreen$lambda$23$0(Store store, FilesSearchFilters.FilterType chip) {
        Intrinsics.checkNotNullParameter(chip, "chip");
        store.send(new SearchReducer.Action.FilesSearch(new FilesSearchReducer.Action.RemoveFilter(chip)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchScreen$lambda$10$0(Store store) {
        store.send(SearchReducer.Action.ClearFiltersClicked.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchScreenContent$lambda$0$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchScreenContent$lambda$1$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchScreenContent$lambda$3$0(FilesSearchFilters.FilterType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:200:0x024e  */
    /* JADX WARN: Code duplicated, block: B:201:0x0253  */
    /* JADX WARN: Code duplicated, block: B:203:0x0259  */
    /* JADX WARN: Code duplicated, block: B:205:0x025f  */
    /* JADX WARN: Code duplicated, block: B:209:0x0269  */
    /* JADX WARN: Code duplicated, block: B:210:0x026e  */
    /* JADX WARN: Code duplicated, block: B:212:0x0274  */
    /* JADX WARN: Code duplicated, block: B:215:0x027b  */
    /* JADX WARN: Code duplicated, block: B:219:0x0285  */
    /* JADX WARN: Code duplicated, block: B:220:0x028a  */
    /* JADX WARN: Code duplicated, block: B:222:0x0290  */
    /* JADX WARN: Code duplicated, block: B:224:0x0296  */
    /* JADX WARN: Code duplicated, block: B:225:0x0299  */
    /* JADX WARN: Code duplicated, block: B:235:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:238:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:240:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:242:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:244:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:246:0x02f0  */
    /* JADX WARN: Code duplicated, block: B:248:0x0302  */
    /* JADX WARN: Code duplicated, block: B:250:0x0312  */
    /* JADX WARN: Code duplicated, block: B:252:0x0316  */
    /* JADX WARN: Code duplicated, block: B:254:0x0328  */
    /* JADX WARN: Code duplicated, block: B:256:0x0336  */
    /* JADX WARN: Code duplicated, block: B:258:0x033a  */
    /* JADX WARN: Code duplicated, block: B:260:0x034c  */
    /* JADX WARN: Code duplicated, block: B:262:0x035b  */
    /* JADX WARN: Code duplicated, block: B:264:0x035f  */
    /* JADX WARN: Code duplicated, block: B:265:0x0363  */
    /* JADX WARN: Code duplicated, block: B:267:0x0367  */
    /* JADX WARN: Code duplicated, block: B:268:0x036b  */
    /* JADX WARN: Code duplicated, block: B:271:0x0373  */
    /* JADX WARN: Code duplicated, block: B:274:0x039c  */
    /* JADX WARN: Code duplicated, block: B:275:0x03b4  */
    /* JADX WARN: Code duplicated, block: B:278:0x044e  */
    /* JADX WARN: Code duplicated, block: B:280:0x045c  */
    /* JADX WARN: Code duplicated, block: B:283:0x0473  */
    /* JADX WARN: Code duplicated, block: B:285:? A[RETURN, SYNTHETIC] */
    private static final void SearchScreenContent(final String str, final SearchModeState searchModeState, final SearchReducer.ScreenState screenState, final List<SearchItemReducer.State> list, final List<String> list2, final List<AiRecentSession> list3, final boolean z, final SnackbarHostState snackbarHostState, final List<? extends SearchMode> list4, final boolean z2, final boolean z3, final Function1<? super ItemId.Remote, Boolean> function1, final Function1<? super String, Boolean> function2, final Function0<Unit> function0, final Function0<Unit> function3, final Function1<? super String, Store<SearchItemReducer.State, SearchItemReducer.Action>> function4, final Function1<? super String, Unit> function5, final Function0<Unit> function6, final Function1<? super SearchMode, Unit> function7, final Function0<Unit> function8, Function1<? super String, Unit> function9, Function1<? super String, Unit> function10, final Function1<? super String, Unit> function11, final Function0<Unit> function12, Function0<Unit> function13, Function1<? super FilesSearchFilters.FilterType, Unit> function14, Function0<Unit> function15, boolean z4, Composer composer, final int i, final int i2, final int i3, final int i4) {
        int i5;
        SearchModeState searchModeState2;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z5;
        Composer composer2;
        final Function1<? super String, Unit> function16;
        final Function1<? super String, Unit> function17;
        final Function0<Unit> function18;
        final Function1<? super FilesSearchFilters.FilterType, Unit> function19;
        final Function0<Unit> function20;
        final boolean z6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final Function1<? super String, Unit> function21;
        Function0<Unit> function22;
        final Function1<? super FilesSearchFilters.FilterType, Unit> function23;
        final Function0<Unit> function24;
        final boolean z7;
        long jM11499getAppBackgroundAlt0d7_KjU;
        Object objRememberedValue;
        Object objRememberedValue2;
        Object objRememberedValue3;
        Object objRememberedValue4;
        Composer composerStartRestartGroup = composer.startRestartGroup(643220047);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SearchScreenContent)N(searchBarText,searchModeState,screenState,resultList,recentQueries,recentAiSessions,canLoadMore,snackbarHostState,enabledTabs,isSelecting,isAiEnabled,isItemSelected,isHubSelected,onRetry,onLoadMore,scopedStoreProvider,onSearchBarTextUpdated,onDismissSearch,onSearchModeChanged,onSearchSubmitted,onDeleteRecentQuery,onRecentQuerySelected,onRecentAiSessionClicked,onAskBoxAiClicked,onFiltersButtonClick,onRemoveFilesFilter,onClearFilters,isRedesignedVersion)286@12670L2,287@12720L2,290@12857L2,291@12928L2,302@13287L342,301@13221L47,313@13801L4731,297@13095L5437:SearchScreen.kt#vkhrzj");
        if ((i & 6) == 0) {
            i5 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i5 = i;
        }
        if ((i & 48) == 0) {
            searchModeState2 = searchModeState;
            i5 |= composerStartRestartGroup.changed(searchModeState2) ? 32 : 16;
        } else {
            searchModeState2 = searchModeState;
        }
        if ((i & 384) == 0) {
            i5 |= composerStartRestartGroup.changed(screenState) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(list) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(list2) ? 16384 : 8192;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(list3) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i5 |= composerStartRestartGroup.changed(z) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i5 |= composerStartRestartGroup.changed(snackbarHostState) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(list4) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i5 |= composerStartRestartGroup.changed(z2) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if ((i2 & 6) == 0) {
            i6 = i2 | (composerStartRestartGroup.changed(z3) ? 4 : 2);
        } else {
            i6 = i2;
        }
        if ((i2 & 48) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(function3) ? 16384 : 8192;
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(function4) ? 131072 : 65536;
        }
        if ((i2 & 1572864) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(function5) ? 1048576 : 524288;
        }
        if ((i2 & 12582912) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(function6) ? 8388608 : 4194304;
        }
        if ((i2 & 100663296) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(function7) ? 67108864 : 33554432;
        }
        if ((i2 & 805306368) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(function8) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        int i13 = i6;
        int i14 = i4 & 1048576;
        if (i14 != 0) {
            i7 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i7 = i3 | (composerStartRestartGroup.changedInstance(function9) ? 4 : 2);
        } else {
            i7 = i3;
        }
        int i15 = i4 & 2097152;
        if (i15 != 0) {
            i7 |= 48;
        } else if ((i3 & 48) == 0) {
            i7 |= composerStartRestartGroup.changedInstance(function10) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i7 |= composerStartRestartGroup.changedInstance(function11) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i7 |= composerStartRestartGroup.changedInstance(function12) ? 2048 : 1024;
        }
        int i16 = i7;
        int i17 = i4 & 16777216;
        if (i17 == 0) {
            i8 = i16;
            if ((i3 & 24576) == 0) {
                i8 |= composerStartRestartGroup.changedInstance(function13) ? 16384 : 8192;
            }
            i9 = i4 & 33554432;
            if (i9 != 0) {
                i8 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                i8 |= composerStartRestartGroup.changedInstance(function14) ? 131072 : 65536;
            }
            i10 = i4 & 67108864;
            if (i10 != 0) {
                i8 |= 1572864;
            } else if ((i3 & 1572864) == 0) {
                i8 |= composerStartRestartGroup.changedInstance(function15) ? 1048576 : 524288;
            }
            i11 = i4 & C.BUFFER_FLAG_FIRST_SAMPLE;
            if (i11 != 0) {
                i8 |= 12582912;
            } else if ((i3 & 12582912) == 0) {
                if (composerStartRestartGroup.changed(z4)) {
                    i12 = 8388608;
                } else {
                    i12 = 4194304;
                }
                i8 |= i12;
            }
            if ((i5 & 306783379) != 306783378 && (306783379 & i13) == 306783378 && (i8 & 4793491) == 4793490) {
                z5 = false;
            } else {
                z5 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i5 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function16 = function9;
                function17 = function10;
                function18 = function13;
                function19 = function14;
                function20 = function15;
                z6 = z4;
            } else {
                if (i14 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -340798063, "CC(remember):SearchScreen.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda67
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreenContent$lambda$0$0((String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function16 = (Function1) objRememberedValue4;
                } else {
                    function16 = function9;
                }
                if (i15 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -340796463, "CC(remember):SearchScreen.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreenContent$lambda$1$0((String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function21 = (Function1) objRememberedValue3;
                } else {
                    function21 = function10;
                }
                if (i17 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -340792079, "CC(remember):SearchScreen.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    function22 = (Function0) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function22 = function13;
                }
                if (i9 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -340789807, "CC(remember):SearchScreen.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchScreenKt.SearchScreenContent$lambda$3$0((FilesSearchFilters.FilterType) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function23 = (Function1) objRememberedValue;
                } else {
                    function23 = function14;
                }
                if (i10 != 0) {
                    function24 = null;
                } else {
                    function24 = function15;
                }
                if (i11 != 0) {
                    z7 = false;
                } else {
                    z7 = z4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(643220047, i5, i13, "com.box.android.search.presentation.ui.SearchScreenContent (SearchScreen.kt:294)");
                }
                final SearchModeConfig searchModeConfigFrom = SearchModeConfig.INSTANCE.from(SearchModeStateKt.toSearchMode(searchModeState2));
                Modifier modifierTestTag = TestTagKt.testTag(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), "SearchScreen");
                WindowInsets WindowInsets = WindowInsetsKt.WindowInsets();
                if (z7) {
                    composerStartRestartGroup.startReplaceGroup(-340763716);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "312@13736L6");
                    jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11498getAppBackground0d7_KjU();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-340762593);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "312@13771L6");
                    jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11499getAppBackgroundAlt0d7_KjU();
                }
                composerStartRestartGroup.endReplaceGroup();
                final Function0<Unit> function25 = function22;
                final SearchModeState searchModeState3 = searchModeState2;
                Function1<? super FilesSearchFilters.FilterType, Unit> function26 = function23;
                composer2 = composerStartRestartGroup;
                ScaffoldKt.m4038ScaffoldTvnljyQ(modifierTestTag, ComposableLambdaKt.rememberComposableLambda(1140630803, true, new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SearchScreenKt.SearchScreenContent$lambda$4(searchModeConfigFrom, str, function5, function6, function8, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-34293739, true, new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SearchScreenKt.SearchScreenContent$lambda$5(snackbarHostState, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), null, 0, jM11499getAppBackgroundAlt0d7_KjU, 0L, WindowInsets, ComposableLambdaKt.rememberComposableLambda(-1827294626, true, new Function3() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return SearchScreenKt.SearchScreenContent$lambda$6(z3, str, function12, searchModeState3, function25, function23, list4, searchModeConfigFrom, function7, screenState, list, z, function3, function4, z2, function1, function2, list2, function21, function16, list3, function11, z7, function0, function24, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, 805309494, 180);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function18 = function25;
                function19 = function26;
                function17 = function21;
                z6 = z7;
                function20 = function24;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Function1<? super String, Unit> function27 = function16;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SearchScreenKt.SearchScreenContent$lambda$7(str, searchModeState, screenState, list, list2, list3, z, snackbarHostState, list4, z2, z3, function1, function2, function0, function3, function4, function5, function6, function7, function8, function27, function17, function11, function12, function18, function19, function20, z6, i, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i8 = i16 | 24576;
        i9 = i4 & 33554432;
        if (i9 != 0) {
            i8 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i8 |= composerStartRestartGroup.changedInstance(function14) ? 131072 : 65536;
        }
        i10 = i4 & 67108864;
        if (i10 != 0) {
            i8 |= 1572864;
        } else if ((i3 & 1572864) == 0) {
            i8 |= composerStartRestartGroup.changedInstance(function15) ? 1048576 : 524288;
        }
        i11 = i4 & C.BUFFER_FLAG_FIRST_SAMPLE;
        if (i11 != 0) {
            i8 |= 12582912;
        } else if ((i3 & 12582912) == 0) {
            if (composerStartRestartGroup.changed(z4)) {
                i12 = 8388608;
            } else {
                i12 = 4194304;
            }
            i8 |= i12;
        }
        if ((i5 & 306783379) != 306783378) {
            z5 = true;
        } else {
            z5 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z5, i5 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            function16 = function9;
            function17 = function10;
            function18 = function13;
            function19 = function14;
            function20 = function15;
            z6 = z4;
        } else {
            if (i14 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -340798063, "CC(remember):SearchScreen.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda67
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreenContent$lambda$0$0((String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                function16 = (Function1) objRememberedValue4;
            } else {
                function16 = function9;
            }
            if (i15 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -340796463, "CC(remember):SearchScreen.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreenContent$lambda$1$0((String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                function21 = (Function1) objRememberedValue3;
            } else {
                function21 = function10;
            }
            if (i17 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -340792079, "CC(remember):SearchScreen.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                function22 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                function22 = function13;
            }
            if (i9 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -340789807, "CC(remember):SearchScreen.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SearchScreenKt.SearchScreenContent$lambda$3$0((FilesSearchFilters.FilterType) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                function23 = (Function1) objRememberedValue;
            } else {
                function23 = function14;
            }
            if (i10 != 0) {
                function24 = null;
            } else {
                function24 = function15;
            }
            if (i11 != 0) {
                z7 = false;
            } else {
                z7 = z4;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(643220047, i5, i13, "com.box.android.search.presentation.ui.SearchScreenContent (SearchScreen.kt:294)");
            }
            final SearchModeConfig searchModeConfigFrom2 = SearchModeConfig.INSTANCE.from(SearchModeStateKt.toSearchMode(searchModeState2));
            Modifier modifierTestTag2 = TestTagKt.testTag(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), "SearchScreen");
            WindowInsets WindowInsets2 = WindowInsetsKt.WindowInsets();
            if (z7) {
                composerStartRestartGroup.startReplaceGroup(-340763716);
                ComposerKt.sourceInformation(composerStartRestartGroup, "312@13736L6");
                jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11498getAppBackground0d7_KjU();
            } else {
                composerStartRestartGroup.startReplaceGroup(-340762593);
                ComposerKt.sourceInformation(composerStartRestartGroup, "312@13771L6");
                jM11499getAppBackgroundAlt0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11499getAppBackgroundAlt0d7_KjU();
            }
            composerStartRestartGroup.endReplaceGroup();
            final Function0 function28 = function22;
            final SearchModeState searchModeState4 = searchModeState2;
            Function1<? super FilesSearchFilters.FilterType, Unit> function29 = function23;
            composer2 = composerStartRestartGroup;
            ScaffoldKt.m4038ScaffoldTvnljyQ(modifierTestTag2, ComposableLambdaKt.rememberComposableLambda(1140630803, true, new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchScreenKt.SearchScreenContent$lambda$4(searchModeConfigFrom2, str, function5, function6, function8, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-34293739, true, new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchScreenKt.SearchScreenContent$lambda$5(snackbarHostState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, 0, jM11499getAppBackgroundAlt0d7_KjU, 0L, WindowInsets2, ComposableLambdaKt.rememberComposableLambda(-1827294626, true, new Function3() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SearchScreenKt.SearchScreenContent$lambda$6(z3, str, function12, searchModeState4, function28, function23, list4, searchModeConfigFrom2, function7, screenState, list, z, function3, function4, z2, function1, function2, list2, function21, function16, list3, function11, z7, function0, function24, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, 805309494, 180);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function18 = function28;
            function19 = function29;
            function17 = function21;
            z6 = z7;
            function20 = function24;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function1 function210 = function16;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchScreenKt.SearchScreenContent$lambda$7(str, searchModeState, screenState, list, list2, list3, z, snackbarHostState, list4, z2, z3, function1, function2, function0, function3, function4, function5, function6, function7, function8, function210, function17, function11, function12, function18, function19, function20, z6, i, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchScreenContent$lambda$5(SnackbarHostState snackbarHostState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C301@13223L43:SearchScreen.kt#vkhrzj");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-34293739, i, -1, "com.box.android.search.presentation.ui.SearchScreenContent.<anonymous> (SearchScreen.kt:301)");
            }
            SnackbarHostKt.SnackbarHost(snackbarHostState, null, null, composer, 0, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchScreenContent$lambda$4(SearchModeConfig searchModeConfig, String str, Function1 function1, Function0 function0, Function0 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C305@13395L39,303@13301L318:SearchScreen.kt#vkhrzj");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1140630803, i, -1, "com.box.android.search.presentation.ui.SearchScreenContent.<anonymous> (SearchScreen.kt:303)");
            }
            SearchBar(str, StringResources_androidKt.stringResource(searchModeConfig.getSearchBarHintRes(), composer, 0), function1, function0, function2, composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchScreenContent$lambda$6(final boolean z, final String str, final Function0 function0, final SearchModeState searchModeState, final Function0 function1, final Function1 function2, List list, final SearchModeConfig searchModeConfig, Function1 function3, final SearchReducer.ScreenState screenState, final List list2, final boolean z2, final Function0 function4, final Function1 function5, final boolean z3, final Function1 function6, final Function1 function7, final List list3, final Function1 function8, final Function1 function9, final List list4, final Function1 function10, final boolean z4, final Function0 function11, final Function0 function12, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "CN(paddingValues)314@13867L493,404@17829L697:SearchScreen.kt#vkhrzj");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1827294626, i2, -1, "com.box.android.search.presentation.ui.SearchScreenContent.<anonymous> (SearchScreen.kt:314)");
            }
            final ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-275630473, true, new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchScreenKt.SearchScreenContent$lambda$6$0(z, str, function0, searchModeState, function1, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1423016785, "C:SearchScreen.kt#vkhrzj");
            if (list.size() > 1) {
                composer.startReplaceGroup(-1422993753);
                ComposerKt.sourceInformation(composer, "411@18208L231,406@17924L515");
                CommonTabsScreenKt.m11833CommonTabsScreenDuhZ5jU(list, searchModeConfig.getSearchMode(), new Function3() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return SearchScreenKt.SearchScreenContent$lambda$6$8$0((SearchMode) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, null, false, 0, 0L, 0L, 0L, 0L, null, null, function3, null, ComposableLambdaKt.rememberComposableLambda(-814305131, true, new Function3() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return SearchScreenKt.SearchScreenContent$lambda$6$8$1(searchModeConfig, screenState, list2, z2, function4, function5, z3, function6, function7, composableLambdaRememberComposableLambda, list3, function8, function9, list4, function10, z4, function11, z, function12, (SearchMode) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54), composer, 0, 24576, 12280);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1422460367);
                ComposerKt.sourceInformation(composer, "419@18477L25");
                SearchScreenContent$lambda$6$HandleSearchScreenState(screenState, list2, z2, function4, function5, z3, function6, function7, composableLambdaRememberComposableLambda, searchModeConfig, list3, function8, function9, list4, function10, z4, function11, z, function12, composer, 0);
                composer.endReplaceGroup();
            }
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
    public static final Unit SearchScreenContent$lambda$6$0(boolean z, String str, Function0 function0, SearchModeState searchModeState, Function0 function1, Function1 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C315@13881L469:SearchScreen.kt#vkhrzj");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-275630473, i, -1, "com.box.android.search.presentation.ui.SearchScreenContent.<anonymous>.<anonymous> (SearchScreen.kt:315)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -713594424, "C322@14112L224:SearchScreen.kt#vkhrzj");
            if (!z) {
                composer.startReplaceGroup(-727403499);
            } else {
                composer.startReplaceGroup(-713585559);
                ComposerKt.sourceInformation(composer, "317@13945L132");
                AskBoxAiRowKt.AskBoxAiRow(str, function0, null, composer, 0, 4);
            }
            composer.endReplaceGroup();
            SearchResultsHeaderKt.SearchResultsHeader(searchModeState, function1, function2, composer, 0);
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

    private static final void SearchScreenContent$lambda$6$HandleSearchScreenState(final SearchReducer.ScreenState screenState, List<SearchItemReducer.State> list, boolean z, Function0<Unit> function0, Function1<? super String, Store<SearchItemReducer.State, SearchItemReducer.Action>> function1, boolean z2, Function1<? super ItemId.Remote, Boolean> function2, Function1<? super String, Boolean> function3, Function2<? super Composer, ? super Integer, Unit> function4, SearchModeConfig searchModeConfig, List<String> list2, final Function1<? super String, Unit> function5, Function1<? super String, Unit> function6, List<AiRecentSession> list3, final Function1<? super String, Unit> function7, final boolean z3, final Function0<Unit> function8, final boolean z4, final Function0<Unit> function9, Composer composer, int i) {
        String strStringResource;
        ComposerKt.sourceInformationMarkerStart(composer, 1588258721, "C(HandleSearchScreenState):SearchScreen.kt#vkhrzj");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1588258721, i, -1, "com.box.android.search.presentation.ui.SearchScreenContent.<anonymous>.HandleSearchScreenState (SearchScreen.kt:331)");
        }
        if (screenState instanceof SearchReducer.ScreenState.Loaded) {
            composer.startReplaceGroup(-1839008024);
            ComposerKt.sourceInformation(composer, "334@14532L465");
            BoxSearchListingContent(list, z, function0, function1, z2, function2, function3, function4, composer, 12582912, 0);
            composer.endReplaceGroup();
        } else if (screenState instanceof SearchReducer.ScreenState.RecentQueries) {
            composer.startReplaceGroup(-1838433594);
            ComposerKt.sourceInformation(composer, "347@15138L7,351@15388L147,358@15814L52,348@15166L722");
            ProvidableCompositionLocal<FocusManager> localFocusManager = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localFocusManager);
            ComposerKt.sourceInformationMarkerEnd(composer);
            final FocusManager focusManager = (FocusManager) objConsume;
            Integer recentQueriesTitleRes = searchModeConfig.getRecentQueriesTitleRes();
            String strStringResource2 = null;
            if (recentQueriesTitleRes == null) {
                composer.startReplaceGroup(-1838275898);
                composer.endReplaceGroup();
                strStringResource = null;
            } else {
                composer.startReplaceGroup(-1838275897);
                ComposerKt.sourceInformation(composer, "*349@15269L18");
                strStringResource = StringResources_androidKt.stringResource(recentQueriesTitleRes.intValue(), composer, 0);
                composer.endReplaceGroup();
            }
            Integer recentAiSessionsTitleRes = searchModeConfig.getRecentAiSessionsTitleRes();
            if (recentAiSessionsTitleRes == null) {
                composer.startReplaceGroup(-1837863226);
            } else {
                composer.startReplaceGroup(-1837863225);
                ComposerKt.sourceInformation(composer, "*356@15685L18");
                strStringResource2 = StringResources_androidKt.stringResource(recentAiSessionsTitleRes.intValue(), composer, 0);
            }
            composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart(composer, 1603272884, "CC(remember):SearchScreen.kt#9igjgp");
            boolean zChanged = composer.changed(function5) | composer.changedInstance(focusManager);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SearchScreenKt.SearchScreenContent$lambda$6$HandleSearchScreenState$3$0(function5, focusManager, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function10 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1603286421, "CC(remember):SearchScreen.kt#9igjgp");
            boolean zChanged2 = composer.changed(function7);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda33
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SearchScreenKt.SearchScreenContent$lambda$6$HandleSearchScreenState$4$0(function7, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SearchRecentsScreen(strStringResource, strStringResource2, list2, function10, function6, list3, (Function1) objRememberedValue2, composer, 0);
            composer.endReplaceGroup();
        } else if (screenState instanceof SearchReducer.ScreenState.Error) {
            composer.startReplaceGroup(-1837559704);
            ComposerKt.sourceInformation(composer, "363@16024L681,363@15984L721");
            ScrollableStateScreenWithHeader(function4, ComposableLambdaKt.rememberComposableLambda(1461882820, true, new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda44
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchScreenKt.SearchScreenContent$lambda$6$HandleSearchScreenState$5(screenState, function8, z3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 54);
            composer.endReplaceGroup();
        } else if (screenState instanceof SearchReducer.ScreenState.EmptyResults) {
            composer.startReplaceGroup(-1836754572);
            ComposerKt.sourceInformation(composer, "379@16848L285,379@16808L325");
            ScrollableStateScreenWithHeader(function4, ComposableLambdaKt.rememberComposableLambda(1028190021, true, new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda55
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchScreenKt.SearchScreenContent$lambda$6$HandleSearchScreenState$6(z4, z3, function9, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 54);
            composer.endReplaceGroup();
        } else if (screenState instanceof SearchReducer.ScreenState.Loading) {
            composer.startReplaceGroup(-1836340412);
            ComposerKt.sourceInformation(composer, "389@17271L109,389@17231L149");
            ScrollableStateScreenWithHeader(function4, ComposableLambdaKt.rememberComposableLambda(594497222, true, new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda64
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchScreenKt.SearchScreenContent$lambda$6$HandleSearchScreenState$7(z3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 54);
            composer.endReplaceGroup();
        } else {
            if (!(screenState instanceof SearchReducer.ScreenState.Blank)) {
                composer.startReplaceGroup(1603245585);
                composer.endReplaceGroup();
                throw new NoWhenBranchMatchedException();
            }
            composer.startReplaceGroup(-1836092629);
            ComposerKt.sourceInformation(composer, "397@17578L41,398@17645L44,395@17476L302");
            EmptyQuerySearchScreen(searchModeConfig.getEmptyQueryDrawableRes(), StringResources_androidKt.stringResource(searchModeConfig.getEmptyQueryTitleRes(), composer, 0), StringResources_androidKt.stringResource(searchModeConfig.getEmptyQuerySubtitleRes(), composer, 0), z3, composer, 0, 0);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchScreenContent$lambda$6$HandleSearchScreenState$3$0(Function1 function1, FocusManager focusManager, String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        function1.invoke(query);
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchScreenContent$lambda$6$HandleSearchScreenState$4$0(Function1 function1, String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        function1.invoke(sessionId);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchScreenContent$lambda$6$HandleSearchScreenState$5(SearchReducer.ScreenState screenState, Function0 function0, boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:SearchScreen.kt#vkhrzj");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1461882820, i, -1, "com.box.android.search.presentation.ui.SearchScreenContent.<anonymous>.HandleSearchScreenState.<anonymous> (SearchScreen.kt:364)");
            }
            if (DomainErrorKt.isNetworkConnectionError(((SearchReducer.ScreenState.Error) screenState).getError())) {
                composer.startReplaceGroup(-17212078);
                ComposerKt.sourceInformation(composer, "365@16130L52");
                ItemStateScreensKt.NetworkConnectionError(function0, z, composer, 0, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-17087799);
                ComposerKt.sourceInformation(composer, "367@16244L413");
                ItemStateScreensKt.GenericErrorScreen(function0, z, R.string.search_generic_error_main_text, Integer.valueOf(R.string.search_generic_error_sub_text), 0, "SearchErrorScreen", composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 16);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchScreenContent$lambda$6$HandleSearchScreenState$6(boolean z, boolean z2, Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C380@16874L237:SearchScreen.kt#vkhrzj");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1028190021, i, -1, "com.box.android.search.presentation.ui.SearchScreenContent.<anonymous>.HandleSearchScreenState.<anonymous> (SearchScreen.kt:380)");
            }
            EmptyResultsSearchScreen(z, z2, function0, composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchScreenContent$lambda$6$HandleSearchScreenState$7(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C390@17297L61:SearchScreen.kt#vkhrzj");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(594497222, i, -1, "com.box.android.search.presentation.ui.SearchScreenContent.<anonymous>.HandleSearchScreenState.<anonymous> (SearchScreen.kt:390)");
            }
            ItemStateScreensKt.LoadingItemsScreen(null, z, composer, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String SearchScreenContent$lambda$6$8$0(SearchMode it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.startReplaceGroup(-1802245609);
        ComposerKt.sourceInformation(composer, "CN(it)409@18072L52:SearchScreen.kt#vkhrzj");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1802245609, i, -1, "com.box.android.search.presentation.ui.SearchScreenContent.<anonymous>.<anonymous>.<anonymous> (SearchScreen.kt:409)");
        }
        String strStringResource = StringResources_androidKt.stringResource(SearchModeConfig.INSTANCE.from(it).getTabNameRes(), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return strStringResource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchScreenContent$lambda$6$8$1(SearchModeConfig searchModeConfig, SearchReducer.ScreenState screenState, List list, boolean z, Function0 function0, Function1 function1, boolean z2, Function1 function2, Function1 function3, Function2 function4, List list2, Function1 function5, Function1 function6, List list3, Function1 function7, boolean z3, Function0 function8, boolean z4, Function0 function9, SearchMode tab, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        ComposerKt.sourceInformation(composer, "CN(tab):SearchScreen.kt#vkhrzj");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-814305131, i, -1, "com.box.android.search.presentation.ui.SearchScreenContent.<anonymous>.<anonymous>.<anonymous> (SearchScreen.kt:412)");
        }
        if (Intrinsics.areEqual(tab, searchModeConfig.getSearchMode())) {
            composer.startReplaceGroup(-988809020);
            ComposerKt.sourceInformation(composer, "413@18293L25");
            SearchScreenContent$lambda$6$HandleSearchScreenState(screenState, list, z, function0, function1, z2, function2, function3, function4, searchModeConfig, list2, function5, function6, list3, function7, z3, function8, z4, function9, composer, 0);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-988730590);
            ComposerKt.sourceInformation(composer, "415@18372L27");
            BoxKt.Box(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composer, 6);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    private static final void ScrollableStateScreenWithHeader(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1093661104);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ScrollableStateScreenWithHeader)N(header,content):SearchScreen.kt#vkhrzj");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1093661104, i2, -1, "com.box.android.search.presentation.ui.ScrollableStateScreenWithHeader (SearchScreen.kt:433)");
            }
            if (function2 == null) {
                composerStartRestartGroup.startReplaceGroup(-363828455);
                ComposerKt.sourceInformation(composerStartRestartGroup, "435@19029L9");
                function3.invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 3) & 14));
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-363775011);
                ComposerKt.sourceInformation(composerStartRestartGroup, "437@19064L21");
                if (ComposeUtilsKt.getIsLandscapePhone(composerStartRestartGroup, 0)) {
                    composerStartRestartGroup.startReplaceGroup(-363746274);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "438@19155L422,438@19101L476");
                    BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, false, ComposableLambdaKt.rememberComposableLambda(936829371, true, new Function3() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return SearchScreenKt.ScrollableStateScreenWithHeader$lambda$0(function2, function3, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 3078, 6);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-363253374);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "452@19607L184");
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -442410845, "C453@19667L8,454@19692L85:SearchScreen.kt#vkhrzj");
                    function2.invoke(composerStartRestartGroup, Integer.valueOf(i2 & 14));
                    Modifier modifierWeight$default = ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -520551826, "C455@19750L9:SearchScreen.kt#vkhrzj");
                    function3.invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 3) & 14));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchScreenKt.ScrollableStateScreenWithHeader$lambda$2(function2, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScrollableStateScreenWithHeader$lambda$0(Function2 function2, Function2 function3, BoxWithConstraintsScope BoxWithConstraints, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation(composer, "C443@19348L21,440@19220L343:SearchScreen.kt#vkhrzj");
        if ((i & 6) == 0) {
            i |= composer.changed(BoxWithConstraints) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(936829371, i, -1, "com.box.android.search.presentation.ui.ScrollableStateScreenWithHeader.<anonymous> (SearchScreen.kt:439)");
            }
            float fMo1100getMaxHeightD9Ej5fM = BoxWithConstraints.mo1100getMaxHeightD9Ej5fM();
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierVerticalScroll$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1090489688, "C445@19411L8,446@19440L105:SearchScreen.kt#vkhrzj");
            function2.invoke(composer, 0);
            Modifier modifierM1252height3ABfNKs = SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, fMo1100getMaxHeightD9Ej5fM);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierM1252height3ABfNKs);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composer);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 573776315, "C447@19514L9:SearchScreen.kt#vkhrzj");
            function3.invoke(composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
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

    /* JADX WARN: Code duplicated, block: B:23:0x0042  */
    /* JADX WARN: Code duplicated, block: B:24:0x0045  */
    /* JADX WARN: Code duplicated, block: B:26:0x0049  */
    /* JADX WARN: Code duplicated, block: B:28:0x0051  */
    /* JADX WARN: Code duplicated, block: B:29:0x0054  */
    /* JADX WARN: Code duplicated, block: B:34:0x0062  */
    /* JADX WARN: Code duplicated, block: B:35:0x0064  */
    /* JADX WARN: Code duplicated, block: B:38:0x006d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0071  */
    /* JADX WARN: Code duplicated, block: B:43:0x0075  */
    /* JADX WARN: Code duplicated, block: B:44:0x0077  */
    /* JADX WARN: Code duplicated, block: B:47:0x007e  */
    /* JADX WARN: Code duplicated, block: B:49:0x0086  */
    /* JADX WARN: Code duplicated, block: B:50:0x009b  */
    /* JADX WARN: Code duplicated, block: B:53:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:58:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:61:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:63:? A[RETURN, SYNTHETIC] */
    private static final void EmptyResultsSearchScreen(final boolean z, boolean z2, Function0<Unit> function0, Composer composer, final int i, final int i2) {
        int i3;
        boolean z3;
        int i4;
        Function0<Unit> function1;
        int i5;
        boolean z4;
        final boolean z5;
        final Function0<Unit> function2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z6;
        Function0<Unit> function3;
        String strStringResource;
        Composer composerStartRestartGroup = composer.startRestartGroup(1455820890);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(EmptyResultsSearchScreen)N(isAiEnabled,isRedesignedVersion,onClearFilters)473@20327L48,469@20141L594:SearchScreen.kt#vkhrzj");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 == 0) {
            if ((i & 48) == 0) {
                z3 = z2;
                i3 |= composerStartRestartGroup.changed(z3) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    function1 = function0;
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i3 & Token.DOTQUERY) != 146) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    z5 = z3;
                    function2 = function1;
                } else {
                    if (i6 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i4 != 0) {
                        function3 = null;
                    } else {
                        function3 = function1;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1455820890, i3, -1, "com.box.android.search.presentation.ui.EmptyResultsSearchScreen (SearchScreen.kt:463)");
                    }
                    if (z) {
                        composerStartRestartGroup.startReplaceGroup(-219456189);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "465@20005L53");
                        strStringResource = StringResources_androidKt.stringResource(R.string.search_no_results_ai_subtext, composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-219381882);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "467@20080L50");
                        strStringResource = StringResources_androidKt.stringResource(R.string.search_no_results_subtext, composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    ItemStateScreensKt.m11654ItemsStateScreenV9fs2A(new ItemsStateConfig(R.drawable.ic_errorstate404140, StringResources_androidKt.stringResource(R.string.search_no_results_title, composerStartRestartGroup, 0), strStringResource, function3 != null ? new ButtonItem.TextButtonItem(false, function3, R.string.search_clear_filters, 1, null) : null), "EmptyResultSearchScreen", SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), false, z6, 0L, composerStartRestartGroup, ((i3 << 9) & 57344) | 432, 40);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z6;
                    function2 = function3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SearchScreenKt.EmptyResultsSearchScreen$lambda$1(z, z5, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            function1 = function0;
            if ((i3 & Token.DOTQUERY) != 146) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                z5 = z3;
                function2 = function1;
            } else {
                if (i6 != 0) {
                    z6 = false;
                } else {
                    z6 = z3;
                }
                if (i4 != 0) {
                    function3 = null;
                } else {
                    function3 = function1;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1455820890, i3, -1, "com.box.android.search.presentation.ui.EmptyResultsSearchScreen (SearchScreen.kt:463)");
                }
                if (z) {
                    composerStartRestartGroup.startReplaceGroup(-219456189);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "465@20005L53");
                    strStringResource = StringResources_androidKt.stringResource(R.string.search_no_results_ai_subtext, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-219381882);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "467@20080L50");
                    strStringResource = StringResources_androidKt.stringResource(R.string.search_no_results_subtext, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                }
                ItemStateScreensKt.m11654ItemsStateScreenV9fs2A(new ItemsStateConfig(R.drawable.ic_errorstate404140, StringResources_androidKt.stringResource(R.string.search_no_results_title, composerStartRestartGroup, 0), strStringResource, function3 != null ? new ButtonItem.TextButtonItem(false, function3, R.string.search_clear_filters, 1, null) : null), "EmptyResultSearchScreen", SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), false, z6, 0L, composerStartRestartGroup, ((i3 << 9) & 57344) | 432, 40);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z6;
                function2 = function3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SearchScreenKt.EmptyResultsSearchScreen$lambda$1(z, z5, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        z3 = z2;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                function1 = function0;
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i3 & Token.DOTQUERY) != 146) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                z5 = z3;
                function2 = function1;
            } else {
                if (i6 != 0) {
                    z6 = false;
                } else {
                    z6 = z3;
                }
                if (i4 != 0) {
                    function3 = null;
                } else {
                    function3 = function1;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1455820890, i3, -1, "com.box.android.search.presentation.ui.EmptyResultsSearchScreen (SearchScreen.kt:463)");
                }
                if (z) {
                    composerStartRestartGroup.startReplaceGroup(-219456189);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "465@20005L53");
                    strStringResource = StringResources_androidKt.stringResource(R.string.search_no_results_ai_subtext, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-219381882);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "467@20080L50");
                    strStringResource = StringResources_androidKt.stringResource(R.string.search_no_results_subtext, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                }
                ItemStateScreensKt.m11654ItemsStateScreenV9fs2A(new ItemsStateConfig(R.drawable.ic_errorstate404140, StringResources_androidKt.stringResource(R.string.search_no_results_title, composerStartRestartGroup, 0), strStringResource, function3 != null ? new ButtonItem.TextButtonItem(false, function3, R.string.search_clear_filters, 1, null) : null), "EmptyResultSearchScreen", SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), false, z6, 0L, composerStartRestartGroup, ((i3 << 9) & 57344) | 432, 40);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z6;
                function2 = function3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SearchScreenKt.EmptyResultsSearchScreen$lambda$1(z, z5, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        function1 = function0;
        if ((i3 & Token.DOTQUERY) != 146) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            z5 = z3;
            function2 = function1;
        } else {
            if (i6 != 0) {
                z6 = false;
            } else {
                z6 = z3;
            }
            if (i4 != 0) {
                function3 = null;
            } else {
                function3 = function1;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1455820890, i3, -1, "com.box.android.search.presentation.ui.EmptyResultsSearchScreen (SearchScreen.kt:463)");
            }
            if (z) {
                composerStartRestartGroup.startReplaceGroup(-219456189);
                ComposerKt.sourceInformation(composerStartRestartGroup, "465@20005L53");
                strStringResource = StringResources_androidKt.stringResource(R.string.search_no_results_ai_subtext, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-219381882);
                ComposerKt.sourceInformation(composerStartRestartGroup, "467@20080L50");
                strStringResource = StringResources_androidKt.stringResource(R.string.search_no_results_subtext, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            ItemStateScreensKt.m11654ItemsStateScreenV9fs2A(new ItemsStateConfig(R.drawable.ic_errorstate404140, StringResources_androidKt.stringResource(R.string.search_no_results_title, composerStartRestartGroup, 0), strStringResource, function3 != null ? new ButtonItem.TextButtonItem(false, function3, R.string.search_clear_filters, 1, null) : null), "EmptyResultSearchScreen", SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), false, z6, 0L, composerStartRestartGroup, ((i3 << 9) & 57344) | 432, 40);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z5 = z6;
            function2 = function3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchScreenKt.EmptyResultsSearchScreen$lambda$1(z, z5, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void BoxSearchListingContent(final List<SearchItemReducer.State> list, final boolean z, final Function0<Unit> function0, final Function1<? super String, Store<SearchItemReducer.State, SearchItemReducer.Action>> function1, final boolean z2, final Function1<? super ItemId.Remote, Boolean> function2, final Function1<? super String, Boolean> function3, Function2<? super Composer, ? super Integer, Unit> function4, Composer composer, final int i, final int i2) {
        int i3;
        final boolean z3;
        Function1<? super String, Store<SearchItemReducer.State, SearchItemReducer.Action>> function5;
        Function1<? super ItemId.Remote, Boolean> function6;
        Function2<? super Composer, ? super Integer, Unit> function7;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function8;
        final Function2<? super Composer, ? super Integer, Unit> function9;
        Composer composerStartRestartGroup = composer.startRestartGroup(-15633161);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxSearchListingContent)N(resultList,canLoadMore,onLoadMore,scopedStoreProvider,isSelecting,isItemSelected,isHubSelected,header)499@21213L23,500@21266L51,508@21558L3798,502@21323L4033:SearchScreen.kt#vkhrzj");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(list) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            z3 = z;
            i3 |= composerStartRestartGroup.changed(z3) ? 32 : 16;
        } else {
            z3 = z;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            function5 = function1;
            i3 |= composerStartRestartGroup.changedInstance(function5) ? 2048 : 1024;
        } else {
            function5 = function1;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            function6 = function2;
            i3 |= composerStartRestartGroup.changedInstance(function6) ? 131072 : 65536;
        } else {
            function6 = function2;
        }
        if ((1572864 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 1048576 : 524288;
        }
        int i4 = i2 & 128;
        if (i4 != 0) {
            i3 |= 12582912;
            function7 = function4;
        } else {
            function7 = function4;
            if ((i & 12582912) == 0) {
                i3 |= composerStartRestartGroup.changedInstance(function7) ? 8388608 : 4194304;
            }
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            function8 = function7;
        } else {
            if (i4 != 0) {
                function7 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-15633161, i3, -1, "com.box.android.search.presentation.ui.BoxSearchListingContent (SearchScreen.kt:498)");
            }
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
            Duration.Companion companion = Duration.INSTANCE;
            final State<Long> stateM11636rememberCurrentTimeMillisKLykuaI = ComposeUtilsKt.m11636rememberCurrentTimeMillisKLykuaI(DurationKt.toDuration(1, DurationUnit.MINUTES), composerStartRestartGroup, 0);
            Modifier modifierTestTag = TestTagKt.testTag(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), "SearchResultList");
            PaddingValues paddingValuesM1215PaddingValuesa9UjIt4$default = PaddingKt.m1215PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, BoxTheme.INSTANCE.getSizes().m11611getListContentBottomPaddingD9Ej5fM(), 7, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2138537779, "CC(remember):SearchScreen.kt#9igjgp");
            boolean zChangedInstance = ((29360128 & i3) == 8388608) | composerStartRestartGroup.changedInstance(list) | ((i3 & 7168) == 2048) | ((57344 & i3) == 16384) | ((3670016 & i3) == 1048576) | ((458752 & i3) == 131072) | composerStartRestartGroup.changed(stateM11636rememberCurrentTimeMillisKLykuaI) | ((i3 & 112) == 32) | ((i3 & 896) == 256);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                final Function1<? super String, Store<SearchItemReducer.State, SearchItemReducer.Action>> function10 = function5;
                function9 = function7;
                final Function1<? super ItemId.Remote, Boolean> function11 = function6;
                Function1 function12 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda30
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SearchScreenKt.BoxSearchListingContent$lambda$1$0(function9, list, z3, function10, z2, function3, function11, stateM11636rememberCurrentTimeMillisKLykuaI, function0, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function12);
                objRememberedValue = function12;
            } else {
                function9 = function7;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            LazyDslKt.LazyColumn(modifierTestTag, lazyListStateRememberLazyListState, paddingValuesM1215PaddingValuesa9UjIt4$default, false, null, null, null, false, null, (Function1) objRememberedValue, composer2, 6, 504);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function8 = function9;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda31
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchScreenKt.BoxSearchListingContent$lambda$2(list, z, function0, function1, z2, function2, function3, function8, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxSearchListingContent$lambda$1$0(final Function2 function2, final List list, boolean z, final Function1 function1, final boolean z2, final Function1 function3, final Function1 function4, final State state, final Function0 function0, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        if (function2 != null) {
            LazyListScope.item$default(LazyColumn, "SearchResultsHeader", null, ComposableLambdaKt.composableLambdaInstance(1026272807, true, new Function3() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SearchScreenKt.BoxSearchListingContent$lambda$1$0$0(function2, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 2, null);
        }
        LazyColumn.items(list.size(), null, new Function1<Integer, Object>() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$BoxSearchListingContent$lambda$1$0$$inlined$itemsIndexed$default$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                list.get(i);
                return null;
            }
        }, ComposableLambdaKt.composableLambdaInstance(2039820996, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$BoxSearchListingContent$lambda$1$0$$inlined$itemsIndexed$default$3
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code duplicated, block: B:57:0x01e2  */
            public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                int i3;
                boolean z3;
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
                SearchItemReducer.State state2 = (SearchItemReducer.State) list.get(i);
                composer.startReplaceGroup(-59562877);
                ComposerKt.sourceInformation(composer, "CN(index,item)*516@21881L29:SearchScreen.kt#vkhrzj");
                final Store store = (Store) function1.invoke(state2.getId());
                if (store == null) {
                    composer.endReplaceGroup();
                } else {
                    State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composer, 0, 7);
                    boolean zAreEqual = Intrinsics.areEqual(state2, CollectionsKt.last(list));
                    SearchItemReducer.SearchItem searchItem = SearchScreenKt.BoxSearchListingContent$lambda$1$0$1$0(stateCollectAsStateWithLifecycle).getSearchItem();
                    if (searchItem instanceof SearchItemReducer.SearchItem.HubItem) {
                        composer.startReplaceGroup(-59314320);
                        ComposerKt.sourceInformation(composer, "523@22272L35,527@22507L352");
                        Store storeScope = store.scope(new PropertyReference1Impl() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$BoxSearchListingContent$1$1$2$hubStore$1
                            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                            public Object get(Object obj) {
                                return ((SearchItemReducer.State) obj).getSearchItem();
                            }
                        });
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(SearchItemReducer.SearchItem.HubItem.class);
                        ComposerKt.sourceInformationMarkerStart(composer, -833191790, "CC(remember):SearchScreen.kt#9igjgp");
                        Object objRememberedValue = composer.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = (KFunction) SearchScreenKt$BoxSearchListingContent$1$1$2$hubStore$2$1.INSTANCE;
                            composer.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        Function1 function5 = (Function1) ((KFunction) objRememberedValue);
                        Object value = storeScope.getState().getValue();
                        if (!(value instanceof SearchItemReducer.SearchItem.HubItem)) {
                            value = null;
                        }
                        Store storeScope2 = ((SearchItemReducer.SearchItem.HubItem) value) != null ? storeScope.scope(KClassesJvm.getJvmName(orCreateKotlinClass), new Function1<SearchItemReducer.SearchItem, Wrapped<HubReducer.State>>() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$BoxSearchListingContent$lambda$1$0$1$$inlined$caseLet$1
                            @Override // kotlin.jvm.functions.Function1
                            public final Wrapped<HubReducer.State> invoke(SearchItemReducer.SearchItem globalState) {
                                HubReducer.State action;
                                Intrinsics.checkNotNullParameter(globalState, "globalState");
                                if (!(globalState instanceof SearchItemReducer.SearchItem.HubItem)) {
                                    globalState = null;
                                }
                                SearchItemReducer.SearchItem.HubItem hubItem = (SearchItemReducer.SearchItem.HubItem) globalState;
                                if (hubItem == null || (action = hubItem.getAction()) == null) {
                                    return null;
                                }
                                return StoreKt.wrap(action);
                            }
                        }, function5) : null;
                        Intrinsics.checkNotNull(storeScope2, "null cannot be cast to non-null type com.box.android.cpl.Store<com.box.android.hubs.presentation.HubReducer.State, com.box.android.hubs.presentation.HubReducer.Action>");
                        SearchItemReducer.SearchItem searchItem2 = SearchScreenKt.BoxSearchListingContent$lambda$1$0$1$0(stateCollectAsStateWithLifecycle).getSearchItem();
                        Intrinsics.checkNotNull(searchItem2, "null cannot be cast to non-null type com.box.android.search.presentation.cpl.SearchItemReducer.SearchItem.HubItem");
                        HubsScreenKt.HubItem(storeScope2, ItemsScreenMode.LIST, zAreEqual, z2, ((Boolean) function3.invoke(((SearchItemReducer.SearchItem.HubItem) searchItem2).getState().getId())).booleanValue(), true, composer, 196656, 0);
                        composer.endReplaceGroup();
                    } else if (searchItem instanceof SearchItemReducer.SearchItem.FileItem) {
                        composer.startReplaceGroup(-58438818);
                        ComposerKt.sourceInformation(composer, "540@23139L36,550@23722L564");
                        Store storeScope3 = store.scope(new PropertyReference1Impl() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$BoxSearchListingContent$1$1$2$itemStore$1
                            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                            public Object get(Object obj) {
                                return ((SearchItemReducer.State) obj).getSearchItem();
                            }
                        });
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(SearchItemReducer.SearchItem.FileItem.class);
                        ComposerKt.sourceInformationMarkerStart(composer, -833164045, "CC(remember):SearchScreen.kt#9igjgp");
                        Object objRememberedValue2 = composer.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = (KFunction) SearchScreenKt$BoxSearchListingContent$1$1$2$itemStore$2$1.INSTANCE;
                            composer.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        Function1 function6 = (Function1) ((KFunction) objRememberedValue2);
                        Object value2 = storeScope3.getState().getValue();
                        if (!(value2 instanceof SearchItemReducer.SearchItem.FileItem)) {
                            value2 = null;
                        }
                        Store storeScope4 = ((SearchItemReducer.SearchItem.FileItem) value2) != null ? storeScope3.scope(KClassesJvm.getJvmName(orCreateKotlinClass2), new Function1<SearchItemReducer.SearchItem, Wrapped<ItemReducer.State>>() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$BoxSearchListingContent$lambda$1$0$1$$inlined$caseLet$2
                            @Override // kotlin.jvm.functions.Function1
                            public final Wrapped<ItemReducer.State> invoke(SearchItemReducer.SearchItem globalState) {
                                ItemReducer.State action;
                                Intrinsics.checkNotNullParameter(globalState, "globalState");
                                if (!(globalState instanceof SearchItemReducer.SearchItem.FileItem)) {
                                    globalState = null;
                                }
                                SearchItemReducer.SearchItem.FileItem fileItem = (SearchItemReducer.SearchItem.FileItem) globalState;
                                if (fileItem == null || (action = fileItem.getAction()) == null) {
                                    return null;
                                }
                                return StoreKt.wrap(action);
                            }
                        }, function6) : null;
                        Intrinsics.checkNotNull(storeScope4, "null cannot be cast to non-null type com.box.android.cpl.Store<com.box.android.browse.cpl.itemsList.ItemReducer.State, com.box.android.browse.cpl.itemsList.ItemReducer.Action>");
                        SearchItemReducer.SearchItem searchItem3 = SearchScreenKt.BoxSearchListingContent$lambda$1$0$1$0(stateCollectAsStateWithLifecycle).getSearchItem();
                        Intrinsics.checkNotNull(searchItem3, "null cannot be cast to non-null type com.box.android.search.presentation.cpl.SearchItemReducer.SearchItem.FileItem");
                        boolean zBooleanValue = ((Boolean) function4.invoke(((SearchItemReducer.SearchItem.FileItem) searchItem3).getState().getId())).booleanValue();
                        if (i != list.size() - 1) {
                            Function1 function7 = function4;
                            SearchItemReducer.SearchItem searchItem4 = ((SearchItemReducer.State) list.get(i + 1)).getSearchItem();
                            Intrinsics.checkNotNull(searchItem4, "null cannot be cast to non-null type com.box.android.search.presentation.cpl.SearchItemReducer.SearchItem.FileItem");
                            z3 = ((Boolean) function7.invoke(((SearchItemReducer.SearchItem.FileItem) searchItem4).getState().getId())).booleanValue();
                        }
                        Alignment bottomStart = Alignment.INSTANCE.getBottomStart();
                        ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        Modifier.Companion companion = Modifier.INSTANCE;
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(bottomStart, false);
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
                        ComposerKt.sourceInformationMarkerStart(composer, 1885152901, "C551@23794L197,556@24016L248:SearchScreen.kt#vkhrzj");
                        SearchScreenKt.FileItem(storeScope4, z2, zBooleanValue, composer, 0);
                        BoxSelectionAwareDividerKt.m11727BoxSelectionAwareDividerjt2gSs(zAreEqual, zBooleanValue, z3, 0.0f, composer, 0, 8);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        composer.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        composer.endReplaceGroup();
                    } else if (searchItem instanceof SearchItemReducer.SearchItem.NoteItem) {
                        composer.startReplaceGroup(-57042609);
                        ComposerKt.sourceInformation(composer, "566@24519L259,576@24963L103,573@24823L265");
                        SearchItemReducer.SearchItem searchItem5 = SearchScreenKt.BoxSearchListingContent$lambda$1$0$1$0(stateCollectAsStateWithLifecycle).getSearchItem();
                        Intrinsics.checkNotNull(searchItem5, "null cannot be cast to non-null type com.box.android.search.presentation.cpl.SearchItemReducer.SearchItem.NoteItem");
                        Object fileModel = ((SearchItemReducer.SearchItem.NoteItem) searchItem5).getFileModel();
                        long jBoxSearchListingContent$lambda$0 = SearchScreenKt.BoxSearchListingContent$lambda$0(state);
                        ComposerKt.sourceInformationMarkerStart(composer, -833119662, "CC(remember):SearchScreen.kt#9igjgp");
                        boolean zChanged = composer.changed(jBoxSearchListingContent$lambda$0) | composer.changed(fileModel);
                        Object objRememberedValue3 = composer.rememberedValue();
                        if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = NotesItemViewDataKt.toNotesItemViewData((ItemModel) fileModel, SearchScreenKt.BoxSearchListingContent$lambda$0(state), null);
                            composer.updateRememberedValue(objRememberedValue3);
                        }
                        NotesItemViewData notesItemViewData = (NotesItemViewData) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        if (notesItemViewData == null) {
                            composer.endReplaceGroup();
                            composer.endReplaceGroup();
                        } else {
                            ComposerKt.sourceInformationMarkerStart(composer, -833105610, "CC(remember):SearchScreen.kt#9igjgp");
                            boolean zChanged2 = composer.changed(store);
                            Object objRememberedValue4 = composer.rememberedValue();
                            if (zChanged2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = (Function0) new Function0<Unit>() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$BoxSearchListingContent$1$1$2$2$1
                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        store.send(new SearchItemReducer.Action.NoteAction(SearchItemReducer.NoteActionType.Clicked.INSTANCE));
                                    }
                                };
                                composer.updateRememberedValue(objRememberedValue4);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            NoteSearchItemKt.NoteSearchItem(notesItemViewData, zAreEqual, (Function0) objRememberedValue4, null, composer, NotesItemViewData.$stable, 8);
                            composer.endReplaceGroup();
                        }
                    } else {
                        composer.startReplaceGroup(-833198060);
                        composer.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    composer.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        if (z) {
            LazyListScope.item$default(LazyColumn, "SearchLoadMoreItem", null, ComposableLambdaKt.composableLambdaInstance(-679403490, true, new Function3() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SearchScreenKt.BoxSearchListingContent$lambda$1$0$2(function0, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 2, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxSearchListingContent$lambda$1$0$0(Function2 function2, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C511@21648L8:SearchScreen.kt#vkhrzj");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1026272807, i, -1, "com.box.android.search.presentation.ui.BoxSearchListingContent.<anonymous>.<anonymous>.<anonymous> (SearchScreen.kt:511)");
            }
            function2.invoke(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxSearchListingContent$lambda$1$0$2(Function0 function0, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C584@25237L52,584@25216L73,587@25306L20:SearchScreen.kt#vkhrzj");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-679403490, i, -1, "com.box.android.search.presentation.ui.BoxSearchListingContent.<anonymous>.<anonymous>.<anonymous> (SearchScreen.kt:584)");
            }
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -71723598, "CC(remember):SearchScreen.kt#9igjgp");
            boolean zChanged = composer.changed(function0);
            SearchScreenKt$BoxSearchListingContent$1$1$3$1$1 searchScreenKt$BoxSearchListingContent$1$1$3$1$1RememberedValue = composer.rememberedValue();
            if (zChanged || searchScreenKt$BoxSearchListingContent$1$1$3$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                searchScreenKt$BoxSearchListingContent$1$1$3$1$1RememberedValue = new SearchScreenKt$BoxSearchListingContent$1$1$3$1$1(function0, null);
                composer.updateRememberedValue(searchScreenKt$BoxSearchListingContent$1$1$3$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) searchScreenKt$BoxSearchListingContent$1$1$3$1$1RememberedValue, composer, 6);
            SearchLoadMoreItem(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void SearchLoadMoreItem(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-489850167);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SearchLoadMoreItem)595@25411L293:SearchScreen.kt#vkhrzj");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-489850167, i, -1, "com.box.android.search.presentation.ui.SearchLoadMoreItem (SearchScreen.kt:594)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            Modifier modifierTestTag = TestTagKt.testTag(PaddingKt.m1218padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(16)), "SearchLoadMoreProgressBar");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 898038694, "C603@25674L24:SearchScreen.kt#vkhrzj");
            BoxCircularProgressBarKt.m11734BoxCircularProgressBarO8KfPlw(null, null, 0L, 0L, 0.0f, 0, null, composerStartRestartGroup, 0, 127);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda32
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchScreenKt.SearchLoadMoreItem$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FileItem(final Store<ItemReducer.State, ItemReducer.Action> store, final boolean z, final boolean z2, Composer composer, final int i) {
        int i2;
        Composer composer2;
        final SecondaryActionType.BottomSheetMenu bottomSheetMenu;
        Composer composerStartRestartGroup = composer.startRestartGroup(23438783);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FileItem)N(store,isSelecting,isSelected)609@25872L29,611@25928L128,611@25907L149,616@26090L66,616@26061L95,640@26964L42,642@27119L362,641@27034L46,650@27511L48,626@26312L1419:SearchScreen.kt#vkhrzj");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(23438783, i2, -1, "com.box.android.search.presentation.ui.FileItem (SearchScreen.kt:608)");
            }
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1049840511, "CC(remember):SearchScreen.kt#9igjgp");
            int i3 = i2 & 14;
            boolean z3 = i3 == 4;
            SearchScreenKt$FileItem$1$1 searchScreenKt$FileItem$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z3 || searchScreenKt$FileItem$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                searchScreenKt$FileItem$1$1RememberedValue = new SearchScreenKt$FileItem$1$1(store, null);
                composerStartRestartGroup.updateRememberedValue(searchScreenKt$FileItem$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) searchScreenKt$FileItem$1$1RememberedValue, composerStartRestartGroup, 6);
            ItemId.Remote id = FileItem$lambda$0(stateCollectAsStateWithLifecycle).getId();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1049845633, "CC(remember):SearchScreen.kt#9igjgp");
            boolean z4 = i3 == 4;
            SearchScreenKt$FileItem$2$1 searchScreenKt$FileItem$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z4 || searchScreenKt$FileItem$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                searchScreenKt$FileItem$2$1RememberedValue = new SearchScreenKt$FileItem$2$1(store, null);
                composerStartRestartGroup.updateRememberedValue(searchScreenKt$FileItem$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(id, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) searchScreenKt$FileItem$2$1RememberedValue, composerStartRestartGroup, 0);
            if (z) {
                bottomSheetMenu = SecondaryActionType.Checkbox.INSTANCE;
            } else {
                bottomSheetMenu = SecondaryActionType.BottomSheetMenu.INSTANCE;
            }
            ListItemInfo listItemInfo = new ListItemInfo(FileItem$lambda$0(stateCollectAsStateWithLifecycle).getName(), FileItem$lambda$0(stateCollectAsStateWithLifecycle).getItemThumbnail(), ItemModelKt.fullPath$default(FileItem$lambda$0(stateCollectAsStateWithLifecycle).getItemModel(), null, 1, null), TestTagUtilsKt.toItemTestTag(FileItem$lambda$0(stateCollectAsStateWithLifecycle).getId()), OfflineManagerExtensionsKt.toOfflineBadgeType(FileItem$lambda$0(stateCollectAsStateWithLifecycle).getOfflineState()), FileItem$lambda$0(stateCollectAsStateWithLifecycle).isInCollections(), FileItem$lambda$0(stateCollectAsStateWithLifecycle).getCommentsCount(), FileItem$lambda$0(stateCollectAsStateWithLifecycle).getHasSharedLink());
            boolean zIsEnabled = FileItem$lambda$0(stateCollectAsStateWithLifecycle).isEnabled();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1049873577, "CC(remember):SearchScreen.kt#9igjgp");
            boolean z5 = i3 == 4;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z5 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda39
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SearchScreenKt.FileItem$lambda$3$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1049878857, "CC(remember):SearchScreen.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(bottomSheetMenu) | (i3 == 4);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda40
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SearchScreenKt.FileItem$lambda$4$0(bottomSheetMenu, store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function0 function1 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1049875821, "CC(remember):SearchScreen.kt#9igjgp");
            boolean z6 = i3 == 4;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z6 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda41
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SearchScreenKt.FileItem$lambda$5$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Function0 function2 = (Function0) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1049891087, "CC(remember):SearchScreen.kt#9igjgp");
            boolean z7 = i3 == 4;
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (z7 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda42
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SearchScreenKt.FileItem$lambda$6$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxListViewItemKt.m11597BoxListViewItemXSU6r7E(listItemInfo, zIsEnabled, z2, false, new ClickActionsConfig(function0, function1, function2, (Function0) objRememberedValue4), bottomSheetMenu, TextOverflow.INSTANCE.m9585getMiddleEllipsisgIe3tQ8(), true, null, composerStartRestartGroup, (i2 & 896) | 14155776 | (SecondaryActionType.$stable << 15), 264);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda43
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchScreenKt.FileItem$lambda$7(store, z, z2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FileItem$lambda$3$0(Store store) {
        store.send(ItemReducer.Action.Clicked.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FileItem$lambda$5$0(Store store) {
        store.send(ItemReducer.Action.LongClicked.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FileItem$lambda$4$0(SecondaryActionType secondaryActionType, Store store) {
        ItemReducer.Action.MenuClicked menuClicked;
        if (Intrinsics.areEqual(secondaryActionType, SecondaryActionType.Checkbox.INSTANCE)) {
            menuClicked = ItemReducer.Action.CheckboxClicked.INSTANCE;
        } else if (Intrinsics.areEqual(secondaryActionType, SecondaryActionType.BottomSheetMenu.INSTANCE)) {
            menuClicked = ItemReducer.Action.MenuClicked.INSTANCE;
        } else {
            if (!Intrinsics.areEqual(secondaryActionType, SecondaryActionType.None.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            menuClicked = null;
        }
        if (menuClicked != null) {
            store.send(menuClicked);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FileItem$lambda$6$0(Store store) {
        store.send(ItemReducer.Action.UpdateClicked.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x007f  */
    /* JADX WARN: Code duplicated, block: B:45:0x0081  */
    /* JADX WARN: Code duplicated, block: B:48:0x008a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x008c  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:53:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:56:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:59:0x013e  */
    /* JADX WARN: Code duplicated, block: B:62:0x014a  */
    /* JADX WARN: Code duplicated, block: B:63:0x014e  */
    /* JADX WARN: Code duplicated, block: B:66:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:68:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:71:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:73:? A[RETURN, SYNTHETIC] */
    private static final void SearchBar(final String str, final String str2, final Function1<? super String, Unit> function1, final Function0<Unit> function0, Function0<Unit> function2, Composer composer, final int i, final int i2) {
        String str3;
        int i3;
        final Function0<Unit> function3;
        boolean z;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function0<Unit> function4;
        Function0<ComposeUiNode> constructor;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(-947548217);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SearchBar)N(searchBarText,searchBarHintText,onSearchBarTextUpdated,onDismissSearch,onSearchSubmitted)664@27943L2,668@28020L6,666@27954L557:SearchScreen.kt#vkhrzj");
        if ((i & 6) == 0) {
            str3 = str;
            i3 = (composerStartRestartGroup.changed(str3) ? 4 : 2) | i;
        } else {
            str3 = str;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(str2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        int i4 = i2 & 16;
        if (i4 == 0) {
            if ((i & 24576) == 0) {
                function3 = function2;
                i3 |= composerStartRestartGroup.changedInstance(function3) ? 16384 : 8192;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
            } else {
                if (i4 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -60763767, "CC(remember):SearchScreen.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda45
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function4 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function4 = function3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-947548217, i3, -1, "com.box.android.search.presentation.ui.SearchBar (SearchScreen.kt:665)");
                }
                Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(WindowInsetsPadding_androidKt.statusBarsPadding(BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11498getAppBackground0d7_KjU(), null, 2, null)), 0.0f, 1, null), Dp.m9687constructorimpl(64)), Dp.m9687constructorimpl(8), 0.0f, 2, null);
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1220paddingVpY3zN4$default);
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 486121945, "C675@28242L263:SearchScreen.kt#vkhrzj");
                Function0<Unit> function5 = function4;
                FilesSearchInputFieldKt.FilesSearchInputField(str3, str2, function1, function0, null, function5, composerStartRestartGroup, (i3 & 8190) | ((i3 << 3) & 458752), 16);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function3 = function5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda46
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SearchScreenKt.SearchBar$lambda$2(str, str2, function1, function0, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        function3 = function2;
        if ((i3 & 9363) != 9362) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -60763767, "CC(remember):SearchScreen.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda45
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                function4 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                function4 = function3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-947548217, i3, -1, "com.box.android.search.presentation.ui.SearchBar (SearchScreen.kt:665)");
            }
            Modifier modifierM1220paddingVpY3zN4$default2 = PaddingKt.m1220paddingVpY3zN4$default(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(WindowInsetsPadding_androidKt.statusBarsPadding(BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11498getAppBackground0d7_KjU(), null, 2, null)), 0.0f, 1, null), Dp.m9687constructorimpl(64)), Dp.m9687constructorimpl(8), 0.0f, 2, null);
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1220paddingVpY3zN4$default2);
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
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 486121945, "C675@28242L263:SearchScreen.kt#vkhrzj");
            Function0<Unit> function6 = function4;
            FilesSearchInputFieldKt.FilesSearchInputField(str3, str2, function1, function0, null, function6, composerStartRestartGroup, (i3 & 8190) | ((i3 << 3) & 458752), 16);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function3 = function6;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda46
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchScreenKt.SearchBar$lambda$2(str, str2, function1, function0, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0056  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:33:0x005d  */
    /* JADX WARN: Code duplicated, block: B:35:0x0065  */
    /* JADX WARN: Code duplicated, block: B:36:0x0068  */
    /* JADX WARN: Code duplicated, block: B:41:0x0076  */
    /* JADX WARN: Code duplicated, block: B:42:0x0078  */
    /* JADX WARN: Code duplicated, block: B:45:0x0081  */
    /* JADX WARN: Code duplicated, block: B:47:0x0084  */
    /* JADX WARN: Code duplicated, block: B:49:0x0087  */
    /* JADX WARN: Code duplicated, block: B:50:0x0089  */
    /* JADX WARN: Code duplicated, block: B:53:0x0090  */
    /* JADX WARN: Code duplicated, block: B:56:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:61:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:63:? A[RETURN, SYNTHETIC] */
    private static final void EmptyQuerySearchScreen(final int i, final String str, String str2, boolean z, Composer composer, final int i2, final int i3) {
        int i4;
        int i5;
        String str3;
        int i6;
        boolean z2;
        int i7;
        boolean z3;
        final String str4;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z5;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1139244915);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(EmptyQuerySearchScreen)N(iconDrawableResource,mainText,secondaryText,isRedesignedVersion)692@28700L298:SearchScreen.kt#vkhrzj");
        if ((i2 & 6) == 0) {
            i4 = i;
            i5 = (composerStartRestartGroup.changed(i4) ? 4 : 2) | i2;
        } else {
            i4 = i;
            i5 = i2;
        }
        if ((i2 & 48) == 0) {
            i5 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        int i8 = i3 & 4;
        if (i8 == 0) {
            if ((i2 & 384) == 0) {
                str3 = str2;
                i5 |= composerStartRestartGroup.changed(str3) ? 256 : 128;
            }
            i6 = i3 & 8;
            if (i6 != 0) {
                if ((i2 & 3072) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i5 |= i7;
                }
                if ((i5 & 1171) != 1170) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    str4 = str3;
                    z4 = z2;
                } else {
                    if (i8 != 0) {
                        str3 = null;
                    }
                    if (i6 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1139244915, i5, -1, "com.box.android.search.presentation.ui.EmptyQuerySearchScreen (SearchScreen.kt:691)");
                    }
                    boolean z6 = z5;
                    ItemStateScreensKt.m11654ItemsStateScreenV9fs2A(new ItemsStateConfig(i4, str, str3, null, 8, null), "EmptyQuerySearchScreen", SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), false, z6, 0L, composerStartRestartGroup, ((i5 << 3) & 57344) | 432, 40);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str4 = str3;
                    z4 = z6;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SearchScreenKt.EmptyQuerySearchScreen$lambda$0(i, str, str4, z4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= 3072;
            z2 = z;
            if ((i5 & 1171) != 1170) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                str4 = str3;
                z4 = z2;
            } else {
                if (i8 != 0) {
                    str3 = null;
                }
                if (i6 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1139244915, i5, -1, "com.box.android.search.presentation.ui.EmptyQuerySearchScreen (SearchScreen.kt:691)");
                }
                boolean z7 = z5;
                ItemStateScreensKt.m11654ItemsStateScreenV9fs2A(new ItemsStateConfig(i4, str, str3, null, 8, null), "EmptyQuerySearchScreen", SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), false, z7, 0L, composerStartRestartGroup, ((i5 << 3) & 57344) | 432, 40);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str4 = str3;
                z4 = z7;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SearchScreenKt.EmptyQuerySearchScreen$lambda$0(i, str, str4, z4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= 384;
        str3 = str2;
        i6 = i3 & 8;
        if (i6 != 0) {
            if ((i2 & 3072) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i5 |= i7;
            }
            if ((i5 & 1171) != 1170) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                str4 = str3;
                z4 = z2;
            } else {
                if (i8 != 0) {
                    str3 = null;
                }
                if (i6 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1139244915, i5, -1, "com.box.android.search.presentation.ui.EmptyQuerySearchScreen (SearchScreen.kt:691)");
                }
                boolean z8 = z5;
                ItemStateScreensKt.m11654ItemsStateScreenV9fs2A(new ItemsStateConfig(i4, str, str3, null, 8, null), "EmptyQuerySearchScreen", SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), false, z8, 0L, composerStartRestartGroup, ((i5 << 3) & 57344) | 432, 40);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str4 = str3;
                z4 = z8;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SearchScreenKt.EmptyQuerySearchScreen$lambda$0(i, str, str4, z4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= 3072;
        z2 = z;
        if ((i5 & 1171) != 1170) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i5 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            str4 = str3;
            z4 = z2;
        } else {
            if (i8 != 0) {
                str3 = null;
            }
            if (i6 != 0) {
                z5 = false;
            } else {
                z5 = z2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1139244915, i5, -1, "com.box.android.search.presentation.ui.EmptyQuerySearchScreen (SearchScreen.kt:691)");
            }
            boolean z9 = z5;
            ItemStateScreensKt.m11654ItemsStateScreenV9fs2A(new ItemsStateConfig(i4, str, str3, null, 8, null), "EmptyQuerySearchScreen", SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), false, z9, 0L, composerStartRestartGroup, ((i5 << 3) & 57344) | 432, 40);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            str4 = str3;
            z4 = z9;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchScreenKt.EmptyQuerySearchScreen$lambda$0(i, str, str4, z4, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SearchRecentsScreen(final String str, final String str2, final List<String> list, final Function1<? super String, Unit> function1, final Function1<? super String, Unit> function2, final List<AiRecentSession> list2, final Function1<? super String, Unit> function3, Composer composer, final int i) {
        final String str3;
        int i2;
        String str4;
        Function1<? super String, Unit> function4;
        Function1<? super String, Unit> function5;
        Function1<? super String, Unit> function6;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1419577816);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SearchRecentsScreen)N(recentSearchesTitle,recentAiSessionsTitle,recentQueries,onQuerySelected,onDeleteQuery,recentAiSessions,onAiSessionSelected)714@29344L47,715@29416L38,722@29665L934,717@29460L1139:SearchScreen.kt#vkhrzj");
        if ((i & 6) == 0) {
            str3 = str;
            i2 = (composerStartRestartGroup.changed(str3) ? 4 : 2) | i;
        } else {
            str3 = str;
            i2 = i;
        }
        if ((i & 48) == 0) {
            str4 = str2;
            i2 |= composerStartRestartGroup.changed(str4) ? 32 : 16;
        } else {
            str4 = str2;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(list) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            function4 = function1;
            i2 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
        } else {
            function4 = function1;
        }
        if ((i & 24576) == 0) {
            function5 = function2;
            i2 |= composerStartRestartGroup.changedInstance(function5) ? 16384 : 8192;
        } else {
            function5 = function2;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(list2) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            function6 = function3;
            i2 |= composerStartRestartGroup.changedInstance(function6) ? 1048576 : 524288;
        } else {
            function6 = function3;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 599187) != 599186, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1419577816, i2, -1, "com.box.android.search.presentation.ui.SearchRecentsScreen (SearchScreen.kt:713)");
            }
            final VectorPainter vectorPainterRememberVectorPainter = VectorPainterKt.rememberVectorPainter(AccessTimeKt.getAccessTime(Icons.Rounded.INSTANCE), composerStartRestartGroup, 0);
            final Painter painterPainterResource = PainterResources_androidKt.painterResource(R.drawable.ic_comment, composerStartRestartGroup, 0);
            Modifier modifierTestTag = TestTagKt.testTag(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), "RecentQueriesList");
            PaddingValues paddingValuesM1215PaddingValuesa9UjIt4$default = PaddingKt.m1215PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, BoxTheme.INSTANCE.getSizes().m11611getListContentBottomPaddingD9Ej5fM(), 7, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1585340462, "CC(remember):SearchScreen.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(list) | ((i2 & 14) == 4) | composerStartRestartGroup.changedInstance(vectorPainterRememberVectorPainter) | ((i2 & 7168) == 2048) | ((57344 & i2) == 16384) | composerStartRestartGroup.changedInstance(list2) | ((i2 & 112) == 32) | composerStartRestartGroup.changedInstance(painterPainterResource) | ((i2 & 3670016) == 1048576);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                final Function1<? super String, Unit> function7 = function4;
                final Function1<? super String, Unit> function8 = function6;
                final String str5 = str4;
                final Function1<? super String, Unit> function9 = function5;
                Function1 function10 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda65
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SearchScreenKt.SearchRecentsScreen$lambda$0$0(list, str3, vectorPainterRememberVectorPainter, function7, function9, list2, str5, painterPainterResource, function8, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function10);
                objRememberedValue = function10;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            LazyDslKt.LazyColumn(modifierTestTag, null, paddingValuesM1215PaddingValuesa9UjIt4$default, false, null, null, null, false, null, (Function1) objRememberedValue, composer2, 6, 506);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda66
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchScreenKt.SearchRecentsScreen$lambda$1(str, str2, list, function1, function2, list2, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchRecentsScreen$lambda$0$0(List list, String str, VectorPainter vectorPainter, Function1 function1, Function1 function2, List list2, String str2, Painter painter, final Function1 function3, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        if (!list.isEmpty() && str != null) {
            SearchRecentsComponentsKt.searchRecentsSection(LazyColumn, "recent_searches", str, list, new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda34
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SearchScreenKt.SearchRecentsScreen$lambda$0$0$0((String) obj);
                }
            }, new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda35
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SearchScreenKt.SearchRecentsScreen$lambda$0$0$1((String) obj);
                }
            }, vectorPainter, function1, function2);
        }
        if (!list2.isEmpty() && str2 != null) {
            SearchRecentsComponentsKt.searchRecentsSection(LazyColumn, "recent_ai_sessions", str2, list2, new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda36
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SearchScreenKt.SearchRecentsScreen$lambda$0$0$2((AiRecentSession) obj);
                }
            }, new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda37
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SearchScreenKt.SearchRecentsScreen$lambda$0$0$3((AiRecentSession) obj);
                }
            }, painter, new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda38
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SearchScreenKt.SearchRecentsScreen$lambda$0$0$4(function3, (AiRecentSession) obj);
                }
            }, (128 & 128) != 0 ? null : null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String SearchRecentsScreen$lambda$0$0$2(AiRecentSession it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object SearchRecentsScreen$lambda$0$0$3(AiRecentSession it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchRecentsScreen$lambda$0$0$4(Function1 function1, AiRecentSession it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it.getId());
        return Unit.INSTANCE;
    }

    private static final void SearchScreenPreview(Composer composer, final int i) {
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1857160395);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SearchScreenPreview)755@30785L31,756@30858L7,757@30894L32,769@31401L14,770@31441L9,772@31498L3,773@31524L3,774@31559L28,777@31622L13,778@31663L71,782@31766L3,783@31799L3,785@31871L8,784@31832L2,758@30931L954:SearchScreen.kt#vkhrzj");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1857160395, i, -1, "com.box.android.search.presentation.ui.SearchScreenPreview (SearchScreen.kt:754)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1975254102, "CC(remember):SearchScreen.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProvidableCompositionLocal<FocusManager> localFocusManager = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localFocusManager);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final FocusManager focusManager = (FocusManager) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1975250613, "CC(remember):SearchScreen.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new SnackbarHostState();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            SnackbarHostState snackbarHostState = (SnackbarHostState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            String strSearchScreenPreview$lambda$1 = SearchScreenPreview$lambda$1(mutableState);
            FilesSearchReducer.State state = new FilesSearchReducer.State(null, null, null, false, 15, null);
            SearchReducer.ScreenState.Loading loading = SearchReducer.ScreenState.Loading.INSTANCE;
            List listEmptyList = CollectionsKt.emptyList();
            List listEmptyList2 = CollectionsKt.emptyList();
            List listEmptyList3 = CollectionsKt.emptyList();
            List listListOf = CollectionsKt.listOf((Object[]) new SearchMode[]{new SearchMode.Files(null, 1, null), SearchMode.Hubs.INSTANCE});
            FilesSearchReducer.State state2 = state;
            SearchReducer.ScreenState.Loading loading2 = loading;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1975234407, "CC(remember):SearchScreen.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(SearchScreenKt.SearchScreenPreview$lambda$4$0((ItemId.Remote) obj));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Function1 function1 = (Function1) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1975233132, "CC(remember):SearchScreen.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(SearchScreenKt.SearchScreenPreview$lambda$5$0((String) obj));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            Function1 function2 = (Function1) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1975231314, "CC(remember):SearchScreen.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            Function0 function0 = (Function0) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1975230482, "CC(remember):SearchScreen.kt#9igjgp");
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            Function0 function3 = (Function0) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1975229337, "CC(remember):SearchScreen.kt#9igjgp");
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SearchScreenKt.SearchScreenPreview$lambda$8$0((String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            Function1 function4 = (Function1) objRememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1975227336, "CC(remember):SearchScreen.kt#9igjgp");
            Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SearchScreenKt.SearchScreenPreview$lambda$9$0(mutableState, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            Function1 function5 = (Function1) objRememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1975225966, "CC(remember):SearchScreen.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(focusManager);
            Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue9 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SearchScreenKt.SearchScreenPreview$lambda$10$0(focusManager, mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
            }
            Function0 function6 = (Function0) objRememberedValue9;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1975222738, "CC(remember):SearchScreen.kt#9igjgp");
            Object objRememberedValue10 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue10 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda26
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SearchScreenKt.SearchScreenPreview$lambda$11$0((SearchMode) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
            }
            Function1 function7 = (Function1) objRememberedValue10;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1975221682, "CC(remember):SearchScreen.kt#9igjgp");
            Object objRememberedValue11 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue11 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda27
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
            }
            Function0 function8 = (Function0) objRememberedValue11;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1975219373, "CC(remember):SearchScreen.kt#9igjgp");
            Object objRememberedValue12 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue12 = new Function1() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SearchScreenKt.SearchScreenPreview$lambda$13$0((String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
            }
            Function1 function9 = (Function1) objRememberedValue12;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1975220627, "CC(remember):SearchScreen.kt#9igjgp");
            Object objRememberedValue13 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue13 = new Function0() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue13);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            SearchScreenContent(strSearchScreenPreview$lambda$1, state2, loading2, listEmptyList3, listEmptyList, listEmptyList2, false, snackbarHostState, listListOf, false, true, function1, function2, function0, function3, function4, function5, function6, function7, function8, null, null, function9, (Function0) objRememberedValue13, null, null, null, false, composer2, 819686832, 907767222, 3456, 254803968);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchScreenKt.SearchScreenPreview$lambda$15(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String SearchScreenPreview$lambda$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchScreenPreview$lambda$9$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchScreenPreview$lambda$10$0(FocusManager focusManager, MutableState mutableState) {
        mutableState.setValue("");
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchScreenPreview$lambda$11$0(SearchMode it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SearchScreenPreview$lambda$13$0(String str) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        return Unit.INSTANCE;
    }

    private static final void SearchRecentsScreenPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(893626463);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SearchRecentsScreenPreview)793@31993L439:SearchScreen.kt#vkhrzj");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(893626463, i, -1, "com.box.android.search.presentation.ui.SearchRecentsScreenPreview (SearchScreen.kt:792)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$SearchScreenKt.INSTANCE.getLambda$892582132$search_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.search.presentation.ui.SearchScreenKt$$ExternalSyntheticLambda29
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchScreenKt.SearchRecentsScreenPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SearchReducer.State SearchScreen$lambda$1(State<SearchReducer.State> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long BoxSearchListingContent$lambda$0(State<Long> state) {
        return state.getValue().longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SearchItemReducer.State BoxSearchListingContent$lambda$1$0$1$0(State<SearchItemReducer.State> state) {
        return state.getValue();
    }

    private static final ItemReducer.State FileItem$lambda$0(State<ItemReducer.State> state) {
        return state.getValue();
    }
}

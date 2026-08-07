package com.box.android.search.presentation.cpl;

import androidx.exifinterface.media.ExifInterface;
import com.box.android.base.presentation.multiselect.MultiselectReducer;
import com.box.android.base.presentation.multiselect.SelectionIdKt;
import com.box.android.browse.cpl.itemsList.ItemReducer;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.EmbeddedItem;
import com.box.android.cpl.Identifiable;
import com.box.android.cpl.IdentifiedList;
import com.box.android.cpl.IdentifiedListKt;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.Combine;
import com.box.android.cpl.reducers.ForEachReducer;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.boxai.AiRecentSession;
import com.box.android.domain.models.hubs.HubModel;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.search.FileSearchItem;
import com.box.android.domain.models.search.FilesSearchFilters;
import com.box.android.domain.models.search.NoteSearchItem;
import com.box.android.domain.models.search.SearchMode;
import com.box.android.domain.models.search.SearchResult;
import com.box.android.domain.utils.result.Result;
import com.box.android.hubs.presentation.HubReducer;
import com.box.android.observability.DiagnosisParams;
import com.box.android.search.analytics.SearchAnalytics;
import com.box.android.search.presentation.SearchConstants;
import com.box.brownfieldApi.featuresNavigator.AiCenterInitialContext;
import com.box.brownfieldApi.featuresNavigator.HubDetailsInitialContext;
import com.pspdfkit.analytics.Analytics;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KCallables;
import kotlin.reflect.full.KClasses;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: SearchReducer.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 >2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0005:;<=>B\u001b\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u0002J\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J$\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J$\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0018H\u0002J\u001c\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0002J$\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u001bH\u0002J,\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0016\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u0015\u001a\u00020\u0002H\u0002J\u001b\u0010!\u001a\u00020\"\"\u0006\b\u0000\u0010#\u0018\u0001*\b\u0012\u0004\u0012\u0002H#0$H\u0082\bJ\u0018\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020'0&*\u00020(H\u0002J<\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020'0&2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020'0&2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020'0&H\u0002J$\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010-\u001a\u00020.H\u0002J$\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u000200H\u0002J$\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u000202H\u0002J\u001c\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0002J$\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u000205H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR \u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000307X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109¨\u0006?"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/search/presentation/cpl/SearchReducer$State;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action;", "environment", "Lcom/box/android/search/presentation/cpl/SearchEnvironment;", "analytics", "Lcom/box/android/search/analytics/SearchAnalytics;", "<init>", "(Lcom/box/android/search/presentation/cpl/SearchEnvironment;Lcom/box/android/search/analytics/SearchAnalytics;)V", "getAnalytics", "()Lcom/box/android/search/analytics/SearchAnalytics;", "performSearchAfterDelay", "Lcom/box/android/cpl/Effect;", "toSearchModeState", "Lcom/box/android/search/presentation/cpl/SearchModeState;", "Lcom/box/android/domain/models/search/SearchMode;", "includeRecentSharedLinksInFilesSearch", "", "reduceSearch", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "updateSearchMode", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action$UpdateSearchMode;", "fetchRecents", "handleSearchItemAction", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action$SearchAction;", "handleFileAction", "Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action;", "searchItemId", "", "saveCurrentQueryEffect", "toScreenState", "Lcom/box/android/search/presentation/cpl/SearchReducer$ScreenState;", ExifInterface.GPS_DIRECTION_TRUE, "", "toIdentifiedList", "Lcom/box/android/cpl/IdentifiedList;", "Lcom/box/android/search/presentation/cpl/SearchItemReducer$State;", "Lcom/box/android/domain/models/search/SearchResult;", "mergeItems", "existing", "new", "handleSearchError", "error", "Lcom/box/android/domain/models/DomainError;", "reduceHubSearchAction", "Lcom/box/android/search/presentation/cpl/HubsSearchReducer$Action;", "reduceFileSearchAction", "Lcom/box/android/search/presentation/cpl/FilesSearchReducer$Action;", "rerunSearchWithUpdatedFilters", "reduceNotesSearchAction", "Lcom/box/android/search/presentation/cpl/NotesSearchReducer$Action;", "build", "Lcom/box/android/cpl/reducers/Combine;", "getBuild", "()Lcom/box/android/cpl/reducers/Combine;", "State", "ScreenState", "Action", "SearchRoute", "Companion", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SearchReducer implements Reducable<State, Action> {
    private static final int RECENT_AI_SESSIONS_LIMIT = 4;
    private final SearchAnalytics analytics;
    private final Combine<State, Action> build;
    private final SearchEnvironment environment;
    public static final int $stable = 8;

    @Inject
    public SearchReducer(SearchEnvironment environment, SearchAnalytics analytics) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.environment = environment;
        this.analytics = analytics;
        Reduce reduce = new Reduce(new SearchReducer$build$2(this));
        final SearchReducer$build$3 searchReducer$build$3 = new PropertyReference1Impl() { // from class: com.box.android.search.presentation.cpl.SearchReducer$build$3
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((SearchReducer.State) obj).getMultiselect();
            }
        };
        final SearchReducer$build$4 searchReducer$build$4 = SearchReducer$build$4.INSTANCE;
        IfLetReducer ifLetReducer = new IfLetReducer(reduce, new MultiselectReducer(environment.getMultiselectEnvironment()), new Function1<State, MultiselectReducer.State>() { // from class: com.box.android.search.presentation.cpl.SearchReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.base.presentation.multiselect.MultiselectReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final MultiselectReducer.State invoke(SearchReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return searchReducer$build$3.invoke(it);
            }
        }, new Function1<Action, MultiselectReducer.Action>() { // from class: com.box.android.search.presentation.cpl.SearchReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final MultiselectReducer.Action invoke(SearchReducer.Action action) {
                if (!(action instanceof SearchReducer.Action.Multiselect)) {
                    action = null;
                }
                SearchReducer.Action.Multiselect multiselect = (SearchReducer.Action.Multiselect) action;
                if (multiselect != null) {
                    return multiselect.getAction();
                }
                return null;
            }
        }, new Function2<State, MultiselectReducer.State, State>() { // from class: com.box.android.search.presentation.cpl.SearchReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final SearchReducer.State invoke(SearchReducer.State parentState, MultiselectReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = searchReducer$build$3;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(SearchReducer.State.class)).iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(((KFunction) next).getName(), BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB));
                KFunction kFunction = (KFunction) next;
                if (kFunction == null) {
                    throw new InvalidObjectException("Copy method not found. Make sure that you work on data class!");
                }
                KParameter instanceParameter = KCallables.getInstanceParameter(kFunction);
                Intrinsics.checkNotNull(instanceParameter);
                for (KParameter kParameter : kFunction.getParameters()) {
                    if (Intrinsics.areEqual(kParameter.getName(), kProperty1.getName())) {
                        R rCallBy = kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, parentState), TuplesKt.to(kParameter, state)));
                        if (rCallBy != 0) {
                            return (SearchReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.search.presentation.cpl.SearchReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<MultiselectReducer.Action, Action>() { // from class: com.box.android.search.presentation.cpl.SearchReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final SearchReducer.Action invoke(MultiselectReducer.Action action) {
                Object objInvoke = searchReducer$build$4.invoke(action);
                if (objInvoke != null) {
                    return (SearchReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.search.presentation.cpl.SearchReducer.Action");
            }
        });
        final SearchReducer$build$6 searchReducer$build$6 = new PropertyReference1Impl() { // from class: com.box.android.search.presentation.cpl.SearchReducer$build$6
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((SearchReducer.State) obj).getSearchModeState();
            }
        };
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(HubsSearchReducer.State.class);
        final SearchReducer$build$7 searchReducer$build$7 = SearchReducer$build$7.INSTANCE;
        IfLetReducer ifLetReducer2 = new IfLetReducer(ifLetReducer, new HubsSearchReducer(environment), new Function1<State, HubsSearchReducer.State>() { // from class: com.box.android.search.presentation.cpl.SearchReducer$special$$inlined$ifCaseScope$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v3, types: [com.box.android.search.presentation.cpl.HubsSearchReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final HubsSearchReducer.State invoke(SearchReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return kotlin.reflect.KClasses.safeCast(orCreateKotlinClass, searchReducer$build$6.invoke(it));
            }
        }, new Function1<Action, HubsSearchReducer.Action>() { // from class: com.box.android.search.presentation.cpl.SearchReducer$special$$inlined$ifCaseScope$2
            @Override // kotlin.jvm.functions.Function1
            public final HubsSearchReducer.Action invoke(SearchReducer.Action action) {
                if (!(action instanceof SearchReducer.Action.HubsSearch)) {
                    action = null;
                }
                SearchReducer.Action.HubsSearch hubsSearch = (SearchReducer.Action.HubsSearch) action;
                if (hubsSearch != null) {
                    return hubsSearch.getAction();
                }
                return null;
            }
        }, new Function2<State, HubsSearchReducer.State, State>() { // from class: com.box.android.search.presentation.cpl.SearchReducer$special$$inlined$ifCaseScope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final SearchReducer.State invoke(SearchReducer.State parentState, HubsSearchReducer.State childState) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                Intrinsics.checkNotNullParameter(childState, "childState");
                KProperty1 kProperty1 = searchReducer$build$6;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(SearchReducer.State.class)).iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(((KFunction) next).getName(), BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB));
                KFunction kFunction = (KFunction) next;
                if (kFunction == null) {
                    throw new InvalidObjectException("Copy method not found. Make sure that you work on data class!");
                }
                KParameter instanceParameter = KCallables.getInstanceParameter(kFunction);
                Intrinsics.checkNotNull(instanceParameter);
                for (KParameter kParameter : kFunction.getParameters()) {
                    if (Intrinsics.areEqual(kParameter.getName(), kProperty1.getName())) {
                        R rCallBy = kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, parentState), TuplesKt.to(kParameter, childState)));
                        if (rCallBy != 0) {
                            return (SearchReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.search.presentation.cpl.SearchReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<HubsSearchReducer.Action, Action>() { // from class: com.box.android.search.presentation.cpl.SearchReducer$special$$inlined$ifCaseScope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final SearchReducer.Action invoke(HubsSearchReducer.Action action) {
                Object objInvoke = searchReducer$build$7.invoke(action);
                if (objInvoke != null) {
                    return (SearchReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.search.presentation.cpl.SearchReducer.Action");
            }
        });
        final SearchReducer$build$9 searchReducer$build$9 = new PropertyReference1Impl() { // from class: com.box.android.search.presentation.cpl.SearchReducer$build$9
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((SearchReducer.State) obj).getSearchModeState();
            }
        };
        final KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(FilesSearchReducer.State.class);
        final SearchReducer$build$10 searchReducer$build$10 = SearchReducer$build$10.INSTANCE;
        IfLetReducer ifLetReducer3 = new IfLetReducer(ifLetReducer2, new FilesSearchReducer(environment), new Function1<State, FilesSearchReducer.State>() { // from class: com.box.android.search.presentation.cpl.SearchReducer$special$$inlined$ifCaseScope$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v3, types: [com.box.android.search.presentation.cpl.FilesSearchReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final FilesSearchReducer.State invoke(SearchReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return kotlin.reflect.KClasses.safeCast(orCreateKotlinClass2, searchReducer$build$9.invoke(it));
            }
        }, new Function1<Action, FilesSearchReducer.Action>() { // from class: com.box.android.search.presentation.cpl.SearchReducer$special$$inlined$ifCaseScope$6
            @Override // kotlin.jvm.functions.Function1
            public final FilesSearchReducer.Action invoke(SearchReducer.Action action) {
                if (!(action instanceof SearchReducer.Action.FilesSearch)) {
                    action = null;
                }
                SearchReducer.Action.FilesSearch filesSearch = (SearchReducer.Action.FilesSearch) action;
                if (filesSearch != null) {
                    return filesSearch.getAction();
                }
                return null;
            }
        }, new Function2<State, FilesSearchReducer.State, State>() { // from class: com.box.android.search.presentation.cpl.SearchReducer$special$$inlined$ifCaseScope$7
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final SearchReducer.State invoke(SearchReducer.State parentState, FilesSearchReducer.State childState) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                Intrinsics.checkNotNullParameter(childState, "childState");
                KProperty1 kProperty1 = searchReducer$build$9;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(SearchReducer.State.class)).iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(((KFunction) next).getName(), BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB));
                KFunction kFunction = (KFunction) next;
                if (kFunction == null) {
                    throw new InvalidObjectException("Copy method not found. Make sure that you work on data class!");
                }
                KParameter instanceParameter = KCallables.getInstanceParameter(kFunction);
                Intrinsics.checkNotNull(instanceParameter);
                for (KParameter kParameter : kFunction.getParameters()) {
                    if (Intrinsics.areEqual(kParameter.getName(), kProperty1.getName())) {
                        R rCallBy = kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, parentState), TuplesKt.to(kParameter, childState)));
                        if (rCallBy != 0) {
                            return (SearchReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.search.presentation.cpl.SearchReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<FilesSearchReducer.Action, Action>() { // from class: com.box.android.search.presentation.cpl.SearchReducer$special$$inlined$ifCaseScope$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final SearchReducer.Action invoke(FilesSearchReducer.Action action) {
                Object objInvoke = searchReducer$build$10.invoke(action);
                if (objInvoke != null) {
                    return (SearchReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.search.presentation.cpl.SearchReducer.Action");
            }
        });
        final SearchReducer$build$12 searchReducer$build$12 = new PropertyReference1Impl() { // from class: com.box.android.search.presentation.cpl.SearchReducer$build$12
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((SearchReducer.State) obj).getSearchModeState();
            }
        };
        final KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(NotesSearchReducer.State.class);
        final SearchReducer$build$13 searchReducer$build$13 = SearchReducer$build$13.INSTANCE;
        IfLetReducer ifLetReducer4 = new IfLetReducer(ifLetReducer3, new NotesSearchReducer(environment), new Function1<State, NotesSearchReducer.State>() { // from class: com.box.android.search.presentation.cpl.SearchReducer$special$$inlined$ifCaseScope$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v3, types: [com.box.android.search.presentation.cpl.NotesSearchReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final NotesSearchReducer.State invoke(SearchReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return kotlin.reflect.KClasses.safeCast(orCreateKotlinClass3, searchReducer$build$12.invoke(it));
            }
        }, new Function1<Action, NotesSearchReducer.Action>() { // from class: com.box.android.search.presentation.cpl.SearchReducer$special$$inlined$ifCaseScope$10
            @Override // kotlin.jvm.functions.Function1
            public final NotesSearchReducer.Action invoke(SearchReducer.Action action) {
                if (!(action instanceof SearchReducer.Action.NotesSearch)) {
                    action = null;
                }
                SearchReducer.Action.NotesSearch notesSearch = (SearchReducer.Action.NotesSearch) action;
                if (notesSearch != null) {
                    return notesSearch.getAction();
                }
                return null;
            }
        }, new Function2<State, NotesSearchReducer.State, State>() { // from class: com.box.android.search.presentation.cpl.SearchReducer$special$$inlined$ifCaseScope$11
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final SearchReducer.State invoke(SearchReducer.State parentState, NotesSearchReducer.State childState) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                Intrinsics.checkNotNullParameter(childState, "childState");
                KProperty1 kProperty1 = searchReducer$build$12;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(SearchReducer.State.class)).iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(((KFunction) next).getName(), BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB));
                KFunction kFunction = (KFunction) next;
                if (kFunction == null) {
                    throw new InvalidObjectException("Copy method not found. Make sure that you work on data class!");
                }
                KParameter instanceParameter = KCallables.getInstanceParameter(kFunction);
                Intrinsics.checkNotNull(instanceParameter);
                for (KParameter kParameter : kFunction.getParameters()) {
                    if (Intrinsics.areEqual(kParameter.getName(), kProperty1.getName())) {
                        R rCallBy = kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, parentState), TuplesKt.to(kParameter, childState)));
                        if (rCallBy != 0) {
                            return (SearchReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.search.presentation.cpl.SearchReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<NotesSearchReducer.Action, Action>() { // from class: com.box.android.search.presentation.cpl.SearchReducer$special$$inlined$ifCaseScope$12
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final SearchReducer.Action invoke(NotesSearchReducer.Action action) {
                Object objInvoke = searchReducer$build$13.invoke(action);
                if (objInvoke != null) {
                    return (SearchReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.search.presentation.cpl.SearchReducer.Action");
            }
        });
        final SearchReducer$build$15 searchReducer$build$15 = new PropertyReference1Impl() { // from class: com.box.android.search.presentation.cpl.SearchReducer$build$15
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((SearchReducer.State) obj).getSearchItems();
            }
        };
        final SearchReducer$build$16 searchReducer$build$16 = SearchReducer$build$16.INSTANCE;
        this.build = new Combine<>(new Reduce(new SearchReducer$build$1(this)), new ForEachReducer(ifLetReducer4, new SearchItemReducer(environment), searchReducer$build$15, new Function1<Action, EmbeddedItem<String, SearchItemReducer.Action>>() { // from class: com.box.android.search.presentation.cpl.SearchReducer$special$$inlined$forEach$1
            @Override // kotlin.jvm.functions.Function1
            public final EmbeddedItem<String, SearchItemReducer.Action> invoke(SearchReducer.Action action) {
                if (!(action instanceof SearchReducer.Action.SearchAction)) {
                    action = null;
                }
                return (SearchReducer.Action.SearchAction) action;
            }
        }, new Function2<State, SearchItemReducer.State, State>() { // from class: com.box.android.search.presentation.cpl.SearchReducer$special$$inlined$forEach$2
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final SearchReducer.State invoke(SearchReducer.State parentState, SearchItemReducer.State childState) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                Intrinsics.checkNotNullParameter(childState, "childState");
                IdentifiedList identifiedListListByReplacingElement = ((IdentifiedList) searchReducer$build$15.get(parentState)).listByReplacingElement(childState);
                KProperty1 kProperty1 = searchReducer$build$15;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(SearchReducer.State.class)).iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(((KFunction) next).getName(), BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB));
                KFunction kFunction = (KFunction) next;
                if (kFunction == null) {
                    throw new InvalidObjectException("Copy method not found. Make sure that you work on data class!");
                }
                KParameter instanceParameter = KCallables.getInstanceParameter(kFunction);
                Intrinsics.checkNotNull(instanceParameter);
                for (KParameter kParameter : kFunction.getParameters()) {
                    if (Intrinsics.areEqual(kParameter.getName(), kProperty1.getName())) {
                        R rCallBy = kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, parentState), TuplesKt.to(kParameter, identifiedListListByReplacingElement)));
                        if (rCallBy != 0) {
                            return (SearchReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.search.presentation.cpl.SearchReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function2<String, SearchItemReducer.Action, Action>() { // from class: com.box.android.search.presentation.cpl.SearchReducer$special$$inlined$forEach$3
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final SearchReducer.Action invoke(String id, SearchItemReducer.Action action) {
                Intrinsics.checkNotNullParameter(id, "id");
                Object objInvoke = searchReducer$build$16.invoke(id, action);
                if (objInvoke != null) {
                    return (SearchReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.search.presentation.cpl.SearchReducer.Action");
            }
        }));
    }

    public /* synthetic */ SearchReducer(SearchEnvironment searchEnvironment, SearchAnalytics.NoOp noOp, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(searchEnvironment, (i & 2) != 0 ? SearchAnalytics.NoOp.INSTANCE : noOp);
    }

    public final SearchAnalytics getAnalytics() {
        return this.analytics;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: SearchReducer.kt */
    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0087\b\u0018\u00002\u00020\u0001B½\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005\u0012\u001a\b\u0002\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00170\u001b\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0017¢\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020@J\u000e\u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0007J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0005HÆ\u0003J\t\u0010E\u001a\u00020\u0007HÆ\u0003J\t\u0010F\u001a\u00020\tHÆ\u0003J\u0015\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\t\u0010H\u001a\u00020\u000eHÆ\u0003J\t\u0010I\u001a\u00020\u0010HÆ\u0003J\u0010\u0010J\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010/J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\t\u0010L\u001a\u00020\u0015HÆ\u0003J\u000f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017HÆ\u0003J\t\u0010N\u001a\u00020\u0005HÆ\u0003J\u001b\u0010O\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00170\u001bHÆ\u0003J\u000f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0017HÆ\u0003JÆ\u0001\u0010Q\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00052\u001a\b\u0002\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00170\u001b2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0017HÆ\u0001¢\u0006\u0002\u0010RJ\u0013\u0010S\u001a\u00020\u00052\b\u0010T\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010U\u001a\u00020\tHÖ\u0001J\t\u0010V\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u00100\u001a\u0004\b.\u0010/R\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010#R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u0010\u0019\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010#R#\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00170\u001b¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0017¢\u0006\b\n\u0000\u001a\u0004\b8\u00105R\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020\u00070\u00178F¢\u0006\u0006\u001a\u0004\b:\u00105R\u0011\u0010;\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b<\u0010#R\u0011\u0010=\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b=\u0010#¨\u0006W"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchReducer$State;", "", "searchModeState", "Lcom/box/android/search/presentation/cpl/SearchModeState;", "includeRecentSharedLinksInFilesSearch", "", "query", "", "offset", "", "searchItems", "Lcom/box/android/cpl/IdentifiedList;", "Lcom/box/android/search/presentation/cpl/SearchItemReducer$State;", "screenState", "Lcom/box/android/search/presentation/cpl/SearchReducer$ScreenState;", "route", "Lcom/box/android/search/presentation/cpl/SearchReducer$SearchRoute;", "totalCount", "", "errorShown", "multiselect", "Lcom/box/android/base/presentation/multiselect/MultiselectReducer$State;", "enabledTabs", "", "Lcom/box/android/domain/models/search/SearchMode;", "isAiAtSearchEnabled", "recentQueriesByMode", "", "recentAiSessions", "Lcom/box/android/domain/models/boxai/AiRecentSession;", "<init>", "(Lcom/box/android/search/presentation/cpl/SearchModeState;ZLjava/lang/String;ILcom/box/android/cpl/IdentifiedList;Lcom/box/android/search/presentation/cpl/SearchReducer$ScreenState;Lcom/box/android/search/presentation/cpl/SearchReducer$SearchRoute;Ljava/lang/Long;ZLcom/box/android/base/presentation/multiselect/MultiselectReducer$State;Ljava/util/List;ZLjava/util/Map;Ljava/util/List;)V", "getSearchModeState", "()Lcom/box/android/search/presentation/cpl/SearchModeState;", "getIncludeRecentSharedLinksInFilesSearch", "()Z", "getQuery", "()Ljava/lang/String;", "getOffset", "()I", "getSearchItems", "()Lcom/box/android/cpl/IdentifiedList;", "getScreenState", "()Lcom/box/android/search/presentation/cpl/SearchReducer$ScreenState;", "getRoute", "()Lcom/box/android/search/presentation/cpl/SearchReducer$SearchRoute;", "getTotalCount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getErrorShown", "getMultiselect", "()Lcom/box/android/base/presentation/multiselect/MultiselectReducer$State;", "getEnabledTabs", "()Ljava/util/List;", "getRecentQueriesByMode", "()Ljava/util/Map;", "getRecentAiSessions", "recentQueries", "getRecentQueries", "hasAppliedFilters", "getHasAppliedFilters", "isSelecting", "isItemChecked", "itemId", "Lcom/box/android/domain/models/ItemId$Remote;", "isHubSelected", HubDetailsInitialContext.HUB_ID_KEY, "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Lcom/box/android/search/presentation/cpl/SearchModeState;ZLjava/lang/String;ILcom/box/android/cpl/IdentifiedList;Lcom/box/android/search/presentation/cpl/SearchReducer$ScreenState;Lcom/box/android/search/presentation/cpl/SearchReducer$SearchRoute;Ljava/lang/Long;ZLcom/box/android/base/presentation/multiselect/MultiselectReducer$State;Ljava/util/List;ZLjava/util/Map;Ljava/util/List;)Lcom/box/android/search/presentation/cpl/SearchReducer$State;", "equals", "other", "hashCode", "toString", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 0;
        private final List<SearchMode> enabledTabs;
        private final boolean errorShown;
        private final boolean includeRecentSharedLinksInFilesSearch;
        private final boolean isAiAtSearchEnabled;
        private final MultiselectReducer.State multiselect;
        private final int offset;
        private final String query;
        private final List<AiRecentSession> recentAiSessions;
        private final Map<SearchMode, List<String>> recentQueriesByMode;
        private final SearchRoute route;
        private final ScreenState screenState;
        private final IdentifiedList<String, SearchItemReducer.State> searchItems;
        private final SearchModeState searchModeState;
        private final Long totalCount;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, SearchModeState searchModeState, boolean z, String str, int i, IdentifiedList identifiedList, ScreenState screenState, SearchRoute searchRoute, Long l, boolean z2, MultiselectReducer.State state2, List list, boolean z3, Map map, List list2, int i2, Object obj) {
            return state.copy((i2 & 1) != 0 ? state.searchModeState : searchModeState, (i2 & 2) != 0 ? state.includeRecentSharedLinksInFilesSearch : z, (i2 & 4) != 0 ? state.query : str, (i2 & 8) != 0 ? state.offset : i, (i2 & 16) != 0 ? state.searchItems : identifiedList, (i2 & 32) != 0 ? state.screenState : screenState, (i2 & 64) != 0 ? state.route : searchRoute, (i2 & 128) != 0 ? state.totalCount : l, (i2 & 256) != 0 ? state.errorShown : z2, (i2 & 512) != 0 ? state.multiselect : state2, (i2 & 1024) != 0 ? state.enabledTabs : list, (i2 & 2048) != 0 ? state.isAiAtSearchEnabled : z3, (i2 & 4096) != 0 ? state.recentQueriesByMode : map, (i2 & 8192) != 0 ? state.recentAiSessions : list2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final SearchModeState getSearchModeState() {
            return this.searchModeState;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final MultiselectReducer.State getMultiselect() {
            return this.multiselect;
        }

        public final List<SearchMode> component11() {
            return this.enabledTabs;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final boolean getIsAiAtSearchEnabled() {
            return this.isAiAtSearchEnabled;
        }

        public final Map<SearchMode, List<String>> component13() {
            return this.recentQueriesByMode;
        }

        public final List<AiRecentSession> component14() {
            return this.recentAiSessions;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIncludeRecentSharedLinksInFilesSearch() {
            return this.includeRecentSharedLinksInFilesSearch;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getQuery() {
            return this.query;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getOffset() {
            return this.offset;
        }

        public final IdentifiedList<String, SearchItemReducer.State> component5() {
            return this.searchItems;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final ScreenState getScreenState() {
            return this.screenState;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final SearchRoute getRoute() {
            return this.route;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Long getTotalCount() {
            return this.totalCount;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final boolean getErrorShown() {
            return this.errorShown;
        }

        public final State copy(SearchModeState searchModeState, boolean includeRecentSharedLinksInFilesSearch, String query, int offset, IdentifiedList<String, SearchItemReducer.State> searchItems, ScreenState screenState, SearchRoute route, Long totalCount, boolean errorShown, MultiselectReducer.State multiselect, List<? extends SearchMode> enabledTabs, boolean isAiAtSearchEnabled, Map<SearchMode, ? extends List<String>> recentQueriesByMode, List<AiRecentSession> recentAiSessions) {
            Intrinsics.checkNotNullParameter(searchModeState, "searchModeState");
            Intrinsics.checkNotNullParameter(query, "query");
            Intrinsics.checkNotNullParameter(searchItems, "searchItems");
            Intrinsics.checkNotNullParameter(screenState, "screenState");
            Intrinsics.checkNotNullParameter(route, "route");
            Intrinsics.checkNotNullParameter(multiselect, "multiselect");
            Intrinsics.checkNotNullParameter(enabledTabs, "enabledTabs");
            Intrinsics.checkNotNullParameter(recentQueriesByMode, "recentQueriesByMode");
            Intrinsics.checkNotNullParameter(recentAiSessions, "recentAiSessions");
            return new State(searchModeState, includeRecentSharedLinksInFilesSearch, query, offset, searchItems, screenState, route, totalCount, errorShown, multiselect, enabledTabs, isAiAtSearchEnabled, recentQueriesByMode, recentAiSessions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.searchModeState, state.searchModeState) && this.includeRecentSharedLinksInFilesSearch == state.includeRecentSharedLinksInFilesSearch && Intrinsics.areEqual(this.query, state.query) && this.offset == state.offset && Intrinsics.areEqual(this.searchItems, state.searchItems) && Intrinsics.areEqual(this.screenState, state.screenState) && Intrinsics.areEqual(this.route, state.route) && Intrinsics.areEqual(this.totalCount, state.totalCount) && this.errorShown == state.errorShown && Intrinsics.areEqual(this.multiselect, state.multiselect) && Intrinsics.areEqual(this.enabledTabs, state.enabledTabs) && this.isAiAtSearchEnabled == state.isAiAtSearchEnabled && Intrinsics.areEqual(this.recentQueriesByMode, state.recentQueriesByMode) && Intrinsics.areEqual(this.recentAiSessions, state.recentAiSessions);
        }

        public int hashCode() {
            int iHashCode = ((((((((((((this.searchModeState.hashCode() * 31) + Boolean.hashCode(this.includeRecentSharedLinksInFilesSearch)) * 31) + this.query.hashCode()) * 31) + Integer.hashCode(this.offset)) * 31) + this.searchItems.hashCode()) * 31) + this.screenState.hashCode()) * 31) + this.route.hashCode()) * 31;
            Long l = this.totalCount;
            return ((((((((((((iHashCode + (l == null ? 0 : l.hashCode())) * 31) + Boolean.hashCode(this.errorShown)) * 31) + this.multiselect.hashCode()) * 31) + this.enabledTabs.hashCode()) * 31) + Boolean.hashCode(this.isAiAtSearchEnabled)) * 31) + this.recentQueriesByMode.hashCode()) * 31) + this.recentAiSessions.hashCode();
        }

        public String toString() {
            return "State(searchModeState=" + this.searchModeState + ", includeRecentSharedLinksInFilesSearch=" + this.includeRecentSharedLinksInFilesSearch + ", query=" + this.query + ", offset=" + this.offset + ", searchItems=" + this.searchItems + ", screenState=" + this.screenState + ", route=" + this.route + ", totalCount=" + this.totalCount + ", errorShown=" + this.errorShown + ", multiselect=" + this.multiselect + ", enabledTabs=" + this.enabledTabs + ", isAiAtSearchEnabled=" + this.isAiAtSearchEnabled + ", recentQueriesByMode=" + this.recentQueriesByMode + ", recentAiSessions=" + this.recentAiSessions + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public State(SearchModeState searchModeState, boolean z, String query, int i, IdentifiedList<String, SearchItemReducer.State> searchItems, ScreenState screenState, SearchRoute route, Long l, boolean z2, MultiselectReducer.State multiselect, List<? extends SearchMode> enabledTabs, boolean z3, Map<SearchMode, ? extends List<String>> recentQueriesByMode, List<AiRecentSession> recentAiSessions) {
            Intrinsics.checkNotNullParameter(searchModeState, "searchModeState");
            Intrinsics.checkNotNullParameter(query, "query");
            Intrinsics.checkNotNullParameter(searchItems, "searchItems");
            Intrinsics.checkNotNullParameter(screenState, "screenState");
            Intrinsics.checkNotNullParameter(route, "route");
            Intrinsics.checkNotNullParameter(multiselect, "multiselect");
            Intrinsics.checkNotNullParameter(enabledTabs, "enabledTabs");
            Intrinsics.checkNotNullParameter(recentQueriesByMode, "recentQueriesByMode");
            Intrinsics.checkNotNullParameter(recentAiSessions, "recentAiSessions");
            this.searchModeState = searchModeState;
            this.includeRecentSharedLinksInFilesSearch = z;
            this.query = query;
            this.offset = i;
            this.searchItems = searchItems;
            this.screenState = screenState;
            this.route = route;
            this.totalCount = l;
            this.errorShown = z2;
            this.multiselect = multiselect;
            this.enabledTabs = enabledTabs;
            this.isAiAtSearchEnabled = z3;
            this.recentQueriesByMode = recentQueriesByMode;
            this.recentAiSessions = recentAiSessions;
        }

        public final SearchModeState getSearchModeState() {
            return this.searchModeState;
        }

        public final boolean getIncludeRecentSharedLinksInFilesSearch() {
            return this.includeRecentSharedLinksInFilesSearch;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ State(SearchModeState searchModeState, boolean z, String str, int i, IdentifiedList identifiedList, ScreenState screenState, SearchRoute searchRoute, Long l, boolean z2, MultiselectReducer.State state, List list, boolean z3, Map map, List list2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            List listListOf;
            boolean z4 = (i2 & 2) != 0 ? false : z;
            String str2 = (i2 & 4) != 0 ? "" : str;
            int i3 = (i2 & 8) != 0 ? 0 : i;
            IdentifiedList identifiedListEmptyIdentifiedList = (i2 & 16) != 0 ? IdentifiedListKt.emptyIdentifiedList() : identifiedList;
            ScreenState.Blank blank = (i2 & 32) != 0 ? ScreenState.Blank.INSTANCE : screenState;
            SearchRoute.None none = (i2 & 64) != 0 ? SearchRoute.None.INSTANCE : searchRoute;
            FolderModel folderModel = null;
            Object[] objArr = 0;
            Long l2 = (i2 & 128) != 0 ? null : l;
            boolean z5 = (i2 & 256) != 0 ? false : z2;
            MultiselectReducer.State.Unavailable unavailable = (i2 & 512) != 0 ? MultiselectReducer.State.Unavailable.INSTANCE : state;
            if ((i2 & 1024) != 0) {
                listListOf = CollectionsKt.listOf(new SearchMode.Files(folderModel, 1, objArr == true ? 1 : 0));
            } else {
                listListOf = list;
            }
            this(searchModeState, z4, str2, i3, identifiedListEmptyIdentifiedList, blank, none, l2, z5, unavailable, listListOf, (i2 & 2048) == 0 ? z3 : false, (i2 & 4096) != 0 ? MapsKt.emptyMap() : map, (i2 & 8192) != 0 ? CollectionsKt.emptyList() : list2);
        }

        public final String getQuery() {
            return this.query;
        }

        public final int getOffset() {
            return this.offset;
        }

        public final IdentifiedList<String, SearchItemReducer.State> getSearchItems() {
            return this.searchItems;
        }

        public final ScreenState getScreenState() {
            return this.screenState;
        }

        public final SearchRoute getRoute() {
            return this.route;
        }

        public final Long getTotalCount() {
            return this.totalCount;
        }

        public final boolean getErrorShown() {
            return this.errorShown;
        }

        public final MultiselectReducer.State getMultiselect() {
            return this.multiselect;
        }

        public final List<SearchMode> getEnabledTabs() {
            return this.enabledTabs;
        }

        public final boolean isAiAtSearchEnabled() {
            return this.isAiAtSearchEnabled;
        }

        public final Map<SearchMode, List<String>> getRecentQueriesByMode() {
            return this.recentQueriesByMode;
        }

        public final List<AiRecentSession> getRecentAiSessions() {
            return this.recentAiSessions;
        }

        public final List<String> getRecentQueries() {
            List<String> list = this.recentQueriesByMode.get(SearchModeStateKt.toSearchMode(this.searchModeState));
            return list == null ? CollectionsKt.emptyList() : list;
        }

        public final boolean getHasAppliedFilters() {
            FilesSearchFilters filters;
            SearchModeState searchModeState = this.searchModeState;
            FilesSearchReducer.State state = searchModeState instanceof FilesSearchReducer.State ? (FilesSearchReducer.State) searchModeState : null;
            return (state == null || (filters = state.getFilters()) == null || !filters.isAnyFilterApplied()) ? false : true;
        }

        public final boolean isSelecting() {
            return this.multiselect instanceof MultiselectReducer.State.Selecting;
        }

        public final boolean isItemChecked(ItemId.Remote itemId) {
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            MultiselectReducer.State state = this.multiselect;
            MultiselectReducer.State.Selecting selecting = state instanceof MultiselectReducer.State.Selecting ? (MultiselectReducer.State.Selecting) state : null;
            return selecting != null && selecting.isItemSelected(SelectionIdKt.toSelectionId(itemId));
        }

        public final boolean isHubSelected(String hubId) {
            Intrinsics.checkNotNullParameter(hubId, "hubId");
            MultiselectReducer.State state = this.multiselect;
            MultiselectReducer.State.Selecting selecting = state instanceof MultiselectReducer.State.Selecting ? (MultiselectReducer.State.Selecting) state : null;
            return selecting != null && selecting.isItemSelected(SelectionIdKt.hubSelectionId(hubId));
        }
    }

    /* JADX INFO: compiled from: SearchReducer.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchReducer$ScreenState;", "", "<init>", "()V", "Error", "Loading", "Loaded", "Blank", "EmptyResults", "RecentQueries", "Lcom/box/android/search/presentation/cpl/SearchReducer$ScreenState$Blank;", "Lcom/box/android/search/presentation/cpl/SearchReducer$ScreenState$EmptyResults;", "Lcom/box/android/search/presentation/cpl/SearchReducer$ScreenState$Error;", "Lcom/box/android/search/presentation/cpl/SearchReducer$ScreenState$Loaded;", "Lcom/box/android/search/presentation/cpl/SearchReducer$ScreenState$Loading;", "Lcom/box/android/search/presentation/cpl/SearchReducer$ScreenState$RecentQueries;", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class ScreenState {
        public static final int $stable = 0;

        public /* synthetic */ ScreenState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: SearchReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchReducer$ScreenState$Error;", "Lcom/box/android/search/presentation/cpl/SearchReducer$ScreenState;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Error extends ScreenState {
            public static final int $stable = 8;
            private final DomainError error;

            public static /* synthetic */ Error copy$default(Error error, DomainError domainError, int i, Object obj) {
                if ((i & 1) != 0) {
                    domainError = error.error;
                }
                return error.copy(domainError);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DomainError getError() {
                return this.error;
            }

            public final Error copy(DomainError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                return new Error(error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Error) && Intrinsics.areEqual(this.error, ((Error) other).error);
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return "Error(error=" + this.error + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(DomainError error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public final DomainError getError() {
                return this.error;
            }
        }

        private ScreenState() {
        }

        /* JADX INFO: compiled from: SearchReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchReducer$ScreenState$Loading;", "Lcom/box/android/search/presentation/cpl/SearchReducer$ScreenState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Loading extends ScreenState {
            public static final int $stable = 0;
            public static final Loading INSTANCE = new Loading();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loading)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1439969373;
            }

            public String toString() {
                return "Loading";
            }

            private Loading() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: SearchReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchReducer$ScreenState$Loaded;", "Lcom/box/android/search/presentation/cpl/SearchReducer$ScreenState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Loaded extends ScreenState {
            public static final int $stable = 0;
            public static final Loaded INSTANCE = new Loaded();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 462092484;
            }

            public String toString() {
                return "Loaded";
            }

            private Loaded() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: SearchReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchReducer$ScreenState$Blank;", "Lcom/box/android/search/presentation/cpl/SearchReducer$ScreenState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Blank extends ScreenState {
            public static final int $stable = 0;
            public static final Blank INSTANCE = new Blank();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Blank)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -2072628043;
            }

            public String toString() {
                return "Blank";
            }

            private Blank() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: SearchReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchReducer$ScreenState$EmptyResults;", "Lcom/box/android/search/presentation/cpl/SearchReducer$ScreenState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class EmptyResults extends ScreenState {
            public static final int $stable = 0;
            public static final EmptyResults INSTANCE = new EmptyResults();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof EmptyResults)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1561187480;
            }

            public String toString() {
                return "EmptyResults";
            }

            private EmptyResults() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: SearchReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchReducer$ScreenState$RecentQueries;", "Lcom/box/android/search/presentation/cpl/SearchReducer$ScreenState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RecentQueries extends ScreenState {
            public static final int $stable = 0;
            public static final RecentQueries INSTANCE = new RecentQueries();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RecentQueries)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 134745836;
            }

            public String toString() {
                return "RecentQueries";
            }

            private RecentQueries() {
                super(null);
            }
        }
    }

    /* JADX INFO: compiled from: SearchReducer.kt */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0013\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0013\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()¨\u0006*"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchReducer$Action;", "", "<init>", "()V", "SearchQueryChanged", "UpdateSearchMode", "HubsSearch", "FilesSearch", "NotesSearch", "SearchAction", "Multiselect", "PerformSearch", "LoadMoreResults", "ClearFiltersClicked", "SearchRouteHandled", "ErrorShown", "FetchRecents", "RecentItemClicked", "SaveSearchQuery", "DeleteRecentQuery", "UpdateRecents", "RecentAiSessionClicked", "AskBoxAiClicked", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action$AskBoxAiClicked;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action$ClearFiltersClicked;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action$DeleteRecentQuery;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action$ErrorShown;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action$FetchRecents;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action$FilesSearch;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action$HubsSearch;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action$LoadMoreResults;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action$Multiselect;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action$NotesSearch;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action$PerformSearch;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action$RecentAiSessionClicked;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action$RecentItemClicked;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action$SaveSearchQuery;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action$SearchAction;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action$SearchQueryChanged;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action$SearchRouteHandled;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action$UpdateRecents;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action$UpdateSearchMode;", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: SearchReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchReducer$Action$SearchQueryChanged;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action;", "text", "", "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SearchQueryChanged extends Action {
            public static final int $stable = 0;
            private final String text;

            public static /* synthetic */ SearchQueryChanged copy$default(SearchQueryChanged searchQueryChanged, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = searchQueryChanged.text;
                }
                return searchQueryChanged.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getText() {
                return this.text;
            }

            public final SearchQueryChanged copy(String text) {
                Intrinsics.checkNotNullParameter(text, "text");
                return new SearchQueryChanged(text);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SearchQueryChanged) && Intrinsics.areEqual(this.text, ((SearchQueryChanged) other).text);
            }

            public int hashCode() {
                return this.text.hashCode();
            }

            public String toString() {
                return "SearchQueryChanged(text=" + this.text + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SearchQueryChanged(String text) {
                super(null);
                Intrinsics.checkNotNullParameter(text, "text");
                this.text = text;
            }

            public final String getText() {
                return this.text;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: SearchReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchReducer$Action$UpdateSearchMode;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action;", "searchMode", "Lcom/box/android/domain/models/search/SearchMode;", "<init>", "(Lcom/box/android/domain/models/search/SearchMode;)V", "getSearchMode", "()Lcom/box/android/domain/models/search/SearchMode;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateSearchMode extends Action {
            public static final int $stable = 8;
            private final SearchMode searchMode;

            public static /* synthetic */ UpdateSearchMode copy$default(UpdateSearchMode updateSearchMode, SearchMode searchMode, int i, Object obj) {
                if ((i & 1) != 0) {
                    searchMode = updateSearchMode.searchMode;
                }
                return updateSearchMode.copy(searchMode);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final SearchMode getSearchMode() {
                return this.searchMode;
            }

            public final UpdateSearchMode copy(SearchMode searchMode) {
                Intrinsics.checkNotNullParameter(searchMode, "searchMode");
                return new UpdateSearchMode(searchMode);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UpdateSearchMode) && Intrinsics.areEqual(this.searchMode, ((UpdateSearchMode) other).searchMode);
            }

            public int hashCode() {
                return this.searchMode.hashCode();
            }

            public String toString() {
                return "UpdateSearchMode(searchMode=" + this.searchMode + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UpdateSearchMode(SearchMode searchMode) {
                super(null);
                Intrinsics.checkNotNullParameter(searchMode, "searchMode");
                this.searchMode = searchMode;
            }

            public final SearchMode getSearchMode() {
                return this.searchMode;
            }
        }

        /* JADX INFO: compiled from: SearchReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchReducer$Action$HubsSearch;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/search/presentation/cpl/HubsSearchReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/search/presentation/cpl/HubsSearchReducer$Action;)V", "getAction", "()Lcom/box/android/search/presentation/cpl/HubsSearchReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class HubsSearch extends Action implements Embedded<HubsSearchReducer.Action> {
            public static final int $stable = 0;
            private final HubsSearchReducer.Action action;

            public static /* synthetic */ HubsSearch copy$default(HubsSearch hubsSearch, HubsSearchReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = hubsSearch.action;
                }
                return hubsSearch.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final HubsSearchReducer.Action getAction() {
                return this.action;
            }

            public final HubsSearch copy(HubsSearchReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new HubsSearch(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof HubsSearch) && Intrinsics.areEqual(this.action, ((HubsSearch) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "HubsSearch(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public HubsSearch(HubsSearchReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final HubsSearchReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: SearchReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchReducer$Action$FilesSearch;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/search/presentation/cpl/FilesSearchReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/search/presentation/cpl/FilesSearchReducer$Action;)V", "getAction", "()Lcom/box/android/search/presentation/cpl/FilesSearchReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FilesSearch extends Action implements Embedded<FilesSearchReducer.Action> {
            public static final int $stable = 0;
            private final FilesSearchReducer.Action action;

            public static /* synthetic */ FilesSearch copy$default(FilesSearch filesSearch, FilesSearchReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = filesSearch.action;
                }
                return filesSearch.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FilesSearchReducer.Action getAction() {
                return this.action;
            }

            public final FilesSearch copy(FilesSearchReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new FilesSearch(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FilesSearch) && Intrinsics.areEqual(this.action, ((FilesSearch) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "FilesSearch(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FilesSearch(FilesSearchReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final FilesSearchReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: SearchReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchReducer$Action$NotesSearch;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/search/presentation/cpl/NotesSearchReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/search/presentation/cpl/NotesSearchReducer$Action;)V", "getAction", "()Lcom/box/android/search/presentation/cpl/NotesSearchReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class NotesSearch extends Action implements Embedded<NotesSearchReducer.Action> {
            public static final int $stable = 0;
            private final NotesSearchReducer.Action action;

            public static /* synthetic */ NotesSearch copy$default(NotesSearch notesSearch, NotesSearchReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = notesSearch.action;
                }
                return notesSearch.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final NotesSearchReducer.Action getAction() {
                return this.action;
            }

            public final NotesSearch copy(NotesSearchReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new NotesSearch(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NotesSearch) && Intrinsics.areEqual(this.action, ((NotesSearch) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "NotesSearch(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NotesSearch(NotesSearchReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final NotesSearchReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: SearchReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchReducer$Action$SearchAction;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action;", "Lcom/box/android/cpl/EmbeddedItem;", "", "Lcom/box/android/search/presentation/cpl/SearchItemReducer$Action;", "id", Analytics.Data.ACTION, "<init>", "(Ljava/lang/String;Lcom/box/android/search/presentation/cpl/SearchItemReducer$Action;)V", "getId", "()Ljava/lang/String;", "getAction", "()Lcom/box/android/search/presentation/cpl/SearchItemReducer$Action;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SearchAction extends Action implements EmbeddedItem<String, SearchItemReducer.Action> {
            public static final int $stable = 0;
            private final SearchItemReducer.Action action;
            private final String id;

            public static /* synthetic */ SearchAction copy$default(SearchAction searchAction, String str, SearchItemReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = searchAction.id;
                }
                if ((i & 2) != 0) {
                    action = searchAction.action;
                }
                return searchAction.copy(str, action);
            }

            @Override // com.box.android.cpl.EmbeddedItem
            /* JADX INFO: renamed from: component1, reason: avoid collision after fix types in other method and from getter */
            public final String getId() {
                return this.id;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.EmbeddedItem
            /* JADX INFO: renamed from: component2, reason: from getter */
            public final SearchItemReducer.Action getAction() {
                return this.action;
            }

            public final SearchAction copy(String id, SearchItemReducer.Action action) {
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(action, "action");
                return new SearchAction(id, action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SearchAction)) {
                    return false;
                }
                SearchAction searchAction = (SearchAction) other;
                return Intrinsics.areEqual(this.id, searchAction.id) && Intrinsics.areEqual(this.action, searchAction.action);
            }

            public int hashCode() {
                return (this.id.hashCode() * 31) + this.action.hashCode();
            }

            public String toString() {
                return "SearchAction(id=" + this.id + ", action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SearchAction(String id, SearchItemReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(action, "action");
                this.id = id;
                this.action = action;
            }

            public final SearchItemReducer.Action getAction() {
                return this.action;
            }

            public final String getId() {
                return this.id;
            }
        }

        /* JADX INFO: compiled from: SearchReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchReducer$Action$Multiselect;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action;)V", "getAction", "()Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Multiselect extends Action implements Embedded<MultiselectReducer.Action> {
            public static final int $stable = MultiselectReducer.Action.$stable;
            private final MultiselectReducer.Action action;

            public static /* synthetic */ Multiselect copy$default(Multiselect multiselect, MultiselectReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = multiselect.action;
                }
                return multiselect.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final MultiselectReducer.Action getAction() {
                return this.action;
            }

            public final Multiselect copy(MultiselectReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new Multiselect(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Multiselect) && Intrinsics.areEqual(this.action, ((Multiselect) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "Multiselect(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Multiselect(MultiselectReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final MultiselectReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: SearchReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchReducer$Action$PerformSearch;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action;", "<init>", "()V", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class PerformSearch extends Action {
            public static final int $stable = 0;
            public static final PerformSearch INSTANCE = new PerformSearch();

            private PerformSearch() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: SearchReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchReducer$Action$LoadMoreResults;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action;", "<init>", "()V", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class LoadMoreResults extends Action {
            public static final int $stable = 0;
            public static final LoadMoreResults INSTANCE = new LoadMoreResults();

            private LoadMoreResults() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: SearchReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchReducer$Action$ClearFiltersClicked;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action;", "<init>", "()V", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class ClearFiltersClicked extends Action {
            public static final int $stable = 0;
            public static final ClearFiltersClicked INSTANCE = new ClearFiltersClicked();

            private ClearFiltersClicked() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: SearchReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchReducer$Action$SearchRouteHandled;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action;", "<init>", "()V", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class SearchRouteHandled extends Action {
            public static final int $stable = 0;
            public static final SearchRouteHandled INSTANCE = new SearchRouteHandled();

            private SearchRouteHandled() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: SearchReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchReducer$Action$ErrorShown;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action;", "<init>", "()V", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class ErrorShown extends Action {
            public static final int $stable = 0;
            public static final ErrorShown INSTANCE = new ErrorShown();

            private ErrorShown() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: SearchReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchReducer$Action$FetchRecents;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FetchRecents extends Action {
            public static final int $stable = 0;
            public static final FetchRecents INSTANCE = new FetchRecents();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FetchRecents)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1884635424;
            }

            public String toString() {
                return "FetchRecents";
            }

            private FetchRecents() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: SearchReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchReducer$Action$RecentItemClicked;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action;", "query", "", "<init>", "(Ljava/lang/String;)V", "getQuery", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RecentItemClicked extends Action {
            public static final int $stable = 0;
            private final String query;

            public static /* synthetic */ RecentItemClicked copy$default(RecentItemClicked recentItemClicked, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = recentItemClicked.query;
                }
                return recentItemClicked.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getQuery() {
                return this.query;
            }

            public final RecentItemClicked copy(String query) {
                Intrinsics.checkNotNullParameter(query, "query");
                return new RecentItemClicked(query);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof RecentItemClicked) && Intrinsics.areEqual(this.query, ((RecentItemClicked) other).query);
            }

            public int hashCode() {
                return this.query.hashCode();
            }

            public String toString() {
                return "RecentItemClicked(query=" + this.query + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RecentItemClicked(String query) {
                super(null);
                Intrinsics.checkNotNullParameter(query, "query");
                this.query = query;
            }

            public final String getQuery() {
                return this.query;
            }
        }

        /* JADX INFO: compiled from: SearchReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchReducer$Action$SaveSearchQuery;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action;", "query", "", "<init>", "(Ljava/lang/String;)V", "getQuery", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SaveSearchQuery extends Action {
            public static final int $stable = 0;
            private final String query;

            public static /* synthetic */ SaveSearchQuery copy$default(SaveSearchQuery saveSearchQuery, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = saveSearchQuery.query;
                }
                return saveSearchQuery.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getQuery() {
                return this.query;
            }

            public final SaveSearchQuery copy(String query) {
                Intrinsics.checkNotNullParameter(query, "query");
                return new SaveSearchQuery(query);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SaveSearchQuery) && Intrinsics.areEqual(this.query, ((SaveSearchQuery) other).query);
            }

            public int hashCode() {
                return this.query.hashCode();
            }

            public String toString() {
                return "SaveSearchQuery(query=" + this.query + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SaveSearchQuery(String query) {
                super(null);
                Intrinsics.checkNotNullParameter(query, "query");
                this.query = query;
            }

            public final String getQuery() {
                return this.query;
            }
        }

        /* JADX INFO: compiled from: SearchReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchReducer$Action$DeleteRecentQuery;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action;", "query", "", "<init>", "(Ljava/lang/String;)V", "getQuery", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class DeleteRecentQuery extends Action {
            public static final int $stable = 0;
            private final String query;

            public static /* synthetic */ DeleteRecentQuery copy$default(DeleteRecentQuery deleteRecentQuery, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = deleteRecentQuery.query;
                }
                return deleteRecentQuery.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getQuery() {
                return this.query;
            }

            public final DeleteRecentQuery copy(String query) {
                Intrinsics.checkNotNullParameter(query, "query");
                return new DeleteRecentQuery(query);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof DeleteRecentQuery) && Intrinsics.areEqual(this.query, ((DeleteRecentQuery) other).query);
            }

            public int hashCode() {
                return this.query.hashCode();
            }

            public String toString() {
                return "DeleteRecentQuery(query=" + this.query + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DeleteRecentQuery(String query) {
                super(null);
                Intrinsics.checkNotNullParameter(query, "query");
                this.query = query;
            }

            public final String getQuery() {
                return this.query;
            }
        }

        /* JADX INFO: compiled from: SearchReducer.kt */
        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003J5\u0010\u0011\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R#\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchReducer$Action$UpdateRecents;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action;", "queriesByMode", "", "Lcom/box/android/domain/models/search/SearchMode;", "", "", "recentAiSessions", "Lcom/box/android/domain/models/boxai/AiRecentSession;", "<init>", "(Ljava/util/Map;Ljava/util/List;)V", "getQueriesByMode", "()Ljava/util/Map;", "getRecentAiSessions", "()Ljava/util/List;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateRecents extends Action {
            public static final int $stable = 8;
            private final Map<SearchMode, List<String>> queriesByMode;
            private final List<AiRecentSession> recentAiSessions;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ UpdateRecents copy$default(UpdateRecents updateRecents, Map map, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    map = updateRecents.queriesByMode;
                }
                if ((i & 2) != 0) {
                    list = updateRecents.recentAiSessions;
                }
                return updateRecents.copy(map, list);
            }

            public final Map<SearchMode, List<String>> component1() {
                return this.queriesByMode;
            }

            public final List<AiRecentSession> component2() {
                return this.recentAiSessions;
            }

            public final UpdateRecents copy(Map<SearchMode, ? extends List<String>> queriesByMode, List<AiRecentSession> recentAiSessions) {
                Intrinsics.checkNotNullParameter(queriesByMode, "queriesByMode");
                Intrinsics.checkNotNullParameter(recentAiSessions, "recentAiSessions");
                return new UpdateRecents(queriesByMode, recentAiSessions);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof UpdateRecents)) {
                    return false;
                }
                UpdateRecents updateRecents = (UpdateRecents) other;
                return Intrinsics.areEqual(this.queriesByMode, updateRecents.queriesByMode) && Intrinsics.areEqual(this.recentAiSessions, updateRecents.recentAiSessions);
            }

            public int hashCode() {
                return (this.queriesByMode.hashCode() * 31) + this.recentAiSessions.hashCode();
            }

            public String toString() {
                return "UpdateRecents(queriesByMode=" + this.queriesByMode + ", recentAiSessions=" + this.recentAiSessions + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public UpdateRecents(Map<SearchMode, ? extends List<String>> queriesByMode, List<AiRecentSession> recentAiSessions) {
                super(null);
                Intrinsics.checkNotNullParameter(queriesByMode, "queriesByMode");
                Intrinsics.checkNotNullParameter(recentAiSessions, "recentAiSessions");
                this.queriesByMode = queriesByMode;
                this.recentAiSessions = recentAiSessions;
            }

            public final Map<SearchMode, List<String>> getQueriesByMode() {
                return this.queriesByMode;
            }

            public /* synthetic */ UpdateRecents(Map map, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(map, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
            }

            public final List<AiRecentSession> getRecentAiSessions() {
                return this.recentAiSessions;
            }
        }

        /* JADX INFO: compiled from: SearchReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchReducer$Action$RecentAiSessionClicked;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action;", "sessionId", "", "<init>", "(Ljava/lang/String;)V", "getSessionId", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RecentAiSessionClicked extends Action {
            public static final int $stable = 0;
            private final String sessionId;

            public static /* synthetic */ RecentAiSessionClicked copy$default(RecentAiSessionClicked recentAiSessionClicked, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = recentAiSessionClicked.sessionId;
                }
                return recentAiSessionClicked.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getSessionId() {
                return this.sessionId;
            }

            public final RecentAiSessionClicked copy(String sessionId) {
                Intrinsics.checkNotNullParameter(sessionId, "sessionId");
                return new RecentAiSessionClicked(sessionId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof RecentAiSessionClicked) && Intrinsics.areEqual(this.sessionId, ((RecentAiSessionClicked) other).sessionId);
            }

            public int hashCode() {
                return this.sessionId.hashCode();
            }

            public String toString() {
                return "RecentAiSessionClicked(sessionId=" + this.sessionId + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RecentAiSessionClicked(String sessionId) {
                super(null);
                Intrinsics.checkNotNullParameter(sessionId, "sessionId");
                this.sessionId = sessionId;
            }

            public final String getSessionId() {
                return this.sessionId;
            }
        }

        /* JADX INFO: compiled from: SearchReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchReducer$Action$AskBoxAiClicked;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class AskBoxAiClicked extends Action {
            public static final int $stable = 0;
            public static final AskBoxAiClicked INSTANCE = new AskBoxAiClicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof AskBoxAiClicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -949902933;
            }

            public String toString() {
                return "AskBoxAiClicked";
            }

            private AskBoxAiClicked() {
                super(null);
            }
        }
    }

    /* JADX INFO: compiled from: SearchReducer.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchReducer$SearchRoute;", "", "<init>", "()V", "None", "OpenItem", "OpenItemMoreActionsMenu", "HubDetails", "FilesFilters", "AiCenter", "Lcom/box/android/search/presentation/cpl/SearchReducer$SearchRoute$AiCenter;", "Lcom/box/android/search/presentation/cpl/SearchReducer$SearchRoute$FilesFilters;", "Lcom/box/android/search/presentation/cpl/SearchReducer$SearchRoute$HubDetails;", "Lcom/box/android/search/presentation/cpl/SearchReducer$SearchRoute$None;", "Lcom/box/android/search/presentation/cpl/SearchReducer$SearchRoute$OpenItem;", "Lcom/box/android/search/presentation/cpl/SearchReducer$SearchRoute$OpenItemMoreActionsMenu;", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class SearchRoute {
        public static final int $stable = 0;

        public /* synthetic */ SearchRoute(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: SearchReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchReducer$SearchRoute$None;", "Lcom/box/android/search/presentation/cpl/SearchReducer$SearchRoute;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class None extends SearchRoute {
            public static final int $stable = 0;
            public static final None INSTANCE = new None();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof None)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 688835387;
            }

            public String toString() {
                return "None";
            }

            private None() {
                super(null);
            }
        }

        private SearchRoute() {
        }

        /* JADX INFO: compiled from: SearchReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchReducer$SearchRoute$OpenItem;", "Lcom/box/android/search/presentation/cpl/SearchReducer$SearchRoute;", "item", "Lcom/box/android/domain/models/item/ItemModel;", "accessibleSharedLink", "", "<init>", "(Lcom/box/android/domain/models/item/ItemModel;Ljava/lang/String;)V", "getItem", "()Lcom/box/android/domain/models/item/ItemModel;", "getAccessibleSharedLink", "()Ljava/lang/String;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class OpenItem extends SearchRoute {
            public static final int $stable = 8;
            private final String accessibleSharedLink;
            private final ItemModel item;

            public static /* synthetic */ OpenItem copy$default(OpenItem openItem, ItemModel itemModel, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    itemModel = openItem.item;
                }
                if ((i & 2) != 0) {
                    str = openItem.accessibleSharedLink;
                }
                return openItem.copy(itemModel, str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemModel getItem() {
                return this.item;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getAccessibleSharedLink() {
                return this.accessibleSharedLink;
            }

            public final OpenItem copy(ItemModel item, String accessibleSharedLink) {
                Intrinsics.checkNotNullParameter(item, "item");
                return new OpenItem(item, accessibleSharedLink);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof OpenItem)) {
                    return false;
                }
                OpenItem openItem = (OpenItem) other;
                return Intrinsics.areEqual(this.item, openItem.item) && Intrinsics.areEqual(this.accessibleSharedLink, openItem.accessibleSharedLink);
            }

            public int hashCode() {
                int iHashCode = this.item.hashCode() * 31;
                String str = this.accessibleSharedLink;
                return iHashCode + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "OpenItem(item=" + this.item + ", accessibleSharedLink=" + this.accessibleSharedLink + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OpenItem(ItemModel item, String str) {
                super(null);
                Intrinsics.checkNotNullParameter(item, "item");
                this.item = item;
                this.accessibleSharedLink = str;
            }

            public /* synthetic */ OpenItem(ItemModel itemModel, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(itemModel, (i & 2) != 0 ? null : str);
            }

            public final String getAccessibleSharedLink() {
                return this.accessibleSharedLink;
            }

            public final ItemModel getItem() {
                return this.item;
            }
        }

        /* JADX INFO: compiled from: SearchReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchReducer$SearchRoute$OpenItemMoreActionsMenu;", "Lcom/box/android/search/presentation/cpl/SearchReducer$SearchRoute;", "item", "Lcom/box/android/domain/models/item/ItemModel;", "<init>", "(Lcom/box/android/domain/models/item/ItemModel;)V", "getItem", "()Lcom/box/android/domain/models/item/ItemModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class OpenItemMoreActionsMenu extends SearchRoute {
            public static final int $stable = 8;
            private final ItemModel item;

            public static /* synthetic */ OpenItemMoreActionsMenu copy$default(OpenItemMoreActionsMenu openItemMoreActionsMenu, ItemModel itemModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    itemModel = openItemMoreActionsMenu.item;
                }
                return openItemMoreActionsMenu.copy(itemModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemModel getItem() {
                return this.item;
            }

            public final OpenItemMoreActionsMenu copy(ItemModel item) {
                Intrinsics.checkNotNullParameter(item, "item");
                return new OpenItemMoreActionsMenu(item);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof OpenItemMoreActionsMenu) && Intrinsics.areEqual(this.item, ((OpenItemMoreActionsMenu) other).item);
            }

            public int hashCode() {
                return this.item.hashCode();
            }

            public String toString() {
                return "OpenItemMoreActionsMenu(item=" + this.item + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OpenItemMoreActionsMenu(ItemModel item) {
                super(null);
                Intrinsics.checkNotNullParameter(item, "item");
                this.item = item;
            }

            public final ItemModel getItem() {
                return this.item;
            }
        }

        /* JADX INFO: compiled from: SearchReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchReducer$SearchRoute$HubDetails;", "Lcom/box/android/search/presentation/cpl/SearchReducer$SearchRoute;", HubDetailsInitialContext.HUB_ID_KEY, "", "<init>", "(Ljava/lang/String;)V", "getHubId", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class HubDetails extends SearchRoute {
            public static final int $stable = 0;
            private final String hubId;

            public static /* synthetic */ HubDetails copy$default(HubDetails hubDetails, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = hubDetails.hubId;
                }
                return hubDetails.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getHubId() {
                return this.hubId;
            }

            public final HubDetails copy(String hubId) {
                Intrinsics.checkNotNullParameter(hubId, "hubId");
                return new HubDetails(hubId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof HubDetails) && Intrinsics.areEqual(this.hubId, ((HubDetails) other).hubId);
            }

            public int hashCode() {
                return this.hubId.hashCode();
            }

            public String toString() {
                return "HubDetails(hubId=" + this.hubId + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public HubDetails(String hubId) {
                super(null);
                Intrinsics.checkNotNullParameter(hubId, "hubId");
                this.hubId = hubId;
            }

            public final String getHubId() {
                return this.hubId;
            }
        }

        /* JADX INFO: compiled from: SearchReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchReducer$SearchRoute$FilesFilters;", "Lcom/box/android/search/presentation/cpl/SearchReducer$SearchRoute;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FilesFilters extends SearchRoute {
            public static final int $stable = 0;
            public static final FilesFilters INSTANCE = new FilesFilters();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FilesFilters)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -506624377;
            }

            public String toString() {
                return "FilesFilters";
            }

            private FilesFilters() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: SearchReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchReducer$SearchRoute$AiCenter;", "Lcom/box/android/search/presentation/cpl/SearchReducer$SearchRoute;", "sessionId", "", AiCenterInitialContext.INITIAL_PROMPT_KEY, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getSessionId", "()Ljava/lang/String;", "getInitialPrompt", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class AiCenter extends SearchRoute {
            public static final int $stable = 0;
            private final String initialPrompt;
            private final String sessionId;

            /* JADX WARN: Multi-variable type inference failed */
            public AiCenter() {
                this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ AiCenter copy$default(AiCenter aiCenter, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = aiCenter.sessionId;
                }
                if ((i & 2) != 0) {
                    str2 = aiCenter.initialPrompt;
                }
                return aiCenter.copy(str, str2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getSessionId() {
                return this.sessionId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getInitialPrompt() {
                return this.initialPrompt;
            }

            public final AiCenter copy(String sessionId, String initialPrompt) {
                return new AiCenter(sessionId, initialPrompt);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof AiCenter)) {
                    return false;
                }
                AiCenter aiCenter = (AiCenter) other;
                return Intrinsics.areEqual(this.sessionId, aiCenter.sessionId) && Intrinsics.areEqual(this.initialPrompt, aiCenter.initialPrompt);
            }

            public int hashCode() {
                String str = this.sessionId;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.initialPrompt;
                return iHashCode + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                return "AiCenter(sessionId=" + this.sessionId + ", initialPrompt=" + this.initialPrompt + ")";
            }

            public AiCenter(String str, String str2) {
                super(null);
                this.sessionId = str;
                this.initialPrompt = str2;
            }

            public /* synthetic */ AiCenter(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
            }

            public final String getInitialPrompt() {
                return this.initialPrompt;
            }

            public final String getSessionId() {
                return this.sessionId;
            }
        }
    }

    /* JADX INFO: renamed from: com.box.android.search.presentation.cpl.SearchReducer$performSearchAfterDelay$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SearchReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.search.presentation.cpl.SearchReducer$performSearchAfterDelay$1", f = "SearchReducer.kt", i = {}, l = {Token.ARRAYCOMP}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C17161 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        int label;

        C17161(Continuation<? super C17161> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C17161(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((C17161) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(750L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Action.PerformSearch.INSTANCE;
        }
    }

    private final Effect<Action> performSearchAfterDelay() {
        return new Effect((Function1) new C17161(null)).cancellable(SearchConstants.SEARCH_CANCEL_EFFECT_KEY, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final SearchModeState toSearchModeState(SearchMode searchMode, boolean z) {
        if (searchMode instanceof SearchMode.Hubs) {
            return new HubsSearchReducer.State(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }
        if (searchMode instanceof SearchMode.Files) {
            return new FilesSearchReducer.State(((SearchMode.Files) searchMode).getParentFolder(), null, null, z, 6, null);
        }
        if (searchMode instanceof SearchMode.Notes) {
            return NotesSearchReducer.State.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final ReducerResult<State, Action> reduceSearch(State state, Action action) {
        Effect effectNone;
        ScreenState.Blank screenState;
        ScreenState.Blank blank;
        Effect effectNone2;
        int i = 1;
        int i2 = 2;
        if (action instanceof Action.SearchQueryChanged) {
            Action.SearchQueryChanged searchQueryChanged = (Action.SearchQueryChanged) action;
            String text = searchQueryChanged.getText();
            if (StringsKt.isBlank(searchQueryChanged.getText())) {
                blank = SearchReducerKt.getHasRecents(state) ? ScreenState.RecentQueries.INSTANCE : ScreenState.Blank.INSTANCE;
            } else {
                blank = ScreenState.Loading.INSTANCE;
            }
            State stateCopy$default = State.copy$default(state, null, false, text, 0, IdentifiedListKt.emptyIdentifiedList(), blank, null, null, false, null, null, false, null, null, 15939, null);
            Effect.Companion companion = Effect.INSTANCE;
            Effect[] effectArr = new Effect[2];
            effectArr[0] = performSearchAfterDelay();
            if ((state.getSearchModeState() instanceof FilesSearchReducer.State) && StringsKt.isBlank(searchQueryChanged.getText())) {
                effectNone2 = new Effect(new Action.FilesSearch(FilesSearchReducer.Action.ClearFilters.INSTANCE));
            } else {
                effectNone2 = Effect.INSTANCE.none();
            }
            effectArr[1] = effectNone2;
            return new ReducerResult<>(stateCopy$default, companion.merge(effectArr));
        }
        if (action instanceof Action.UpdateSearchMode) {
            return updateSearchMode(state, (Action.UpdateSearchMode) action);
        }
        String str = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        if (action instanceof Action.UpdateRecents) {
            Action.UpdateRecents updateRecents = (Action.UpdateRecents) action;
            State stateCopy$default2 = State.copy$default(state, null, false, null, 0, null, null, null, null, false, null, null, false, updateRecents.getQueriesByMode(), updateRecents.getRecentAiSessions(), 4095, null);
            if (StringsKt.isBlank(state.getQuery())) {
                screenState = SearchReducerKt.getHasRecents(stateCopy$default2) ? ScreenState.RecentQueries.INSTANCE : ScreenState.Blank.INSTANCE;
            } else {
                screenState = state.getScreenState();
            }
            return new ReducerResult<>(State.copy$default(stateCopy$default2, null, false, null, 0, null, screenState, null, null, false, null, null, false, null, null, 16351, null), null, 2, null);
        }
        if (action instanceof Action.FetchRecents) {
            return fetchRecents(state);
        }
        if (action instanceof Action.PerformSearch) {
            Effect effect = new Effect((Function1) new C17171(state, null));
            if (state.getQuery().length() <= 0) {
                effect = null;
            }
            if (effect == null) {
                effect = Effect.INSTANCE.none();
            }
            return new ReducerResult<>(state, effect);
        }
        if (action instanceof Action.LoadMoreResults) {
            return new ReducerResult<>(state, new Effect(Action.PerformSearch.INSTANCE));
        }
        if (action instanceof Action.ClearFiltersClicked) {
            if (state.getSearchModeState() instanceof FilesSearchReducer.State) {
                effectNone = new Effect(new Action.FilesSearch(FilesSearchReducer.Action.ClearFilters.INSTANCE));
            } else {
                effectNone = Effect.INSTANCE.none();
            }
            return new ReducerResult<>(state, effectNone);
        }
        if (action instanceof Action.SearchAction) {
            return handleSearchItemAction(state, (Action.SearchAction) action);
        }
        if (action instanceof Action.HubsSearch) {
            return reduceHubSearchAction(state, ((Action.HubsSearch) action).getAction());
        }
        if (action instanceof Action.FilesSearch) {
            return reduceFileSearchAction(state, ((Action.FilesSearch) action).getAction());
        }
        if (action instanceof Action.NotesSearch) {
            return reduceNotesSearchAction(state, ((Action.NotesSearch) action).getAction());
        }
        if (action instanceof Action.SearchRouteHandled) {
            return new ReducerResult<>(State.copy$default(state, null, false, null, 0, null, null, SearchRoute.None.INSTANCE, null, false, null, null, false, null, null, 16319, null), null, 2, null);
        }
        if (action instanceof Action.ErrorShown) {
            return new ReducerResult<>(State.copy$default(state, null, false, null, 0, null, null, null, null, false, null, null, false, null, null, 16127, null), null, 2, null);
        }
        if (action instanceof Action.SaveSearchQuery) {
            return new ReducerResult<>(state, new Effect((Function1) new AnonymousClass3(state, this, action, null)));
        }
        if (action instanceof Action.DeleteRecentQuery) {
            return new ReducerResult<>(state, new Effect((Function1) new AnonymousClass4(state, this, action, null)));
        }
        if (action instanceof Action.RecentItemClicked) {
            Action.RecentItemClicked recentItemClicked = (Action.RecentItemClicked) action;
            return new ReducerResult<>(State.copy$default(state, null, false, recentItemClicked.getQuery(), 0, IdentifiedListKt.emptyIdentifiedList(), ScreenState.Loading.INSTANCE, null, null, false, null, null, false, null, null, 15939, null), Effect.INSTANCE.merge(new Effect(Action.PerformSearch.INSTANCE), new Effect(new Action.SaveSearchQuery(recentItemClicked.getQuery()))));
        }
        if (action instanceof Action.Multiselect) {
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof Action.RecentAiSessionClicked) {
            return new ReducerResult<>(State.copy$default(state, null, false, null, 0, null, null, new SearchRoute.AiCenter(((Action.RecentAiSessionClicked) action).getSessionId(), str, i2, objArr3 == true ? 1 : 0), null, false, null, null, false, null, null, 16319, null), null, 2, null);
        }
        if (action instanceof Action.AskBoxAiClicked) {
            return new ReducerResult<>(State.copy$default(state, null, false, null, 0, null, null, new SearchRoute.AiCenter(objArr2 == true ? 1 : 0, state.getQuery(), i, objArr == true ? 1 : 0), null, false, null, null, false, null, null, 16319, null), null, 2, null);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: com.box.android.search.presentation.cpl.SearchReducer$reduceSearch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SearchReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.search.presentation.cpl.SearchReducer$reduceSearch$1", f = "SearchReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C17171 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C17171(State state, Continuation<? super C17171> continuation) {
            super(1, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C17171(this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((C17171) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Action notesSearch;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            SearchModeState searchModeState = this.$state.getSearchModeState();
            if (searchModeState instanceof HubsSearchReducer.State) {
                notesSearch = new Action.HubsSearch(new HubsSearchReducer.Action.PerformSearch(this.$state.getQuery(), this.$state.getOffset()));
            } else if (searchModeState instanceof FilesSearchReducer.State) {
                notesSearch = new Action.FilesSearch(new FilesSearchReducer.Action.PerformSearch(this.$state.getQuery(), this.$state.getOffset()));
            } else {
                if (!(searchModeState instanceof NotesSearchReducer.State)) {
                    throw new NoWhenBranchMatchedException();
                }
                notesSearch = new Action.NotesSearch(new NotesSearchReducer.Action.PerformSearch(this.$state.getQuery(), this.$state.getOffset()));
            }
            return notesSearch;
        }
    }

    /* JADX INFO: renamed from: com.box.android.search.presentation.cpl.SearchReducer$reduceSearch$3, reason: invalid class name */
    /* JADX INFO: compiled from: SearchReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.search.presentation.cpl.SearchReducer$reduceSearch$3", f = "SearchReducer.kt", i = {0}, l = {265}, m = "invokeSuspend", n = {"activeSearchMode"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        final /* synthetic */ Action $action;
        final /* synthetic */ State $state;
        Object L$0;
        int label;
        final /* synthetic */ SearchReducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(State state, SearchReducer searchReducer, Action action, Continuation<? super AnonymousClass3> continuation) {
            super(1, continuation);
            this.$state = state;
            this.this$0 = searchReducer;
            this.$action = action;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass3(this.$state, this.this$0, this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SearchMode searchMode;
            Object recentQueries;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SearchMode searchMode2 = SearchModeStateKt.toSearchMode(this.$state.getSearchModeState());
                this.L$0 = searchMode2;
                this.label = 1;
                Object objSaveQuery = this.this$0.environment.getSearchService().saveQuery(((Action.SaveSearchQuery) this.$action).getQuery(), searchMode2, this);
                if (objSaveQuery == coroutine_suspended) {
                    return coroutine_suspended;
                }
                searchMode = searchMode2;
                obj = objSaveQuery;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                searchMode = (SearchMode) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            Result result = (Result) obj;
            State state = this.$state;
            if (result instanceof Result.Success) {
                recentQueries = ((Result.Success) result).getValue();
            } else if (result instanceof Result.Error) {
                recentQueries = state.getRecentQueries();
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return new Action.UpdateRecents(MapsKt.plus(this.$state.getRecentQueriesByMode(), TuplesKt.to(searchMode, (List) recentQueries)), this.$state.getRecentAiSessions());
        }
    }

    /* JADX INFO: renamed from: com.box.android.search.presentation.cpl.SearchReducer$reduceSearch$4, reason: invalid class name */
    /* JADX INFO: compiled from: SearchReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.search.presentation.cpl.SearchReducer$reduceSearch$4", f = "SearchReducer.kt", i = {0}, l = {278}, m = "invokeSuspend", n = {"activeMode"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        final /* synthetic */ Action $action;
        final /* synthetic */ State $state;
        Object L$0;
        int label;
        final /* synthetic */ SearchReducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(State state, SearchReducer searchReducer, Action action, Continuation<? super AnonymousClass4> continuation) {
            super(1, continuation);
            this.$state = state;
            this.this$0 = searchReducer;
            this.$action = action;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass4(this.$state, this.this$0, this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((AnonymousClass4) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SearchMode searchMode;
            Object recentQueries;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SearchMode searchMode2 = SearchModeStateKt.toSearchMode(this.$state.getSearchModeState());
                this.L$0 = searchMode2;
                this.label = 1;
                Object objDeleteQuery = this.this$0.environment.getSearchService().deleteQuery(((Action.DeleteRecentQuery) this.$action).getQuery(), searchMode2, this);
                if (objDeleteQuery == coroutine_suspended) {
                    return coroutine_suspended;
                }
                searchMode = searchMode2;
                obj = objDeleteQuery;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                searchMode = (SearchMode) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            Result result = (Result) obj;
            State state = this.$state;
            if (result instanceof Result.Success) {
                recentQueries = ((Result.Success) result).getValue();
            } else if (result instanceof Result.Error) {
                recentQueries = state.getRecentQueries();
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return new Action.UpdateRecents(MapsKt.plus(this.$state.getRecentQueriesByMode(), TuplesKt.to(searchMode, (List) recentQueries)), this.$state.getRecentAiSessions());
        }
    }

    private final ReducerResult<State, Action> updateSearchMode(State state, Action.UpdateSearchMode action) {
        ScreenState.Blank blank;
        Effect effectNone;
        State stateCopy$default = State.copy$default(state, toSearchModeState(action.getSearchMode(), state.getIncludeRecentSharedLinksInFilesSearch()), false, null, 0, IdentifiedListKt.emptyIdentifiedList(), null, null, null, false, null, null, false, null, null, 15974, null);
        if (StringsKt.isBlank(stateCopy$default.getQuery())) {
            blank = SearchReducerKt.getHasRecents(stateCopy$default) ? ScreenState.RecentQueries.INSTANCE : ScreenState.Blank.INSTANCE;
        } else {
            blank = ScreenState.Loading.INSTANCE;
        }
        State stateCopy$default2 = State.copy$default(stateCopy$default, null, false, null, 0, null, blank, null, null, false, null, null, false, null, null, 16351, null);
        if (!StringsKt.isBlank(state.getQuery())) {
            effectNone = new Effect(Action.PerformSearch.INSTANCE);
        } else {
            effectNone = Effect.INSTANCE.none();
        }
        return new ReducerResult<>(stateCopy$default2, effectNone);
    }

    private final ReducerResult<State, Action> fetchRecents(State state) {
        return new ReducerResult<>(state, new Effect(FlowKt.flow(new AnonymousClass1(state, this, null))));
    }

    /* JADX INFO: renamed from: com.box.android.search.presentation.cpl.SearchReducer$fetchRecents$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.search.presentation.cpl.SearchReducer$fetchRecents$1", f = "SearchReducer.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 3}, l = {341, 344, 347, 353}, m = "invokeSuspend", n = {"$this$flow", "$this$associateWith$iv", "result$iv", "$this$associateWithTo$iv$iv", "destination$iv$iv", "element$iv$iv", DiagnosisParams.DIAGNOSIS_MODE, "$i$f$associateWith", "$i$f$associateWithTo", "$i$a$-associateWith-SearchReducer$fetchRecents$1$recentQueriesByMode$1", "$this$flow", "recentQueriesByMode", "$this$flow", "recentQueriesByMode", "$this$flow", "recentQueriesByMode", "recentAiSession"}, s = {"L$0", "L$1", "L$3", "L$4", "L$5", "L$7", "L$8", "I$0", "I$1", "I$2", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ State $state;
        int I$0;
        int I$1;
        int I$2;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        final /* synthetic */ SearchReducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(State state, SearchReducer searchReducer, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$state = state;
            this.this$0 = searchReducer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$state, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:17:0x00a8  */
        /* JADX WARN: Code duplicated, block: B:20:0x00f2  */
        /* JADX WARN: Code duplicated, block: B:33:0x0156  */
        /* JADX WARN: Code duplicated, block: B:34:0x015d  */
        /* JADX WARN: Code duplicated, block: B:36:0x0161  */
        /* JADX WARN: Code duplicated, block: B:39:0x018a  */
        /* JADX WARN: Code duplicated, block: B:42:0x01ae  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00f2 -> B:21:0x00f3). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                Method dump skipped, instruction units count: 439
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.search.presentation.cpl.SearchReducer.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final ReducerResult<State, Action> handleSearchItemAction(State state, Action.SearchAction action) {
        FileModel fileModel;
        HubReducer.State state2;
        HubModel hubModel;
        SearchItemReducer.Action action2 = action.getAction();
        if (action2 instanceof SearchItemReducer.Action.HubAction) {
            SearchItemReducer.State state3 = (SearchItemReducer.State) state.getSearchItems().getById(action.getId());
            SearchItemReducer.SearchItem searchItem = state3 != null ? state3.getSearchItem() : null;
            SearchItemReducer.SearchItem.HubItem hubItem = searchItem instanceof SearchItemReducer.SearchItem.HubItem ? (SearchItemReducer.SearchItem.HubItem) searchItem : null;
            if (hubItem == null || (state2 = hubItem.getState()) == null || (hubModel = state2.getHubModel()) == null) {
                return new ReducerResult<>(state, null, 2, null);
            }
            HubReducer.Action action3 = ((SearchItemReducer.Action.HubAction) action.getAction()).getAction();
            if (action3 instanceof HubReducer.Action.Clicked) {
                if (state.getMultiselect() instanceof MultiselectReducer.State.Selecting) {
                    return new ReducerResult<>(state, new Effect(new Action.Multiselect(new MultiselectReducer.Action.ToggleHub(hubModel))));
                }
                return new ReducerResult<>(State.copy$default(state, null, false, null, 0, null, null, new SearchRoute.HubDetails(action.getId()), null, false, null, null, false, null, null, 16319, null), saveCurrentQueryEffect(state));
            }
            if (action3 instanceof HubReducer.Action.CheckboxClicked) {
                if (state.getMultiselect() instanceof MultiselectReducer.State.Selecting) {
                    return new ReducerResult<>(state, new Effect(new Action.Multiselect(new MultiselectReducer.Action.ToggleHub(hubModel))));
                }
                return new ReducerResult<>(state, null, 2, null);
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action2 instanceof SearchItemReducer.Action.FileAction) {
            return handleFileAction(((SearchItemReducer.Action.FileAction) action.getAction()).getAction(), state, action.getId());
        }
        if (!(action2 instanceof SearchItemReducer.Action.NoteAction)) {
            throw new NoWhenBranchMatchedException();
        }
        SearchItemReducer.State state4 = (SearchItemReducer.State) state.getSearchItems().getById(action.getId());
        SearchItemReducer.SearchItem searchItem2 = state4 != null ? state4.getSearchItem() : null;
        SearchItemReducer.SearchItem.NoteItem noteItem = searchItem2 instanceof SearchItemReducer.SearchItem.NoteItem ? (SearchItemReducer.SearchItem.NoteItem) searchItem2 : null;
        if (noteItem == null || (fileModel = noteItem.getFileModel()) == null) {
            return new ReducerResult<>(state, null, 2, null);
        }
        if (!Intrinsics.areEqual(((SearchItemReducer.Action.NoteAction) action.getAction()).getAction(), SearchItemReducer.NoteActionType.Clicked.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult<>(State.copy$default(state, null, false, null, 0, null, null, new SearchRoute.OpenItem(fileModel, state4.getAccessibleSharedLink()), null, false, null, null, false, null, null, 16319, null), saveCurrentQueryEffect(state));
    }

    private final ReducerResult<State, Action> handleFileAction(ItemReducer.Action action, State state, String searchItemId) {
        SearchItemReducer.State state2 = (SearchItemReducer.State) state.getSearchItems().getById(searchItemId);
        SearchItemReducer.SearchItem searchItem = state2 != null ? state2.getSearchItem() : null;
        SearchItemReducer.SearchItem.FileItem fileItem = searchItem instanceof SearchItemReducer.SearchItem.FileItem ? (SearchItemReducer.SearchItem.FileItem) searchItem : null;
        if (fileItem == null) {
            return new ReducerResult<>(state, null, 2, null);
        }
        ItemModel itemModel = fileItem.getState().getItemModel();
        String accessibleSharedLink = state2.getAccessibleSharedLink();
        if (action instanceof ItemReducer.Action.Clicked) {
            MultiselectReducer.State multiselect = state.getMultiselect();
            if (!(multiselect instanceof MultiselectReducer.State.Selecting)) {
                return new ReducerResult<>(State.copy$default(state, null, false, null, 0, null, null, new SearchRoute.OpenItem(itemModel, accessibleSharedLink), null, false, null, null, false, null, null, 16319, null), saveCurrentQueryEffect(state));
            }
            if ((itemModel instanceof FolderModel) && ((MultiselectReducer.State.Selecting) multiselect).getSelectionInfo().getAllowFolderNavigation()) {
                return new ReducerResult<>(State.copy$default(state, null, false, null, 0, null, null, new SearchRoute.OpenItem(itemModel, accessibleSharedLink), null, false, null, null, false, null, null, 16319, null), saveCurrentQueryEffect(state));
            }
            return new ReducerResult<>(state, new Effect(new Action.Multiselect(new MultiselectReducer.Action.Toggle(itemModel))));
        }
        if (action instanceof ItemReducer.Action.CheckboxClicked) {
            if (state.getMultiselect() instanceof MultiselectReducer.State.Selecting) {
                return new ReducerResult<>(state, new Effect(new Action.Multiselect(new MultiselectReducer.Action.Toggle(itemModel))));
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof ItemReducer.Action.MenuClicked) {
            return new ReducerResult<>(State.copy$default(state, null, false, null, 0, null, null, new SearchRoute.OpenItemMoreActionsMenu(itemModel), null, false, null, null, false, null, null, 16319, null), null, 2, null);
        }
        if (action instanceof ItemReducer.Action.UpdateClicked) {
            return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new C17151(itemModel, null)));
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.search.presentation.cpl.SearchReducer$handleFileAction$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SearchReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.search.presentation.cpl.SearchReducer$handleFileAction$1", f = "SearchReducer.kt", i = {}, l = {446}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C17151 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ ItemModel $itemModel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C17151(ItemModel itemModel, Continuation<? super C17151> continuation) {
            super(1, continuation);
            this.$itemModel = itemModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return SearchReducer.this.new C17151(this.$itemModel, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C17151) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (SearchReducer.this.environment.getOfflineService().syncOfflineItems(CollectionsKt.listOf(this.$itemModel), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    private final Effect<Action> saveCurrentQueryEffect(State state) {
        if (!StringsKt.isBlank(state.getQuery())) {
            return new Effect<>(new Action.SaveSearchQuery(state.getQuery()));
        }
        return Effect.INSTANCE.none();
    }

    private final /* synthetic */ <T> ScreenState toScreenState(List<? extends T> list) {
        if (list.isEmpty()) {
            return ScreenState.EmptyResults.INSTANCE;
        }
        return ScreenState.Loaded.INSTANCE;
    }

    private final IdentifiedList<String, SearchItemReducer.State> toIdentifiedList(SearchResult searchResult) {
        ArrayList arrayList;
        if (searchResult instanceof SearchResult.HubSearchResult) {
            List<HubModel> items = ((SearchResult.HubSearchResult) searchResult).getItems();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
            for (HubModel hubModel : items) {
                arrayList2.add(new SearchItemReducer.State(hubModel.getId(), new SearchItemReducer.SearchItem.HubItem(HubReducer.State.INSTANCE.createState(hubModel)), null, 4, null));
            }
            arrayList = arrayList2;
        } else if (searchResult instanceof SearchResult.FileSearchResult) {
            List<FileSearchItem> items2 = ((SearchResult.FileSearchResult) searchResult).getItems();
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(items2, 10));
            for (FileSearchItem fileSearchItem : items2) {
                arrayList3.add(new SearchItemReducer.State(fileSearchItem.getItem().getItemId().toString(), new SearchItemReducer.SearchItem.FileItem(new ItemReducer.State(fileSearchItem.getItem(), false, null, null, null, 30, null)), fileSearchItem.getAccessibleSharedLink()));
            }
            arrayList = arrayList3;
        } else {
            if (!(searchResult instanceof SearchResult.NoteSearchResult)) {
                throw new NoWhenBranchMatchedException();
            }
            List<NoteSearchItem> items3 = ((SearchResult.NoteSearchResult) searchResult).getItems();
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(items3, 10));
            for (NoteSearchItem noteSearchItem : items3) {
                arrayList4.add(new SearchItemReducer.State(noteSearchItem.getFile().getItemId().toString(), new SearchItemReducer.SearchItem.NoteItem(noteSearchItem.getFile()), noteSearchItem.getAccessibleSharedLink()));
            }
            arrayList = arrayList4;
        }
        return new IdentifiedList<>((SearchItemReducer.State[]) arrayList.toArray(new SearchItemReducer.State[0]));
    }

    private final IdentifiedList<String, SearchItemReducer.State> mergeItems(IdentifiedList<String, SearchItemReducer.State> existing, IdentifiedList<String, SearchItemReducer.State> identifiedList) {
        IdentifiedList<String, SearchItemReducer.State> identifiedList2 = existing;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(identifiedList2, 10)), 16));
        for (SearchItemReducer.State state : identifiedList2) {
            linkedHashMap.put(state.getId(), state);
        }
        Map mutableMap = MapsKt.toMutableMap(linkedHashMap);
        for (SearchItemReducer.State state2 : identifiedList) {
            mutableMap.put(state2.getId(), state2);
        }
        return new IdentifiedList<>((Identifiable[]) mutableMap.values().toArray(new SearchItemReducer.State[0]));
    }

    private final ReducerResult<State, Action> handleSearchError(State state, DomainError error) {
        if (!state.getSearchItems().isEmpty()) {
            return new ReducerResult<>(State.copy$default(state, null, false, null, 0, null, null, null, null, true, null, null, false, null, null, 15999, null), null, 2, null);
        }
        return new ReducerResult<>(State.copy$default(state, null, false, null, 0, null, new ScreenState.Error(error), null, null, false, null, null, false, null, null, 16215, null), null, 2, null);
    }

    private final ReducerResult<State, Action> reduceHubSearchAction(State state, HubsSearchReducer.Action action) {
        ScreenState.Loaded loaded;
        if (!(action instanceof HubsSearchReducer.Action.SearchResultsReceived)) {
            return action instanceof HubsSearchReducer.Action.Error ? handleSearchError(state, ((HubsSearchReducer.Action.Error) action).getError()) : new ReducerResult<>(state, null, 2, null);
        }
        HubsSearchReducer.Action.SearchResultsReceived searchResultsReceived = (HubsSearchReducer.Action.SearchResultsReceived) action;
        IdentifiedList<String, SearchItemReducer.State> identifiedListMergeItems = mergeItems(state.getSearchItems(), toIdentifiedList(searchResultsReceived.getResult()));
        if (identifiedListMergeItems.isEmpty()) {
            loaded = ScreenState.EmptyResults.INSTANCE;
        } else {
            loaded = ScreenState.Loaded.INSTANCE;
        }
        return new ReducerResult<>(State.copy$default(state, null, false, null, searchResultsReceived.getResult().getOffset(), identifiedListMergeItems, loaded, null, null, false, null, null, false, null, null, 16327, null), null, 2, null);
    }

    private final ReducerResult<State, Action> reduceFileSearchAction(State state, FilesSearchReducer.Action action) {
        ScreenState.Loaded loaded;
        if (action instanceof FilesSearchReducer.Action.SearchResultsReceived) {
            FilesSearchReducer.Action.SearchResultsReceived searchResultsReceived = (FilesSearchReducer.Action.SearchResultsReceived) action;
            IdentifiedList<String, SearchItemReducer.State> identifiedListMergeItems = mergeItems(state.getSearchItems(), toIdentifiedList(searchResultsReceived.getResult()));
            if (identifiedListMergeItems.isEmpty()) {
                loaded = ScreenState.EmptyResults.INSTANCE;
            } else {
                loaded = ScreenState.Loaded.INSTANCE;
            }
            return new ReducerResult<>(State.copy$default(state, null, false, null, searchResultsReceived.getResult().getLimit() + searchResultsReceived.getResult().getOffset(), identifiedListMergeItems, loaded, null, Long.valueOf(searchResultsReceived.getResult().getTotalCount()), false, null, null, false, null, null, 16199, null), null, 2, null);
        }
        if (action instanceof FilesSearchReducer.Action.Error) {
            return handleSearchError(state, ((FilesSearchReducer.Action.Error) action).getError());
        }
        if (action instanceof FilesSearchReducer.Action.FiltersButtonClicked) {
            return new ReducerResult<>(State.copy$default(state, null, false, null, 0, null, null, SearchRoute.FilesFilters.INSTANCE, null, false, null, null, false, null, null, 16319, null), null, 2, null);
        }
        return action instanceof FilesSearchReducer.Action.OnFiltersUpdated ? rerunSearchWithUpdatedFilters(state) : new ReducerResult<>(state, null, 2, null);
    }

    private final ReducerResult<State, Action> rerunSearchWithUpdatedFilters(State state) {
        if (StringsKt.isBlank(state.getQuery())) {
            return new ReducerResult<>(state, null, 2, null);
        }
        return new ReducerResult<>(State.copy$default(state, null, false, null, 0, IdentifiedListKt.emptyIdentifiedList(), ScreenState.Loading.INSTANCE, null, null, false, null, null, false, null, null, 16199, null), new Effect(Action.PerformSearch.INSTANCE));
    }

    private final ReducerResult<State, Action> reduceNotesSearchAction(State state, NotesSearchReducer.Action action) {
        ScreenState.Loaded loaded;
        if (!(action instanceof NotesSearchReducer.Action.SearchResultsReceived)) {
            return action instanceof NotesSearchReducer.Action.Error ? handleSearchError(state, ((NotesSearchReducer.Action.Error) action).getError()) : new ReducerResult<>(state, null, 2, null);
        }
        NotesSearchReducer.Action.SearchResultsReceived searchResultsReceived = (NotesSearchReducer.Action.SearchResultsReceived) action;
        IdentifiedList<String, SearchItemReducer.State> identifiedListMergeItems = mergeItems(state.getSearchItems(), toIdentifiedList(searchResultsReceived.getResult()));
        if (identifiedListMergeItems.isEmpty()) {
            loaded = ScreenState.EmptyResults.INSTANCE;
        } else {
            loaded = ScreenState.Loaded.INSTANCE;
        }
        return new ReducerResult<>(State.copy$default(state, null, false, null, searchResultsReceived.getResult().getLimit() + searchResultsReceived.getResult().getOffset(), identifiedListMergeItems, loaded, null, Long.valueOf(searchResultsReceived.getResult().getTotalCount()), false, null, null, false, null, null, 16199, null), null, 2, null);
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }
}

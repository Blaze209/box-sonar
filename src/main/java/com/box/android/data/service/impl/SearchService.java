package com.box.android.data.service.impl;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKt;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.datasource.search.FilesSearchRemoteDataSource;
import com.box.android.domain.configuration.DataPolicy;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.hubs.HubModel;
import com.box.android.domain.models.hubs.HubsDirection;
import com.box.android.domain.models.hubs.HubsSort;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.models.search.SearchMode;
import com.box.android.domain.models.search.SearchResult;
import com.box.android.domain.services.ISearchService;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxIterator;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.facebook.react.uimanager.ViewProps;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: SearchService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 62\u00020\u0001:\u00016B9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ:\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u001bJ0\u0010\u001c\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u001d\u0012\u0004\u0012\u00020\u00120\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001fH\u0096@¢\u0006\u0002\u0010 J0\u0010!\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u001d\u0012\u0004\u0012\u00020\u00120\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001fH\u0096@¢\u0006\u0002\u0010 JP\u0010\"\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u001d\u0012\u0004\u0012\u00020\u00120\u00102\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u00142\u001e\u0010$\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u001d0%H\u0082@¢\u0006\u0002\u0010&J\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00140\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0096@¢\u0006\u0002\u0010(JN\u0010)\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00120\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u000201H\u0096@¢\u0006\u0002\u00102J2\u00103\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u00120\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u00105R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/box/android/data/service/impl/SearchService;", "Lcom/box/android/domain/services/ISearchService;", "hubsService", "Lcom/box/android/data/service/impl/HubsService;", "filesSearchRemoteDataSource", "Lcom/box/android/data/datasource/search/FilesSearchRemoteDataSource;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "dataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/box/android/data/service/impl/HubsService;Lcom/box/android/data/datasource/search/FilesSearchRemoteDataSource;Lcom/box/android/domain/services/IdMappingService;Landroidx/datastore/core/DataStore;Lcom/squareup/moshi/Moshi;)V", "searchHubs", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/search/SearchResult$HubSearchResult;", "Lcom/box/android/domain/models/DomainError;", "query", "", "offset", "", "sortBy", "Lcom/box/android/domain/models/hubs/HubsSort;", "sortDirection", "Lcom/box/android/domain/models/hubs/HubsDirection;", "(Ljava/lang/String;ILcom/box/android/domain/models/hubs/HubsSort;Lcom/box/android/domain/models/hubs/HubsDirection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveQuery", "", "searchMode", "Lcom/box/android/domain/models/search/SearchMode;", "(Ljava/lang/String;Lcom/box/android/domain/models/search/SearchMode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteQuery", "updateQueries", "errorMessage", ViewProps.TRANSFORM, "Lkotlin/Function1;", "(Lcom/box/android/domain/models/search/SearchMode;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecentQueries", "(Lcom/box/android/domain/models/search/SearchMode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchFiles", "Lcom/box/android/domain/models/search/SearchResult$FileSearchResult;", "filters", "Lcom/box/android/domain/models/search/FilesSearchFilters;", "ancestorFolderId", "Lcom/box/android/domain/models/ItemId;", BoxIterator.FIELD_LIMIT, "includeRecentSharedLinks", "", "(Ljava/lang/String;ILcom/box/android/domain/models/search/FilesSearchFilters;Lcom/box/android/domain/models/ItemId;IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchNotes", "Lcom/box/android/domain/models/search/SearchResult$NoteSearchResult;", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SearchService implements ISearchService {
    private static final ParameterizedType LIST_TYPE = Types.newParameterizedType(List.class, String.class);
    private static final int MAX_RECENT_QUERIES = 4;
    private final DataStore<Preferences> dataStore;
    private final FilesSearchRemoteDataSource filesSearchRemoteDataSource;
    private final HubsService hubsService;
    private final IdMappingService idMappingService;
    private final Moshi moshi;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.SearchService$getRecentQueries$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.SearchService", f = "SearchService.kt", i = {0, 0}, l = {109}, m = "getRecentQueries", n = {"searchMode", "key"}, s = {"L$0", "L$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SearchService.this.getRecentQueries(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.SearchService$searchFiles$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SearchService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.SearchService", f = "SearchService.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {126, 128}, m = "searchFiles", n = {"query", "filters", "ancestorFolderId", "it", "offset", BoxIterator.FIELD_LIMIT, "includeRecentSharedLinks", "$i$a$-let-SearchService$searchFiles$ancestorFolderBoxId$1", "query", "filters", "ancestorFolderId", "ancestorFolderBoxId", "offset", BoxIterator.FIELD_LIMIT, "includeRecentSharedLinks"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "Z$0", "I$2", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "Z$0"}, v = 1)
    static final class C15191 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C15191(Continuation<? super C15191> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SearchService.this.searchFiles(null, 0, null, null, 0, false, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.SearchService$searchHubs$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SearchService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.SearchService", f = "SearchService.kt", i = {0, 0, 0, 0}, l = {66}, m = "searchHubs", n = {"query", "sortBy", "sortDirection", "offset"}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 1)
    static final class C15201 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C15201(Continuation<? super C15201> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SearchService.this.searchHubs(null, 0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.SearchService$searchNotes$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SearchService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.SearchService", f = "SearchService.kt", i = {0, 0, 0}, l = {150}, m = "searchNotes", n = {"query", "offset", BoxIterator.FIELD_LIMIT}, s = {"L$0", "I$0", "I$1"}, v = 1)
    static final class C15211 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C15211(Continuation<? super C15211> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SearchService.this.searchNotes(null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.SearchService$updateQueries$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SearchService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.SearchService", f = "SearchService.kt", i = {0, 0, 0, 0, 0, 0}, l = {96}, m = "updateQueries", n = {"searchMode", "errorMessage", ViewProps.TRANSFORM, "updatedQueries", "key", "adapter"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 1)
    static final class C15221 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C15221(Continuation<? super C15221> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SearchService.this.updateQueries(null, null, null, this);
        }
    }

    @Inject
    public SearchService(HubsService hubsService, FilesSearchRemoteDataSource filesSearchRemoteDataSource, IdMappingService idMappingService, @Named("recent_search_queries") DataStore<Preferences> dataStore, Moshi moshi) {
        Intrinsics.checkNotNullParameter(hubsService, "hubsService");
        Intrinsics.checkNotNullParameter(filesSearchRemoteDataSource, "filesSearchRemoteDataSource");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.hubsService = hubsService;
        this.filesSearchRemoteDataSource = filesSearchRemoteDataSource;
        this.idMappingService = idMappingService;
        this.dataStore = dataStore;
        this.moshi = moshi;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.ISearchService
    public Object searchHubs(String str, int i, HubsSort hubsSort, HubsDirection hubsDirection, Continuation<? super Result<SearchResult.HubSearchResult, ? extends DomainError>> continuation) {
        C15201 c15201;
        if (continuation instanceof C15201) {
            c15201 = (C15201) continuation;
            if ((c15201.label & Integer.MIN_VALUE) != 0) {
                c15201.label -= Integer.MIN_VALUE;
            } else {
                c15201 = new C15201(continuation);
            }
        } else {
            c15201 = new C15201(continuation);
        }
        Object objLastOrNull = c15201.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c15201.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objLastOrNull);
            Flow<Result<List<HubModel>, DomainError>> hubs = this.hubsService.getHubs(hubsSort, hubsDirection, DataPolicy.REMOTE, str);
            c15201.L$0 = SpillingKt.nullOutSpilledVariable(str);
            c15201.L$1 = SpillingKt.nullOutSpilledVariable(hubsSort);
            c15201.L$2 = SpillingKt.nullOutSpilledVariable(hubsDirection);
            c15201.I$0 = i;
            c15201.label = 1;
            objLastOrNull = FlowKt.lastOrNull(hubs, c15201);
            if (objLastOrNull == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i3 = c15201.I$0;
            ResultKt.throwOnFailure(objLastOrNull);
        }
        Result result = (Result) objLastOrNull;
        if (result == null) {
            return new Result.Error(new DomainError.CustomError("Failed to get search result"));
        }
        if (result instanceof Result.Success) {
            return new Result.Success(new SearchResult.HubSearchResult((List) ((Result.Success) result).getValue(), 0));
        }
        if (result instanceof Result.Error) {
            return result;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.box.android.domain.services.ISearchService
    public Object saveQuery(final String str, SearchMode searchMode, Continuation<? super Result<? extends List<String>, ? extends DomainError>> continuation) {
        return StringsKt.isBlank(str) ? new Result.Error(new DomainError.CustomError("Query is blank")) : updateQueries(searchMode, "Failed to save search query", new Function1() { // from class: com.box.android.data.service.impl.SearchService$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SearchService.saveQuery$lambda$0(str, (List) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List saveQuery$lambda$0(String str, List current) {
        Intrinsics.checkNotNullParameter(current, "current");
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        listCreateListBuilder.add(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : current) {
            if (!Intrinsics.areEqual((String) obj, str)) {
                arrayList.add(obj);
            }
        }
        listCreateListBuilder.addAll(arrayList);
        return CollectionsKt.take(CollectionsKt.build(listCreateListBuilder), 4);
    }

    @Override // com.box.android.domain.services.ISearchService
    public Object deleteQuery(final String str, SearchMode searchMode, Continuation<? super Result<? extends List<String>, ? extends DomainError>> continuation) {
        return updateQueries(searchMode, "Failed to delete search query", new Function1() { // from class: com.box.android.data.service.impl.SearchService$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SearchService.deleteQuery$lambda$0(str, (List) obj);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List deleteQuery$lambda$0(String str, List current) {
        Intrinsics.checkNotNullParameter(current, "current");
        ArrayList arrayList = new ArrayList();
        for (Object obj : current) {
            if (!Intrinsics.areEqual((String) obj, str)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r14v2, types: [T, java.util.List] */
    public final Object updateQueries(SearchMode searchMode, String str, Function1<? super List<String>, ? extends List<String>> function1, Continuation<? super Result<? extends List<String>, ? extends DomainError>> continuation) {
        C15221 c15221;
        Ref.ObjectRef objectRef;
        if (continuation instanceof C15221) {
            c15221 = (C15221) continuation;
            if ((c15221.label & Integer.MIN_VALUE) != 0) {
                c15221.label -= Integer.MIN_VALUE;
            } else {
                c15221 = new C15221(continuation);
            }
        } else {
            c15221 = new C15221(continuation);
        }
        Object obj = c15221.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c15221.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                objectRef2.element = CollectionsKt.emptyList();
                Preferences.Key preferencesKey = SearchServiceKt.toPreferencesKey(searchMode);
                JsonAdapter jsonAdapterAdapter = this.moshi.adapter(LIST_TYPE);
                Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter, "adapter(...)");
                DataStore<Preferences> dataStore = this.dataStore;
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(jsonAdapterAdapter, preferencesKey, objectRef2, function1, null);
                c15221.L$0 = SpillingKt.nullOutSpilledVariable(searchMode);
                c15221.L$1 = str;
                c15221.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                c15221.L$3 = objectRef2;
                c15221.L$4 = SpillingKt.nullOutSpilledVariable(preferencesKey);
                c15221.L$5 = SpillingKt.nullOutSpilledVariable(jsonAdapterAdapter);
                c15221.label = 1;
                if (PreferencesKt.edit(dataStore, anonymousClass2, c15221) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef = (Ref.ObjectRef) c15221.L$3;
                str = (String) c15221.L$1;
                ResultKt.throwOnFailure(obj);
            }
            return new Result.Success(objectRef.element);
        } catch (Exception e) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), str, e);
            return new Result.Error(new DomainError.CustomError(str));
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.SearchService$updateQueries$2, reason: invalid class name */
    /* JADX INFO: compiled from: SearchService.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.SearchService$updateQueries$2", f = "SearchService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {
        final /* synthetic */ JsonAdapter<List<String>> $adapter;
        final /* synthetic */ Preferences.Key<String> $key;
        final /* synthetic */ Function1<List<String>, List<String>> $transform;
        final /* synthetic */ Ref.ObjectRef<List<String>> $updatedQueries;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(JsonAdapter<List<String>> jsonAdapter, Preferences.Key<String> key, Ref.ObjectRef<List<String>> objectRef, Function1<? super List<String>, ? extends List<String>> function1, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$adapter = jsonAdapter;
            this.$key = key;
            this.$updatedQueries = objectRef;
            this.$transform = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$adapter, this.$key, this.$updatedQueries, this.$transform, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(MutablePreferences mutablePreferences, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(mutablePreferences, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r4v6, types: [T, java.lang.Object] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            MutablePreferences mutablePreferences = (MutablePreferences) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            JsonAdapter<List<String>> jsonAdapter = this.$adapter;
            String str = (String) mutablePreferences.get(this.$key);
            if (str == null) {
                str = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            }
            List<String> listFromJson = jsonAdapter.fromJson(str);
            if (listFromJson == null) {
                listFromJson = CollectionsKt.emptyList();
            }
            this.$updatedQueries.element = this.$transform.invoke(listFromJson);
            mutablePreferences.set(this.$key, this.$adapter.toJson(this.$updatedQueries.element));
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.ISearchService
    public Object getRecentQueries(SearchMode searchMode, Continuation<? super List<String>> continuation) {
        AnonymousClass1 anonymousClass1;
        Preferences.Key key;
        List list;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Preferences.Key preferencesKey = SearchServiceKt.toPreferencesKey(searchMode);
            Flow<Preferences> data = this.dataStore.getData();
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(searchMode);
            anonymousClass1.L$1 = preferencesKey;
            anonymousClass1.label = 1;
            Object objFirst = FlowKt.first(data, anonymousClass1);
            if (objFirst == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = objFirst;
            key = preferencesKey;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            key = (Preferences.Key) anonymousClass1.L$1;
            ResultKt.throwOnFailure(obj);
        }
        JsonAdapter jsonAdapterAdapter = this.moshi.adapter(LIST_TYPE);
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter, "adapter(...)");
        String str = (String) ((Preferences) obj).get(key);
        return (str == null || (list = (List) jsonAdapterAdapter.fromJson(str)) == null) ? CollectionsKt.emptyList() : list;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:35:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:37:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:38:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:40:0x0102  */
    /* JADX WARN: Code duplicated, block: B:41:0x0107  */
    /* JADX WARN: Code duplicated, block: B:43:0x010a  */
    /* JADX WARN: Code duplicated, block: B:44:0x010f  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x013c, code lost:
    
        if (r0 == r3) goto L47;
     */
    @Override // com.box.android.domain.services.ISearchService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object searchFiles(java.lang.String r19, int r20, com.box.android.domain.models.search.FilesSearchFilters r21, com.box.android.domain.models.ItemId r22, int r23, boolean r24, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<com.box.android.domain.models.search.SearchResult.FileSearchResult, ? extends com.box.android.domain.models.DomainError>> r25) {
        /*
            Method dump skipped, instruction units count: 442
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.SearchService.searchFiles(java.lang.String, int, com.box.android.domain.models.search.FilesSearchFilters, com.box.android.domain.models.ItemId, int, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Override // com.box.android.domain.services.ISearchService
    public Object searchNotes(String str, int i, int i2, Continuation<? super Result<SearchResult.NoteSearchResult, ? extends DomainError>> continuation) {
        C15211 c15211;
        if (continuation instanceof C15211) {
            c15211 = (C15211) continuation;
            if ((c15211.label & Integer.MIN_VALUE) != 0) {
                c15211.label -= Integer.MIN_VALUE;
            } else {
                c15211 = new C15211(continuation);
            }
        } else {
            c15211 = new C15211(continuation);
        }
        C15211 c15212 = c15211;
        Object objSearch$default = c15212.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c15212.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objSearch$default);
            FilesSearchRemoteDataSource filesSearchRemoteDataSource = this.filesSearchRemoteDataSource;
            String value = ItemType.FILE.getValue();
            List listListOf = CollectionsKt.listOf("boxnote");
            Integer numBoxInt = Boxing.boxInt(i);
            c15212.L$0 = SpillingKt.nullOutSpilledVariable(str);
            c15212.I$0 = i;
            c15212.I$1 = i2;
            c15212.label = 1;
            objSearch$default = FilesSearchRemoteDataSource.search$default(filesSearchRemoteDataSource, str, i2, numBoxInt, value, listListOf, null, null, null, true, c15212, 224, null);
            if (objSearch$default == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i4 = c15212.I$1;
            int i5 = c15212.I$0;
            ResultKt.throwOnFailure(objSearch$default);
        }
        Result.Success success = (Result) objSearch$default;
        if (success instanceof Result.Success) {
            FilesSearchRemoteDataSource.SearchResultPage searchResultPage = (FilesSearchRemoteDataSource.SearchResultPage) ((Result.Success) success).getValue();
            List<ItemModel> listMapItemDTOsToDomainModel = DomainErrorMapper.INSTANCE.mapItemDTOsToDomainModel(searchResultPage.getItems());
            ArrayList arrayList = new ArrayList();
            for (Object obj : listMapItemDTOsToDomainModel) {
                if (obj instanceof FileModel) {
                    arrayList.add(obj);
                }
            }
            success = new Result.Success(new SearchResult.NoteSearchResult(SearchServiceKt.associateWithSharedLinks(arrayList, searchResultPage.getAccessibleSharedLinkByItemId(), SearchService$searchNotes$2$1.INSTANCE), searchResultPage.getLimit(), searchResultPage.getOffset(), searchResultPage.getTotalCount()));
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success instanceof Result.Success) {
            return success;
        }
        if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (RemoteError) ((Result.Error) success).getValue(), null, 2, null));
    }
}

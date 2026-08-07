package com.box.android.domain.services;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.hubs.HubsDirection;
import com.box.android.domain.models.hubs.HubsSort;
import com.box.android.domain.models.search.FilesSearchFilters;
import com.box.android.domain.models.search.SearchMode;
import com.box.android.domain.models.search.SearchResult;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxIterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: ISearchService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 $2\u00020\u0001:\u0001$J:\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH¦@¢\u0006\u0002\u0010\u000eJ0\u0010\u000f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0010\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H¦@¢\u0006\u0002\u0010\u0013J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00102\u0006\u0010\u0011\u001a\u00020\u0012H¦@¢\u0006\u0002\u0010\u0015J0\u0010\u0016\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0010\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H¦@¢\u0006\u0002\u0010\u0013JX\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH¦@¢\u0006\u0002\u0010 J6\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u001d\u001a\u00020\tH¦@¢\u0006\u0002\u0010#¨\u0006%À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/ISearchService;", "", "searchHubs", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/search/SearchResult$HubSearchResult;", "Lcom/box/android/domain/models/DomainError;", "query", "", "offset", "", "sortBy", "Lcom/box/android/domain/models/hubs/HubsSort;", "sortDirection", "Lcom/box/android/domain/models/hubs/HubsDirection;", "(Ljava/lang/String;ILcom/box/android/domain/models/hubs/HubsSort;Lcom/box/android/domain/models/hubs/HubsDirection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveQuery", "", "searchMode", "Lcom/box/android/domain/models/search/SearchMode;", "(Ljava/lang/String;Lcom/box/android/domain/models/search/SearchMode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecentQueries", "(Lcom/box/android/domain/models/search/SearchMode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteQuery", "searchFiles", "Lcom/box/android/domain/models/search/SearchResult$FileSearchResult;", "filters", "Lcom/box/android/domain/models/search/FilesSearchFilters;", "ancestorFolderId", "Lcom/box/android/domain/models/ItemId;", BoxIterator.FIELD_LIMIT, "includeRecentSharedLinks", "", "(Ljava/lang/String;ILcom/box/android/domain/models/search/FilesSearchFilters;Lcom/box/android/domain/models/ItemId;IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchNotes", "Lcom/box/android/domain/models/search/SearchResult$NoteSearchResult;", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ISearchService {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int DEFAULT_SEARCH_LIMIT = 20;

    Object deleteQuery(String str, SearchMode searchMode, Continuation<? super Result<? extends List<String>, ? extends DomainError>> continuation);

    Object getRecentQueries(SearchMode searchMode, Continuation<? super List<String>> continuation);

    Object saveQuery(String str, SearchMode searchMode, Continuation<? super Result<? extends List<String>, ? extends DomainError>> continuation);

    Object searchFiles(String str, int i, FilesSearchFilters filesSearchFilters, ItemId itemId, int i2, boolean z, Continuation<? super Result<SearchResult.FileSearchResult, ? extends DomainError>> continuation);

    Object searchHubs(String str, int i, HubsSort hubsSort, HubsDirection hubsDirection, Continuation<? super Result<SearchResult.HubSearchResult, ? extends DomainError>> continuation);

    Object searchNotes(String str, int i, int i2, Continuation<? super Result<SearchResult.NoteSearchResult, ? extends DomainError>> continuation);

    /* JADX INFO: compiled from: ISearchService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object searchFiles$default(ISearchService iSearchService, String str, int i, FilesSearchFilters filesSearchFilters, ItemId itemId, int i2, boolean z, Continuation continuation, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: searchFiles");
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            filesSearchFilters = null;
        }
        if ((i3 & 8) != 0) {
            itemId = null;
        }
        if ((i3 & 16) != 0) {
            i2 = 20;
        }
        if ((i3 & 32) != 0) {
            z = false;
        }
        return iSearchService.searchFiles(str, i, filesSearchFilters, itemId, i2, z, continuation);
    }

    static /* synthetic */ Object searchNotes$default(ISearchService iSearchService, String str, int i, int i2, Continuation continuation, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: searchNotes");
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 20;
        }
        return iSearchService.searchNotes(str, i, i2, continuation);
    }

    /* JADX INFO: compiled from: ISearchService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/box/android/domain/services/ISearchService$Companion;", "", "<init>", "()V", "DEFAULT_SEARCH_LIMIT", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int DEFAULT_SEARCH_LIMIT = 20;

        private Companion() {
        }
    }
}

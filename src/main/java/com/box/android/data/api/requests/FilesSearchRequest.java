package com.box.android.data.api.requests;

import com.box.android.data.api.models.items.ItemsDTO;
import com.box.android.data.api.models.items.SearchResultsDTO;
import com.box.androidsdk.content.models.BoxIterator;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* JADX INFO: compiled from: FilesSearchRequest.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J´\u0001\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0005H§@¢\u0006\u0002\u0010\u0014J´\u0001\u0010\u0015\u001a\u00020\u00162\b\b\u0001\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0005H§@¢\u0006\u0002\u0010\u0014¨\u0006\u0017À\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/requests/FilesSearchRequest;", "", "search", "Lcom/box/android/data/api/models/items/ItemsDTO;", "query", "", BoxIterator.FIELD_LIMIT, "", "offset", "scope", "type", "fileExtensions", "ancestorFolderIds", "updatedAtRange", "createdAtRange", "sizeRange", "ownerUserIds", "trashContent", "contentTypes", "fields", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchWithSharedLinks", "Lcom/box/android/data/api/models/items/SearchResultsDTO;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface FilesSearchRequest {
    @GET("search")
    Object search(@Query("query") String str, @Query(BoxIterator.FIELD_LIMIT) Integer num, @Query("offset") Integer num2, @Query("scope") String str2, @Query("type") String str3, @Query("file_extensions") String str4, @Query("ancestor_folder_ids") String str5, @Query("updated_at_range") String str6, @Query("created_at_range") String str7, @Query("size_range") String str8, @Query("owner_user_ids") String str9, @Query("trash_content") String str10, @Query("content_types") String str11, @Query("fields") String str12, Continuation<? super ItemsDTO> continuation);

    @GET("search?include_recent_shared_links=true")
    Object searchWithSharedLinks(@Query("query") String str, @Query(BoxIterator.FIELD_LIMIT) Integer num, @Query("offset") Integer num2, @Query("scope") String str2, @Query("type") String str3, @Query("file_extensions") String str4, @Query("ancestor_folder_ids") String str5, @Query("updated_at_range") String str6, @Query("created_at_range") String str7, @Query("size_range") String str8, @Query("owner_user_ids") String str9, @Query("trash_content") String str10, @Query("content_types") String str11, @Query("fields") String str12, Continuation<? super SearchResultsDTO> continuation);

    /* JADX INFO: compiled from: FilesSearchRequest.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object search$default(FilesSearchRequest filesSearchRequest, String str, Integer num, Integer num2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Continuation continuation, int i, Object obj) {
        if (obj == null) {
            return filesSearchRequest.search(str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : str7, (i & 512) != 0 ? null : str8, (i & 1024) != 0 ? null : str9, (i & 2048) != 0 ? null : str10, (i & 4096) != 0 ? null : str11, (i & 8192) != 0 ? null : str12, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: search");
    }

    static /* synthetic */ Object searchWithSharedLinks$default(FilesSearchRequest filesSearchRequest, String str, Integer num, Integer num2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, Continuation continuation, int i, Object obj) {
        if (obj == null) {
            return filesSearchRequest.searchWithSharedLinks(str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : str7, (i & 512) != 0 ? null : str8, (i & 1024) != 0 ? null : str9, (i & 2048) != 0 ? null : str10, (i & 4096) != 0 ? null : str11, (i & 8192) != 0 ? null : str12, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: searchWithSharedLinks");
    }
}

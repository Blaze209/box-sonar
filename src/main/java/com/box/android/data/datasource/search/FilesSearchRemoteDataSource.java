package com.box.android.data.datasource.search;

import com.box.android.data.api.models.items.IItemDTO;
import com.box.android.data.api.models.items.ItemDTOFields;
import com.box.android.data.api.models.items.ItemsDTO;
import com.box.android.data.api.models.items.SearchResultEntryDTO;
import com.box.android.data.api.models.items.SearchResultsDTO;
import com.box.android.data.api.requests.FilesSearchRequest;
import com.box.android.data.datasource.ErrorUtil;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxIterator;
import com.box.androidsdk.content.utils.BoxDateFormat;
import com.facebook.react.modules.dialog.AlertFragment;
import com.squareup.moshi.Moshi;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FilesSearchRemoteDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001!B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u008e\u0001\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0086@¢\u0006\u0002\u0010\u001cJ\u0014\u0010\u001d\u001a\u00020\n*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000fH\u0002J\u0014\u0010\u001d\u001a\u00020\n*\u00020 2\u0006\u0010\u001f\u001a\u00020\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/box/android/data/datasource/search/FilesSearchRemoteDataSource;", "", "filesSearchRequest", "Lcom/box/android/data/api/requests/FilesSearchRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/box/android/data/api/requests/FilesSearchRequest;Lcom/squareup/moshi/Moshi;)V", "search", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/data/datasource/search/FilesSearchRemoteDataSource$SearchResultPage;", "Lcom/box/android/data/datasource/errors/RemoteError;", "query", "", BoxIterator.FIELD_LIMIT, "", "offset", "type", "fileExtensions", "", "ancestorFolderId", "modifiedAfter", "Ljava/util/Date;", "sizeRange", "Lkotlin/Pair;", "", "includeRecentSharedLinks", "", "(Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/Date;Lkotlin/Pair;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResultPage", "Lcom/box/android/data/api/models/items/SearchResultsDTO;", "fallbackLimit", "Lcom/box/android/data/api/models/items/ItemsDTO;", "SearchResultPage", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FilesSearchRemoteDataSource {
    private final FilesSearchRequest filesSearchRequest;
    private final Moshi moshi;

    /* JADX INFO: renamed from: com.box.android.data.datasource.search.FilesSearchRemoteDataSource$search$1, reason: invalid class name */
    /* JADX INFO: compiled from: FilesSearchRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.search.FilesSearchRemoteDataSource", f = "FilesSearchRemoteDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {35, 47}, m = "search", n = {"query", "offset", "type", "fileExtensions", "ancestorFolderId", "modifiedAfter", "sizeRange", "joinedSizeRange", "updatedAtRange", "joinedFileExtensions", BoxIterator.FIELD_LIMIT, "includeRecentSharedLinks", "$i$f$resultOf", "$i$a$-resultOf-FilesSearchRemoteDataSource$search$2", "query", "offset", "type", "fileExtensions", "ancestorFolderId", "modifiedAfter", "sizeRange", "joinedSizeRange", "updatedAtRange", "joinedFileExtensions", BoxIterator.FIELD_LIMIT, "includeRecentSharedLinks", "$i$f$resultOf", "$i$a$-resultOf-FilesSearchRemoteDataSource$search$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "Z$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "I$0", "Z$0", "I$1", "I$2"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
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
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FilesSearchRemoteDataSource.this.search(null, 0, null, null, null, null, null, null, false, this);
        }
    }

    @Inject
    public FilesSearchRemoteDataSource(FilesSearchRequest filesSearchRequest, Moshi moshi) {
        Intrinsics.checkNotNullParameter(filesSearchRequest, "filesSearchRequest");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.filesSearchRequest = filesSearchRequest;
        this.moshi = moshi;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object search$default(FilesSearchRemoteDataSource filesSearchRemoteDataSource, String str, int i, Integer num, String str2, List list, String str3, Date date, Pair pair, boolean z, Continuation continuation, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            num = null;
        }
        if ((i2 & 8) != 0) {
            str2 = null;
        }
        if ((i2 & 16) != 0) {
            list = null;
        }
        if ((i2 & 32) != 0) {
            str3 = null;
        }
        if ((i2 & 64) != 0) {
            date = null;
        }
        if ((i2 & 128) != 0) {
            pair = null;
        }
        if ((i2 & 256) != 0) {
            z = false;
        }
        return filesSearchRemoteDataSource.search(str, i, num, str2, list, str3, date, pair, z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    public final Object search(String str, int i, Integer num, String str2, List<String> list, String str3, Date date, Pair<Long, Long> pair, boolean z, Continuation<? super Result<SearchResultPage, ? extends RemoteError>> continuation) {
        AnonymousClass1 anonymousClass1;
        Result.Error error;
        String strJoinToString$default;
        Object obj;
        FilesSearchRemoteDataSource filesSearchRemoteDataSource;
        FilesSearchRemoteDataSource filesSearchRemoteDataSource2;
        SearchResultPage searchResultPage;
        int i2 = i;
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
        Object objSearch$default = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = anonymousClass1.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(objSearch$default);
                String str4 = null;
                if (list == null) {
                    strJoinToString$default = null;
                } else {
                    List<String> list2 = !list.isEmpty() ? list : null;
                    if (list2 != null) {
                        strJoinToString$default = CollectionsKt.joinToString$default(list2, ",", null, null, 0, null, null, 62, null);
                    } else {
                        strJoinToString$default = null;
                    }
                }
                String timeRangeString = BoxDateFormat.getTimeRangeString(date, null);
                if (pair != null) {
                    str4 = pair.getFirst() + "," + pair.getSecond();
                }
                String str5 = str4;
                if (z) {
                    FilesSearchRequest filesSearchRequest = this.filesSearchRequest;
                    Integer numBoxInt = Boxing.boxInt(i2);
                    String all_file_fields_with_representations = ItemDTOFields.INSTANCE.getALL_FILE_FIELDS_WITH_REPRESENTATIONS();
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(num);
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(list);
                    anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(str3);
                    anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(date);
                    anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(pair);
                    anonymousClass1.L$7 = SpillingKt.nullOutSpilledVariable(str5);
                    anonymousClass1.L$8 = SpillingKt.nullOutSpilledVariable(timeRangeString);
                    anonymousClass1.L$9 = SpillingKt.nullOutSpilledVariable(strJoinToString$default);
                    anonymousClass1.L$10 = this;
                    anonymousClass1.I$0 = i2;
                    anonymousClass1.Z$0 = z;
                    anonymousClass1.I$1 = 0;
                    anonymousClass1.I$2 = 0;
                    anonymousClass1.label = 1;
                    AnonymousClass1 anonymousClass2 = anonymousClass1;
                    obj = coroutine_suspended;
                    objSearch$default = FilesSearchRequest.searchWithSharedLinks$default(filesSearchRequest, str, numBoxInt, num, null, str2, strJoinToString$default, str3, timeRangeString, null, str5, null, null, null, all_file_fields_with_representations, anonymousClass2, 7432, null);
                    if (objSearch$default != obj) {
                        filesSearchRemoteDataSource2 = this;
                        searchResultPage = filesSearchRemoteDataSource2.toSearchResultPage((SearchResultsDTO) objSearch$default, i2);
                    }
                } else {
                    AnonymousClass1 anonymousClass3 = anonymousClass1;
                    obj = coroutine_suspended;
                    FilesSearchRequest filesSearchRequest2 = this.filesSearchRequest;
                    Integer numBoxInt2 = Boxing.boxInt(i2);
                    String all_file_fields_with_representations2 = ItemDTOFields.INSTANCE.getALL_FILE_FIELDS_WITH_REPRESENTATIONS();
                    anonymousClass3.L$0 = SpillingKt.nullOutSpilledVariable(str);
                    anonymousClass3.L$1 = SpillingKt.nullOutSpilledVariable(num);
                    anonymousClass3.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                    anonymousClass3.L$3 = SpillingKt.nullOutSpilledVariable(list);
                    anonymousClass3.L$4 = SpillingKt.nullOutSpilledVariable(str3);
                    anonymousClass3.L$5 = SpillingKt.nullOutSpilledVariable(date);
                    anonymousClass3.L$6 = SpillingKt.nullOutSpilledVariable(pair);
                    anonymousClass3.L$7 = SpillingKt.nullOutSpilledVariable(str5);
                    anonymousClass3.L$8 = SpillingKt.nullOutSpilledVariable(timeRangeString);
                    anonymousClass3.L$9 = SpillingKt.nullOutSpilledVariable(strJoinToString$default);
                    anonymousClass3.L$10 = this;
                    anonymousClass3.I$0 = i2;
                    anonymousClass3.Z$0 = z;
                    anonymousClass3.I$1 = 0;
                    anonymousClass3.I$2 = 0;
                    anonymousClass3.label = 2;
                    objSearch$default = FilesSearchRequest.search$default(filesSearchRequest2, str, numBoxInt2, num, null, str2, strJoinToString$default, str3, timeRangeString, null, str5, null, null, null, all_file_fields_with_representations2, anonymousClass3, 7432, null);
                    if (objSearch$default != obj) {
                        filesSearchRemoteDataSource = this;
                        searchResultPage = filesSearchRemoteDataSource.toSearchResultPage((ItemsDTO) objSearch$default, i2);
                    }
                }
                return obj;
            }
            if (i3 == 1) {
                int i4 = anonymousClass1.I$2;
                int i5 = anonymousClass1.I$1;
                boolean z2 = anonymousClass1.Z$0;
                i2 = anonymousClass1.I$0;
                filesSearchRemoteDataSource2 = (FilesSearchRemoteDataSource) anonymousClass1.L$10;
                ResultKt.throwOnFailure(objSearch$default);
                searchResultPage = filesSearchRemoteDataSource2.toSearchResultPage((SearchResultsDTO) objSearch$default, i2);
            } else {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i6 = anonymousClass1.I$2;
                int i7 = anonymousClass1.I$1;
                boolean z3 = anonymousClass1.Z$0;
                i2 = anonymousClass1.I$0;
                filesSearchRemoteDataSource = (FilesSearchRemoteDataSource) anonymousClass1.L$10;
                ResultKt.throwOnFailure(objSearch$default);
                searchResultPage = filesSearchRemoteDataSource.toSearchResultPage((ItemsDTO) objSearch$default, i2);
            }
            error = new Result.Success(searchResultPage);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), this.moshi));
    }

    private final SearchResultPage toSearchResultPage(SearchResultsDTO searchResultsDTO, int i) {
        List<SearchResultEntryDTO> entries = searchResultsDTO.getEntries();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entries, 10));
        Iterator<T> it = entries.iterator();
        while (it.hasNext()) {
            arrayList.add(((SearchResultEntryDTO) it.next()).getItem());
        }
        ArrayList arrayList2 = arrayList;
        Long limit = searchResultsDTO.getLimit();
        if (limit != null) {
            i = (int) limit.longValue();
        }
        int i2 = i;
        Long offset = searchResultsDTO.getOffset();
        int iLongValue = offset != null ? (int) offset.longValue() : 0;
        long totalCount = searchResultsDTO.getTotalCount();
        List<SearchResultEntryDTO> entries2 = searchResultsDTO.getEntries();
        ArrayList arrayList3 = new ArrayList();
        for (SearchResultEntryDTO searchResultEntryDTO : entries2) {
            String accessibleViaSharedLink = searchResultEntryDTO.getAccessibleViaSharedLink();
            Pair pair = null;
            if (accessibleViaSharedLink != null) {
                if (accessibleViaSharedLink.length() <= 0) {
                    accessibleViaSharedLink = null;
                }
                if (accessibleViaSharedLink != null) {
                    pair = TuplesKt.to(searchResultEntryDTO.getItem().getId(), accessibleViaSharedLink);
                }
            }
            if (pair != null) {
                arrayList3.add(pair);
            }
        }
        return new SearchResultPage(arrayList2, i2, iLongValue, totalCount, MapsKt.toMap(arrayList3));
    }

    private final SearchResultPage toSearchResultPage(ItemsDTO itemsDTO, int i) {
        List<IItemDTO> entries = itemsDTO.getEntries();
        Long limit = itemsDTO.getLimit();
        if (limit != null) {
            i = (int) limit.longValue();
        }
        int i2 = i;
        Long offset = itemsDTO.getOffset();
        return new SearchResultPage(entries, i2, offset != null ? (int) offset.longValue() : 0, itemsDTO.getTotalCount(), null, 16, null);
    }

    /* JADX INFO: compiled from: FilesSearchRemoteDataSource.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\u0015\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JM\u0010\u001d\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0006HÖ\u0001J\t\u0010\"\u001a\u00020\fHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Lcom/box/android/data/datasource/search/FilesSearchRemoteDataSource$SearchResultPage;", "", AlertFragment.ARG_ITEMS, "", "Lcom/box/android/data/api/models/items/IItemDTO;", BoxIterator.FIELD_LIMIT, "", "offset", "totalCount", "", "accessibleSharedLinkByItemId", "", "", "<init>", "(Ljava/util/List;IIJLjava/util/Map;)V", "getItems", "()Ljava/util/List;", "getLimit", "()I", "getOffset", "getTotalCount", "()J", "getAccessibleSharedLinkByItemId", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SearchResultPage {
        private final Map<String, String> accessibleSharedLinkByItemId;
        private final List<IItemDTO> items;
        private final int limit;
        private final int offset;
        private final long totalCount;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SearchResultPage copy$default(SearchResultPage searchResultPage, List list, int i, int i2, long j, Map map, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                list = searchResultPage.items;
            }
            if ((i3 & 2) != 0) {
                i = searchResultPage.limit;
            }
            if ((i3 & 4) != 0) {
                i2 = searchResultPage.offset;
            }
            if ((i3 & 8) != 0) {
                j = searchResultPage.totalCount;
            }
            if ((i3 & 16) != 0) {
                map = searchResultPage.accessibleSharedLinkByItemId;
            }
            Map map2 = map;
            int i4 = i2;
            return searchResultPage.copy(list, i, i4, j, map2);
        }

        public final List<IItemDTO> component1() {
            return this.items;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getLimit() {
            return this.limit;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getOffset() {
            return this.offset;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final long getTotalCount() {
            return this.totalCount;
        }

        public final Map<String, String> component5() {
            return this.accessibleSharedLinkByItemId;
        }

        public final SearchResultPage copy(List<? extends IItemDTO> items, int limit, int offset, long totalCount, Map<String, String> accessibleSharedLinkByItemId) {
            Intrinsics.checkNotNullParameter(items, "items");
            Intrinsics.checkNotNullParameter(accessibleSharedLinkByItemId, "accessibleSharedLinkByItemId");
            return new SearchResultPage(items, limit, offset, totalCount, accessibleSharedLinkByItemId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SearchResultPage)) {
                return false;
            }
            SearchResultPage searchResultPage = (SearchResultPage) other;
            return Intrinsics.areEqual(this.items, searchResultPage.items) && this.limit == searchResultPage.limit && this.offset == searchResultPage.offset && this.totalCount == searchResultPage.totalCount && Intrinsics.areEqual(this.accessibleSharedLinkByItemId, searchResultPage.accessibleSharedLinkByItemId);
        }

        public int hashCode() {
            return (((((((this.items.hashCode() * 31) + Integer.hashCode(this.limit)) * 31) + Integer.hashCode(this.offset)) * 31) + Long.hashCode(this.totalCount)) * 31) + this.accessibleSharedLinkByItemId.hashCode();
        }

        public String toString() {
            return "SearchResultPage(items=" + this.items + ", limit=" + this.limit + ", offset=" + this.offset + ", totalCount=" + this.totalCount + ", accessibleSharedLinkByItemId=" + this.accessibleSharedLinkByItemId + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public SearchResultPage(List<? extends IItemDTO> items, int i, int i2, long j, Map<String, String> accessibleSharedLinkByItemId) {
            Intrinsics.checkNotNullParameter(items, "items");
            Intrinsics.checkNotNullParameter(accessibleSharedLinkByItemId, "accessibleSharedLinkByItemId");
            this.items = items;
            this.limit = i;
            this.offset = i2;
            this.totalCount = j;
            this.accessibleSharedLinkByItemId = accessibleSharedLinkByItemId;
        }

        public final List<IItemDTO> getItems() {
            return this.items;
        }

        public final int getLimit() {
            return this.limit;
        }

        public final int getOffset() {
            return this.offset;
        }

        public final long getTotalCount() {
            return this.totalCount;
        }

        public /* synthetic */ SearchResultPage(List list, int i, int i2, long j, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, i, i2, j, (i3 & 16) != 0 ? MapsKt.emptyMap() : map);
        }

        public final Map<String, String> getAccessibleSharedLinkByItemId() {
            return this.accessibleSharedLinkByItemId;
        }
    }
}

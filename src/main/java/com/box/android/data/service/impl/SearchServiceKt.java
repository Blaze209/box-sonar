package com.box.android.data.service.impl;

import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.media3.common.C;
import androidx.media3.exoplayer.dash.DashMediaSource;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.models.search.FilesSearchFilters;
import com.box.android.domain.models.search.SearchMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SearchService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aX\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u0002H\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u0002H\u00020\tH\u0002\u001a\u0012\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b*\u00020\fH\u0002\u001a\u000e\u0010\u000f\u001a\u0004\u0018\u00010\u0007*\u00020\u0010H\u0002\u001a\u0014\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0001*\u00020\u0010H\u0002\u001a\u000e\u0010\u0012\u001a\u0004\u0018\u00010\u0013*\u00020\u0010H\u0002\u001a\u001a\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0015*\u00020\u0010H\u0002\"\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"associateWithSharedLinks", "", "R", "I", "Lcom/box/android/domain/models/item/ItemModel;", "sharedLinksById", "", "", "itemFactory", "Lkotlin/Function2;", "toPreferencesKey", "Landroidx/datastore/preferences/core/Preferences$Key;", "Lcom/box/android/domain/models/search/SearchMode;", "ONE_MB", "", "toType", "Lcom/box/android/domain/models/search/FilesSearchFilters;", "toFileExtensions", "toModifiedAfter", "Ljava/util/Date;", "toSizeRange", "Lkotlin/Pair;", "data_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SearchServiceKt {
    private static final long ONE_MB = 1000000;

    /* JADX INFO: Access modifiers changed from: private */
    public static final <I extends ItemModel, R> List<R> associateWithSharedLinks(List<? extends I> list, Map<String, String> map, Function2<? super I, ? super String, ? extends R> function2) {
        String str;
        List<? extends I> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            ItemModel itemModel = (ItemModel) it.next();
            String strBoxIdOrNull = itemModel.boxIdOrNull();
            String str2 = null;
            if (strBoxIdOrNull != null && (str = map.get(strBoxIdOrNull)) != null && !StringsKt.isBlank(str)) {
                str2 = str;
            }
            arrayList.add(function2.invoke(itemModel, str2));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Preferences.Key<String> toPreferencesKey(SearchMode searchMode) {
        return PreferencesKeys.stringKey("recent_search_queries_" + searchMode.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String toType(FilesSearchFilters filesSearchFilters) {
        if (filesSearchFilters.getItemTypes().isEmpty()) {
            return null;
        }
        return filesSearchFilters.getItemTypes().contains(FilesSearchFilters.FilterItemType.Folder.INSTANCE) ? ItemType.FOLDER.getValue() : ItemType.FILE.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<String> toFileExtensions(FilesSearchFilters filesSearchFilters) {
        if (filesSearchFilters.getItemTypes().isEmpty() || filesSearchFilters.getItemTypes().contains(FilesSearchFilters.FilterItemType.Folder.INSTANCE)) {
            return null;
        }
        Set<FilesSearchFilters.FilterItemType> itemTypes = filesSearchFilters.getItemTypes();
        ArrayList arrayList = new ArrayList();
        for (Object obj : itemTypes) {
            if (obj instanceof FilesSearchFilters.FilterItemType.FileType) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList2, ((FilesSearchFilters.FilterItemType.FileType) it.next()).getExtensions());
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Date toModifiedAfter(FilesSearchFilters filesSearchFilters) {
        Calendar calendar = Calendar.getInstance();
        FilesSearchFilters.ModifiedAfterDate modifiedDate = filesSearchFilters.getModifiedDate();
        if (Intrinsics.areEqual(modifiedDate, FilesSearchFilters.ModifiedAfterDate.Any.INSTANCE)) {
            return null;
        }
        if (Intrinsics.areEqual(modifiedDate, FilesSearchFilters.ModifiedAfterDate.PastDay.INSTANCE)) {
            calendar.add(5, -1);
            return calendar.getTime();
        }
        if (Intrinsics.areEqual(modifiedDate, FilesSearchFilters.ModifiedAfterDate.PastWeek.INSTANCE)) {
            calendar.add(5, -7);
            return calendar.getTime();
        }
        if (Intrinsics.areEqual(modifiedDate, FilesSearchFilters.ModifiedAfterDate.PastMonth.INSTANCE)) {
            calendar.add(2, -1);
            return calendar.getTime();
        }
        if (!Intrinsics.areEqual(modifiedDate, FilesSearchFilters.ModifiedAfterDate.PastYear.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        calendar.add(1, -1);
        return calendar.getTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair<Long, Long> toSizeRange(FilesSearchFilters filesSearchFilters) {
        FilesSearchFilters.Size size = filesSearchFilters.getSize();
        if (Intrinsics.areEqual(size, FilesSearchFilters.Size.Any.INSTANCE)) {
            return null;
        }
        if (Intrinsics.areEqual(size, FilesSearchFilters.Size.LessThan1Mb.INSTANCE)) {
            return TuplesKt.to(0L, 1000000L);
        }
        if (Intrinsics.areEqual(size, FilesSearchFilters.Size.From1To5Mb.INSTANCE)) {
            return TuplesKt.to(1000000L, Long.valueOf(DashMediaSource.MIN_LIVE_DEFAULT_START_POSITION_US));
        }
        if (Intrinsics.areEqual(size, FilesSearchFilters.Size.From5To25Mb.INSTANCE)) {
            return TuplesKt.to(Long.valueOf(DashMediaSource.MIN_LIVE_DEFAULT_START_POSITION_US), 25000000L);
        }
        if (Intrinsics.areEqual(size, FilesSearchFilters.Size.From25To100Mb.INSTANCE)) {
            return TuplesKt.to(25000000L, 100000000L);
        }
        if (Intrinsics.areEqual(size, FilesSearchFilters.Size.From100MbTo1Gb.INSTANCE)) {
            return TuplesKt.to(100000000L, Long.valueOf(C.NANOS_PER_SECOND));
        }
        throw new NoWhenBranchMatchedException();
    }
}

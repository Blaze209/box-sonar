package com.box.android.search.presentation.cpl;

import androidx.media3.common.MimeTypes;
import com.box.android.base.presentation.multiselect.MultiselectReducer;
import com.box.android.browse.cpl.itemsList.ItemReducer;
import com.box.android.cpl.Effect;
import com.box.android.cpl.IdentifiedList;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.WebLinkModel;
import com.box.android.domain.models.search.FilesSearchFilters;
import com.box.android.domain.models.search.FilesSearchFiltersKt;
import com.pspdfkit.analytics.Analytics;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchAnalyticsHelper.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0003\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0002\u001a\u000e\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u000bH\u0002\u001a\f\u0010\f\u001a\u00020\b*\u00020\rH\u0002\u001a\f\u0010\f\u001a\u00020\b*\u00020\u000eH\u0002\u001a\f\u0010\f\u001a\u00020\b*\u00020\u000fH\u0002¨\u0006\u0010"}, d2 = {"reduceSearchAnalytics", "Lcom/box/android/cpl/ReducerResult;", "Lcom/box/android/search/presentation/cpl/SearchReducer$State;", "Lcom/box/android/search/presentation/cpl/SearchReducer$Action;", "Lcom/box/android/search/presentation/cpl/SearchReducer;", "state", Analytics.Data.ACTION, "toItemTypeToken", "", "Lcom/box/android/domain/models/item/ItemModel;", "toFilterTypeToken", "Lcom/box/android/domain/models/search/FilesSearchFilters;", "toToken", "Lcom/box/android/domain/models/search/FilesSearchFilters$FilterItemType;", "Lcom/box/android/domain/models/search/FilesSearchFilters$ModifiedAfterDate;", "Lcom/box/android/domain/models/search/FilesSearchFilters$Size;", "search_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SearchAnalyticsHelperKt {
    public static final ReducerResult<SearchReducer.State, SearchReducer.Action> reduceSearchAnalytics(SearchReducer searchReducer, SearchReducer.State state, SearchReducer.Action action) {
        Intrinsics.checkNotNullParameter(searchReducer, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass1(action, searchReducer, state, null)));
    }

    /* JADX INFO: renamed from: com.box.android.search.presentation.cpl.SearchAnalyticsHelperKt$reduceSearchAnalytics$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchAnalyticsHelper.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.search.presentation.cpl.SearchAnalyticsHelperKt$reduceSearchAnalytics$1", f = "SearchAnalyticsHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ SearchReducer.Action $action;
        final /* synthetic */ SearchReducer.State $state;
        final /* synthetic */ SearchReducer $this_reduceSearchAnalytics;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SearchReducer.Action action, SearchReducer searchReducer, SearchReducer.State state, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$action = action;
            this.$this_reduceSearchAnalytics = searchReducer;
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.$action, this.$this_reduceSearchAnalytics, this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SearchItemReducer.SearchItem searchItem;
            ItemReducer.State state;
            ItemModel itemModel;
            FilesSearchFilters filters;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            SearchReducer.Action action = this.$action;
            if (action instanceof SearchReducer.Action.FilesSearch) {
                FilesSearchReducer.Action action2 = ((SearchReducer.Action.FilesSearch) action).getAction();
                if (action2 instanceof FilesSearchReducer.Action.UpdateFilters) {
                    this.$this_reduceSearchAnalytics.getAnalytics().filterApplied(SearchAnalyticsHelperKt.toFilterTypeToken(((FilesSearchReducer.Action.UpdateFilters) action2).getNewFilters()));
                } else if (action2 instanceof FilesSearchReducer.Action.RemoveFilter) {
                    SearchModeState searchModeState = this.$state.getSearchModeState();
                    FilesSearchReducer.State state2 = searchModeState instanceof FilesSearchReducer.State ? (FilesSearchReducer.State) searchModeState : null;
                    if (state2 == null || (filters = state2.getFilters()) == null) {
                        return Unit.INSTANCE;
                    }
                    FilesSearchFilters filesSearchFiltersRemoved = FilesSearchFiltersKt.removed(filters, ((FilesSearchReducer.Action.RemoveFilter) action2).getChip());
                    if (filesSearchFiltersRemoved.isAnyFilterApplied()) {
                        this.$this_reduceSearchAnalytics.getAnalytics().filterApplied(SearchAnalyticsHelperKt.toFilterTypeToken(filesSearchFiltersRemoved));
                    }
                }
            } else if (action instanceof SearchReducer.Action.ClearFiltersClicked) {
                this.$this_reduceSearchAnalytics.getAnalytics().clearFiltersTapped();
            } else if (action instanceof SearchReducer.Action.RecentItemClicked) {
                this.$this_reduceSearchAnalytics.getAnalytics().recentItemTapped();
            } else if (action instanceof SearchReducer.Action.RecentAiSessionClicked) {
                this.$this_reduceSearchAnalytics.getAnalytics().recentAiSessionTapped();
            } else if (action instanceof SearchReducer.Action.AskBoxAiClicked) {
                this.$this_reduceSearchAnalytics.getAnalytics().askAiTapped();
            } else if (action instanceof SearchReducer.Action.SearchAction) {
                SearchItemReducer.Action action3 = ((SearchReducer.Action.SearchAction) action).getAction();
                if ((action3 instanceof SearchItemReducer.Action.FileAction) && (((SearchItemReducer.Action.FileAction) action3).getAction() instanceof ItemReducer.Action.Clicked) && !(this.$state.getMultiselect() instanceof MultiselectReducer.State.Selecting)) {
                    SearchItemReducer.State state3 = (SearchItemReducer.State) this.$state.getSearchItems().getById(((SearchReducer.Action.SearchAction) this.$action).getId());
                    if (state3 == null || (searchItem = state3.getSearchItem()) == null) {
                        return Unit.INSTANCE;
                    }
                    SearchItemReducer.SearchItem.FileItem fileItem = searchItem instanceof SearchItemReducer.SearchItem.FileItem ? (SearchItemReducer.SearchItem.FileItem) searchItem : null;
                    if (fileItem == null || (state = fileItem.getState()) == null || (itemModel = state.getItemModel()) == null) {
                        return Unit.INSTANCE;
                    }
                    IdentifiedList<String, SearchItemReducer.State> searchItems = this.$state.getSearchItems();
                    SearchReducer.Action action4 = this.$action;
                    Iterator<SearchItemReducer.State> it = searchItems.iterator();
                    int i = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i = -1;
                            break;
                        }
                        if (Intrinsics.areEqual(it.next().getId(), ((SearchReducer.Action.SearchAction) action4).getId())) {
                            break;
                        }
                        i++;
                    }
                    Integer numBoxInt = Boxing.boxInt(i);
                    if (numBoxInt.intValue() < 0) {
                        numBoxInt = null;
                    }
                    this.$this_reduceSearchAnalytics.getAnalytics().resultTapped(SearchAnalyticsHelperKt.toItemTypeToken(itemModel), numBoxInt != null ? Boxing.boxInt(numBoxInt.intValue() + 1) : null);
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String toItemTypeToken(ItemModel itemModel) {
        if (itemModel instanceof FolderModel) {
            return "folder";
        }
        if (itemModel instanceof WebLinkModel) {
            return "weblink";
        }
        return itemModel instanceof FileModel ? "file" : "unknown";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String toFilterTypeToken(FilesSearchFilters filesSearchFilters) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = filesSearchFilters.getItemTypes().iterator();
        while (it.hasNext()) {
            arrayList.add(toToken((FilesSearchFilters.FilterItemType) it.next()));
        }
        if (!Intrinsics.areEqual(filesSearchFilters.getModifiedDate(), FilesSearchFilters.ModifiedAfterDate.Any.INSTANCE)) {
            arrayList.add(toToken(filesSearchFilters.getModifiedDate()));
        }
        if (!Intrinsics.areEqual(filesSearchFilters.getSize(), FilesSearchFilters.Size.Any.INSTANCE)) {
            arrayList.add(toToken(filesSearchFilters.getSize()));
        }
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        if (arrayList != null) {
            return CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null);
        }
        return null;
    }

    private static final String toToken(FilesSearchFilters.FilterItemType filterItemType) {
        if (Intrinsics.areEqual(filterItemType, FilesSearchFilters.FilterItemType.Folder.INSTANCE)) {
            return "folder";
        }
        if (Intrinsics.areEqual(filterItemType, FilesSearchFilters.FilterItemType.FileType.Audio.INSTANCE)) {
            return MimeTypes.BASE_TYPE_AUDIO;
        }
        if (Intrinsics.areEqual(filterItemType, FilesSearchFilters.FilterItemType.FileType.BoxNote.INSTANCE)) {
            return "boxnote";
        }
        if (Intrinsics.areEqual(filterItemType, FilesSearchFilters.FilterItemType.FileType.Document.INSTANCE)) {
            return "document";
        }
        if (Intrinsics.areEqual(filterItemType, FilesSearchFilters.FilterItemType.FileType.Autocad.INSTANCE)) {
            return "autocad";
        }
        if (Intrinsics.areEqual(filterItemType, FilesSearchFilters.FilterItemType.FileType.Image.INSTANCE)) {
            return "image";
        }
        if (Intrinsics.areEqual(filterItemType, FilesSearchFilters.FilterItemType.FileType.Pdf.INSTANCE)) {
            return "pdf";
        }
        if (Intrinsics.areEqual(filterItemType, FilesSearchFilters.FilterItemType.FileType.Presentation.INSTANCE)) {
            return "presentation";
        }
        if (Intrinsics.areEqual(filterItemType, FilesSearchFilters.FilterItemType.FileType.Spreadsheet.INSTANCE)) {
            return "spreadsheet";
        }
        if (Intrinsics.areEqual(filterItemType, FilesSearchFilters.FilterItemType.FileType.Video.INSTANCE)) {
            return MimeTypes.BASE_TYPE_VIDEO;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final String toToken(FilesSearchFilters.ModifiedAfterDate modifiedAfterDate) {
        if (Intrinsics.areEqual(modifiedAfterDate, FilesSearchFilters.ModifiedAfterDate.Any.INSTANCE)) {
            return "any";
        }
        if (Intrinsics.areEqual(modifiedAfterDate, FilesSearchFilters.ModifiedAfterDate.PastDay.INSTANCE)) {
            return "past_day";
        }
        if (Intrinsics.areEqual(modifiedAfterDate, FilesSearchFilters.ModifiedAfterDate.PastWeek.INSTANCE)) {
            return "past_week";
        }
        if (Intrinsics.areEqual(modifiedAfterDate, FilesSearchFilters.ModifiedAfterDate.PastMonth.INSTANCE)) {
            return "past_month";
        }
        if (Intrinsics.areEqual(modifiedAfterDate, FilesSearchFilters.ModifiedAfterDate.PastYear.INSTANCE)) {
            return "past_year";
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final String toToken(FilesSearchFilters.Size size) {
        if (Intrinsics.areEqual(size, FilesSearchFilters.Size.Any.INSTANCE)) {
            return "any";
        }
        if (Intrinsics.areEqual(size, FilesSearchFilters.Size.LessThan1Mb.INSTANCE)) {
            return "less_than_1_mb";
        }
        if (Intrinsics.areEqual(size, FilesSearchFilters.Size.From1To5Mb.INSTANCE)) {
            return "from_1_to_5_mb";
        }
        if (Intrinsics.areEqual(size, FilesSearchFilters.Size.From5To25Mb.INSTANCE)) {
            return "from_5_to_25_mb";
        }
        if (Intrinsics.areEqual(size, FilesSearchFilters.Size.From25To100Mb.INSTANCE)) {
            return "from_25_to_100_mb";
        }
        if (Intrinsics.areEqual(size, FilesSearchFilters.Size.From100MbTo1Gb.INSTANCE)) {
            return "from_100_mb_to_1_gb";
        }
        throw new NoWhenBranchMatchedException();
    }
}

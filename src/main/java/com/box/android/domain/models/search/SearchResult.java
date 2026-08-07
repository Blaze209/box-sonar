package com.box.android.domain.models.search;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.hubs.HubModel;
import com.box.androidsdk.content.models.BoxIterator;
import com.facebook.react.modules.dialog.AlertFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchResult.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/domain/models/search/SearchResult;", "", "<init>", "()V", "HubSearchResult", "FileSearchResult", "NoteSearchResult", "Lcom/box/android/domain/models/search/SearchResult$FileSearchResult;", "Lcom/box/android/domain/models/search/SearchResult$HubSearchResult;", "Lcom/box/android/domain/models/search/SearchResult$NoteSearchResult;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class SearchResult {
    public /* synthetic */ SearchResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: SearchResult.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/box/android/domain/models/search/SearchResult$HubSearchResult;", "Lcom/box/android/domain/models/search/SearchResult;", AlertFragment.ARG_ITEMS, "", "Lcom/box/android/domain/models/hubs/HubModel;", "offset", "", "<init>", "(Ljava/util/List;I)V", "getItems", "()Ljava/util/List;", "getOffset", "()I", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class HubSearchResult extends SearchResult {
        private final List<HubModel> items;
        private final int offset;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ HubSearchResult copy$default(HubSearchResult hubSearchResult, List list, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                list = hubSearchResult.items;
            }
            if ((i2 & 2) != 0) {
                i = hubSearchResult.offset;
            }
            return hubSearchResult.copy(list, i);
        }

        public final List<HubModel> component1() {
            return this.items;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getOffset() {
            return this.offset;
        }

        public final HubSearchResult copy(List<HubModel> items, int offset) {
            Intrinsics.checkNotNullParameter(items, "items");
            return new HubSearchResult(items, offset);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HubSearchResult)) {
                return false;
            }
            HubSearchResult hubSearchResult = (HubSearchResult) other;
            return Intrinsics.areEqual(this.items, hubSearchResult.items) && this.offset == hubSearchResult.offset;
        }

        public int hashCode() {
            return (this.items.hashCode() * 31) + Integer.hashCode(this.offset);
        }

        public String toString() {
            return "HubSearchResult(items=" + this.items + ", offset=" + this.offset + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HubSearchResult(List<HubModel> items, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(items, "items");
            this.items = items;
            this.offset = i;
        }

        public final List<HubModel> getItems() {
            return this.items;
        }

        public final int getOffset() {
            return this.offset;
        }
    }

    private SearchResult() {
    }

    /* JADX INFO: compiled from: SearchResult.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/box/android/domain/models/search/SearchResult$FileSearchResult;", "Lcom/box/android/domain/models/search/SearchResult;", AlertFragment.ARG_ITEMS, "", "Lcom/box/android/domain/models/search/FileSearchItem;", BoxIterator.FIELD_LIMIT, "", "offset", "totalCount", "", "<init>", "(Ljava/util/List;IIJ)V", "getItems", "()Ljava/util/List;", "getLimit", "()I", "getOffset", "getTotalCount", "()J", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class FileSearchResult extends SearchResult {
        private final List<FileSearchItem> items;
        private final int limit;
        private final int offset;
        private final long totalCount;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ FileSearchResult copy$default(FileSearchResult fileSearchResult, List list, int i, int i2, long j, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                list = fileSearchResult.items;
            }
            if ((i3 & 2) != 0) {
                i = fileSearchResult.limit;
            }
            if ((i3 & 4) != 0) {
                i2 = fileSearchResult.offset;
            }
            if ((i3 & 8) != 0) {
                j = fileSearchResult.totalCount;
            }
            int i4 = i2;
            return fileSearchResult.copy(list, i, i4, j);
        }

        public final List<FileSearchItem> component1() {
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

        public final FileSearchResult copy(List<FileSearchItem> items, int limit, int offset, long totalCount) {
            Intrinsics.checkNotNullParameter(items, "items");
            return new FileSearchResult(items, limit, offset, totalCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FileSearchResult)) {
                return false;
            }
            FileSearchResult fileSearchResult = (FileSearchResult) other;
            return Intrinsics.areEqual(this.items, fileSearchResult.items) && this.limit == fileSearchResult.limit && this.offset == fileSearchResult.offset && this.totalCount == fileSearchResult.totalCount;
        }

        public int hashCode() {
            return (((((this.items.hashCode() * 31) + Integer.hashCode(this.limit)) * 31) + Integer.hashCode(this.offset)) * 31) + Long.hashCode(this.totalCount);
        }

        public String toString() {
            return "FileSearchResult(items=" + this.items + ", limit=" + this.limit + ", offset=" + this.offset + ", totalCount=" + this.totalCount + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FileSearchResult(List<FileSearchItem> items, int i, int i2, long j) {
            super(null);
            Intrinsics.checkNotNullParameter(items, "items");
            this.items = items;
            this.limit = i;
            this.offset = i2;
            this.totalCount = j;
        }

        public final List<FileSearchItem> getItems() {
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
    }

    /* JADX INFO: compiled from: SearchResult.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/box/android/domain/models/search/SearchResult$NoteSearchResult;", "Lcom/box/android/domain/models/search/SearchResult;", AlertFragment.ARG_ITEMS, "", "Lcom/box/android/domain/models/search/NoteSearchItem;", BoxIterator.FIELD_LIMIT, "", "offset", "totalCount", "", "<init>", "(Ljava/util/List;IIJ)V", "getItems", "()Ljava/util/List;", "getLimit", "()I", "getOffset", "getTotalCount", "()J", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class NoteSearchResult extends SearchResult {
        private final List<NoteSearchItem> items;
        private final int limit;
        private final int offset;
        private final long totalCount;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ NoteSearchResult copy$default(NoteSearchResult noteSearchResult, List list, int i, int i2, long j, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                list = noteSearchResult.items;
            }
            if ((i3 & 2) != 0) {
                i = noteSearchResult.limit;
            }
            if ((i3 & 4) != 0) {
                i2 = noteSearchResult.offset;
            }
            if ((i3 & 8) != 0) {
                j = noteSearchResult.totalCount;
            }
            int i4 = i2;
            return noteSearchResult.copy(list, i, i4, j);
        }

        public final List<NoteSearchItem> component1() {
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

        public final NoteSearchResult copy(List<NoteSearchItem> items, int limit, int offset, long totalCount) {
            Intrinsics.checkNotNullParameter(items, "items");
            return new NoteSearchResult(items, limit, offset, totalCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NoteSearchResult)) {
                return false;
            }
            NoteSearchResult noteSearchResult = (NoteSearchResult) other;
            return Intrinsics.areEqual(this.items, noteSearchResult.items) && this.limit == noteSearchResult.limit && this.offset == noteSearchResult.offset && this.totalCount == noteSearchResult.totalCount;
        }

        public int hashCode() {
            return (((((this.items.hashCode() * 31) + Integer.hashCode(this.limit)) * 31) + Integer.hashCode(this.offset)) * 31) + Long.hashCode(this.totalCount);
        }

        public String toString() {
            return "NoteSearchResult(items=" + this.items + ", limit=" + this.limit + ", offset=" + this.offset + ", totalCount=" + this.totalCount + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NoteSearchResult(List<NoteSearchItem> items, int i, int i2, long j) {
            super(null);
            Intrinsics.checkNotNullParameter(items, "items");
            this.items = items;
            this.limit = i;
            this.offset = i2;
            this.totalCount = j;
        }

        public final List<NoteSearchItem> getItems() {
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
    }
}

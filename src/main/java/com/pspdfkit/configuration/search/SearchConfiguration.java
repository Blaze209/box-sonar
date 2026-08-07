package com.pspdfkit.configuration.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.pspdfkit.internal.mv;
import com.pspdfkit.internal.nd;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0001$B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J8\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0006\u0010\u0018\u001a\u00020\u0003J\u0014\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u001eHÖ\u0081\u0004J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006%"}, d2 = {"Lcom/pspdfkit/configuration/search/SearchConfiguration;", "Landroid/os/Parcelable;", "startSearchChars", "", "snippetLength", "startSearchOnCurrentPage", "", "maxSearchResults", "<init>", "(IIZLjava/lang/Integer;)V", "getStartSearchChars", "()I", "getSnippetLength", "getStartSearchOnCurrentPage", "()Z", "getMaxSearchResults", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(IIZLjava/lang/Integer;)Lcom/pspdfkit/configuration/search/SearchConfiguration;", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class SearchConfiguration implements Parcelable {
    public static final int DEFAULT_SNIPPET_LENGTH = 80;
    public static final int DEFAULT_START_SEARCH_CHARS = 2;
    private final Integer maxSearchResults;
    private final int snippetLength;
    private final int startSearchChars;
    private final boolean startSearchOnCurrentPage;
    public static final Parcelable.Creator<SearchConfiguration> CREATOR = new Creator();
    public static final int $stable = 8;

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SearchConfiguration> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SearchConfiguration createFromParcel(Parcel parcel) {
            parcel.getClass();
            return new SearchConfiguration(parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SearchConfiguration[] newArray(int i) {
            return new SearchConfiguration[i];
        }
    }

    public SearchConfiguration() {
        this(0, 0, false, null, 15, null);
    }

    public static /* synthetic */ SearchConfiguration copy$default(SearchConfiguration searchConfiguration, int i, int i2, boolean z, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = searchConfiguration.startSearchChars;
        }
        if ((i3 & 2) != 0) {
            i2 = searchConfiguration.snippetLength;
        }
        if ((i3 & 4) != 0) {
            z = searchConfiguration.startSearchOnCurrentPage;
        }
        if ((i3 & 8) != 0) {
            num = searchConfiguration.maxSearchResults;
        }
        return searchConfiguration.copy(i, i2, z, num);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getStartSearchChars() {
        return this.startSearchChars;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getSnippetLength() {
        return this.snippetLength;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getStartSearchOnCurrentPage() {
        return this.startSearchOnCurrentPage;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getMaxSearchResults() {
        return this.maxSearchResults;
    }

    public final SearchConfiguration copy(int startSearchChars, int snippetLength, boolean startSearchOnCurrentPage, Integer maxSearchResults) {
        return new SearchConfiguration(startSearchChars, snippetLength, startSearchOnCurrentPage, maxSearchResults);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchConfiguration)) {
            return false;
        }
        SearchConfiguration searchConfiguration = (SearchConfiguration) other;
        return this.startSearchChars == searchConfiguration.startSearchChars && this.snippetLength == searchConfiguration.snippetLength && this.startSearchOnCurrentPage == searchConfiguration.startSearchOnCurrentPage && Intrinsics.areEqual(this.maxSearchResults, searchConfiguration.maxSearchResults);
    }

    public final Integer getMaxSearchResults() {
        return this.maxSearchResults;
    }

    public final int getSnippetLength() {
        return this.snippetLength;
    }

    public final int getStartSearchChars() {
        return this.startSearchChars;
    }

    public final boolean getStartSearchOnCurrentPage() {
        return this.startSearchOnCurrentPage;
    }

    public int hashCode() {
        int iA = mv.a(this.startSearchOnCurrentPage, nd.a(this.snippetLength, Integer.hashCode(this.startSearchChars) * 31, 31), 31);
        Integer num = this.maxSearchResults;
        return iA + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "SearchConfiguration(startSearchChars=" + this.startSearchChars + ", snippetLength=" + this.snippetLength + ", startSearchOnCurrentPage=" + this.startSearchOnCurrentPage + ", maxSearchResults=" + this.maxSearchResults + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        dest.getClass();
        dest.writeInt(this.startSearchChars);
        dest.writeInt(this.snippetLength);
        dest.writeInt(this.startSearchOnCurrentPage ? 1 : 0);
        Integer num = this.maxSearchResults;
        if (num == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(num.intValue());
        }
    }

    public SearchConfiguration(int i, int i2, boolean z, Integer num) {
        this.startSearchChars = i;
        this.snippetLength = i2;
        this.startSearchOnCurrentPage = z;
        this.maxSearchResults = num;
    }

    public /* synthetic */ SearchConfiguration(int i, int i2, boolean z, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 2 : i, (i3 & 2) != 0 ? 80 : i2, (i3 & 4) != 0 ? false : z, (i3 & 8) != 0 ? null : num);
    }
}

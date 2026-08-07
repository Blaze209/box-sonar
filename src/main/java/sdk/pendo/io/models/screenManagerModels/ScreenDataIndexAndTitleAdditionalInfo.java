package sdk.pendo.io.models.screenManagerModels;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0019"}, d2 = {"Lsdk/pendo/io/models/screenManagerModels/ScreenDataIndexAndTitleAdditionalInfo;", "", "numOfIndexes", "", "selectedIndex", "selectedTitle", "", "viewType", "(IILjava/lang/String;Ljava/lang/String;)V", "getNumOfIndexes", "()I", "getSelectedIndex", "getSelectedTitle", "()Ljava/lang/String;", "getViewType", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class ScreenDataIndexAndTitleAdditionalInfo {
    private final int numOfIndexes;
    private final int selectedIndex;
    private final String selectedTitle;
    private final String viewType;

    public ScreenDataIndexAndTitleAdditionalInfo(int i, int i2, String str, String viewType) {
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        this.numOfIndexes = i;
        this.selectedIndex = i2;
        this.selectedTitle = str;
        this.viewType = viewType;
    }

    public static /* synthetic */ ScreenDataIndexAndTitleAdditionalInfo copy$default(ScreenDataIndexAndTitleAdditionalInfo screenDataIndexAndTitleAdditionalInfo, int i, int i2, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = screenDataIndexAndTitleAdditionalInfo.numOfIndexes;
        }
        if ((i3 & 2) != 0) {
            i2 = screenDataIndexAndTitleAdditionalInfo.selectedIndex;
        }
        if ((i3 & 4) != 0) {
            str = screenDataIndexAndTitleAdditionalInfo.selectedTitle;
        }
        if ((i3 & 8) != 0) {
            str2 = screenDataIndexAndTitleAdditionalInfo.viewType;
        }
        return screenDataIndexAndTitleAdditionalInfo.copy(i, i2, str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getNumOfIndexes() {
        return this.numOfIndexes;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getSelectedIndex() {
        return this.selectedIndex;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSelectedTitle() {
        return this.selectedTitle;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getViewType() {
        return this.viewType;
    }

    public final ScreenDataIndexAndTitleAdditionalInfo copy(int numOfIndexes, int selectedIndex, String selectedTitle, String viewType) {
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        return new ScreenDataIndexAndTitleAdditionalInfo(numOfIndexes, selectedIndex, selectedTitle, viewType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScreenDataIndexAndTitleAdditionalInfo)) {
            return false;
        }
        ScreenDataIndexAndTitleAdditionalInfo screenDataIndexAndTitleAdditionalInfo = (ScreenDataIndexAndTitleAdditionalInfo) other;
        return this.numOfIndexes == screenDataIndexAndTitleAdditionalInfo.numOfIndexes && this.selectedIndex == screenDataIndexAndTitleAdditionalInfo.selectedIndex && Intrinsics.areEqual(this.selectedTitle, screenDataIndexAndTitleAdditionalInfo.selectedTitle) && Intrinsics.areEqual(this.viewType, screenDataIndexAndTitleAdditionalInfo.viewType);
    }

    public final int getNumOfIndexes() {
        return this.numOfIndexes;
    }

    public final int getSelectedIndex() {
        return this.selectedIndex;
    }

    public final String getSelectedTitle() {
        return this.selectedTitle;
    }

    public final String getViewType() {
        return this.viewType;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.numOfIndexes) * 31) + Integer.hashCode(this.selectedIndex)) * 31;
        String str = this.selectedTitle;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.viewType.hashCode();
    }

    public String toString() {
        return "ScreenDataIndexAndTitleAdditionalInfo(numOfIndexes=" + this.numOfIndexes + ", selectedIndex=" + this.selectedIndex + ", selectedTitle=" + this.selectedTitle + ", viewType=" + this.viewType + ")";
    }
}

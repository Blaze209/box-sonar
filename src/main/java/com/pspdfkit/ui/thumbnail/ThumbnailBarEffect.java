package com.pspdfkit.ui.thumbnail;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEffect;", "", "NavigateToPage", "ShowError", "ScrollToPage", "RequestFocus", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEffect$NavigateToPage;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEffect$RequestFocus;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEffect$ScrollToPage;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEffect$ShowError;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface ThumbnailBarEffect {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEffect$NavigateToPage;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEffect;", "pageIndex", "", "<init>", "(I)V", "getPageIndex", "()I", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class NavigateToPage implements ThumbnailBarEffect {
        public static final int $stable = 0;
        private final int pageIndex;

        public NavigateToPage(int i) {
            this.pageIndex = i;
        }

        public static /* synthetic */ NavigateToPage copy$default(NavigateToPage navigateToPage, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = navigateToPage.pageIndex;
            }
            return navigateToPage.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getPageIndex() {
            return this.pageIndex;
        }

        public final NavigateToPage copy(int pageIndex) {
            return new NavigateToPage(pageIndex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NavigateToPage) && this.pageIndex == ((NavigateToPage) other).pageIndex;
        }

        public final int getPageIndex() {
            return this.pageIndex;
        }

        public int hashCode() {
            return Integer.hashCode(this.pageIndex);
        }

        public String toString() {
            return "NavigateToPage(pageIndex=" + this.pageIndex + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEffect$RequestFocus;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEffect;", "pageIndex", "", "<init>", "(I)V", "getPageIndex", "()I", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class RequestFocus implements ThumbnailBarEffect {
        public static final int $stable = 0;
        private final int pageIndex;

        public RequestFocus(int i) {
            this.pageIndex = i;
        }

        public static /* synthetic */ RequestFocus copy$default(RequestFocus requestFocus, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = requestFocus.pageIndex;
            }
            return requestFocus.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getPageIndex() {
            return this.pageIndex;
        }

        public final RequestFocus copy(int pageIndex) {
            return new RequestFocus(pageIndex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof RequestFocus) && this.pageIndex == ((RequestFocus) other).pageIndex;
        }

        public final int getPageIndex() {
            return this.pageIndex;
        }

        public int hashCode() {
            return Integer.hashCode(this.pageIndex);
        }

        public String toString() {
            return "RequestFocus(pageIndex=" + this.pageIndex + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEffect$ScrollToPage;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEffect;", "pageIndex", "", "<init>", "(I)V", "getPageIndex", "()I", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ScrollToPage implements ThumbnailBarEffect {
        public static final int $stable = 0;
        private final int pageIndex;

        public ScrollToPage(int i) {
            this.pageIndex = i;
        }

        public static /* synthetic */ ScrollToPage copy$default(ScrollToPage scrollToPage, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = scrollToPage.pageIndex;
            }
            return scrollToPage.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getPageIndex() {
            return this.pageIndex;
        }

        public final ScrollToPage copy(int pageIndex) {
            return new ScrollToPage(pageIndex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ScrollToPage) && this.pageIndex == ((ScrollToPage) other).pageIndex;
        }

        public final int getPageIndex() {
            return this.pageIndex;
        }

        public int hashCode() {
            return Integer.hashCode(this.pageIndex);
        }

        public String toString() {
            return "ScrollToPage(pageIndex=" + this.pageIndex + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEffect$ShowError;", "Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEffect;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ShowError implements ThumbnailBarEffect {
        public static final int $stable = 0;
        private final String message;

        public ShowError(String str) {
            str.getClass();
            this.message = str;
        }

        public static /* synthetic */ ShowError copy$default(ShowError showError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = showError.message;
            }
            return showError.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final ShowError copy(String message) {
            message.getClass();
            return new ShowError(message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ShowError) && Intrinsics.areEqual(this.message, ((ShowError) other).message);
        }

        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "ShowError(message=" + this.message + ")";
        }
    }
}

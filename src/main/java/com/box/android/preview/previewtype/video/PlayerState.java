package com.box.android.preview.previewtype.video;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VideoPlayerInteractor.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/preview/previewtype/video/PlayerState;", "", "<init>", "()V", "VideoPlayError", "NetworkError", "Ready", "Lcom/box/android/preview/previewtype/video/PlayerState$NetworkError;", "Lcom/box/android/preview/previewtype/video/PlayerState$Ready;", "Lcom/box/android/preview/previewtype/video/PlayerState$VideoPlayError;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class PlayerState {
    public static final int $stable = 0;

    public /* synthetic */ PlayerState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: VideoPlayerInteractor.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/previewtype/video/PlayerState$VideoPlayError;", "Lcom/box/android/preview/previewtype/video/PlayerState;", "domainError", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getDomainError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class VideoPlayError extends PlayerState {
        public static final int $stable = 8;
        private final DomainError domainError;

        public static /* synthetic */ VideoPlayError copy$default(VideoPlayError videoPlayError, DomainError domainError, int i, Object obj) {
            if ((i & 1) != 0) {
                domainError = videoPlayError.domainError;
            }
            return videoPlayError.copy(domainError);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DomainError getDomainError() {
            return this.domainError;
        }

        public final VideoPlayError copy(DomainError domainError) {
            Intrinsics.checkNotNullParameter(domainError, "domainError");
            return new VideoPlayError(domainError);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof VideoPlayError) && Intrinsics.areEqual(this.domainError, ((VideoPlayError) other).domainError);
        }

        public int hashCode() {
            return this.domainError.hashCode();
        }

        public String toString() {
            return "VideoPlayError(domainError=" + this.domainError + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VideoPlayError(DomainError domainError) {
            super(null);
            Intrinsics.checkNotNullParameter(domainError, "domainError");
            this.domainError = domainError;
        }

        public final DomainError getDomainError() {
            return this.domainError;
        }
    }

    private PlayerState() {
    }

    /* JADX INFO: compiled from: VideoPlayerInteractor.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/video/PlayerState$NetworkError;", "Lcom/box/android/preview/previewtype/video/PlayerState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class NetworkError extends PlayerState {
        public static final int $stable = 0;
        public static final NetworkError INSTANCE = new NetworkError();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NetworkError)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1569641996;
        }

        public String toString() {
            return "NetworkError";
        }

        private NetworkError() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: VideoPlayerInteractor.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/video/PlayerState$Ready;", "Lcom/box/android/preview/previewtype/video/PlayerState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Ready extends PlayerState {
        public static final int $stable = 0;
        public static final Ready INSTANCE = new Ready();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Ready)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1328379985;
        }

        public String toString() {
            return "Ready";
        }

        private Ready() {
            super(null);
        }
    }
}

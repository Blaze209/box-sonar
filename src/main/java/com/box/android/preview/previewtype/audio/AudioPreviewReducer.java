package com.box.android.preview.previewtype.audio;

import android.graphics.Bitmap;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.item.FileModel;
import java.net.URI;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AudioPreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\t\nB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$State;", "Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$Action;", "<init>", "()V", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "State", "Action", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AudioPreviewReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build = new Reduce(new Function2() { // from class: com.box.android.preview.previewtype.audio.AudioPreviewReducer$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return AudioPreviewReducer.build$lambda$0((AudioPreviewReducer.State) obj, (AudioPreviewReducer.Action) obj2);
        }
    });

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: AudioPreviewReducer.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003JI\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0007HÆ\u0001J\u0013\u0010 \u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013¨\u0006&"}, d2 = {"Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$State;", "", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "uri", "Ljava/net/URI;", "isPaused", "", "cover", "Landroid/graphics/Bitmap;", "errorWhenTryPlaying", "Lcom/box/android/domain/models/DomainError;", "needRetryPlaying", "<init>", "(Lcom/box/android/domain/models/item/FileModel;Ljava/net/URI;ZLandroid/graphics/Bitmap;Lcom/box/android/domain/models/DomainError;Z)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "getUri", "()Ljava/net/URI;", "()Z", "getCover", "()Landroid/graphics/Bitmap;", "getErrorWhenTryPlaying", "()Lcom/box/android/domain/models/DomainError;", "getNeedRetryPlaying", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final Bitmap cover;
        private final DomainError errorWhenTryPlaying;
        private final FileModel fileModel;
        private final boolean isPaused;
        private final boolean needRetryPlaying;
        private final URI uri;

        public static /* synthetic */ State copy$default(State state, FileModel fileModel, URI uri, boolean z, Bitmap bitmap, DomainError domainError, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                fileModel = state.fileModel;
            }
            if ((i & 2) != 0) {
                uri = state.uri;
            }
            if ((i & 4) != 0) {
                z = state.isPaused;
            }
            if ((i & 8) != 0) {
                bitmap = state.cover;
            }
            if ((i & 16) != 0) {
                domainError = state.errorWhenTryPlaying;
            }
            if ((i & 32) != 0) {
                z2 = state.needRetryPlaying;
            }
            DomainError domainError2 = domainError;
            boolean z3 = z2;
            return state.copy(fileModel, uri, z, bitmap, domainError2, z3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FileModel getFileModel() {
            return this.fileModel;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final URI getUri() {
            return this.uri;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsPaused() {
            return this.isPaused;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Bitmap getCover() {
            return this.cover;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final DomainError getErrorWhenTryPlaying() {
            return this.errorWhenTryPlaying;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getNeedRetryPlaying() {
            return this.needRetryPlaying;
        }

        public final State copy(FileModel fileModel, URI uri, boolean isPaused, Bitmap cover, DomainError errorWhenTryPlaying, boolean needRetryPlaying) {
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            Intrinsics.checkNotNullParameter(uri, "uri");
            return new State(fileModel, uri, isPaused, cover, errorWhenTryPlaying, needRetryPlaying);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.fileModel, state.fileModel) && Intrinsics.areEqual(this.uri, state.uri) && this.isPaused == state.isPaused && Intrinsics.areEqual(this.cover, state.cover) && Intrinsics.areEqual(this.errorWhenTryPlaying, state.errorWhenTryPlaying) && this.needRetryPlaying == state.needRetryPlaying;
        }

        public int hashCode() {
            int iHashCode = ((((this.fileModel.hashCode() * 31) + this.uri.hashCode()) * 31) + Boolean.hashCode(this.isPaused)) * 31;
            Bitmap bitmap = this.cover;
            int iHashCode2 = (iHashCode + (bitmap == null ? 0 : bitmap.hashCode())) * 31;
            DomainError domainError = this.errorWhenTryPlaying;
            return ((iHashCode2 + (domainError != null ? domainError.hashCode() : 0)) * 31) + Boolean.hashCode(this.needRetryPlaying);
        }

        public String toString() {
            return "State(fileModel=" + this.fileModel + ", uri=" + this.uri + ", isPaused=" + this.isPaused + ", cover=" + this.cover + ", errorWhenTryPlaying=" + this.errorWhenTryPlaying + ", needRetryPlaying=" + this.needRetryPlaying + ")";
        }

        public State(FileModel fileModel, URI uri, boolean z, Bitmap bitmap, DomainError domainError, boolean z2) {
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            Intrinsics.checkNotNullParameter(uri, "uri");
            this.fileModel = fileModel;
            this.uri = uri;
            this.isPaused = z;
            this.cover = bitmap;
            this.errorWhenTryPlaying = domainError;
            this.needRetryPlaying = z2;
        }

        public /* synthetic */ State(FileModel fileModel, URI uri, boolean z, Bitmap bitmap, DomainError domainError, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(fileModel, uri, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : bitmap, (i & 16) != 0 ? null : domainError, (i & 32) != 0 ? false : z2);
        }

        public final FileModel getFileModel() {
            return this.fileModel;
        }

        public final URI getUri() {
            return this.uri;
        }

        public final boolean isPaused() {
            return this.isPaused;
        }

        public final Bitmap getCover() {
            return this.cover;
        }

        public final DomainError getErrorWhenTryPlaying() {
            return this.errorWhenTryPlaying;
        }

        public final boolean getNeedRetryPlaying() {
            return this.needRetryPlaying;
        }
    }

    /* JADX INFO: compiled from: AudioPreviewReducer.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\b\u0004\u0005\u0006\u0007\b\t\n\u000bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\b\f\r\u000e\u000f\u0010\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$Action;", "", "<init>", "()V", "Opened", "Error", "ErrorHandled", "RetryClicked", "Loaded", "Paused", "Playing", "UpdateCoverArt", "Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$Action$Error;", "Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$Action$ErrorHandled;", "Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$Action$Loaded;", "Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$Action$Opened;", "Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$Action$Paused;", "Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$Action$Playing;", "Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$Action$RetryClicked;", "Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$Action$UpdateCoverArt;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: AudioPreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$Action$Opened;", "Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Opened extends Action {
            public static final int $stable = 0;
            public static final Opened INSTANCE = new Opened();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Opened)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 555347252;
            }

            public String toString() {
                return "Opened";
            }

            private Opened() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: AudioPreviewReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$Action$Error;", "Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$Action;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Error extends Action {
            public static final int $stable = 8;
            private final DomainError error;

            public static /* synthetic */ Error copy$default(Error error, DomainError domainError, int i, Object obj) {
                if ((i & 1) != 0) {
                    domainError = error.error;
                }
                return error.copy(domainError);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DomainError getError() {
                return this.error;
            }

            public final Error copy(DomainError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                return new Error(error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Error) && Intrinsics.areEqual(this.error, ((Error) other).error);
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return "Error(error=" + this.error + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(DomainError error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public final DomainError getError() {
                return this.error;
            }
        }

        /* JADX INFO: compiled from: AudioPreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$Action$ErrorHandled;", "Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ErrorHandled extends Action {
            public static final int $stable = 0;
            public static final ErrorHandled INSTANCE = new ErrorHandled();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ErrorHandled)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 265577631;
            }

            public String toString() {
                return "ErrorHandled";
            }

            private ErrorHandled() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AudioPreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$Action$RetryClicked;", "Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RetryClicked extends Action {
            public static final int $stable = 0;
            public static final RetryClicked INSTANCE = new RetryClicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RetryClicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1791252714;
            }

            public String toString() {
                return "RetryClicked";
            }

            private RetryClicked() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AudioPreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$Action$Loaded;", "Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Loaded extends Action {
            public static final int $stable = 0;
            public static final Loaded INSTANCE = new Loaded();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 468407504;
            }

            public String toString() {
                return "Loaded";
            }

            private Loaded() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AudioPreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$Action$Paused;", "Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Paused extends Action {
            public static final int $stable = 0;
            public static final Paused INSTANCE = new Paused();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Paused)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 570605049;
            }

            public String toString() {
                return "Paused";
            }

            private Paused() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AudioPreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$Action$Playing;", "Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Playing extends Action {
            public static final int $stable = 0;
            public static final Playing INSTANCE = new Playing();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Playing)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 805520579;
            }

            public String toString() {
                return "Playing";
            }

            private Playing() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AudioPreviewReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$Action$UpdateCoverArt;", "Lcom/box/android/preview/previewtype/audio/AudioPreviewReducer$Action;", "cover", "Landroid/graphics/Bitmap;", "<init>", "(Landroid/graphics/Bitmap;)V", "getCover", "()Landroid/graphics/Bitmap;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateCoverArt extends Action {
            public static final int $stable = 8;
            private final Bitmap cover;

            public static /* synthetic */ UpdateCoverArt copy$default(UpdateCoverArt updateCoverArt, Bitmap bitmap, int i, Object obj) {
                if ((i & 1) != 0) {
                    bitmap = updateCoverArt.cover;
                }
                return updateCoverArt.copy(bitmap);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Bitmap getCover() {
                return this.cover;
            }

            public final UpdateCoverArt copy(Bitmap cover) {
                Intrinsics.checkNotNullParameter(cover, "cover");
                return new UpdateCoverArt(cover);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UpdateCoverArt) && Intrinsics.areEqual(this.cover, ((UpdateCoverArt) other).cover);
            }

            public int hashCode() {
                return this.cover.hashCode();
            }

            public String toString() {
                return "UpdateCoverArt(cover=" + this.cover + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UpdateCoverArt(Bitmap cover) {
                super(null);
                Intrinsics.checkNotNullParameter(cover, "cover");
                this.cover = cover;
            }

            public final Bitmap getCover() {
                return this.cover;
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReducerResult build$lambda$0(State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof Action.Loaded) {
            return new ReducerResult(State.copy$default(state, null, null, false, null, null, false, 31, null), null, 2, null);
        }
        if (action instanceof Action.Error) {
            return new ReducerResult(State.copy$default(state, null, null, false, null, ((Action.Error) action).getError(), false, 15, null), null, 2, null);
        }
        if (action instanceof Action.ErrorHandled) {
            return new ReducerResult(State.copy$default(state, null, null, false, null, null, false, 47, null), null, 2, null);
        }
        if (action instanceof Action.RetryClicked) {
            return new ReducerResult(State.copy$default(state, null, null, false, null, null, true, 31, null), null, 2, null);
        }
        if (action instanceof Action.Paused) {
            return new ReducerResult(State.copy$default(state, null, null, true, null, null, false, 59, null), null, 2, null);
        }
        if (action instanceof Action.Opened) {
            return new ReducerResult(state, null, 2, null);
        }
        if (action instanceof Action.Playing) {
            return new ReducerResult(State.copy$default(state, null, null, false, null, null, false, 59, null), null, 2, null);
        }
        if (action instanceof Action.UpdateCoverArt) {
            return new ReducerResult(State.copy$default(state, null, null, false, ((Action.UpdateCoverArt) action).getCover(), null, false, 55, null), null, 2, null);
        }
        throw new NoWhenBranchMatchedException();
    }
}

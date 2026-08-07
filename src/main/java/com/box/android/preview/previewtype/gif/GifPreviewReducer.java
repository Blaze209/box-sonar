package com.box.android.preview.previewtype.gif;

import com.box.android.base.presentation.utilities.FileTypeIcon;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.item.FileModel;
import com.box.android.preview.item.LoadingPlaceholder;
import com.pspdfkit.analytics.Analytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GifPreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0012\u0013B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0003H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/box/android/preview/previewtype/gif/GifPreviewReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/preview/previewtype/gif/GifPreviewReducer$State;", "Lcom/box/android/preview/previewtype/gif/GifPreviewReducer$Action;", "environment", "Lcom/box/android/preview/previewtype/gif/GifPreviewEnvironment;", "<init>", "(Lcom/box/android/preview/previewtype/gif/GifPreviewEnvironment;)V", "getEnvironment", "()Lcom/box/android/preview/previewtype/gif/GifPreviewEnvironment;", "build", "Lcom/box/android/cpl/Reduce;", "getBuild", "()Lcom/box/android/cpl/Reduce;", "reduceGifPreview", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "State", "Action", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GifPreviewReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reduce<State, Action> build;
    private final GifPreviewEnvironment environment;

    public GifPreviewReducer(GifPreviewEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        this.build = new Reduce<>(new GifPreviewReducer$build$1(this));
    }

    public final GifPreviewEnvironment getEnvironment() {
        return this.environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: GifPreviewReducer.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/box/android/preview/previewtype/gif/GifPreviewReducer$State;", "", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "url", "", "loadingPlaceholder", "Lcom/box/android/preview/item/LoadingPlaceholder;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;Ljava/lang/String;Lcom/box/android/preview/item/LoadingPlaceholder;)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "getUrl", "()Ljava/lang/String;", "getLoadingPlaceholder", "()Lcom/box/android/preview/item/LoadingPlaceholder;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final FileModel fileModel;
        private final LoadingPlaceholder loadingPlaceholder;
        private final String url;

        public static /* synthetic */ State copy$default(State state, FileModel fileModel, String str, LoadingPlaceholder loadingPlaceholder, int i, Object obj) {
            if ((i & 1) != 0) {
                fileModel = state.fileModel;
            }
            if ((i & 2) != 0) {
                str = state.url;
            }
            if ((i & 4) != 0) {
                loadingPlaceholder = state.loadingPlaceholder;
            }
            return state.copy(fileModel, str, loadingPlaceholder);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FileModel getFileModel() {
            return this.fileModel;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final LoadingPlaceholder getLoadingPlaceholder() {
            return this.loadingPlaceholder;
        }

        public final State copy(FileModel fileModel, String url, LoadingPlaceholder loadingPlaceholder) {
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            Intrinsics.checkNotNullParameter(url, "url");
            return new State(fileModel, url, loadingPlaceholder);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.fileModel, state.fileModel) && Intrinsics.areEqual(this.url, state.url) && Intrinsics.areEqual(this.loadingPlaceholder, state.loadingPlaceholder);
        }

        public int hashCode() {
            int iHashCode = ((this.fileModel.hashCode() * 31) + this.url.hashCode()) * 31;
            LoadingPlaceholder loadingPlaceholder = this.loadingPlaceholder;
            return iHashCode + (loadingPlaceholder == null ? 0 : loadingPlaceholder.hashCode());
        }

        public String toString() {
            return "State(fileModel=" + this.fileModel + ", url=" + this.url + ", loadingPlaceholder=" + this.loadingPlaceholder + ")";
        }

        public State(FileModel fileModel, String url, LoadingPlaceholder loadingPlaceholder) {
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            Intrinsics.checkNotNullParameter(url, "url");
            this.fileModel = fileModel;
            this.url = url;
            this.loadingPlaceholder = loadingPlaceholder;
        }

        public final FileModel getFileModel() {
            return this.fileModel;
        }

        public final String getUrl() {
            return this.url;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ State(FileModel fileModel, String str, LoadingPlaceholder loadingPlaceholder, int i, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i & 4) != 0) {
                loadingPlaceholder = new LoadingPlaceholder(FileTypeIcon.DEFAULT, null, 2, 0 == true ? 1 : 0);
            }
            this(fileModel, str, loadingPlaceholder);
        }

        public final LoadingPlaceholder getLoadingPlaceholder() {
            return this.loadingPlaceholder;
        }
    }

    /* JADX INFO: compiled from: GifPreviewReducer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/preview/previewtype/gif/GifPreviewReducer$Action;", "", "<init>", "()V", "Error", "GifLoaded", "GifClicked", "Lcom/box/android/preview/previewtype/gif/GifPreviewReducer$Action$Error;", "Lcom/box/android/preview/previewtype/gif/GifPreviewReducer$Action$GifClicked;", "Lcom/box/android/preview/previewtype/gif/GifPreviewReducer$Action$GifLoaded;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: GifPreviewReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/previewtype/gif/GifPreviewReducer$Action$Error;", "Lcom/box/android/preview/previewtype/gif/GifPreviewReducer$Action;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

        private Action() {
        }

        /* JADX INFO: compiled from: GifPreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/gif/GifPreviewReducer$Action$GifLoaded;", "Lcom/box/android/preview/previewtype/gif/GifPreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class GifLoaded extends Action {
            public static final int $stable = 0;
            public static final GifLoaded INSTANCE = new GifLoaded();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof GifLoaded)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1781925474;
            }

            public String toString() {
                return "GifLoaded";
            }

            private GifLoaded() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: GifPreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/gif/GifPreviewReducer$Action$GifClicked;", "Lcom/box/android/preview/previewtype/gif/GifPreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class GifClicked extends Action {
            public static final int $stable = 0;
            public static final GifClicked INSTANCE = new GifClicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof GifClicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -71006870;
            }

            public String toString() {
                return "GifClicked";
            }

            private GifClicked() {
                super(null);
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReducerResult<State, Action> reduceGifPreview(State state, Action action) {
        return action instanceof Action.GifLoaded ? new ReducerResult<>(State.copy$default(state, null, null, null, 3, null), null, 2, null) : new ReducerResult<>(state, null, 2, null);
    }
}

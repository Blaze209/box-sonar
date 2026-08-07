package com.box.android.preview.filesandfolders;

import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.preview.PageFitMode;
import com.box.android.domain.models.preview.ScrollSettings;
import com.box.android.domain.models.preview.ScrollableFileType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FilesAndFoldersReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0014\u0015\u0016B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J$\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$State;", "Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$Action;", "environment", "Lcom/box/android/preview/filesandfolders/FilesAndFoldersSettingsEnvironment;", "<init>", "(Lcom/box/android/preview/filesandfolders/FilesAndFoldersSettingsEnvironment;)V", "getEnvironment", "()Lcom/box/android/preview/filesandfolders/FilesAndFoldersSettingsEnvironment;", "build", "Lcom/box/android/cpl/Reduce;", "getBuild", "()Lcom/box/android/cpl/Reduce;", "updatePageFitMode", "Lcom/box/android/cpl/ReducerResult;", "state", "updateScrollSettingsState", "scrollableFileType", "Lcom/box/android/domain/models/preview/ScrollableFileType;", "SelectionDialogState", "State", "Action", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FilesAndFoldersReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reduce<State, Action> build;
    private final FilesAndFoldersSettingsEnvironment environment;

    /* JADX INFO: compiled from: FilesAndFoldersReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[PagingMode.values().length];
            try {
                iArr[PagingMode.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PagingMode.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PagingMode.VERTICAL_CONTINUOUS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PagingMode.UNSUPPORTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ScrollableFileType.values().length];
            try {
                iArr2[ScrollableFileType.PDF.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ScrollableFileType.POWERPOINT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[ScrollableFileType.WORD.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public FilesAndFoldersReducer(FilesAndFoldersSettingsEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        this.build = new Reduce<>(new Function2() { // from class: com.box.android.preview.filesandfolders.FilesAndFoldersReducer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return FilesAndFoldersReducer.build$lambda$0(this.f$0, (FilesAndFoldersReducer.State) obj, (FilesAndFoldersReducer.Action) obj2);
            }
        });
    }

    public final FilesAndFoldersSettingsEnvironment getEnvironment() {
        return this.environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: FilesAndFoldersReducer.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$SelectionDialogState;", "", "<init>", "()V", "PageDisplay", "PagingMode", "Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$SelectionDialogState$PageDisplay;", "Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$SelectionDialogState$PagingMode;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class SelectionDialogState {
        public static final int $stable = 0;

        public /* synthetic */ SelectionDialogState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: FilesAndFoldersReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$SelectionDialogState$PageDisplay;", "Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$SelectionDialogState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PageDisplay extends SelectionDialogState {
            public static final int $stable = 0;
            public static final PageDisplay INSTANCE = new PageDisplay();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PageDisplay)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -729334901;
            }

            public String toString() {
                return "PageDisplay";
            }

            private PageDisplay() {
                super(null);
            }
        }

        private SelectionDialogState() {
        }

        /* JADX INFO: compiled from: FilesAndFoldersReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$SelectionDialogState$PagingMode;", "Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$SelectionDialogState;", "scrollableFileType", "Lcom/box/android/domain/models/preview/ScrollableFileType;", "<init>", "(Lcom/box/android/domain/models/preview/ScrollableFileType;)V", "getScrollableFileType", "()Lcom/box/android/domain/models/preview/ScrollableFileType;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PagingMode extends SelectionDialogState {
            public static final int $stable = 0;
            private final ScrollableFileType scrollableFileType;

            public static /* synthetic */ PagingMode copy$default(PagingMode pagingMode, ScrollableFileType scrollableFileType, int i, Object obj) {
                if ((i & 1) != 0) {
                    scrollableFileType = pagingMode.scrollableFileType;
                }
                return pagingMode.copy(scrollableFileType);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ScrollableFileType getScrollableFileType() {
                return this.scrollableFileType;
            }

            public final PagingMode copy(ScrollableFileType scrollableFileType) {
                Intrinsics.checkNotNullParameter(scrollableFileType, "scrollableFileType");
                return new PagingMode(scrollableFileType);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof PagingMode) && this.scrollableFileType == ((PagingMode) other).scrollableFileType;
            }

            public int hashCode() {
                return this.scrollableFileType.hashCode();
            }

            public String toString() {
                return "PagingMode(scrollableFileType=" + this.scrollableFileType + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PagingMode(ScrollableFileType scrollableFileType) {
                super(null);
                Intrinsics.checkNotNullParameter(scrollableFileType, "scrollableFileType");
                this.scrollableFileType = scrollableFileType;
            }

            public final ScrollableFileType getScrollableFileType() {
                return this.scrollableFileType;
            }
        }
    }

    /* JADX INFO: compiled from: FilesAndFoldersReducer.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003JG\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0016¨\u0006$"}, d2 = {"Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$State;", "", "pageFitMode", "Lcom/box/android/domain/models/preview/PageFitMode;", "pdfScrollSettings", "Lcom/box/android/domain/models/preview/ScrollSettings;", "powerPointScrollSettings", "wordScrollSettings", "selectionDialogState", "Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$SelectionDialogState;", "isClosing", "", "<init>", "(Lcom/box/android/domain/models/preview/PageFitMode;Lcom/box/android/domain/models/preview/ScrollSettings;Lcom/box/android/domain/models/preview/ScrollSettings;Lcom/box/android/domain/models/preview/ScrollSettings;Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$SelectionDialogState;Z)V", "getPageFitMode", "()Lcom/box/android/domain/models/preview/PageFitMode;", "getPdfScrollSettings", "()Lcom/box/android/domain/models/preview/ScrollSettings;", "getPowerPointScrollSettings", "getWordScrollSettings", "getSelectionDialogState", "()Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$SelectionDialogState;", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final boolean isClosing;
        private final PageFitMode pageFitMode;
        private final ScrollSettings pdfScrollSettings;
        private final ScrollSettings powerPointScrollSettings;
        private final SelectionDialogState selectionDialogState;
        private final ScrollSettings wordScrollSettings;

        public static /* synthetic */ State copy$default(State state, PageFitMode pageFitMode, ScrollSettings scrollSettings, ScrollSettings scrollSettings2, ScrollSettings scrollSettings3, SelectionDialogState selectionDialogState, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                pageFitMode = state.pageFitMode;
            }
            if ((i & 2) != 0) {
                scrollSettings = state.pdfScrollSettings;
            }
            if ((i & 4) != 0) {
                scrollSettings2 = state.powerPointScrollSettings;
            }
            if ((i & 8) != 0) {
                scrollSettings3 = state.wordScrollSettings;
            }
            if ((i & 16) != 0) {
                selectionDialogState = state.selectionDialogState;
            }
            if ((i & 32) != 0) {
                z = state.isClosing;
            }
            SelectionDialogState selectionDialogState2 = selectionDialogState;
            boolean z2 = z;
            return state.copy(pageFitMode, scrollSettings, scrollSettings2, scrollSettings3, selectionDialogState2, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final PageFitMode getPageFitMode() {
            return this.pageFitMode;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ScrollSettings getPdfScrollSettings() {
            return this.pdfScrollSettings;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final ScrollSettings getPowerPointScrollSettings() {
            return this.powerPointScrollSettings;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final ScrollSettings getWordScrollSettings() {
            return this.wordScrollSettings;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final SelectionDialogState getSelectionDialogState() {
            return this.selectionDialogState;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getIsClosing() {
            return this.isClosing;
        }

        public final State copy(PageFitMode pageFitMode, ScrollSettings pdfScrollSettings, ScrollSettings powerPointScrollSettings, ScrollSettings wordScrollSettings, SelectionDialogState selectionDialogState, boolean isClosing) {
            Intrinsics.checkNotNullParameter(pageFitMode, "pageFitMode");
            Intrinsics.checkNotNullParameter(pdfScrollSettings, "pdfScrollSettings");
            Intrinsics.checkNotNullParameter(powerPointScrollSettings, "powerPointScrollSettings");
            Intrinsics.checkNotNullParameter(wordScrollSettings, "wordScrollSettings");
            return new State(pageFitMode, pdfScrollSettings, powerPointScrollSettings, wordScrollSettings, selectionDialogState, isClosing);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return this.pageFitMode == state.pageFitMode && Intrinsics.areEqual(this.pdfScrollSettings, state.pdfScrollSettings) && Intrinsics.areEqual(this.powerPointScrollSettings, state.powerPointScrollSettings) && Intrinsics.areEqual(this.wordScrollSettings, state.wordScrollSettings) && Intrinsics.areEqual(this.selectionDialogState, state.selectionDialogState) && this.isClosing == state.isClosing;
        }

        public int hashCode() {
            int iHashCode = ((((((this.pageFitMode.hashCode() * 31) + this.pdfScrollSettings.hashCode()) * 31) + this.powerPointScrollSettings.hashCode()) * 31) + this.wordScrollSettings.hashCode()) * 31;
            SelectionDialogState selectionDialogState = this.selectionDialogState;
            return ((iHashCode + (selectionDialogState == null ? 0 : selectionDialogState.hashCode())) * 31) + Boolean.hashCode(this.isClosing);
        }

        public String toString() {
            return "State(pageFitMode=" + this.pageFitMode + ", pdfScrollSettings=" + this.pdfScrollSettings + ", powerPointScrollSettings=" + this.powerPointScrollSettings + ", wordScrollSettings=" + this.wordScrollSettings + ", selectionDialogState=" + this.selectionDialogState + ", isClosing=" + this.isClosing + ")";
        }

        public State(PageFitMode pageFitMode, ScrollSettings pdfScrollSettings, ScrollSettings powerPointScrollSettings, ScrollSettings wordScrollSettings, SelectionDialogState selectionDialogState, boolean z) {
            Intrinsics.checkNotNullParameter(pageFitMode, "pageFitMode");
            Intrinsics.checkNotNullParameter(pdfScrollSettings, "pdfScrollSettings");
            Intrinsics.checkNotNullParameter(powerPointScrollSettings, "powerPointScrollSettings");
            Intrinsics.checkNotNullParameter(wordScrollSettings, "wordScrollSettings");
            this.pageFitMode = pageFitMode;
            this.pdfScrollSettings = pdfScrollSettings;
            this.powerPointScrollSettings = powerPointScrollSettings;
            this.wordScrollSettings = wordScrollSettings;
            this.selectionDialogState = selectionDialogState;
            this.isClosing = z;
        }

        public /* synthetic */ State(PageFitMode pageFitMode, ScrollSettings scrollSettings, ScrollSettings scrollSettings2, ScrollSettings scrollSettings3, SelectionDialogState selectionDialogState, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(pageFitMode, scrollSettings, scrollSettings2, scrollSettings3, (i & 16) != 0 ? null : selectionDialogState, (i & 32) != 0 ? false : z);
        }

        public final PageFitMode getPageFitMode() {
            return this.pageFitMode;
        }

        public final ScrollSettings getPdfScrollSettings() {
            return this.pdfScrollSettings;
        }

        public final ScrollSettings getPowerPointScrollSettings() {
            return this.powerPointScrollSettings;
        }

        public final ScrollSettings getWordScrollSettings() {
            return this.wordScrollSettings;
        }

        public final SelectionDialogState getSelectionDialogState() {
            return this.selectionDialogState;
        }

        public final boolean isClosing() {
            return this.isClosing;
        }
    }

    /* JADX INFO: compiled from: FilesAndFoldersReducer.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$Action;", "", "<init>", "()V", "CloseScreen", "SelectPageFitMode", "PageFitModeSelected", "SelectPagingMode", "PagingModeSelected", "DismissSelectionDialog", "Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$Action$CloseScreen;", "Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$Action$DismissSelectionDialog;", "Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$Action$PageFitModeSelected;", "Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$Action$PagingModeSelected;", "Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$Action$SelectPageFitMode;", "Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$Action$SelectPagingMode;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: FilesAndFoldersReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$Action$CloseScreen;", "Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CloseScreen extends Action {
            public static final int $stable = 0;
            public static final CloseScreen INSTANCE = new CloseScreen();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CloseScreen)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 138702421;
            }

            public String toString() {
                return "CloseScreen";
            }

            private CloseScreen() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: FilesAndFoldersReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$Action$SelectPageFitMode;", "Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SelectPageFitMode extends Action {
            public static final int $stable = 0;
            public static final SelectPageFitMode INSTANCE = new SelectPageFitMode();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SelectPageFitMode)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 878930490;
            }

            public String toString() {
                return "SelectPageFitMode";
            }

            private SelectPageFitMode() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FilesAndFoldersReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$Action$PageFitModeSelected;", "Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$Action;", "pageFitMode", "Lcom/box/android/domain/models/preview/PageFitMode;", "<init>", "(Lcom/box/android/domain/models/preview/PageFitMode;)V", "getPageFitMode", "()Lcom/box/android/domain/models/preview/PageFitMode;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PageFitModeSelected extends Action {
            public static final int $stable = 0;
            private final PageFitMode pageFitMode;

            public static /* synthetic */ PageFitModeSelected copy$default(PageFitModeSelected pageFitModeSelected, PageFitMode pageFitMode, int i, Object obj) {
                if ((i & 1) != 0) {
                    pageFitMode = pageFitModeSelected.pageFitMode;
                }
                return pageFitModeSelected.copy(pageFitMode);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final PageFitMode getPageFitMode() {
                return this.pageFitMode;
            }

            public final PageFitModeSelected copy(PageFitMode pageFitMode) {
                Intrinsics.checkNotNullParameter(pageFitMode, "pageFitMode");
                return new PageFitModeSelected(pageFitMode);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof PageFitModeSelected) && this.pageFitMode == ((PageFitModeSelected) other).pageFitMode;
            }

            public int hashCode() {
                return this.pageFitMode.hashCode();
            }

            public String toString() {
                return "PageFitModeSelected(pageFitMode=" + this.pageFitMode + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PageFitModeSelected(PageFitMode pageFitMode) {
                super(null);
                Intrinsics.checkNotNullParameter(pageFitMode, "pageFitMode");
                this.pageFitMode = pageFitMode;
            }

            public final PageFitMode getPageFitMode() {
                return this.pageFitMode;
            }
        }

        /* JADX INFO: compiled from: FilesAndFoldersReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$Action$SelectPagingMode;", "Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$Action;", "scrollableFileType", "Lcom/box/android/domain/models/preview/ScrollableFileType;", "<init>", "(Lcom/box/android/domain/models/preview/ScrollableFileType;)V", "getScrollableFileType", "()Lcom/box/android/domain/models/preview/ScrollableFileType;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SelectPagingMode extends Action {
            public static final int $stable = 0;
            private final ScrollableFileType scrollableFileType;

            public static /* synthetic */ SelectPagingMode copy$default(SelectPagingMode selectPagingMode, ScrollableFileType scrollableFileType, int i, Object obj) {
                if ((i & 1) != 0) {
                    scrollableFileType = selectPagingMode.scrollableFileType;
                }
                return selectPagingMode.copy(scrollableFileType);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ScrollableFileType getScrollableFileType() {
                return this.scrollableFileType;
            }

            public final SelectPagingMode copy(ScrollableFileType scrollableFileType) {
                Intrinsics.checkNotNullParameter(scrollableFileType, "scrollableFileType");
                return new SelectPagingMode(scrollableFileType);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SelectPagingMode) && this.scrollableFileType == ((SelectPagingMode) other).scrollableFileType;
            }

            public int hashCode() {
                return this.scrollableFileType.hashCode();
            }

            public String toString() {
                return "SelectPagingMode(scrollableFileType=" + this.scrollableFileType + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SelectPagingMode(ScrollableFileType scrollableFileType) {
                super(null);
                Intrinsics.checkNotNullParameter(scrollableFileType, "scrollableFileType");
                this.scrollableFileType = scrollableFileType;
            }

            public final ScrollableFileType getScrollableFileType() {
                return this.scrollableFileType;
            }
        }

        /* JADX INFO: compiled from: FilesAndFoldersReducer.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$Action$PagingModeSelected;", "Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$Action;", "pagingMode", "Lcom/box/android/preview/filesandfolders/PagingMode;", "scrollableFileType", "Lcom/box/android/domain/models/preview/ScrollableFileType;", "<init>", "(Lcom/box/android/preview/filesandfolders/PagingMode;Lcom/box/android/domain/models/preview/ScrollableFileType;)V", "getPagingMode", "()Lcom/box/android/preview/filesandfolders/PagingMode;", "getScrollableFileType", "()Lcom/box/android/domain/models/preview/ScrollableFileType;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PagingModeSelected extends Action {
            public static final int $stable = 0;
            private final PagingMode pagingMode;
            private final ScrollableFileType scrollableFileType;

            public static /* synthetic */ PagingModeSelected copy$default(PagingModeSelected pagingModeSelected, PagingMode pagingMode, ScrollableFileType scrollableFileType, int i, Object obj) {
                if ((i & 1) != 0) {
                    pagingMode = pagingModeSelected.pagingMode;
                }
                if ((i & 2) != 0) {
                    scrollableFileType = pagingModeSelected.scrollableFileType;
                }
                return pagingModeSelected.copy(pagingMode, scrollableFileType);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final PagingMode getPagingMode() {
                return this.pagingMode;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final ScrollableFileType getScrollableFileType() {
                return this.scrollableFileType;
            }

            public final PagingModeSelected copy(PagingMode pagingMode, ScrollableFileType scrollableFileType) {
                Intrinsics.checkNotNullParameter(pagingMode, "pagingMode");
                Intrinsics.checkNotNullParameter(scrollableFileType, "scrollableFileType");
                return new PagingModeSelected(pagingMode, scrollableFileType);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PagingModeSelected)) {
                    return false;
                }
                PagingModeSelected pagingModeSelected = (PagingModeSelected) other;
                return this.pagingMode == pagingModeSelected.pagingMode && this.scrollableFileType == pagingModeSelected.scrollableFileType;
            }

            public int hashCode() {
                return (this.pagingMode.hashCode() * 31) + this.scrollableFileType.hashCode();
            }

            public String toString() {
                return "PagingModeSelected(pagingMode=" + this.pagingMode + ", scrollableFileType=" + this.scrollableFileType + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PagingModeSelected(PagingMode pagingMode, ScrollableFileType scrollableFileType) {
                super(null);
                Intrinsics.checkNotNullParameter(pagingMode, "pagingMode");
                Intrinsics.checkNotNullParameter(scrollableFileType, "scrollableFileType");
                this.pagingMode = pagingMode;
                this.scrollableFileType = scrollableFileType;
            }

            public final PagingMode getPagingMode() {
                return this.pagingMode;
            }

            public final ScrollableFileType getScrollableFileType() {
                return this.scrollableFileType;
            }
        }

        /* JADX INFO: compiled from: FilesAndFoldersReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$Action$DismissSelectionDialog;", "Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class DismissSelectionDialog extends Action {
            public static final int $stable = 0;
            public static final DismissSelectionDialog INSTANCE = new DismissSelectionDialog();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof DismissSelectionDialog)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -364312679;
            }

            public String toString() {
                return "DismissSelectionDialog";
            }

            private DismissSelectionDialog() {
                super(null);
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReducerResult build$lambda$0(FilesAndFoldersReducer filesAndFoldersReducer, State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (Intrinsics.areEqual(action, Action.CloseScreen.INSTANCE)) {
            return new ReducerResult(State.copy$default(state, null, null, null, null, null, true, 31, null), null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.SelectPageFitMode.INSTANCE)) {
            return new ReducerResult(State.copy$default(state, null, null, null, null, SelectionDialogState.PageDisplay.INSTANCE, false, 47, null), null, 2, null);
        }
        if (action instanceof Action.PageFitModeSelected) {
            filesAndFoldersReducer.environment.getPreviewSettingsService().setPageFitMode(((Action.PageFitModeSelected) action).getPageFitMode());
            return filesAndFoldersReducer.updatePageFitMode(state);
        }
        if (action instanceof Action.SelectPagingMode) {
            return new ReducerResult(State.copy$default(state, null, null, null, null, new SelectionDialogState.PagingMode(((Action.SelectPagingMode) action).getScrollableFileType()), false, 47, null), null, 2, null);
        }
        if (action instanceof Action.PagingModeSelected) {
            Action.PagingModeSelected pagingModeSelected = (Action.PagingModeSelected) action;
            int i = WhenMappings.$EnumSwitchMapping$0[pagingModeSelected.getPagingMode().ordinal()];
            if (i == 1) {
                filesAndFoldersReducer.environment.getPreviewSettingsService().setHorizontalScrolling(pagingModeSelected.getScrollableFileType());
            } else if (i == 2) {
                filesAndFoldersReducer.environment.getPreviewSettingsService().setVerticalPageByPageScrolling(pagingModeSelected.getScrollableFileType());
            } else {
                if (i != 3) {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    return new ReducerResult(State.copy$default(state, null, null, null, null, null, false, 47, null), null, 2, null);
                }
                filesAndFoldersReducer.environment.getPreviewSettingsService().setVerticalContinuousScrolling(pagingModeSelected.getScrollableFileType());
            }
            return filesAndFoldersReducer.updateScrollSettingsState(state, pagingModeSelected.getScrollableFileType());
        }
        if (!Intrinsics.areEqual(action, Action.DismissSelectionDialog.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult(State.copy$default(state, null, null, null, null, null, false, 47, null), null, 2, null);
    }

    private final ReducerResult<State, Action> updatePageFitMode(State state) {
        return new ReducerResult<>(State.copy$default(state, this.environment.getPreviewSettingsService().getPageFitMode(), null, null, null, null, false, 46, null), null, 2, null);
    }

    private final ReducerResult<State, Action> updateScrollSettingsState(State state, ScrollableFileType scrollableFileType) {
        ScrollSettings pageScrollSettings = this.environment.getPreviewSettingsService().getPageScrollSettings(scrollableFileType);
        int i = WhenMappings.$EnumSwitchMapping$1[scrollableFileType.ordinal()];
        if (i == 1) {
            return new ReducerResult<>(State.copy$default(state, null, pageScrollSettings, null, null, null, false, 45, null), null, 2, null);
        }
        if (i == 2) {
            return new ReducerResult<>(State.copy$default(state, null, null, pageScrollSettings, null, null, false, 43, null), null, 2, null);
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult<>(State.copy$default(state, null, null, null, pageScrollSettings, null, false, 39, null), null, 2, null);
    }
}

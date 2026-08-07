package com.box.android.browse.cpl.browse.fab;

import android.app.Activity;
import android.content.Intent;
import com.box.android.base.analytics.UploadAnalyticsUtils;
import com.box.android.browse.cpl.browse.fab.newfile.NewFileType;
import com.box.android.common.utilities.Connectivity;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.NewNoteLocation;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.domain.usecases.jobs.JobTags;
import com.box.androidsdk.content.models.BoxUser;
import com.pspdfkit.analytics.Analytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FilesFabReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0006\u0016\u0017\u0018\u0019\u001a\u001bB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0003H\u0016J$\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0013H\u0002J\f\u0010\u0014\u001a\u00020\u0015*\u00020\u0013H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$State;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action;", "environment", "Lcom/box/android/browse/cpl/browse/fab/FilesFabEnvironment;", "<init>", "(Lcom/box/android/browse/cpl/browse/fab/FilesFabEnvironment;)V", "getEnvironment", "()Lcom/box/android/browse/cpl/browse/fab/FilesFabEnvironment;", "reduce", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "initializeFab", "folder", "Lcom/box/android/domain/models/item/FolderModel;", "toJobSource", "Lcom/box/android/domain/usecases/jobs/JobTags$JobSource;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$UploadType;", "toLaunchPickerEffect", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$ViewEffect;", "State", "FabMenuOption", "CreateNewDocumentMenuState", "ViewEffect", "UploadType", "Action", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FilesFabReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final FilesFabEnvironment environment;

    /* JADX INFO: compiled from: FilesFabReducer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$FabMenuOption;", "", "<init>", "(Ljava/lang/String;I)V", "NEW_FOLDER", "NEW_DOCUMENT", "UPLOAD_CONTENT", "CAPTURE_MEDIA", "NEW_BOX_NOTE", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum FabMenuOption {
        NEW_FOLDER,
        NEW_DOCUMENT,
        UPLOAD_CONTENT,
        CAPTURE_MEDIA,
        NEW_BOX_NOTE;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<FabMenuOption> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: FilesFabReducer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$UploadType;", "", "<init>", "(Ljava/lang/String;I)V", "UPLOAD_FILES", "UPLOAD_FOLDER", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum UploadType {
        UPLOAD_FILES,
        UPLOAD_FOLDER;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<UploadType> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: FilesFabReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UploadType.values().length];
            try {
                iArr[UploadType.UPLOAD_FILES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UploadType.UPLOAD_FOLDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public FilesFabReducer(FilesFabEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ Reducable<State, Action> getBuild() {
        return Reducable.DefaultImpls.getBuild(this);
    }

    public final FilesFabEnvironment getEnvironment() {
        return this.environment;
    }

    /* JADX INFO: compiled from: FilesFabReducer.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u000eHÆ\u0003J\t\u0010$\u001a\u00020\u0010HÆ\u0003Ji\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u0010&\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0015R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0015R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0015R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006,"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$State;", "", "currentFolder", "Lcom/box/android/domain/models/item/FolderModel;", "isInitialized", "", "isFabVisible", "menuOptions", "", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$FabMenuOption;", "isMenuExpanded", "isUploadContentMenuVisible", "isStorageAccessDialogVisible", "createNewDocumentMenuState", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$CreateNewDocumentMenuState;", "viewEffect", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$ViewEffect;", "<init>", "(Lcom/box/android/domain/models/item/FolderModel;ZZLjava/util/List;ZZZLcom/box/android/browse/cpl/browse/fab/FilesFabReducer$CreateNewDocumentMenuState;Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$ViewEffect;)V", "getCurrentFolder", "()Lcom/box/android/domain/models/item/FolderModel;", "()Z", "getMenuOptions", "()Ljava/util/List;", "getCreateNewDocumentMenuState", "()Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$CreateNewDocumentMenuState;", "getViewEffect", "()Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$ViewEffect;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final CreateNewDocumentMenuState createNewDocumentMenuState;
        private final FolderModel currentFolder;
        private final boolean isFabVisible;
        private final boolean isInitialized;
        private final boolean isMenuExpanded;
        private final boolean isStorageAccessDialogVisible;
        private final boolean isUploadContentMenuVisible;
        private final List<FabMenuOption> menuOptions;
        private final ViewEffect viewEffect;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, FolderModel folderModel, boolean z, boolean z2, List list, boolean z3, boolean z4, boolean z5, CreateNewDocumentMenuState createNewDocumentMenuState, ViewEffect viewEffect, int i, Object obj) {
            if ((i & 1) != 0) {
                folderModel = state.currentFolder;
            }
            if ((i & 2) != 0) {
                z = state.isInitialized;
            }
            if ((i & 4) != 0) {
                z2 = state.isFabVisible;
            }
            if ((i & 8) != 0) {
                list = state.menuOptions;
            }
            if ((i & 16) != 0) {
                z3 = state.isMenuExpanded;
            }
            if ((i & 32) != 0) {
                z4 = state.isUploadContentMenuVisible;
            }
            if ((i & 64) != 0) {
                z5 = state.isStorageAccessDialogVisible;
            }
            if ((i & 128) != 0) {
                createNewDocumentMenuState = state.createNewDocumentMenuState;
            }
            if ((i & 256) != 0) {
                viewEffect = state.viewEffect;
            }
            CreateNewDocumentMenuState createNewDocumentMenuState2 = createNewDocumentMenuState;
            ViewEffect viewEffect2 = viewEffect;
            boolean z6 = z4;
            boolean z7 = z5;
            boolean z8 = z3;
            boolean z9 = z2;
            return state.copy(folderModel, z, z9, list, z8, z6, z7, createNewDocumentMenuState2, viewEffect2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FolderModel getCurrentFolder() {
            return this.currentFolder;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsInitialized() {
            return this.isInitialized;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsFabVisible() {
            return this.isFabVisible;
        }

        public final List<FabMenuOption> component4() {
            return this.menuOptions;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsMenuExpanded() {
            return this.isMenuExpanded;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getIsUploadContentMenuVisible() {
            return this.isUploadContentMenuVisible;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getIsStorageAccessDialogVisible() {
            return this.isStorageAccessDialogVisible;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final CreateNewDocumentMenuState getCreateNewDocumentMenuState() {
            return this.createNewDocumentMenuState;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final ViewEffect getViewEffect() {
            return this.viewEffect;
        }

        public final State copy(FolderModel currentFolder, boolean isInitialized, boolean isFabVisible, List<? extends FabMenuOption> menuOptions, boolean isMenuExpanded, boolean isUploadContentMenuVisible, boolean isStorageAccessDialogVisible, CreateNewDocumentMenuState createNewDocumentMenuState, ViewEffect viewEffect) {
            Intrinsics.checkNotNullParameter(currentFolder, "currentFolder");
            Intrinsics.checkNotNullParameter(menuOptions, "menuOptions");
            Intrinsics.checkNotNullParameter(createNewDocumentMenuState, "createNewDocumentMenuState");
            Intrinsics.checkNotNullParameter(viewEffect, "viewEffect");
            return new State(currentFolder, isInitialized, isFabVisible, menuOptions, isMenuExpanded, isUploadContentMenuVisible, isStorageAccessDialogVisible, createNewDocumentMenuState, viewEffect);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.currentFolder, state.currentFolder) && this.isInitialized == state.isInitialized && this.isFabVisible == state.isFabVisible && Intrinsics.areEqual(this.menuOptions, state.menuOptions) && this.isMenuExpanded == state.isMenuExpanded && this.isUploadContentMenuVisible == state.isUploadContentMenuVisible && this.isStorageAccessDialogVisible == state.isStorageAccessDialogVisible && Intrinsics.areEqual(this.createNewDocumentMenuState, state.createNewDocumentMenuState) && Intrinsics.areEqual(this.viewEffect, state.viewEffect);
        }

        public int hashCode() {
            return (((((((((((((((this.currentFolder.hashCode() * 31) + Boolean.hashCode(this.isInitialized)) * 31) + Boolean.hashCode(this.isFabVisible)) * 31) + this.menuOptions.hashCode()) * 31) + Boolean.hashCode(this.isMenuExpanded)) * 31) + Boolean.hashCode(this.isUploadContentMenuVisible)) * 31) + Boolean.hashCode(this.isStorageAccessDialogVisible)) * 31) + this.createNewDocumentMenuState.hashCode()) * 31) + this.viewEffect.hashCode();
        }

        public String toString() {
            return "State(currentFolder=" + this.currentFolder + ", isInitialized=" + this.isInitialized + ", isFabVisible=" + this.isFabVisible + ", menuOptions=" + this.menuOptions + ", isMenuExpanded=" + this.isMenuExpanded + ", isUploadContentMenuVisible=" + this.isUploadContentMenuVisible + ", isStorageAccessDialogVisible=" + this.isStorageAccessDialogVisible + ", createNewDocumentMenuState=" + this.createNewDocumentMenuState + ", viewEffect=" + this.viewEffect + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public State(FolderModel currentFolder, boolean z, boolean z2, List<? extends FabMenuOption> menuOptions, boolean z3, boolean z4, boolean z5, CreateNewDocumentMenuState createNewDocumentMenuState, ViewEffect viewEffect) {
            Intrinsics.checkNotNullParameter(currentFolder, "currentFolder");
            Intrinsics.checkNotNullParameter(menuOptions, "menuOptions");
            Intrinsics.checkNotNullParameter(createNewDocumentMenuState, "createNewDocumentMenuState");
            Intrinsics.checkNotNullParameter(viewEffect, "viewEffect");
            this.currentFolder = currentFolder;
            this.isInitialized = z;
            this.isFabVisible = z2;
            this.menuOptions = menuOptions;
            this.isMenuExpanded = z3;
            this.isUploadContentMenuVisible = z4;
            this.isStorageAccessDialogVisible = z5;
            this.createNewDocumentMenuState = createNewDocumentMenuState;
            this.viewEffect = viewEffect;
        }

        public final FolderModel getCurrentFolder() {
            return this.currentFolder;
        }

        public final boolean isInitialized() {
            return this.isInitialized;
        }

        public final boolean isFabVisible() {
            return this.isFabVisible;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ State(FolderModel folderModel, boolean z, boolean z2, List list, boolean z3, boolean z4, boolean z5, CreateNewDocumentMenuState createNewDocumentMenuState, ViewEffect.None none, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(folderModel, (i & 2) != 0 ? false : z, (i & 4) != 0 ? true : z2, (i & 8) != 0 ? CollectionsKt.emptyList() : list, (i & 16) != 0 ? false : z3, (i & 32) != 0 ? false : z4, (i & 64) != 0 ? false : z5, (i & 128) != 0 ? new CreateNewDocumentMenuState(false, null, 3, 0 == true ? 1 : 0) : createNewDocumentMenuState, (i & 256) != 0 ? ViewEffect.None.INSTANCE : none);
        }

        public final List<FabMenuOption> getMenuOptions() {
            return this.menuOptions;
        }

        public final boolean isMenuExpanded() {
            return this.isMenuExpanded;
        }

        public final boolean isUploadContentMenuVisible() {
            return this.isUploadContentMenuVisible;
        }

        public final boolean isStorageAccessDialogVisible() {
            return this.isStorageAccessDialogVisible;
        }

        public final CreateNewDocumentMenuState getCreateNewDocumentMenuState() {
            return this.createNewDocumentMenuState;
        }

        public final ViewEffect getViewEffect() {
            return this.viewEffect;
        }
    }

    /* JADX INFO: compiled from: FilesFabReducer.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$CreateNewDocumentMenuState;", "", "isVisible", "", "menuItems", "", "Lcom/box/android/browse/cpl/browse/fab/newfile/NewFileType;", "<init>", "(ZLjava/util/List;)V", "()Z", "getMenuItems", "()Ljava/util/List;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CreateNewDocumentMenuState {
        public static final int $stable = 8;
        private final boolean isVisible;
        private final List<NewFileType> menuItems;

        /* JADX WARN: Multi-variable type inference failed */
        public CreateNewDocumentMenuState() {
            this(false, null, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CreateNewDocumentMenuState copy$default(CreateNewDocumentMenuState createNewDocumentMenuState, boolean z, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                z = createNewDocumentMenuState.isVisible;
            }
            if ((i & 2) != 0) {
                list = createNewDocumentMenuState.menuItems;
            }
            return createNewDocumentMenuState.copy(z, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsVisible() {
            return this.isVisible;
        }

        public final List<NewFileType> component2() {
            return this.menuItems;
        }

        public final CreateNewDocumentMenuState copy(boolean isVisible, List<? extends NewFileType> menuItems) {
            Intrinsics.checkNotNullParameter(menuItems, "menuItems");
            return new CreateNewDocumentMenuState(isVisible, menuItems);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CreateNewDocumentMenuState)) {
                return false;
            }
            CreateNewDocumentMenuState createNewDocumentMenuState = (CreateNewDocumentMenuState) other;
            return this.isVisible == createNewDocumentMenuState.isVisible && Intrinsics.areEqual(this.menuItems, createNewDocumentMenuState.menuItems);
        }

        public int hashCode() {
            return (Boolean.hashCode(this.isVisible) * 31) + this.menuItems.hashCode();
        }

        public String toString() {
            return "CreateNewDocumentMenuState(isVisible=" + this.isVisible + ", menuItems=" + this.menuItems + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public CreateNewDocumentMenuState(boolean z, List<? extends NewFileType> menuItems) {
            Intrinsics.checkNotNullParameter(menuItems, "menuItems");
            this.isVisible = z;
            this.menuItems = menuItems;
        }

        public /* synthetic */ CreateNewDocumentMenuState(boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
        }

        public final List<NewFileType> getMenuItems() {
            return this.menuItems;
        }

        public final boolean isVisible() {
            return this.isVisible;
        }
    }

    /* JADX INFO: compiled from: FilesFabReducer.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$ViewEffect;", "", "<init>", "()V", "NoConnectivityErrorMessage", "RequestStorageAccess", "StorageAccessGrantedMessage", "LaunchFilePicker", "LaunchFolderPicker", "None", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$ViewEffect$LaunchFilePicker;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$ViewEffect$LaunchFolderPicker;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$ViewEffect$NoConnectivityErrorMessage;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$ViewEffect$None;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$ViewEffect$RequestStorageAccess;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$ViewEffect$StorageAccessGrantedMessage;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class ViewEffect {
        public static final int $stable = 0;

        public /* synthetic */ ViewEffect(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: FilesFabReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$ViewEffect$NoConnectivityErrorMessage;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$ViewEffect;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class NoConnectivityErrorMessage extends ViewEffect {
            public static final int $stable = 0;
            public static final NoConnectivityErrorMessage INSTANCE = new NoConnectivityErrorMessage();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NoConnectivityErrorMessage)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -2043081290;
            }

            public String toString() {
                return "NoConnectivityErrorMessage";
            }

            private NoConnectivityErrorMessage() {
                super(null);
            }
        }

        private ViewEffect() {
        }

        /* JADX INFO: compiled from: FilesFabReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$ViewEffect$RequestStorageAccess;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$ViewEffect;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RequestStorageAccess extends ViewEffect {
            public static final int $stable = 0;
            public static final RequestStorageAccess INSTANCE = new RequestStorageAccess();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RequestStorageAccess)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1164240049;
            }

            public String toString() {
                return "RequestStorageAccess";
            }

            private RequestStorageAccess() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FilesFabReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$ViewEffect$StorageAccessGrantedMessage;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$ViewEffect;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class StorageAccessGrantedMessage extends ViewEffect {
            public static final int $stable = 0;
            public static final StorageAccessGrantedMessage INSTANCE = new StorageAccessGrantedMessage();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof StorageAccessGrantedMessage)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 894315436;
            }

            public String toString() {
                return "StorageAccessGrantedMessage";
            }

            private StorageAccessGrantedMessage() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FilesFabReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$ViewEffect$LaunchFilePicker;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$ViewEffect;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class LaunchFilePicker extends ViewEffect {
            public static final int $stable = 0;
            public static final LaunchFilePicker INSTANCE = new LaunchFilePicker();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LaunchFilePicker)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1187708260;
            }

            public String toString() {
                return "LaunchFilePicker";
            }

            private LaunchFilePicker() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FilesFabReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$ViewEffect$LaunchFolderPicker;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$ViewEffect;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class LaunchFolderPicker extends ViewEffect {
            public static final int $stable = 0;
            public static final LaunchFolderPicker INSTANCE = new LaunchFolderPicker();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LaunchFolderPicker)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1780357006;
            }

            public String toString() {
                return "LaunchFolderPicker";
            }

            private LaunchFolderPicker() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FilesFabReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$ViewEffect$None;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$ViewEffect;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class None extends ViewEffect {
            public static final int $stable = 0;
            public static final None INSTANCE = new None();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof None)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1703243543;
            }

            public String toString() {
                return "None";
            }

            private None() {
                super(null);
            }
        }
    }

    /* JADX INFO: compiled from: FilesFabReducer.kt */
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0015\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0015\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-¨\u0006."}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action;", "", "<init>", "()V", "Initialize", "FabClicked", "FabContentViewed", "FabMenuDismissed", "CreateNewFolderClicked", "CreateNewDocumentClicked", "CreateNewBoxNoteClicked", "UploadContentClicked", "CaptureMediaClicked", "CreateNewFolder", "CreateNewDocumentMenuDismissed", "StorageAccessDialogDismissed", "StorageAccessDialogPositiveClicked", "StorageAccessGranted", "StorageAccessDenied", "UploadTypeSelected", "UploadDataSelected", "UploadContentMenuViewed", "UploadSelectionDismissed", "ChangeFabVisibility", "OnViewEffectProcessed", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$CaptureMediaClicked;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$ChangeFabVisibility;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$CreateNewBoxNoteClicked;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$CreateNewDocumentClicked;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$CreateNewDocumentMenuDismissed;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$CreateNewFolder;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$CreateNewFolderClicked;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$FabClicked;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$FabContentViewed;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$FabMenuDismissed;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$Initialize;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$OnViewEffectProcessed;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$StorageAccessDenied;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$StorageAccessDialogDismissed;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$StorageAccessDialogPositiveClicked;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$StorageAccessGranted;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$UploadContentClicked;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$UploadContentMenuViewed;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$UploadDataSelected;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$UploadSelectionDismissed;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$UploadTypeSelected;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: FilesFabReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$Initialize;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action;", "folder", "Lcom/box/android/domain/models/item/FolderModel;", "<init>", "(Lcom/box/android/domain/models/item/FolderModel;)V", "getFolder", "()Lcom/box/android/domain/models/item/FolderModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Initialize extends Action {
            public static final int $stable = 8;
            private final FolderModel folder;

            public static /* synthetic */ Initialize copy$default(Initialize initialize, FolderModel folderModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    folderModel = initialize.folder;
                }
                return initialize.copy(folderModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FolderModel getFolder() {
                return this.folder;
            }

            public final Initialize copy(FolderModel folder) {
                Intrinsics.checkNotNullParameter(folder, "folder");
                return new Initialize(folder);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Initialize) && Intrinsics.areEqual(this.folder, ((Initialize) other).folder);
            }

            public int hashCode() {
                return this.folder.hashCode();
            }

            public String toString() {
                return "Initialize(folder=" + this.folder + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Initialize(FolderModel folder) {
                super(null);
                Intrinsics.checkNotNullParameter(folder, "folder");
                this.folder = folder;
            }

            public final FolderModel getFolder() {
                return this.folder;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: FilesFabReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$FabClicked;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FabClicked extends Action {
            public static final int $stable = 0;
            public static final FabClicked INSTANCE = new FabClicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FabClicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1740836255;
            }

            public String toString() {
                return "FabClicked";
            }

            private FabClicked() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FilesFabReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$FabContentViewed;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FabContentViewed extends Action {
            public static final int $stable = 0;
            public static final FabContentViewed INSTANCE = new FabContentViewed();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FabContentViewed)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 576509781;
            }

            public String toString() {
                return "FabContentViewed";
            }

            private FabContentViewed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FilesFabReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$FabMenuDismissed;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FabMenuDismissed extends Action {
            public static final int $stable = 0;
            public static final FabMenuDismissed INSTANCE = new FabMenuDismissed();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FabMenuDismissed)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -386175614;
            }

            public String toString() {
                return "FabMenuDismissed";
            }

            private FabMenuDismissed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FilesFabReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$CreateNewFolderClicked;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action;", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CreateNewFolderClicked extends Action {
            public static final int $stable = 8;
            private final Activity activity;

            public static /* synthetic */ CreateNewFolderClicked copy$default(CreateNewFolderClicked createNewFolderClicked, Activity activity, int i, Object obj) {
                if ((i & 1) != 0) {
                    activity = createNewFolderClicked.activity;
                }
                return createNewFolderClicked.copy(activity);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Activity getActivity() {
                return this.activity;
            }

            public final CreateNewFolderClicked copy(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                return new CreateNewFolderClicked(activity);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CreateNewFolderClicked) && Intrinsics.areEqual(this.activity, ((CreateNewFolderClicked) other).activity);
            }

            public int hashCode() {
                return this.activity.hashCode();
            }

            public String toString() {
                return "CreateNewFolderClicked(activity=" + this.activity + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CreateNewFolderClicked(Activity activity) {
                super(null);
                Intrinsics.checkNotNullParameter(activity, "activity");
                this.activity = activity;
            }

            public final Activity getActivity() {
                return this.activity;
            }
        }

        /* JADX INFO: compiled from: FilesFabReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$CreateNewDocumentClicked;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action;", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CreateNewDocumentClicked extends Action {
            public static final int $stable = 8;
            private final Activity activity;

            public static /* synthetic */ CreateNewDocumentClicked copy$default(CreateNewDocumentClicked createNewDocumentClicked, Activity activity, int i, Object obj) {
                if ((i & 1) != 0) {
                    activity = createNewDocumentClicked.activity;
                }
                return createNewDocumentClicked.copy(activity);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Activity getActivity() {
                return this.activity;
            }

            public final CreateNewDocumentClicked copy(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                return new CreateNewDocumentClicked(activity);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CreateNewDocumentClicked) && Intrinsics.areEqual(this.activity, ((CreateNewDocumentClicked) other).activity);
            }

            public int hashCode() {
                return this.activity.hashCode();
            }

            public String toString() {
                return "CreateNewDocumentClicked(activity=" + this.activity + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CreateNewDocumentClicked(Activity activity) {
                super(null);
                Intrinsics.checkNotNullParameter(activity, "activity");
                this.activity = activity;
            }

            public final Activity getActivity() {
                return this.activity;
            }
        }

        /* JADX INFO: compiled from: FilesFabReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$CreateNewBoxNoteClicked;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action;", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CreateNewBoxNoteClicked extends Action {
            public static final int $stable = 8;
            private final Activity activity;

            public static /* synthetic */ CreateNewBoxNoteClicked copy$default(CreateNewBoxNoteClicked createNewBoxNoteClicked, Activity activity, int i, Object obj) {
                if ((i & 1) != 0) {
                    activity = createNewBoxNoteClicked.activity;
                }
                return createNewBoxNoteClicked.copy(activity);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Activity getActivity() {
                return this.activity;
            }

            public final CreateNewBoxNoteClicked copy(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                return new CreateNewBoxNoteClicked(activity);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CreateNewBoxNoteClicked) && Intrinsics.areEqual(this.activity, ((CreateNewBoxNoteClicked) other).activity);
            }

            public int hashCode() {
                return this.activity.hashCode();
            }

            public String toString() {
                return "CreateNewBoxNoteClicked(activity=" + this.activity + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CreateNewBoxNoteClicked(Activity activity) {
                super(null);
                Intrinsics.checkNotNullParameter(activity, "activity");
                this.activity = activity;
            }

            public final Activity getActivity() {
                return this.activity;
            }
        }

        /* JADX INFO: compiled from: FilesFabReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$UploadContentClicked;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action;", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UploadContentClicked extends Action {
            public static final int $stable = 8;
            private final Activity activity;

            public static /* synthetic */ UploadContentClicked copy$default(UploadContentClicked uploadContentClicked, Activity activity, int i, Object obj) {
                if ((i & 1) != 0) {
                    activity = uploadContentClicked.activity;
                }
                return uploadContentClicked.copy(activity);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Activity getActivity() {
                return this.activity;
            }

            public final UploadContentClicked copy(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                return new UploadContentClicked(activity);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UploadContentClicked) && Intrinsics.areEqual(this.activity, ((UploadContentClicked) other).activity);
            }

            public int hashCode() {
                return this.activity.hashCode();
            }

            public String toString() {
                return "UploadContentClicked(activity=" + this.activity + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UploadContentClicked(Activity activity) {
                super(null);
                Intrinsics.checkNotNullParameter(activity, "activity");
                this.activity = activity;
            }

            public final Activity getActivity() {
                return this.activity;
            }
        }

        /* JADX INFO: compiled from: FilesFabReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$CaptureMediaClicked;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action;", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CaptureMediaClicked extends Action {
            public static final int $stable = 8;
            private final Activity activity;

            public static /* synthetic */ CaptureMediaClicked copy$default(CaptureMediaClicked captureMediaClicked, Activity activity, int i, Object obj) {
                if ((i & 1) != 0) {
                    activity = captureMediaClicked.activity;
                }
                return captureMediaClicked.copy(activity);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Activity getActivity() {
                return this.activity;
            }

            public final CaptureMediaClicked copy(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                return new CaptureMediaClicked(activity);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CaptureMediaClicked) && Intrinsics.areEqual(this.activity, ((CaptureMediaClicked) other).activity);
            }

            public int hashCode() {
                return this.activity.hashCode();
            }

            public String toString() {
                return "CaptureMediaClicked(activity=" + this.activity + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CaptureMediaClicked(Activity activity) {
                super(null);
                Intrinsics.checkNotNullParameter(activity, "activity");
                this.activity = activity;
            }

            public final Activity getActivity() {
                return this.activity;
            }
        }

        /* JADX INFO: compiled from: FilesFabReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$CreateNewFolder;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CreateNewFolder extends Action {
            public static final int $stable = 0;
            public static final CreateNewFolder INSTANCE = new CreateNewFolder();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CreateNewFolder)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1520732813;
            }

            public String toString() {
                return "CreateNewFolder";
            }

            private CreateNewFolder() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FilesFabReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$CreateNewDocumentMenuDismissed;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CreateNewDocumentMenuDismissed extends Action {
            public static final int $stable = 0;
            public static final CreateNewDocumentMenuDismissed INSTANCE = new CreateNewDocumentMenuDismissed();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CreateNewDocumentMenuDismissed)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1051265290;
            }

            public String toString() {
                return "CreateNewDocumentMenuDismissed";
            }

            private CreateNewDocumentMenuDismissed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FilesFabReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$StorageAccessDialogDismissed;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class StorageAccessDialogDismissed extends Action {
            public static final int $stable = 0;
            public static final StorageAccessDialogDismissed INSTANCE = new StorageAccessDialogDismissed();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof StorageAccessDialogDismissed)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -389385407;
            }

            public String toString() {
                return "StorageAccessDialogDismissed";
            }

            private StorageAccessDialogDismissed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FilesFabReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$StorageAccessDialogPositiveClicked;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class StorageAccessDialogPositiveClicked extends Action {
            public static final int $stable = 0;
            public static final StorageAccessDialogPositiveClicked INSTANCE = new StorageAccessDialogPositiveClicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof StorageAccessDialogPositiveClicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1802039430;
            }

            public String toString() {
                return "StorageAccessDialogPositiveClicked";
            }

            private StorageAccessDialogPositiveClicked() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FilesFabReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$StorageAccessGranted;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class StorageAccessGranted extends Action {
            public static final int $stable = 0;
            public static final StorageAccessGranted INSTANCE = new StorageAccessGranted();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof StorageAccessGranted)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1801228731;
            }

            public String toString() {
                return "StorageAccessGranted";
            }

            private StorageAccessGranted() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FilesFabReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$StorageAccessDenied;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class StorageAccessDenied extends Action {
            public static final int $stable = 0;
            public static final StorageAccessDenied INSTANCE = new StorageAccessDenied();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof StorageAccessDenied)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -455049061;
            }

            public String toString() {
                return "StorageAccessDenied";
            }

            private StorageAccessDenied() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FilesFabReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$UploadTypeSelected;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action;", "type", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$UploadType;", "<init>", "(Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$UploadType;)V", "getType", "()Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$UploadType;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UploadTypeSelected extends Action {
            public static final int $stable = 0;
            private final UploadType type;

            public static /* synthetic */ UploadTypeSelected copy$default(UploadTypeSelected uploadTypeSelected, UploadType uploadType, int i, Object obj) {
                if ((i & 1) != 0) {
                    uploadType = uploadTypeSelected.type;
                }
                return uploadTypeSelected.copy(uploadType);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final UploadType getType() {
                return this.type;
            }

            public final UploadTypeSelected copy(UploadType type) {
                Intrinsics.checkNotNullParameter(type, "type");
                return new UploadTypeSelected(type);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UploadTypeSelected) && this.type == ((UploadTypeSelected) other).type;
            }

            public int hashCode() {
                return this.type.hashCode();
            }

            public String toString() {
                return "UploadTypeSelected(type=" + this.type + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UploadTypeSelected(UploadType type) {
                super(null);
                Intrinsics.checkNotNullParameter(type, "type");
                this.type = type;
            }

            public final UploadType getType() {
                return this.type;
            }
        }

        /* JADX INFO: compiled from: FilesFabReducer.kt */
        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$UploadDataSelected;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action;", "activity", "Landroid/app/Activity;", "data", "Landroid/content/Intent;", "type", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$UploadType;", "<init>", "(Landroid/app/Activity;Landroid/content/Intent;Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$UploadType;)V", "getActivity", "()Landroid/app/Activity;", "getData", "()Landroid/content/Intent;", "getType", "()Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$UploadType;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UploadDataSelected extends Action {
            public static final int $stable = 8;
            private final Activity activity;
            private final Intent data;
            private final UploadType type;

            public static /* synthetic */ UploadDataSelected copy$default(UploadDataSelected uploadDataSelected, Activity activity, Intent intent, UploadType uploadType, int i, Object obj) {
                if ((i & 1) != 0) {
                    activity = uploadDataSelected.activity;
                }
                if ((i & 2) != 0) {
                    intent = uploadDataSelected.data;
                }
                if ((i & 4) != 0) {
                    uploadType = uploadDataSelected.type;
                }
                return uploadDataSelected.copy(activity, intent, uploadType);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Activity getActivity() {
                return this.activity;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Intent getData() {
                return this.data;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final UploadType getType() {
                return this.type;
            }

            public final UploadDataSelected copy(Activity activity, Intent data, UploadType type) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(type, "type");
                return new UploadDataSelected(activity, data, type);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof UploadDataSelected)) {
                    return false;
                }
                UploadDataSelected uploadDataSelected = (UploadDataSelected) other;
                return Intrinsics.areEqual(this.activity, uploadDataSelected.activity) && Intrinsics.areEqual(this.data, uploadDataSelected.data) && this.type == uploadDataSelected.type;
            }

            public int hashCode() {
                return (((this.activity.hashCode() * 31) + this.data.hashCode()) * 31) + this.type.hashCode();
            }

            public String toString() {
                return "UploadDataSelected(activity=" + this.activity + ", data=" + this.data + ", type=" + this.type + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UploadDataSelected(Activity activity, Intent data, UploadType type) {
                super(null);
                Intrinsics.checkNotNullParameter(activity, "activity");
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(type, "type");
                this.activity = activity;
                this.data = data;
                this.type = type;
            }

            public final Activity getActivity() {
                return this.activity;
            }

            public final Intent getData() {
                return this.data;
            }

            public final UploadType getType() {
                return this.type;
            }
        }

        /* JADX INFO: compiled from: FilesFabReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$UploadContentMenuViewed;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UploadContentMenuViewed extends Action {
            public static final int $stable = 0;
            public static final UploadContentMenuViewed INSTANCE = new UploadContentMenuViewed();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof UploadContentMenuViewed)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -309919364;
            }

            public String toString() {
                return "UploadContentMenuViewed";
            }

            private UploadContentMenuViewed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: FilesFabReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$UploadSelectionDismissed;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action;", "flowWasCancelled", "", "<init>", "(Z)V", "getFlowWasCancelled", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UploadSelectionDismissed extends Action {
            public static final int $stable = 0;
            private final boolean flowWasCancelled;

            public static /* synthetic */ UploadSelectionDismissed copy$default(UploadSelectionDismissed uploadSelectionDismissed, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = uploadSelectionDismissed.flowWasCancelled;
                }
                return uploadSelectionDismissed.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getFlowWasCancelled() {
                return this.flowWasCancelled;
            }

            public final UploadSelectionDismissed copy(boolean flowWasCancelled) {
                return new UploadSelectionDismissed(flowWasCancelled);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UploadSelectionDismissed) && this.flowWasCancelled == ((UploadSelectionDismissed) other).flowWasCancelled;
            }

            public int hashCode() {
                return Boolean.hashCode(this.flowWasCancelled);
            }

            public String toString() {
                return "UploadSelectionDismissed(flowWasCancelled=" + this.flowWasCancelled + ")";
            }

            public UploadSelectionDismissed(boolean z) {
                super(null);
                this.flowWasCancelled = z;
            }

            public final boolean getFlowWasCancelled() {
                return this.flowWasCancelled;
            }
        }

        /* JADX INFO: compiled from: FilesFabReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$ChangeFabVisibility;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action;", "isVisible", "", "<init>", "(Z)V", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ChangeFabVisibility extends Action {
            public static final int $stable = 0;
            private final boolean isVisible;

            public static /* synthetic */ ChangeFabVisibility copy$default(ChangeFabVisibility changeFabVisibility, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = changeFabVisibility.isVisible;
                }
                return changeFabVisibility.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getIsVisible() {
                return this.isVisible;
            }

            public final ChangeFabVisibility copy(boolean isVisible) {
                return new ChangeFabVisibility(isVisible);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ChangeFabVisibility) && this.isVisible == ((ChangeFabVisibility) other).isVisible;
            }

            public int hashCode() {
                return Boolean.hashCode(this.isVisible);
            }

            public String toString() {
                return "ChangeFabVisibility(isVisible=" + this.isVisible + ")";
            }

            public ChangeFabVisibility(boolean z) {
                super(null);
                this.isVisible = z;
            }

            public final boolean isVisible() {
                return this.isVisible;
            }
        }

        /* JADX INFO: compiled from: FilesFabReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action$OnViewEffectProcessed;", "Lcom/box/android/browse/cpl/browse/fab/FilesFabReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class OnViewEffectProcessed extends Action {
            public static final int $stable = 0;
            public static final OnViewEffectProcessed INSTANCE = new OnViewEffectProcessed();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof OnViewEffectProcessed)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1573138202;
            }

            public String toString() {
                return "OnViewEffectProcessed";
            }

            private OnViewEffectProcessed() {
                super(null);
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public ReducerResult<State, Action> reduce(State state, Action action) {
        State stateCopy$default;
        Effect effectNone;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof Action.Initialize) {
            return initializeFab(state, ((Action.Initialize) action).getFolder());
        }
        if (Intrinsics.areEqual(action, Action.FabClicked.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, null, false, false, null, true, false, false, null, null, 495, null), Effect.INSTANCE.fireAndForget(new AnonymousClass1(null)));
        }
        if (Intrinsics.areEqual(action, Action.FabContentViewed.INSTANCE)) {
            return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass2(null)));
        }
        if (Intrinsics.areEqual(action, Action.FabMenuDismissed.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, null, false, false, null, false, false, false, null, null, 495, null), null, 2, null);
        }
        if (action instanceof Action.CreateNewFolderClicked) {
            if (this.environment.getFabManager().handleNewFolderClick(state.getCurrentFolder(), ((Action.CreateNewFolderClicked) action).getActivity()) instanceof FabMenuOptionResult.Success) {
                effectNone = new Effect(Action.CreateNewFolder.INSTANCE);
            } else {
                effectNone = Effect.INSTANCE.none();
            }
            return new ReducerResult<>(state, effectNone);
        }
        if (action instanceof Action.CreateNewDocumentClicked) {
            FabMenuOptionResult fabMenuOptionResultHandleNewDocumentClick$default = FabManager.handleNewDocumentClick$default(this.environment.getFabManager(), state.getCurrentFolder(), ((Action.CreateNewDocumentClicked) action).getActivity(), false, 4, null);
            if (Intrinsics.areEqual(fabMenuOptionResultHandleNewDocumentClick$default, FabMenuOptionResult.PermissionDenied.INSTANCE)) {
                return new ReducerResult<>(state, null, 2, null);
            }
            if (!Intrinsics.areEqual(fabMenuOptionResultHandleNewDocumentClick$default, FabMenuOptionResult.Success.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            return new ReducerResult<>(State.copy$default(state, null, false, false, null, false, false, false, CreateNewDocumentMenuState.copy$default(state.getCreateNewDocumentMenuState(), true, null, 2, null), null, 383, null), null, 2, null);
        }
        if (action instanceof Action.CreateNewBoxNoteClicked) {
            this.environment.getFabManager().handleNewBoxNoteClick(new NewNoteLocation.Folder(state.getCurrentFolder()), PreviewSource.Browse.INSTANCE, ((Action.CreateNewBoxNoteClicked) action).getActivity());
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof Action.UploadContentClicked) {
            FabMenuUploadContentOptionResult fabMenuUploadContentOptionResultHandleUploadContentClicked = this.environment.getFabManager().handleUploadContentClicked(state.getCurrentFolder(), ((Action.UploadContentClicked) action).getActivity());
            if (Intrinsics.areEqual(fabMenuUploadContentOptionResultHandleUploadContentClicked, FabMenuUploadContentOptionResult.MAMBlocked.INSTANCE) || Intrinsics.areEqual(fabMenuUploadContentOptionResultHandleUploadContentClicked, FabMenuUploadContentOptionResult.PermissionDenied.INSTANCE)) {
                stateCopy$default = state;
            } else if (Intrinsics.areEqual(fabMenuUploadContentOptionResultHandleUploadContentClicked, FabMenuUploadContentOptionResult.StorageAccessNeeded.INSTANCE)) {
                stateCopy$default = State.copy$default(state, null, false, false, null, false, false, true, null, null, 447, null);
            } else {
                if (!Intrinsics.areEqual(fabMenuUploadContentOptionResultHandleUploadContentClicked, FabMenuUploadContentOptionResult.Success.INSTANCE)) {
                    throw new NoWhenBranchMatchedException();
                }
                stateCopy$default = State.copy$default(state, null, false, false, null, false, true, false, null, null, 479, null);
            }
            return new ReducerResult<>(stateCopy$default, null, 2, null);
        }
        if (action instanceof Action.CaptureMediaClicked) {
            return new ReducerResult<>(this.environment.getFabManager().handleCaptureMediaClicked(state.getCurrentFolder(), ((Action.CaptureMediaClicked) action).getActivity()) instanceof FabMenuCaptureMediaOptionResult.StorageAccessNeeded ? State.copy$default(state, null, false, false, null, false, false, true, null, null, 447, null) : state, null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.CreateNewFolder.INSTANCE)) {
            return new ReducerResult<>(state, null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.CreateNewDocumentMenuDismissed.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, null, false, false, null, false, false, false, CreateNewDocumentMenuState.copy$default(state.getCreateNewDocumentMenuState(), false, null, 2, null), null, 383, null), null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.StorageAccessDialogDismissed.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, null, false, false, null, false, false, false, null, null, 447, null), null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.StorageAccessDialogPositiveClicked.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, null, false, false, null, false, false, false, null, ViewEffect.RequestStorageAccess.INSTANCE, 191, null), null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.StorageAccessGranted.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, null, false, false, null, false, false, false, null, ViewEffect.StorageAccessGrantedMessage.INSTANCE, 255, null), null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.StorageAccessDenied.INSTANCE)) {
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof Action.UploadTypeSelected) {
            if (!Connectivity.isConnected()) {
                return new ReducerResult<>(State.copy$default(state, null, false, false, null, false, false, false, null, ViewEffect.NoConnectivityErrorMessage.INSTANCE, 223, null), null, 2, null);
            }
            return new ReducerResult<>(State.copy$default(state, null, false, false, null, false, false, false, null, toLaunchPickerEffect(((Action.UploadTypeSelected) action).getType()), 223, null), null, 2, null);
        }
        if (action instanceof Action.UploadDataSelected) {
            return new ReducerResult<>(State.copy$default(state, null, false, false, null, false, false, false, null, null, 479, null), Effect.INSTANCE.fireAndForget(new AnonymousClass3(state, action, null)));
        }
        if (Intrinsics.areEqual(action, Action.UploadContentMenuViewed.INSTANCE)) {
            return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass4(null)));
        }
        if (action instanceof Action.UploadSelectionDismissed) {
            if (((Action.UploadSelectionDismissed) action).getFlowWasCancelled()) {
                UploadAnalyticsUtils.logUploadFlowCancelCtaEvent("os");
            }
            return new ReducerResult<>(State.copy$default(state, null, false, false, null, false, false, false, null, null, 479, null), null, 2, null);
        }
        if (action instanceof Action.ChangeFabVisibility) {
            return new ReducerResult<>(State.copy$default(state, null, false, ((Action.ChangeFabVisibility) action).isVisible(), null, false, false, false, null, null, 507, null), null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.OnViewEffectProcessed.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, null, false, false, null, false, false, false, null, ViewEffect.None.INSTANCE, 255, null), null, 2, null);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.browse.fab.FilesFabReducer$reduce$1, reason: invalid class name */
    /* JADX INFO: compiled from: FilesFabReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.browse.fab.FilesFabReducer$reduce$1", f = "FilesFabReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return FilesFabReducer.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            FilesFabReducer.this.getEnvironment().getAnalytics().fabClicked();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.browse.fab.FilesFabReducer$reduce$2, reason: invalid class name */
    /* JADX INFO: compiled from: FilesFabReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.browse.fab.FilesFabReducer$reduce$2", f = "FilesFabReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return FilesFabReducer.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            FilesFabReducer.this.getEnvironment().getAnalytics().fabContentViewed();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.browse.fab.FilesFabReducer$reduce$3, reason: invalid class name */
    /* JADX INFO: compiled from: FilesFabReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.browse.fab.FilesFabReducer$reduce$3", f = "FilesFabReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Action $action;
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(State state, Action action, Continuation<? super AnonymousClass3> continuation) {
            super(1, continuation);
            this.$state = state;
            this.$action = action;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return FilesFabReducer.this.new AnonymousClass3(this.$state, this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            FilesFabReducer.this.getEnvironment().getUploadHelper().doUpload(this.$state.getCurrentFolder(), ((Action.UploadDataSelected) this.$action).getData(), FilesFabReducer.this.toJobSource(((Action.UploadDataSelected) this.$action).getType()), ((Action.UploadDataSelected) this.$action).getActivity());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.browse.fab.FilesFabReducer$reduce$4, reason: invalid class name */
    /* JADX INFO: compiled from: FilesFabReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.browse.fab.FilesFabReducer$reduce$4", f = "FilesFabReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return FilesFabReducer.this.new AnonymousClass4(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            FilesFabReducer.this.getEnvironment().getAnalytics().uploadContentMenuViewed();
            return Unit.INSTANCE;
        }
    }

    private final ReducerResult<State, Action> initializeFab(State state, FolderModel folder) {
        List listMutableListOf = CollectionsKt.mutableListOf(FabMenuOption.NEW_FOLDER, FabMenuOption.UPLOAD_CONTENT, FabMenuOption.CAPTURE_MEDIA);
        BoxUser userInfo = this.environment.getUserContextManager().getUserInfo();
        if (userInfo != null && userInfo.isBoxNoteCreationEnabled()) {
            listMutableListOf.add(FabMenuOption.NEW_BOX_NOTE);
        }
        List<NewFileType> availableCreateNewFileOptions = this.environment.getNewFileMenuUtils().getAvailableCreateNewFileOptions();
        if (!availableCreateNewFileOptions.isEmpty()) {
            listMutableListOf.add(1, FabMenuOption.NEW_DOCUMENT);
        }
        return new ReducerResult<>(State.copy$default(state, folder, true, false, listMutableListOf, false, false, false, new CreateNewDocumentMenuState(false, availableCreateNewFileOptions), null, 372, null), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JobTags.JobSource toJobSource(UploadType uploadType) {
        int i = WhenMappings.$EnumSwitchMapping$0[uploadType.ordinal()];
        if (i == 1) {
            return JobTags.JobSource.FAB_FILE;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return JobTags.JobSource.FAB_FOLDER;
    }

    private final ViewEffect toLaunchPickerEffect(UploadType uploadType) {
        int i = WhenMappings.$EnumSwitchMapping$0[uploadType.ordinal()];
        if (i == 1) {
            return ViewEffect.LaunchFilePicker.INSTANCE;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return ViewEffect.LaunchFolderPicker.INSTANCE;
    }
}

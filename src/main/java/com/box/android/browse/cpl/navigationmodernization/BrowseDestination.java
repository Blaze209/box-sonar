package com.box.android.browse.cpl.navigationmodernization;

import com.box.android.activities.addcontent.CreateDocumentTaskActivity;
import com.box.android.base.presentation.fragments.models.BottomSheetAttributes;
import com.box.android.browse.cpl.browse.BrowseReducer;
import com.box.android.browse.cpl.itemsList.BottomSheetItemAction;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.RecentFileModel;
import com.box.android.domain.models.item.WebLinkModel;
import com.box.android.domain.models.preview.PreviewSource;
import com.facebook.react.modules.dialog.AlertFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BrowseDestination.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00062\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination;", "", "<init>", "()V", "InnerDestination", "OuterDestination", "Companion", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$InnerDestination;", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class BrowseDestination {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ BrowseDestination(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private BrowseDestination() {
    }

    /* JADX INFO: compiled from: BrowseDestination.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$InnerDestination;", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination;", "<init>", "()V", com.swmansion.rnscreens.gamma.tabs.screen.TabsScreen.TAG, "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$InnerDestination$TabsScreen;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class InnerDestination extends BrowseDestination {
        public static final int $stable = 0;

        public /* synthetic */ InnerDestination(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: BrowseDestination.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0017B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$InnerDestination$TabsScreen;", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$InnerDestination;", "tabs", "", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$InnerDestination$TabsScreen$BrowseTab;", "startTab", "<init>", "(Ljava/util/List;Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$InnerDestination$TabsScreen$BrowseTab;)V", "getTabs", "()Ljava/util/List;", "getStartTab", "()Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$InnerDestination$TabsScreen$BrowseTab;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "BrowseTab", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class TabsScreen extends InnerDestination {
            public static final int $stable = 8;
            private final BrowseTab startTab;
            private final List<BrowseTab> tabs;

            /* JADX INFO: compiled from: BrowseDestination.kt */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$InnerDestination$TabsScreen$BrowseTab;", "", "<init>", "(Ljava/lang/String;I)V", "AllFilesTab", "RecentsTab", "OfflinedTab", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public enum BrowseTab {
                AllFilesTab,
                RecentsTab,
                OfflinedTab;

                private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

                public static EnumEntries<BrowseTab> getEntries() {
                    return $ENTRIES;
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ TabsScreen copy$default(TabsScreen tabsScreen, List list, BrowseTab browseTab, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = tabsScreen.tabs;
                }
                if ((i & 2) != 0) {
                    browseTab = tabsScreen.startTab;
                }
                return tabsScreen.copy(list, browseTab);
            }

            public final List<BrowseTab> component1() {
                return this.tabs;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final BrowseTab getStartTab() {
                return this.startTab;
            }

            public final TabsScreen copy(List<? extends BrowseTab> tabs, BrowseTab startTab) {
                Intrinsics.checkNotNullParameter(tabs, "tabs");
                Intrinsics.checkNotNullParameter(startTab, "startTab");
                return new TabsScreen(tabs, startTab);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof TabsScreen)) {
                    return false;
                }
                TabsScreen tabsScreen = (TabsScreen) other;
                return Intrinsics.areEqual(this.tabs, tabsScreen.tabs) && this.startTab == tabsScreen.startTab;
            }

            public int hashCode() {
                return (this.tabs.hashCode() * 31) + this.startTab.hashCode();
            }

            public String toString() {
                return "TabsScreen(tabs=" + this.tabs + ", startTab=" + this.startTab + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public TabsScreen(List<? extends BrowseTab> tabs, BrowseTab startTab) {
                super(null);
                Intrinsics.checkNotNullParameter(tabs, "tabs");
                Intrinsics.checkNotNullParameter(startTab, "startTab");
                this.tabs = tabs;
                this.startTab = startTab;
            }

            public final BrowseTab getStartTab() {
                return this.startTab;
            }

            public final List<BrowseTab> getTabs() {
                return this.tabs;
            }
        }

        private InnerDestination() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: BrowseDestination.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\n\u0004\u0005\u0006\u0007\b\t\n\u000b\f\rB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\n\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination;", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination;", "<init>", "()V", "Folder", "File", "WebLink", "RecentFile", "FeatureBanner", "InviteCollaborators", "CreateNewDocument", "ItemMoreActionsMenu", "ItemsBatchActionFlow", "PlayStoreBoxPage", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination$CreateNewDocument;", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination$FeatureBanner;", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination$File;", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination$Folder;", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination$InviteCollaborators;", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination$ItemMoreActionsMenu;", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination$ItemsBatchActionFlow;", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination$PlayStoreBoxPage;", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination$RecentFile;", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination$WebLink;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class OuterDestination extends BrowseDestination {
        public static final int $stable = 0;

        public /* synthetic */ OuterDestination(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: BrowseDestination.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination$Folder;", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination;", "folderModel", "Lcom/box/android/domain/models/item/FolderModel;", "<init>", "(Lcom/box/android/domain/models/item/FolderModel;)V", "getFolderModel", "()Lcom/box/android/domain/models/item/FolderModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Folder extends OuterDestination {
            public static final int $stable = 8;
            private final FolderModel folderModel;

            public static /* synthetic */ Folder copy$default(Folder folder, FolderModel folderModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    folderModel = folder.folderModel;
                }
                return folder.copy(folderModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FolderModel getFolderModel() {
                return this.folderModel;
            }

            public final Folder copy(FolderModel folderModel) {
                Intrinsics.checkNotNullParameter(folderModel, "folderModel");
                return new Folder(folderModel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Folder) && Intrinsics.areEqual(this.folderModel, ((Folder) other).folderModel);
            }

            public int hashCode() {
                return this.folderModel.hashCode();
            }

            public String toString() {
                return "Folder(folderModel=" + this.folderModel + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Folder(FolderModel folderModel) {
                super(null);
                Intrinsics.checkNotNullParameter(folderModel, "folderModel");
                this.folderModel = folderModel;
            }

            public final FolderModel getFolderModel() {
                return this.folderModel;
            }
        }

        private OuterDestination() {
            super(null);
        }

        /* JADX INFO: compiled from: BrowseDestination.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination$File;", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "previewSource", "Lcom/box/android/domain/models/preview/PreviewSource;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;Lcom/box/android/domain/models/preview/PreviewSource;)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "getPreviewSource", "()Lcom/box/android/domain/models/preview/PreviewSource;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class File extends OuterDestination {
            public static final int $stable = 8;
            private final FileModel fileModel;
            private final PreviewSource previewSource;

            public static /* synthetic */ File copy$default(File file, FileModel fileModel, PreviewSource previewSource, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileModel = file.fileModel;
                }
                if ((i & 2) != 0) {
                    previewSource = file.previewSource;
                }
                return file.copy(fileModel, previewSource);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FileModel getFileModel() {
                return this.fileModel;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final PreviewSource getPreviewSource() {
                return this.previewSource;
            }

            public final File copy(FileModel fileModel, PreviewSource previewSource) {
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                Intrinsics.checkNotNullParameter(previewSource, "previewSource");
                return new File(fileModel, previewSource);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof File)) {
                    return false;
                }
                File file = (File) other;
                return Intrinsics.areEqual(this.fileModel, file.fileModel) && Intrinsics.areEqual(this.previewSource, file.previewSource);
            }

            public int hashCode() {
                return (this.fileModel.hashCode() * 31) + this.previewSource.hashCode();
            }

            public String toString() {
                return "File(fileModel=" + this.fileModel + ", previewSource=" + this.previewSource + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public File(FileModel fileModel, PreviewSource previewSource) {
                super(null);
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                Intrinsics.checkNotNullParameter(previewSource, "previewSource");
                this.fileModel = fileModel;
                this.previewSource = previewSource;
            }

            public final FileModel getFileModel() {
                return this.fileModel;
            }

            public final PreviewSource getPreviewSource() {
                return this.previewSource;
            }
        }

        /* JADX INFO: compiled from: BrowseDestination.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination$WebLink;", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination;", "webLinkModel", "Lcom/box/android/domain/models/item/WebLinkModel;", "<init>", "(Lcom/box/android/domain/models/item/WebLinkModel;)V", "getWebLinkModel", "()Lcom/box/android/domain/models/item/WebLinkModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class WebLink extends OuterDestination {
            public static final int $stable = 8;
            private final WebLinkModel webLinkModel;

            public static /* synthetic */ WebLink copy$default(WebLink webLink, WebLinkModel webLinkModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    webLinkModel = webLink.webLinkModel;
                }
                return webLink.copy(webLinkModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final WebLinkModel getWebLinkModel() {
                return this.webLinkModel;
            }

            public final WebLink copy(WebLinkModel webLinkModel) {
                Intrinsics.checkNotNullParameter(webLinkModel, "webLinkModel");
                return new WebLink(webLinkModel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof WebLink) && Intrinsics.areEqual(this.webLinkModel, ((WebLink) other).webLinkModel);
            }

            public int hashCode() {
                return this.webLinkModel.hashCode();
            }

            public String toString() {
                return "WebLink(webLinkModel=" + this.webLinkModel + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public WebLink(WebLinkModel webLinkModel) {
                super(null);
                Intrinsics.checkNotNullParameter(webLinkModel, "webLinkModel");
                this.webLinkModel = webLinkModel;
            }

            public final WebLinkModel getWebLinkModel() {
                return this.webLinkModel;
            }
        }

        /* JADX INFO: compiled from: BrowseDestination.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination$RecentFile;", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination;", "recentFileModel", "Lcom/box/android/domain/models/item/RecentFileModel;", "<init>", "(Lcom/box/android/domain/models/item/RecentFileModel;)V", "getRecentFileModel", "()Lcom/box/android/domain/models/item/RecentFileModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RecentFile extends OuterDestination {
            public static final int $stable = 8;
            private final RecentFileModel recentFileModel;

            public static /* synthetic */ RecentFile copy$default(RecentFile recentFile, RecentFileModel recentFileModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    recentFileModel = recentFile.recentFileModel;
                }
                return recentFile.copy(recentFileModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final RecentFileModel getRecentFileModel() {
                return this.recentFileModel;
            }

            public final RecentFile copy(RecentFileModel recentFileModel) {
                Intrinsics.checkNotNullParameter(recentFileModel, "recentFileModel");
                return new RecentFile(recentFileModel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof RecentFile) && Intrinsics.areEqual(this.recentFileModel, ((RecentFile) other).recentFileModel);
            }

            public int hashCode() {
                return this.recentFileModel.hashCode();
            }

            public String toString() {
                return "RecentFile(recentFileModel=" + this.recentFileModel + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RecentFile(RecentFileModel recentFileModel) {
                super(null);
                Intrinsics.checkNotNullParameter(recentFileModel, "recentFileModel");
                this.recentFileModel = recentFileModel;
            }

            public final RecentFileModel getRecentFileModel() {
                return this.recentFileModel;
            }
        }

        /* JADX INFO: compiled from: BrowseDestination.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination$FeatureBanner;", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination;", "data", "Lcom/box/android/browse/cpl/browse/BrowseReducer$FeatureBannerActionData;", "<init>", "(Lcom/box/android/browse/cpl/browse/BrowseReducer$FeatureBannerActionData;)V", "getData", "()Lcom/box/android/browse/cpl/browse/BrowseReducer$FeatureBannerActionData;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FeatureBanner extends OuterDestination {
            public static final int $stable = 0;
            private final BrowseReducer.FeatureBannerActionData data;

            public static /* synthetic */ FeatureBanner copy$default(FeatureBanner featureBanner, BrowseReducer.FeatureBannerActionData featureBannerActionData, int i, Object obj) {
                if ((i & 1) != 0) {
                    featureBannerActionData = featureBanner.data;
                }
                return featureBanner.copy(featureBannerActionData);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BrowseReducer.FeatureBannerActionData getData() {
                return this.data;
            }

            public final FeatureBanner copy(BrowseReducer.FeatureBannerActionData data) {
                Intrinsics.checkNotNullParameter(data, "data");
                return new FeatureBanner(data);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FeatureBanner) && Intrinsics.areEqual(this.data, ((FeatureBanner) other).data);
            }

            public int hashCode() {
                return this.data.hashCode();
            }

            public String toString() {
                return "FeatureBanner(data=" + this.data + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FeatureBanner(BrowseReducer.FeatureBannerActionData data) {
                super(null);
                Intrinsics.checkNotNullParameter(data, "data");
                this.data = data;
            }

            public final BrowseReducer.FeatureBannerActionData getData() {
                return this.data;
            }
        }

        /* JADX INFO: compiled from: BrowseDestination.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination$InviteCollaborators;", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination;", "folderModel", "Lcom/box/android/domain/models/item/FolderModel;", "<init>", "(Lcom/box/android/domain/models/item/FolderModel;)V", "getFolderModel", "()Lcom/box/android/domain/models/item/FolderModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class InviteCollaborators extends OuterDestination {
            public static final int $stable = 8;
            private final FolderModel folderModel;

            public static /* synthetic */ InviteCollaborators copy$default(InviteCollaborators inviteCollaborators, FolderModel folderModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    folderModel = inviteCollaborators.folderModel;
                }
                return inviteCollaborators.copy(folderModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FolderModel getFolderModel() {
                return this.folderModel;
            }

            public final InviteCollaborators copy(FolderModel folderModel) {
                Intrinsics.checkNotNullParameter(folderModel, "folderModel");
                return new InviteCollaborators(folderModel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof InviteCollaborators) && Intrinsics.areEqual(this.folderModel, ((InviteCollaborators) other).folderModel);
            }

            public int hashCode() {
                return this.folderModel.hashCode();
            }

            public String toString() {
                return "InviteCollaborators(folderModel=" + this.folderModel + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public InviteCollaborators(FolderModel folderModel) {
                super(null);
                Intrinsics.checkNotNullParameter(folderModel, "folderModel");
                this.folderModel = folderModel;
            }

            public final FolderModel getFolderModel() {
                return this.folderModel;
            }
        }

        /* JADX INFO: compiled from: BrowseDestination.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination$CreateNewDocument;", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination;", "folderModel", "Lcom/box/android/domain/models/item/FolderModel;", CreateDocumentTaskActivity.EXTRA_ASSET_NAME, "", "<init>", "(Lcom/box/android/domain/models/item/FolderModel;Ljava/lang/String;)V", "getFolderModel", "()Lcom/box/android/domain/models/item/FolderModel;", "getAssetName", "()Ljava/lang/String;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CreateNewDocument extends OuterDestination {
            public static final int $stable = 8;
            private final String assetName;
            private final FolderModel folderModel;

            public static /* synthetic */ CreateNewDocument copy$default(CreateNewDocument createNewDocument, FolderModel folderModel, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    folderModel = createNewDocument.folderModel;
                }
                if ((i & 2) != 0) {
                    str = createNewDocument.assetName;
                }
                return createNewDocument.copy(folderModel, str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FolderModel getFolderModel() {
                return this.folderModel;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getAssetName() {
                return this.assetName;
            }

            public final CreateNewDocument copy(FolderModel folderModel, String assetName) {
                Intrinsics.checkNotNullParameter(folderModel, "folderModel");
                Intrinsics.checkNotNullParameter(assetName, "assetName");
                return new CreateNewDocument(folderModel, assetName);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CreateNewDocument)) {
                    return false;
                }
                CreateNewDocument createNewDocument = (CreateNewDocument) other;
                return Intrinsics.areEqual(this.folderModel, createNewDocument.folderModel) && Intrinsics.areEqual(this.assetName, createNewDocument.assetName);
            }

            public int hashCode() {
                return (this.folderModel.hashCode() * 31) + this.assetName.hashCode();
            }

            public String toString() {
                return "CreateNewDocument(folderModel=" + this.folderModel + ", assetName=" + this.assetName + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CreateNewDocument(FolderModel folderModel, String assetName) {
                super(null);
                Intrinsics.checkNotNullParameter(folderModel, "folderModel");
                Intrinsics.checkNotNullParameter(assetName, "assetName");
                this.folderModel = folderModel;
                this.assetName = assetName;
            }

            public final String getAssetName() {
                return this.assetName;
            }

            public final FolderModel getFolderModel() {
                return this.folderModel;
            }
        }

        /* JADX INFO: compiled from: BrowseDestination.kt */
        @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012:\b\u0002\u0010\u000b\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u0011\u0018\u00010\f¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J;\u0010\"\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u0011\u0018\u00010\fHÆ\u0003Js\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2:\b\u0002\u0010\u000b\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u0011\u0018\u00010\fHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\rHÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bRC\u0010\u000b\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u0011\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006+"}, d2 = {"Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination$ItemMoreActionsMenu;", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination;", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "bottomSheetMenuType", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuType;", "launchContext", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$LaunchContext;", "availableActions", "", "Lcom/box/android/browse/cpl/itemsList/BottomSheetItemAction;", "onBottomSheetAction", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "menuItemId", "", "<init>", "(Lcom/box/android/domain/models/item/ItemModel;Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuType;Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$LaunchContext;Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "getItemModel", "()Lcom/box/android/domain/models/item/ItemModel;", "getBottomSheetMenuType", "()Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuType;", "getLaunchContext", "()Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$LaunchContext;", "getAvailableActions", "()Ljava/util/List;", "getOnBottomSheetAction", "()Lkotlin/jvm/functions/Function2;", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ItemMoreActionsMenu extends OuterDestination {
            public static final int $stable = 8;
            private final List<BottomSheetItemAction> availableActions;
            private final BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType;
            private final ItemModel itemModel;
            private final BottomSheetAttributes.LaunchContext launchContext;
            private final Function2<Integer, ItemModel, Unit> onBottomSheetAction;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ItemMoreActionsMenu copy$default(ItemMoreActionsMenu itemMoreActionsMenu, ItemModel itemModel, BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType, BottomSheetAttributes.LaunchContext launchContext, List list, Function2 function2, int i, Object obj) {
                if ((i & 1) != 0) {
                    itemModel = itemMoreActionsMenu.itemModel;
                }
                if ((i & 2) != 0) {
                    bottomSheetMenuType = itemMoreActionsMenu.bottomSheetMenuType;
                }
                if ((i & 4) != 0) {
                    launchContext = itemMoreActionsMenu.launchContext;
                }
                if ((i & 8) != 0) {
                    list = itemMoreActionsMenu.availableActions;
                }
                if ((i & 16) != 0) {
                    function2 = itemMoreActionsMenu.onBottomSheetAction;
                }
                Function2 function3 = function2;
                BottomSheetAttributes.LaunchContext launchContext2 = launchContext;
                return itemMoreActionsMenu.copy(itemModel, bottomSheetMenuType, launchContext2, list, function3);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemModel getItemModel() {
                return this.itemModel;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final BottomSheetAttributes.BottomSheetMenuType getBottomSheetMenuType() {
                return this.bottomSheetMenuType;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final BottomSheetAttributes.LaunchContext getLaunchContext() {
                return this.launchContext;
            }

            public final List<BottomSheetItemAction> component4() {
                return this.availableActions;
            }

            public final Function2<Integer, ItemModel, Unit> component5() {
                return this.onBottomSheetAction;
            }

            public final ItemMoreActionsMenu copy(ItemModel itemModel, BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType, BottomSheetAttributes.LaunchContext launchContext, List<? extends BottomSheetItemAction> availableActions, Function2<? super Integer, ? super ItemModel, Unit> onBottomSheetAction) {
                Intrinsics.checkNotNullParameter(itemModel, "itemModel");
                Intrinsics.checkNotNullParameter(bottomSheetMenuType, "bottomSheetMenuType");
                Intrinsics.checkNotNullParameter(launchContext, "launchContext");
                Intrinsics.checkNotNullParameter(availableActions, "availableActions");
                return new ItemMoreActionsMenu(itemModel, bottomSheetMenuType, launchContext, availableActions, onBottomSheetAction);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ItemMoreActionsMenu)) {
                    return false;
                }
                ItemMoreActionsMenu itemMoreActionsMenu = (ItemMoreActionsMenu) other;
                return Intrinsics.areEqual(this.itemModel, itemMoreActionsMenu.itemModel) && Intrinsics.areEqual(this.bottomSheetMenuType, itemMoreActionsMenu.bottomSheetMenuType) && Intrinsics.areEqual(this.launchContext, itemMoreActionsMenu.launchContext) && Intrinsics.areEqual(this.availableActions, itemMoreActionsMenu.availableActions) && Intrinsics.areEqual(this.onBottomSheetAction, itemMoreActionsMenu.onBottomSheetAction);
            }

            public int hashCode() {
                int iHashCode = ((((((this.itemModel.hashCode() * 31) + this.bottomSheetMenuType.hashCode()) * 31) + this.launchContext.hashCode()) * 31) + this.availableActions.hashCode()) * 31;
                Function2<Integer, ItemModel, Unit> function2 = this.onBottomSheetAction;
                return iHashCode + (function2 == null ? 0 : function2.hashCode());
            }

            public String toString() {
                return "ItemMoreActionsMenu(itemModel=" + this.itemModel + ", bottomSheetMenuType=" + this.bottomSheetMenuType + ", launchContext=" + this.launchContext + ", availableActions=" + this.availableActions + ", onBottomSheetAction=" + this.onBottomSheetAction + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public ItemMoreActionsMenu(ItemModel itemModel, BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType, BottomSheetAttributes.LaunchContext launchContext, List<? extends BottomSheetItemAction> availableActions, Function2<? super Integer, ? super ItemModel, Unit> function2) {
                super(null);
                Intrinsics.checkNotNullParameter(itemModel, "itemModel");
                Intrinsics.checkNotNullParameter(bottomSheetMenuType, "bottomSheetMenuType");
                Intrinsics.checkNotNullParameter(launchContext, "launchContext");
                Intrinsics.checkNotNullParameter(availableActions, "availableActions");
                this.itemModel = itemModel;
                this.bottomSheetMenuType = bottomSheetMenuType;
                this.launchContext = launchContext;
                this.availableActions = availableActions;
                this.onBottomSheetAction = function2;
            }

            public final ItemModel getItemModel() {
                return this.itemModel;
            }

            public final BottomSheetAttributes.BottomSheetMenuType getBottomSheetMenuType() {
                return this.bottomSheetMenuType;
            }

            public /* synthetic */ ItemMoreActionsMenu(ItemModel itemModel, BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType, BottomSheetAttributes.LaunchContext.Default r9, List list, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(itemModel, bottomSheetMenuType, (i & 4) != 0 ? BottomSheetAttributes.LaunchContext.Default.INSTANCE : r9, (i & 8) != 0 ? CollectionsKt.emptyList() : list, (i & 16) != 0 ? null : function2);
            }

            public final BottomSheetAttributes.LaunchContext getLaunchContext() {
                return this.launchContext;
            }

            public final List<BottomSheetItemAction> getAvailableActions() {
                return this.availableActions;
            }

            public final Function2<Integer, ItemModel, Unit> getOnBottomSheetAction() {
                return this.onBottomSheetAction;
            }
        }

        /* JADX INFO: compiled from: BrowseDestination.kt */
        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0018B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination$ItemsBatchActionFlow;", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination;", "batchAction", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination$ItemsBatchActionFlow$BatchAction;", AlertFragment.ARG_ITEMS, "", "Lcom/box/android/domain/models/item/ItemModel;", "<init>", "(Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination$ItemsBatchActionFlow$BatchAction;Ljava/util/List;)V", "getBatchAction", "()Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination$ItemsBatchActionFlow$BatchAction;", "getItems", "()Ljava/util/List;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "BatchAction", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ItemsBatchActionFlow extends OuterDestination {
            public static final int $stable = 8;
            private final BatchAction batchAction;
            private final List<ItemModel> items;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ItemsBatchActionFlow copy$default(ItemsBatchActionFlow itemsBatchActionFlow, BatchAction batchAction, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    batchAction = itemsBatchActionFlow.batchAction;
                }
                if ((i & 2) != 0) {
                    list = itemsBatchActionFlow.items;
                }
                return itemsBatchActionFlow.copy(batchAction, list);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BatchAction getBatchAction() {
                return this.batchAction;
            }

            public final List<ItemModel> component2() {
                return this.items;
            }

            public final ItemsBatchActionFlow copy(BatchAction batchAction, List<? extends ItemModel> items) {
                Intrinsics.checkNotNullParameter(batchAction, "batchAction");
                Intrinsics.checkNotNullParameter(items, "items");
                return new ItemsBatchActionFlow(batchAction, items);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ItemsBatchActionFlow)) {
                    return false;
                }
                ItemsBatchActionFlow itemsBatchActionFlow = (ItemsBatchActionFlow) other;
                return Intrinsics.areEqual(this.batchAction, itemsBatchActionFlow.batchAction) && Intrinsics.areEqual(this.items, itemsBatchActionFlow.items);
            }

            public int hashCode() {
                return (this.batchAction.hashCode() * 31) + this.items.hashCode();
            }

            public String toString() {
                return "ItemsBatchActionFlow(batchAction=" + this.batchAction + ", items=" + this.items + ")";
            }

            /* JADX INFO: compiled from: BrowseDestination.kt */
            @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination$ItemsBatchActionFlow$BatchAction;", "", "<init>", "()V", "CopyMove", "Delete", "Export", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination$ItemsBatchActionFlow$BatchAction$CopyMove;", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination$ItemsBatchActionFlow$BatchAction$Delete;", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination$ItemsBatchActionFlow$BatchAction$Export;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public static abstract class BatchAction {
                public static final int $stable = 0;

                public /* synthetic */ BatchAction(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                /* JADX INFO: compiled from: BrowseDestination.kt */
                @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination$ItemsBatchActionFlow$BatchAction$CopyMove;", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination$ItemsBatchActionFlow$BatchAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
                public static final /* data */ class CopyMove extends BatchAction {
                    public static final int $stable = 0;
                    public static final CopyMove INSTANCE = new CopyMove();

                    public boolean equals(Object other) {
                        if (this == other) {
                            return true;
                        }
                        if (!(other instanceof CopyMove)) {
                            return false;
                        }
                        return true;
                    }

                    public int hashCode() {
                        return -1332379772;
                    }

                    public String toString() {
                        return "CopyMove";
                    }

                    private CopyMove() {
                        super(null);
                    }
                }

                private BatchAction() {
                }

                /* JADX INFO: compiled from: BrowseDestination.kt */
                @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination$ItemsBatchActionFlow$BatchAction$Delete;", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination$ItemsBatchActionFlow$BatchAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
                public static final /* data */ class Delete extends BatchAction {
                    public static final int $stable = 0;
                    public static final Delete INSTANCE = new Delete();

                    public boolean equals(Object other) {
                        if (this == other) {
                            return true;
                        }
                        if (!(other instanceof Delete)) {
                            return false;
                        }
                        return true;
                    }

                    public int hashCode() {
                        return -1197770807;
                    }

                    public String toString() {
                        return "Delete";
                    }

                    private Delete() {
                        super(null);
                    }
                }

                /* JADX INFO: compiled from: BrowseDestination.kt */
                @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001R\u001f\u0010\u0002\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination$ItemsBatchActionFlow$BatchAction$Export;", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination$ItemsBatchActionFlow$BatchAction;", "onExportFolderSelected", "Lkotlin/Function1;", "", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getOnExportFolderSelected", "()Lkotlin/jvm/functions/Function1;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
                public static final /* data */ class Export extends BatchAction {
                    public static final int $stable = 0;
                    private final Function1<String, Unit> onExportFolderSelected;

                    /* JADX WARN: Multi-variable type inference failed */
                    public static /* synthetic */ Export copy$default(Export export, Function1 function1, int i, Object obj) {
                        if ((i & 1) != 0) {
                            function1 = export.onExportFolderSelected;
                        }
                        return export.copy(function1);
                    }

                    public final Function1<String, Unit> component1() {
                        return this.onExportFolderSelected;
                    }

                    public final Export copy(Function1<? super String, Unit> onExportFolderSelected) {
                        Intrinsics.checkNotNullParameter(onExportFolderSelected, "onExportFolderSelected");
                        return new Export(onExportFolderSelected);
                    }

                    public boolean equals(Object other) {
                        if (this == other) {
                            return true;
                        }
                        return (other instanceof Export) && Intrinsics.areEqual(this.onExportFolderSelected, ((Export) other).onExportFolderSelected);
                    }

                    public int hashCode() {
                        return this.onExportFolderSelected.hashCode();
                    }

                    public String toString() {
                        return "Export(onExportFolderSelected=" + this.onExportFolderSelected + ")";
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    public Export(Function1<? super String, Unit> onExportFolderSelected) {
                        super(null);
                        Intrinsics.checkNotNullParameter(onExportFolderSelected, "onExportFolderSelected");
                        this.onExportFolderSelected = onExportFolderSelected;
                    }

                    public final Function1<String, Unit> getOnExportFolderSelected() {
                        return this.onExportFolderSelected;
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public ItemsBatchActionFlow(BatchAction batchAction, List<? extends ItemModel> items) {
                super(null);
                Intrinsics.checkNotNullParameter(batchAction, "batchAction");
                Intrinsics.checkNotNullParameter(items, "items");
                this.batchAction = batchAction;
                this.items = items;
            }

            public final BatchAction getBatchAction() {
                return this.batchAction;
            }

            public final List<ItemModel> getItems() {
                return this.items;
            }
        }

        /* JADX INFO: compiled from: BrowseDestination.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination$PlayStoreBoxPage;", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$OuterDestination;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PlayStoreBoxPage extends OuterDestination {
            public static final int $stable = 0;
            public static final PlayStoreBoxPage INSTANCE = new PlayStoreBoxPage();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PlayStoreBoxPage)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -2145796515;
            }

            public String toString() {
                return "PlayStoreBoxPage";
            }

            private PlayStoreBoxPage() {
                super(null);
            }
        }
    }

    /* JADX INFO: compiled from: BrowseDestination.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/browse/cpl/navigationmodernization/BrowseDestination$Companion;", "", "<init>", "()V", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

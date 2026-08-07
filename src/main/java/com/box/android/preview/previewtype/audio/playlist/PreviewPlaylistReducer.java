package com.box.android.preview.previewtype.audio.playlist;

import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.domain.services.AudioItem;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.facebook.react.modules.dialog.AlertFragment;
import com.pspdfkit.analytics.Analytics;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: PreviewPlaylistReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\u0010\u0011\u0012\u0013B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0003H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$State;", "Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$Action;", "environment", "Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistEnvironment;", "<init>", "(Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistEnvironment;)V", "build", "Lcom/box/android/cpl/Reduce;", "getBuild", "()Lcom/box/android/cpl/Reduce;", "reducePlaylist", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "Close", "State", "ActivePlaylistItem", "Action", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviewPlaylistReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reduce<State, Action> build;
    private final PreviewPlaylistEnvironment environment;

    public PreviewPlaylistReducer(PreviewPlaylistEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        this.build = new Reduce<>(new PreviewPlaylistReducer$build$1(this));
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: PreviewPlaylistReducer.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$Close;", "", "itemModel", "Lcom/box/android/domain/models/item/FileModel;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;)V", "getItemModel", "()Lcom/box/android/domain/models/item/FileModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Close {
        public static final int $stable = 8;
        private final FileModel itemModel;

        /* JADX WARN: Multi-variable type inference failed */
        public Close() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Close copy$default(Close close, FileModel fileModel, int i, Object obj) {
            if ((i & 1) != 0) {
                fileModel = close.itemModel;
            }
            return close.copy(fileModel);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FileModel getItemModel() {
            return this.itemModel;
        }

        public final Close copy(FileModel itemModel) {
            return new Close(itemModel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Close) && Intrinsics.areEqual(this.itemModel, ((Close) other).itemModel);
        }

        public int hashCode() {
            FileModel fileModel = this.itemModel;
            if (fileModel == null) {
                return 0;
            }
            return fileModel.hashCode();
        }

        public String toString() {
            return "Close(itemModel=" + this.itemModel + ")";
        }

        public Close(FileModel fileModel) {
            this.itemModel = fileModel;
        }

        public /* synthetic */ Close(FileModel fileModel, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : fileModel);
        }

        public final FileModel getItemModel() {
            return this.itemModel;
        }
    }

    /* JADX INFO: compiled from: PreviewPlaylistReducer.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\fHÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$State;", "", "initialFileModel", "Lcom/box/android/domain/models/item/FileModel;", "previewSource", "Lcom/box/android/domain/models/preview/PreviewSource;", "activeItem", "Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$ActivePlaylistItem;", AlertFragment.ARG_ITEMS, "", "Lcom/box/android/domain/services/AudioItem;", "closeRoute", "Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$Close;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;Lcom/box/android/domain/models/preview/PreviewSource;Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$ActivePlaylistItem;Ljava/util/List;Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$Close;)V", "getInitialFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "getPreviewSource", "()Lcom/box/android/domain/models/preview/PreviewSource;", "getActiveItem", "()Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$ActivePlaylistItem;", "getItems", "()Ljava/util/List;", "getCloseRoute", "()Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$Close;", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final ActivePlaylistItem activeItem;
        private final Close closeRoute;
        private final FileModel initialFileModel;
        private final List<AudioItem> items;
        private final PreviewSource previewSource;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, FileModel fileModel, PreviewSource previewSource, ActivePlaylistItem activePlaylistItem, List list, Close close, int i, Object obj) {
            if ((i & 1) != 0) {
                fileModel = state.initialFileModel;
            }
            if ((i & 2) != 0) {
                previewSource = state.previewSource;
            }
            if ((i & 4) != 0) {
                activePlaylistItem = state.activeItem;
            }
            if ((i & 8) != 0) {
                list = state.items;
            }
            if ((i & 16) != 0) {
                close = state.closeRoute;
            }
            Close close2 = close;
            ActivePlaylistItem activePlaylistItem2 = activePlaylistItem;
            return state.copy(fileModel, previewSource, activePlaylistItem2, list, close2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FileModel getInitialFileModel() {
            return this.initialFileModel;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final PreviewSource getPreviewSource() {
            return this.previewSource;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final ActivePlaylistItem getActiveItem() {
            return this.activeItem;
        }

        public final List<AudioItem> component4() {
            return this.items;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Close getCloseRoute() {
            return this.closeRoute;
        }

        public final State copy(FileModel initialFileModel, PreviewSource previewSource, ActivePlaylistItem activeItem, List<? extends AudioItem> items, Close closeRoute) {
            Intrinsics.checkNotNullParameter(initialFileModel, "initialFileModel");
            Intrinsics.checkNotNullParameter(previewSource, "previewSource");
            Intrinsics.checkNotNullParameter(items, "items");
            return new State(initialFileModel, previewSource, activeItem, items, closeRoute);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.initialFileModel, state.initialFileModel) && Intrinsics.areEqual(this.previewSource, state.previewSource) && Intrinsics.areEqual(this.activeItem, state.activeItem) && Intrinsics.areEqual(this.items, state.items) && Intrinsics.areEqual(this.closeRoute, state.closeRoute);
        }

        public int hashCode() {
            int iHashCode = ((this.initialFileModel.hashCode() * 31) + this.previewSource.hashCode()) * 31;
            ActivePlaylistItem activePlaylistItem = this.activeItem;
            int iHashCode2 = (((iHashCode + (activePlaylistItem == null ? 0 : activePlaylistItem.hashCode())) * 31) + this.items.hashCode()) * 31;
            Close close = this.closeRoute;
            return iHashCode2 + (close != null ? close.hashCode() : 0);
        }

        public String toString() {
            return "State(initialFileModel=" + this.initialFileModel + ", previewSource=" + this.previewSource + ", activeItem=" + this.activeItem + ", items=" + this.items + ", closeRoute=" + this.closeRoute + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public State(FileModel initialFileModel, PreviewSource previewSource, ActivePlaylistItem activePlaylistItem, List<? extends AudioItem> items, Close close) {
            Intrinsics.checkNotNullParameter(initialFileModel, "initialFileModel");
            Intrinsics.checkNotNullParameter(previewSource, "previewSource");
            Intrinsics.checkNotNullParameter(items, "items");
            this.initialFileModel = initialFileModel;
            this.previewSource = previewSource;
            this.activeItem = activePlaylistItem;
            this.items = items;
            this.closeRoute = close;
        }

        public final FileModel getInitialFileModel() {
            return this.initialFileModel;
        }

        public final PreviewSource getPreviewSource() {
            return this.previewSource;
        }

        public final ActivePlaylistItem getActiveItem() {
            return this.activeItem;
        }

        public /* synthetic */ State(FileModel fileModel, PreviewSource previewSource, ActivePlaylistItem activePlaylistItem, List list, Close close, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(fileModel, previewSource, (i & 4) != 0 ? null : activePlaylistItem, (i & 8) != 0 ? CollectionsKt.emptyList() : list, (i & 16) != 0 ? null : close);
        }

        public final List<AudioItem> getItems() {
            return this.items;
        }

        public final Close getCloseRoute() {
            return this.closeRoute;
        }
    }

    /* JADX INFO: compiled from: PreviewPlaylistReducer.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$ActivePlaylistItem;", "", "item", "Lcom/box/android/domain/services/AudioItem;", "isPlaying", "", "<init>", "(Lcom/box/android/domain/services/AudioItem;Z)V", "getItem", "()Lcom/box/android/domain/services/AudioItem;", "()Z", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ActivePlaylistItem {
        public static final int $stable = 8;
        private final boolean isPlaying;
        private final AudioItem item;

        public static /* synthetic */ ActivePlaylistItem copy$default(ActivePlaylistItem activePlaylistItem, AudioItem audioItem, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                audioItem = activePlaylistItem.item;
            }
            if ((i & 2) != 0) {
                z = activePlaylistItem.isPlaying;
            }
            return activePlaylistItem.copy(audioItem, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final AudioItem getItem() {
            return this.item;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsPlaying() {
            return this.isPlaying;
        }

        public final ActivePlaylistItem copy(AudioItem item, boolean isPlaying) {
            Intrinsics.checkNotNullParameter(item, "item");
            return new ActivePlaylistItem(item, isPlaying);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ActivePlaylistItem)) {
                return false;
            }
            ActivePlaylistItem activePlaylistItem = (ActivePlaylistItem) other;
            return Intrinsics.areEqual(this.item, activePlaylistItem.item) && this.isPlaying == activePlaylistItem.isPlaying;
        }

        public int hashCode() {
            return (this.item.hashCode() * 31) + Boolean.hashCode(this.isPlaying);
        }

        public String toString() {
            return "ActivePlaylistItem(item=" + this.item + ", isPlaying=" + this.isPlaying + ")";
        }

        public ActivePlaylistItem(AudioItem item, boolean z) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.item = item;
            this.isPlaying = z;
        }

        public final AudioItem getItem() {
            return this.item;
        }

        public final boolean isPlaying() {
            return this.isPlaying;
        }
    }

    /* JADX INFO: compiled from: PreviewPlaylistReducer.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$Action;", "", "<init>", "()V", "Fetch", "ItemsLoaded", "CurrentItemChanged", "IsPlayingStateChanged", "ItemClicked", "Close", "Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$Action$Close;", "Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$Action$CurrentItemChanged;", "Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$Action$Fetch;", "Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$Action$IsPlayingStateChanged;", "Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$Action$ItemClicked;", "Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$Action$ItemsLoaded;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: PreviewPlaylistReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$Action$Fetch;", "Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Fetch extends Action {
            public static final int $stable = 0;
            public static final Fetch INSTANCE = new Fetch();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Fetch)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1634590885;
            }

            public String toString() {
                return "Fetch";
            }

            private Fetch() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: PreviewPlaylistReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$Action$ItemsLoaded;", "Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$Action;", "updatedItems", "", "Lcom/box/android/domain/services/AudioItem;", "<init>", "(Ljava/util/List;)V", "getUpdatedItems", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ItemsLoaded extends Action {
            public static final int $stable = 8;
            private final List<AudioItem> updatedItems;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ItemsLoaded copy$default(ItemsLoaded itemsLoaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = itemsLoaded.updatedItems;
                }
                return itemsLoaded.copy(list);
            }

            public final List<AudioItem> component1() {
                return this.updatedItems;
            }

            public final ItemsLoaded copy(List<? extends AudioItem> updatedItems) {
                Intrinsics.checkNotNullParameter(updatedItems, "updatedItems");
                return new ItemsLoaded(updatedItems);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ItemsLoaded) && Intrinsics.areEqual(this.updatedItems, ((ItemsLoaded) other).updatedItems);
            }

            public int hashCode() {
                return this.updatedItems.hashCode();
            }

            public String toString() {
                return "ItemsLoaded(updatedItems=" + this.updatedItems + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public ItemsLoaded(List<? extends AudioItem> updatedItems) {
                super(null);
                Intrinsics.checkNotNullParameter(updatedItems, "updatedItems");
                this.updatedItems = updatedItems;
            }

            public final List<AudioItem> getUpdatedItems() {
                return this.updatedItems;
            }
        }

        /* JADX INFO: compiled from: PreviewPlaylistReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$Action$CurrentItemChanged;", "Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$Action;", "newAudioItem", "Lcom/box/android/domain/services/AudioItem;", "<init>", "(Lcom/box/android/domain/services/AudioItem;)V", "getNewAudioItem", "()Lcom/box/android/domain/services/AudioItem;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CurrentItemChanged extends Action {
            public static final int $stable = 8;
            private final AudioItem newAudioItem;

            public static /* synthetic */ CurrentItemChanged copy$default(CurrentItemChanged currentItemChanged, AudioItem audioItem, int i, Object obj) {
                if ((i & 1) != 0) {
                    audioItem = currentItemChanged.newAudioItem;
                }
                return currentItemChanged.copy(audioItem);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final AudioItem getNewAudioItem() {
                return this.newAudioItem;
            }

            public final CurrentItemChanged copy(AudioItem newAudioItem) {
                Intrinsics.checkNotNullParameter(newAudioItem, "newAudioItem");
                return new CurrentItemChanged(newAudioItem);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CurrentItemChanged) && Intrinsics.areEqual(this.newAudioItem, ((CurrentItemChanged) other).newAudioItem);
            }

            public int hashCode() {
                return this.newAudioItem.hashCode();
            }

            public String toString() {
                return "CurrentItemChanged(newAudioItem=" + this.newAudioItem + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CurrentItemChanged(AudioItem newAudioItem) {
                super(null);
                Intrinsics.checkNotNullParameter(newAudioItem, "newAudioItem");
                this.newAudioItem = newAudioItem;
            }

            public final AudioItem getNewAudioItem() {
                return this.newAudioItem;
            }
        }

        /* JADX INFO: compiled from: PreviewPlaylistReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$Action$IsPlayingStateChanged;", "Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$Action;", "newIsPlaying", "", "<init>", "(Z)V", "getNewIsPlaying", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class IsPlayingStateChanged extends Action {
            public static final int $stable = 0;
            private final boolean newIsPlaying;

            public static /* synthetic */ IsPlayingStateChanged copy$default(IsPlayingStateChanged isPlayingStateChanged, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = isPlayingStateChanged.newIsPlaying;
                }
                return isPlayingStateChanged.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getNewIsPlaying() {
                return this.newIsPlaying;
            }

            public final IsPlayingStateChanged copy(boolean newIsPlaying) {
                return new IsPlayingStateChanged(newIsPlaying);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof IsPlayingStateChanged) && this.newIsPlaying == ((IsPlayingStateChanged) other).newIsPlaying;
            }

            public int hashCode() {
                return Boolean.hashCode(this.newIsPlaying);
            }

            public String toString() {
                return "IsPlayingStateChanged(newIsPlaying=" + this.newIsPlaying + ")";
            }

            public IsPlayingStateChanged(boolean z) {
                super(null);
                this.newIsPlaying = z;
            }

            public final boolean getNewIsPlaying() {
                return this.newIsPlaying;
            }
        }

        /* JADX INFO: compiled from: PreviewPlaylistReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$Action$ItemClicked;", "Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$Action;", "item", "Lcom/box/android/domain/services/AudioItem;", "<init>", "(Lcom/box/android/domain/services/AudioItem;)V", "getItem", "()Lcom/box/android/domain/services/AudioItem;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ItemClicked extends Action {
            public static final int $stable = 8;
            private final AudioItem item;

            public static /* synthetic */ ItemClicked copy$default(ItemClicked itemClicked, AudioItem audioItem, int i, Object obj) {
                if ((i & 1) != 0) {
                    audioItem = itemClicked.item;
                }
                return itemClicked.copy(audioItem);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final AudioItem getItem() {
                return this.item;
            }

            public final ItemClicked copy(AudioItem item) {
                Intrinsics.checkNotNullParameter(item, "item");
                return new ItemClicked(item);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ItemClicked) && Intrinsics.areEqual(this.item, ((ItemClicked) other).item);
            }

            public int hashCode() {
                return this.item.hashCode();
            }

            public String toString() {
                return "ItemClicked(item=" + this.item + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ItemClicked(AudioItem item) {
                super(null);
                Intrinsics.checkNotNullParameter(item, "item");
                this.item = item;
            }

            public final AudioItem getItem() {
                return this.item;
            }
        }

        /* JADX INFO: compiled from: PreviewPlaylistReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$Action$Close;", "Lcom/box/android/preview/previewtype/audio/playlist/PreviewPlaylistReducer$Action;", "itemModel", "Lcom/box/android/domain/models/item/FileModel;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;)V", "getItemModel", "()Lcom/box/android/domain/models/item/FileModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Close extends Action {
            public static final int $stable = 8;
            private final FileModel itemModel;

            /* JADX WARN: Multi-variable type inference failed */
            public Close() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ Close copy$default(Close close, FileModel fileModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileModel = close.itemModel;
                }
                return close.copy(fileModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FileModel getItemModel() {
                return this.itemModel;
            }

            public final Close copy(FileModel itemModel) {
                return new Close(itemModel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Close) && Intrinsics.areEqual(this.itemModel, ((Close) other).itemModel);
            }

            public int hashCode() {
                FileModel fileModel = this.itemModel;
                if (fileModel == null) {
                    return 0;
                }
                return fileModel.hashCode();
            }

            public String toString() {
                return "Close(itemModel=" + this.itemModel + ")";
            }

            public Close(FileModel fileModel) {
                super(null);
                this.itemModel = fileModel;
            }

            public /* synthetic */ Close(FileModel fileModel, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : fileModel);
            }

            public final FileModel getItemModel() {
                return this.itemModel;
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReducerResult<State, Action> reducePlaylist(State state, Action action) {
        Object next;
        if (action instanceof Action.Fetch) {
            final Flow<Result<List<AudioItem>, DomainError>> flowFetchAudioPlaylistItems = this.environment.getPlaylistService().fetchAudioPlaylistItems(state.getInitialFileModel(), state.getPreviewSource());
            return new ReducerResult<>(state, EffectKt.toEffect(new Flow<Action.ItemsLoaded>() { // from class: com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistReducer$reducePlaylist$$inlined$map$1

                /* JADX INFO: renamed from: com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistReducer$reducePlaylist$$inlined$map$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* JADX INFO: renamed from: com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistReducer$reducePlaylist$$inlined$map$1$2$1, reason: invalid class name */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "com.box.android.preview.previewtype.audio.playlist.PreviewPlaylistReducer$reducePlaylist$$inlined$map$1$2", f = "PreviewPlaylistReducer.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object obj, Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
                        if (continuation instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) continuation;
                            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label -= Integer.MIN_VALUE;
                            } else {
                                anonymousClass1 = new AnonymousClass1(continuation);
                            }
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                        Object obj2 = anonymousClass1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = anonymousClass1.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj2);
                            FlowCollector flowCollector = this.$this_unsafeFlow;
                            List listEmptyList = (List) com.box.android.domain.utils.result.ResultKt.getOrNull((Result) obj);
                            if (listEmptyList == null) {
                                listEmptyList = CollectionsKt.emptyList();
                            }
                            PreviewPlaylistReducer.Action.ItemsLoaded itemsLoaded = new PreviewPlaylistReducer.Action.ItemsLoaded(listEmptyList);
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(itemsLoaded, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            int i2 = anonymousClass1.I$0;
                            Object obj3 = anonymousClass1.L$2;
                            Object obj4 = anonymousClass1.L$0;
                            ResultKt.throwOnFailure(obj2);
                        }
                        return Unit.INSTANCE;
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super PreviewPlaylistReducer.Action.ItemsLoaded> flowCollector, Continuation continuation) {
                    Object objCollect = flowFetchAudioPlaylistItems.collect(new AnonymousClass2(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }
            }));
        }
        if (action instanceof Action.ItemsLoaded) {
            boolean zIsPlaying = this.environment.getAudioPlayerManager().isPlaying();
            String currentItemId = this.environment.getAudioPlayerManager().getCurrentItemId();
            Action.ItemsLoaded itemsLoaded = (Action.ItemsLoaded) action;
            Iterator<T> it = itemsLoaded.getUpdatedItems().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(((AudioItem) next).getFileModel().getItemId().toString(), currentItemId));
            AudioItem audioItem = (AudioItem) next;
            if (audioItem == null) {
                BoxLogUtils.e("Playlist screen items loaded with no item is playing, items = " + itemsLoaded.getUpdatedItems());
                return new ReducerResult<>(state, null, 2, null);
            }
            return new ReducerResult<>(State.copy$default(state, null, null, new ActivePlaylistItem(audioItem, zIsPlaying), itemsLoaded.getUpdatedItems(), null, 19, null), null, 2, null);
        }
        if (action instanceof Action.CurrentItemChanged) {
            ActivePlaylistItem activeItem = state.getActiveItem();
            return new ReducerResult<>(State.copy$default(state, null, null, activeItem != null ? ActivePlaylistItem.copy$default(activeItem, ((Action.CurrentItemChanged) action).getNewAudioItem(), false, 2, null) : null, null, null, 27, null), null, 2, null);
        }
        if (action instanceof Action.IsPlayingStateChanged) {
            ActivePlaylistItem activeItem2 = state.getActiveItem();
            return new ReducerResult<>(State.copy$default(state, null, null, activeItem2 != null ? ActivePlaylistItem.copy$default(activeItem2, null, ((Action.IsPlayingStateChanged) action).getNewIsPlaying(), 1, null) : null, null, null, 27, null), null, 2, null);
        }
        if (action instanceof Action.ItemClicked) {
            return new ReducerResult<>(state, new Effect(new Action.Close(((Action.ItemClicked) action).getItem().getFileModel())));
        }
        if (action instanceof Action.Close) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, new Close(((Action.Close) action).getItemModel()), 15, null), null, 2, null);
        }
        throw new NoWhenBranchMatchedException();
    }
}

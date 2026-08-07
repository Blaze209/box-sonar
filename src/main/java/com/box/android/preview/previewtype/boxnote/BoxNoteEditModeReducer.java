package com.box.android.preview.previewtype.boxnote;

import com.box.android.base.cpl.IClipboardService;
import com.box.android.coreservices.models.BoxAccountManager;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.item.FileModel;
import com.facebook.react.uimanager.ViewProps;
import com.pspdfkit.analytics.Analytics;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxNoteEditModeReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0005\u0015\u0016\u0017\u0018\u0019B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\f\u001a\u00020\u0002*\u00020\u00022\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0002\b\u0010H\u0002J$\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$State;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action;", "environment", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeEnvironment;", "<init>", "(Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeEnvironment;)V", "build", "Lcom/box/android/cpl/Reduce;", "getBuild", "()Lcom/box/android/cpl/Reduce;", "appendEffect", ViewProps.TRANSFORM, "Lkotlin/Function1;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$ViewEffect;", "Lkotlin/ExtensionFunctionType;", "reduce", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "State", "Action", "ViewEffect", "TextStyle", "ListStyle", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxNoteEditModeReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reduce<State, Action> build;
    private final BoxNoteEditModeEnvironment environment;

    /* JADX INFO: compiled from: BoxNoteEditModeReducer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$ListStyle;", "", "<init>", "(Ljava/lang/String;I)V", "NUMBER", "BULLET", "CHECK", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum ListStyle {
        NUMBER,
        BULLET,
        CHECK;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<ListStyle> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: BoxNoteEditModeReducer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$TextStyle;", "", "<init>", "(Ljava/lang/String;I)V", "BOLD", "ITALIC", "UNDERLINE", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum TextStyle {
        BOLD,
        ITALIC,
        UNDERLINE;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<TextStyle> getEntries() {
            return $ENTRIES;
        }
    }

    public BoxNoteEditModeReducer(BoxNoteEditModeEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        this.build = new Reduce<>(new BoxNoteEditModeReducer$build$1(this));
    }

    /* JADX INFO: compiled from: BoxNoteEditModeReducer.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\u0015\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\tHÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u0083\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001J\u0013\u00100\u001a\u00020\u00072\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00065"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$State;", "", "file", "Lcom/box/android/domain/models/item/FileModel;", "noteUrl", "", BoxNoteConstants.BOX_NOTE_VALUE_CONNECTED, "", "headers", "", "isSelectionMode", "hasPasteData", "isMobileCopyPasteEnabled", "viewEffect", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$ViewEffect;", "textStyle", "", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$TextStyle;", "listStyle", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$ListStyle;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;Ljava/lang/String;ZLjava/util/Map;ZZZLcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$ViewEffect;Ljava/util/Set;Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$ListStyle;)V", "getFile", "()Lcom/box/android/domain/models/item/FileModel;", "getNoteUrl", "()Ljava/lang/String;", "getConnected", "()Z", "getHeaders", "()Ljava/util/Map;", "getHasPasteData", "getViewEffect", "()Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$ViewEffect;", "getTextStyle", "()Ljava/util/Set;", "getListStyle", "()Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$ListStyle;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final boolean connected;
        private final FileModel file;
        private final boolean hasPasteData;
        private final Map<String, String> headers;
        private final boolean isMobileCopyPasteEnabled;
        private final boolean isSelectionMode;
        private final ListStyle listStyle;
        private final String noteUrl;
        private final Set<TextStyle> textStyle;
        private final ViewEffect viewEffect;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, FileModel fileModel, String str, boolean z, Map map, boolean z2, boolean z3, boolean z4, ViewEffect viewEffect, Set set, ListStyle listStyle, int i, Object obj) {
            if ((i & 1) != 0) {
                fileModel = state.file;
            }
            if ((i & 2) != 0) {
                str = state.noteUrl;
            }
            if ((i & 4) != 0) {
                z = state.connected;
            }
            if ((i & 8) != 0) {
                map = state.headers;
            }
            if ((i & 16) != 0) {
                z2 = state.isSelectionMode;
            }
            if ((i & 32) != 0) {
                z3 = state.hasPasteData;
            }
            if ((i & 64) != 0) {
                z4 = state.isMobileCopyPasteEnabled;
            }
            if ((i & 128) != 0) {
                viewEffect = state.viewEffect;
            }
            if ((i & 256) != 0) {
                set = state.textStyle;
            }
            if ((i & 512) != 0) {
                listStyle = state.listStyle;
            }
            Set set2 = set;
            ListStyle listStyle2 = listStyle;
            boolean z5 = z4;
            ViewEffect viewEffect2 = viewEffect;
            boolean z6 = z2;
            boolean z7 = z3;
            return state.copy(fileModel, str, z, map, z6, z7, z5, viewEffect2, set2, listStyle2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FileModel getFile() {
            return this.file;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final ListStyle getListStyle() {
            return this.listStyle;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getNoteUrl() {
            return this.noteUrl;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getConnected() {
            return this.connected;
        }

        public final Map<String, String> component4() {
            return this.headers;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsSelectionMode() {
            return this.isSelectionMode;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getHasPasteData() {
            return this.hasPasteData;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getIsMobileCopyPasteEnabled() {
            return this.isMobileCopyPasteEnabled;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final ViewEffect getViewEffect() {
            return this.viewEffect;
        }

        public final Set<TextStyle> component9() {
            return this.textStyle;
        }

        public final State copy(FileModel file, String noteUrl, boolean connected, Map<String, String> headers, boolean isSelectionMode, boolean hasPasteData, boolean isMobileCopyPasteEnabled, ViewEffect viewEffect, Set<? extends TextStyle> textStyle, ListStyle listStyle) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(noteUrl, "noteUrl");
            Intrinsics.checkNotNullParameter(headers, "headers");
            Intrinsics.checkNotNullParameter(textStyle, "textStyle");
            return new State(file, noteUrl, connected, headers, isSelectionMode, hasPasteData, isMobileCopyPasteEnabled, viewEffect, textStyle, listStyle);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.file, state.file) && Intrinsics.areEqual(this.noteUrl, state.noteUrl) && this.connected == state.connected && Intrinsics.areEqual(this.headers, state.headers) && this.isSelectionMode == state.isSelectionMode && this.hasPasteData == state.hasPasteData && this.isMobileCopyPasteEnabled == state.isMobileCopyPasteEnabled && Intrinsics.areEqual(this.viewEffect, state.viewEffect) && Intrinsics.areEqual(this.textStyle, state.textStyle) && this.listStyle == state.listStyle;
        }

        public int hashCode() {
            int iHashCode = ((((((((((((this.file.hashCode() * 31) + this.noteUrl.hashCode()) * 31) + Boolean.hashCode(this.connected)) * 31) + this.headers.hashCode()) * 31) + Boolean.hashCode(this.isSelectionMode)) * 31) + Boolean.hashCode(this.hasPasteData)) * 31) + Boolean.hashCode(this.isMobileCopyPasteEnabled)) * 31;
            ViewEffect viewEffect = this.viewEffect;
            int iHashCode2 = (((iHashCode + (viewEffect == null ? 0 : viewEffect.hashCode())) * 31) + this.textStyle.hashCode()) * 31;
            ListStyle listStyle = this.listStyle;
            return iHashCode2 + (listStyle != null ? listStyle.hashCode() : 0);
        }

        public String toString() {
            return "State(file=" + this.file + ", noteUrl=" + this.noteUrl + ", connected=" + this.connected + ", headers=" + this.headers + ", isSelectionMode=" + this.isSelectionMode + ", hasPasteData=" + this.hasPasteData + ", isMobileCopyPasteEnabled=" + this.isMobileCopyPasteEnabled + ", viewEffect=" + this.viewEffect + ", textStyle=" + this.textStyle + ", listStyle=" + this.listStyle + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public State(FileModel file, String noteUrl, boolean z, Map<String, String> headers, boolean z2, boolean z3, boolean z4, ViewEffect viewEffect, Set<? extends TextStyle> textStyle, ListStyle listStyle) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(noteUrl, "noteUrl");
            Intrinsics.checkNotNullParameter(headers, "headers");
            Intrinsics.checkNotNullParameter(textStyle, "textStyle");
            this.file = file;
            this.noteUrl = noteUrl;
            this.connected = z;
            this.headers = headers;
            this.isSelectionMode = z2;
            this.hasPasteData = z3;
            this.isMobileCopyPasteEnabled = z4;
            this.viewEffect = viewEffect;
            this.textStyle = textStyle;
            this.listStyle = listStyle;
        }

        public final FileModel getFile() {
            return this.file;
        }

        public final String getNoteUrl() {
            return this.noteUrl;
        }

        public final boolean getConnected() {
            return this.connected;
        }

        public /* synthetic */ State(FileModel fileModel, String str, boolean z, Map map, boolean z2, boolean z3, boolean z4, ViewEffect viewEffect, Set set, ListStyle listStyle, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(fileModel, str, z, (i & 8) != 0 ? MapsKt.emptyMap() : map, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? false : z3, (i & 64) != 0 ? false : z4, (i & 128) != 0 ? null : viewEffect, (i & 256) != 0 ? SetsKt.emptySet() : set, (i & 512) != 0 ? null : listStyle);
        }

        public final Map<String, String> getHeaders() {
            return this.headers;
        }

        public final boolean isSelectionMode() {
            return this.isSelectionMode;
        }

        public final boolean getHasPasteData() {
            return this.hasPasteData;
        }

        public final boolean isMobileCopyPasteEnabled() {
            return this.isMobileCopyPasteEnabled;
        }

        public final ViewEffect getViewEffect() {
            return this.viewEffect;
        }

        public final Set<TextStyle> getTextStyle() {
            return this.textStyle;
        }

        public final ListStyle getListStyle() {
            return this.listStyle;
        }
    }

    /* JADX INFO: compiled from: BoxNoteEditModeReducer.kt */
    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0016\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0016\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./¨\u00060"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action;", "", "<init>", "()V", "Initialize", "RequestFocus", "Exit", "EnterSelectionMode", "ExitSelectionMode", "Cut", "Copy", "Paste", "Bold", "Italic", "Underline", "Indent", "Outdent", "NumberList", "BulletList", "CheckList", "EffectProcessed", "TextStyleChanged", "ListStyleChanged", "SetEditorFocus", "ScreenHeightChanged", "SelectedTextRetrieved", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$Bold;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$BulletList;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$CheckList;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$Copy;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$Cut;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$EffectProcessed;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$EnterSelectionMode;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$Exit;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$ExitSelectionMode;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$Indent;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$Initialize;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$Italic;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$ListStyleChanged;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$NumberList;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$Outdent;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$Paste;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$RequestFocus;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$ScreenHeightChanged;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$SelectedTextRetrieved;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$SetEditorFocus;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$TextStyleChanged;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$Underline;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: BoxNoteEditModeReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$Initialize;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action;", "<init>", "()V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Initialize extends Action {
            public static final int $stable = 0;
            public static final Initialize INSTANCE = new Initialize();

            private Initialize() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: BoxNoteEditModeReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$RequestFocus;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action;", "<init>", "()V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class RequestFocus extends Action {
            public static final int $stable = 0;
            public static final RequestFocus INSTANCE = new RequestFocus();

            private RequestFocus() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BoxNoteEditModeReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$Exit;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action;", "<init>", "()V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Exit extends Action {
            public static final int $stable = 0;
            public static final Exit INSTANCE = new Exit();

            private Exit() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BoxNoteEditModeReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$EnterSelectionMode;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action;", "<init>", "()V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class EnterSelectionMode extends Action {
            public static final int $stable = 0;
            public static final EnterSelectionMode INSTANCE = new EnterSelectionMode();

            private EnterSelectionMode() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BoxNoteEditModeReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$ExitSelectionMode;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action;", "<init>", "()V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class ExitSelectionMode extends Action {
            public static final int $stable = 0;
            public static final ExitSelectionMode INSTANCE = new ExitSelectionMode();

            private ExitSelectionMode() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BoxNoteEditModeReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$Cut;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action;", "<init>", "()V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Cut extends Action {
            public static final int $stable = 0;
            public static final Cut INSTANCE = new Cut();

            private Cut() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BoxNoteEditModeReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$Copy;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action;", "<init>", "()V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Copy extends Action {
            public static final int $stable = 0;
            public static final Copy INSTANCE = new Copy();

            private Copy() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BoxNoteEditModeReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$Paste;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action;", "<init>", "()V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Paste extends Action {
            public static final int $stable = 0;
            public static final Paste INSTANCE = new Paste();

            private Paste() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BoxNoteEditModeReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$Bold;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action;", "<init>", "()V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Bold extends Action {
            public static final int $stable = 0;
            public static final Bold INSTANCE = new Bold();

            private Bold() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BoxNoteEditModeReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$Italic;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action;", "<init>", "()V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Italic extends Action {
            public static final int $stable = 0;
            public static final Italic INSTANCE = new Italic();

            private Italic() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BoxNoteEditModeReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$Underline;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action;", "<init>", "()V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Underline extends Action {
            public static final int $stable = 0;
            public static final Underline INSTANCE = new Underline();

            private Underline() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BoxNoteEditModeReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$Indent;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action;", "<init>", "()V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Indent extends Action {
            public static final int $stable = 0;
            public static final Indent INSTANCE = new Indent();

            private Indent() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BoxNoteEditModeReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$Outdent;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action;", "<init>", "()V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Outdent extends Action {
            public static final int $stable = 0;
            public static final Outdent INSTANCE = new Outdent();

            private Outdent() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BoxNoteEditModeReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$NumberList;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action;", "<init>", "()V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class NumberList extends Action {
            public static final int $stable = 0;
            public static final NumberList INSTANCE = new NumberList();

            private NumberList() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BoxNoteEditModeReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$BulletList;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action;", "<init>", "()V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class BulletList extends Action {
            public static final int $stable = 0;
            public static final BulletList INSTANCE = new BulletList();

            private BulletList() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BoxNoteEditModeReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$CheckList;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action;", "<init>", "()V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class CheckList extends Action {
            public static final int $stable = 0;
            public static final CheckList INSTANCE = new CheckList();

            private CheckList() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BoxNoteEditModeReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$EffectProcessed;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action;", "<init>", "()V", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class EffectProcessed extends Action {
            public static final int $stable = 0;
            public static final EffectProcessed INSTANCE = new EffectProcessed();

            private EffectProcessed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BoxNoteEditModeReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$TextStyleChanged;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action;", "style", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$TextStyle;", "enabled", "", "<init>", "(Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$TextStyle;Z)V", "getStyle", "()Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$TextStyle;", "getEnabled", "()Z", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class TextStyleChanged extends Action {
            public static final int $stable = 0;
            private final boolean enabled;
            private final TextStyle style;

            public static /* synthetic */ TextStyleChanged copy$default(TextStyleChanged textStyleChanged, TextStyle textStyle, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    textStyle = textStyleChanged.style;
                }
                if ((i & 2) != 0) {
                    z = textStyleChanged.enabled;
                }
                return textStyleChanged.copy(textStyle, z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final TextStyle getStyle() {
                return this.style;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getEnabled() {
                return this.enabled;
            }

            public final TextStyleChanged copy(TextStyle style, boolean enabled) {
                Intrinsics.checkNotNullParameter(style, "style");
                return new TextStyleChanged(style, enabled);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof TextStyleChanged)) {
                    return false;
                }
                TextStyleChanged textStyleChanged = (TextStyleChanged) other;
                return this.style == textStyleChanged.style && this.enabled == textStyleChanged.enabled;
            }

            public int hashCode() {
                return (this.style.hashCode() * 31) + Boolean.hashCode(this.enabled);
            }

            public String toString() {
                return "TextStyleChanged(style=" + this.style + ", enabled=" + this.enabled + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public TextStyleChanged(TextStyle style, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(style, "style");
                this.style = style;
                this.enabled = z;
            }

            public final boolean getEnabled() {
                return this.enabled;
            }

            public final TextStyle getStyle() {
                return this.style;
            }
        }

        /* JADX INFO: compiled from: BoxNoteEditModeReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$ListStyleChanged;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action;", "style", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$ListStyle;", "<init>", "(Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$ListStyle;)V", "getStyle", "()Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$ListStyle;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ListStyleChanged extends Action {
            public static final int $stable = 0;
            private final ListStyle style;

            public static /* synthetic */ ListStyleChanged copy$default(ListStyleChanged listStyleChanged, ListStyle listStyle, int i, Object obj) {
                if ((i & 1) != 0) {
                    listStyle = listStyleChanged.style;
                }
                return listStyleChanged.copy(listStyle);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ListStyle getStyle() {
                return this.style;
            }

            public final ListStyleChanged copy(ListStyle style) {
                return new ListStyleChanged(style);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ListStyleChanged) && this.style == ((ListStyleChanged) other).style;
            }

            public int hashCode() {
                ListStyle listStyle = this.style;
                if (listStyle == null) {
                    return 0;
                }
                return listStyle.hashCode();
            }

            public String toString() {
                return "ListStyleChanged(style=" + this.style + ")";
            }

            public ListStyleChanged(ListStyle listStyle) {
                super(null);
                this.style = listStyle;
            }

            public final ListStyle getStyle() {
                return this.style;
            }
        }

        /* JADX INFO: compiled from: BoxNoteEditModeReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$SetEditorFocus;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action;", "shouldFocus", "", "<init>", "(Z)V", "getShouldFocus", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SetEditorFocus extends Action {
            public static final int $stable = 0;
            private final boolean shouldFocus;

            public static /* synthetic */ SetEditorFocus copy$default(SetEditorFocus setEditorFocus, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = setEditorFocus.shouldFocus;
                }
                return setEditorFocus.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getShouldFocus() {
                return this.shouldFocus;
            }

            public final SetEditorFocus copy(boolean shouldFocus) {
                return new SetEditorFocus(shouldFocus);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SetEditorFocus) && this.shouldFocus == ((SetEditorFocus) other).shouldFocus;
            }

            public int hashCode() {
                return Boolean.hashCode(this.shouldFocus);
            }

            public String toString() {
                return "SetEditorFocus(shouldFocus=" + this.shouldFocus + ")";
            }

            public SetEditorFocus(boolean z) {
                super(null);
                this.shouldFocus = z;
            }

            public final boolean getShouldFocus() {
                return this.shouldFocus;
            }
        }

        /* JADX INFO: compiled from: BoxNoteEditModeReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$ScreenHeightChanged;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action;", "heightPx", "", "<init>", "(I)V", "getHeightPx", "()I", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ScreenHeightChanged extends Action {
            public static final int $stable = 0;
            private final int heightPx;

            public static /* synthetic */ ScreenHeightChanged copy$default(ScreenHeightChanged screenHeightChanged, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = screenHeightChanged.heightPx;
                }
                return screenHeightChanged.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getHeightPx() {
                return this.heightPx;
            }

            public final ScreenHeightChanged copy(int heightPx) {
                return new ScreenHeightChanged(heightPx);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ScreenHeightChanged) && this.heightPx == ((ScreenHeightChanged) other).heightPx;
            }

            public int hashCode() {
                return Integer.hashCode(this.heightPx);
            }

            public String toString() {
                return "ScreenHeightChanged(heightPx=" + this.heightPx + ")";
            }

            public ScreenHeightChanged(int i) {
                super(null);
                this.heightPx = i;
            }

            public final int getHeightPx() {
                return this.heightPx;
            }
        }

        /* JADX INFO: compiled from: BoxNoteEditModeReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action$SelectedTextRetrieved;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action;", "selectedText", "", "<init>", "(Ljava/lang/String;)V", "getSelectedText", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SelectedTextRetrieved extends Action {
            public static final int $stable = 0;
            private final String selectedText;

            public static /* synthetic */ SelectedTextRetrieved copy$default(SelectedTextRetrieved selectedTextRetrieved, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = selectedTextRetrieved.selectedText;
                }
                return selectedTextRetrieved.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getSelectedText() {
                return this.selectedText;
            }

            public final SelectedTextRetrieved copy(String selectedText) {
                Intrinsics.checkNotNullParameter(selectedText, "selectedText");
                return new SelectedTextRetrieved(selectedText);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SelectedTextRetrieved) && Intrinsics.areEqual(this.selectedText, ((SelectedTextRetrieved) other).selectedText);
            }

            public int hashCode() {
                return this.selectedText.hashCode();
            }

            public String toString() {
                return "SelectedTextRetrieved(selectedText=" + this.selectedText + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SelectedTextRetrieved(String selectedText) {
                super(null);
                Intrinsics.checkNotNullParameter(selectedText, "selectedText");
                this.selectedText = selectedText;
            }

            public final String getSelectedText() {
                return this.selectedText;
            }
        }
    }

    /* JADX INFO: compiled from: BoxNoteEditModeReducer.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0004J\u0014\u0010\u000f\u001a\u00020\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0006\u0010\u0011\u001a\u00020\u0000J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J#\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$ViewEffect;", "", "requests", "", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteRequest;", "hideKeyboard", "", "<init>", "(Ljava/util/List;Z)V", "getRequests", "()Ljava/util/List;", "getHideKeyboard", "()Z", "withRequest", "request", "withRequests", "newRequests", "withHideKeyboard", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ViewEffect {
        public static final int $stable = 8;
        private final boolean hideKeyboard;
        private final List<BoxNoteRequest> requests;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewEffect() {
            this(null, false, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewEffect copy$default(ViewEffect viewEffect, List list, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                list = viewEffect.requests;
            }
            if ((i & 2) != 0) {
                z = viewEffect.hideKeyboard;
            }
            return viewEffect.copy(list, z);
        }

        public final List<BoxNoteRequest> component1() {
            return this.requests;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getHideKeyboard() {
            return this.hideKeyboard;
        }

        public final ViewEffect copy(List<BoxNoteRequest> requests, boolean hideKeyboard) {
            Intrinsics.checkNotNullParameter(requests, "requests");
            return new ViewEffect(requests, hideKeyboard);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewEffect)) {
                return false;
            }
            ViewEffect viewEffect = (ViewEffect) other;
            return Intrinsics.areEqual(this.requests, viewEffect.requests) && this.hideKeyboard == viewEffect.hideKeyboard;
        }

        public int hashCode() {
            return (this.requests.hashCode() * 31) + Boolean.hashCode(this.hideKeyboard);
        }

        public String toString() {
            return "ViewEffect(requests=" + this.requests + ", hideKeyboard=" + this.hideKeyboard + ")";
        }

        public ViewEffect(List<BoxNoteRequest> requests, boolean z) {
            Intrinsics.checkNotNullParameter(requests, "requests");
            this.requests = requests;
            this.hideKeyboard = z;
        }

        public /* synthetic */ ViewEffect(List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? false : z);
        }

        public final boolean getHideKeyboard() {
            return this.hideKeyboard;
        }

        public final List<BoxNoteRequest> getRequests() {
            return this.requests;
        }

        public final ViewEffect withRequest(BoxNoteRequest request) {
            Intrinsics.checkNotNullParameter(request, "request");
            return copy$default(this, CollectionsKt.plus((Collection<? extends BoxNoteRequest>) this.requests, request), false, 2, null);
        }

        public final ViewEffect withRequests(List<BoxNoteRequest> newRequests) {
            Intrinsics.checkNotNullParameter(newRequests, "newRequests");
            return copy$default(this, CollectionsKt.plus((Collection) this.requests, (Iterable) newRequests), false, 2, null);
        }

        public final ViewEffect withHideKeyboard() {
            return copy$default(this, null, true, 1, null);
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final State appendEffect(State state, Function1<? super ViewEffect, ViewEffect> function1) {
        ViewEffect viewEffect = state.getViewEffect();
        if (viewEffect == null) {
            viewEffect = new ViewEffect(null, false, 3, 0 == true ? 1 : 0);
        }
        return State.copy$default(state, null, null, false, null, false, false, false, function1.invoke(viewEffect), null, null, 895, null);
    }

    @Override // com.box.android.cpl.Reducable
    public ReducerResult<State, Action> reduce(State state, final Action action) {
        State stateCopy$default;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof Action.Initialize) {
            return new ReducerResult<>(State.copy$default(state, null, null, false, null, false, this.environment.getClipboardService().hasPasteData(), BoxAccountManager.isMobileCopyPasteEnabled(this.environment.getUserContextManager()), null, null, null, 927, null), null, 2, null);
        }
        if (action instanceof Action.EnterSelectionMode) {
            return new ReducerResult<>(State.copy$default(state, null, null, false, null, true, false, false, null, null, null, 1007, null), null, 2, null);
        }
        if (action instanceof Action.ExitSelectionMode) {
            return new ReducerResult<>(State.copy$default(state, null, null, false, null, false, false, false, null, null, null, 1007, null), null, 2, null);
        }
        if (action instanceof Action.Cut) {
            return new ReducerResult<>(appendEffect(state, new Function1() { // from class: com.box.android.preview.previewtype.boxnote.BoxNoteEditModeReducer$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BoxNoteEditModeReducer.reduce$lambda$0(this.f$0, (BoxNoteEditModeReducer.ViewEffect) obj);
                }
            }), null, 2, null);
        }
        if (action instanceof Action.Copy) {
            return new ReducerResult<>(appendEffect(state, new Function1() { // from class: com.box.android.preview.previewtype.boxnote.BoxNoteEditModeReducer$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BoxNoteEditModeReducer.reduce$lambda$1(this.f$0, (BoxNoteEditModeReducer.ViewEffect) obj);
                }
            }), null, 2, null);
        }
        if (action instanceof Action.Paste) {
            final String htmlTextFromClipboard = this.environment.getClipboardService().getHtmlTextFromClipboard();
            if (htmlTextFromClipboard == null) {
                htmlTextFromClipboard = "";
            }
            return new ReducerResult<>(appendEffect(state, new Function1() { // from class: com.box.android.preview.previewtype.boxnote.BoxNoteEditModeReducer$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BoxNoteEditModeReducer.reduce$lambda$2(this.f$0, htmlTextFromClipboard, (BoxNoteEditModeReducer.ViewEffect) obj);
                }
            }), null, 2, null);
        }
        if (action instanceof Action.Bold) {
            return new ReducerResult<>(appendEffect(state, new Function1() { // from class: com.box.android.preview.previewtype.boxnote.BoxNoteEditModeReducer$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BoxNoteEditModeReducer.reduce$lambda$3(this.f$0, (BoxNoteEditModeReducer.ViewEffect) obj);
                }
            }), null, 2, null);
        }
        if (action instanceof Action.Italic) {
            return new ReducerResult<>(appendEffect(state, new Function1() { // from class: com.box.android.preview.previewtype.boxnote.BoxNoteEditModeReducer$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BoxNoteEditModeReducer.reduce$lambda$4(this.f$0, (BoxNoteEditModeReducer.ViewEffect) obj);
                }
            }), null, 2, null);
        }
        if (action instanceof Action.Underline) {
            return new ReducerResult<>(appendEffect(state, new Function1() { // from class: com.box.android.preview.previewtype.boxnote.BoxNoteEditModeReducer$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BoxNoteEditModeReducer.reduce$lambda$5(this.f$0, (BoxNoteEditModeReducer.ViewEffect) obj);
                }
            }), null, 2, null);
        }
        if (action instanceof Action.EffectProcessed) {
            return new ReducerResult<>(State.copy$default(state, null, null, false, null, false, false, false, null, null, null, 895, null), null, 2, null);
        }
        if (action instanceof Action.SetEditorFocus) {
            return new ReducerResult<>(appendEffect(state, new Function1() { // from class: com.box.android.preview.previewtype.boxnote.BoxNoteEditModeReducer$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BoxNoteEditModeReducer.reduce$lambda$6(this.f$0, action, (BoxNoteEditModeReducer.ViewEffect) obj);
                }
            }), null, 2, null);
        }
        if (action instanceof Action.ScreenHeightChanged) {
            return new ReducerResult<>(appendEffect(state, new Function1() { // from class: com.box.android.preview.previewtype.boxnote.BoxNoteEditModeReducer$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BoxNoteEditModeReducer.reduce$lambda$7(this.f$0, action, (BoxNoteEditModeReducer.ViewEffect) obj);
                }
            }), null, 2, null);
        }
        if (action instanceof Action.SelectedTextRetrieved) {
            return new ReducerResult<>(State.copy$default(state, null, null, false, null, false, ((Action.SelectedTextRetrieved) action).getSelectedText().length() > 0, false, null, null, null, 991, null), Effect.INSTANCE.fireAndForget(new AnonymousClass9(action, null)));
        }
        if (action instanceof Action.Indent) {
            return new ReducerResult<>(appendEffect(state, new Function1() { // from class: com.box.android.preview.previewtype.boxnote.BoxNoteEditModeReducer$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BoxNoteEditModeReducer.reduce$lambda$8(this.f$0, (BoxNoteEditModeReducer.ViewEffect) obj);
                }
            }), null, 2, null);
        }
        if (action instanceof Action.Outdent) {
            return new ReducerResult<>(appendEffect(state, new Function1() { // from class: com.box.android.preview.previewtype.boxnote.BoxNoteEditModeReducer$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BoxNoteEditModeReducer.reduce$lambda$9(this.f$0, (BoxNoteEditModeReducer.ViewEffect) obj);
                }
            }), null, 2, null);
        }
        if (action instanceof Action.NumberList) {
            return new ReducerResult<>(appendEffect(state, new Function1() { // from class: com.box.android.preview.previewtype.boxnote.BoxNoteEditModeReducer$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BoxNoteEditModeReducer.reduce$lambda$10(this.f$0, (BoxNoteEditModeReducer.ViewEffect) obj);
                }
            }), null, 2, null);
        }
        if (action instanceof Action.BulletList) {
            return new ReducerResult<>(appendEffect(state, new Function1() { // from class: com.box.android.preview.previewtype.boxnote.BoxNoteEditModeReducer$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BoxNoteEditModeReducer.reduce$lambda$11(this.f$0, (BoxNoteEditModeReducer.ViewEffect) obj);
                }
            }), null, 2, null);
        }
        if (action instanceof Action.CheckList) {
            return new ReducerResult<>(appendEffect(state, new Function1() { // from class: com.box.android.preview.previewtype.boxnote.BoxNoteEditModeReducer$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BoxNoteEditModeReducer.reduce$lambda$12(this.f$0, (BoxNoteEditModeReducer.ViewEffect) obj);
                }
            }), null, 2, null);
        }
        if (action instanceof Action.TextStyleChanged) {
            Action.TextStyleChanged textStyleChanged = (Action.TextStyleChanged) action;
            if (textStyleChanged.getEnabled()) {
                stateCopy$default = State.copy$default(state, null, null, false, null, false, false, false, null, SetsKt.plus(state.getTextStyle(), textStyleChanged.getStyle()), null, 767, null);
            } else {
                stateCopy$default = State.copy$default(state, null, null, false, null, false, false, false, null, SetsKt.minus(state.getTextStyle(), textStyleChanged.getStyle()), null, 767, null);
            }
            new ReducerResult(stateCopy$default, null, 2, null);
            return r0;
        }
        if (action instanceof Action.ListStyleChanged) {
            return new ReducerResult<>(State.copy$default(state, null, null, false, null, false, false, false, null, null, ((Action.ListStyleChanged) action).getStyle(), 511, null), null, 2, null);
        }
        if (action instanceof Action.Exit) {
            return new ReducerResult<>(appendEffect(state, new Function1() { // from class: com.box.android.preview.previewtype.boxnote.BoxNoteEditModeReducer$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BoxNoteEditModeReducer.reduce$lambda$13(this.f$0, (BoxNoteEditModeReducer.ViewEffect) obj);
                }
            }), null, 2, null);
        }
        if (!(action instanceof Action.RequestFocus)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult<>(appendEffect(state, new Function1() { // from class: com.box.android.preview.previewtype.boxnote.BoxNoteEditModeReducer$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BoxNoteEditModeReducer.reduce$lambda$14(this.f$0, (BoxNoteEditModeReducer.ViewEffect) obj);
            }
        }), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewEffect reduce$lambda$0(BoxNoteEditModeReducer boxNoteEditModeReducer, ViewEffect appendEffect) {
        Intrinsics.checkNotNullParameter(appendEffect, "$this$appendEffect");
        return appendEffect.withRequests(CollectionsKt.listOf((Object[]) new BoxNoteRequest[]{boxNoteEditModeReducer.environment.getRequestBuilder().requestSelectedHtml(), boxNoteEditModeReducer.environment.getRequestBuilder().insertHtmlString("")}));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewEffect reduce$lambda$1(BoxNoteEditModeReducer boxNoteEditModeReducer, ViewEffect appendEffect) {
        Intrinsics.checkNotNullParameter(appendEffect, "$this$appendEffect");
        return appendEffect.withRequest(boxNoteEditModeReducer.environment.getRequestBuilder().requestSelectedHtml());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewEffect reduce$lambda$2(BoxNoteEditModeReducer boxNoteEditModeReducer, String str, ViewEffect appendEffect) {
        Intrinsics.checkNotNullParameter(appendEffect, "$this$appendEffect");
        return appendEffect.withRequest(boxNoteEditModeReducer.environment.getRequestBuilder().insertHtmlString(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewEffect reduce$lambda$3(BoxNoteEditModeReducer boxNoteEditModeReducer, ViewEffect appendEffect) {
        Intrinsics.checkNotNullParameter(appendEffect, "$this$appendEffect");
        return appendEffect.withRequest(boxNoteEditModeReducer.environment.getRequestBuilder().setStyle("bold"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewEffect reduce$lambda$4(BoxNoteEditModeReducer boxNoteEditModeReducer, ViewEffect appendEffect) {
        Intrinsics.checkNotNullParameter(appendEffect, "$this$appendEffect");
        return appendEffect.withRequest(boxNoteEditModeReducer.environment.getRequestBuilder().setStyle("italic"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewEffect reduce$lambda$5(BoxNoteEditModeReducer boxNoteEditModeReducer, ViewEffect appendEffect) {
        Intrinsics.checkNotNullParameter(appendEffect, "$this$appendEffect");
        return appendEffect.withRequest(boxNoteEditModeReducer.environment.getRequestBuilder().setStyle("underline"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewEffect reduce$lambda$6(BoxNoteEditModeReducer boxNoteEditModeReducer, Action action, ViewEffect appendEffect) {
        Intrinsics.checkNotNullParameter(appendEffect, "$this$appendEffect");
        return appendEffect.withRequest(boxNoteEditModeReducer.environment.getRequestBuilder().setEditorFocus(((Action.SetEditorFocus) action).getShouldFocus()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewEffect reduce$lambda$7(BoxNoteEditModeReducer boxNoteEditModeReducer, Action action, ViewEffect appendEffect) {
        Intrinsics.checkNotNullParameter(appendEffect, "$this$appendEffect");
        return appendEffect.withRequest(boxNoteEditModeReducer.environment.getRequestBuilder().setViewportHeight(((Action.ScreenHeightChanged) action).getHeightPx()));
    }

    /* JADX INFO: renamed from: com.box.android.preview.previewtype.boxnote.BoxNoteEditModeReducer$reduce$9, reason: invalid class name */
    /* JADX INFO: compiled from: BoxNoteEditModeReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.previewtype.boxnote.BoxNoteEditModeReducer$reduce$9", f = "BoxNoteEditModeReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass9 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Action $action;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass9(Action action, Continuation<? super AnonymousClass9> continuation) {
            super(1, continuation);
            this.$action = action;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return BoxNoteEditModeReducer.this.new AnonymousClass9(this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass9) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                IClipboardService.copyTextToClipboard$default(BoxNoteEditModeReducer.this.environment.getClipboardService(), ((Action.SelectedTextRetrieved) this.$action).getSelectedText(), null, 2, null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewEffect reduce$lambda$8(BoxNoteEditModeReducer boxNoteEditModeReducer, ViewEffect appendEffect) {
        Intrinsics.checkNotNullParameter(appendEffect, "$this$appendEffect");
        return appendEffect.withRequest(boxNoteEditModeReducer.environment.getRequestBuilder().setStyle(BoxNoteConstants.BOX_NOTE_STYLE_TYPE_INDENT));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewEffect reduce$lambda$9(BoxNoteEditModeReducer boxNoteEditModeReducer, ViewEffect appendEffect) {
        Intrinsics.checkNotNullParameter(appendEffect, "$this$appendEffect");
        return appendEffect.withRequest(boxNoteEditModeReducer.environment.getRequestBuilder().setStyle(BoxNoteConstants.BOX_NOTE_STYLE_TYPE_OUTDENT));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewEffect reduce$lambda$10(BoxNoteEditModeReducer boxNoteEditModeReducer, ViewEffect appendEffect) {
        Intrinsics.checkNotNullParameter(appendEffect, "$this$appendEffect");
        return appendEffect.withRequest(boxNoteEditModeReducer.environment.getRequestBuilder().setStyle(BoxNoteConstants.BOX_NOTE_STYLE_TYPE_LIST, "number"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewEffect reduce$lambda$11(BoxNoteEditModeReducer boxNoteEditModeReducer, ViewEffect appendEffect) {
        Intrinsics.checkNotNullParameter(appendEffect, "$this$appendEffect");
        return appendEffect.withRequest(boxNoteEditModeReducer.environment.getRequestBuilder().setStyle(BoxNoteConstants.BOX_NOTE_STYLE_TYPE_LIST, BoxNoteConstants.BOX_NOTE_STYLE_TYPE_BULLET));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewEffect reduce$lambda$12(BoxNoteEditModeReducer boxNoteEditModeReducer, ViewEffect appendEffect) {
        Intrinsics.checkNotNullParameter(appendEffect, "$this$appendEffect");
        return appendEffect.withRequest(boxNoteEditModeReducer.environment.getRequestBuilder().setStyle(BoxNoteConstants.BOX_NOTE_STYLE_TYPE_LIST, BoxNoteConstants.BOX_NOTE_STYLE_TYPE_CHECK));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewEffect reduce$lambda$13(BoxNoteEditModeReducer boxNoteEditModeReducer, ViewEffect appendEffect) {
        Intrinsics.checkNotNullParameter(appendEffect, "$this$appendEffect");
        return appendEffect.withRequest(boxNoteEditModeReducer.environment.getRequestBuilder().setEditorFocus(false)).withHideKeyboard();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewEffect reduce$lambda$14(BoxNoteEditModeReducer boxNoteEditModeReducer, ViewEffect appendEffect) {
        Intrinsics.checkNotNullParameter(appendEffect, "$this$appendEffect");
        return appendEffect.withRequest(boxNoteEditModeReducer.environment.getRequestBuilder().setEditorFocus(true));
    }
}

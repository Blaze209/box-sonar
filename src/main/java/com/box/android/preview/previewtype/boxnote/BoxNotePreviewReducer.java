package com.box.android.preview.previewtype.boxnote;

import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.item.FileModel;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.pspdfkit.analytics.Analytics;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: BoxNotePreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002)*B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J$\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0010H\u0002J$\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0012H\u0002J$\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0014H\u0002J$\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0016H\u0002J$\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0018H\u0002J$\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u001aH\u0002J$\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u001cH\u0002J$\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u001e2\u0006\u0010\u000e\u001a\u00020\u001aH\u0002J$\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020 H\u0002J$\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\"H\u0002J\u001c\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u001c\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u001c\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u0002H\u0002J$\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020'H\u0002J\u001c\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u0002H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006+"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$State;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action;", "environment", "Lcom/box/android/preview/previewtype/boxnote/BoxNotesEnvironment;", "<init>", "(Lcom/box/android/preview/previewtype/boxnote/BoxNotesEnvironment;)V", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "reduceBoxNote", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "handleInitialize", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$Initialize;", "handleLoadNote", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$LoadNote;", "handleSessionRefreshed", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$RefreshSession;", "handleSessionRefreshFailed", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$SessionRefreshFailed;", "handleNoteUrlReady", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$NoteUrlReady;", "handleEditorReady", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$EditorReady;", "handleFilePermissionsResult", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$FilePermissionsResult;", "transitionToEditorReady", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$State$EditorInitializing;", "handleEditorFocusChanged", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$EditorFocusChanged;", "handleKeyboardVisibilityChanged", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$KeyboardVisibilityChanged;", "handleStartEditing", "handleStopEditing", "handleError", "handleConnectionStateChanged", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$ConnectionStateChanged;", "handleRetryLoad", "State", "Action", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxNotePreviewReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final BoxNotesEnvironment environment;

    public BoxNotePreviewReducer(BoxNotesEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new BoxNotePreviewReducer$build$1(this));
        final BoxNotePreviewReducer$build$2 boxNotePreviewReducer$build$2 = BoxNotePreviewReducer$build$2.INSTANCE;
        final BoxNotePreviewReducer$build$3 boxNotePreviewReducer$build$3 = BoxNotePreviewReducer$build$3.INSTANCE;
        this.build = new IfLetReducer(reduce, new BoxNoteEditModeReducer(environment.getEditModeEnvironment()), new Function1<State, BoxNoteEditModeReducer.State>() { // from class: com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer$special$$inlined$ifCaseLet$1
            @Override // kotlin.jvm.functions.Function1
            public final BoxNoteEditModeReducer.State invoke(BoxNotePreviewReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (!(it instanceof BoxNotePreviewReducer.State.Editing)) {
                    it = null;
                }
                BoxNotePreviewReducer.State.Editing editing = (BoxNotePreviewReducer.State.Editing) it;
                if (editing != null) {
                    return editing.getItem();
                }
                return null;
            }
        }, new Function1<Action, BoxNoteEditModeReducer.Action>() { // from class: com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer$special$$inlined$ifCaseLet$2
            @Override // kotlin.jvm.functions.Function1
            public final BoxNoteEditModeReducer.Action invoke(BoxNotePreviewReducer.Action action) {
                if (!(action instanceof BoxNotePreviewReducer.Action.EditModeAction)) {
                    action = null;
                }
                BoxNotePreviewReducer.Action.EditModeAction editModeAction = (BoxNotePreviewReducer.Action.EditModeAction) action;
                if (editModeAction != null) {
                    return editModeAction.getItem();
                }
                return null;
            }
        }, new Function2<State, BoxNoteEditModeReducer.State, State>() { // from class: com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer$special$$inlined$ifCaseLet$3
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final BoxNotePreviewReducer.State invoke(BoxNotePreviewReducer.State state, BoxNoteEditModeReducer.State state2) {
                Intrinsics.checkNotNullParameter(state, "<anonymous parameter 0>");
                Object objInvoke = boxNotePreviewReducer$build$2.invoke(state2);
                if (objInvoke != null) {
                    return (BoxNotePreviewReducer.State) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer.State");
            }
        }, new Function1<BoxNoteEditModeReducer.Action, Action>() { // from class: com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer$special$$inlined$ifCaseLet$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final BoxNotePreviewReducer.Action invoke(BoxNoteEditModeReducer.Action action) {
                Object objInvoke = boxNotePreviewReducer$build$3.invoke(action);
                if (objInvoke != null) {
                    return (BoxNotePreviewReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer.Action");
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: BoxNotePreviewReducer.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\u000f\u0010\u0011\u0012\u0013\u0014\u0015B\u001b\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nR\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n\u0082\u0001\u0007\u0016\u0017\u0018\u0019\u001a\u001b\u001c¨\u0006\u001d"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$State;", "", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "isConnected", "", "<init>", "(Lcom/box/android/domain/models/item/FileModel;Z)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "()Z", "withFile", "newFileModel", "withConnectionStatus", "isLoading", "Initializing", "Loading", "RefreshingSession", "EditorInitializing", "EditorReady", "Editing", "Error", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$State$Editing;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$State$EditorInitializing;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$State$EditorReady;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$State$Error;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$State$Initializing;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$State$Loading;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$State$RefreshingSession;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class State {
        public static final int $stable = 8;
        private final FileModel fileModel;
        private final boolean isConnected;
        private final boolean isLoading;

        public /* synthetic */ State(FileModel fileModel, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(fileModel, z);
        }

        public abstract State withConnectionStatus(boolean isConnected);

        public abstract State withFile(FileModel newFileModel);

        private State(FileModel fileModel, boolean z) {
            this.fileModel = fileModel;
            this.isConnected = z;
            this.isLoading = (this instanceof Initializing) || (this instanceof Loading) || (this instanceof RefreshingSession) || (this instanceof EditorInitializing);
        }

        public /* synthetic */ State(FileModel fileModel, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(fileModel, (i & 2) != 0 ? false : z, null);
        }

        public final FileModel getFileModel() {
            return this.fileModel;
        }

        /* JADX INFO: renamed from: isConnected, reason: from getter */
        public final boolean getIsConnected() {
            return this.isConnected;
        }

        /* JADX INFO: renamed from: isLoading, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        /* JADX INFO: compiled from: BoxNotePreviewReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\t\u0010\f\u001a\u00020\u0003HÂ\u0003J\t\u0010\r\u001a\u00020\u0005HÂ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$State$Initializing;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$State;", "file", "Lcom/box/android/domain/models/item/FileModel;", BoxNoteConstants.BOX_NOTE_VALUE_CONNECTED, "", "<init>", "(Lcom/box/android/domain/models/item/FileModel;Z)V", "withFile", "newFileModel", "withConnectionStatus", "isConnected", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Initializing extends State {
            public static final int $stable = 8;
            private final boolean connected;
            private final FileModel file;

            /* JADX INFO: renamed from: component1, reason: from getter */
            private final FileModel getFile() {
                return this.file;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            private final boolean getConnected() {
                return this.connected;
            }

            public static /* synthetic */ Initializing copy$default(Initializing initializing, FileModel fileModel, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileModel = initializing.file;
                }
                if ((i & 2) != 0) {
                    z = initializing.connected;
                }
                return initializing.copy(fileModel, z);
            }

            public final Initializing copy(FileModel file, boolean connected) {
                Intrinsics.checkNotNullParameter(file, "file");
                return new Initializing(file, connected);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Initializing)) {
                    return false;
                }
                Initializing initializing = (Initializing) other;
                return Intrinsics.areEqual(this.file, initializing.file) && this.connected == initializing.connected;
            }

            public int hashCode() {
                return (this.file.hashCode() * 31) + Boolean.hashCode(this.connected);
            }

            public String toString() {
                return "Initializing(file=" + this.file + ", connected=" + this.connected + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Initializing(FileModel file, boolean z) {
                super(file, z, null);
                Intrinsics.checkNotNullParameter(file, "file");
                this.file = file;
                this.connected = z;
            }

            @Override // com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer.State
            public State withFile(FileModel newFileModel) {
                Intrinsics.checkNotNullParameter(newFileModel, "newFileModel");
                return copy$default(this, newFileModel, false, 2, null);
            }

            @Override // com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer.State
            public State withConnectionStatus(boolean isConnected) {
                return copy$default(this, null, isConnected, 1, null);
            }
        }

        /* JADX INFO: compiled from: BoxNotePreviewReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0005H\u0016J\t\u0010\u000e\u001a\u00020\u0003HÂ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÂ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\tR\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$State$Loading;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$State;", "file", "Lcom/box/android/domain/models/item/FileModel;", "isRetrying", "", BoxNoteConstants.BOX_NOTE_VALUE_CONNECTED, "<init>", "(Lcom/box/android/domain/models/item/FileModel;ZZ)V", "()Z", "withFile", "newFileModel", "withConnectionStatus", "isConnected", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Loading extends State {
            public static final int $stable = 8;
            private final boolean connected;
            private final FileModel file;
            private final boolean isRetrying;

            /* JADX INFO: renamed from: component1, reason: from getter */
            private final FileModel getFile() {
                return this.file;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            private final boolean getConnected() {
                return this.connected;
            }

            public static /* synthetic */ Loading copy$default(Loading loading, FileModel fileModel, boolean z, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileModel = loading.file;
                }
                if ((i & 2) != 0) {
                    z = loading.isRetrying;
                }
                if ((i & 4) != 0) {
                    z2 = loading.connected;
                }
                return loading.copy(fileModel, z, z2);
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getIsRetrying() {
                return this.isRetrying;
            }

            public final Loading copy(FileModel file, boolean isRetrying, boolean connected) {
                Intrinsics.checkNotNullParameter(file, "file");
                return new Loading(file, isRetrying, connected);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loading)) {
                    return false;
                }
                Loading loading = (Loading) other;
                return Intrinsics.areEqual(this.file, loading.file) && this.isRetrying == loading.isRetrying && this.connected == loading.connected;
            }

            public int hashCode() {
                return (((this.file.hashCode() * 31) + Boolean.hashCode(this.isRetrying)) * 31) + Boolean.hashCode(this.connected);
            }

            public String toString() {
                return "Loading(file=" + this.file + ", isRetrying=" + this.isRetrying + ", connected=" + this.connected + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loading(FileModel file, boolean z, boolean z2) {
                super(file, z2, null);
                Intrinsics.checkNotNullParameter(file, "file");
                this.file = file;
                this.isRetrying = z;
                this.connected = z2;
            }

            public /* synthetic */ Loading(FileModel fileModel, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(fileModel, (i & 2) != 0 ? false : z, z2);
            }

            public final boolean isRetrying() {
                return this.isRetrying;
            }

            @Override // com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer.State
            public State withFile(FileModel newFileModel) {
                Intrinsics.checkNotNullParameter(newFileModel, "newFileModel");
                return copy$default(this, newFileModel, false, false, 6, null);
            }

            @Override // com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer.State
            public State withConnectionStatus(boolean isConnected) {
                return copy$default(this, null, false, isConnected, 3, null);
            }
        }

        /* JADX INFO: compiled from: BoxNotePreviewReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\t\u0010\f\u001a\u00020\u0003HÂ\u0003J\t\u0010\r\u001a\u00020\u0005HÂ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$State$RefreshingSession;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$State;", "file", "Lcom/box/android/domain/models/item/FileModel;", BoxNoteConstants.BOX_NOTE_VALUE_CONNECTED, "", "<init>", "(Lcom/box/android/domain/models/item/FileModel;Z)V", "withFile", "newFileModel", "withConnectionStatus", "isConnected", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RefreshingSession extends State {
            public static final int $stable = 8;
            private final boolean connected;
            private final FileModel file;

            /* JADX INFO: renamed from: component1, reason: from getter */
            private final FileModel getFile() {
                return this.file;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            private final boolean getConnected() {
                return this.connected;
            }

            public static /* synthetic */ RefreshingSession copy$default(RefreshingSession refreshingSession, FileModel fileModel, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileModel = refreshingSession.file;
                }
                if ((i & 2) != 0) {
                    z = refreshingSession.connected;
                }
                return refreshingSession.copy(fileModel, z);
            }

            public final RefreshingSession copy(FileModel file, boolean connected) {
                Intrinsics.checkNotNullParameter(file, "file");
                return new RefreshingSession(file, connected);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RefreshingSession)) {
                    return false;
                }
                RefreshingSession refreshingSession = (RefreshingSession) other;
                return Intrinsics.areEqual(this.file, refreshingSession.file) && this.connected == refreshingSession.connected;
            }

            public int hashCode() {
                return (this.file.hashCode() * 31) + Boolean.hashCode(this.connected);
            }

            public String toString() {
                return "RefreshingSession(file=" + this.file + ", connected=" + this.connected + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RefreshingSession(FileModel file, boolean z) {
                super(file, z, null);
                Intrinsics.checkNotNullParameter(file, "file");
                this.file = file;
                this.connected = z;
            }

            @Override // com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer.State
            public State withFile(FileModel newFileModel) {
                Intrinsics.checkNotNullParameter(newFileModel, "newFileModel");
                return copy$default(this, newFileModel, false, 2, null);
            }

            @Override // com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer.State
            public State withConnectionStatus(boolean isConnected) {
                return copy$default(this, null, isConnected, 1, null);
            }
        }

        /* JADX INFO: compiled from: BoxNotePreviewReducer.kt */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u0003H\u0016J\u0010\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\tH\u0016J\t\u0010\u001e\u001a\u00020\u0003HÂ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u0015\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\tHÂ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jg\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010'\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0005HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0015R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006-"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$State$EditorInitializing;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$State;", "file", "Lcom/box/android/domain/models/item/FileModel;", "noteUrl", "", "headers", "", "isReadOnly", "", BoxNoteConstants.BOX_NOTE_VALUE_CONNECTED, "editOnLoad", "permissionsChecked", "pendingEditorReadyAction", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$EditorReady;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;Ljava/lang/String;Ljava/util/Map;ZZZZLcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$EditorReady;)V", "getNoteUrl", "()Ljava/lang/String;", "getHeaders", "()Ljava/util/Map;", "()Z", "getEditOnLoad", "getPermissionsChecked", "getPendingEditorReadyAction", "()Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$EditorReady;", "withFile", "newFileModel", "withConnectionStatus", "isConnected", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class EditorInitializing extends State {
            public static final int $stable = 8;
            private final boolean connected;
            private final boolean editOnLoad;
            private final FileModel file;
            private final Map<String, String> headers;
            private final boolean isReadOnly;
            private final String noteUrl;
            private final Action.EditorReady pendingEditorReadyAction;
            private final boolean permissionsChecked;

            /* JADX INFO: renamed from: component1, reason: from getter */
            private final FileModel getFile() {
                return this.file;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            private final boolean getConnected() {
                return this.connected;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ EditorInitializing copy$default(EditorInitializing editorInitializing, FileModel fileModel, String str, Map map, boolean z, boolean z2, boolean z3, boolean z4, Action.EditorReady editorReady, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileModel = editorInitializing.file;
                }
                if ((i & 2) != 0) {
                    str = editorInitializing.noteUrl;
                }
                if ((i & 4) != 0) {
                    map = editorInitializing.headers;
                }
                if ((i & 8) != 0) {
                    z = editorInitializing.isReadOnly;
                }
                if ((i & 16) != 0) {
                    z2 = editorInitializing.connected;
                }
                if ((i & 32) != 0) {
                    z3 = editorInitializing.editOnLoad;
                }
                if ((i & 64) != 0) {
                    z4 = editorInitializing.permissionsChecked;
                }
                if ((i & 128) != 0) {
                    editorReady = editorInitializing.pendingEditorReadyAction;
                }
                boolean z5 = z4;
                Action.EditorReady editorReady2 = editorReady;
                boolean z6 = z2;
                boolean z7 = z3;
                return editorInitializing.copy(fileModel, str, map, z, z6, z7, z5, editorReady2);
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getNoteUrl() {
                return this.noteUrl;
            }

            public final Map<String, String> component3() {
                return this.headers;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getIsReadOnly() {
                return this.isReadOnly;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final boolean getEditOnLoad() {
                return this.editOnLoad;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final boolean getPermissionsChecked() {
                return this.permissionsChecked;
            }

            /* JADX INFO: renamed from: component8, reason: from getter */
            public final Action.EditorReady getPendingEditorReadyAction() {
                return this.pendingEditorReadyAction;
            }

            public final EditorInitializing copy(FileModel file, String noteUrl, Map<String, String> headers, boolean isReadOnly, boolean connected, boolean editOnLoad, boolean permissionsChecked, Action.EditorReady pendingEditorReadyAction) {
                Intrinsics.checkNotNullParameter(file, "file");
                Intrinsics.checkNotNullParameter(noteUrl, "noteUrl");
                Intrinsics.checkNotNullParameter(headers, "headers");
                return new EditorInitializing(file, noteUrl, headers, isReadOnly, connected, editOnLoad, permissionsChecked, pendingEditorReadyAction);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof EditorInitializing)) {
                    return false;
                }
                EditorInitializing editorInitializing = (EditorInitializing) other;
                return Intrinsics.areEqual(this.file, editorInitializing.file) && Intrinsics.areEqual(this.noteUrl, editorInitializing.noteUrl) && Intrinsics.areEqual(this.headers, editorInitializing.headers) && this.isReadOnly == editorInitializing.isReadOnly && this.connected == editorInitializing.connected && this.editOnLoad == editorInitializing.editOnLoad && this.permissionsChecked == editorInitializing.permissionsChecked && Intrinsics.areEqual(this.pendingEditorReadyAction, editorInitializing.pendingEditorReadyAction);
            }

            public int hashCode() {
                int iHashCode = ((((((((((((this.file.hashCode() * 31) + this.noteUrl.hashCode()) * 31) + this.headers.hashCode()) * 31) + Boolean.hashCode(this.isReadOnly)) * 31) + Boolean.hashCode(this.connected)) * 31) + Boolean.hashCode(this.editOnLoad)) * 31) + Boolean.hashCode(this.permissionsChecked)) * 31;
                Action.EditorReady editorReady = this.pendingEditorReadyAction;
                return iHashCode + (editorReady == null ? 0 : editorReady.hashCode());
            }

            public String toString() {
                return "EditorInitializing(file=" + this.file + ", noteUrl=" + this.noteUrl + ", headers=" + this.headers + ", isReadOnly=" + this.isReadOnly + ", connected=" + this.connected + ", editOnLoad=" + this.editOnLoad + ", permissionsChecked=" + this.permissionsChecked + ", pendingEditorReadyAction=" + this.pendingEditorReadyAction + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EditorInitializing(FileModel file, String noteUrl, Map<String, String> headers, boolean z, boolean z2, boolean z3, boolean z4, Action.EditorReady editorReady) {
                super(file, z2, null);
                Intrinsics.checkNotNullParameter(file, "file");
                Intrinsics.checkNotNullParameter(noteUrl, "noteUrl");
                Intrinsics.checkNotNullParameter(headers, "headers");
                this.file = file;
                this.noteUrl = noteUrl;
                this.headers = headers;
                this.isReadOnly = z;
                this.connected = z2;
                this.editOnLoad = z3;
                this.permissionsChecked = z4;
                this.pendingEditorReadyAction = editorReady;
            }

            public /* synthetic */ EditorInitializing(FileModel fileModel, String str, Map map, boolean z, boolean z2, boolean z3, boolean z4, Action.EditorReady editorReady, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(fileModel, str, map, z, z2, (i & 32) != 0 ? false : z3, (i & 64) != 0 ? false : z4, (i & 128) != 0 ? null : editorReady);
            }

            public final String getNoteUrl() {
                return this.noteUrl;
            }

            public final Map<String, String> getHeaders() {
                return this.headers;
            }

            public final boolean isReadOnly() {
                return this.isReadOnly;
            }

            public final boolean getEditOnLoad() {
                return this.editOnLoad;
            }

            public final boolean getPermissionsChecked() {
                return this.permissionsChecked;
            }

            public final Action.EditorReady getPendingEditorReadyAction() {
                return this.pendingEditorReadyAction;
            }

            @Override // com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer.State
            public State withFile(FileModel newFileModel) {
                Intrinsics.checkNotNullParameter(newFileModel, "newFileModel");
                return copy$default(this, newFileModel, null, null, false, false, false, false, null, 254, null);
            }

            @Override // com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer.State
            public State withConnectionStatus(boolean isConnected) {
                return copy$default(this, null, null, null, false, isConnected, false, false, null, 239, null);
            }
        }

        /* JADX INFO: compiled from: BoxNotePreviewReducer.kt */
        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0003H\u0016J\u0010\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J\t\u0010\u0017\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u0015\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÂ\u0003JQ\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0010R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$State$EditorReady;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$State;", "file", "Lcom/box/android/domain/models/item/FileModel;", "noteUrl", "", "isReadOnly", "", "headers", "", "isFocused", BoxNoteConstants.BOX_NOTE_VALUE_CONNECTED, "<init>", "(Lcom/box/android/domain/models/item/FileModel;Ljava/lang/String;ZLjava/util/Map;ZZ)V", "getNoteUrl", "()Ljava/lang/String;", "()Z", "getHeaders", "()Ljava/util/Map;", "withFile", "newFileModel", "withConnectionStatus", "isConnected", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class EditorReady extends State {
            public static final int $stable = 8;
            private final boolean connected;
            private final FileModel file;
            private final Map<String, String> headers;
            private final boolean isFocused;
            private final boolean isReadOnly;
            private final String noteUrl;

            /* JADX INFO: renamed from: component1, reason: from getter */
            private final FileModel getFile() {
                return this.file;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            private final boolean getConnected() {
                return this.connected;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ EditorReady copy$default(EditorReady editorReady, FileModel fileModel, String str, boolean z, Map map, boolean z2, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileModel = editorReady.file;
                }
                if ((i & 2) != 0) {
                    str = editorReady.noteUrl;
                }
                if ((i & 4) != 0) {
                    z = editorReady.isReadOnly;
                }
                if ((i & 8) != 0) {
                    map = editorReady.headers;
                }
                if ((i & 16) != 0) {
                    z2 = editorReady.isFocused;
                }
                if ((i & 32) != 0) {
                    z3 = editorReady.connected;
                }
                boolean z4 = z2;
                boolean z5 = z3;
                return editorReady.copy(fileModel, str, z, map, z4, z5);
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getNoteUrl() {
                return this.noteUrl;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getIsReadOnly() {
                return this.isReadOnly;
            }

            public final Map<String, String> component4() {
                return this.headers;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final boolean getIsFocused() {
                return this.isFocused;
            }

            public final EditorReady copy(FileModel file, String noteUrl, boolean isReadOnly, Map<String, String> headers, boolean isFocused, boolean connected) {
                Intrinsics.checkNotNullParameter(file, "file");
                Intrinsics.checkNotNullParameter(noteUrl, "noteUrl");
                Intrinsics.checkNotNullParameter(headers, "headers");
                return new EditorReady(file, noteUrl, isReadOnly, headers, isFocused, connected);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof EditorReady)) {
                    return false;
                }
                EditorReady editorReady = (EditorReady) other;
                return Intrinsics.areEqual(this.file, editorReady.file) && Intrinsics.areEqual(this.noteUrl, editorReady.noteUrl) && this.isReadOnly == editorReady.isReadOnly && Intrinsics.areEqual(this.headers, editorReady.headers) && this.isFocused == editorReady.isFocused && this.connected == editorReady.connected;
            }

            public int hashCode() {
                return (((((((((this.file.hashCode() * 31) + this.noteUrl.hashCode()) * 31) + Boolean.hashCode(this.isReadOnly)) * 31) + this.headers.hashCode()) * 31) + Boolean.hashCode(this.isFocused)) * 31) + Boolean.hashCode(this.connected);
            }

            public String toString() {
                return "EditorReady(file=" + this.file + ", noteUrl=" + this.noteUrl + ", isReadOnly=" + this.isReadOnly + ", headers=" + this.headers + ", isFocused=" + this.isFocused + ", connected=" + this.connected + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EditorReady(FileModel file, String noteUrl, boolean z, Map<String, String> headers, boolean z2, boolean z3) {
                super(file, z3, null);
                Intrinsics.checkNotNullParameter(file, "file");
                Intrinsics.checkNotNullParameter(noteUrl, "noteUrl");
                Intrinsics.checkNotNullParameter(headers, "headers");
                this.file = file;
                this.noteUrl = noteUrl;
                this.isReadOnly = z;
                this.headers = headers;
                this.isFocused = z2;
                this.connected = z3;
            }

            public final String getNoteUrl() {
                return this.noteUrl;
            }

            public final boolean isReadOnly() {
                return this.isReadOnly;
            }

            public /* synthetic */ EditorReady(FileModel fileModel, String str, boolean z, Map map, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(fileModel, str, z, (i & 8) != 0 ? MapsKt.emptyMap() : map, (i & 16) != 0 ? false : z2, z3);
            }

            public final Map<String, String> getHeaders() {
                return this.headers;
            }

            public final boolean isFocused() {
                return this.isFocused;
            }

            @Override // com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer.State
            public State withFile(FileModel newFileModel) {
                Intrinsics.checkNotNullParameter(newFileModel, "newFileModel");
                return copy$default(this, newFileModel, null, false, null, false, false, 62, null);
            }

            @Override // com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer.State
            public State withConnectionStatus(boolean isConnected) {
                return copy$default(this, null, null, false, null, false, isConnected, 31, null);
            }
        }

        /* JADX INFO: compiled from: BoxNotePreviewReducer.kt */
        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0016J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$State$Editing;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$State;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$State;", "editState", "<init>", "(Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$State;)V", "getEditState", "()Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$State;", "withFile", "newFileModel", "Lcom/box/android/domain/models/item/FileModel;", "withConnectionStatus", "isConnected", "", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Editing extends State implements Embedded<BoxNoteEditModeReducer.State> {
            public static final int $stable = 8;
            private final BoxNoteEditModeReducer.State editState;

            public static /* synthetic */ Editing copy$default(Editing editing, BoxNoteEditModeReducer.State state, int i, Object obj) {
                if ((i & 1) != 0) {
                    state = editing.editState;
                }
                return editing.copy(state);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BoxNoteEditModeReducer.State getItem() {
                return this.editState;
            }

            public final Editing copy(BoxNoteEditModeReducer.State editState) {
                Intrinsics.checkNotNullParameter(editState, "editState");
                return new Editing(editState);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Editing) && Intrinsics.areEqual(this.editState, ((Editing) other).editState);
            }

            public int hashCode() {
                return this.editState.hashCode();
            }

            public String toString() {
                return "Editing(editState=" + this.editState + ")";
            }

            public final BoxNoteEditModeReducer.State getEditState() {
                return this.editState;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Editing(BoxNoteEditModeReducer.State editState) {
                super(editState.getFile(), editState.getConnected(), null);
                Intrinsics.checkNotNullParameter(editState, "editState");
                this.editState = editState;
            }

            @Override // com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer.State
            public State withFile(FileModel newFileModel) {
                Intrinsics.checkNotNullParameter(newFileModel, "newFileModel");
                return copy(BoxNoteEditModeReducer.State.copy$default(this.editState, newFileModel, null, false, null, false, false, false, null, null, null, AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED, null));
            }

            @Override // com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer.State
            public State withConnectionStatus(boolean isConnected) {
                return copy(BoxNoteEditModeReducer.State.copy$default(this.editState, null, null, isConnected, null, false, false, false, null, null, null, 1019, null));
            }
        }

        /* JADX INFO: compiled from: BoxNotePreviewReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\t\u0010\u000f\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÂ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$State$Error;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$State;", "file", "Lcom/box/android/domain/models/item/FileModel;", "canRetry", "", BoxNoteConstants.BOX_NOTE_VALUE_CONNECTED, "<init>", "(Lcom/box/android/domain/models/item/FileModel;ZZ)V", "getCanRetry", "()Z", "withFile", "newFileModel", "withConnectionStatus", "isConnected", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Error extends State {
            public static final int $stable = 8;
            private final boolean canRetry;
            private final boolean connected;
            private final FileModel file;

            /* JADX INFO: renamed from: component1, reason: from getter */
            private final FileModel getFile() {
                return this.file;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            private final boolean getConnected() {
                return this.connected;
            }

            public static /* synthetic */ Error copy$default(Error error, FileModel fileModel, boolean z, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileModel = error.file;
                }
                if ((i & 2) != 0) {
                    z = error.canRetry;
                }
                if ((i & 4) != 0) {
                    z2 = error.connected;
                }
                return error.copy(fileModel, z, z2);
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getCanRetry() {
                return this.canRetry;
            }

            public final Error copy(FileModel file, boolean canRetry, boolean connected) {
                Intrinsics.checkNotNullParameter(file, "file");
                return new Error(file, canRetry, connected);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Error)) {
                    return false;
                }
                Error error = (Error) other;
                return Intrinsics.areEqual(this.file, error.file) && this.canRetry == error.canRetry && this.connected == error.connected;
            }

            public int hashCode() {
                return (((this.file.hashCode() * 31) + Boolean.hashCode(this.canRetry)) * 31) + Boolean.hashCode(this.connected);
            }

            public String toString() {
                return "Error(file=" + this.file + ", canRetry=" + this.canRetry + ", connected=" + this.connected + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(FileModel file, boolean z, boolean z2) {
                super(file, z2, null);
                Intrinsics.checkNotNullParameter(file, "file");
                this.file = file;
                this.canRetry = z;
                this.connected = z2;
            }

            public /* synthetic */ Error(FileModel fileModel, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(fileModel, (i & 2) != 0 ? false : z, z2);
            }

            public final boolean getCanRetry() {
                return this.canRetry;
            }

            @Override // com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer.State
            public State withFile(FileModel newFileModel) {
                Intrinsics.checkNotNullParameter(newFileModel, "newFileModel");
                return copy$default(this, newFileModel, false, false, 6, null);
            }

            @Override // com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer.State
            public State withConnectionStatus(boolean isConnected) {
                return copy$default(this, null, false, isConnected, 3, null);
            }
        }
    }

    /* JADX INFO: compiled from: BoxNotePreviewReducer.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u000f\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u000f\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !¨\u0006\""}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action;", "", "<init>", "()V", "Initialize", "LoadNote", "RefreshSession", "SessionRefreshFailed", "NoteUrlReady", "FilePermissionsResult", "EditorReady", "EditorFocusChanged", "KeyboardVisibilityChanged", "StartEditing", "StopEditing", "Error", "ConnectionStateChanged", "RetryLoad", "EditModeAction", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$ConnectionStateChanged;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$EditModeAction;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$EditorFocusChanged;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$EditorReady;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$Error;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$FilePermissionsResult;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$Initialize;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$KeyboardVisibilityChanged;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$LoadNote;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$NoteUrlReady;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$RefreshSession;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$RetryLoad;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$SessionRefreshFailed;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$StartEditing;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$StopEditing;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Action() {
        }

        /* JADX INFO: compiled from: BoxNotePreviewReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$Initialize;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "editOnLoad", "", "<init>", "(Lcom/box/android/domain/models/item/FileModel;Z)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "getEditOnLoad", "()Z", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Initialize extends Action {
            public static final int $stable = 8;
            private final boolean editOnLoad;
            private final FileModel fileModel;

            public static /* synthetic */ Initialize copy$default(Initialize initialize, FileModel fileModel, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileModel = initialize.fileModel;
                }
                if ((i & 2) != 0) {
                    z = initialize.editOnLoad;
                }
                return initialize.copy(fileModel, z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FileModel getFileModel() {
                return this.fileModel;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getEditOnLoad() {
                return this.editOnLoad;
            }

            public final Initialize copy(FileModel fileModel, boolean editOnLoad) {
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                return new Initialize(fileModel, editOnLoad);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Initialize)) {
                    return false;
                }
                Initialize initialize = (Initialize) other;
                return Intrinsics.areEqual(this.fileModel, initialize.fileModel) && this.editOnLoad == initialize.editOnLoad;
            }

            public int hashCode() {
                return (this.fileModel.hashCode() * 31) + Boolean.hashCode(this.editOnLoad);
            }

            public String toString() {
                return "Initialize(fileModel=" + this.fileModel + ", editOnLoad=" + this.editOnLoad + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Initialize(FileModel fileModel, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                this.fileModel = fileModel;
                this.editOnLoad = z;
            }

            public /* synthetic */ Initialize(FileModel fileModel, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(fileModel, (i & 2) != 0 ? false : z);
            }

            public final boolean getEditOnLoad() {
                return this.editOnLoad;
            }

            public final FileModel getFileModel() {
                return this.fileModel;
            }
        }

        /* JADX INFO: compiled from: BoxNotePreviewReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$LoadNote;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "attemptQuickLoad", "", "editOnLoad", "<init>", "(Lcom/box/android/domain/models/item/FileModel;ZZ)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "getAttemptQuickLoad", "()Z", "getEditOnLoad", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class LoadNote extends Action {
            public static final int $stable = 8;
            private final boolean attemptQuickLoad;
            private final boolean editOnLoad;
            private final FileModel fileModel;

            public static /* synthetic */ LoadNote copy$default(LoadNote loadNote, FileModel fileModel, boolean z, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileModel = loadNote.fileModel;
                }
                if ((i & 2) != 0) {
                    z = loadNote.attemptQuickLoad;
                }
                if ((i & 4) != 0) {
                    z2 = loadNote.editOnLoad;
                }
                return loadNote.copy(fileModel, z, z2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FileModel getFileModel() {
                return this.fileModel;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getAttemptQuickLoad() {
                return this.attemptQuickLoad;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getEditOnLoad() {
                return this.editOnLoad;
            }

            public final LoadNote copy(FileModel fileModel, boolean attemptQuickLoad, boolean editOnLoad) {
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                return new LoadNote(fileModel, attemptQuickLoad, editOnLoad);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LoadNote)) {
                    return false;
                }
                LoadNote loadNote = (LoadNote) other;
                return Intrinsics.areEqual(this.fileModel, loadNote.fileModel) && this.attemptQuickLoad == loadNote.attemptQuickLoad && this.editOnLoad == loadNote.editOnLoad;
            }

            public int hashCode() {
                return (((this.fileModel.hashCode() * 31) + Boolean.hashCode(this.attemptQuickLoad)) * 31) + Boolean.hashCode(this.editOnLoad);
            }

            public String toString() {
                return "LoadNote(fileModel=" + this.fileModel + ", attemptQuickLoad=" + this.attemptQuickLoad + ", editOnLoad=" + this.editOnLoad + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LoadNote(FileModel fileModel, boolean z, boolean z2) {
                super(null);
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                this.fileModel = fileModel;
                this.attemptQuickLoad = z;
                this.editOnLoad = z2;
            }

            public /* synthetic */ LoadNote(FileModel fileModel, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(fileModel, z, (i & 4) != 0 ? false : z2);
            }

            public final boolean getAttemptQuickLoad() {
                return this.attemptQuickLoad;
            }

            public final boolean getEditOnLoad() {
                return this.editOnLoad;
            }

            public final FileModel getFileModel() {
                return this.fileModel;
            }
        }

        /* JADX INFO: compiled from: BoxNotePreviewReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$RefreshSession;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "attemptQuickLoad", "", "editOnLoad", "<init>", "(Lcom/box/android/domain/models/item/FileModel;ZZ)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "getAttemptQuickLoad", "()Z", "getEditOnLoad", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RefreshSession extends Action {
            public static final int $stable = 8;
            private final boolean attemptQuickLoad;
            private final boolean editOnLoad;
            private final FileModel fileModel;

            public static /* synthetic */ RefreshSession copy$default(RefreshSession refreshSession, FileModel fileModel, boolean z, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileModel = refreshSession.fileModel;
                }
                if ((i & 2) != 0) {
                    z = refreshSession.attemptQuickLoad;
                }
                if ((i & 4) != 0) {
                    z2 = refreshSession.editOnLoad;
                }
                return refreshSession.copy(fileModel, z, z2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FileModel getFileModel() {
                return this.fileModel;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getAttemptQuickLoad() {
                return this.attemptQuickLoad;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getEditOnLoad() {
                return this.editOnLoad;
            }

            public final RefreshSession copy(FileModel fileModel, boolean attemptQuickLoad, boolean editOnLoad) {
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                return new RefreshSession(fileModel, attemptQuickLoad, editOnLoad);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RefreshSession)) {
                    return false;
                }
                RefreshSession refreshSession = (RefreshSession) other;
                return Intrinsics.areEqual(this.fileModel, refreshSession.fileModel) && this.attemptQuickLoad == refreshSession.attemptQuickLoad && this.editOnLoad == refreshSession.editOnLoad;
            }

            public int hashCode() {
                return (((this.fileModel.hashCode() * 31) + Boolean.hashCode(this.attemptQuickLoad)) * 31) + Boolean.hashCode(this.editOnLoad);
            }

            public String toString() {
                return "RefreshSession(fileModel=" + this.fileModel + ", attemptQuickLoad=" + this.attemptQuickLoad + ", editOnLoad=" + this.editOnLoad + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RefreshSession(FileModel fileModel, boolean z, boolean z2) {
                super(null);
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                this.fileModel = fileModel;
                this.attemptQuickLoad = z;
                this.editOnLoad = z2;
            }

            public /* synthetic */ RefreshSession(FileModel fileModel, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(fileModel, z, (i & 4) != 0 ? false : z2);
            }

            public final boolean getAttemptQuickLoad() {
                return this.attemptQuickLoad;
            }

            public final boolean getEditOnLoad() {
                return this.editOnLoad;
            }

            public final FileModel getFileModel() {
                return this.fileModel;
            }
        }

        /* JADX INFO: compiled from: BoxNotePreviewReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$SessionRefreshFailed;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SessionRefreshFailed extends Action {
            public static final int $stable = 8;
            private final FileModel fileModel;

            public static /* synthetic */ SessionRefreshFailed copy$default(SessionRefreshFailed sessionRefreshFailed, FileModel fileModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileModel = sessionRefreshFailed.fileModel;
                }
                return sessionRefreshFailed.copy(fileModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FileModel getFileModel() {
                return this.fileModel;
            }

            public final SessionRefreshFailed copy(FileModel fileModel) {
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                return new SessionRefreshFailed(fileModel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SessionRefreshFailed) && Intrinsics.areEqual(this.fileModel, ((SessionRefreshFailed) other).fileModel);
            }

            public int hashCode() {
                return this.fileModel.hashCode();
            }

            public String toString() {
                return "SessionRefreshFailed(fileModel=" + this.fileModel + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SessionRefreshFailed(FileModel fileModel) {
                super(null);
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                this.fileModel = fileModel;
            }

            public final FileModel getFileModel() {
                return this.fileModel;
            }
        }

        /* JADX INFO: compiled from: BoxNotePreviewReducer.kt */
        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003JG\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0013R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006!"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$NoteUrlReady;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "noteUrl", "", "headers", "", "isReadOnly", "", "editOnLoad", "<init>", "(Lcom/box/android/domain/models/item/FileModel;Ljava/lang/String;Ljava/util/Map;ZZ)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "getNoteUrl", "()Ljava/lang/String;", "getHeaders", "()Ljava/util/Map;", "()Z", "getEditOnLoad", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class NoteUrlReady extends Action {
            public static final int $stable = 8;
            private final boolean editOnLoad;
            private final FileModel fileModel;
            private final Map<String, String> headers;
            private final boolean isReadOnly;
            private final String noteUrl;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ NoteUrlReady copy$default(NoteUrlReady noteUrlReady, FileModel fileModel, String str, Map map, boolean z, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileModel = noteUrlReady.fileModel;
                }
                if ((i & 2) != 0) {
                    str = noteUrlReady.noteUrl;
                }
                if ((i & 4) != 0) {
                    map = noteUrlReady.headers;
                }
                if ((i & 8) != 0) {
                    z = noteUrlReady.isReadOnly;
                }
                if ((i & 16) != 0) {
                    z2 = noteUrlReady.editOnLoad;
                }
                boolean z3 = z2;
                Map map2 = map;
                return noteUrlReady.copy(fileModel, str, map2, z, z3);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FileModel getFileModel() {
                return this.fileModel;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getNoteUrl() {
                return this.noteUrl;
            }

            public final Map<String, String> component3() {
                return this.headers;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getIsReadOnly() {
                return this.isReadOnly;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final boolean getEditOnLoad() {
                return this.editOnLoad;
            }

            public final NoteUrlReady copy(FileModel fileModel, String noteUrl, Map<String, String> headers, boolean isReadOnly, boolean editOnLoad) {
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                Intrinsics.checkNotNullParameter(noteUrl, "noteUrl");
                Intrinsics.checkNotNullParameter(headers, "headers");
                return new NoteUrlReady(fileModel, noteUrl, headers, isReadOnly, editOnLoad);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NoteUrlReady)) {
                    return false;
                }
                NoteUrlReady noteUrlReady = (NoteUrlReady) other;
                return Intrinsics.areEqual(this.fileModel, noteUrlReady.fileModel) && Intrinsics.areEqual(this.noteUrl, noteUrlReady.noteUrl) && Intrinsics.areEqual(this.headers, noteUrlReady.headers) && this.isReadOnly == noteUrlReady.isReadOnly && this.editOnLoad == noteUrlReady.editOnLoad;
            }

            public int hashCode() {
                return (((((((this.fileModel.hashCode() * 31) + this.noteUrl.hashCode()) * 31) + this.headers.hashCode()) * 31) + Boolean.hashCode(this.isReadOnly)) * 31) + Boolean.hashCode(this.editOnLoad);
            }

            public String toString() {
                return "NoteUrlReady(fileModel=" + this.fileModel + ", noteUrl=" + this.noteUrl + ", headers=" + this.headers + ", isReadOnly=" + this.isReadOnly + ", editOnLoad=" + this.editOnLoad + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NoteUrlReady(FileModel fileModel, String noteUrl, Map<String, String> headers, boolean z, boolean z2) {
                super(null);
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                Intrinsics.checkNotNullParameter(noteUrl, "noteUrl");
                Intrinsics.checkNotNullParameter(headers, "headers");
                this.fileModel = fileModel;
                this.noteUrl = noteUrl;
                this.headers = headers;
                this.isReadOnly = z;
                this.editOnLoad = z2;
            }

            public /* synthetic */ NoteUrlReady(FileModel fileModel, String str, Map map, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(fileModel, str, map, z, (i & 16) != 0 ? false : z2);
            }

            public final FileModel getFileModel() {
                return this.fileModel;
            }

            public final String getNoteUrl() {
                return this.noteUrl;
            }

            public final Map<String, String> getHeaders() {
                return this.headers;
            }

            public final boolean isReadOnly() {
                return this.isReadOnly;
            }

            public final boolean getEditOnLoad() {
                return this.editOnLoad;
            }
        }

        /* JADX INFO: compiled from: BoxNotePreviewReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$FilePermissionsResult;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "isReadOnly", "", "<init>", "(Lcom/box/android/domain/models/item/FileModel;Z)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "()Z", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FilePermissionsResult extends Action {
            public static final int $stable = 8;
            private final FileModel fileModel;
            private final boolean isReadOnly;

            public static /* synthetic */ FilePermissionsResult copy$default(FilePermissionsResult filePermissionsResult, FileModel fileModel, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileModel = filePermissionsResult.fileModel;
                }
                if ((i & 2) != 0) {
                    z = filePermissionsResult.isReadOnly;
                }
                return filePermissionsResult.copy(fileModel, z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FileModel getFileModel() {
                return this.fileModel;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getIsReadOnly() {
                return this.isReadOnly;
            }

            public final FilePermissionsResult copy(FileModel fileModel, boolean isReadOnly) {
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                return new FilePermissionsResult(fileModel, isReadOnly);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FilePermissionsResult)) {
                    return false;
                }
                FilePermissionsResult filePermissionsResult = (FilePermissionsResult) other;
                return Intrinsics.areEqual(this.fileModel, filePermissionsResult.fileModel) && this.isReadOnly == filePermissionsResult.isReadOnly;
            }

            public int hashCode() {
                return (this.fileModel.hashCode() * 31) + Boolean.hashCode(this.isReadOnly);
            }

            public String toString() {
                return "FilePermissionsResult(fileModel=" + this.fileModel + ", isReadOnly=" + this.isReadOnly + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FilePermissionsResult(FileModel fileModel, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                this.fileModel = fileModel;
                this.isReadOnly = z;
            }

            public final FileModel getFileModel() {
                return this.fileModel;
            }

            public final boolean isReadOnly() {
                return this.isReadOnly;
            }
        }

        /* JADX INFO: compiled from: BoxNotePreviewReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$EditorReady;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action;", "loadDurationMillis", "", "<init>", "(J)V", "getLoadDurationMillis", "()J", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class EditorReady extends Action {
            public static final int $stable = 0;
            private final long loadDurationMillis;

            public static /* synthetic */ EditorReady copy$default(EditorReady editorReady, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = editorReady.loadDurationMillis;
                }
                return editorReady.copy(j);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getLoadDurationMillis() {
                return this.loadDurationMillis;
            }

            public final EditorReady copy(long loadDurationMillis) {
                return new EditorReady(loadDurationMillis);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof EditorReady) && this.loadDurationMillis == ((EditorReady) other).loadDurationMillis;
            }

            public int hashCode() {
                return Long.hashCode(this.loadDurationMillis);
            }

            public String toString() {
                return "EditorReady(loadDurationMillis=" + this.loadDurationMillis + ")";
            }

            public EditorReady(long j) {
                super(null);
                this.loadDurationMillis = j;
            }

            public final long getLoadDurationMillis() {
                return this.loadDurationMillis;
            }
        }

        /* JADX INFO: compiled from: BoxNotePreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$EditorFocusChanged;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action;", "isFocused", "", "<init>", "(Z)V", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class EditorFocusChanged extends Action {
            public static final int $stable = 0;
            private final boolean isFocused;

            public static /* synthetic */ EditorFocusChanged copy$default(EditorFocusChanged editorFocusChanged, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = editorFocusChanged.isFocused;
                }
                return editorFocusChanged.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getIsFocused() {
                return this.isFocused;
            }

            public final EditorFocusChanged copy(boolean isFocused) {
                return new EditorFocusChanged(isFocused);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof EditorFocusChanged) && this.isFocused == ((EditorFocusChanged) other).isFocused;
            }

            public int hashCode() {
                return Boolean.hashCode(this.isFocused);
            }

            public String toString() {
                return "EditorFocusChanged(isFocused=" + this.isFocused + ")";
            }

            public EditorFocusChanged(boolean z) {
                super(null);
                this.isFocused = z;
            }

            public final boolean isFocused() {
                return this.isFocused;
            }
        }

        /* JADX INFO: compiled from: BoxNotePreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$KeyboardVisibilityChanged;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action;", "isVisible", "", "<init>", "(Z)V", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class KeyboardVisibilityChanged extends Action {
            public static final int $stable = 0;
            private final boolean isVisible;

            public static /* synthetic */ KeyboardVisibilityChanged copy$default(KeyboardVisibilityChanged keyboardVisibilityChanged, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = keyboardVisibilityChanged.isVisible;
                }
                return keyboardVisibilityChanged.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getIsVisible() {
                return this.isVisible;
            }

            public final KeyboardVisibilityChanged copy(boolean isVisible) {
                return new KeyboardVisibilityChanged(isVisible);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof KeyboardVisibilityChanged) && this.isVisible == ((KeyboardVisibilityChanged) other).isVisible;
            }

            public int hashCode() {
                return Boolean.hashCode(this.isVisible);
            }

            public String toString() {
                return "KeyboardVisibilityChanged(isVisible=" + this.isVisible + ")";
            }

            public KeyboardVisibilityChanged(boolean z) {
                super(null);
                this.isVisible = z;
            }

            public final boolean isVisible() {
                return this.isVisible;
            }
        }

        /* JADX INFO: compiled from: BoxNotePreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$StartEditing;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class StartEditing extends Action {
            public static final int $stable = 0;
            public static final StartEditing INSTANCE = new StartEditing();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof StartEditing)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1406474161;
            }

            public String toString() {
                return "StartEditing";
            }

            private StartEditing() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BoxNotePreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$StopEditing;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class StopEditing extends Action {
            public static final int $stable = 0;
            public static final StopEditing INSTANCE = new StopEditing();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof StopEditing)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 726456989;
            }

            public String toString() {
                return "StopEditing";
            }

            private StopEditing() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BoxNotePreviewReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$Error;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

        /* JADX INFO: compiled from: BoxNotePreviewReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$ConnectionStateChanged;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action;", "value", "", BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_REASON, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "getReason", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ConnectionStateChanged extends Action {
            public static final int $stable = 0;
            private final String reason;
            private final String value;

            public static /* synthetic */ ConnectionStateChanged copy$default(ConnectionStateChanged connectionStateChanged, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = connectionStateChanged.value;
                }
                if ((i & 2) != 0) {
                    str2 = connectionStateChanged.reason;
                }
                return connectionStateChanged.copy(str, str2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getValue() {
                return this.value;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getReason() {
                return this.reason;
            }

            public final ConnectionStateChanged copy(String value, String reason) {
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(reason, "reason");
                return new ConnectionStateChanged(value, reason);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ConnectionStateChanged)) {
                    return false;
                }
                ConnectionStateChanged connectionStateChanged = (ConnectionStateChanged) other;
                return Intrinsics.areEqual(this.value, connectionStateChanged.value) && Intrinsics.areEqual(this.reason, connectionStateChanged.reason);
            }

            public int hashCode() {
                return (this.value.hashCode() * 31) + this.reason.hashCode();
            }

            public String toString() {
                return "ConnectionStateChanged(value=" + this.value + ", reason=" + this.reason + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ConnectionStateChanged(String value, String reason) {
                super(null);
                Intrinsics.checkNotNullParameter(value, "value");
                Intrinsics.checkNotNullParameter(reason, "reason");
                this.value = value;
                this.reason = reason;
            }

            public final String getReason() {
                return this.reason;
            }

            public final String getValue() {
                return this.value;
            }
        }

        /* JADX INFO: compiled from: BoxNotePreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$RetryLoad;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RetryLoad extends Action {
            public static final int $stable = 0;
            public static final RetryLoad INSTANCE = new RetryLoad();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RetryLoad)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1298624725;
            }

            public String toString() {
                return "RetryLoad";
            }

            private RetryLoad() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BoxNotePreviewReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action$EditModeAction;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action;", "editModeAction", "<init>", "(Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action;)V", "getEditModeAction", "()Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class EditModeAction extends Action implements Embedded<BoxNoteEditModeReducer.Action> {
            public static final int $stable = 0;
            private final BoxNoteEditModeReducer.Action editModeAction;

            public static /* synthetic */ EditModeAction copy$default(EditModeAction editModeAction, BoxNoteEditModeReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = editModeAction.editModeAction;
                }
                return editModeAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BoxNoteEditModeReducer.Action getItem() {
                return this.editModeAction;
            }

            public final EditModeAction copy(BoxNoteEditModeReducer.Action editModeAction) {
                Intrinsics.checkNotNullParameter(editModeAction, "editModeAction");
                return new EditModeAction(editModeAction);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof EditModeAction) && Intrinsics.areEqual(this.editModeAction, ((EditModeAction) other).editModeAction);
            }

            public int hashCode() {
                return this.editModeAction.hashCode();
            }

            public String toString() {
                return "EditModeAction(editModeAction=" + this.editModeAction + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EditModeAction(BoxNoteEditModeReducer.Action editModeAction) {
                super(null);
                Intrinsics.checkNotNullParameter(editModeAction, "editModeAction");
                this.editModeAction = editModeAction;
            }

            public final BoxNoteEditModeReducer.Action getEditModeAction() {
                return this.editModeAction;
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReducerResult<State, Action> reduceBoxNote(State state, Action action) {
        if (action instanceof Action.Initialize) {
            return handleInitialize(state, (Action.Initialize) action);
        }
        if (action instanceof Action.LoadNote) {
            return handleLoadNote(state, (Action.LoadNote) action);
        }
        if (action instanceof Action.RefreshSession) {
            return handleSessionRefreshed(state, (Action.RefreshSession) action);
        }
        if (action instanceof Action.SessionRefreshFailed) {
            return handleSessionRefreshFailed(state, (Action.SessionRefreshFailed) action);
        }
        if (action instanceof Action.NoteUrlReady) {
            return handleNoteUrlReady(state, (Action.NoteUrlReady) action);
        }
        if (action instanceof Action.EditorReady) {
            return handleEditorReady(state, (Action.EditorReady) action);
        }
        if (action instanceof Action.EditorFocusChanged) {
            return handleEditorFocusChanged(state, (Action.EditorFocusChanged) action);
        }
        if (action instanceof Action.KeyboardVisibilityChanged) {
            return handleKeyboardVisibilityChanged(state, (Action.KeyboardVisibilityChanged) action);
        }
        if (action instanceof Action.StartEditing) {
            return handleStartEditing(state);
        }
        if (action instanceof Action.StopEditing) {
            return handleStopEditing(state);
        }
        if (action instanceof Action.Error) {
            return handleError(state);
        }
        if (action instanceof Action.ConnectionStateChanged) {
            return handleConnectionStateChanged(state, (Action.ConnectionStateChanged) action);
        }
        if (action instanceof Action.RetryLoad) {
            return handleRetryLoad(state);
        }
        if (action instanceof Action.FilePermissionsResult) {
            return handleFilePermissionsResult(state, (Action.FilePermissionsResult) action);
        }
        if (action instanceof Action.EditModeAction) {
            return new ReducerResult<>(state, null, 2, null);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final ReducerResult<State, Action> handleInitialize(State state, Action.Initialize action) {
        return new ReducerResult<>(state, new Effect(new Action.LoadNote(action.getFileModel(), true, action.getEditOnLoad())));
    }

    private final ReducerResult<State, Action> handleLoadNote(State state, Action.LoadNote action) {
        return new ReducerResult<>(new State.Loading(action.getFileModel(), false, state.getIsConnected(), 2, null), EffectKt.toEffect(FlowKt.flowOn(FlowKt.flow(new BoxNotePreviewReducer$handleLoadNote$effect$1(this, action, null)), Dispatchers.getIO())));
    }

    private final ReducerResult<State, Action> handleSessionRefreshed(State state, Action.RefreshSession action) {
        return new ReducerResult<>(new State.RefreshingSession(action.getFileModel(), state.getIsConnected()), EffectKt.toEffect(FlowKt.flow(new BoxNotePreviewReducer$handleSessionRefreshed$effect$1(this, action, null))));
    }

    private final ReducerResult<State, Action> handleSessionRefreshFailed(State state, Action.SessionRefreshFailed action) {
        return new ReducerResult<>(new State.Error(action.getFileModel(), false, state.getIsConnected()), null, 2, null);
    }

    private final ReducerResult<State, Action> handleNoteUrlReady(State state, Action.NoteUrlReady action) {
        return new ReducerResult<>(new State.EditorInitializing(action.getFileModel(), action.getNoteUrl(), action.getHeaders(), action.isReadOnly(), state.getIsConnected(), action.getEditOnLoad(), false, null, 192, null), null, 2, null);
    }

    private final ReducerResult<State, Action> handleEditorReady(State state, Action.EditorReady action) {
        if (state instanceof State.EditorInitializing) {
            State.EditorInitializing editorInitializing = (State.EditorInitializing) state;
            if (editorInitializing.getPermissionsChecked()) {
                return transitionToEditorReady(editorInitializing, action);
            }
            return new ReducerResult<>(State.EditorInitializing.copy$default(editorInitializing, null, null, null, false, false, false, false, action, 127, null), null, 2, null);
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private final ReducerResult<State, Action> handleFilePermissionsResult(State state, Action.FilePermissionsResult action) {
        if (state instanceof State.EditorInitializing) {
            State.EditorInitializing editorInitializing = (State.EditorInitializing) state;
            State.EditorInitializing editorInitializingCopy$default = State.EditorInitializing.copy$default(editorInitializing, action.getFileModel(), null, null, action.isReadOnly(), false, false, true, null, 182, null);
            Action.EditorReady pendingEditorReadyAction = editorInitializing.getPendingEditorReadyAction();
            if (pendingEditorReadyAction != null) {
                return transitionToEditorReady(editorInitializingCopy$default, pendingEditorReadyAction);
            }
            return new ReducerResult<>(editorInitializingCopy$default, null, 2, null);
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private final ReducerResult<State, Action> transitionToEditorReady(State.EditorInitializing state, Action.EditorReady action) {
        State.EditorReady editorReady = new State.EditorReady(state.getFileModel(), state.getNoteUrl(), state.isReadOnly(), state.getHeaders(), false, state.getIsConnected());
        Effect.Companion companion = Effect.INSTANCE;
        Effect[] effectArr = new Effect[2];
        effectArr[0] = Effect.INSTANCE.fireAndForget(new AnonymousClass1(action, this, state, null));
        effectArr[1] = state.getEditOnLoad() ? new Effect(Action.StartEditing.INSTANCE) : Effect.INSTANCE.none();
        return new ReducerResult<>(editorReady, companion.merge(effectArr));
    }

    /* JADX INFO: renamed from: com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer$transitionToEditorReady$1, reason: invalid class name */
    /* JADX INFO: compiled from: BoxNotePreviewReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer$transitionToEditorReady$1", f = "BoxNotePreviewReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Action.EditorReady $action;
        final /* synthetic */ State.EditorInitializing $state;
        int label;
        final /* synthetic */ BoxNotePreviewReducer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Action.EditorReady editorReady, BoxNotePreviewReducer boxNotePreviewReducer, State.EditorInitializing editorInitializing, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$action = editorReady;
            this.this$0 = boxNotePreviewReducer;
            this.$state = editorInitializing;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.$action, this.this$0, this.$state, continuation);
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
            BoxLogUtils.d(BoxNoteConstants.LOG_TAG, "Time to load box note (in ms): " + this.$action.getLoadDurationMillis());
            BoxAnalytics.INSTANCE.trackEvent("boxnote", "open", "load_time", Boxing.boxLong(this.$action.getLoadDurationMillis()));
            this.this$0.environment.getPreviewAnalytics().noteOpened(this.$state.getFileModel());
            return Unit.INSTANCE;
        }
    }

    private final ReducerResult<State, Action> handleEditorFocusChanged(State state, Action.EditorFocusChanged action) {
        if (state instanceof State.EditorReady) {
            return new ReducerResult<>(State.EditorReady.copy$default((State.EditorReady) state, null, null, false, null, action.isFocused(), false, 47, null), action.isFocused() ? new Effect(Action.StartEditing.INSTANCE) : Effect.INSTANCE.none());
        }
        if (state instanceof State.Editing) {
            return new ReducerResult<>(state, !action.isFocused() ? new Effect(Action.StopEditing.INSTANCE) : Effect.INSTANCE.none());
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private final ReducerResult<State, Action> handleKeyboardVisibilityChanged(State state, Action.KeyboardVisibilityChanged action) {
        Effect effectNone;
        Effect effectNone2;
        if (state instanceof State.EditorReady) {
            if (action.isVisible() && ((State.EditorReady) state).isFocused()) {
                effectNone2 = new Effect(Action.StartEditing.INSTANCE);
            } else {
                effectNone2 = Effect.INSTANCE.none();
            }
            return new ReducerResult<>(state, effectNone2);
        }
        if (state instanceof State.Editing) {
            if (action.isVisible()) {
                effectNone = new Effect(new Action.EditModeAction(BoxNoteEditModeReducer.Action.RequestFocus.INSTANCE));
            } else {
                effectNone = Effect.INSTANCE.none();
            }
            return new ReducerResult<>(state, effectNone);
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private final ReducerResult<State, Action> handleStartEditing(State state) {
        if (state instanceof State.EditorReady) {
            State.EditorReady editorReady = (State.EditorReady) state;
            if (!editorReady.isReadOnly()) {
                return new ReducerResult<>(new State.Editing(new BoxNoteEditModeReducer.State(state.getFileModel(), editorReady.getNoteUrl(), state.getIsConnected(), editorReady.getHeaders(), false, false, false, null, null, null, 1008, null)), new Effect(new Action.EditModeAction(BoxNoteEditModeReducer.Action.Initialize.INSTANCE)));
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private final ReducerResult<State, Action> handleStopEditing(State state) {
        if (state instanceof State.Editing) {
            State.Editing editing = (State.Editing) state;
            return new ReducerResult<>(new State.EditorReady(state.getFileModel(), editing.getEditState().getNoteUrl(), false, editing.getEditState().getHeaders(), false, state.getIsConnected()), null, 2, null);
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private final ReducerResult<State, Action> handleError(State state) {
        return new ReducerResult<>(new State.Error(state.getFileModel(), false, state.getIsConnected()), null, 2, null);
    }

    private final ReducerResult<State, Action> handleConnectionStateChanged(State state, Action.ConnectionStateChanged action) {
        boolean zAreEqual = Intrinsics.areEqual(action.getValue(), BoxNoteConstants.BOX_NOTE_VALUE_CONNECTED);
        if (Intrinsics.areEqual(action.getValue(), BoxNoteConstants.BOX_NOTE_VALUE_DISCONNECTED) && Intrinsics.areEqual(action.getReason(), BoxNoteConstants.BOX_NOTE_VALUE_INITIAL_AUTH_ERROR)) {
            if (state instanceof State.EditorInitializing) {
                return new ReducerResult<>(new State.Loading(state.getFileModel(), true, false), EffectKt.toEffect(FlowKt.flow(new BoxNotePreviewReducer$handleConnectionStateChanged$effect$1(state, null))));
            }
            return new ReducerResult<>(state.withConnectionStatus(false), null, 2, null);
        }
        return new ReducerResult<>(state.withConnectionStatus(zAreEqual), null, 2, null);
    }

    private final ReducerResult<State, Action> handleRetryLoad(State state) {
        if (state instanceof State.Error) {
            if (((State.Error) state).getCanRetry()) {
                return new ReducerResult<>(new State.Loading(state.getFileModel(), true, state.getIsConnected()), EffectKt.toEffect(FlowKt.flow(new BoxNotePreviewReducer$handleRetryLoad$effect$1(state, null))));
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        return new ReducerResult<>(state, null, 2, null);
    }
}

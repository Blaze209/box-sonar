package com.box.android.preview.previewtype.code;

import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.item.FileModel;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.pspdfkit.analytics.Analytics;
import java.net.URI;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: CodePreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0012\u0013\u0014B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0003H\u0002J\u0016\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/preview/previewtype/code/CodePreviewReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/preview/previewtype/code/CodePreviewReducer$State;", "Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Action;", "environment", "Lcom/box/android/preview/previewtype/code/CodePreviewEnvironment;", "<init>", "(Lcom/box/android/preview/previewtype/code/CodePreviewEnvironment;)V", "build", "Lcom/box/android/cpl/Reduce;", "getBuild", "()Lcom/box/android/cpl/Reduce;", "reduceCodePreview", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "initCodePreview", "(Lcom/box/android/preview/previewtype/code/CodePreviewReducer$State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "State", "Action", AuthenticationConstants.BUNDLE_MESSAGE, "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CodePreviewReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reduce<State, Action> build;
    private final CodePreviewEnvironment environment;

    /* JADX INFO: compiled from: CodePreviewReducer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Message;", "", "<init>", "(Ljava/lang/String;I)V", "CODE_PREVIEW_TOO_LARGE", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum Message {
        CODE_PREVIEW_TOO_LARGE;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Message> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: renamed from: com.box.android.preview.previewtype.code.CodePreviewReducer$initCodePreview$1, reason: invalid class name */
    /* JADX INFO: compiled from: CodePreviewReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.previewtype.code.CodePreviewReducer", f = "CodePreviewReducer.kt", i = {0}, l = {52}, m = "initCodePreview", n = {"state"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CodePreviewReducer.this.initCodePreview(null, this);
        }
    }

    public CodePreviewReducer(CodePreviewEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        this.build = new Reduce<>(new CodePreviewReducer$build$1(this));
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: CodePreviewReducer.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÆ\u0003J=\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0016¨\u0006\""}, d2 = {"Lcom/box/android/preview/previewtype/code/CodePreviewReducer$State;", "", "file", "Lcom/box/android/domain/models/item/FileModel;", "uri", "Ljava/net/URI;", "fileContent", "", "message", "Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Message;", "isPreviewLoaded", "", "<init>", "(Lcom/box/android/domain/models/item/FileModel;Ljava/net/URI;Ljava/lang/String;Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Message;Z)V", "getFile", "()Lcom/box/android/domain/models/item/FileModel;", "getUri", "()Ljava/net/URI;", "getFileContent", "()Ljava/lang/String;", "getMessage", "()Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Message;", "()Z", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final FileModel file;
        private final String fileContent;
        private final boolean isPreviewLoaded;
        private final Message message;
        private final URI uri;

        public static /* synthetic */ State copy$default(State state, FileModel fileModel, URI uri, String str, Message message, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                fileModel = state.file;
            }
            if ((i & 2) != 0) {
                uri = state.uri;
            }
            if ((i & 4) != 0) {
                str = state.fileContent;
            }
            if ((i & 8) != 0) {
                message = state.message;
            }
            if ((i & 16) != 0) {
                z = state.isPreviewLoaded;
            }
            boolean z2 = z;
            String str2 = str;
            return state.copy(fileModel, uri, str2, message, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FileModel getFile() {
            return this.file;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final URI getUri() {
            return this.uri;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getFileContent() {
            return this.fileContent;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Message getMessage() {
            return this.message;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsPreviewLoaded() {
            return this.isPreviewLoaded;
        }

        public final State copy(FileModel file, URI uri, String fileContent, Message message, boolean isPreviewLoaded) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(uri, "uri");
            Intrinsics.checkNotNullParameter(fileContent, "fileContent");
            return new State(file, uri, fileContent, message, isPreviewLoaded);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.file, state.file) && Intrinsics.areEqual(this.uri, state.uri) && Intrinsics.areEqual(this.fileContent, state.fileContent) && this.message == state.message && this.isPreviewLoaded == state.isPreviewLoaded;
        }

        public int hashCode() {
            int iHashCode = ((((this.file.hashCode() * 31) + this.uri.hashCode()) * 31) + this.fileContent.hashCode()) * 31;
            Message message = this.message;
            return ((iHashCode + (message == null ? 0 : message.hashCode())) * 31) + Boolean.hashCode(this.isPreviewLoaded);
        }

        public String toString() {
            return "State(file=" + this.file + ", uri=" + this.uri + ", fileContent=" + this.fileContent + ", message=" + this.message + ", isPreviewLoaded=" + this.isPreviewLoaded + ")";
        }

        public State(FileModel file, URI uri, String fileContent, Message message, boolean z) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(uri, "uri");
            Intrinsics.checkNotNullParameter(fileContent, "fileContent");
            this.file = file;
            this.uri = uri;
            this.fileContent = fileContent;
            this.message = message;
            this.isPreviewLoaded = z;
        }

        public final FileModel getFile() {
            return this.file;
        }

        public final URI getUri() {
            return this.uri;
        }

        public /* synthetic */ State(FileModel fileModel, URI uri, String str, Message message, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(fileModel, uri, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? null : message, (i & 16) != 0 ? false : z);
        }

        public final String getFileContent() {
            return this.fileContent;
        }

        public final Message getMessage() {
            return this.message;
        }

        public final boolean isPreviewLoaded() {
            return this.isPreviewLoaded;
        }
    }

    /* JADX INFO: compiled from: CodePreviewReducer.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Action;", "", "<init>", "()V", "Init", "OnInitialised", "OnPreviewLoaded", "OnPreviewScrolled", "OnPreviewPressed", "MessageShown", "Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Action$Init;", "Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Action$MessageShown;", "Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Action$OnInitialised;", "Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Action$OnPreviewLoaded;", "Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Action$OnPreviewPressed;", "Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Action$OnPreviewScrolled;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: CodePreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Action$Init;", "Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Init extends Action {
            public static final int $stable = 0;
            public static final Init INSTANCE = new Init();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Init)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1813440981;
            }

            public String toString() {
                return "Init";
            }

            private Init() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: CodePreviewReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Action$OnInitialised;", "Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Action;", "content", "", "message", "Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Message;", "<init>", "(Ljava/lang/String;Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Message;)V", "getContent", "()Ljava/lang/String;", "getMessage", "()Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Message;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class OnInitialised extends Action {
            public static final int $stable = 0;
            private final String content;
            private final Message message;

            public static /* synthetic */ OnInitialised copy$default(OnInitialised onInitialised, String str, Message message, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = onInitialised.content;
                }
                if ((i & 2) != 0) {
                    message = onInitialised.message;
                }
                return onInitialised.copy(str, message);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getContent() {
                return this.content;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Message getMessage() {
                return this.message;
            }

            public final OnInitialised copy(String content, Message message) {
                Intrinsics.checkNotNullParameter(content, "content");
                return new OnInitialised(content, message);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof OnInitialised)) {
                    return false;
                }
                OnInitialised onInitialised = (OnInitialised) other;
                return Intrinsics.areEqual(this.content, onInitialised.content) && this.message == onInitialised.message;
            }

            public int hashCode() {
                int iHashCode = this.content.hashCode() * 31;
                Message message = this.message;
                return iHashCode + (message == null ? 0 : message.hashCode());
            }

            public String toString() {
                return "OnInitialised(content=" + this.content + ", message=" + this.message + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OnInitialised(String content, Message message) {
                super(null);
                Intrinsics.checkNotNullParameter(content, "content");
                this.content = content;
                this.message = message;
            }

            public final String getContent() {
                return this.content;
            }

            public final Message getMessage() {
                return this.message;
            }
        }

        /* JADX INFO: compiled from: CodePreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Action$OnPreviewLoaded;", "Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class OnPreviewLoaded extends Action {
            public static final int $stable = 0;
            public static final OnPreviewLoaded INSTANCE = new OnPreviewLoaded();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof OnPreviewLoaded)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1552544173;
            }

            public String toString() {
                return "OnPreviewLoaded";
            }

            private OnPreviewLoaded() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CodePreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Action$OnPreviewScrolled;", "Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class OnPreviewScrolled extends Action {
            public static final int $stable = 0;
            public static final OnPreviewScrolled INSTANCE = new OnPreviewScrolled();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof OnPreviewScrolled)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 405403386;
            }

            public String toString() {
                return "OnPreviewScrolled";
            }

            private OnPreviewScrolled() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CodePreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Action$OnPreviewPressed;", "Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class OnPreviewPressed extends Action {
            public static final int $stable = 0;
            public static final OnPreviewPressed INSTANCE = new OnPreviewPressed();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof OnPreviewPressed)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1539139692;
            }

            public String toString() {
                return "OnPreviewPressed";
            }

            private OnPreviewPressed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CodePreviewReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Action$MessageShown;", "Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class MessageShown extends Action {
            public static final int $stable = 0;
            public static final MessageShown INSTANCE = new MessageShown();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof MessageShown)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1822955675;
            }

            public String toString() {
                return "MessageShown";
            }

            private MessageShown() {
                super(null);
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: renamed from: com.box.android.preview.previewtype.code.CodePreviewReducer$reduceCodePreview$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CodePreviewReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.previewtype.code.CodePreviewReducer$reduceCodePreview$1", f = "CodePreviewReducer.kt", i = {0, 1}, l = {45, 45}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"}, v = 1)
    static final class C17041 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ State $state;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C17041(State state, Continuation<? super C17041> continuation) {
            super(2, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C17041 c17041 = CodePreviewReducer.this.new C17041(this.$state, continuation);
            c17041.L$0 = obj;
            return c17041;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((C17041) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0054, code lost:
        
            if (r2.emit(r8, r7) == r1) goto L16;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = r7.L$0
                kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r7.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L26
                if (r2 == r4) goto L1e
                if (r2 != r3) goto L16
                kotlin.ResultKt.throwOnFailure(r8)
                goto L57
            L16:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L1e:
                java.lang.Object r2 = r7.L$1
                kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
                kotlin.ResultKt.throwOnFailure(r8)
                goto L42
            L26:
                kotlin.ResultKt.throwOnFailure(r8)
                com.box.android.preview.previewtype.code.CodePreviewReducer r8 = com.box.android.preview.previewtype.code.CodePreviewReducer.this
                com.box.android.preview.previewtype.code.CodePreviewReducer$State r2 = r7.$state
                r5 = r7
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r7.L$0 = r6
                r7.L$1 = r0
                r7.label = r4
                java.lang.Object r8 = com.box.android.preview.previewtype.code.CodePreviewReducer.access$initCodePreview(r8, r2, r5)
                if (r8 != r1) goto L41
                goto L56
            L41:
                r2 = r0
            L42:
                r4 = r7
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r7.L$0 = r0
                r0 = 0
                r7.L$1 = r0
                r7.label = r3
                java.lang.Object r7 = r2.emit(r8, r4)
                if (r7 != r1) goto L57
            L56:
                return r1
            L57:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.preview.previewtype.code.CodePreviewReducer.C17041.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReducerResult<State, Action> reduceCodePreview(State state, Action action) {
        if (action instanceof Action.Init) {
            return new ReducerResult<>(state, EffectKt.toEffect(FlowKt.flow(new C17041(state, null))));
        }
        if (!(action instanceof Action.OnInitialised)) {
            return action instanceof Action.MessageShown ? new ReducerResult<>(State.copy$default(state, null, null, null, null, false, 23, null), null, 2, null) : new ReducerResult<>(state, null, 2, null);
        }
        Action.OnInitialised onInitialised = (Action.OnInitialised) action;
        return new ReducerResult<>(State.copy$default(state, null, null, onInitialised.getContent(), onInitialised.getMessage(), true, 3, null), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object initCodePreview(State state, Continuation<? super Action> continuation) {
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
        Object codeFile = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(codeFile);
            CodeFileReader codeFileReader = this.environment.getCodeFileReader();
            URI uri = state.getUri();
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(state);
            anonymousClass1.label = 1;
            codeFile = codeFileReader.readCodeFile(uri, anonymousClass1);
            if (codeFile == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(codeFile);
        }
        Pair pair = (Pair) codeFile;
        return new Action.OnInitialised((String) pair.component1(), ((Boolean) pair.component2()).booleanValue() ? Message.CODE_PREVIEW_TOO_LARGE : null);
    }
}

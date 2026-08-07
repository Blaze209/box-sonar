package com.box.android.preview.fileactions;

import com.box.android.cpl.Effect;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.ReducerResult;
import com.box.android.preview.fileactions.openin.OpenInReducer;
import com.box.android.preview.preview.PreviewAnalytics;
import com.pspdfkit.analytics.Analytics;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActionsAnalyticsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/box/android/preview/fileactions/FileActionsAnalyticsReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/preview/fileactions/FileActionsReducer$State;", "Lcom/box/android/preview/fileactions/FileActionsReducer$Action;", "analytics", "Lcom/box/android/preview/preview/PreviewAnalytics;", "<init>", "(Lcom/box/android/preview/preview/PreviewAnalytics;)V", "reduce", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileActionsAnalyticsReducer implements Reducable<FileActionsReducer.State, FileActionsReducer.Action> {
    public static final int $stable = 8;
    private final PreviewAnalytics analytics;

    /* JADX INFO: compiled from: FileActionsAnalyticsReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FileAction.values().length];
            try {
                iArr[FileAction.Rename.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FileAction.CopySharedLink.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FileAction.MakeAvailableOffline.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FileAction.Gallery.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FileAction.Playlist.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[FileAction.BoxAi.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public FileActionsAnalyticsReducer(PreviewAnalytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.analytics = analytics;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ Reducable<FileActionsReducer.State, FileActionsReducer.Action> getBuild() {
        return Reducable.DefaultImpls.getBuild(this);
    }

    @Override // com.box.android.cpl.Reducable
    public ReducerResult<FileActionsReducer.State, FileActionsReducer.Action> reduce(FileActionsReducer.State state, FileActionsReducer.Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof FileActionsReducer.Action.PerformAction) {
            switch (WhenMappings.$EnumSwitchMapping$0[((FileActionsReducer.Action.PerformAction) action).getAction().ordinal()]) {
                case 1:
                    return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass1(state, null)));
                case 2:
                    return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass2(state, null)));
                case 3:
                    return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass3(state, null)));
                case 4:
                    return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass4(state, null)));
                case 5:
                    return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass5(state, null)));
                case 6:
                    return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass6(state, null)));
                default:
                    return new ReducerResult<>(state, null, 2, null);
            }
        }
        if (action instanceof FileActionsReducer.Action.OpenIn) {
            OpenInReducer.Action action2 = ((FileActionsReducer.Action.OpenIn) action).getAction();
            if (action2 instanceof OpenInReducer.Action.OpenWopiUrl) {
                return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass7(action2, null)));
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.preview.fileactions.FileActionsAnalyticsReducer$reduce$1, reason: invalid class name */
    /* JADX INFO: compiled from: FileActionsAnalyticsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.fileactions.FileActionsAnalyticsReducer$reduce$1", f = "FileActionsAnalyticsReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ FileActionsReducer.State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(FileActionsReducer.State state, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return FileActionsAnalyticsReducer.this.new AnonymousClass1(this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                FileActionsAnalyticsReducer.this.analytics.renameTriggered(this.$state.getFileModel());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.box.android.preview.fileactions.FileActionsAnalyticsReducer$reduce$2, reason: invalid class name */
    /* JADX INFO: compiled from: FileActionsAnalyticsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.fileactions.FileActionsAnalyticsReducer$reduce$2", f = "FileActionsAnalyticsReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ FileActionsReducer.State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(FileActionsReducer.State state, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return FileActionsAnalyticsReducer.this.new AnonymousClass2(this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                FileActionsAnalyticsReducer.this.analytics.copyLinkTriggered(this.$state.getFileModel());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.box.android.preview.fileactions.FileActionsAnalyticsReducer$reduce$3, reason: invalid class name */
    /* JADX INFO: compiled from: FileActionsAnalyticsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.fileactions.FileActionsAnalyticsReducer$reduce$3", f = "FileActionsAnalyticsReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ FileActionsReducer.State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(FileActionsReducer.State state, Continuation<? super AnonymousClass3> continuation) {
            super(1, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return FileActionsAnalyticsReducer.this.new AnonymousClass3(this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                FileActionsAnalyticsReducer.this.analytics.makeAvailableOfflineTriggered(this.$state.getFileModel());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.box.android.preview.fileactions.FileActionsAnalyticsReducer$reduce$4, reason: invalid class name */
    /* JADX INFO: compiled from: FileActionsAnalyticsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.fileactions.FileActionsAnalyticsReducer$reduce$4", f = "FileActionsAnalyticsReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ FileActionsReducer.State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(FileActionsReducer.State state, Continuation<? super AnonymousClass4> continuation) {
            super(1, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return FileActionsAnalyticsReducer.this.new AnonymousClass4(this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                FileActionsAnalyticsReducer.this.analytics.galleryViewTriggered(this.$state.getFileModel());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.box.android.preview.fileactions.FileActionsAnalyticsReducer$reduce$5, reason: invalid class name */
    /* JADX INFO: compiled from: FileActionsAnalyticsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.fileactions.FileActionsAnalyticsReducer$reduce$5", f = "FileActionsAnalyticsReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass5 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ FileActionsReducer.State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(FileActionsReducer.State state, Continuation<? super AnonymousClass5> continuation) {
            super(1, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return FileActionsAnalyticsReducer.this.new AnonymousClass5(this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                FileActionsAnalyticsReducer.this.analytics.playlistViewTriggered(this.$state.getFileModel());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.box.android.preview.fileactions.FileActionsAnalyticsReducer$reduce$6, reason: invalid class name */
    /* JADX INFO: compiled from: FileActionsAnalyticsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.fileactions.FileActionsAnalyticsReducer$reduce$6", f = "FileActionsAnalyticsReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass6 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ FileActionsReducer.State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(FileActionsReducer.State state, Continuation<? super AnonymousClass6> continuation) {
            super(1, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return FileActionsAnalyticsReducer.this.new AnonymousClass6(this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass6) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                FileActionsAnalyticsReducer.this.analytics.boxAiTriggered(this.$state.getFileModel());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.box.android.preview.fileactions.FileActionsAnalyticsReducer$reduce$7, reason: invalid class name */
    /* JADX INFO: compiled from: FileActionsAnalyticsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.fileactions.FileActionsAnalyticsReducer$reduce$7", f = "FileActionsAnalyticsReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass7 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ OpenInReducer.Action $wopiAction;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass7(OpenInReducer.Action action, Continuation<? super AnonymousClass7> continuation) {
            super(1, continuation);
            this.$wopiAction = action;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return FileActionsAnalyticsReducer.this.new AnonymousClass7(this.$wopiAction, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass7) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                FileActionsAnalyticsReducer.this.analytics.previewByWopiTriggered(((OpenInReducer.Action.OpenWopiUrl) this.$wopiAction).getWopiConfiguration());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}

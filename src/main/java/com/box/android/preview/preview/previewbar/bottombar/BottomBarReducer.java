package com.box.android.preview.preview.previewbar.bottombar;

import com.box.android.base.models.ButtonState;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.item.FileModel;
import com.box.android.preview.fileactions.FileAction;
import com.pspdfkit.analytics.Analytics;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BottomBarReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u001c\u001d\u001eB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J2\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\t2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010\u0019J\f\u0010\u001a\u001a\u00020\u001b*\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/box/android/preview/preview/previewbar/bottombar/BottomBarReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/preview/preview/previewbar/bottombar/BottomBarReducer$State;", "Lcom/box/android/preview/preview/previewbar/bottombar/BottomBarReducer$Action;", "environment", "Lcom/box/android/preview/preview/previewbar/bottombar/BottomBarEnvironment;", "<init>", "(Lcom/box/android/preview/preview/previewbar/bottombar/BottomBarEnvironment;)V", "bottomBarActions", "", "Lcom/box/android/preview/fileactions/FileAction;", "reduce", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "calculateActivityCount", "", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "getActions", "Lcom/box/android/preview/preview/previewbar/bottombar/BottomBarReducer$BottomBarAction;", "availableActions", "", "isAiEnabled", "", "(Lcom/box/android/domain/models/item/FileModel;Ljava/util/Set;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toButtonState", "Lcom/box/android/base/models/ButtonState;", "State", "BottomBarAction", "Action", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BottomBarReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final List<FileAction> bottomBarActions;
    private final BottomBarEnvironment environment;

    /* JADX INFO: compiled from: BottomBarReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FileAction.values().length];
            try {
                iArr[FileAction.Share.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FileAction.CopySharedLink.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FileAction.AddAnnotations.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FileAction.AddComment.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FileAction.BoxAi.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.box.android.preview.preview.previewbar.bottombar.BottomBarReducer$getActions$1, reason: invalid class name */
    /* JADX INFO: compiled from: BottomBarReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.preview.previewbar.bottombar.BottomBarReducer", f = "BottomBarReducer.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {65, 72, 78, 83}, m = "getActions", n = {"fileModel", "availableActions", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "it", "isAiEnabled", "$i$f$map", "$i$f$mapTo", "$i$a$-map-BottomBarReducer$getActions$3", "fileModel", "availableActions", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "it", "isAiEnabled", "$i$f$map", "$i$f$mapTo", "$i$a$-map-BottomBarReducer$getActions$3", "fileModel", "availableActions", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "it", "isAiEnabled", "$i$f$map", "$i$f$mapTo", "$i$a$-map-BottomBarReducer$getActions$3", "fileModel", "availableActions", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "it", "isAiEnabled", "$i$f$map", "$i$f$mapTo", "$i$a$-map-BottomBarReducer$getActions$3"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "Z$0", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "Z$0", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "Z$0", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "Z$0", "I$0", "I$1", "I$2"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BottomBarReducer.this.getActions(null, null, false, this);
        }
    }

    public BottomBarReducer(BottomBarEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        this.bottomBarActions = CollectionsKt.listOf((Object[]) new FileAction[]{FileAction.Share, FileAction.CopySharedLink, FileAction.BoxAi, FileAction.AddAnnotations, FileAction.AddComment});
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ Reducable<State, Action> getBuild() {
        return Reducable.DefaultImpls.getBuild(this);
    }

    /* JADX INFO: compiled from: BottomBarReducer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/preview/previewbar/bottombar/BottomBarReducer$State;", "", "actions", "", "Lcom/box/android/preview/preview/previewbar/bottombar/BottomBarReducer$BottomBarAction;", "<init>", "(Ljava/util/List;)V", "getActions", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 0;
        private final List<BottomBarAction> actions;

        /* JADX WARN: Multi-variable type inference failed */
        public State() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = state.actions;
            }
            return state.copy(list);
        }

        public final List<BottomBarAction> component1() {
            return this.actions;
        }

        public final State copy(List<BottomBarAction> actions) {
            Intrinsics.checkNotNullParameter(actions, "actions");
            return new State(actions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof State) && Intrinsics.areEqual(this.actions, ((State) other).actions);
        }

        public int hashCode() {
            return this.actions.hashCode();
        }

        public String toString() {
            return "State(actions=" + this.actions + ")";
        }

        public State(List<BottomBarAction> actions) {
            Intrinsics.checkNotNullParameter(actions, "actions");
            this.actions = actions;
        }

        public final List<BottomBarAction> getActions() {
            return this.actions;
        }

        public /* synthetic */ State(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? CollectionsKt.listOf((Object[]) new BottomBarAction[]{new BottomBarAction(FileAction.Share, ButtonState.DISABLED, null, 4, null), new BottomBarAction(FileAction.CopySharedLink, ButtonState.DISABLED, null, 4, null)}) : list);
        }
    }

    /* JADX INFO: compiled from: BottomBarReducer.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ.\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/box/android/preview/preview/previewbar/bottombar/BottomBarReducer$BottomBarAction;", "", Analytics.Data.ACTION, "Lcom/box/android/preview/fileactions/FileAction;", "state", "Lcom/box/android/base/models/ButtonState;", "badgeCount", "", "<init>", "(Lcom/box/android/preview/fileactions/FileAction;Lcom/box/android/base/models/ButtonState;Ljava/lang/Long;)V", "getAction", "()Lcom/box/android/preview/fileactions/FileAction;", "getState", "()Lcom/box/android/base/models/ButtonState;", "getBadgeCount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Lcom/box/android/preview/fileactions/FileAction;Lcom/box/android/base/models/ButtonState;Ljava/lang/Long;)Lcom/box/android/preview/preview/previewbar/bottombar/BottomBarReducer$BottomBarAction;", "equals", "", "other", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class BottomBarAction {
        public static final int $stable = 0;
        private final FileAction action;
        private final Long badgeCount;
        private final ButtonState state;

        public static /* synthetic */ BottomBarAction copy$default(BottomBarAction bottomBarAction, FileAction fileAction, ButtonState buttonState, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                fileAction = bottomBarAction.action;
            }
            if ((i & 2) != 0) {
                buttonState = bottomBarAction.state;
            }
            if ((i & 4) != 0) {
                l = bottomBarAction.badgeCount;
            }
            return bottomBarAction.copy(fileAction, buttonState, l);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FileAction getAction() {
            return this.action;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ButtonState getState() {
            return this.state;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Long getBadgeCount() {
            return this.badgeCount;
        }

        public final BottomBarAction copy(FileAction action, ButtonState state, Long badgeCount) {
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(state, "state");
            return new BottomBarAction(action, state, badgeCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BottomBarAction)) {
                return false;
            }
            BottomBarAction bottomBarAction = (BottomBarAction) other;
            return this.action == bottomBarAction.action && this.state == bottomBarAction.state && Intrinsics.areEqual(this.badgeCount, bottomBarAction.badgeCount);
        }

        public int hashCode() {
            int iHashCode = ((this.action.hashCode() * 31) + this.state.hashCode()) * 31;
            Long l = this.badgeCount;
            return iHashCode + (l == null ? 0 : l.hashCode());
        }

        public String toString() {
            return "BottomBarAction(action=" + this.action + ", state=" + this.state + ", badgeCount=" + this.badgeCount + ")";
        }

        public BottomBarAction(FileAction action, ButtonState state, Long l) {
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(state, "state");
            this.action = action;
            this.state = state;
            this.badgeCount = l;
        }

        public /* synthetic */ BottomBarAction(FileAction fileAction, ButtonState buttonState, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(fileAction, buttonState, (i & 4) != 0 ? null : l);
        }

        public final FileAction getAction() {
            return this.action;
        }

        public final Long getBadgeCount() {
            return this.badgeCount;
        }

        public final ButtonState getState() {
            return this.state;
        }
    }

    /* JADX INFO: compiled from: BottomBarReducer.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/preview/preview/previewbar/bottombar/BottomBarReducer$Action;", "", "<init>", "()V", "Update", "SetActions", "Lcom/box/android/preview/preview/previewbar/bottombar/BottomBarReducer$Action$SetActions;", "Lcom/box/android/preview/preview/previewbar/bottombar/BottomBarReducer$Action$Update;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: BottomBarReducer.kt */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/box/android/preview/preview/previewbar/bottombar/BottomBarReducer$Action$Update;", "Lcom/box/android/preview/preview/previewbar/bottombar/BottomBarReducer$Action;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "availableActions", "", "Lcom/box/android/preview/fileactions/FileAction;", "isAiEnabled", "", "<init>", "(Lcom/box/android/domain/models/item/FileModel;Ljava/util/Set;Z)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "getAvailableActions", "()Ljava/util/Set;", "()Z", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Update extends Action {
            public static final int $stable = 8;
            private final Set<FileAction> availableActions;
            private final FileModel fileModel;
            private final boolean isAiEnabled;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Update copy$default(Update update, FileModel fileModel, Set set, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileModel = update.fileModel;
                }
                if ((i & 2) != 0) {
                    set = update.availableActions;
                }
                if ((i & 4) != 0) {
                    z = update.isAiEnabled;
                }
                return update.copy(fileModel, set, z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FileModel getFileModel() {
                return this.fileModel;
            }

            public final Set<FileAction> component2() {
                return this.availableActions;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getIsAiEnabled() {
                return this.isAiEnabled;
            }

            public final Update copy(FileModel fileModel, Set<? extends FileAction> availableActions, boolean isAiEnabled) {
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                Intrinsics.checkNotNullParameter(availableActions, "availableActions");
                return new Update(fileModel, availableActions, isAiEnabled);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Update)) {
                    return false;
                }
                Update update = (Update) other;
                return Intrinsics.areEqual(this.fileModel, update.fileModel) && Intrinsics.areEqual(this.availableActions, update.availableActions) && this.isAiEnabled == update.isAiEnabled;
            }

            public int hashCode() {
                return (((this.fileModel.hashCode() * 31) + this.availableActions.hashCode()) * 31) + Boolean.hashCode(this.isAiEnabled);
            }

            public String toString() {
                return "Update(fileModel=" + this.fileModel + ", availableActions=" + this.availableActions + ", isAiEnabled=" + this.isAiEnabled + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Update(FileModel fileModel, Set<? extends FileAction> availableActions, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                Intrinsics.checkNotNullParameter(availableActions, "availableActions");
                this.fileModel = fileModel;
                this.availableActions = availableActions;
                this.isAiEnabled = z;
            }

            public final Set<FileAction> getAvailableActions() {
                return this.availableActions;
            }

            public final FileModel getFileModel() {
                return this.fileModel;
            }

            public final boolean isAiEnabled() {
                return this.isAiEnabled;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: BottomBarReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/preview/previewbar/bottombar/BottomBarReducer$Action$SetActions;", "Lcom/box/android/preview/preview/previewbar/bottombar/BottomBarReducer$Action;", "actions", "", "Lcom/box/android/preview/preview/previewbar/bottombar/BottomBarReducer$BottomBarAction;", "<init>", "(Ljava/util/List;)V", "getActions", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SetActions extends Action {
            public static final int $stable = 8;
            private final List<BottomBarAction> actions;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ SetActions copy$default(SetActions setActions, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = setActions.actions;
                }
                return setActions.copy(list);
            }

            public final List<BottomBarAction> component1() {
                return this.actions;
            }

            public final SetActions copy(List<BottomBarAction> actions) {
                Intrinsics.checkNotNullParameter(actions, "actions");
                return new SetActions(actions);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SetActions) && Intrinsics.areEqual(this.actions, ((SetActions) other).actions);
            }

            public int hashCode() {
                return this.actions.hashCode();
            }

            public String toString() {
                return "SetActions(actions=" + this.actions + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SetActions(List<BottomBarAction> actions) {
                super(null);
                Intrinsics.checkNotNullParameter(actions, "actions");
                this.actions = actions;
            }

            public final List<BottomBarAction> getActions() {
                return this.actions;
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public ReducerResult<State, Action> reduce(State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof Action.Update) {
            return new ReducerResult<>(state, new Effect((Function1) new C17011(action, null)).cancellable("updateBottomBarEffect", true));
        }
        if (!(action instanceof Action.SetActions)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult<>(state.copy(((Action.SetActions) action).getActions()), null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.preview.preview.previewbar.bottombar.BottomBarReducer$reduce$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BottomBarReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/preview/preview/previewbar/bottombar/BottomBarReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.preview.previewbar.bottombar.BottomBarReducer$reduce$1", f = "BottomBarReducer.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C17011 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        final /* synthetic */ Action $action;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C17011(Action action, Continuation<? super C17011> continuation) {
            super(1, continuation);
            this.$action = action;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return BottomBarReducer.this.new C17011(this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((C17011) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = BottomBarReducer.this.getActions(((Action.Update) this.$action).getFileModel(), ((Action.Update) this.$action).getAvailableActions(), ((Action.Update) this.$action).isAiEnabled(), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return new Action.SetActions((List) obj);
        }
    }

    private final long calculateActivityCount(FileModel fileModel) {
        Long annotationCount = fileModel.getAnnotationCount();
        long jLongValue = annotationCount != null ? annotationCount.longValue() : 0L;
        Long commentCount = fileModel.getCommentCount();
        return jLongValue + (commentCount != null ? commentCount.longValue() : 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x01f0 -> B:46:0x01fe). Please report as a decompilation issue!!! */
    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 8891. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final java.lang.Object getActions(com.box.android.domain.models.item.FileModel r27, java.util.Set<? extends com.box.android.preview.fileactions.FileAction> r28, boolean r29, kotlin.coroutines.Continuation<? super java.util.List<com.box.android.preview.preview.previewbar.bottombar.BottomBarReducer.BottomBarAction>> r30) {
        /*
            Method dump skipped, instruction units count: 889
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.preview.preview.previewbar.bottombar.BottomBarReducer.getActions(com.box.android.domain.models.item.FileModel, java.util.Set, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final ButtonState toButtonState(boolean z) {
        return z ? ButtonState.ENABLED : ButtonState.DISABLED;
    }
}

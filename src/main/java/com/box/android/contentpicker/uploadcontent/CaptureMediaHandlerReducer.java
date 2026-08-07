package com.box.android.contentpicker.uploadcontent;

import android.net.Uri;
import com.box.android.base.presentation.components.permission.PermissionReducer;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemType;
import com.pspdfkit.analytics.Analytics;
import java.io.InvalidObjectException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KCallables;
import kotlin.reflect.full.KClasses;

/* JADX INFO: compiled from: CaptureMediaHandlerReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\u0011\u0012\u0013\u0014B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0003H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/box/android/contentpicker/uploadcontent/CaptureMediaHandlerReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/contentpicker/uploadcontent/CaptureMediaHandlerReducer$State;", "Lcom/box/android/contentpicker/uploadcontent/CaptureMediaHandlerReducer$Action;", "environment", "Lcom/box/android/contentpicker/uploadcontent/CaptureMediaEnvironment;", "<init>", "(Lcom/box/android/contentpicker/uploadcontent/CaptureMediaEnvironment;)V", "getEnvironment", "()Lcom/box/android/contentpicker/uploadcontent/CaptureMediaEnvironment;", "reduceCapturePhoto", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "State", "ViewEffect", "Action", "Companion", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CaptureMediaHandlerReducer implements Reducable<State, Action> {
    private static final String EXTENSION_FOR_FILE = "jpg";
    private final Reducable<State, Action> build;
    private final CaptureMediaEnvironment environment;
    public static final int $stable = 8;

    public CaptureMediaHandlerReducer(CaptureMediaEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new CaptureMediaHandlerReducer$build$1(this));
        final CaptureMediaHandlerReducer$build$2 captureMediaHandlerReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.contentpicker.uploadcontent.CaptureMediaHandlerReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((CaptureMediaHandlerReducer.State) obj).getPermissionState();
            }
        };
        final CaptureMediaHandlerReducer$build$3 captureMediaHandlerReducer$build$3 = CaptureMediaHandlerReducer$build$3.INSTANCE;
        this.build = new IfLetReducer(reduce, new PermissionReducer(), new Function1<State, PermissionReducer.State>() { // from class: com.box.android.contentpicker.uploadcontent.CaptureMediaHandlerReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.base.presentation.components.permission.PermissionReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final PermissionReducer.State invoke(CaptureMediaHandlerReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return captureMediaHandlerReducer$build$2.invoke(it);
            }
        }, new Function1<Action, PermissionReducer.Action>() { // from class: com.box.android.contentpicker.uploadcontent.CaptureMediaHandlerReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final PermissionReducer.Action invoke(CaptureMediaHandlerReducer.Action action) {
                if (!(action instanceof CaptureMediaHandlerReducer.Action.PermissionAction)) {
                    action = null;
                }
                CaptureMediaHandlerReducer.Action.PermissionAction permissionAction = (CaptureMediaHandlerReducer.Action.PermissionAction) action;
                if (permissionAction != null) {
                    return permissionAction.getAction();
                }
                return null;
            }
        }, new Function2<State, PermissionReducer.State, State>() { // from class: com.box.android.contentpicker.uploadcontent.CaptureMediaHandlerReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final CaptureMediaHandlerReducer.State invoke(CaptureMediaHandlerReducer.State parentState, PermissionReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = captureMediaHandlerReducer$build$2;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(CaptureMediaHandlerReducer.State.class)).iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(((KFunction) next).getName(), BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB));
                KFunction kFunction = (KFunction) next;
                if (kFunction == null) {
                    throw new InvalidObjectException("Copy method not found. Make sure that you work on data class!");
                }
                KParameter instanceParameter = KCallables.getInstanceParameter(kFunction);
                Intrinsics.checkNotNull(instanceParameter);
                for (KParameter kParameter : kFunction.getParameters()) {
                    if (Intrinsics.areEqual(kParameter.getName(), kProperty1.getName())) {
                        R rCallBy = kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, parentState), TuplesKt.to(kParameter, state)));
                        if (rCallBy != 0) {
                            return (CaptureMediaHandlerReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.contentpicker.uploadcontent.CaptureMediaHandlerReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<PermissionReducer.Action, Action>() { // from class: com.box.android.contentpicker.uploadcontent.CaptureMediaHandlerReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CaptureMediaHandlerReducer.Action invoke(PermissionReducer.Action action) {
                Object objInvoke = captureMediaHandlerReducer$build$3.invoke(action);
                if (objInvoke != null) {
                    return (CaptureMediaHandlerReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.contentpicker.uploadcontent.CaptureMediaHandlerReducer.Action");
            }
        });
    }

    public final CaptureMediaEnvironment getEnvironment() {
        return this.environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: CaptureMediaHandlerReducer.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/box/android/contentpicker/uploadcontent/CaptureMediaHandlerReducer$State;", "", "permissionState", "Lcom/box/android/base/presentation/components/permission/PermissionReducer$State;", "viewEffect", "Lcom/box/android/contentpicker/uploadcontent/CaptureMediaHandlerReducer$ViewEffect;", "localItemId", "Lcom/box/android/domain/models/ItemId$Local;", "<init>", "(Lcom/box/android/base/presentation/components/permission/PermissionReducer$State;Lcom/box/android/contentpicker/uploadcontent/CaptureMediaHandlerReducer$ViewEffect;Lcom/box/android/domain/models/ItemId$Local;)V", "getPermissionState", "()Lcom/box/android/base/presentation/components/permission/PermissionReducer$State;", "getViewEffect", "()Lcom/box/android/contentpicker/uploadcontent/CaptureMediaHandlerReducer$ViewEffect;", "getLocalItemId", "()Lcom/box/android/domain/models/ItemId$Local;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final ItemId.Local localItemId;
        private final PermissionReducer.State permissionState;
        private final ViewEffect viewEffect;

        public State() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ State copy$default(State state, PermissionReducer.State state2, ViewEffect viewEffect, ItemId.Local local, int i, Object obj) {
            if ((i & 1) != 0) {
                state2 = state.permissionState;
            }
            if ((i & 2) != 0) {
                viewEffect = state.viewEffect;
            }
            if ((i & 4) != 0) {
                local = state.localItemId;
            }
            return state.copy(state2, viewEffect, local);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final PermissionReducer.State getPermissionState() {
            return this.permissionState;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ViewEffect getViewEffect() {
            return this.viewEffect;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final ItemId.Local getLocalItemId() {
            return this.localItemId;
        }

        public final State copy(PermissionReducer.State permissionState, ViewEffect viewEffect, ItemId.Local localItemId) {
            Intrinsics.checkNotNullParameter(permissionState, "permissionState");
            Intrinsics.checkNotNullParameter(viewEffect, "viewEffect");
            Intrinsics.checkNotNullParameter(localItemId, "localItemId");
            return new State(permissionState, viewEffect, localItemId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.permissionState, state.permissionState) && Intrinsics.areEqual(this.viewEffect, state.viewEffect) && Intrinsics.areEqual(this.localItemId, state.localItemId);
        }

        public int hashCode() {
            return (((this.permissionState.hashCode() * 31) + this.viewEffect.hashCode()) * 31) + this.localItemId.hashCode();
        }

        public String toString() {
            return "State(permissionState=" + this.permissionState + ", viewEffect=" + this.viewEffect + ", localItemId=" + this.localItemId + ")";
        }

        public State(PermissionReducer.State permissionState, ViewEffect viewEffect, ItemId.Local localItemId) {
            Intrinsics.checkNotNullParameter(permissionState, "permissionState");
            Intrinsics.checkNotNullParameter(viewEffect, "viewEffect");
            Intrinsics.checkNotNullParameter(localItemId, "localItemId");
            this.permissionState = permissionState;
            this.viewEffect = viewEffect;
            this.localItemId = localItemId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ State(PermissionReducer.State state, ViewEffect.None none, ItemId.Local local, int i, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i & 1) != 0) {
                state = new PermissionReducer.State(null, false, 3, 0 == true ? 1 : 0);
            }
            this(state, (i & 2) != 0 ? ViewEffect.None.INSTANCE : none, (i & 4) != 0 ? ItemId.Local.INSTANCE.create(ItemType.FILE) : local);
        }

        public final PermissionReducer.State getPermissionState() {
            return this.permissionState;
        }

        public final ViewEffect getViewEffect() {
            return this.viewEffect;
        }

        public final ItemId.Local getLocalItemId() {
            return this.localItemId;
        }
    }

    /* JADX INFO: compiled from: CaptureMediaHandlerReducer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/contentpicker/uploadcontent/CaptureMediaHandlerReducer$ViewEffect;", "", "<init>", "()V", "None", "LaunchCamera", "PhotoCaptured", "PhotoNotCaptured", "Lcom/box/android/contentpicker/uploadcontent/CaptureMediaHandlerReducer$ViewEffect$LaunchCamera;", "Lcom/box/android/contentpicker/uploadcontent/CaptureMediaHandlerReducer$ViewEffect$None;", "Lcom/box/android/contentpicker/uploadcontent/CaptureMediaHandlerReducer$ViewEffect$PhotoCaptured;", "Lcom/box/android/contentpicker/uploadcontent/CaptureMediaHandlerReducer$ViewEffect$PhotoNotCaptured;", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class ViewEffect {
        public static final int $stable = 0;

        public /* synthetic */ ViewEffect(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: CaptureMediaHandlerReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/contentpicker/uploadcontent/CaptureMediaHandlerReducer$ViewEffect$None;", "Lcom/box/android/contentpicker/uploadcontent/CaptureMediaHandlerReducer$ViewEffect;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return 1646877518;
            }

            public String toString() {
                return "None";
            }

            private None() {
                super(null);
            }
        }

        private ViewEffect() {
        }

        /* JADX INFO: compiled from: CaptureMediaHandlerReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/contentpicker/uploadcontent/CaptureMediaHandlerReducer$ViewEffect$LaunchCamera;", "Lcom/box/android/contentpicker/uploadcontent/CaptureMediaHandlerReducer$ViewEffect;", "uri", "Landroid/net/Uri;", "<init>", "(Landroid/net/Uri;)V", "getUri", "()Landroid/net/Uri;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class LaunchCamera extends ViewEffect {
            public static final int $stable = 8;
            private final Uri uri;

            public static /* synthetic */ LaunchCamera copy$default(LaunchCamera launchCamera, Uri uri, int i, Object obj) {
                if ((i & 1) != 0) {
                    uri = launchCamera.uri;
                }
                return launchCamera.copy(uri);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Uri getUri() {
                return this.uri;
            }

            public final LaunchCamera copy(Uri uri) {
                Intrinsics.checkNotNullParameter(uri, "uri");
                return new LaunchCamera(uri);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof LaunchCamera) && Intrinsics.areEqual(this.uri, ((LaunchCamera) other).uri);
            }

            public int hashCode() {
                return this.uri.hashCode();
            }

            public String toString() {
                return "LaunchCamera(uri=" + this.uri + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LaunchCamera(Uri uri) {
                super(null);
                Intrinsics.checkNotNullParameter(uri, "uri");
                this.uri = uri;
            }

            public final Uri getUri() {
                return this.uri;
            }
        }

        /* JADX INFO: compiled from: CaptureMediaHandlerReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/contentpicker/uploadcontent/CaptureMediaHandlerReducer$ViewEffect$PhotoCaptured;", "Lcom/box/android/contentpicker/uploadcontent/CaptureMediaHandlerReducer$ViewEffect;", "itemId", "Lcom/box/android/domain/models/ItemId$Local;", "name", "", "<init>", "(Lcom/box/android/domain/models/ItemId$Local;Ljava/lang/String;)V", "getItemId", "()Lcom/box/android/domain/models/ItemId$Local;", "getName", "()Ljava/lang/String;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PhotoCaptured extends ViewEffect {
            public static final int $stable = 8;
            private final ItemId.Local itemId;
            private final String name;

            public static /* synthetic */ PhotoCaptured copy$default(PhotoCaptured photoCaptured, ItemId.Local local, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    local = photoCaptured.itemId;
                }
                if ((i & 2) != 0) {
                    str = photoCaptured.name;
                }
                return photoCaptured.copy(local, str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemId.Local getItemId() {
                return this.itemId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getName() {
                return this.name;
            }

            public final PhotoCaptured copy(ItemId.Local itemId, String name) {
                Intrinsics.checkNotNullParameter(itemId, "itemId");
                Intrinsics.checkNotNullParameter(name, "name");
                return new PhotoCaptured(itemId, name);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PhotoCaptured)) {
                    return false;
                }
                PhotoCaptured photoCaptured = (PhotoCaptured) other;
                return Intrinsics.areEqual(this.itemId, photoCaptured.itemId) && Intrinsics.areEqual(this.name, photoCaptured.name);
            }

            public int hashCode() {
                return (this.itemId.hashCode() * 31) + this.name.hashCode();
            }

            public String toString() {
                return "PhotoCaptured(itemId=" + this.itemId + ", name=" + this.name + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PhotoCaptured(ItemId.Local itemId, String name) {
                super(null);
                Intrinsics.checkNotNullParameter(itemId, "itemId");
                Intrinsics.checkNotNullParameter(name, "name");
                this.itemId = itemId;
                this.name = name;
            }

            public final ItemId.Local getItemId() {
                return this.itemId;
            }

            public final String getName() {
                return this.name;
            }
        }

        /* JADX INFO: compiled from: CaptureMediaHandlerReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/contentpicker/uploadcontent/CaptureMediaHandlerReducer$ViewEffect$PhotoNotCaptured;", "Lcom/box/android/contentpicker/uploadcontent/CaptureMediaHandlerReducer$ViewEffect;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PhotoNotCaptured extends ViewEffect {
            public static final int $stable = 0;
            public static final PhotoNotCaptured INSTANCE = new PhotoNotCaptured();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PhotoNotCaptured)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1526276267;
            }

            public String toString() {
                return "PhotoNotCaptured";
            }

            private PhotoNotCaptured() {
                super(null);
            }
        }
    }

    /* JADX INFO: compiled from: CaptureMediaHandlerReducer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/contentpicker/uploadcontent/CaptureMediaHandlerReducer$Action;", "", "<init>", "()V", "PermissionAction", "PhotoCaptured", "OnViewEffectProcessed", "Lcom/box/android/contentpicker/uploadcontent/CaptureMediaHandlerReducer$Action$OnViewEffectProcessed;", "Lcom/box/android/contentpicker/uploadcontent/CaptureMediaHandlerReducer$Action$PermissionAction;", "Lcom/box/android/contentpicker/uploadcontent/CaptureMediaHandlerReducer$Action$PhotoCaptured;", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: CaptureMediaHandlerReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/contentpicker/uploadcontent/CaptureMediaHandlerReducer$Action$PermissionAction;", "Lcom/box/android/contentpicker/uploadcontent/CaptureMediaHandlerReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/base/presentation/components/permission/PermissionReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/base/presentation/components/permission/PermissionReducer$Action;)V", "getAction", "()Lcom/box/android/base/presentation/components/permission/PermissionReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PermissionAction extends Action implements Embedded<PermissionReducer.Action> {
            public static final int $stable = PermissionReducer.Action.$stable;
            private final PermissionReducer.Action action;

            public static /* synthetic */ PermissionAction copy$default(PermissionAction permissionAction, PermissionReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = permissionAction.action;
                }
                return permissionAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final PermissionReducer.Action getAction() {
                return this.action;
            }

            public final PermissionAction copy(PermissionReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new PermissionAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof PermissionAction) && Intrinsics.areEqual(this.action, ((PermissionAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "PermissionAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PermissionAction(PermissionReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final PermissionReducer.Action getAction() {
                return this.action;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: CaptureMediaHandlerReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/contentpicker/uploadcontent/CaptureMediaHandlerReducer$Action$PhotoCaptured;", "Lcom/box/android/contentpicker/uploadcontent/CaptureMediaHandlerReducer$Action;", "success", "", "<init>", "(Z)V", "getSuccess", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PhotoCaptured extends Action {
            public static final int $stable = 0;
            private final boolean success;

            public static /* synthetic */ PhotoCaptured copy$default(PhotoCaptured photoCaptured, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = photoCaptured.success;
                }
                return photoCaptured.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getSuccess() {
                return this.success;
            }

            public final PhotoCaptured copy(boolean success) {
                return new PhotoCaptured(success);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof PhotoCaptured) && this.success == ((PhotoCaptured) other).success;
            }

            public int hashCode() {
                return Boolean.hashCode(this.success);
            }

            public String toString() {
                return "PhotoCaptured(success=" + this.success + ")";
            }

            public PhotoCaptured(boolean z) {
                super(null);
                this.success = z;
            }

            public final boolean getSuccess() {
                return this.success;
            }
        }

        /* JADX INFO: compiled from: CaptureMediaHandlerReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/contentpicker/uploadcontent/CaptureMediaHandlerReducer$Action$OnViewEffectProcessed;", "Lcom/box/android/contentpicker/uploadcontent/CaptureMediaHandlerReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "content-picker_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return 1048974403;
            }

            public String toString() {
                return "OnViewEffectProcessed";
            }

            private OnViewEffectProcessed() {
                super(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final ReducerResult<State, Action> reduceCapturePhoto(State state, Action action) {
        int i = 2;
        Effect effect = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        Object[] objArr6 = 0;
        Object[] objArr7 = 0;
        Object[] objArr8 = 0;
        Object[] objArr9 = 0;
        Object[] objArr10 = 0;
        Object[] objArr11 = 0;
        Object[] objArr12 = 0;
        Object[] objArr13 = 0;
        Object[] objArr14 = 0;
        Object[] objArr15 = 0;
        if (action instanceof Action.PermissionAction) {
            Action.PermissionAction permissionAction = (Action.PermissionAction) action;
            PermissionReducer.Action action2 = permissionAction.getAction();
            if (action2 instanceof PermissionReducer.Action.PermissionGranted) {
                return new ReducerResult<>(State.copy$default(state, null, new ViewEffect.LaunchCamera(this.environment.getUploadFileProvider().getUriForFile(this.environment.getUploadFileProvider().getTemporaryUploadFile(state.getLocalItemId().getLocalId()))), null, 5, null), effect, i, objArr15 == true ? 1 : 0);
            }
            if (action2 instanceof PermissionReducer.Action.PermissionRequestResult) {
                if (((PermissionReducer.Action.PermissionRequestResult) permissionAction.getAction()).getStatus() == PermissionReducer.Action.PermissionRequestResult.Status.DENIED) {
                    return new ReducerResult<>(State.copy$default(state, null, ViewEffect.PhotoNotCaptured.INSTANCE, null, 5, null), objArr14 == true ? 1 : 0, i, objArr13 == true ? 1 : 0);
                }
                return new ReducerResult<>(state, objArr12 == true ? 1 : 0, i, objArr11 == true ? 1 : 0);
            }
            if (action2 instanceof PermissionReducer.Action.DismissPermanentDenialDialog) {
                return new ReducerResult<>(State.copy$default(state, null, ViewEffect.PhotoNotCaptured.INSTANCE, null, 5, null), objArr10 == true ? 1 : 0, i, objArr9 == true ? 1 : 0);
            }
            return new ReducerResult<>(state, objArr8 == true ? 1 : 0, i, objArr7 == true ? 1 : 0);
        }
        if (action instanceof Action.PhotoCaptured) {
            if (((Action.PhotoCaptured) action).getSuccess()) {
                return new ReducerResult<>(State.copy$default(state, null, new ViewEffect.PhotoCaptured(state.getLocalItemId(), CommonBoxUtil.getTimestampedName$default(null, null, "jpg", null, 11, null)), null, 5, null), objArr6 == true ? 1 : 0, i, objArr5 == true ? 1 : 0);
            }
            return new ReducerResult<>(State.copy$default(state, null, ViewEffect.PhotoNotCaptured.INSTANCE, null, 5, null), objArr4 == true ? 1 : 0, i, objArr3 == true ? 1 : 0);
        }
        if (Intrinsics.areEqual(action, Action.OnViewEffectProcessed.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, null, ViewEffect.None.INSTANCE, null, 5, null), objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }
}

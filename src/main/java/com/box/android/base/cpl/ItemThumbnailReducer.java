package com.box.android.base.cpl;

import com.box.android.base.compose.ItemThumbnail;
import com.box.android.base.presentation.ThumbnailManager;
import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Identifiable;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: ItemThumbnailReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\f\rB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/box/android/base/cpl/ItemThumbnailReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/base/cpl/ItemThumbnailReducer$State;", "Lcom/box/android/base/cpl/ItemThumbnailReducer$Action;", "environment", "Lcom/box/android/base/cpl/ItemThumbnailEnvironment;", "<init>", "(Lcom/box/android/base/cpl/ItemThumbnailEnvironment;)V", "build", "Lcom/box/android/cpl/Reduce;", "getBuild", "()Lcom/box/android/cpl/Reduce;", "Action", "State", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ItemThumbnailReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reduce<State, Action> build;
    private final ItemThumbnailEnvironment environment;

    public ItemThumbnailReducer(ItemThumbnailEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        this.build = new Reduce<>(new Function2() { // from class: com.box.android.base.cpl.ItemThumbnailReducer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ItemThumbnailReducer.build$lambda$0(this.f$0, (ItemThumbnailReducer.State) obj, (ItemThumbnailReducer.Action) obj2);
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: ItemThumbnailReducer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/base/cpl/ItemThumbnailReducer$Action;", "", "<init>", "()V", "Clicked", "FetchThumbnail", "UpdateThumbnail", "ThumbnailError", "Lcom/box/android/base/cpl/ItemThumbnailReducer$Action$Clicked;", "Lcom/box/android/base/cpl/ItemThumbnailReducer$Action$FetchThumbnail;", "Lcom/box/android/base/cpl/ItemThumbnailReducer$Action$ThumbnailError;", "Lcom/box/android/base/cpl/ItemThumbnailReducer$Action$UpdateThumbnail;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: ItemThumbnailReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/cpl/ItemThumbnailReducer$Action$Clicked;", "Lcom/box/android/base/cpl/ItemThumbnailReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Clicked extends Action {
            public static final int $stable = 0;
            public static final Clicked INSTANCE = new Clicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Clicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -2074344595;
            }

            public String toString() {
                return "Clicked";
            }

            private Clicked() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: ItemThumbnailReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/cpl/ItemThumbnailReducer$Action$FetchThumbnail;", "Lcom/box/android/base/cpl/ItemThumbnailReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FetchThumbnail extends Action {
            public static final int $stable = 0;
            public static final FetchThumbnail INSTANCE = new FetchThumbnail();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FetchThumbnail)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1176489292;
            }

            public String toString() {
                return "FetchThumbnail";
            }

            private FetchThumbnail() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ItemThumbnailReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/base/cpl/ItemThumbnailReducer$Action$UpdateThumbnail;", "Lcom/box/android/base/cpl/ItemThumbnailReducer$Action;", "itemThumbnail", "Lcom/box/android/base/compose/ItemThumbnail;", "<init>", "(Lcom/box/android/base/compose/ItemThumbnail;)V", "getItemThumbnail", "()Lcom/box/android/base/compose/ItemThumbnail;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateThumbnail extends Action {
            public static final int $stable = 0;
            private final ItemThumbnail itemThumbnail;

            public static /* synthetic */ UpdateThumbnail copy$default(UpdateThumbnail updateThumbnail, ItemThumbnail itemThumbnail, int i, Object obj) {
                if ((i & 1) != 0) {
                    itemThumbnail = updateThumbnail.itemThumbnail;
                }
                return updateThumbnail.copy(itemThumbnail);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemThumbnail getItemThumbnail() {
                return this.itemThumbnail;
            }

            public final UpdateThumbnail copy(ItemThumbnail itemThumbnail) {
                Intrinsics.checkNotNullParameter(itemThumbnail, "itemThumbnail");
                return new UpdateThumbnail(itemThumbnail);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UpdateThumbnail) && Intrinsics.areEqual(this.itemThumbnail, ((UpdateThumbnail) other).itemThumbnail);
            }

            public int hashCode() {
                return this.itemThumbnail.hashCode();
            }

            public String toString() {
                return "UpdateThumbnail(itemThumbnail=" + this.itemThumbnail + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UpdateThumbnail(ItemThumbnail itemThumbnail) {
                super(null);
                Intrinsics.checkNotNullParameter(itemThumbnail, "itemThumbnail");
                this.itemThumbnail = itemThumbnail;
            }

            public final ItemThumbnail getItemThumbnail() {
                return this.itemThumbnail;
            }
        }

        /* JADX INFO: compiled from: ItemThumbnailReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/base/cpl/ItemThumbnailReducer$Action$ThumbnailError;", "Lcom/box/android/base/cpl/ItemThumbnailReducer$Action;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ThumbnailError extends Action {
            public static final int $stable = 8;
            private final DomainError error;

            public static /* synthetic */ ThumbnailError copy$default(ThumbnailError thumbnailError, DomainError domainError, int i, Object obj) {
                if ((i & 1) != 0) {
                    domainError = thumbnailError.error;
                }
                return thumbnailError.copy(domainError);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DomainError getError() {
                return this.error;
            }

            public final ThumbnailError copy(DomainError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                return new ThumbnailError(error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ThumbnailError) && Intrinsics.areEqual(this.error, ((ThumbnailError) other).error);
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return "ThumbnailError(error=" + this.error + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ThumbnailError(DomainError error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public final DomainError getError() {
                return this.error;
            }
        }
    }

    /* JADX INFO: compiled from: ItemThumbnailReducer.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0002HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/box/android/base/cpl/ItemThumbnailReducer$State;", "Lcom/box/android/cpl/Identifiable;", "", "source", "Lcom/box/android/base/cpl/ThumbnailSource;", "thumbnail", "Lcom/box/android/base/compose/ItemThumbnail;", "isThumbnailFetchAttempted", "", "<init>", "(Lcom/box/android/base/cpl/ThumbnailSource;Lcom/box/android/base/compose/ItemThumbnail;Z)V", "getSource", "()Lcom/box/android/base/cpl/ThumbnailSource;", "getThumbnail", "()Lcom/box/android/base/compose/ItemThumbnail;", "()Z", "id", "getId", "()Ljava/lang/String;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State implements Identifiable<String> {
        public static final int $stable = 0;
        private final boolean isThumbnailFetchAttempted;
        private final ThumbnailSource source;
        private final ItemThumbnail thumbnail;

        public static /* synthetic */ State copy$default(State state, ThumbnailSource thumbnailSource, ItemThumbnail itemThumbnail, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                thumbnailSource = state.source;
            }
            if ((i & 2) != 0) {
                itemThumbnail = state.thumbnail;
            }
            if ((i & 4) != 0) {
                z = state.isThumbnailFetchAttempted;
            }
            return state.copy(thumbnailSource, itemThumbnail, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ThumbnailSource getSource() {
            return this.source;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ItemThumbnail getThumbnail() {
            return this.thumbnail;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsThumbnailFetchAttempted() {
            return this.isThumbnailFetchAttempted;
        }

        public final State copy(ThumbnailSource source, ItemThumbnail thumbnail, boolean isThumbnailFetchAttempted) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(thumbnail, "thumbnail");
            return new State(source, thumbnail, isThumbnailFetchAttempted);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.source, state.source) && Intrinsics.areEqual(this.thumbnail, state.thumbnail) && this.isThumbnailFetchAttempted == state.isThumbnailFetchAttempted;
        }

        public int hashCode() {
            return (((this.source.hashCode() * 31) + this.thumbnail.hashCode()) * 31) + Boolean.hashCode(this.isThumbnailFetchAttempted);
        }

        public String toString() {
            return "State(source=" + this.source + ", thumbnail=" + this.thumbnail + ", isThumbnailFetchAttempted=" + this.isThumbnailFetchAttempted + ")";
        }

        public State(ThumbnailSource source, ItemThumbnail thumbnail, boolean z) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(thumbnail, "thumbnail");
            this.source = source;
            this.thumbnail = thumbnail;
            this.isThumbnailFetchAttempted = z;
        }

        public final ThumbnailSource getSource() {
            return this.source;
        }

        public final ItemThumbnail getThumbnail() {
            return this.thumbnail;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ State(ThumbnailSource thumbnailSource, ItemThumbnail itemThumbnail, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i & 2) != 0) {
                if (thumbnailSource instanceof ThumbnailSource.Item) {
                    itemThumbnail = ThumbnailManager.INSTANCE.getDefaultThumbnail(((ThumbnailSource.Item) thumbnailSource).getItemModel());
                } else {
                    if (!(thumbnailSource instanceof ThumbnailSource.HubAsset)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    itemThumbnail = ItemThumbnail.Placeholder.INSTANCE;
                }
            }
            this(thumbnailSource, itemThumbnail, (i & 4) != 0 ? false : z);
        }

        public final boolean isThumbnailFetchAttempted() {
            return this.isThumbnailFetchAttempted;
        }

        @Override // com.box.android.cpl.Identifiable
        /* JADX INFO: renamed from: getId, reason: avoid collision after fix types in other method */
        public String getActivityId() {
            ThumbnailSource thumbnailSource = this.source;
            if (thumbnailSource instanceof ThumbnailSource.Item) {
                return ((ThumbnailSource.Item) thumbnailSource).getItemModel().getItemId().toString();
            }
            if (thumbnailSource instanceof ThumbnailSource.HubAsset) {
                return ((ThumbnailSource.HubAsset) thumbnailSource).getHubAssetModel().toString();
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReducerResult build$lambda$0(ItemThumbnailReducer itemThumbnailReducer, State state, Action action) {
        Effect effect;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof Action.FetchThumbnail) {
            ThumbnailSource source = state.getSource();
            if (source instanceof ThumbnailSource.Item) {
                final Flow<ItemThumbnail> flowLoadThumbnail = itemThumbnailReducer.environment.getThumbnailManager().loadThumbnail(((ThumbnailSource.Item) state.getSource()).getItemModel(), ((ThumbnailSource.Item) state.getSource()).isBigThumbnailNeeded());
                effect = EffectKt.toEffect(new Flow<Action.UpdateThumbnail>() { // from class: com.box.android.base.cpl.ItemThumbnailReducer$build$lambda$0$$inlined$map$1

                    /* JADX INFO: renamed from: com.box.android.base.cpl.ItemThumbnailReducer$build$lambda$0$$inlined$map$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* JADX INFO: renamed from: com.box.android.base.cpl.ItemThumbnailReducer$build$lambda$0$$inlined$map$1$2$1, reason: invalid class name */
                        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "com.box.android.base.cpl.ItemThumbnailReducer$build$lambda$0$$inlined$map$1$2", f = "ItemThumbnailReducer.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
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
                                ItemThumbnailReducer.Action.UpdateThumbnail updateThumbnail = new ItemThumbnailReducer.Action.UpdateThumbnail((ItemThumbnail) obj);
                                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                anonymousClass1.I$0 = 0;
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(updateThumbnail, anonymousClass1) == coroutine_suspended) {
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
                    public Object collect(FlowCollector<? super ItemThumbnailReducer.Action.UpdateThumbnail> flowCollector, Continuation continuation) {
                        Object objCollect = flowLoadThumbnail.collect(new AnonymousClass2(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                });
            } else {
                if (!(source instanceof ThumbnailSource.HubAsset)) {
                    throw new NoWhenBranchMatchedException();
                }
                effect = EffectKt.toEffect(FlowKt.flow(new ItemThumbnailReducer$build$1$effect$2(itemThumbnailReducer, state, null)));
            }
            return new ReducerResult(State.copy$default(state, null, null, true, 3, null), effect);
        }
        if (action instanceof Action.UpdateThumbnail) {
            return new ReducerResult(State.copy$default(state, null, ((Action.UpdateThumbnail) action).getItemThumbnail(), false, 5, null), null, 2, null);
        }
        return new ReducerResult(state, null, 2, null);
    }
}

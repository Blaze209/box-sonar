package com.box.android.preview.fileactions.copylink;

import com.box.android.base.presentation.components.CopyTextReducer;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.SharedLinkModel;
import com.box.android.domain.utils.result.Result;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.pspdfkit.analytics.Analytics;
import java.io.InvalidObjectException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: CopyLinkReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0011\u0012B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0003H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/fileactions/copylink/CopyLinkReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/preview/fileactions/copylink/CopyLinkReducer$State;", "Lcom/box/android/preview/fileactions/copylink/CopyLinkReducer$Action;", "environment", "Lcom/box/android/preview/fileactions/copylink/CopyLinkEnvironment;", "<init>", "(Lcom/box/android/preview/fileactions/copylink/CopyLinkEnvironment;)V", "getEnvironment", "()Lcom/box/android/preview/fileactions/copylink/CopyLinkEnvironment;", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "reduceCopyLink", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "Action", "State", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CopyLinkReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final CopyLinkEnvironment environment;

    public CopyLinkReducer(CopyLinkEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new CopyLinkReducer$build$1(this));
        final CopyLinkReducer$build$2 copyLinkReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.preview.fileactions.copylink.CopyLinkReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((CopyLinkReducer.State) obj).getCopyTextState();
            }
        };
        final CopyLinkReducer$build$3 copyLinkReducer$build$3 = CopyLinkReducer$build$3.INSTANCE;
        this.build = new IfLetReducer(reduce, new CopyTextReducer(environment.getClipboardService()), new Function1<State, CopyTextReducer.State>() { // from class: com.box.android.preview.fileactions.copylink.CopyLinkReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.base.presentation.components.CopyTextReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final CopyTextReducer.State invoke(CopyLinkReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return copyLinkReducer$build$2.invoke(it);
            }
        }, new Function1<Action, CopyTextReducer.Action>() { // from class: com.box.android.preview.fileactions.copylink.CopyLinkReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final CopyTextReducer.Action invoke(CopyLinkReducer.Action action) {
                if (!(action instanceof CopyLinkReducer.Action.CopyTextAction)) {
                    action = null;
                }
                CopyLinkReducer.Action.CopyTextAction copyTextAction = (CopyLinkReducer.Action.CopyTextAction) action;
                if (copyTextAction != null) {
                    return copyTextAction.getAction();
                }
                return null;
            }
        }, new Function2<State, CopyTextReducer.State, State>() { // from class: com.box.android.preview.fileactions.copylink.CopyLinkReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final CopyLinkReducer.State invoke(CopyLinkReducer.State parentState, CopyTextReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = copyLinkReducer$build$2;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(CopyLinkReducer.State.class)).iterator();
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
                            return (CopyLinkReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.fileactions.copylink.CopyLinkReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<CopyTextReducer.Action, Action>() { // from class: com.box.android.preview.fileactions.copylink.CopyLinkReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CopyLinkReducer.Action invoke(CopyTextReducer.Action action) {
                Object objInvoke = copyLinkReducer$build$3.invoke(action);
                if (objInvoke != null) {
                    return (CopyLinkReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.preview.fileactions.copylink.CopyLinkReducer.Action");
            }
        });
    }

    public final CopyLinkEnvironment getEnvironment() {
        return this.environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: CopyLinkReducer.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/box/android/preview/fileactions/copylink/CopyLinkReducer$Action;", "", "<init>", "()V", "CopyLinkClicked", "FetchSuccess", "FetchSharedLink", "FetchFailed", "CopyTextAction", "Finish", "Lcom/box/android/preview/fileactions/copylink/CopyLinkReducer$Action$CopyLinkClicked;", "Lcom/box/android/preview/fileactions/copylink/CopyLinkReducer$Action$CopyTextAction;", "Lcom/box/android/preview/fileactions/copylink/CopyLinkReducer$Action$FetchFailed;", "Lcom/box/android/preview/fileactions/copylink/CopyLinkReducer$Action$FetchSharedLink;", "Lcom/box/android/preview/fileactions/copylink/CopyLinkReducer$Action$FetchSuccess;", "Lcom/box/android/preview/fileactions/copylink/CopyLinkReducer$Action$Finish;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: CopyLinkReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/fileactions/copylink/CopyLinkReducer$Action$CopyLinkClicked;", "Lcom/box/android/preview/fileactions/copylink/CopyLinkReducer$Action;", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "<init>", "(Lcom/box/android/domain/models/item/ItemModel;)V", "getItemModel", "()Lcom/box/android/domain/models/item/ItemModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CopyLinkClicked extends Action {
            public static final int $stable = 8;
            private final ItemModel itemModel;

            public static /* synthetic */ CopyLinkClicked copy$default(CopyLinkClicked copyLinkClicked, ItemModel itemModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    itemModel = copyLinkClicked.itemModel;
                }
                return copyLinkClicked.copy(itemModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemModel getItemModel() {
                return this.itemModel;
            }

            public final CopyLinkClicked copy(ItemModel itemModel) {
                Intrinsics.checkNotNullParameter(itemModel, "itemModel");
                return new CopyLinkClicked(itemModel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CopyLinkClicked) && Intrinsics.areEqual(this.itemModel, ((CopyLinkClicked) other).itemModel);
            }

            public int hashCode() {
                return this.itemModel.hashCode();
            }

            public String toString() {
                return "CopyLinkClicked(itemModel=" + this.itemModel + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CopyLinkClicked(ItemModel itemModel) {
                super(null);
                Intrinsics.checkNotNullParameter(itemModel, "itemModel");
                this.itemModel = itemModel;
            }

            public final ItemModel getItemModel() {
                return this.itemModel;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: CopyLinkReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/preview/fileactions/copylink/CopyLinkReducer$Action$FetchSuccess;", "Lcom/box/android/preview/fileactions/copylink/CopyLinkReducer$Action;", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "", "<init>", "(Ljava/lang/String;)V", "getSharedLink", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FetchSuccess extends Action {
            public static final int $stable = 0;
            private final String sharedLink;

            public static /* synthetic */ FetchSuccess copy$default(FetchSuccess fetchSuccess, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = fetchSuccess.sharedLink;
                }
                return fetchSuccess.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getSharedLink() {
                return this.sharedLink;
            }

            public final FetchSuccess copy(String sharedLink) {
                Intrinsics.checkNotNullParameter(sharedLink, "sharedLink");
                return new FetchSuccess(sharedLink);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FetchSuccess) && Intrinsics.areEqual(this.sharedLink, ((FetchSuccess) other).sharedLink);
            }

            public int hashCode() {
                return this.sharedLink.hashCode();
            }

            public String toString() {
                return "FetchSuccess(sharedLink=" + this.sharedLink + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FetchSuccess(String sharedLink) {
                super(null);
                Intrinsics.checkNotNullParameter(sharedLink, "sharedLink");
                this.sharedLink = sharedLink;
            }

            public final String getSharedLink() {
                return this.sharedLink;
            }
        }

        /* JADX INFO: compiled from: CopyLinkReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/fileactions/copylink/CopyLinkReducer$Action$FetchSharedLink;", "Lcom/box/android/preview/fileactions/copylink/CopyLinkReducer$Action;", "fileId", "Lcom/box/android/domain/models/ItemId;", "<init>", "(Lcom/box/android/domain/models/ItemId;)V", "getFileId", "()Lcom/box/android/domain/models/ItemId;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FetchSharedLink extends Action {
            public static final int $stable = 8;
            private final ItemId fileId;

            public static /* synthetic */ FetchSharedLink copy$default(FetchSharedLink fetchSharedLink, ItemId itemId, int i, Object obj) {
                if ((i & 1) != 0) {
                    itemId = fetchSharedLink.fileId;
                }
                return fetchSharedLink.copy(itemId);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemId getFileId() {
                return this.fileId;
            }

            public final FetchSharedLink copy(ItemId fileId) {
                Intrinsics.checkNotNullParameter(fileId, "fileId");
                return new FetchSharedLink(fileId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FetchSharedLink) && Intrinsics.areEqual(this.fileId, ((FetchSharedLink) other).fileId);
            }

            public int hashCode() {
                return this.fileId.hashCode();
            }

            public String toString() {
                return "FetchSharedLink(fileId=" + this.fileId + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FetchSharedLink(ItemId fileId) {
                super(null);
                Intrinsics.checkNotNullParameter(fileId, "fileId");
                this.fileId = fileId;
            }

            public final ItemId getFileId() {
                return this.fileId;
            }
        }

        /* JADX INFO: compiled from: CopyLinkReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/preview/fileactions/copylink/CopyLinkReducer$Action$FetchFailed;", "Lcom/box/android/preview/fileactions/copylink/CopyLinkReducer$Action;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FetchFailed extends Action {
            public static final int $stable = 8;
            private final DomainError error;

            public static /* synthetic */ FetchFailed copy$default(FetchFailed fetchFailed, DomainError domainError, int i, Object obj) {
                if ((i & 1) != 0) {
                    domainError = fetchFailed.error;
                }
                return fetchFailed.copy(domainError);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DomainError getError() {
                return this.error;
            }

            public final FetchFailed copy(DomainError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                return new FetchFailed(error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FetchFailed) && Intrinsics.areEqual(this.error, ((FetchFailed) other).error);
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return "FetchFailed(error=" + this.error + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FetchFailed(DomainError error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public final DomainError getError() {
                return this.error;
            }
        }

        /* JADX INFO: compiled from: CopyLinkReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/fileactions/copylink/CopyLinkReducer$Action$CopyTextAction;", "Lcom/box/android/preview/fileactions/copylink/CopyLinkReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/base/presentation/components/CopyTextReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/base/presentation/components/CopyTextReducer$Action;)V", "getAction", "()Lcom/box/android/base/presentation/components/CopyTextReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CopyTextAction extends Action implements Embedded<CopyTextReducer.Action> {
            public static final int $stable = CopyTextReducer.Action.$stable;
            private final CopyTextReducer.Action action;

            public static /* synthetic */ CopyTextAction copy$default(CopyTextAction copyTextAction, CopyTextReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = copyTextAction.action;
                }
                return copyTextAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final CopyTextReducer.Action getAction() {
                return this.action;
            }

            public final CopyTextAction copy(CopyTextReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new CopyTextAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CopyTextAction) && Intrinsics.areEqual(this.action, ((CopyTextAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "CopyTextAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CopyTextAction(CopyTextReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final CopyTextReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: CopyLinkReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/preview/fileactions/copylink/CopyLinkReducer$Action$Finish;", "Lcom/box/android/preview/fileactions/copylink/CopyLinkReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Finish extends Action {
            public static final int $stable = 0;
            public static final Finish INSTANCE = new Finish();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Finish)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1538204509;
            }

            public String toString() {
                return "Finish";
            }

            private Finish() {
                super(null);
            }
        }
    }

    /* JADX INFO: compiled from: CopyLinkReducer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/box/android/preview/fileactions/copylink/CopyLinkReducer$State;", "", "copyTextState", "Lcom/box/android/base/presentation/components/CopyTextReducer$State;", "isFetching", "", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/base/presentation/components/CopyTextReducer$State;ZLcom/box/android/domain/models/DomainError;)V", "getCopyTextState", "()Lcom/box/android/base/presentation/components/CopyTextReducer$State;", "()Z", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final CopyTextReducer.State copyTextState;
        private final DomainError error;
        private final boolean isFetching;

        public State() {
            this(null, false, null, 7, null);
        }

        public static /* synthetic */ State copy$default(State state, CopyTextReducer.State state2, boolean z, DomainError domainError, int i, Object obj) {
            if ((i & 1) != 0) {
                state2 = state.copyTextState;
            }
            if ((i & 2) != 0) {
                z = state.isFetching;
            }
            if ((i & 4) != 0) {
                domainError = state.error;
            }
            return state.copy(state2, z, domainError);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CopyTextReducer.State getCopyTextState() {
            return this.copyTextState;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsFetching() {
            return this.isFetching;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final DomainError getError() {
            return this.error;
        }

        public final State copy(CopyTextReducer.State copyTextState, boolean isFetching, DomainError error) {
            Intrinsics.checkNotNullParameter(copyTextState, "copyTextState");
            return new State(copyTextState, isFetching, error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.copyTextState, state.copyTextState) && this.isFetching == state.isFetching && Intrinsics.areEqual(this.error, state.error);
        }

        public int hashCode() {
            int iHashCode = ((this.copyTextState.hashCode() * 31) + Boolean.hashCode(this.isFetching)) * 31;
            DomainError domainError = this.error;
            return iHashCode + (domainError == null ? 0 : domainError.hashCode());
        }

        public String toString() {
            return "State(copyTextState=" + this.copyTextState + ", isFetching=" + this.isFetching + ", error=" + this.error + ")";
        }

        public State(CopyTextReducer.State copyTextState, boolean z, DomainError domainError) {
            Intrinsics.checkNotNullParameter(copyTextState, "copyTextState");
            this.copyTextState = copyTextState;
            this.isFetching = z;
            this.error = domainError;
        }

        public /* synthetic */ State(CopyTextReducer.State state, boolean z, DomainError domainError, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new CopyTextReducer.State(false, false, 3, null) : state, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : domainError);
        }

        public final CopyTextReducer.State getCopyTextState() {
            return this.copyTextState;
        }

        public final boolean isFetching() {
            return this.isFetching;
        }

        public final DomainError getError() {
            return this.error;
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReducerResult<State, Action> reduceCopyLink(State state, Action action) {
        String url;
        if (action instanceof Action.CopyLinkClicked) {
            Action.CopyLinkClicked copyLinkClicked = (Action.CopyLinkClicked) action;
            SharedLinkModel sharedLink = copyLinkClicked.getItemModel().getSharedLink();
            if (sharedLink != null && (url = sharedLink.getUrl()) != null) {
                return new ReducerResult<>(state, new Effect((Flow) new Effect(new Action.CopyTextAction(new CopyTextReducer.Action.CopyText(url)))));
            }
            return new ReducerResult<>(state, new Effect(new Action.FetchSharedLink(copyLinkClicked.getItemModel().getItemId())));
        }
        if (action instanceof Action.FetchSharedLink) {
            return new ReducerResult<>(State.copy$default(state, null, true, null, 5, null), new Effect((Function1) new AnonymousClass2(action, null)));
        }
        if (action instanceof Action.FetchSuccess) {
            return new ReducerResult<>(State.copy$default(state, null, false, null, 5, null), new Effect((Flow) new Effect(new Action.CopyTextAction(new CopyTextReducer.Action.CopyText(((Action.FetchSuccess) action).getSharedLink())))));
        }
        if (action instanceof Action.Finish) {
            return new ReducerResult<>(new State(null, false, null, 7, null), null, 2, null);
        }
        if (action instanceof Action.CopyTextAction) {
            return new ReducerResult<>(state, null, 2, null);
        }
        if (!(action instanceof Action.FetchFailed)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult<>(State.copy$default(state, null, false, ((Action.FetchFailed) action).getError(), 1, null), null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.preview.fileactions.copylink.CopyLinkReducer$reduceCopyLink$2, reason: invalid class name */
    /* JADX INFO: compiled from: CopyLinkReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/preview/fileactions/copylink/CopyLinkReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.fileactions.copylink.CopyLinkReducer$reduceCopyLink$2", f = "CopyLinkReducer.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        final /* synthetic */ Action $action;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Action action, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$action = action;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return CopyLinkReducer.this.new AnonymousClass2(this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = CopyLinkReducer.this.getEnvironment().getSharedLinkService().createDefaultSharedLink(((Action.FetchSharedLink) this.$action).getFileId(), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Result result = (Result) obj;
            if (result instanceof Result.Success) {
                return new Action.FetchSuccess(((SharedLinkModel) ((Result.Success) result).getValue()).getUrl());
            }
            if (!(result instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            return new Action.FetchFailed((DomainError) ((Result.Error) result).getValue());
        }
    }
}

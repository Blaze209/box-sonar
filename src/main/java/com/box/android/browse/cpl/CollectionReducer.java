package com.box.android.browse.cpl;

import com.box.android.browse.cpl.browse.BrowseEnvironment;
import com.box.android.browse.cpl.browse.BrowseReducer;
import com.box.android.browse.cpl.itemsList.ActionableItemsListReducer;
import com.box.android.browse.cpl.itemsList.ItemsListReducer;
import com.box.android.coreservices.jobmanager.jobs.BoxItemJob;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.WebLinkModel;
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

/* JADX INFO: compiled from: CollectionReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u000f\u0010\u0011B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/CollectionReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/browse/cpl/CollectionReducer$State;", "Lcom/box/android/browse/cpl/CollectionReducer$Action;", "environment", "Lcom/box/android/browse/cpl/browse/BrowseEnvironment;", "<init>", "(Lcom/box/android/browse/cpl/browse/BrowseEnvironment;)V", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "reduceCollection", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "Route", "State", "Action", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollectionReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final BrowseEnvironment environment;

    /* JADX INFO: compiled from: CollectionReducer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/CollectionReducer$Route;", "", "<init>", "()V", "Folder", "File", "WebLink", "None", "Lcom/box/android/browse/cpl/CollectionReducer$Route$File;", "Lcom/box/android/browse/cpl/CollectionReducer$Route$Folder;", "Lcom/box/android/browse/cpl/CollectionReducer$Route$None;", "Lcom/box/android/browse/cpl/CollectionReducer$Route$WebLink;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Route {
        public static final int $stable = 0;

        public /* synthetic */ Route(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: CollectionReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/CollectionReducer$Route$Folder;", "Lcom/box/android/browse/cpl/CollectionReducer$Route;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$State;", "state", "<init>", "(Lcom/box/android/browse/cpl/browse/BrowseReducer$State;)V", "getState", "()Lcom/box/android/browse/cpl/browse/BrowseReducer$State;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Folder extends Route implements Embedded<BrowseReducer.State> {
            public static final int $stable = 8;
            private final BrowseReducer.State state;

            public static /* synthetic */ Folder copy$default(Folder folder, BrowseReducer.State state, int i, Object obj) {
                if ((i & 1) != 0) {
                    state = folder.state;
                }
                return folder.copy(state);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BrowseReducer.State getItem() {
                return this.state;
            }

            public final Folder copy(BrowseReducer.State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return new Folder(state);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Folder) && Intrinsics.areEqual(this.state, ((Folder) other).state);
            }

            public int hashCode() {
                return this.state.hashCode();
            }

            public String toString() {
                return "Folder(state=" + this.state + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Folder(BrowseReducer.State state) {
                super(null);
                Intrinsics.checkNotNullParameter(state, "state");
                this.state = state;
            }

            public final BrowseReducer.State getState() {
                return this.state;
            }
        }

        private Route() {
        }

        /* JADX INFO: compiled from: CollectionReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/CollectionReducer$Route$File;", "Lcom/box/android/browse/cpl/CollectionReducer$Route;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/domain/models/item/FileModel;", "file", "<init>", "(Lcom/box/android/domain/models/item/FileModel;)V", "getFile", "()Lcom/box/android/domain/models/item/FileModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class File extends Route implements Embedded<FileModel> {
            public static final int $stable = 8;
            private final FileModel file;

            public static /* synthetic */ File copy$default(File file, FileModel fileModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileModel = file.file;
                }
                return file.copy(fileModel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FileModel getItem() {
                return this.file;
            }

            public final File copy(FileModel file) {
                Intrinsics.checkNotNullParameter(file, "file");
                return new File(file);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof File) && Intrinsics.areEqual(this.file, ((File) other).file);
            }

            public int hashCode() {
                return this.file.hashCode();
            }

            public String toString() {
                return "File(file=" + this.file + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public File(FileModel file) {
                super(null);
                Intrinsics.checkNotNullParameter(file, "file");
                this.file = file;
            }

            public final FileModel getFile() {
                return this.file;
            }
        }

        /* JADX INFO: compiled from: CollectionReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/CollectionReducer$Route$WebLink;", "Lcom/box/android/browse/cpl/CollectionReducer$Route;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/domain/models/item/WebLinkModel;", "webLink", "<init>", "(Lcom/box/android/domain/models/item/WebLinkModel;)V", "getWebLink", "()Lcom/box/android/domain/models/item/WebLinkModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class WebLink extends Route implements Embedded<WebLinkModel> {
            public static final int $stable = 8;
            private final WebLinkModel webLink;

            public static /* synthetic */ WebLink copy$default(WebLink webLink, WebLinkModel webLinkModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    webLinkModel = webLink.webLink;
                }
                return webLink.copy(webLinkModel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final WebLinkModel getItem() {
                return this.webLink;
            }

            public final WebLink copy(WebLinkModel webLink) {
                Intrinsics.checkNotNullParameter(webLink, "webLink");
                return new WebLink(webLink);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof WebLink) && Intrinsics.areEqual(this.webLink, ((WebLink) other).webLink);
            }

            public int hashCode() {
                return this.webLink.hashCode();
            }

            public String toString() {
                return "WebLink(webLink=" + this.webLink + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public WebLink(WebLinkModel webLink) {
                super(null);
                Intrinsics.checkNotNullParameter(webLink, "webLink");
                this.webLink = webLink;
            }

            public final WebLinkModel getWebLink() {
                return this.webLink;
            }
        }

        /* JADX INFO: compiled from: CollectionReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/browse/cpl/CollectionReducer$Route$None;", "Lcom/box/android/browse/cpl/CollectionReducer$Route;", "<init>", "()V", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class None extends Route {
            public static final int $stable = 0;
            public static final None INSTANCE = new None();

            private None() {
                super(null);
            }
        }
    }

    public CollectionReducer(BrowseEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new CollectionReducer$build$1(this));
        final CollectionReducer$build$2 collectionReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.CollectionReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((CollectionReducer.State) obj).getNavigationRoute();
            }
        };
        final CollectionReducer$build$3 collectionReducer$build$3 = CollectionReducer$build$3.INSTANCE;
        final CollectionReducer$build$4 collectionReducer$build$4 = CollectionReducer$build$4.INSTANCE;
        this.build = new IfLetReducer(reduce, new BrowseReducer(environment), new Function1<State, BrowseReducer.State>() { // from class: com.box.android.browse.cpl.CollectionReducer$special$$inlined$ifCaseScope$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final BrowseReducer.State invoke(CollectionReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Object objInvoke = collectionReducer$build$2.invoke(it);
                if (!(objInvoke instanceof CollectionReducer.Route.Folder)) {
                    objInvoke = null;
                }
                CollectionReducer.Route.Folder folder = (CollectionReducer.Route.Folder) objInvoke;
                if (folder != null) {
                    return folder.getItem();
                }
                return null;
            }
        }, new Function1<Action, BrowseReducer.Action>() { // from class: com.box.android.browse.cpl.CollectionReducer$special$$inlined$ifCaseScope$2
            @Override // kotlin.jvm.functions.Function1
            public final BrowseReducer.Action invoke(CollectionReducer.Action action) {
                if (!(action instanceof CollectionReducer.Action.ChildBrowseAction)) {
                    action = null;
                }
                CollectionReducer.Action.ChildBrowseAction childBrowseAction = (CollectionReducer.Action.ChildBrowseAction) action;
                if (childBrowseAction != null) {
                    return childBrowseAction.getItem();
                }
                return null;
            }
        }, new Function2<State, BrowseReducer.State, State>() { // from class: com.box.android.browse.cpl.CollectionReducer$special$$inlined$ifCaseScope$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final CollectionReducer.State invoke(CollectionReducer.State parentState, BrowseReducer.State childState) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                Intrinsics.checkNotNullParameter(childState, "childState");
                KProperty1 kProperty1 = collectionReducer$build$2;
                Object objInvoke = collectionReducer$build$3.invoke(childState);
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(CollectionReducer.State.class)).iterator();
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
                        R rCallBy = kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, parentState), TuplesKt.to(kParameter, objInvoke)));
                        if (rCallBy != 0) {
                            return (CollectionReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.CollectionReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<BrowseReducer.Action, Action>() { // from class: com.box.android.browse.cpl.CollectionReducer$special$$inlined$ifCaseScope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CollectionReducer.Action invoke(BrowseReducer.Action action) {
                Object objInvoke = collectionReducer$build$4.invoke(action);
                if (objInvoke != null) {
                    return (CollectionReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.CollectionReducer.Action");
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: CollectionReducer.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/box/android/browse/cpl/CollectionReducer$State;", "Lcom/box/android/browse/cpl/NestedViewState;", "collectionName", "", BoxItemJob.COLLECTION_ID, "navigationRoute", "Lcom/box/android/browse/cpl/CollectionReducer$Route;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/browse/cpl/CollectionReducer$Route;)V", "getCollectionName", "()Ljava/lang/String;", "getCollectionId", "getNavigationRoute", "()Lcom/box/android/browse/cpl/CollectionReducer$Route;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State extends NestedViewState {
        public static final int $stable = 0;
        private final String collectionId;
        private final String collectionName;
        private final Route navigationRoute;

        public static /* synthetic */ State copy$default(State state, String str, String str2, Route route, int i, Object obj) {
            if ((i & 1) != 0) {
                str = state.collectionName;
            }
            if ((i & 2) != 0) {
                str2 = state.collectionId;
            }
            if ((i & 4) != 0) {
                route = state.navigationRoute;
            }
            return state.copy(str, str2, route);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getCollectionName() {
            return this.collectionName;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getCollectionId() {
            return this.collectionId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Route getNavigationRoute() {
            return this.navigationRoute;
        }

        public final State copy(String collectionName, String collectionId, Route navigationRoute) {
            Intrinsics.checkNotNullParameter(collectionName, "collectionName");
            Intrinsics.checkNotNullParameter(collectionId, "collectionId");
            Intrinsics.checkNotNullParameter(navigationRoute, "navigationRoute");
            return new State(collectionName, collectionId, navigationRoute);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.collectionName, state.collectionName) && Intrinsics.areEqual(this.collectionId, state.collectionId) && Intrinsics.areEqual(this.navigationRoute, state.navigationRoute);
        }

        public int hashCode() {
            return (((this.collectionName.hashCode() * 31) + this.collectionId.hashCode()) * 31) + this.navigationRoute.hashCode();
        }

        public String toString() {
            return "State(collectionName=" + this.collectionName + ", collectionId=" + this.collectionId + ", navigationRoute=" + this.navigationRoute + ")";
        }

        public State(String collectionName, String collectionId, Route navigationRoute) {
            Intrinsics.checkNotNullParameter(collectionName, "collectionName");
            Intrinsics.checkNotNullParameter(collectionId, "collectionId");
            Intrinsics.checkNotNullParameter(navigationRoute, "navigationRoute");
            this.collectionName = collectionName;
            this.collectionId = collectionId;
            this.navigationRoute = navigationRoute;
        }

        public /* synthetic */ State(String str, String str2, Route.None none, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? Route.None.INSTANCE : none);
        }

        public final String getCollectionId() {
            return this.collectionId;
        }

        public final String getCollectionName() {
            return this.collectionName;
        }

        public final Route getNavigationRoute() {
            return this.navigationRoute;
        }
    }

    /* JADX INFO: compiled from: CollectionReducer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/browse/cpl/CollectionReducer$Action;", "", "<init>", "()V", "NavigateToFolder", "OpenItem", "ChildBrowseAction", "NavigationCompleted", "Lcom/box/android/browse/cpl/CollectionReducer$Action$ChildBrowseAction;", "Lcom/box/android/browse/cpl/CollectionReducer$Action$NavigateToFolder;", "Lcom/box/android/browse/cpl/CollectionReducer$Action$NavigationCompleted;", "Lcom/box/android/browse/cpl/CollectionReducer$Action$OpenItem;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: CollectionReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/CollectionReducer$Action$NavigateToFolder;", "Lcom/box/android/browse/cpl/CollectionReducer$Action;", "folder", "Lcom/box/android/domain/models/item/FolderModel;", "<init>", "(Lcom/box/android/domain/models/item/FolderModel;)V", "getFolder", "()Lcom/box/android/domain/models/item/FolderModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class NavigateToFolder extends Action {
            public static final int $stable = 8;
            private final FolderModel folder;

            public static /* synthetic */ NavigateToFolder copy$default(NavigateToFolder navigateToFolder, FolderModel folderModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    folderModel = navigateToFolder.folder;
                }
                return navigateToFolder.copy(folderModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FolderModel getFolder() {
                return this.folder;
            }

            public final NavigateToFolder copy(FolderModel folder) {
                Intrinsics.checkNotNullParameter(folder, "folder");
                return new NavigateToFolder(folder);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NavigateToFolder) && Intrinsics.areEqual(this.folder, ((NavigateToFolder) other).folder);
            }

            public int hashCode() {
                return this.folder.hashCode();
            }

            public String toString() {
                return "NavigateToFolder(folder=" + this.folder + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NavigateToFolder(FolderModel folder) {
                super(null);
                Intrinsics.checkNotNullParameter(folder, "folder");
                this.folder = folder;
            }

            public final FolderModel getFolder() {
                return this.folder;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: CollectionReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/cpl/CollectionReducer$Action$OpenItem;", "Lcom/box/android/browse/cpl/CollectionReducer$Action;", "item", "Lcom/box/android/domain/models/item/ItemModel;", "<init>", "(Lcom/box/android/domain/models/item/ItemModel;)V", "getItem", "()Lcom/box/android/domain/models/item/ItemModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class OpenItem extends Action {
            public static final int $stable = 8;
            private final ItemModel item;

            public static /* synthetic */ OpenItem copy$default(OpenItem openItem, ItemModel itemModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    itemModel = openItem.item;
                }
                return openItem.copy(itemModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemModel getItem() {
                return this.item;
            }

            public final OpenItem copy(ItemModel item) {
                Intrinsics.checkNotNullParameter(item, "item");
                return new OpenItem(item);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof OpenItem) && Intrinsics.areEqual(this.item, ((OpenItem) other).item);
            }

            public int hashCode() {
                return this.item.hashCode();
            }

            public String toString() {
                return "OpenItem(item=" + this.item + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OpenItem(ItemModel item) {
                super(null);
                Intrinsics.checkNotNullParameter(item, "item");
                this.item = item;
            }

            public final ItemModel getItem() {
                return this.item;
            }
        }

        /* JADX INFO: compiled from: CollectionReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/CollectionReducer$Action$ChildBrowseAction;", "Lcom/box/android/browse/cpl/CollectionReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;)V", "getAction", "()Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ChildBrowseAction extends Action implements Embedded<BrowseReducer.Action> {
            public static final int $stable = 0;
            private final BrowseReducer.Action action;

            public static /* synthetic */ ChildBrowseAction copy$default(ChildBrowseAction childBrowseAction, BrowseReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = childBrowseAction.action;
                }
                return childBrowseAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BrowseReducer.Action getItem() {
                return this.action;
            }

            public final ChildBrowseAction copy(BrowseReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new ChildBrowseAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ChildBrowseAction) && Intrinsics.areEqual(this.action, ((ChildBrowseAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "ChildBrowseAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ChildBrowseAction(BrowseReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final BrowseReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: CollectionReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/browse/cpl/CollectionReducer$Action$NavigationCompleted;", "Lcom/box/android/browse/cpl/CollectionReducer$Action;", "<init>", "()V", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class NavigationCompleted extends Action {
            public static final int $stable = 0;
            public static final NavigationCompleted INSTANCE = new NavigationCompleted();

            private NavigationCompleted() {
                super(null);
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final ReducerResult<State, Action> reduceCollection(State state, Action action) {
        Route webLink;
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
        if (action instanceof Action.OpenItem) {
            Action.OpenItem openItem = (Action.OpenItem) action;
            ItemModel item = openItem.getItem();
            if (item instanceof FolderModel) {
                Object[] objArr10 = 0 == true ? 1 : 0;
                Object[] objArr11 = 0 == true ? 1 : 0;
                Object[] objArr12 = 0 == true ? 1 : 0;
                Object[] objArr13 = 0 == true ? 1 : 0;
                Object[] objArr14 = 0 == true ? 1 : 0;
                BrowseReducer.Route route = null;
                boolean z = false;
                Object[] objArr15 = 0 == true ? 1 : 0;
                Object[] objArr16 = 0 == true ? 1 : 0;
                webLink = new Route.Folder(new BrowseReducer.State(new ActionableItemsListReducer.State(new ItemsListReducer.State(null, null, null, (FolderModel) openItem.getItem(), false, null, null, false, null, null, null, null, null, null, false, false, 65527, null), objArr10, objArr11, objArr12, null, null, objArr13, objArr14, null, 510, 0 == true ? 1 : 0), route, objArr15, z, objArr16, 30, 0 == true ? 1 : 0));
            } else if (item instanceof FileModel) {
                webLink = new Route.File((FileModel) openItem.getItem());
            } else {
                webLink = item instanceof WebLinkModel ? new Route.WebLink((WebLinkModel) openItem.getItem()) : null;
            }
            if (webLink != null) {
                return new ReducerResult<>(State.copy$default(state, null, null, webLink, 3, null), effect, i, objArr9 == true ? 1 : 0);
            }
            return new ReducerResult<>(state, objArr8 == true ? 1 : 0, i, objArr7 == true ? 1 : 0);
        }
        if (action instanceof Action.ChildBrowseAction) {
            if (((Action.ChildBrowseAction) action).getAction() instanceof BrowseReducer.Action.CloseScreen) {
                return new ReducerResult<>(State.copy$default(state, null, null, Route.None.INSTANCE, 3, null), objArr6 == true ? 1 : 0, i, objArr5 == true ? 1 : 0);
            }
            return new ReducerResult<>(state, objArr4 == true ? 1 : 0, i, objArr3 == true ? 1 : 0);
        }
        if (action instanceof Action.NavigateToFolder) {
            return new ReducerResult<>(state, new Effect(new Action.ChildBrowseAction(new BrowseReducer.Action.NavigateToFolder(((Action.NavigateToFolder) action).getFolder()))));
        }
        if (!(action instanceof Action.NavigationCompleted)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult<>(State.copy$default(state, null, null, Route.None.INSTANCE, 3, null), objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
    }
}

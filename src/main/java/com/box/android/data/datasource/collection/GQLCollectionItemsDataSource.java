package com.box.android.data.datasource.collection;

import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;
import com.apollographql.apollo3.api.ApolloResponse;
import com.box.android.coreservices.jobmanager.jobs.BoxItemJob;
import com.box.android.data.GetCollectionItemsQuery;
import com.box.android.data.datasource.gql.BoxGraphQL;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.facebook.react.modules.dialog.AlertFragment;
import com.microsoft.identity.common.internal.broker.SerializedNames;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;

/* JADX INFO: compiled from: GQLCollectionItemsDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 (2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002'(B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u0012\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0018\u00010\u000e2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0014\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000f0\u000eH\u0002J \u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0019\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u001aJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001c\u001a\u00020\u0003H\u0002J*\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020 2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\"H\u0016J*\u0010#\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020$2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030%H\u0016J*\u0010&\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020$2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030%H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/box/android/data/datasource/collection/GQLCollectionItemsDataSource;", "Landroidx/paging/PageKeyedDataSource;", "", "Lcom/box/android/data/GetCollectionItemsQuery$Node;", "graphQL", "Lcom/box/android/data/datasource/gql/BoxGraphQL;", BoxItemJob.COLLECTION_ID, "<init>", "(Lcom/box/android/data/datasource/gql/BoxGraphQL;Ljava/lang/String;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "cachedItems", "", "nodeFlow", "Lkotlinx/coroutines/flow/Flow;", "", "totalCount", "", "gqlGetCollectionItemsQueryFromCache", "Lcom/apollographql/apollo3/api/ApolloResponse;", "Lcom/box/android/data/GetCollectionItemsQuery$Data;", "watchQuery", "getPage", "Lcom/box/android/data/datasource/collection/GQLCollectionItemsDataSource$Page;", "startKey", "pageSize", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIdForNode", "node", "loadInitial", "", SerializedNames.PARAMS, "Landroidx/paging/PageKeyedDataSource$LoadInitialParams;", "callback", "Landroidx/paging/PageKeyedDataSource$LoadInitialCallback;", "loadBefore", "Landroidx/paging/PageKeyedDataSource$LoadParams;", "Landroidx/paging/PageKeyedDataSource$LoadCallback;", "loadAfter", "Page", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLCollectionItemsDataSource extends PageKeyedDataSource<String, GetCollectionItemsQuery.Node> {
    private static final String FILE_ID_PREFIX = "File.";
    private static final String FOLDER_ID_PREFIX = "Folder.";
    private static final String WEBLINK_ID_PREFIX = "Weblink.";
    private List<GetCollectionItemsQuery.Node> cachedItems;
    private final String collectionId;
    private final CoroutineScope coroutineScope;
    private final BoxGraphQL graphQL;
    private Flow<? extends List<GetCollectionItemsQuery.Node>> nodeFlow;
    private int totalCount;

    @Override // androidx.paging.PageKeyedDataSource
    public void loadBefore(PageKeyedDataSource.LoadParams<String> params, PageKeyedDataSource.LoadCallback<String, GetCollectionItemsQuery.Node> callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Inject
    public GQLCollectionItemsDataSource(BoxGraphQL graphQL, String collectionId) {
        Intrinsics.checkNotNullParameter(graphQL, "graphQL");
        Intrinsics.checkNotNullParameter(collectionId, "collectionId");
        this.graphQL = graphQL;
        this.collectionId = collectionId;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        this.nodeFlow = watchQuery();
        addInvalidatedCallback(new DataSource.InvalidatedCallback() { // from class: com.box.android.data.datasource.collection.GQLCollectionItemsDataSource$$ExternalSyntheticLambda0
            @Override // androidx.paging.DataSource.InvalidatedCallback
            public final void onInvalidated() {
                GQLCollectionItemsDataSource._init_$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: compiled from: GQLCollectionItemsDataSource.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/box/android/data/datasource/collection/GQLCollectionItemsDataSource$Page;", "", AlertFragment.ARG_ITEMS, "", "Lcom/box/android/data/GetCollectionItemsQuery$Node;", "prevKey", "", "nextKey", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getItems", "()Ljava/util/List;", "getPrevKey", "()Ljava/lang/String;", "getNextKey", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Page {
        private final List<GetCollectionItemsQuery.Node> items;
        private final String nextKey;
        private final String prevKey;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Page copy$default(Page page, List list, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = page.items;
            }
            if ((i & 2) != 0) {
                str = page.prevKey;
            }
            if ((i & 4) != 0) {
                str2 = page.nextKey;
            }
            return page.copy(list, str, str2);
        }

        public final List<GetCollectionItemsQuery.Node> component1() {
            return this.items;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getPrevKey() {
            return this.prevKey;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getNextKey() {
            return this.nextKey;
        }

        public final Page copy(List<GetCollectionItemsQuery.Node> items, String prevKey, String nextKey) {
            Intrinsics.checkNotNullParameter(items, "items");
            return new Page(items, prevKey, nextKey);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Page)) {
                return false;
            }
            Page page = (Page) other;
            return Intrinsics.areEqual(this.items, page.items) && Intrinsics.areEqual(this.prevKey, page.prevKey) && Intrinsics.areEqual(this.nextKey, page.nextKey);
        }

        public int hashCode() {
            int iHashCode = this.items.hashCode() * 31;
            String str = this.prevKey;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.nextKey;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Page(items=" + this.items + ", prevKey=" + this.prevKey + ", nextKey=" + this.nextKey + ")";
        }

        public Page(List<GetCollectionItemsQuery.Node> items, String str, String str2) {
            Intrinsics.checkNotNullParameter(items, "items");
            this.items = items;
            this.prevKey = str;
            this.nextKey = str2;
        }

        public final List<GetCollectionItemsQuery.Node> getItems() {
            return this.items;
        }

        public final String getNextKey() {
            return this.nextKey;
        }

        public final String getPrevKey() {
            return this.prevKey;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(GQLCollectionItemsDataSource gQLCollectionItemsDataSource) {
        CoroutineScopeKt.cancel$default(gQLCollectionItemsDataSource.coroutineScope, null, 1, null);
        BoxLogUtils.d(ExtensionsKt.getTAG(gQLCollectionItemsDataSource), "Invalidated " + ExtensionsKt.getTAG(gQLCollectionItemsDataSource) + ", cancelling coroutineScope");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flow<ApolloResponse<GetCollectionItemsQuery.Data>> gqlGetCollectionItemsQueryFromCache(String collectionId) {
        return this.graphQL.getCollectionsItemsWatcher(collectionId);
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.collection.GQLCollectionItemsDataSource$watchQuery$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GQLCollectionItemsDataSource.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lcom/box/android/data/GetCollectionItemsQuery$Node;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.collection.GQLCollectionItemsDataSource$watchQuery$1", f = "GQLCollectionItemsDataSource.kt", i = {0, 1}, l = {48, 75}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"}, v = 1)
    static final class C11291 extends SuspendLambda implements Function2<FlowCollector<? super List<? extends GetCollectionItemsQuery.Node>>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C11291(Continuation<? super C11291> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C11291 c11291 = GQLCollectionItemsDataSource.this.new C11291(continuation);
            c11291.L$0 = obj;
            return c11291;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super List<? extends GetCollectionItemsQuery.Node>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super List<GetCollectionItemsQuery.Node>>) flowCollector, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super List<GetCollectionItemsQuery.Node>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C11291) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x006c, code lost:
        
            if (r8.collect(new com.box.android.data.datasource.collection.GQLCollectionItemsDataSource.C11291.AnonymousClass2(r7.this$0, r0), r7) == r1) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0082, code lost:
        
            if (r0.emit(kotlin.collections.CollectionsKt.emptyList(), r7) == r1) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0084, code lost:
        
            return r1;
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
                if (r2 == 0) goto L1f
                if (r2 == r4) goto L1b
                if (r2 != r3) goto L13
                goto L1b
            L13:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L1b:
                kotlin.ResultKt.throwOnFailure(r8)
                goto L85
            L1f:
                kotlin.ResultKt.throwOnFailure(r8)
                java.lang.String r8 = com.box.android.domain.utils.ExtensionsKt.getTAG(r0)
                com.box.android.data.datasource.collection.GQLCollectionItemsDataSource r2 = com.box.android.data.datasource.collection.GQLCollectionItemsDataSource.this
                java.lang.String r2 = com.box.android.data.datasource.collection.GQLCollectionItemsDataSource.access$getCollectionId$p(r2)
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                java.lang.String r6 = "Watching QUERY for collection ID "
                r5.<init>(r6)
                java.lang.StringBuilder r2 = r5.append(r2)
                java.lang.String r2 = r2.toString()
                com.box.androidsdk.content.utils.BoxLogUtils.v(r8, r2)
                com.box.android.data.datasource.collection.GQLCollectionItemsDataSource r8 = com.box.android.data.datasource.collection.GQLCollectionItemsDataSource.this
                java.lang.String r2 = com.box.android.data.datasource.collection.GQLCollectionItemsDataSource.access$getCollectionId$p(r8)
                kotlinx.coroutines.flow.Flow r8 = com.box.android.data.datasource.collection.GQLCollectionItemsDataSource.access$gqlGetCollectionItemsQueryFromCache(r8, r2)
                if (r8 == 0) goto L6f
                com.box.android.data.datasource.collection.GQLCollectionItemsDataSource$watchQuery$1$1 r2 = new com.box.android.data.datasource.collection.GQLCollectionItemsDataSource$watchQuery$1$1
                r5 = 0
                r2.<init>(r5)
                kotlin.jvm.functions.Function3 r2 = (kotlin.jvm.functions.Function3) r2
                kotlinx.coroutines.flow.Flow r8 = kotlinx.coroutines.flow.FlowKt.m16356catch(r8, r2)
                if (r8 == 0) goto L6f
                com.box.android.data.datasource.collection.GQLCollectionItemsDataSource$watchQuery$1$2 r2 = new com.box.android.data.datasource.collection.GQLCollectionItemsDataSource$watchQuery$1$2
                com.box.android.data.datasource.collection.GQLCollectionItemsDataSource r3 = com.box.android.data.datasource.collection.GQLCollectionItemsDataSource.this
                r2.<init>(r3, r0)
                kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
                r3 = r7
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                r7.L$0 = r0
                r7.label = r4
                java.lang.Object r7 = r8.collect(r2, r3)
                if (r7 != r1) goto L85
                goto L84
            L6f:
                java.util.List r8 = kotlin.collections.CollectionsKt.emptyList()
                r2 = r7
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r7.L$0 = r4
                r7.label = r3
                java.lang.Object r7 = r0.emit(r8, r2)
                if (r7 != r1) goto L85
            L84:
                return r1
            L85:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.collection.GQLCollectionItemsDataSource.C11291.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.box.android.data.datasource.collection.GQLCollectionItemsDataSource$watchQuery$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: GQLCollectionItemsDataSource.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/apollographql/apollo3/api/ApolloResponse;", "Lcom/box/android/data/GetCollectionItemsQuery$Data;", "it", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.data.datasource.collection.GQLCollectionItemsDataSource$watchQuery$1$1", f = "GQLCollectionItemsDataSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C01601 extends SuspendLambda implements Function3<FlowCollector<? super ApolloResponse<GetCollectionItemsQuery.Data>>, Throwable, Continuation<? super Unit>, Object> {
            int label;

            C01601(Continuation<? super C01601> continuation) {
                super(3, continuation);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(FlowCollector<? super ApolloResponse<GetCollectionItemsQuery.Data>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                return new C01601(continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.box.android.data.datasource.collection.GQLCollectionItemsDataSource$watchQuery$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: GQLCollectionItemsDataSource.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        static final class AnonymousClass2<T> implements FlowCollector {
            final /* synthetic */ FlowCollector<List<GetCollectionItemsQuery.Node>> $$this$flow;
            final /* synthetic */ GQLCollectionItemsDataSource this$0;

            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass2(GQLCollectionItemsDataSource gQLCollectionItemsDataSource, FlowCollector<? super List<GetCollectionItemsQuery.Node>> flowCollector) {
                this.this$0 = gQLCollectionItemsDataSource;
                this.$$this$flow = flowCollector;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0014  */
            /* JADX WARN: Code restructure failed: missing block: B:55:0x015a, code lost:
            
                if (r10.emit(r3, r0) == r1) goto L59;
             */
            /* JADX WARN: Code restructure failed: missing block: B:58:0x0190, code lost:
            
                if (r10.emit(r2, r0) == r1) goto L59;
             */
            /* JADX WARN: Code restructure failed: missing block: B:59:0x0192, code lost:
            
                return r1;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(com.apollographql.apollo3.api.ApolloResponse<com.box.android.data.GetCollectionItemsQuery.Data> r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
                /*
                    Method dump skipped, instruction units count: 412
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.collection.GQLCollectionItemsDataSource.C11291.AnonymousClass2.emit(com.apollographql.apollo3.api.ApolloResponse, kotlin.coroutines.Continuation):java.lang.Object");
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((ApolloResponse<GetCollectionItemsQuery.Data>) obj, (Continuation<? super Unit>) continuation);
            }
        }
    }

    private final synchronized Flow<List<GetCollectionItemsQuery.Node>> watchQuery() {
        return FlowKt.shareIn(FlowKt.flow(new C11291(null)), this.coroutineScope, SharingStarted.INSTANCE.getLazily(), 1);
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.collection.GQLCollectionItemsDataSource$getPage$2, reason: invalid class name */
    /* JADX INFO: compiled from: GQLCollectionItemsDataSource.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/box/android/data/datasource/collection/GQLCollectionItemsDataSource$Page;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.collection.GQLCollectionItemsDataSource$getPage$2", f = "GQLCollectionItemsDataSource.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Page>, Object> {
        final /* synthetic */ int $pageSize;
        final /* synthetic */ String $startKey;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, int i, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$startKey = str;
            this.$pageSize = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GQLCollectionItemsDataSource.this.new AnonymousClass2(this.$startKey, this.$pageSize, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Page> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            List listSubList;
            String idForNode;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = FlowKt.first(GQLCollectionItemsDataSource.this.nodeFlow, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            List list = (List) obj;
            String str = this.$startKey;
            int i2 = 0;
            if (str != null) {
                GQLCollectionItemsDataSource gQLCollectionItemsDataSource = GQLCollectionItemsDataSource.this;
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        i2 = -1;
                        break;
                    }
                    if (Intrinsics.areEqual(gQLCollectionItemsDataSource.getIdForNode((GetCollectionItemsQuery.Node) it.next()), str)) {
                        break;
                    }
                    i2++;
                }
            }
            if (this.$pageSize + i2 > list.size()) {
                listSubList = list.subList(i2, list.size());
            } else {
                listSubList = list.subList(i2, this.$pageSize + i2);
            }
            if (listSubList.size() + i2 < GQLCollectionItemsDataSource.this.totalCount) {
                idForNode = GQLCollectionItemsDataSource.this.getIdForNode((GetCollectionItemsQuery.Node) list.get(i2 + listSubList.size()));
            } else {
                idForNode = null;
            }
            return new Page(listSubList, null, idForNode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getPage(String str, int i, Continuation<? super Page> continuation) {
        return BuildersKt.withContext(this.coroutineScope.getCoroutineContext(), new AnonymousClass2(str, i, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getIdForNode(GetCollectionItemsQuery.Node node) {
        if (node.getOnFile() != null) {
            return FILE_ID_PREFIX + node.getOnFile().getId();
        }
        if (node.getOnFolder() != null) {
            return FOLDER_ID_PREFIX + node.getOnFolder().getId();
        }
        if (node.getOnWeblink() == null) {
            return null;
        }
        return WEBLINK_ID_PREFIX + node.getOnWeblink().getId();
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.collection.GQLCollectionItemsDataSource$loadInitial$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GQLCollectionItemsDataSource.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.collection.GQLCollectionItemsDataSource$loadInitial$1", f = "GQLCollectionItemsDataSource.kt", i = {0}, l = {135}, m = "invokeSuspend", n = {"$this$runBlocking"}, s = {"L$0"}, v = 1)
    static final class C11281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PageKeyedDataSource.LoadInitialCallback<String, GetCollectionItemsQuery.Node> $callback;
        final /* synthetic */ PageKeyedDataSource.LoadInitialParams<String> $params;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11281(PageKeyedDataSource.LoadInitialParams<String> loadInitialParams, PageKeyedDataSource.LoadInitialCallback<String, GetCollectionItemsQuery.Node> loadInitialCallback, Continuation<? super C11281> continuation) {
            super(2, continuation);
            this.$params = loadInitialParams;
            this.$callback = loadInitialCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C11281 c11281 = GQLCollectionItemsDataSource.this.new C11281(this.$params, this.$callback, continuation);
            c11281.L$0 = obj;
            return c11281;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C11281) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.box.android.data.datasource.collection.GQLCollectionItemsDataSource$loadInitial$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: GQLCollectionItemsDataSource.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.data.datasource.collection.GQLCollectionItemsDataSource$loadInitial$1$1", f = "GQLCollectionItemsDataSource.kt", i = {}, l = {136}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C01591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PageKeyedDataSource.LoadInitialCallback<String, GetCollectionItemsQuery.Node> $callback;
            final /* synthetic */ PageKeyedDataSource.LoadInitialParams<String> $params;
            int label;
            final /* synthetic */ GQLCollectionItemsDataSource this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01591(GQLCollectionItemsDataSource gQLCollectionItemsDataSource, PageKeyedDataSource.LoadInitialParams<String> loadInitialParams, PageKeyedDataSource.LoadInitialCallback<String, GetCollectionItemsQuery.Node> loadInitialCallback, Continuation<? super C01591> continuation) {
                super(2, continuation);
                this.this$0 = gQLCollectionItemsDataSource;
                this.$params = loadInitialParams;
                this.$callback = loadInitialCallback;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01591(this.this$0, this.$params, this.$callback, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01591) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = this.this$0.getPage(null, this.$params.requestedLoadSize, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Page page = (Page) obj;
                this.$callback.onResult(page.getItems(), 0, page.getItems().size(), page.getPrevKey(), page.getNextKey());
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.label = 1;
                if (BuildersKt.withContext(coroutineScope.getCoroutineContext(), new C01591(GQLCollectionItemsDataSource.this, this.$params, this.$callback, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.paging.PageKeyedDataSource
    public void loadInitial(PageKeyedDataSource.LoadInitialParams<String> params, PageKeyedDataSource.LoadInitialCallback<String, GetCollectionItemsQuery.Node> callback) throws InterruptedException {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__BuildersKt.runBlocking$default(null, new C11281(params, callback, null), 1, null);
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.collection.GQLCollectionItemsDataSource$loadAfter$1, reason: invalid class name */
    /* JADX INFO: compiled from: GQLCollectionItemsDataSource.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.collection.GQLCollectionItemsDataSource$loadAfter$1", f = "GQLCollectionItemsDataSource.kt", i = {0}, l = {150}, m = "invokeSuspend", n = {"$this$runBlocking"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PageKeyedDataSource.LoadCallback<String, GetCollectionItemsQuery.Node> $callback;
        final /* synthetic */ PageKeyedDataSource.LoadParams<String> $params;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PageKeyedDataSource.LoadParams<String> loadParams, PageKeyedDataSource.LoadCallback<String, GetCollectionItemsQuery.Node> loadCallback, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$params = loadParams;
            this.$callback = loadCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = GQLCollectionItemsDataSource.this.new AnonymousClass1(this.$params, this.$callback, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.box.android.data.datasource.collection.GQLCollectionItemsDataSource$loadAfter$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: GQLCollectionItemsDataSource.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.data.datasource.collection.GQLCollectionItemsDataSource$loadAfter$1$1", f = "GQLCollectionItemsDataSource.kt", i = {}, l = {Token.TO_DOUBLE}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C01581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PageKeyedDataSource.LoadCallback<String, GetCollectionItemsQuery.Node> $callback;
            final /* synthetic */ PageKeyedDataSource.LoadParams<String> $params;
            int label;
            final /* synthetic */ GQLCollectionItemsDataSource this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01581(GQLCollectionItemsDataSource gQLCollectionItemsDataSource, PageKeyedDataSource.LoadParams<String> loadParams, PageKeyedDataSource.LoadCallback<String, GetCollectionItemsQuery.Node> loadCallback, Continuation<? super C01581> continuation) {
                super(2, continuation);
                this.this$0 = gQLCollectionItemsDataSource;
                this.$params = loadParams;
                this.$callback = loadCallback;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01581(this.this$0, this.$params, this.$callback, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01581) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = this.this$0.getPage(this.$params.key, this.$params.requestedLoadSize, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Page page = (Page) obj;
                this.$callback.onResult(page.getItems(), page.getNextKey());
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.label = 1;
                if (BuildersKt.withContext(coroutineScope.getCoroutineContext(), new C01581(GQLCollectionItemsDataSource.this, this.$params, this.$callback, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.paging.PageKeyedDataSource
    public void loadAfter(PageKeyedDataSource.LoadParams<String> params, PageKeyedDataSource.LoadCallback<String, GetCollectionItemsQuery.Node> callback) throws InterruptedException {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(params, callback, null), 1, null);
    }
}

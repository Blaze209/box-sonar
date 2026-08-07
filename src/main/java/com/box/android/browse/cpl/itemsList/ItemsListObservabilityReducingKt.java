package com.box.android.browse.cpl.itemsList;

import com.box.android.base.presentation.multiselect.MultiselectReducer;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.coreservices.observability.appstart.AppStartDestinationPageType;
import com.box.android.cpl.Effect;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.models.observability.ApdexType;
import com.box.android.domain.models.observability.FolderNavApdex;
import com.box.android.domain.models.observability.RecentsLoadApdex;
import com.box.android.domain.models.observability.RecentsNavApdex;
import com.box.android.domain.models.observability.RootFolderLoadApdex;
import com.box.android.domain.models.observability.RootFolderNavApdex;
import com.pspdfkit.analytics.Analytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemsListObservabilityReducing.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0003\u001a \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u001e\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0010\u001a\u001e\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0010\u001a\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a\u001e\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u0014\u001a\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0002\u001a\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u000fH\u0002¨\u0006\u0019"}, d2 = {"reduceObservability", "Lcom/box/android/cpl/ReducerResult;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$State;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$Action;", "Lcom/box/android/browse/cpl/itemsList/ItemsListReducer;", "state", Analytics.Data.ACTION, "startFolderNavApdexIfNecessary", "", "environment", "Lcom/box/android/browse/cpl/itemsList/IItemsListViewEnvironment;", "itemId", "Lcom/box/android/domain/models/ItemId$Remote;", "startNavOrLoadApdexIfNecessary", "folderId", "", "(Lcom/box/android/browse/cpl/itemsList/IItemsListViewEnvironment;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startDeferredLoadApdex", "startNavApdex", "endNavOrLoadApdexIfNecessary", "(Lcom/box/android/browse/cpl/itemsList/IItemsListViewEnvironment;Lcom/box/android/browse/cpl/itemsList/ItemsListReducer$State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNavApdexType", "Lcom/box/android/domain/models/observability/ApdexType;", "identifier", "getLoadApdexType", "browse_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ItemsListObservabilityReducingKt {

    /* JADX INFO: renamed from: com.box.android.browse.cpl.itemsList.ItemsListObservabilityReducingKt$endNavOrLoadApdexIfNecessary$1, reason: invalid class name */
    /* JADX INFO: compiled from: ItemsListObservabilityReducing.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.itemsList.ItemsListObservabilityReducingKt", f = "ItemsListObservabilityReducing.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3}, l = {79, 80, 84, 85}, m = "endNavOrLoadApdexIfNecessary", n = {"environment", "state", "identifier", "$i$a$-let-ItemsListObservabilityReducingKt$endNavOrLoadApdexIfNecessary$2", "environment", "state", "identifier", "$i$a$-let-ItemsListObservabilityReducingKt$endNavOrLoadApdexIfNecessary$2", "environment", "state", "identifier", "$i$a$-let-ItemsListObservabilityReducingKt$endNavOrLoadApdexIfNecessary$2", "environment", "state", "identifier", "$i$a$-let-ItemsListObservabilityReducingKt$endNavOrLoadApdexIfNecessary$2"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ItemsListObservabilityReducingKt.endNavOrLoadApdexIfNecessary(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.itemsList.ItemsListObservabilityReducingKt$startDeferredLoadApdex$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ItemsListObservabilityReducing.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.itemsList.ItemsListObservabilityReducingKt", f = "ItemsListObservabilityReducing.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {65, 66}, m = "startDeferredLoadApdex", n = {"environment", "folderId", "apdexType", "appStartType", "environment", "folderId", "apdexType", "appStartType"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class C09581 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C09581(Continuation<? super C09581> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ItemsListObservabilityReducingKt.startDeferredLoadApdex(null, null, this);
        }
    }

    public static final ReducerResult<ItemsListReducer.State, ItemsListReducer.Action> reduceObservability(ItemsListReducer itemsListReducer, ItemsListReducer.State state, ItemsListReducer.Action action) {
        Intrinsics.checkNotNullParameter(itemsListReducer, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new C09571(action, itemsListReducer, state, null)));
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.itemsList.ItemsListObservabilityReducingKt$reduceObservability$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ItemsListObservabilityReducing.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.browse.cpl.itemsList.ItemsListObservabilityReducingKt$reduceObservability$1", f = "ItemsListObservabilityReducing.kt", i = {}, l = {36, 40}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C09571 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ ItemsListReducer.Action $action;
        final /* synthetic */ ItemsListReducer.State $state;
        final /* synthetic */ ItemsListReducer $this_reduceObservability;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09571(ItemsListReducer.Action action, ItemsListReducer itemsListReducer, ItemsListReducer.State state, Continuation<? super C09571> continuation) {
            super(1, continuation);
            this.$action = action;
            this.$this_reduceObservability = itemsListReducer;
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C09571(this.$action, this.$this_reduceObservability, this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C09571) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x005d, code lost:
        
            if (com.box.android.browse.cpl.itemsList.ItemsListObservabilityReducingKt.startNavOrLoadApdexIfNecessary(r4.$this_reduceObservability.getEnvironment(), ((com.box.android.browse.cpl.itemsList.ItemsListReducer.Action.TabChanged) r4.$action).getFolderId(), r4) == r0) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0075, code lost:
        
            if (com.box.android.browse.cpl.itemsList.ItemsListObservabilityReducingKt.endNavOrLoadApdexIfNecessary(r4.$this_reduceObservability.getEnvironment(), r4.$state, r4) == r0) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0077, code lost:
        
            return r0;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1b
                if (r1 == r3) goto L17
                if (r1 != r2) goto Lf
                goto L17
            Lf:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L17:
                kotlin.ResultKt.throwOnFailure(r5)
                goto L78
            L1b:
                kotlin.ResultKt.throwOnFailure(r5)
                com.box.android.browse.cpl.itemsList.ItemsListReducer$Action r5 = r4.$action
                boolean r1 = r5 instanceof com.box.android.browse.cpl.itemsList.ItemsListReducer.Action.ItemAction
                if (r1 == 0) goto L42
                com.box.android.browse.cpl.itemsList.ItemsListReducer$Action$ItemAction r5 = (com.box.android.browse.cpl.itemsList.ItemsListReducer.Action.ItemAction) r5
                com.box.android.browse.cpl.itemsList.ItemReducer$Action r5 = r5.getAction()
                boolean r5 = r5 instanceof com.box.android.browse.cpl.itemsList.ItemReducer.Action.Clicked
                if (r5 == 0) goto L78
                com.box.android.browse.cpl.itemsList.ItemsListReducer r5 = r4.$this_reduceObservability
                com.box.android.browse.cpl.itemsList.IItemsListViewEnvironment r5 = r5.getEnvironment()
                com.box.android.browse.cpl.itemsList.ItemsListReducer$State r0 = r4.$state
                com.box.android.browse.cpl.itemsList.ItemsListReducer$Action r4 = r4.$action
                com.box.android.browse.cpl.itemsList.ItemsListReducer$Action$ItemAction r4 = (com.box.android.browse.cpl.itemsList.ItemsListReducer.Action.ItemAction) r4
                com.box.android.domain.models.ItemId$Remote r4 = r4.getId()
                com.box.android.browse.cpl.itemsList.ItemsListObservabilityReducingKt.access$startFolderNavApdexIfNecessary(r5, r0, r4)
                goto L78
            L42:
                boolean r1 = r5 instanceof com.box.android.browse.cpl.itemsList.ItemsListReducer.Action.TabChanged
                if (r1 == 0) goto L60
                com.box.android.browse.cpl.itemsList.ItemsListReducer r5 = r4.$this_reduceObservability
                com.box.android.browse.cpl.itemsList.IItemsListViewEnvironment r5 = r5.getEnvironment()
                com.box.android.browse.cpl.itemsList.ItemsListReducer$Action r1 = r4.$action
                com.box.android.browse.cpl.itemsList.ItemsListReducer$Action$TabChanged r1 = (com.box.android.browse.cpl.itemsList.ItemsListReducer.Action.TabChanged) r1
                java.lang.String r1 = r1.getFolderId()
                r2 = r4
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                r4.label = r3
                java.lang.Object r4 = com.box.android.browse.cpl.itemsList.ItemsListObservabilityReducingKt.access$startNavOrLoadApdexIfNecessary(r5, r1, r2)
                if (r4 != r0) goto L78
                goto L77
            L60:
                boolean r5 = r5 instanceof com.box.android.browse.cpl.itemsList.ItemsListReducer.Action.ScreenUpdated
                if (r5 == 0) goto L78
                com.box.android.browse.cpl.itemsList.ItemsListReducer r5 = r4.$this_reduceObservability
                com.box.android.browse.cpl.itemsList.IItemsListViewEnvironment r5 = r5.getEnvironment()
                com.box.android.browse.cpl.itemsList.ItemsListReducer$State r1 = r4.$state
                r3 = r4
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                r4.label = r2
                java.lang.Object r4 = com.box.android.browse.cpl.itemsList.ItemsListObservabilityReducingKt.access$endNavOrLoadApdexIfNecessary(r5, r1, r3)
                if (r4 != r0) goto L78
            L77:
                return r0
            L78:
                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.browse.cpl.itemsList.ItemsListObservabilityReducingKt.C09571.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startFolderNavApdexIfNecessary(IItemsListViewEnvironment iItemsListViewEnvironment, ItemsListReducer.State state, ItemId.Remote remote) {
        if (remote.getType() != ItemType.FOLDER || (state.getMultiselect() instanceof MultiselectReducer.State.Selecting)) {
            return;
        }
        iItemsListViewEnvironment.getApdexService().startTracker(FolderNavApdex.INSTANCE, remote.getBoxId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object startNavOrLoadApdexIfNecessary(IItemsListViewEnvironment iItemsListViewEnvironment, String str, Continuation<? super Unit> continuation) {
        if (iItemsListViewEnvironment.getAppStartApdexTracker().isAppStartRecordedForPage(AppStartDestinationPageType.BrowseTabDestinationPage.INSTANCE)) {
            Object objStartDeferredLoadApdex = startDeferredLoadApdex(iItemsListViewEnvironment, str, continuation);
            return objStartDeferredLoadApdex == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objStartDeferredLoadApdex : Unit.INSTANCE;
        }
        startNavApdex(iItemsListViewEnvironment, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00be, code lost:
    
        if (r4.startDeferredAppStartIfNecessary(r2, r9, r0) == r1) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object startDeferredLoadApdex(com.box.android.browse.cpl.itemsList.IItemsListViewEnvironment r8, java.lang.String r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            boolean r0 = r10 instanceof com.box.android.browse.cpl.itemsList.ItemsListObservabilityReducingKt.C09581
            if (r0 == 0) goto L14
            r0 = r10
            com.box.android.browse.cpl.itemsList.ItemsListObservabilityReducingKt$startDeferredLoadApdex$1 r0 = (com.box.android.browse.cpl.itemsList.ItemsListObservabilityReducingKt.C09581) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            com.box.android.browse.cpl.itemsList.ItemsListObservabilityReducingKt$startDeferredLoadApdex$1 r0 = new com.box.android.browse.cpl.itemsList.ItemsListObservabilityReducingKt$startDeferredLoadApdex$1
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L5e
            if (r2 == r4) goto L46
            if (r2 != r3) goto L3e
            java.lang.Object r8 = r0.L$3
            com.box.android.coreservices.observability.appstart.AppStartType r8 = (com.box.android.coreservices.observability.appstart.AppStartType) r8
            java.lang.Object r8 = r0.L$2
            com.box.android.domain.models.observability.ApdexType r8 = (com.box.android.domain.models.observability.ApdexType) r8
            java.lang.Object r8 = r0.L$1
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r8 = r0.L$0
            com.box.android.browse.cpl.itemsList.IItemsListViewEnvironment r8 = (com.box.android.browse.cpl.itemsList.IItemsListViewEnvironment) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto Lc1
        L3e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L46:
            java.lang.Object r8 = r0.L$3
            com.box.android.coreservices.observability.appstart.AppStartType r8 = (com.box.android.coreservices.observability.appstart.AppStartType) r8
            java.lang.Object r9 = r0.L$2
            com.box.android.domain.models.observability.ApdexType r9 = (com.box.android.domain.models.observability.ApdexType) r9
            java.lang.Object r2 = r0.L$1
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r4 = r0.L$0
            com.box.android.browse.cpl.itemsList.IItemsListViewEnvironment r4 = (com.box.android.browse.cpl.itemsList.IItemsListViewEnvironment) r4
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r9
            r9 = r2
            r2 = r8
            r8 = r4
            goto L9c
        L5e:
            kotlin.ResultKt.throwOnFailure(r10)
            com.box.android.domain.models.observability.ApdexType r10 = getLoadApdexType(r9)
            if (r10 != 0) goto L6a
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L6a:
            com.box.android.coreservices.observability.appstart.apdex.AppStartApdexTracker r2 = r8.getAppStartApdexTracker()
            com.box.android.coreservices.observability.appstart.AppStartDestinationPageType$BrowseTabDestinationPage r5 = com.box.android.coreservices.observability.appstart.AppStartDestinationPageType.BrowseTabDestinationPage.INSTANCE
            com.box.android.coreservices.observability.appstart.AppStartDestinationPageType r5 = (com.box.android.coreservices.observability.appstart.AppStartDestinationPageType) r5
            com.box.android.coreservices.observability.appstart.AppStartType r2 = r2.consumeAppStartType(r5)
            if (r2 != 0) goto L7b
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L7b:
            com.box.android.domain.services.ApdexService r5 = r8.getApdexService()
            long r6 = r2.getStartTime()
            java.lang.Long r6 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r6)
            r0.L$0 = r8
            r0.L$1 = r9
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r0.L$2 = r7
            r0.L$3 = r2
            r0.label = r4
            java.lang.Object r4 = r5.startCustomizedTracker(r10, r9, r6, r0)
            if (r4 != r1) goto L9c
            goto Lc0
        L9c:
            com.box.android.coreservices.observability.appstart.apdex.AppStartApdexTracker r4 = r8.getAppStartApdexTracker()
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$0 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$1 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r0.L$2 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r0.L$3 = r8
            r0.label = r3
            java.lang.Object r8 = r4.startDeferredAppStartIfNecessary(r2, r9, r0)
            if (r8 != r1) goto Lc1
        Lc0:
            return r1
        Lc1:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.browse.cpl.itemsList.ItemsListObservabilityReducingKt.startDeferredLoadApdex(com.box.android.browse.cpl.itemsList.IItemsListViewEnvironment, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final void startNavApdex(IItemsListViewEnvironment iItemsListViewEnvironment, String str) {
        ApdexType navApdexType = getNavApdexType(str);
        if (navApdexType != null) {
            iItemsListViewEnvironment.getApdexService().startTracker(navApdexType, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00f8, code lost:
    
        if (r11.endAppStartIfNecessary(r4, r10, r0) == r1) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0138, code lost:
    
        if (r11.endAppStartIfNecessary(r3, r10, r0) == r1) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object endNavOrLoadApdexIfNecessary(com.box.android.browse.cpl.itemsList.IItemsListViewEnvironment r9, com.box.android.browse.cpl.itemsList.ItemsListReducer.State r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            Method dump skipped, instruction units count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.browse.cpl.itemsList.ItemsListObservabilityReducingKt.endNavOrLoadApdexIfNecessary(com.box.android.browse.cpl.itemsList.IItemsListViewEnvironment, com.box.android.browse.cpl.itemsList.ItemsListReducer$State, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final ApdexType getNavApdexType(String str) {
        if (Intrinsics.areEqual(str, "0")) {
            return RootFolderNavApdex.INSTANCE;
        }
        if (Intrinsics.areEqual(str, BoxCommonConstants.RECENTS_ROOT_FOLDER_ID)) {
            return RecentsNavApdex.INSTANCE;
        }
        return null;
    }

    private static final ApdexType getLoadApdexType(String str) {
        if (Intrinsics.areEqual(str, "0")) {
            return RootFolderLoadApdex.INSTANCE;
        }
        if (Intrinsics.areEqual(str, BoxCommonConstants.RECENTS_ROOT_FOLDER_ID)) {
            return RecentsLoadApdex.INSTANCE;
        }
        return null;
    }
}

package com.box.android.hubs.presentation;

import android.content.Context;
import androidx.compose.runtime.State;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.cpl.Store;
import com.box.android.domain.models.search.SearchMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: HubsScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.hubs.presentation.HubsScreenKt$HubsScreen$2$1", f = "HubsScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class HubsScreenKt$HubsScreen$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ IntentServices $intentServices;
    final /* synthetic */ State<HubsReducer.State> $state$delegate;
    final /* synthetic */ Store<HubsReducer.State, HubsReducer.Action> $store;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HubsScreenKt$HubsScreen$2$1(Context context, IntentServices intentServices, Store<HubsReducer.State, HubsReducer.Action> store, State<HubsReducer.State> state, Continuation<? super HubsScreenKt$HubsScreen$2$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$intentServices = intentServices;
        this.$store = store;
        this.$state$delegate = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HubsScreenKt$HubsScreen$2$1(this.$context, this.$intentServices, this.$store, this.$state$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HubsScreenKt$HubsScreen$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            HubsRoute route = HubsScreenKt.HubsScreen$lambda$0(this.$state$delegate).getRoute();
            if (route instanceof HubsRoute.Search) {
                Context context = this.$context;
                context.startActivity(this.$intentServices.searchActivityIntent(context, SearchMode.Hubs.INSTANCE));
            } else if (route instanceof HubsRoute.HubDetails) {
                Context context2 = this.$context;
                context2.startActivity(this.$intentServices.hubDetailsActivityIntent(context2, ((HubsRoute.HubDetails) route).getId()));
            } else if (!(route instanceof HubsRoute.None)) {
                throw new NoWhenBranchMatchedException();
            }
            this.$store.send(HubsReducer.Action.HubsRouteHandled.INSTANCE);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

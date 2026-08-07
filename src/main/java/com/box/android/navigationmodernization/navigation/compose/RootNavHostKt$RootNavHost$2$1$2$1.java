package com.box.android.navigationmodernization.navigation.compose;

import androidx.compose.runtime.MutableState;
import com.box.android.navigationmodernization.navigation.RootNavigationConfig;
import com.box.android.navigationmodernization.navigation.RootNavigationDestination;
import com.box.android.navigationmodernization.navigation.navigator.RootNavigator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: RootNavHost.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.navigationmodernization.navigation.compose.RootNavHostKt$RootNavHost$2$1$2$1", f = "RootNavHost.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class RootNavHostKt$RootNavHost$2$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $additionalDestinationsConsumed$delegate;
    final /* synthetic */ RootNavigationConfig $rootNavigationConfig;
    final /* synthetic */ RootNavigator $rootNavigator;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RootNavHostKt$RootNavHost$2$1$2$1(RootNavigationConfig rootNavigationConfig, MutableState<Boolean> mutableState, RootNavigator rootNavigator, Continuation<? super RootNavHostKt$RootNavHost$2$1$2$1> continuation) {
        super(2, continuation);
        this.$rootNavigationConfig = rootNavigationConfig;
        this.$additionalDestinationsConsumed$delegate = mutableState;
        this.$rootNavigator = rootNavigator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RootNavHostKt$RootNavHost$2$1$2$1(this.$rootNavigationConfig, this.$additionalDestinationsConsumed$delegate, this.$rootNavigator, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RootNavHostKt$RootNavHost$2$1$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (!RootNavHostKt.RootNavHost$lambda$5$0$2(this.$additionalDestinationsConsumed$delegate) && !this.$rootNavigationConfig.getAdditionalDestinations().isEmpty()) {
                RootNavHostKt.RootNavHost$lambda$5$0$3(this.$additionalDestinationsConsumed$delegate, true);
                List<RootNavigationDestination.InnerDestination> additionalDestinations = this.$rootNavigationConfig.getAdditionalDestinations();
                RootNavigator rootNavigator = this.$rootNavigator;
                Iterator<T> it = additionalDestinations.iterator();
                while (it.hasNext()) {
                    rootNavigator.navigateTo((RootNavigationDestination.InnerDestination) it.next());
                }
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

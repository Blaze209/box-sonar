package com.box.android.collections.presentation.navigationmodernization.navigation.compose;

import androidx.compose.runtime.MutableState;
import com.box.android.collections.presentation.navigationmodernization.navigation.CollectionsDestination;
import com.box.android.collections.presentation.navigationmodernization.navigation.CollectionsNavigationConfig;
import com.box.android.collections.presentation.navigationmodernization.navigation.CollectionsNavigator;
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

/* JADX INFO: compiled from: CollectionsNavigationCompose.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.collections.presentation.navigationmodernization.navigation.compose.CollectionsNavigationComposeKt$collectionsNavigationGraph$2$1$1$1", f = "CollectionsNavigationCompose.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class CollectionsNavigationComposeKt$collectionsNavigationGraph$2$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $additionalDestinationsConsumed$delegate;
    final /* synthetic */ CollectionsNavigationConfig $collectionsNavigationConfig;
    final /* synthetic */ CollectionsNavigator $navigator;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CollectionsNavigationComposeKt$collectionsNavigationGraph$2$1$1$1(CollectionsNavigationConfig collectionsNavigationConfig, MutableState<Boolean> mutableState, CollectionsNavigator collectionsNavigator, Continuation<? super CollectionsNavigationComposeKt$collectionsNavigationGraph$2$1$1$1> continuation) {
        super(2, continuation);
        this.$collectionsNavigationConfig = collectionsNavigationConfig;
        this.$additionalDestinationsConsumed$delegate = mutableState;
        this.$navigator = collectionsNavigator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CollectionsNavigationComposeKt$collectionsNavigationGraph$2$1$1$1(this.$collectionsNavigationConfig, this.$additionalDestinationsConsumed$delegate, this.$navigator, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CollectionsNavigationComposeKt$collectionsNavigationGraph$2$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (!CollectionsNavigationComposeKt.collectionsNavigationGraph$lambda$1$0$1(this.$additionalDestinationsConsumed$delegate) && !this.$collectionsNavigationConfig.getAdditionalDestinations().isEmpty()) {
                CollectionsNavigationComposeKt.collectionsNavigationGraph$lambda$1$0$2(this.$additionalDestinationsConsumed$delegate, true);
                List<CollectionsDestination.InnerDestination> additionalDestinations = this.$collectionsNavigationConfig.getAdditionalDestinations();
                CollectionsNavigator collectionsNavigator = this.$navigator;
                Iterator<T> it = additionalDestinations.iterator();
                while (it.hasNext()) {
                    collectionsNavigator.navigateTo((CollectionsDestination.InnerDestination) it.next());
                }
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

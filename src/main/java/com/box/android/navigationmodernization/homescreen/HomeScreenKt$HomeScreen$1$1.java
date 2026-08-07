package com.box.android.navigationmodernization.homescreen;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import com.box.android.navigationmodernization.homescreen.navigation.HomeNavigationBarDestination;
import com.box.android.navigationmodernization.homescreen.navigation.configuration.HomeScreenNavigationConfigurator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: HomeScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.navigationmodernization.homescreen.HomeScreenKt$HomeScreen$1$1", f = "HomeScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class HomeScreenKt$HomeScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<HomeNavigationBarDestination> $currentGraph$delegate;
    final /* synthetic */ MutableState<String> $currentInnerTabName$delegate;
    final /* synthetic */ HomeScreenNavigationConfigurator $navigationConfigurator;
    final /* synthetic */ HomeScreenViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    HomeScreenKt$HomeScreen$1$1(HomeScreenNavigationConfigurator homeScreenNavigationConfigurator, State<? extends HomeNavigationBarDestination> state, MutableState<String> mutableState, HomeScreenViewModel homeScreenViewModel, Continuation<? super HomeScreenKt$HomeScreen$1$1> continuation) {
        super(2, continuation);
        this.$navigationConfigurator = homeScreenNavigationConfigurator;
        this.$currentGraph$delegate = state;
        this.$currentInnerTabName$delegate = mutableState;
        this.$viewModel = homeScreenViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeScreenKt$HomeScreen$1$1(this.$navigationConfigurator, this.$currentGraph$delegate, this.$currentInnerTabName$delegate, this.$viewModel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeScreenKt$HomeScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        MutableState<String> mutableState = this.$currentInnerTabName$delegate;
        HomeNavigationBarDestination homeNavigationBarDestinationHomeScreen$lambda$2 = HomeScreenKt.HomeScreen$lambda$2(this.$currentGraph$delegate);
        mutableState.setValue(homeNavigationBarDestinationHomeScreen$lambda$2 != null ? HomeScreenKt.getStartInnerTabName(homeNavigationBarDestinationHomeScreen$lambda$2, this.$navigationConfigurator) : null);
        HomeNavigationBarDestination homeNavigationBarDestinationHomeScreen$lambda$3 = HomeScreenKt.HomeScreen$lambda$2(this.$currentGraph$delegate);
        if (homeNavigationBarDestinationHomeScreen$lambda$3 != null) {
            this.$viewModel.saveLastUsedTab(homeNavigationBarDestinationHomeScreen$lambda$3);
        }
        return Unit.INSTANCE;
    }
}

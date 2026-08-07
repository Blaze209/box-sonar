package com.box.android.navigationmodernization.homescreen;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.box.android.navigationmodernization.homescreen.navigation.HomeNavigationBarDestination;
import com.box.android.navigationmodernization.homescreen.navigation.configuration.NavigationPersistenceKeysKt;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: HomeScreenViewModel.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/box/android/navigationmodernization/homescreen/HomeScreenViewModel;", "Landroidx/lifecycle/ViewModel;", "environment", "Lcom/box/android/navigationmodernization/homescreen/HomeScreenEnvironment;", "<init>", "(Lcom/box/android/navigationmodernization/homescreen/HomeScreenEnvironment;)V", "saveLastUsedTab", "", "tab", "Lcom/box/android/navigationmodernization/homescreen/navigation/HomeNavigationBarDestination;", "saveInnerTab", "bottomTab", "innerTabName", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HomeScreenViewModel extends ViewModel {
    public static final int $stable = 8;
    private final HomeScreenEnvironment environment;

    @Inject
    public HomeScreenViewModel(HomeScreenEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
    }

    /* JADX INFO: renamed from: com.box.android.navigationmodernization.homescreen.HomeScreenViewModel$saveLastUsedTab$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomeScreenViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.navigationmodernization.homescreen.HomeScreenViewModel$saveLastUsedTab$1", f = "HomeScreenViewModel.kt", i = {}, l = {20}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C16591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ HomeNavigationBarDestination $tab;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16591(HomeNavigationBarDestination homeNavigationBarDestination, Continuation<? super C16591> continuation) {
            super(2, continuation);
            this.$tab = homeNavigationBarDestination;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomeScreenViewModel.this.new C16591(this.$tab, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C16591) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (HomeScreenViewModel.this.environment.getTabPersistenceService().saveLastUsedTab(NavigationPersistenceKeysKt.getPersistenceKey(this.$tab), this) == coroutine_suspended) {
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

    public final void saveLastUsedTab(HomeNavigationBarDestination tab) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C16591(tab, null), 3, null);
    }

    /* JADX INFO: renamed from: com.box.android.navigationmodernization.homescreen.HomeScreenViewModel$saveInnerTab$1, reason: invalid class name */
    /* JADX INFO: compiled from: HomeScreenViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.navigationmodernization.homescreen.HomeScreenViewModel$saveInnerTab$1", f = "HomeScreenViewModel.kt", i = {0}, l = {27}, m = "invokeSuspend", n = {"tabKey"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ HomeNavigationBarDestination $bottomTab;
        final /* synthetic */ String $innerTabName;
        Object L$0;
        int label;
        final /* synthetic */ HomeScreenViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(HomeNavigationBarDestination homeNavigationBarDestination, String str, HomeScreenViewModel homeScreenViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$bottomTab = homeNavigationBarDestination;
            this.$innerTabName = str;
            this.this$0 = homeScreenViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$bottomTab, this.$innerTabName, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String strInnerTabNameToPersistenceKey = NavigationPersistenceKeysKt.innerTabNameToPersistenceKey(this.$bottomTab, this.$innerTabName);
                if (strInnerTabNameToPersistenceKey == null) {
                    return Unit.INSTANCE;
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(strInnerTabNameToPersistenceKey);
                this.label = 1;
                if (this.this$0.environment.getTabPersistenceService().saveInnerTab(NavigationPersistenceKeysKt.getPersistenceKey(this.$bottomTab), strInnerTabNameToPersistenceKey, this) == coroutine_suspended) {
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

    public final void saveInnerTab(HomeNavigationBarDestination bottomTab, String innerTabName) {
        Intrinsics.checkNotNullParameter(bottomTab, "bottomTab");
        Intrinsics.checkNotNullParameter(innerTabName, "innerTabName");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(bottomTab, innerTabName, this, null), 3, null);
    }
}

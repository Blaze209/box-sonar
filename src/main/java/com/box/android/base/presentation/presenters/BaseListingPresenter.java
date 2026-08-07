package com.box.android.base.presentation.presenters;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.box.android.base.presentation.ListingFragmentInterface;
import com.box.android.base.vm.BaseListingViewModel;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.utils.result.Result;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseListingPresenter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0004:\u0001/B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\u0019\u001a\u00020\u000eJ\b\u0010\u001a\u001a\u00020\u0017H'J\b\u0010\u001b\u001a\u00020\u0017H\u0017J\b\u0010\u001c\u001a\u00020\u0017H\u0007J\u001c\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001eH\u0096@¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\u001fH&J\u000e\u0010#\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010!J\b\u0010$\u001a\u00020\u0010H$J\r\u0010%\u001a\u00028\u0001H$¢\u0006\u0002\u0010\u0015J\u0018\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001fH\u0002J\b\u0010*\u001a\u00020+H$J\u0014\u0010,\u001a\u00020\u00172\n\u0010-\u001a\u0006\u0012\u0002\b\u00030.H\u0016R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\bX\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00028\u00018DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u00060"}, d2 = {"Lcom/box/android/base/presentation/presenters/BaseListingPresenter;", ExifInterface.GPS_DIRECTION_TRUE, "F", "Lcom/box/android/base/presentation/ListingFragmentInterface;", "Landroidx/lifecycle/LifecycleObserver;", "<init>", "()V", "boxItemsView", "Lcom/box/android/base/presentation/presenters/BaseListingPresenter$BoxItemsView;", "getBoxItemsView", "()Lcom/box/android/base/presentation/presenters/BaseListingPresenter$BoxItemsView;", "setBoxItemsView", "(Lcom/box/android/base/presentation/presenters/BaseListingPresenter$BoxItemsView;)V", "viewLifecycle", "Landroidx/lifecycle/Lifecycle;", "baseViewModel", "Lcom/box/android/base/vm/BaseListingViewModel;", "getBaseViewModel", "()Lcom/box/android/base/vm/BaseListingViewModel;", "baseFragment", "getBaseFragment", "()Lcom/box/android/base/presentation/ListingFragmentInterface;", "attachView", "", "view", "viewLifeCycle", "onViewCreate", "onResume", "onViewDestroyed", "fetchItems", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isContentAvailable", "refresh", "getViewModel", "getFragment", "logServerResponse", "startTime", "", "newData", "getRefreshEventName", "", "handleBroadcastMessage", "message", "Lcom/box/android/coreservices/modelcontroller/messages/BoxMessage;", "BoxItemsView", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class BaseListingPresenter<T, F extends ListingFragmentInterface> implements LifecycleObserver {
    public static final int $stable = 8;
    private BoxItemsView<T> boxItemsView;
    private Lifecycle viewLifecycle;

    /* JADX INFO: compiled from: BaseListingPresenter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\bf\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/box/android/base/presentation/presenters/BaseListingPresenter$BoxItemsView;", ExifInterface.GPS_DIRECTION_TRUE, "", "renderNewList", "", "newList", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface BoxItemsView<T> {
        void renderNewList(List<? extends T> newList);
    }

    /* JADX INFO: renamed from: com.box.android.base.presentation.presenters.BaseListingPresenter$fetchItems$1, reason: invalid class name */
    /* JADX INFO: compiled from: BaseListingPresenter.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.base.presentation.presenters.BaseListingPresenter", f = "BaseListingPresenter.kt", i = {0}, l = {45}, m = "fetchItems$suspendImpl", n = {"$this"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1<T, F extends ListingFragmentInterface> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ BaseListingPresenter<T, F> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BaseListingPresenter<T, F> baseListingPresenter, Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
            this.this$0 = baseListingPresenter;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BaseListingPresenter.fetchItems$suspendImpl(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.base.presentation.presenters.BaseListingPresenter$refresh$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseListingPresenter.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.base.presentation.presenters.BaseListingPresenter", f = "BaseListingPresenter.kt", i = {0, 0}, l = {57}, m = "refresh$suspendImpl", n = {"$this", "startTime"}, s = {"L$0", "J$0"}, v = 1)
    static final class C09321<T, F extends ListingFragmentInterface> extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ BaseListingPresenter<T, F> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09321(BaseListingPresenter<T, F> baseListingPresenter, Continuation<? super C09321> continuation) {
            super(continuation);
            this.this$0 = baseListingPresenter;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BaseListingPresenter.refresh$suspendImpl(this.this$0, this);
        }
    }

    public Object fetchItems(Continuation<? super Result<Boolean, ? extends DomainError>> continuation) {
        return fetchItems$suspendImpl(this, continuation);
    }

    protected abstract F getFragment();

    protected abstract String getRefreshEventName();

    protected abstract BaseListingViewModel getViewModel();

    public void handleBroadcastMessage(BoxMessage<?> message) {
        Intrinsics.checkNotNullParameter(message, "message");
    }

    public abstract boolean isContentAvailable();

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public abstract void onViewCreate();

    public Object refresh(Continuation<? super Unit> continuation) {
        return refresh$suspendImpl(this, continuation);
    }

    protected BoxItemsView<T> getBoxItemsView() {
        return this.boxItemsView;
    }

    protected void setBoxItemsView(BoxItemsView<T> boxItemsView) {
        this.boxItemsView = boxItemsView;
    }

    private final BaseListingViewModel getBaseViewModel() {
        return getViewModel();
    }

    protected final F getBaseFragment() {
        return (F) getFragment();
    }

    public final void attachView(BoxItemsView<T> view, Lifecycle viewLifeCycle) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(viewLifeCycle, "viewLifeCycle");
        setBoxItemsView(view);
        this.viewLifecycle = viewLifeCycle;
        Intrinsics.checkNotNull(viewLifeCycle);
        viewLifeCycle.addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onViewDestroyed() {
        setBoxItemsView(null);
        this.viewLifecycle = null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    static /* synthetic */ <T, F extends ListingFragmentInterface> Object fetchItems$suspendImpl(BaseListingPresenter<T, F> baseListingPresenter, Continuation<? super Result<Boolean, ? extends DomainError>> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(baseListingPresenter, continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(baseListingPresenter, continuation);
        }
        Object objFetchItems = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objFetchItems);
            BaseListingViewModel baseViewModel = baseListingPresenter.getBaseViewModel();
            anonymousClass1.L$0 = baseListingPresenter;
            anonymousClass1.label = 1;
            objFetchItems = baseViewModel.fetchItems(anonymousClass1);
            if (objFetchItems == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            baseListingPresenter = (BaseListingPresenter) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objFetchItems);
        }
        Result result = (Result) objFetchItems;
        if (result == null) {
            return null;
        }
        boolean z = result instanceof Result.Success;
        if (z) {
            ((Boolean) ((Result.Success) result).getValue()).booleanValue();
            baseListingPresenter.getBaseFragment().updateUI();
        } else if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (z) {
            return result;
        }
        if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        baseListingPresenter.getBaseViewModel().setError((DomainError) ((Result.Error) result).getValue());
        return result;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    static /* synthetic */ <T, F extends ListingFragmentInterface> Object refresh$suspendImpl(BaseListingPresenter<T, F> baseListingPresenter, Continuation<? super Unit> continuation) {
        C09321 c09321;
        long j;
        if (continuation instanceof C09321) {
            c09321 = (C09321) continuation;
            if ((c09321.label & Integer.MIN_VALUE) != 0) {
                c09321.label -= Integer.MIN_VALUE;
            } else {
                c09321 = new C09321(baseListingPresenter, continuation);
            }
        } else {
            c09321 = new C09321(baseListingPresenter, continuation);
        }
        Object objFetchItems = c09321.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09321.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objFetchItems);
            long jCurrentTimeMillis = System.currentTimeMillis();
            c09321.L$0 = baseListingPresenter;
            c09321.J$0 = jCurrentTimeMillis;
            c09321.label = 1;
            objFetchItems = baseListingPresenter.fetchItems(c09321);
            if (objFetchItems == coroutine_suspended) {
                return coroutine_suspended;
            }
            j = jCurrentTimeMillis;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = c09321.J$0;
            baseListingPresenter = (BaseListingPresenter) c09321.L$0;
            ResultKt.throwOnFailure(objFetchItems);
        }
        Result result = (Result) objFetchItems;
        if (result != null) {
            if (result instanceof Result.Success) {
                baseListingPresenter.logServerResponse(j, ((Boolean) ((Result.Success) result).getValue()).booleanValue());
            } else if (!(result instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return Unit.INSTANCE;
    }

    private final void logServerResponse(long startTime, boolean newData) {
        BoxAmplitudeAnalytics.EventPropertyBuilder eventPropertyBuilderCreateEventBuilder = BoxAmplitudeAnalytics.createEventBuilder();
        eventPropertyBuilderCreateEventBuilder.setRoundTripTime(String.valueOf(System.currentTimeMillis() - startTime));
        eventPropertyBuilderCreateEventBuilder.setNewDataOnRefresh(newData);
        eventPropertyBuilderCreateEventBuilder.logEvent(getRefreshEventName());
    }
}

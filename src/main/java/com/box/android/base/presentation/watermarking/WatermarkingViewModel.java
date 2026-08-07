package com.box.android.base.presentation.watermarking;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.box.android.cpl.IStoreFactory;
import com.box.android.cpl.Store;
import com.box.android.domain.models.item.WatermarkableItem;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WatermarkingViewModel.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0014\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/box/android/base/presentation/watermarking/WatermarkingViewModel;", "Landroidx/lifecycle/ViewModel;", "environment", "Lcom/box/android/base/presentation/watermarking/WatermarkingEnvironment;", "storeFactory", "Lcom/box/android/cpl/IStoreFactory;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "<init>", "(Lcom/box/android/base/presentation/watermarking/WatermarkingEnvironment;Lcom/box/android/cpl/IStoreFactory;Landroidx/lifecycle/SavedStateHandle;)V", "watermarkableItem", "Lcom/box/android/domain/models/item/WatermarkableItem;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$State;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$Action;", "getStore", "()Lcom/box/android/cpl/Store;", "store$delegate", "Lkotlin/Lazy;", "createInitialState", "Companion", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class WatermarkingViewModel extends ViewModel {
    public static final String EXTRA_WATERMARKABLE_ITEM = "extra_watermarkable_item";
    private final WatermarkingEnvironment environment;

    /* JADX INFO: renamed from: store$delegate, reason: from kotlin metadata */
    private final Lazy store;
    private final IStoreFactory storeFactory;
    private final WatermarkableItem watermarkableItem;
    public static final int $stable = 8;

    @Inject
    public WatermarkingViewModel(WatermarkingEnvironment environment, IStoreFactory storeFactory, SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(storeFactory, "storeFactory");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        this.environment = environment;
        this.storeFactory = storeFactory;
        this.watermarkableItem = (WatermarkableItem) savedStateHandle.get(EXTRA_WATERMARKABLE_ITEM);
        this.store = LazyKt.lazy(new Function0() { // from class: com.box.android.base.presentation.watermarking.WatermarkingViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return WatermarkingViewModel.store_delegate$lambda$0(this.f$0);
            }
        });
    }

    public final Store<WatermarkingReducer.State, WatermarkingReducer.Action> getStore() {
        return (Store) this.store.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Store store_delegate$lambda$0(WatermarkingViewModel watermarkingViewModel) {
        Store storeCreate = watermarkingViewModel.storeFactory.create(watermarkingViewModel.createInitialState(), new WatermarkingReducer(watermarkingViewModel.environment), ViewModelKt.getViewModelScope(watermarkingViewModel));
        storeCreate.send(WatermarkingReducer.Action.Initialize.INSTANCE);
        return storeCreate;
    }

    private final WatermarkingReducer.State createInitialState() {
        WatermarkableItem watermarkableItem = this.watermarkableItem;
        if (watermarkableItem == null) {
            throw new IllegalArgumentException("WatermarkingViewModel requires a WatermarkableItem");
        }
        if (watermarkableItem instanceof WatermarkableItem.File) {
            return WatermarkingReducerKt.toWatermarkingState(((WatermarkableItem.File) watermarkableItem).getModel());
        }
        if (watermarkableItem instanceof WatermarkableItem.Folder) {
            return WatermarkingReducerKt.toWatermarkingState(((WatermarkableItem.Folder) watermarkableItem).getModel());
        }
        throw new NoWhenBranchMatchedException();
    }
}

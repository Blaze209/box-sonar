package com.box.android.collections.presentation.navigationmodernization.collectionitemslist;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.box.android.base.presentation.multiselect.MultiselectReducer;
import com.box.android.collections.presentation.navigationmodernization.navigation.compose.CollectionItemsNavArg;
import com.box.android.coreservices.jobmanager.jobs.BoxItemJob;
import com.box.android.cpl.IStoreFactory;
import com.box.android.cpl.Store;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.CollectionType;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionItemsListViewModel.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListViewModel;", "Landroidx/lifecycle/ViewModel;", "environment", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListEnvironment;", "storeFactory", "Lcom/box/android/cpl/IStoreFactory;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "<init>", "(Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListEnvironment;Lcom/box/android/cpl/IStoreFactory;Landroidx/lifecycle/SavedStateHandle;)V", BoxItemJob.COLLECTION_ID, "", "collectionName", "collectionType", "Lcom/box/android/domain/models/CollectionType;", "startInSelectingMode", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$State;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action;", "getStore", "()Lcom/box/android/cpl/Store;", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollectionItemsListViewModel extends ViewModel {
    public static final int $stable = 8;
    private final String collectionId;
    private final String collectionName;
    private final CollectionType collectionType;
    private final boolean startInSelectingMode;
    private final Store<CollectionItemsListReducer.State, CollectionItemsListReducer.Action> store;

    /* JADX INFO: compiled from: CollectionItemsListViewModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CollectionType.values().length];
            try {
                iArr[CollectionType.FAVORITES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CollectionType.PERSONAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public CollectionItemsListViewModel(CollectionItemsListEnvironment environment, IStoreFactory storeFactory, SavedStateHandle savedStateHandle) {
        CollectionModel collectionModelCreateFavorites;
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(storeFactory, "storeFactory");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Object obj = savedStateHandle.get("collection_id");
        if (obj == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        String str = (String) obj;
        this.collectionId = str;
        Object obj2 = savedStateHandle.get(CollectionItemsNavArg.COLLECTION_NAME);
        if (obj2 == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        String str2 = (String) obj2;
        this.collectionName = str2;
        Object obj3 = savedStateHandle.get("collection_type");
        if (obj3 == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        CollectionType collectionType = (CollectionType) obj3;
        this.collectionType = collectionType;
        Boolean bool = (Boolean) savedStateHandle.get(CollectionItemsNavArg.ITEM_PICKER_MODE);
        boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
        this.startInSelectingMode = zBooleanValue;
        int i = WhenMappings.$EnumSwitchMapping$0[collectionType.ordinal()];
        if (i == 1) {
            collectionModelCreateFavorites = CollectionModel.INSTANCE.createFavorites(str);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            collectionModelCreateFavorites = CollectionModel.copy$default(CollectionModel.INSTANCE.createFromId(str), null, null, str2, null, null, 27, null);
        }
        Store<CollectionItemsListReducer.State, CollectionItemsListReducer.Action> storeCreate = storeFactory.create(new CollectionItemsListReducer.State(collectionModelCreateFavorites, null, null, false, null, null, null, 126, null), new CollectionItemsListReducer(environment), ViewModelKt.getViewModelScope(this));
        this.store = storeCreate;
        if (zBooleanValue) {
            storeCreate.send(new CollectionItemsListReducer.Action.Multiselect(MultiselectReducer.Action.StartMultiSelectMode.INSTANCE));
        }
    }

    public final Store<CollectionItemsListReducer.State, CollectionItemsListReducer.Action> getStore() {
        return this.store;
    }
}

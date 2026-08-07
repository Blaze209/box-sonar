package com.box.android.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.box.android.base.presentation.components.topbar.component.inbox.InboxBadgeRepository;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.boxandroidlibv2private.model.BoxTaskBadge;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes13.dex */
public class InboxBadgeVM extends ViewModel {
    private final MediatorLiveData<BadgeData> combinedBadgeData = new MediatorLiveData<>();
    public InboxBadgeRepository mBadgeRepo;

    public static class BadgeData {
        public final int count;
        public final boolean hasMore;

        public BadgeData(int i, boolean z) {
            this.count = i;
            this.hasMore = z;
        }
    }

    @Inject
    public InboxBadgeVM(InboxBadgeRepository inboxBadgeRepository) {
        this.mBadgeRepo = inboxBadgeRepository;
        initializeCombinedBadgeCount();
    }

    public void fetchBadgeData() {
        InboxBadgeRepository inboxBadgeRepository = this.mBadgeRepo;
        if (inboxBadgeRepository != null) {
            inboxBadgeRepository.updateBothBadgeCounts();
        }
    }

    public LiveData<BadgeData> getCombinedBadgeData() {
        return this.combinedBadgeData;
    }

    public LiveData<BoxResponse<BoxTaskBadge>> getTaskBadgeLiveData() {
        return this.mBadgeRepo.getTaskBadge();
    }

    public LiveData<Integer> getNotificationCountLiveData() {
        return this.mBadgeRepo.getNotificationBadgeCount();
    }

    private void initializeCombinedBadgeCount() {
        this.combinedBadgeData.setValue(new BadgeData(0, false));
        if (this.mBadgeRepo != null) {
            setupLiveDataObservers();
        }
    }

    public void setupLiveDataObservers() {
        if (this.mBadgeRepo == null || this.combinedBadgeData.hasActiveObservers()) {
            return;
        }
        this.combinedBadgeData.addSource(getTaskBadgeLiveData(), new Observer() { // from class: com.box.android.vm.InboxBadgeVM$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$setupLiveDataObservers$0((BoxResponse) obj);
            }
        });
        this.combinedBadgeData.addSource(getNotificationCountLiveData(), new Observer() { // from class: com.box.android.vm.InboxBadgeVM$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$setupLiveDataObservers$1((Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupLiveDataObservers$0(BoxResponse boxResponse) {
        recalculateCombinedBadgeData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupLiveDataObservers$1(Integer num) {
        recalculateCombinedBadgeData();
    }

    private void recalculateCombinedBadgeData() {
        boolean z;
        int iIntValue;
        if (this.mBadgeRepo == null) {
            return;
        }
        BoxResponse<BoxTaskBadge> value = getTaskBadgeLiveData().getValue();
        if (value == null || value.getResult() == null) {
            z = false;
            iIntValue = 0;
        } else {
            BoxTaskBadge boxTaskBadge = (BoxTaskBadge) value.getResult();
            iIntValue = boxTaskBadge.getCount().intValue();
            z = boxTaskBadge.hasMore() != null && boxTaskBadge.hasMore().booleanValue();
        }
        Integer value2 = getNotificationCountLiveData().getValue();
        this.combinedBadgeData.setValue(new BadgeData(iIntValue + (value2 != null ? value2.intValue() : 0), z));
    }
}

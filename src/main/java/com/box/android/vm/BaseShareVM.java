package com.box.android.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.box.android.repo.ShareRepo;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.views.BoxAvatarView;
import java.io.Serializable;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes13.dex */
public class BaseShareVM extends ViewModel {
    private final LiveData<PresenterData<BoxItem>> mItemInfo;
    protected BoxItem mShareItem;
    protected final ShareRepo mShareRepo;

    public BaseShareVM(ShareRepo shareRepo, BoxCollaborationItem boxCollaborationItem) {
        this.mShareRepo = shareRepo;
        this.mShareItem = boxCollaborationItem;
        this.mItemInfo = Transformations.map(shareRepo.getItemInfo(), new Function1() { // from class: com.box.android.vm.BaseShareVM$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseShareVM.lambda$new$0((BoxResponse) obj);
            }
        });
    }

    static /* synthetic */ PresenterData lambda$new$0(BoxResponse boxResponse) {
        PresenterData presenterData = new PresenterData();
        if (boxResponse.isSuccess()) {
            presenterData.success((BoxItem) boxResponse.getResult());
            return presenterData;
        }
        presenterData.setException(boxResponse.getException());
        return presenterData;
    }

    public BoxItem getShareItem() {
        return this.mShareItem;
    }

    public void setShareItem(BoxItem boxItem) {
        this.mShareItem = boxItem;
    }

    public void fetchItemInfo(BoxItem boxItem) {
        this.mShareRepo.fetchItemInfo(boxItem);
    }

    public LiveData<PresenterData<BoxItem>> getItemInfo() {
        return this.mItemInfo;
    }

    public String getUserId() {
        return this.mShareRepo.getUserId();
    }

    public <E extends BoxAvatarView.AvatarController & Serializable> E getAvatarController() {
        return (E) this.mShareRepo.getAvatarController();
    }
}

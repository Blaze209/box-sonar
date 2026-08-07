package com.box.android.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.box.android.repo.ShareRepo;
import com.box.android.utilities.ShareSDKTransformer;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxIteratorCollaborations;
import com.box.androidsdk.content.requests.BoxResponse;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes13.dex */
public class CollaboratorsInitialsVM extends BaseShareVM {
    private final LiveData<PresenterData<BoxIteratorCollaborations>> mCollaborations;

    public CollaboratorsInitialsVM(ShareRepo shareRepo, BoxCollaborationItem boxCollaborationItem) {
        super(shareRepo, boxCollaborationItem);
        final ShareSDKTransformer shareSDKTransformer = new ShareSDKTransformer();
        this.mCollaborations = Transformations.map(shareRepo.getCollaborations(), new Function1() { // from class: com.box.android.vm.CollaboratorsInitialsVM$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$new$0(shareSDKTransformer, (BoxResponse) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ PresenterData lambda$new$0(ShareSDKTransformer shareSDKTransformer, BoxResponse boxResponse) {
        return shareSDKTransformer.getIntialsViewCollabsPresenterData(boxResponse, getCollaborationsValue());
    }

    CollaboratorsInitialsVM(ShareRepo shareRepo, BoxCollaborationItem boxCollaborationItem, final ShareSDKTransformer shareSDKTransformer) {
        super(shareRepo, boxCollaborationItem);
        this.mCollaborations = Transformations.map(shareRepo.getCollaborations(), new Function1() { // from class: com.box.android.vm.CollaboratorsInitialsVM$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$new$1(shareSDKTransformer, (BoxResponse) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ PresenterData lambda$new$1(ShareSDKTransformer shareSDKTransformer, BoxResponse boxResponse) {
        return shareSDKTransformer.getIntialsViewCollabsPresenterData(boxResponse, getCollaborationsValue());
    }

    public void fetchCollaborations(BoxCollaborationItem boxCollaborationItem) {
        this.mShareRepo.fetchCollaborations(boxCollaborationItem);
    }

    public LiveData<PresenterData<BoxIteratorCollaborations>> getCollaborations() {
        return this.mCollaborations;
    }

    public BoxIteratorCollaborations getCollaborationsValue() {
        LiveData<PresenterData<BoxIteratorCollaborations>> liveData = this.mCollaborations;
        if (liveData == null || liveData.getValue() == null) {
            return null;
        }
        return this.mCollaborations.getValue().getData();
    }
}

package com.box.android.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.box.android.coreservices.models.BoxFeatures;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.domain.utils.result.Result;
import com.box.android.repo.ShareRepo;
import com.box.android.utilities.ShareSDKTransformer;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxSharedLink;
import com.box.androidsdk.content.requests.BoxResponse;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes13.dex */
public class SharedLinkVM extends BaseShareVM {
    private final LiveData<PresenterData<BoxItem>> mShareLinkedItem;
    private final LiveData<PresenterData<BoxFeatures>> mSupportedFeatures;
    public final LiveData<Result<BoxItem, RemoteError>> updateSharedLinkPasswordResult;

    public SharedLinkVM(ShareRepo shareRepo, BoxCollaborationItem boxCollaborationItem) {
        this(shareRepo, boxCollaborationItem, new ShareSDKTransformer());
    }

    public SharedLinkVM(ShareRepo shareRepo, BoxCollaborationItem boxCollaborationItem, final ShareSDKTransformer shareSDKTransformer) {
        super(shareRepo, boxCollaborationItem);
        this.mShareLinkedItem = Transformations.map(shareRepo.getShareLinkedItem(), new Function1() { // from class: com.box.android.vm.SharedLinkVM$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$new$0(shareSDKTransformer, (BoxResponse) obj);
            }
        });
        LiveData<BoxResponse<BoxFeatures>> supportFeatures = shareRepo.getSupportFeatures();
        Objects.requireNonNull(shareSDKTransformer);
        this.mSupportedFeatures = Transformations.map(supportFeatures, new Function1() { // from class: com.box.android.vm.SharedLinkVM$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return shareSDKTransformer.getSupportedFeaturePresenterData((BoxResponse) obj);
            }
        });
        this.updateSharedLinkPasswordResult = shareRepo.updateSharedLinkPasswordResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ PresenterData lambda$new$0(ShareSDKTransformer shareSDKTransformer, BoxResponse boxResponse) {
        return shareSDKTransformer.getSharedLinkItemPresenterData(boxResponse, getShareItem());
    }

    public void createDefaultSharedLink(BoxCollaborationItem boxCollaborationItem) {
        this.mShareRepo.createDefaultSharedLink(boxCollaborationItem);
    }

    public void disableSharedLink(BoxCollaborationItem boxCollaborationItem) {
        this.mShareRepo.disableSharedLink(boxCollaborationItem);
    }

    public LiveData<PresenterData<BoxItem>> getSharedLinkedItem() {
        return this.mShareLinkedItem;
    }

    public HashSet<BoxSharedLink.Access> getActiveRadioButtons() {
        HashSet<BoxSharedLink.Access> hashSet = new HashSet<>(3);
        if (this.mShareItem.getAllowedSharedLinkAccessLevels() != null) {
            Iterator<BoxSharedLink.Access> it = this.mShareItem.getAllowedSharedLinkAccessLevels().iterator();
            while (it.hasNext()) {
                int i = AnonymousClass1.$SwitchMap$com$box$androidsdk$content$models$BoxSharedLink$Access[it.next().ordinal()];
                if (i == 1) {
                    hashSet.add(BoxSharedLink.Access.OPEN);
                } else if (i == 2) {
                    hashSet.add(BoxSharedLink.Access.COMPANY);
                } else if (i == 3) {
                    hashSet.add(BoxSharedLink.Access.COLLABORATORS);
                }
            }
        }
        return hashSet;
    }

    /* JADX INFO: renamed from: com.box.android.vm.SharedLinkVM$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$box$androidsdk$content$models$BoxSharedLink$Access;

        static {
            int[] iArr = new int[BoxSharedLink.Access.values().length];
            $SwitchMap$com$box$androidsdk$content$models$BoxSharedLink$Access = iArr;
            try {
                iArr[BoxSharedLink.Access.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$box$androidsdk$content$models$BoxSharedLink$Access[BoxSharedLink.Access.COMPANY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$box$androidsdk$content$models$BoxSharedLink$Access[BoxSharedLink.Access.COLLABORATORS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$box$androidsdk$content$models$BoxSharedLink$Access[BoxSharedLink.Access.DEFAULT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public void changePermission(BoxCollaborationItem boxCollaborationItem, BoxSharedLink.Permission permission) throws IllegalArgumentException {
        this.mShareRepo.changeItemPermission(boxCollaborationItem, permission);
    }

    public void setExpiryDate(BoxCollaborationItem boxCollaborationItem, Date date) throws Exception {
        this.mShareRepo.setExpiryDate(boxCollaborationItem, date);
    }

    public void changeAccessLevel(BoxCollaborationItem boxCollaborationItem, BoxSharedLink.Access access) {
        this.mShareRepo.changeAccessLevel(boxCollaborationItem, access);
    }

    public void changePassword(BoxCollaborationItem boxCollaborationItem, String str) {
        this.mShareRepo.changePassword(boxCollaborationItem, str);
    }

    public void removeExpiryDate(BoxCollaborationItem boxCollaborationItem) throws Exception {
        this.mShareRepo.removeExpiryDate(boxCollaborationItem);
    }

    public void fetchSupportedFeatures() {
        this.mShareRepo.fetchSupportedFeatures();
    }

    public LiveData<PresenterData<BoxFeatures>> getSupportedFeatures() {
        return this.mSupportedFeatures;
    }
}

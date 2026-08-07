package com.box.android.base.presentation.multiselect;

import com.box.android.domain.models.DomainModel;
import com.box.android.domain.models.hubs.HubModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.RecentFileModel;
import com.box.android.domain.models.item.SharedLinkModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SelectionManager.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002\u001a\f\u0010\u0007\u001a\u00020\u0006*\u00020\u0002H\u0002\u001a\f\u0010\b\u001a\u0004\u0018\u00010\u0006*\u00020\u0002¨\u0006\t"}, d2 = {"toSelectionItemInfo", "Lcom/box/android/base/presentation/multiselect/SelectionItemInfo;", "Lcom/box/android/domain/models/DomainModel;", "selectionId", "Lcom/box/android/base/presentation/multiselect/SelectionId;", "selectionScreenSource", "", "name", "sharedLinkUrl", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SelectionManagerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final SelectionItemInfo toSelectionItemInfo(DomainModel domainModel, SelectionId selectionId, String str) {
        return domainModel instanceof SelectionItemInfo ? (SelectionItemInfo) domainModel : new SelectionItemInfo(selectionId.getId(), name(domainModel), selectionId.getType(), sharedLinkUrl(domainModel), selectionId.getId(), str);
    }

    private static final String name(DomainModel domainModel) {
        if (domainModel instanceof ItemModel) {
            return ((ItemModel) domainModel).getName();
        }
        if (!(domainModel instanceof HubModel)) {
            return domainModel instanceof SelectionItemInfo ? ((SelectionItemInfo) domainModel).getName() : "";
        }
        String title = ((HubModel) domainModel).getTitle();
        Intrinsics.checkNotNull(title);
        return title;
    }

    public static final String sharedLinkUrl(DomainModel domainModel) {
        Intrinsics.checkNotNullParameter(domainModel, "<this>");
        if (domainModel instanceof RecentFileModel) {
            RecentFileModel recentFileModel = (RecentFileModel) domainModel;
            String interactionSharedLink = recentFileModel.getRecentItem().getInteractionSharedLink();
            if (interactionSharedLink != null) {
                return interactionSharedLink;
            }
            SharedLinkModel sharedLink = recentFileModel.getSharedLink();
            if (sharedLink != null) {
                return sharedLink.getUrl();
            }
            return null;
        }
        if (!(domainModel instanceof ItemModel)) {
            if (domainModel instanceof SelectionItemInfo) {
                return ((SelectionItemInfo) domainModel).getSharedLinkUrl();
            }
            return null;
        }
        SharedLinkModel sharedLink2 = ((ItemModel) domainModel).getSharedLink();
        if (sharedLink2 != null) {
            return sharedLink2.getUrl();
        }
        return null;
    }
}

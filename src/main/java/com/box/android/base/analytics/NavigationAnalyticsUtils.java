package com.box.android.base.analytics;

import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.identity.IUserContextManager;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.utils.BoxItemUtility;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes9.dex */
public class NavigationAnalyticsUtils {
    public static String calculateContentOwnership(BoxItem boxItem, IBaseModelController iBaseModelController, BoxExtendedApiFolder boxExtendedApiFolder, IUserContextManager iUserContextManager) {
        if (boxItem instanceof BoxFolder) {
            return calculateContentOwnershipType((BoxFolder) boxItem, iUserContextManager);
        }
        if (boxItem instanceof BoxFile) {
            BoxFile boxFile = (BoxFile) boxItem;
            if (boxFile.getParent() == null || StringUtils.equals(boxFile.getParent().getUserId(), "0")) {
                return calculateContentOwnershipType(boxFile, iUserContextManager);
            }
            try {
                return calculateContentOwnershipType((BoxFolder) iBaseModelController.performLocal(boxExtendedApiFolder.getFolderWithAllItems(boxFile.getParent().getUserId())).get().getResult(), iUserContextManager);
            } catch (Exception e) {
                BoxLogUtils.e(NavigationAnalyticsUtils.class.getName(), e);
                return BoxAnalyticsParams.CONTENT_OWNERSHIP_OWNED_PRIVATE;
            }
        }
        return BoxAnalyticsParams.CONTENT_OWNERSHIP_OWNED_PRIVATE;
    }

    static String calculateContentOwnershipType(BoxCollaborationItem boxCollaborationItem, IUserContextManager iUserContextManager) {
        if (boxCollaborationItem.getIsExternallyOwned() != null && boxCollaborationItem.getIsExternallyOwned().booleanValue()) {
            return BoxAnalyticsParams.CONTENT_OWNERSHIP_EXTERNAL_SHARED;
        }
        if (boxCollaborationItem.getHasCollaborations() != null && boxCollaborationItem.getHasCollaborations().booleanValue()) {
            if (BoxItemUtility.isSharedWithMe(boxCollaborationItem, iUserContextManager.getUserInfo())) {
                return BoxAnalyticsParams.CONTENT_OWNERSHIP_INTERNAL_SHARED;
            }
            return BoxAnalyticsParams.CONTENT_OWNERSHIP_OWNED_SHARED;
        }
        return BoxAnalyticsParams.CONTENT_OWNERSHIP_OWNED_PRIVATE;
    }
}

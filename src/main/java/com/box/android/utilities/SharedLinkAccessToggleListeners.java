package com.box.android.utilities;

import com.box.android.usx.fragments.SharedLinkAccessFragment;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxSharedLink;

/* JADX INFO: loaded from: classes13.dex */
public class SharedLinkAccessToggleListeners {
    public static void onAccessLevelCheckChanged(boolean z, BoxSharedLink.Access access, SharedLinkAccessFragment.SharedLinkAccessNotifiers sharedLinkAccessNotifiers) {
        if (z) {
            sharedLinkAccessNotifiers.notifyAccessLevelChange(access);
        }
    }

    public static void onPermissionChange(BoxSharedLink.Permission permission, SharedLinkAccessFragment.SharedLinkAccessNotifiers sharedLinkAccessNotifiers) {
        sharedLinkAccessNotifiers.notifyPermissionChange(permission);
    }

    public static void onPasswordToggle(boolean z, BoxItem boxItem, SharedLinkAccessFragment.SharedLinkAccessNotifiers sharedLinkAccessNotifiers) {
        if (boxItem == null || boxItem.getSharedLink() == null || boxItem.getSharedLink().getIsPasswordEnabled().booleanValue() == z) {
            return;
        }
        sharedLinkAccessNotifiers.notifyRequirePassword(z);
    }

    public static void onExpireToggle(boolean z, BoxItem boxItem, SharedLinkAccessFragment.SharedLinkAccessNotifiers sharedLinkAccessNotifiers) {
        if (boxItem == null || boxItem.getSharedLink() == null) {
            return;
        }
        if ((boxItem.getSharedLink().getUnsharedDate() != null) == z) {
            return;
        }
        sharedLinkAccessNotifiers.notifyExpireLink(z);
    }
}

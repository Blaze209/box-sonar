package com.box.android.coreservices.jobmanager.tasks;

import com.box.android.coreservices.jobmanager.jobs.BoxJob;
import com.box.android.coreservices.modelcontroller.MoCoContainerBuilder;
import com.box.android.coreservices.models.BoxModelOfflineManager;
import com.box.androidsdk.content.models.BoxBookmark;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public abstract class CleanUpItemTask extends BoxItemTask {
    protected CleanUpItemTask() {
    }

    protected CleanUpItemTask(String str, String str2, BoxItem boxItem, MoCoContainerBuilder.MoCoContainer moCoContainer, BoxJob boxJob) {
        super(str, str2, boxItem, moCoContainer, boxJob);
    }

    protected void populateListsWithChildren(List<BoxFolder> list, List<BoxFile> list2, List<BoxBookmark> list3, BoxSession boxSession) {
        if (getItem() instanceof BoxFile) {
            list2.add((BoxFile) getItem());
            return;
        }
        if (getItem() instanceof BoxBookmark) {
            list3.add((BoxBookmark) getItem());
            return;
        }
        if (getItem() instanceof BoxFolder) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(getItemId());
            while (linkedList.size() > 0) {
                try {
                    BoxFolder boxFolderSendForCachedResult = this.mMoCoContainer.getFolderApi().getFolderWithAllItems((String) linkedList.pop()).sendForCachedResult();
                    if (boxFolderSendForCachedResult != null) {
                        for (BoxItem boxItem : boxFolderSendForCachedResult.getItemCollection()) {
                            if (!BoxModelOfflineManager.isSpecificallyUserSaved(boxItem, this.mMoCoContainer.getUserContextManager())) {
                                if (boxItem instanceof BoxFolder) {
                                    list.add((BoxFolder) boxItem);
                                    linkedList.add(boxItem.getUserId());
                                } else if (boxItem instanceof BoxFile) {
                                    list2.add((BoxFile) boxItem);
                                } else if (boxItem instanceof BoxBookmark) {
                                    list3.add((BoxBookmark) boxItem);
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    BoxLogUtils.logException(e);
                    setErrorStateFromError(e);
                }
            }
        }
    }
}

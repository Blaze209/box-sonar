package com.box.android.utilities;

import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.androidsdk.content.models.BoxComment;
import com.box.androidsdk.content.models.BoxEntity;
import com.box.androidsdk.content.models.BoxEvent;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxIteratorEvents;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.concurrent.ExecutionException;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes13.dex */
public class BoxEventUtils {
    public static void refreshItemsInEvents(IBaseModelController iBaseModelController, BoxExtendedApiFolder boxExtendedApiFolder, BoxExtendedApiFile boxExtendedApiFile, BoxIteratorEvents boxIteratorEvents) throws ExecutionException, InterruptedException {
        TreeSet<BoxEntity> treeSet = new TreeSet(new Comparator<BoxEntity>() { // from class: com.box.android.utilities.BoxEventUtils.1
            @Override // java.util.Comparator
            public int compare(BoxEntity boxEntity, BoxEntity boxEntity2) {
                if (boxEntity.getType().equals(boxEntity2.getType()) && boxEntity.getUserId().equals(boxEntity2.getUserId())) {
                    return 0;
                }
                return boxEntity.getUserId().compareTo(boxEntity2.getUserId());
            }
        });
        Iterator<E> it = boxIteratorEvents.iterator();
        while (it.hasNext()) {
            BoxEvent boxEvent = (BoxEvent) it.next();
            if (boxEvent.getSource() != null && isEventRefreshWorthy(boxEvent)) {
                treeSet.add(boxEvent.getSource());
            }
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (BoxEntity boxEntity : treeSet) {
            if (boxEntity instanceof BoxFile) {
                String parentId = getParentId(iBaseModelController, (BoxFile) boxEntity);
                if (!StringUtils.isBlank(parentId)) {
                    hashSet.add(parentId);
                }
            } else if (boxEntity instanceof BoxFolder) {
                BoxFolder boxFolder = (BoxFolder) boxEntity;
                hashSet.add(boxFolder.getUserId());
                String parentId2 = getParentId(iBaseModelController, boxFolder);
                if (!StringUtils.isBlank(parentId2)) {
                    hashSet.add(parentId2);
                }
            } else if (boxEntity instanceof BoxComment) {
                BoxComment boxComment = (BoxComment) boxEntity;
                if (boxComment.getItem() != null && (boxComment.getItem() instanceof BoxFile)) {
                    hashSet2.add(boxComment.getItem().getUserId());
                }
            }
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            iBaseModelController.performRemote(boxExtendedApiFolder.getInfoRequest((String) it2.next())).get();
        }
        Iterator it3 = hashSet2.iterator();
        while (it3.hasNext()) {
            iBaseModelController.performRemote(boxExtendedApiFile.getInfoRequest((String) it3.next())).get();
        }
    }

    private static String getParentId(IBaseModelController iBaseModelController, BoxItem boxItem) {
        if (boxItem.getParent() != null) {
            return boxItem.getParent().getUserId();
        }
        try {
            return iBaseModelController.getParentId(boxItem);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isEventRefreshWorthy(BoxEvent boxEvent) {
        HashSet hashSet = new HashSet();
        hashSet.add(BoxEvent.EVENT_TYPE_ITEM_CREATE);
        hashSet.add(BoxEvent.EVENT_TYPE_ITEM_UPLOAD);
        hashSet.add(BoxEvent.EVENT_TYPE_COMMENT_CREATE);
        hashSet.add(BoxEvent.EVENT_TYPE_ITEM_MOVE);
        hashSet.add(BoxEvent.EVENT_TYPE_ITEM_COPY);
        hashSet.add(BoxEvent.EVENT_TYPE_ITEM_TRASH);
        hashSet.add(BoxEvent.EVENT_TYPE_ITEM_UNDELETE_VIA_TRASH);
        hashSet.add(BoxEvent.EVENT_TYPE_COLLAB_ADD_COLLABORATOR);
        hashSet.add(BoxEvent.EVENT_TYPE_COLLAB_INVITE_COLLABORATOR);
        hashSet.add(BoxEvent.EVENT_TYPE_ITEM_RENAME);
        return hashSet.contains(boxEvent.getEventType());
    }
}

package com.box.boxandroidlibv2private.requests;

import com.box.androidsdk.content.BoxApiFolder;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxCacheableRequest;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxRequestItem;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.boxandroidlibv2private.requests.requestobjects.BoxFullFolder;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestGetFullFolder extends BoxRequestItem<BoxFullFolder, BoxRequestGetFullFolder> implements BoxCacheableRequest<BoxFullFolder> {
    public static final String URI = "folders/%s";
    private static final long serialVersionUID = -146995023920583104L;
    private BoxApiFolder mBoxApiFolder;
    private String mFolderId;

    public BoxRequestGetFullFolder(String str, String str2, BoxSession boxSession, BoxApiFolder boxApiFolder) {
        super(BoxFullFolder.class, str, str2, boxSession);
        this.mRequestMethod = BoxRequest.Methods.GET;
        this.mBoxApiFolder = boxApiFolder;
        this.mFolderId = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.box.androidsdk.content.requests.BoxRequest
    public BoxFullFolder onSend() throws BoxException {
        LinkedList linkedList = new LinkedList();
        linkedList.add(this.mFolderId);
        BoxFullFolder boxFullFolder = null;
        while (!linkedList.isEmpty() && !Thread.interrupted()) {
            String str = (String) linkedList.remove();
            BoxFolder boxFolder = (BoxFolder) this.mBoxApiFolder.getFolderWithAllItems(str).setFields(this.mQueryMap.get(QUERY_FIELDS)).send();
            if (str.equalsIgnoreCase(this.mFolderId)) {
                boxFullFolder = new BoxFullFolder(boxFolder);
            }
            if (boxFullFolder != null) {
                boxFullFolder.addChildren(boxFolder.getItemCollection());
            }
            for (BoxItem boxItem : boxFolder.getItemCollection()) {
                if (boxItem instanceof BoxFolder) {
                    linkedList.add(boxItem.getUserId());
                }
            }
        }
        return boxFullFolder;
    }

    public static String getUri(String str) {
        return String.format(URI, str);
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public BoxFullFolder sendForCachedResult() throws BoxException {
        return (BoxFullFolder) super.handleSendForCachedResult();
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public BoxFutureTask<BoxFullFolder> toTaskForCachedResult() throws BoxException {
        return super.handleToTaskForCachedResult();
    }

    @Override // com.box.androidsdk.content.requests.BoxRequestItem, com.box.androidsdk.content.requests.BoxRequest
    protected void onSendCompleted(BoxResponse<BoxFullFolder> boxResponse) throws BoxException {
        super.onSendCompleted(boxResponse);
        super.handleUpdateCache(boxResponse);
    }
}

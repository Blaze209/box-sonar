package com.box.android.providers;

import android.database.MatrixCursor;
import android.os.Bundle;
import android.text.TextUtils;
import com.box.android.base.presentation.ThumbnailManager;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.models.BoxLocalMetadata;
import com.box.android.domain.localrepo.IKeyValueStore;
import com.box.android.domain.metrics.hubs.HubsObservability;
import com.box.android.domain.utils.SupportedFileExtensions;
import com.box.androidsdk.content.models.BoxBookmark;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxIterator;
import com.box.androidsdk.content.models.BoxIteratorItems;
import java.util.Iterator;

/* JADX INFO: loaded from: classes12.dex */
public class DocCursor extends MatrixCursor {
    private Bundle mExtras;

    public DocCursor(BoxIteratorItems boxIteratorItems, String[] strArr, IKeyValueStore iKeyValueStore) {
        super(strArr, boxIteratorItems.size());
        Iterator<E> it = boxIteratorItems.iterator();
        while (it.hasNext()) {
            BoxItem boxItem = (BoxItem) it.next();
            if (!TextUtils.equals(boxItem.getType(), BoxBookmark.TYPE)) {
                addRow(boxItem, (BoxLocalMetadata) iKeyValueStore.getLocalMetadataForObject(boxItem.getType(), boxItem.getUserId()));
            }
        }
    }

    public DocCursor(BoxIterator<BoxItem> boxIterator, String[] strArr, IKeyValueStore iKeyValueStore) {
        super(strArr, boxIterator.size());
        for (BoxItem boxItem : boxIterator) {
            if (!TextUtils.equals(boxItem.getType(), BoxBookmark.TYPE)) {
                addRow(boxItem, (BoxLocalMetadata) iKeyValueStore.getLocalMetadataForObject(boxItem.getType(), boxItem.getUserId()));
            }
        }
    }

    public DocCursor(BoxItem boxItem, String[] strArr) {
        super(strArr, 1);
        if (TextUtils.equals(boxItem.getType(), BoxBookmark.TYPE)) {
            return;
        }
        addRow(boxItem, null);
    }

    protected final void addRow(BoxItem boxItem, BoxLocalMetadata boxLocalMetadata) {
        buildRow(boxItem, boxLocalMetadata, newRow());
    }

    protected void buildRow(BoxItem boxItem, BoxLocalMetadata boxLocalMetadata, MatrixCursor.RowBuilder rowBuilder) {
        rowBuilder.add("document_id", BoxDocumentsProvider.TypedId.getDocumentId(boxItem));
        rowBuilder.add("_display_name", boxItem.getName());
        rowBuilder.add("_size", boxItem.getSize());
        rowBuilder.add("mime_type", BoxDocumentsProvider.getTypeForBoxItem(boxItem));
        rowBuilder.add("last_modified", Long.valueOf(boxItem.getModifiedAt() != null ? boxItem.getModifiedAt().getTime() : -1L));
        rowBuilder.add("flags", Integer.valueOf(generateFlags(boxItem)));
        rowBuilder.add(HubsObservability.HUB_ASSET_ICON, Integer.valueOf(getDefaultDrawable(boxItem)));
    }

    public static DocCursor buildErrorCursor(String str, String[] strArr, IKeyValueStore iKeyValueStore) {
        DocCursor docCursor = new DocCursor(new BoxIteratorItems(), strArr, iKeyValueStore);
        docCursor.setErrorInformation(str);
        return docCursor;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public Bundle getExtras() {
        Bundle bundle = this.mExtras;
        return bundle == null ? super.getExtras() : bundle;
    }

    public void setIsLoading(boolean z) {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        this.mExtras.putBoolean("loading", z);
    }

    public void setErrorInformation(String str) {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        this.mExtras.putString("error", str);
    }

    protected static int generateFlags(BoxItem boxItem) {
        int i = boxItem instanceof BoxFolder ? 8 : 0;
        int i2 = i | 6;
        String fileExtension = CommonBoxUtil.getFileExtension(boxItem.getName(), "");
        return (SupportedFileExtensions.INSTANCE.isImageExtension(fileExtension) || SupportedFileExtensions.INSTANCE.isGifExtension(fileExtension) || SupportedFileExtensions.INSTANCE.isVectorExtension(fileExtension) || SupportedFileExtensions.INSTANCE.isAdobePhotoshopExtension(fileExtension)) ? i | 7 : i2;
    }

    protected static int getDefaultDrawable(BoxItem boxItem) {
        return ThumbnailManager.getDefaultIconResource(boxItem);
    }
}

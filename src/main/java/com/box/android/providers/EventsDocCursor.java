package com.box.android.providers;

import android.database.MatrixCursor;
import com.box.android.coreservices.modelcontroller.BoxTypedObjectsCursor;
import com.box.android.coreservices.models.BoxLocalMetadata;
import com.box.android.domain.metrics.hubs.HubsObservability;
import com.box.androidsdk.content.models.BoxBookmark;
import com.box.androidsdk.content.models.BoxEntity;
import com.box.androidsdk.content.models.BoxEvent;
import com.box.androidsdk.content.models.BoxItem;
import java.util.Date;

/* JADX INFO: loaded from: classes12.dex */
public class EventsDocCursor extends MatrixCursor {
    public EventsDocCursor(BoxTypedObjectsCursor<BoxEntity> boxTypedObjectsCursor, String[] strArr) {
        super(strArr, boxTypedObjectsCursor.getCount());
        for (int i = 0; i < boxTypedObjectsCursor.getCount(); i++) {
            if (!(boxTypedObjectsCursor.getItem() instanceof BoxBookmark)) {
                buildRow(boxTypedObjectsCursor.getItem(), boxTypedObjectsCursor.getItemLocalMetadataAt(i), newRow());
            }
        }
    }

    protected void buildRow(BoxEntity boxEntity, BoxLocalMetadata boxLocalMetadata, MatrixCursor.RowBuilder rowBuilder) {
        BoxItem boxItem;
        Object objValueOf;
        boolean z = boxEntity instanceof BoxEvent;
        if (z) {
            boxItem = (BoxItem) ((BoxEvent) boxEntity).getSource();
        } else {
            boxItem = boxEntity instanceof BoxItem ? (BoxItem) boxEntity : null;
        }
        if (boxItem != null) {
            rowBuilder.add("document_id", BoxDocumentsProvider.TypedId.getDocumentId(boxItem));
            rowBuilder.add("_display_name", boxItem.getName());
            rowBuilder.add("_size", boxItem.getSize());
            rowBuilder.add("mime_type", BoxDocumentsProvider.getTypeForBoxItem(boxItem));
            rowBuilder.add("flags", Integer.valueOf(DocCursor.generateFlags(boxItem)));
            rowBuilder.add(HubsObservability.HUB_ASSET_ICON, Integer.valueOf(DocCursor.getDefaultDrawable(boxItem)));
            if (boxLocalMetadata != null && boxLocalMetadata.get(BoxLocalMetadata.FIELD_RECENT_TIMESTAMP) != null) {
                rowBuilder.add("last_modified", Long.valueOf(new Date(((Long) boxLocalMetadata.get(BoxLocalMetadata.FIELD_RECENT_TIMESTAMP)).longValue()).getTime()));
                return;
            }
            if (z) {
                objValueOf = ((BoxEvent) boxEntity).getCreatedAt();
            } else {
                objValueOf = Long.valueOf(boxItem.getModifiedAt() != null ? boxItem.getModifiedAt().getTime() : -1L);
            }
            rowBuilder.add("last_modified", objValueOf);
        }
    }
}

package com.box.android.coreservices.modelcontroller.messages;

import com.box.android.coreservices.modelcontroller.MoCoCursor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public abstract class BoxPluralMessage<E extends MoCoCursor<T>, T> extends BoxMessage<E> {
    protected static final String CURSOR_IDS_LIST_EXTRA = "box_cursor_ids_list_extra";

    @Override // com.box.android.coreservices.modelcontroller.messages.BoxMessage
    public abstract E getPayload();

    public void setTypedIds(List<String> list) {
        if (list == null) {
            putExtra(CURSOR_IDS_LIST_EXTRA, new String[0]);
        } else {
            putExtra(CURSOR_IDS_LIST_EXTRA, (String[]) list.toArray(new String[0]));
        }
    }

    protected List<String> getTypedIds() {
        String[] stringArrayExtra = getStringArrayExtra(CURSOR_IDS_LIST_EXTRA);
        if (stringArrayExtra == null) {
            stringArrayExtra = new String[0];
        }
        return new ArrayList(Arrays.asList(stringArrayExtra));
    }
}

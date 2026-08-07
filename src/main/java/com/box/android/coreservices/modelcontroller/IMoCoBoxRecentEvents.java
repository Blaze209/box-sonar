package com.box.android.coreservices.modelcontroller;

import com.box.android.coreservices.modelcontroller.messages.BoxItemsMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxLocalMetadataMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxRecentItemsMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxVoidMessage;
import com.box.android.coreservices.models.BoxFragmentFilenameFilter;
import com.box.androidsdk.content.models.BoxEntity;
import com.box.androidsdk.content.models.BoxFile;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public interface IMoCoBoxRecentEvents {
    BoxFutureTask<BoxVoidMessage> addFileToRecents(BoxFile boxFile, String str);

    BoxFutureTask<BoxVoidMessage> addFileToRecents(String str, String str2);

    BoxFutureTask<BoxRecentItemsMessage> getInterleavedRecentsAndEvents(boolean z);

    BoxFutureTask<BoxRecentItemsMessage> getInterleavedRecentsAndEvents(boolean z, int i);

    BoxFutureTask<BoxRecentItemsMessage> getInterleavedRecentsAndEvents(boolean z, int i, String str, List<String> list);

    BoxFutureTask<BoxItemsMessage> getRecents(int i, boolean z);

    BoxFutureTask<BoxItemsMessage> getRecentsLocalFiltered(int i, boolean z, BoxFragmentFilenameFilter boxFragmentFilenameFilter);

    boolean isEveryoneSelected();

    void setIsEveryoneSelected(boolean z);

    BoxFutureTask<BoxVoidMessage> setItemUserDismissed(BoxEntity boxEntity, boolean z);

    BoxFutureTask<BoxLocalMetadataMessage> updateItemLocalMetadata(BoxEntity boxEntity, String str, Object obj);
}

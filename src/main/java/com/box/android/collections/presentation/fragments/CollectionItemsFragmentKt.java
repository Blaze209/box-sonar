package com.box.android.collections.presentation.fragments;

import com.box.android.coreservices.jobmanager.jobs.OfflineBoxJob;
import com.box.android.coreservices.jobmanager.jobs.RemoveOfflineBoxJob;
import com.box.android.coreservices.jobmanager.tasks.OfflinePreviewTask;
import com.box.android.coreservices.jobmanager.tasks.OfflineTask;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionItemsFragment.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0002¨\u0006\u0003"}, d2 = {"isOfflineSingleTaskMessage", "", "Lcom/box/android/coreservices/modelcontroller/messages/BoxMessage;", "collections_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CollectionItemsFragmentKt {
    public static final boolean isOfflineSingleTaskMessage(BoxMessage<?> boxMessage) {
        Intrinsics.checkNotNullParameter(boxMessage, "<this>");
        return Intrinsics.areEqual(boxMessage.getAction(), OfflineBoxJob.class.getName()) || Intrinsics.areEqual(boxMessage.getAction(), OfflineTask.class.getName()) || Intrinsics.areEqual(boxMessage.getAction(), OfflinePreviewTask.class.getName()) || Intrinsics.areEqual(boxMessage.getAction(), RemoveOfflineBoxJob.class.getName());
    }
}

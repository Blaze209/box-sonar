package com.box.android.utilities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.coreservices.modelcontroller.messages.BoxFileTransferMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxResponseMessage;
import com.box.android.coreservices.modelcontroller.messages.Controller;
import com.box.android.domain.services.ILegacyBridgeService;
import com.box.androidsdk.content.models.BoxCollaboration;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxObject;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxRequestItemDelete;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.boxandroidlibv2private.dao.BoxNoteCreation;
import com.box.boxandroidlibv2private.requests.BoxRequestDeleteCollaboration;
import com.box.boxandroidlibv2private.requests.BoxRequestUploadFile;
import com.microsoft.intune.mam.client.content.MAMBroadcastReceiver;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.KClassesJvm;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: LegacyMessageToGQLBridge.kt */
/* JADX INFO: loaded from: classes13.dex */
@Singleton
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/box/android/utilities/LegacyMessageToGQLBridge;", "", "legacyBridgeService", "Lcom/box/android/domain/services/ILegacyBridgeService;", "<init>", "(Lcom/box/android/domain/services/ILegacyBridgeService;)V", "legacyMessagesReceiver", "Landroid/content/BroadcastReceiver;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LegacyMessageToGQLBridge {
    public static final int $stable = 8;
    private final ILegacyBridgeService legacyBridgeService;
    private final BroadcastReceiver legacyMessagesReceiver;

    @Inject
    public LegacyMessageToGQLBridge(ILegacyBridgeService legacyBridgeService) {
        Intrinsics.checkNotNullParameter(legacyBridgeService, "legacyBridgeService");
        this.legacyBridgeService = legacyBridgeService;
        MAMBroadcastReceiver mAMBroadcastReceiver = new MAMBroadcastReceiver() { // from class: com.box.android.utilities.LegacyMessageToGQLBridge$legacyMessagesReceiver$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
            public void onMAMReceive(Context context, Intent intent) {
                BoxItem item;
                BoxResponse response;
                BoxCollaboration collaboration;
                BoxFile boxFile;
                BoxFile newNote;
                BoxResponse response2;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                BoxMessage boxMessage = intent instanceof BoxMessage ? (BoxMessage) intent : null;
                if (boxMessage != null) {
                    LegacyMessageToGQLBridge legacyMessageToGQLBridge = this.this$0;
                    String action = boxMessage.getAction();
                    if (Intrinsics.areEqual(action, Controller.ACTION_BOX_NOTE_CREATED)) {
                        BoxResponseMessage boxResponseMessage = boxMessage instanceof BoxResponseMessage ? (BoxResponseMessage) boxMessage : null;
                        BoxObject result = (boxResponseMessage == null || (response2 = boxResponseMessage.getResponse()) == null) ? null : response2.getResult();
                        BoxNoteCreation boxNoteCreation = result instanceof BoxNoteCreation ? (BoxNoteCreation) result : null;
                        if (boxNoteCreation == null || (newNote = boxNoteCreation.getNewNote()) == null) {
                            return;
                        }
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new LegacyMessageToGQLBridge$legacyMessagesReceiver$1$onReceive$1$1$1(legacyMessageToGQLBridge, newNote, null), 3, null);
                        return;
                    }
                    if (Intrinsics.areEqual(action, Controller.ACTION_UPLOADED_FILE)) {
                        BoxFileTransferMessage boxFileTransferMessage = boxMessage instanceof BoxFileTransferMessage ? (BoxFileTransferMessage) boxMessage : null;
                        if (boxFileTransferMessage == null || (boxFile = (BoxFile) boxFileTransferMessage.getPayload()) == null) {
                            return;
                        }
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new LegacyMessageToGQLBridge$legacyMessagesReceiver$1$onReceive$1$2$1(legacyMessageToGQLBridge, boxFile, null), 3, null);
                        return;
                    }
                    if (Intrinsics.areEqual(action, Controller.ACTION_DELETED_FILE) || Intrinsics.areEqual(action, Controller.ACTION_DELETED_FOLDER) || Intrinsics.areEqual(action, Controller.ACTION_DELETED_BOOKMARK)) {
                        BoxResponseMessage boxResponseMessage2 = boxMessage instanceof BoxResponseMessage ? (BoxResponseMessage) boxMessage : null;
                        BoxRequest request = boxResponseMessage2 != null ? boxResponseMessage2.getRequest() : null;
                        BoxRequestItemDelete boxRequestItemDelete = request instanceof BoxRequestItemDelete ? (BoxRequestItemDelete) request : null;
                        if (boxRequestItemDelete == null || (item = boxRequestItemDelete.getItem()) == null) {
                            return;
                        }
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new LegacyMessageToGQLBridge$legacyMessagesReceiver$1$onReceive$1$3$1(legacyMessageToGQLBridge, item, null), 3, null);
                        return;
                    }
                    if (Intrinsics.areEqual(action, Controller.ACTION_DELETED_COLLABORATION)) {
                        BoxResponseMessage boxResponseMessage3 = boxMessage instanceof BoxResponseMessage ? (BoxResponseMessage) boxMessage : null;
                        BoxRequest request2 = boxResponseMessage3 != null ? boxResponseMessage3.getRequest() : null;
                        BoxRequestDeleteCollaboration boxRequestDeleteCollaboration = request2 instanceof BoxRequestDeleteCollaboration ? (BoxRequestDeleteCollaboration) request2 : null;
                        if (boxRequestDeleteCollaboration == null || (collaboration = boxRequestDeleteCollaboration.getCollaboration()) == null) {
                            return;
                        }
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new LegacyMessageToGQLBridge$legacyMessagesReceiver$1$onReceive$1$4$1(legacyMessageToGQLBridge, collaboration, null), 3, null);
                        return;
                    }
                    if (Intrinsics.areEqual(action, Controller.ACTION_CREATED_FOLDER)) {
                        BoxResponseMessage boxResponseMessage4 = boxMessage instanceof BoxResponseMessage ? (BoxResponseMessage) boxMessage : null;
                        BoxObject result2 = (boxResponseMessage4 == null || (response = boxResponseMessage4.getResponse()) == null) ? null : response.getResult();
                        BoxFolder boxFolder = result2 instanceof BoxFolder ? (BoxFolder) result2 : null;
                        if (boxFolder != null) {
                            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new LegacyMessageToGQLBridge$legacyMessagesReceiver$1$onReceive$1$5$1(legacyMessageToGQLBridge, boxFolder, null), 3, null);
                            return;
                        }
                        return;
                    }
                    if (Intrinsics.areEqual(action, KClassesJvm.getJvmName(Reflection.getOrCreateKotlinClass(BoxRequestUploadFile.class)))) {
                        BoxResponseMessage boxResponseMessage5 = boxMessage instanceof BoxResponseMessage ? (BoxResponseMessage) boxMessage : null;
                        BoxObject payload = boxResponseMessage5 != null ? boxResponseMessage5.getPayload() : null;
                        BoxFile boxFile2 = payload instanceof BoxFile ? (BoxFile) payload : null;
                        if (boxFile2 != null) {
                            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new LegacyMessageToGQLBridge$legacyMessagesReceiver$1$onReceive$1$6$1(legacyMessageToGQLBridge, boxFile2, null), 3, null);
                        }
                    }
                }
            }
        };
        this.legacyMessagesReceiver = mAMBroadcastReceiver;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Controller.ACTION_BOX_NOTE_CREATED);
        intentFilter.addAction(Controller.ACTION_UPLOADED_FILE);
        intentFilter.addAction(Controller.ACTION_DELETED_FILE);
        intentFilter.addAction(Controller.ACTION_DELETED_FOLDER);
        intentFilter.addAction(Controller.ACTION_DELETED_BOOKMARK);
        intentFilter.addAction(Controller.ACTION_DELETED_COLLABORATION);
        intentFilter.addAction(Controller.ACTION_CREATED_FOLDER);
        intentFilter.addAction(KClassesJvm.getJvmName(Reflection.getOrCreateKotlinClass(BoxRequestUploadFile.class)));
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(ApplicationProvider.getApplication());
        Intrinsics.checkNotNullExpressionValue(localBroadcastManager, "getInstance(...)");
        localBroadcastManager.registerReceiver(mAMBroadcastReceiver, intentFilter);
    }
}

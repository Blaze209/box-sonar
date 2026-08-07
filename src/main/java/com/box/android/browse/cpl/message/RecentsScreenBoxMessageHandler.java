package com.box.android.browse.cpl.message;

import com.box.android.base.presentation.message.BoxMessageHandler;
import com.box.android.browse.cpl.recents.RecentsReducer;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxSwitchUserMessage;
import com.box.android.coreservices.modelcontroller.messages.Controller;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecentsScreenBoxMessageHandler.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0002J\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0016R\u001e\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/box/android/browse/cpl/message/RecentsScreenBoxMessageHandler;", "Lcom/box/android/base/presentation/message/BoxMessageHandler;", "Lcom/box/android/browse/cpl/recents/RecentsReducer$Action;", "<init>", "()V", "SUCCESS_MESSAGES", "", "", "kotlin.jvm.PlatformType", "[Ljava/lang/String;", "ALWAYS_HANDLE_MESSAGES", "shouldHandle", "", "message", "Lcom/box/android/coreservices/modelcontroller/messages/BoxMessage;", "handle", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecentsScreenBoxMessageHandler implements BoxMessageHandler<RecentsReducer.Action> {
    public static final RecentsScreenBoxMessageHandler INSTANCE = new RecentsScreenBoxMessageHandler();
    private static final String[] SUCCESS_MESSAGES = {Controller.ACTION_GET_FILE_INFO, Controller.ACTION_REMOVE_OFFLINE_ITEM, Controller.ACTION_MADE_FILE_AVAILABLE_OFFLINE, Controller.ACTION_ADD_OFFLINE_ITEM, Controller.ACTION_ADD_OFFLINE_ITEM_ALL_FINISHED, Controller.ACTION_DELETED_FILE};
    private static final String[] ALWAYS_HANDLE_MESSAGES = {BoxSwitchUserMessage.ACTION_SWITCHED_USER};
    public static final int $stable = 8;

    private RecentsScreenBoxMessageHandler() {
    }

    @Override // com.box.android.base.presentation.message.BoxMessageHandler
    public /* bridge */ /* synthetic */ RecentsReducer.Action handle(BoxMessage boxMessage) {
        return handle((BoxMessage<?>) boxMessage);
    }

    private final boolean shouldHandle(BoxMessage<?> message) {
        return (message.wasSuccessful() && ArraysKt.contains(SUCCESS_MESSAGES, message.getAction())) || ArraysKt.contains(ALWAYS_HANDLE_MESSAGES, message.getAction());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.box.android.base.presentation.message.BoxMessageHandler
    public RecentsReducer.Action handle(BoxMessage<?> message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (shouldHandle(message)) {
            return RecentsReducer.Action.LoadItems.INSTANCE;
        }
        return null;
    }
}

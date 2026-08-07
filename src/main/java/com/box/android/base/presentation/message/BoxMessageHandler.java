package com.box.android.base.presentation.message;

import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import kotlin.Metadata;

/* JADX INFO: compiled from: BoxMessageHandler.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001b\u0010\u0003\u001a\u0004\u0018\u00018\u00002\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/box/android/base/presentation/message/BoxMessageHandler;", "Action", "", "handle", "message", "Lcom/box/android/coreservices/modelcontroller/messages/BoxMessage;", "(Lcom/box/android/coreservices/modelcontroller/messages/BoxMessage;)Ljava/lang/Object;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface BoxMessageHandler<Action> {
    Action handle(BoxMessage<?> message);
}

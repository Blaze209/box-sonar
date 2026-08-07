package com.box.android.receiver;

import com.box.android.data.service.impl.LocalItemService;
import com.box.android.domain.identity.IUserContextManager;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import kotlin.Metadata;

/* JADX INFO: compiled from: BoxBootReceiverEntryPoint.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/receiver/BoxBootReceiverEntryPoint;", "", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "boxApiPrivate", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxApiPrivate;", "localItemService", "Lcom/box/android/data/service/impl/LocalItemService;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface BoxBootReceiverEntryPoint {
    BoxApiPrivate boxApiPrivate();

    LocalItemService localItemService();

    IUserContextManager userContextManager();
}

package com.box.android.data.mappers.annotation;

import com.box.android.data.api.models.UserMiniDTO;
import com.box.android.domain.models.annotations.UserEventModel;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserEventMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/box/android/data/mappers/annotation/UserEventMapper;", "", "<init>", "()V", "toUserEvent", "Lcom/box/android/domain/models/annotations/UserEventModel;", "eventDate", "Ljava/util/Date;", "userMini", "Lcom/box/android/data/api/models/UserMiniDTO;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UserEventMapper {
    public static final UserEventMapper INSTANCE = new UserEventMapper();

    private UserEventMapper() {
    }

    public final UserEventModel toUserEvent(Date eventDate, UserMiniDTO userMini) {
        Intrinsics.checkNotNullParameter(eventDate, "eventDate");
        Intrinsics.checkNotNullParameter(userMini, "userMini");
        return new UserEventModel(userMini.getId(), userMini.getName(), userMini.getLogin(), eventDate);
    }
}

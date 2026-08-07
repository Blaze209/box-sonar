package com.box.android.utilities;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.box.android.base.presentation.BoxFragmentInterface;
import com.box.android.domain.models.preview.PreviewSource;
import kotlin.Metadata;

/* JADX INFO: compiled from: BoxFragmentToPreviewSourceMapper.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/utilities/BoxFragmentToPreviewSourceMapper;", "", "<init>", "()V", "map", "Lcom/box/android/domain/models/preview/PreviewSource;", TypedValues.TransitionType.S_FROM, "Lcom/box/android/base/presentation/BoxFragmentInterface;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxFragmentToPreviewSourceMapper {
    public static final int $stable = 0;
    public static final BoxFragmentToPreviewSourceMapper INSTANCE = new BoxFragmentToPreviewSourceMapper();

    private BoxFragmentToPreviewSourceMapper() {
    }

    public final PreviewSource map(BoxFragmentInterface from) {
        Integer numValueOf = from != null ? Integer.valueOf(from.getType()) : null;
        if (numValueOf != null && numValueOf.intValue() == 22) {
            return PreviewSource.MyTasks.INSTANCE;
        }
        if (numValueOf != null && numValueOf.intValue() == 23) {
            return PreviewSource.SentTasks.INSTANCE;
        }
        if (numValueOf != null && numValueOf.intValue() == 6) {
            return PreviewSource.Notification.INSTANCE;
        }
        return (numValueOf != null && numValueOf.intValue() == 4) ? PreviewSource.Search.INSTANCE : PreviewSource.Unknown.INSTANCE;
    }
}

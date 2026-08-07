package com.box.android.utilities.inbox;

import com.box.android.R;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.models.inboxnotifications.ImageSourceModel;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: InboxSubIconMapper.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0007¨\u0006\u000f"}, d2 = {"Lcom/box/android/utilities/inbox/InboxSubIconMapper;", "", "<init>", "()V", "resolveIconSource", "", "imageSource", "Lcom/box/android/domain/models/inboxnotifications/ImageSourceModel;", "isDarkTheme", "", "getDrawableResourceIdByName", "iconName", "", "transformIconName", "getDefaultIconResourceId", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InboxSubIconMapper {
    public static final int $stable = 0;
    public static final InboxSubIconMapper INSTANCE = new InboxSubIconMapper();

    public final int getDefaultIconResourceId() {
        return R.drawable.ic_file_default;
    }

    private InboxSubIconMapper() {
    }

    public static /* synthetic */ int resolveIconSource$default(InboxSubIconMapper inboxSubIconMapper, ImageSourceModel imageSourceModel, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return inboxSubIconMapper.resolveIconSource(imageSourceModel, z);
    }

    public final int resolveIconSource(ImageSourceModel imageSource, boolean isDarkTheme) {
        int drawableResourceIdByName;
        Intrinsics.checkNotNullParameter(imageSource, "imageSource");
        if (isDarkTheme) {
            String nameDark = imageSource.getNameDark();
            if (nameDark == null) {
                nameDark = imageSource.getName();
            }
            drawableResourceIdByName = getDrawableResourceIdByName(nameDark);
        } else {
            drawableResourceIdByName = getDrawableResourceIdByName(imageSource.getName());
        }
        return drawableResourceIdByName != 0 ? drawableResourceIdByName : getDefaultIconResourceId();
    }

    public final int getDrawableResourceIdByName(String iconName) {
        Intrinsics.checkNotNullParameter(iconName, "iconName");
        return CommonBoxUtil.getDrawableResIdByName(transformIconName(iconName));
    }

    private final String transformIconName(String iconName) {
        String lowerCase = StringsKt.replace$default(iconName, "/", "_", false, 4, (Object) null).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return "icon_fill_" + lowerCase;
    }
}

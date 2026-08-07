package com.box.android.browse.cpl.helpers;

import com.box.android.browse.R;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.models.item.RecentItemModel;
import com.box.android.domain.usecases.InteractionType;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: RecentItemsHelper.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/browse/cpl/helpers/RecentItemsHelper;", "", "<init>", "()V", "getRecentItemDescription", "", "itemModel", "Lcom/box/android/domain/models/item/RecentItemModel;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecentItemsHelper {
    public static final int $stable = 0;
    public static final RecentItemsHelper INSTANCE = new RecentItemsHelper();

    /* JADX INFO: compiled from: RecentItemsHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InteractionType.values().length];
            try {
                iArr[InteractionType.PREVIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InteractionType.UPLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InteractionType.COMMENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[InteractionType.OPEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[InteractionType.MODIFY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private RecentItemsHelper() {
    }

    public final String getRecentItemDescription(RecentItemModel itemModel) {
        int i;
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        if (itemModel.getInteractedAt() == null) {
            return "";
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[itemModel.getInteractionType().ordinal()];
        if (i2 == 1) {
            i = R.string.recents_previewed;
        } else if (i2 == 2) {
            i = R.string.recents_uploaded;
        } else if (i2 == 3) {
            i = R.string.recents_commented;
        } else if (i2 == 4) {
            i = R.string.recents_opened;
        } else {
            if (i2 != 5) {
                throw new NoWhenBranchMatchedException();
            }
            i = R.string.recents_modified;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String strLS = CommonBoxUtil.LS(i);
        DateFormat dateInstance = DateFormat.getDateInstance(2);
        Date interactedAt = itemModel.getInteractedAt();
        Intrinsics.checkNotNull(interactedAt);
        String str = String.format(strLS, Arrays.copyOf(new Object[]{dateInstance.format(interactedAt)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }
}

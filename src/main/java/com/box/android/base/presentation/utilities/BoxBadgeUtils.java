package com.box.android.base.presentation.utilities;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.box.android.base.R;
import com.google.android.material.badge.BadgeDrawable;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxBadgeUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tH\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/base/presentation/utilities/BoxBadgeUtils;", "", "<init>", "()V", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/google/android/material/badge/BadgeDrawable;", "context", "Landroid/content/Context;", "verticalOffset", "", "badgeGravity", "maxCharacterCount", "attachBadge", "", "badgeDrawable", "anchor", "Landroid/view/View;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxBadgeUtils {
    public static final int $stable = 0;
    public static final BoxBadgeUtils INSTANCE = new BoxBadgeUtils();

    private BoxBadgeUtils() {
    }

    public static /* synthetic */ BadgeDrawable create$default(Context context, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = R.dimen.badge_vertical_offset;
        }
        if ((i4 & 4) != 0) {
            i2 = 8388659;
        }
        if ((i4 & 8) != 0) {
            i3 = 2;
        }
        return create(context, i, i2, i3);
    }

    @JvmStatic
    public static final BadgeDrawable create(Context context, int verticalOffset, int badgeGravity, int maxCharacterCount) {
        Intrinsics.checkNotNullParameter(context, "context");
        BadgeDrawable badgeDrawableCreate = BadgeDrawable.create(context);
        Intrinsics.checkNotNullExpressionValue(badgeDrawableCreate, "create(...)");
        badgeDrawableCreate.setBadgeGravity(badgeGravity);
        badgeDrawableCreate.setVerticalOffset((int) context.getResources().getDimension(verticalOffset));
        badgeDrawableCreate.setBackgroundColor(ContextCompat.getColor(context, R.color.box_watermelon_red_110));
        badgeDrawableCreate.setMaxCharacterCount(maxCharacterCount);
        badgeDrawableCreate.setBadgeTextColor(ContextCompat.getColor(context, R.color.white));
        return badgeDrawableCreate;
    }

    @JvmStatic
    public static final void attachBadge(BadgeDrawable badgeDrawable, View anchor) {
        Intrinsics.checkNotNullParameter(badgeDrawable, "badgeDrawable");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (badgeDrawable.hasNumber() && badgeDrawable.getNumber() > 0) {
            badgeDrawable.setHorizontalOffset((int) ((anchor.getWidth() / 2) + anchor.getResources().getDimension(R.dimen.badge_horizontal_offset)));
            badgeDrawable.updateBadgeCoordinates(anchor, (FrameLayout) null);
            anchor.setForeground(badgeDrawable);
            return;
        }
        anchor.setForeground(null);
    }
}

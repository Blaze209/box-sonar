package com.box.android.navigationmodernization.utils;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.core.widget.ImageViewCompat;
import com.box.android.R;
import com.box.android.common.utilities.CommonBoxUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActionModeDarkModeRecreator.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010\b\u001a\u00020\u0007H\u0002J \u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/box/android/navigationmodernization/utils/ActionModeDarkModeRecreator;", "", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "refreshActionModeColors", "", "doRefresh", "applyActionModeChildColors", "view", "Landroid/view/View;", "textColor", "", "tint", "Landroid/content/res/ColorStateList;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ActionModeDarkModeRecreator {
    public static final int $stable = 8;
    private final Activity activity;

    public ActionModeDarkModeRecreator(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
    }

    public final void refreshActionModeColors() {
        this.activity.getWindow().getDecorView().post(new Runnable() { // from class: com.box.android.navigationmodernization.utils.ActionModeDarkModeRecreator$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.doRefresh();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doRefresh() {
        ActionBarContextView actionBarContextView = (ActionBarContextView) this.activity.getWindow().getDecorView().findViewById(R.id.action_mode_bar);
        if (actionBarContextView == null) {
            return;
        }
        int colorFromAttribute = CommonBoxUtil.getColorFromAttribute(this.activity, R.attr.topBarActionModeText);
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(CommonBoxUtil.getColorFromAttribute(this.activity, R.attr.topBarActionModeControl));
        Intrinsics.checkNotNullExpressionValue(colorStateListValueOf, "valueOf(...)");
        actionBarContextView.setBackgroundColor(CommonBoxUtil.getColorFromAttribute(this.activity, R.attr.topBarActionModeBackground));
        applyActionModeChildColors(actionBarContextView, colorFromAttribute, colorStateListValueOf);
    }

    private final void applyActionModeChildColors(View view, int textColor, ColorStateList tint) {
        if (view instanceof TextView) {
            ((TextView) view).setTextColor(textColor);
        } else if (view instanceof ImageView) {
            ImageViewCompat.setImageTintList((ImageView) view, tint);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
                applyActionModeChildColors(childAt, textColor, tint);
            }
        }
    }
}

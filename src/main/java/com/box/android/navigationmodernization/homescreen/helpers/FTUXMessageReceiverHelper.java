package com.box.android.navigationmodernization.homescreen.helpers;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import com.box.android.base.presentation.fragments.BaseFTUX;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.androidsdk.content.utils.BoxLogUtils;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FTUXMessageReceiverHelper.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/box/android/navigationmodernization/homescreen/helpers/FTUXMessageReceiverHelper;", "", "ftuxFactory", "Lcom/box/android/base/presentation/fragments/BaseFTUX$FTUXFactory;", "<init>", "(Lcom/box/android/base/presentation/fragments/BaseFTUX$FTUXFactory;)V", "handleOnReceive", "", "intent", "Landroid/content/Intent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FTUXMessageReceiverHelper {
    public static final int $stable = 8;
    private final BaseFTUX.FTUXFactory ftuxFactory;

    @Inject
    public FTUXMessageReceiverHelper(BaseFTUX.FTUXFactory ftuxFactory) {
        Intrinsics.checkNotNullParameter(ftuxFactory, "ftuxFactory");
        this.ftuxFactory = ftuxFactory;
    }

    public final void handleOnReceive(Intent intent, AppCompatActivity activity) {
        String stringExtra;
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (Intrinsics.areEqual(intent.getAction(), BaseFTUX.EXTRA_ACTION_SHOW_FTUX)) {
            String stringExtra2 = intent.getStringExtra(BaseFTUX.EXTRA_FTUX_TYPE_NAME);
            try {
                Intrinsics.checkNotNull(stringExtra2);
                this.ftuxFactory.createFTUX(BaseFTUX.FTUXType.valueOf(stringExtra2)).show(activity);
            } catch (Exception e) {
                BoxLogUtils.logException("unknown ftux", "ftuxTypeName : " + stringExtra2, e);
                return;
            }
        }
        if (Intrinsics.areEqual(intent.getAction(), BaseFTUX.EXTRA_ACTION_POSITIVE_CLICK) && (stringExtra = intent.getStringExtra(BaseFTUX.EXTRA_FTUX_TYPE_NAME)) != null && Intrinsics.areEqual(stringExtra, "RATE")) {
            try {
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + activity.getPackageName())));
            } catch (ActivityNotFoundException unused) {
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(BoxCommonConstants.BOX_PLAY_STORE_URL)));
            }
        }
    }
}

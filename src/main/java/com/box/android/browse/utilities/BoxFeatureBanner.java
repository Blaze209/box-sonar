package com.box.android.browse.utilities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.Spanned;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.text.HtmlCompat;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxFeatureBanners.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0014\u0010\u0015\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u0012H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bj\u0002\b\u0010¨\u0006\u001d"}, d2 = {"Lcom/box/android/browse/utilities/BoxFeatureBanner;", "", "id", "", "featureIdentifier", "", "imageResourceId", "textResourceId", "<init>", "(Ljava/lang/String;IILjava/lang/String;II)V", "getId", "()I", "getFeatureIdentifier", "()Ljava/lang/String;", "getImageResourceId", "getTextResourceId", "CAPTURE", "fillText", "", "textView", "Landroid/widget/TextView;", "onPrimaryActionClicked", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "activity", "Landroid/app/Activity;", "createIntent", "sendAnalyticsEvent", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum BoxFeatureBanner {
    CAPTURE { // from class: com.box.android.browse.utilities.BoxFeatureBanner.CAPTURE
        @Override // com.box.android.browse.utilities.BoxFeatureBanner
        public void fillText(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "textView");
            Spanned spannedFromHtml = HtmlCompat.fromHtml(CommonBoxUtil.LS(getTextResourceId()), 0);
            Intrinsics.checkNotNullExpressionValue(spannedFromHtml, "fromHtml(...)");
            textView.setText(spannedFromHtml);
        }

        @Override // com.box.android.browse.utilities.BoxFeatureBanner
        public Intent createIntent() {
            Intent intent = new Intent("android.intent.action.VIEW", new Uri.Builder().scheme("boxapp").authority("capture").build());
            intent.setPackage("com.box.android");
            return intent;
        }
    };

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String featureIdentifier;
    private final int id;
    private final int imageResourceId;
    private final int textResourceId;

    /* synthetic */ BoxFeatureBanner(int i, String str, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, i2, i3);
    }

    public static EnumEntries<BoxFeatureBanner> getEntries() {
        return $ENTRIES;
    }

    public abstract void fillText(TextView textView);

    BoxFeatureBanner(int i, String str, int i2, int i3) {
        this.id = i;
        this.featureIdentifier = str;
        this.imageResourceId = i2;
        this.textResourceId = i3;
    }

    public final int getId() {
        return this.id;
    }

    public final String getFeatureIdentifier() {
        return this.featureIdentifier;
    }

    public final int getImageResourceId() {
        return this.imageResourceId;
    }

    public final int getTextResourceId() {
        return this.textResourceId;
    }

    public final void onPrimaryActionClicked(ActivityResultLauncher<Intent> launcher) {
        Intrinsics.checkNotNullParameter(launcher, "launcher");
        sendAnalyticsEvent();
        launcher.launch(createIntent());
    }

    public final void onPrimaryActionClicked(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        sendAnalyticsEvent();
        activity.startActivity(createIntent());
    }

    public Intent createIntent() {
        return new Intent();
    }

    private final void sendAnalyticsEvent() {
        BoxAmplitudeAnalytics.createFeatureBannerEventBuilder().setFeature(this.featureIdentifier).setBannerId(this.id).logEvent(BoxAnalyticsParams.EVENT_PRODUCT_BANNER_TAPPED);
    }
}

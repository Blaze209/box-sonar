package com.box.android.utilities;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import androidx.core.net.MailTo;
import com.box.android.R;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import dagger.hilt.android.qualifiers.ApplicationContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EmailChooserHelper.kt */
/* JADX INFO: loaded from: classes13.dex */
@Singleton
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0002J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000e2\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/box/android/utilities/EmailChooserHelper;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "launchEmailOnlyChooser", "", "emailIntent", "Landroid/content/Intent;", "chooserTitle", "", "launchUnfilteredChooser", "getEmailClientPackages", "", "queryEmailActivities", "Landroid/content/pm/ResolveInfo;", "Companion", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EmailChooserHelper {
    private static final String TAG = "EmailChooserHelper";
    private final Context context;
    public static final int $stable = 8;

    @Inject
    public EmailChooserHelper(@ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public static /* synthetic */ void launchEmailOnlyChooser$default(EmailChooserHelper emailChooserHelper, Intent intent, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = CommonBoxUtil.LS(R.string.Send_with);
        }
        emailChooserHelper.launchEmailOnlyChooser(intent, str);
    }

    public final void launchEmailOnlyChooser(Intent emailIntent, String chooserTitle) {
        Intrinsics.checkNotNullParameter(emailIntent, "emailIntent");
        Intrinsics.checkNotNullParameter(chooserTitle, "chooserTitle");
        List<String> emailClientPackages = getEmailClientPackages();
        if (emailClientPackages.isEmpty()) {
            launchUnfilteredChooser(emailIntent, chooserTitle);
            return;
        }
        List<String> list = emailClientPackages;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (String str : list) {
            Intent intent = new Intent(emailIntent);
            intent.setPackage(str);
            arrayList.add(intent);
        }
        ArrayList arrayList2 = arrayList;
        Intent intentCreateChooser = Intent.createChooser((Intent) CollectionsKt.first((List) arrayList2), chooserTitle);
        if (arrayList2.size() > 1) {
            intentCreateChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) CollectionsKt.drop(arrayList2, 1).toArray(new Intent[0]));
        }
        intentCreateChooser.setFlags(intentCreateChooser.getFlags() | 268435456);
        try {
            this.context.startActivity(intentCreateChooser);
        } catch (ActivityNotFoundException e) {
            BoxLogUtils.w(TAG, "Failed to launch filtered email chooser, falling back to unfiltered", e);
            launchUnfilteredChooser(emailIntent, chooserTitle);
        }
    }

    private final void launchUnfilteredChooser(Intent emailIntent, String chooserTitle) {
        Intent intentCreateChooser = Intent.createChooser(emailIntent, chooserTitle);
        intentCreateChooser.setFlags(intentCreateChooser.getFlags() | 268435456);
        try {
            this.context.startActivity(intentCreateChooser);
        } catch (ActivityNotFoundException e) {
            BoxLogUtils.e(TAG, "No app available to handle email intent", e);
        }
    }

    private final List<String> getEmailClientPackages() {
        List<ResolveInfo> listQueryEmailActivities = queryEmailActivities(new Intent("android.intent.action.SENDTO", Uri.parse(MailTo.MAILTO_SCHEME)));
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listQueryEmailActivities, 10));
        Iterator<T> it = listQueryEmailActivities.iterator();
        while (it.hasNext()) {
            arrayList.add(((ResolveInfo) it.next()).activityInfo.packageName);
        }
        return CollectionsKt.distinct(arrayList);
    }

    private final List<ResolveInfo> queryEmailActivities(Intent emailIntent) {
        if (Build.VERSION.SDK_INT >= 33) {
            List<ResolveInfo> listQueryIntentActivities = MAMPackageManagement.queryIntentActivities(this.context.getPackageManager(), emailIntent, PackageManager.ResolveInfoFlags.of(65536L));
            Intrinsics.checkNotNull(listQueryIntentActivities);
            return listQueryIntentActivities;
        }
        List<ResolveInfo> listQueryIntentActivities2 = MAMPackageManagement.queryIntentActivities(this.context.getPackageManager(), emailIntent, 65536);
        Intrinsics.checkNotNull(listQueryIntentActivities2);
        return listQueryIntentActivities2;
    }
}

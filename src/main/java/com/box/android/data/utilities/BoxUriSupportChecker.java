package com.box.android.data.utilities;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.box.android.domain.utils.IBoxUriSupportChecker;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxUriSupportChecker.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/box/android/data/utilities/BoxUriSupportChecker;", "Lcom/box/android/domain/utils/IBoxUriSupportChecker;", "appContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "isLinkSupportedByBoxApp", "", "uri", "Landroid/net/Uri;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxUriSupportChecker implements IBoxUriSupportChecker {
    private final Context appContext;

    @Inject
    public BoxUriSupportChecker(Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.appContext = appContext;
    }

    @Override // com.box.android.domain.utils.IBoxUriSupportChecker
    public boolean isLinkSupportedByBoxApp(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            intent.setPackage(this.appContext.getPackageName());
            List<ResolveInfo> listQueryIntentActivities = MAMPackageManagement.queryIntentActivities(this.appContext.getPackageManager(), intent, 65536);
            Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "queryIntentActivities(...)");
            return !listQueryIntentActivities.isEmpty();
        } catch (Exception unused) {
            return false;
        }
    }
}

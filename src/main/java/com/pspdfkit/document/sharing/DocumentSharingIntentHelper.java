package com.pspdfkit.document.sharing;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.g60;
import com.pspdfkit.internal.m0;
import com.pspdfkit.internal.q10;
import com.pspdfkit.internal.uw;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Supplier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DocumentSharingIntentHelper {
    private static final String DEFAULT_MIME_TYPE = "application/octet-stream";
    public static final String MIME_TYPE_PDF = "application/pdf";
    private static final String MIME_TYPE_PLAIN_TEXT = "text/plain";
    static PackageManagerAccessor packageManagerAccessor = new PackageManagerAccessor();

    /* JADX INFO: renamed from: com.pspdfkit.document.sharing.DocumentSharingIntentHelper$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$pspdfkit$document$sharing$ShareAction;

        static {
            int[] iArr = new int[ShareAction.values().length];
            $SwitchMap$com$pspdfkit$document$sharing$ShareAction = iArr;
            try {
                iArr[ShareAction.SEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$pspdfkit$document$sharing$ShareAction[ShareAction.VIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class PackageManagerAccessor {
        public PackageManager getPackageManager(Context context) {
            return context.getApplicationContext().getPackageManager();
        }
    }

    private static String getMimeTypeForUri(Uri uri) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(uri.toString());
        String mimeTypeFromExtension = fileExtensionFromUrl != null ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl) : null;
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
    }

    private static Intent getSendActionIntent(Uri uri) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", uri);
        intent.setFlags(1);
        intent.setTypeAndNormalize(getMimeTypeForUri(uri));
        return intent;
    }

    public static Intent getShareIntent(Context context, Uri uri, ShareAction shareAction) {
        uw.a(context, "context", null);
        uw.a(shareAction, "shareAction", null);
        if (!uri.getAuthority().equals(DocumentSharingProvider.getDocumentProviderAuthority(context))) {
            throw new IllegalArgumentException("Sharing uri must have authority " + DocumentSharingProvider.getDocumentProviderAuthority(context));
        }
        int i = AnonymousClass1.$SwitchMap$com$pspdfkit$document$sharing$ShareAction[shareAction.ordinal()];
        if (i == 1) {
            return getSendActionIntent(uri);
        }
        if (i == 2) {
            return getViewActionIntent(uri);
        }
        throw new IllegalArgumentException("Unrecognized share action: " + shareAction);
    }

    public static List<Intent> getShareIntents(Context context, Uri uri, ShareAction... shareActionArr) {
        uw.a(context, "context", null);
        uw.a(uri, "shareUri", null);
        ArrayList arrayList = new ArrayList();
        for (ShareAction shareAction : shareActionArr) {
            Intent shareIntent = getShareIntent(context, uri, shareAction);
            if (shareIntent != null) {
                arrayList.addAll(queryIntentActivities(context, shareIntent));
            }
        }
        return arrayList;
    }

    public static Observable<List<Intent>> getShareIntentsAsync(final Context context, final Uri uri, final ShareAction shareAction) {
        g60 g60VarC;
        uw.a(context, "context", null);
        uw.a(uri, "shareUri", null);
        uw.a(shareAction, "shareAction", null);
        Observable observableDefer = Observable.defer(new Supplier() { // from class: com.pspdfkit.document.sharing.DocumentSharingIntentHelper$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Supplier
            public final Object get() {
                return Observable.just(DocumentSharingIntentHelper.getShareIntents(context, uri, shareAction));
            }
        });
        synchronized (ar.class) {
            g60VarC = q10.c();
        }
        return observableDefer.subscribeOn(((m0) g60VarC).a());
    }

    public static ShareTarget getShareTarget(Context context, ShareAction shareAction, String str, String str2) {
        uw.a(context, "context", null);
        uw.a(shareAction, "shareAction", null);
        uw.a(str, "targetPackageName", null);
        Intent shareIntent = getShareIntent(context, shareAction, str2);
        if (shareIntent == null) {
            return null;
        }
        shareIntent.setPackage(str);
        List<ShareTarget> listQueryShareTargets = queryShareTargets(context, shareIntent);
        if (listQueryShareTargets.size() == 1) {
            return listQueryShareTargets.get(0);
        }
        return null;
    }

    public static List<ShareTarget> getShareTargets(Context context, List<Intent> list) {
        uw.a(context, "context", null);
        uw.a(list, "intents", null);
        ArrayList arrayList = new ArrayList();
        Iterator<Intent> it = list.iterator();
        while (it.hasNext()) {
            arrayList.addAll(queryShareTargets(context, it.next()));
        }
        return arrayList;
    }

    public static Observable<List<ShareTarget>> getShareTargetsAsync(final Context context, final List<Intent> list) {
        g60 g60VarC;
        uw.a(context, "context", null);
        uw.a(list, "intents", null);
        Observable observableDefer = Observable.defer(new Supplier() { // from class: com.pspdfkit.document.sharing.DocumentSharingIntentHelper$$ExternalSyntheticLambda1
            @Override // io.reactivex.rxjava3.functions.Supplier
            public final Object get() {
                return Observable.just(DocumentSharingIntentHelper.getShareTargets(context, list));
            }
        });
        synchronized (ar.class) {
            g60VarC = q10.c();
        }
        return observableDefer.subscribeOn(((m0) g60VarC).a());
    }

    public static Intent getShareTextIntent(String str) {
        uw.a(str, "text", null);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.setType("text/plain");
        return intent;
    }

    private static Intent getViewActionIntent(Uri uri) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setFlags(1);
        intent.setDataAndTypeAndNormalize(uri, getMimeTypeForUri(uri));
        return intent;
    }

    private static List<Intent> queryIntentActivities(Context context, Intent intent) {
        ArrayList arrayList = new ArrayList();
        List<ResolveInfo> listQueryIntentActivities = MAMPackageManagement.queryIntentActivities(packageManagerAccessor.getPackageManager(context), intent, 0);
        String packageName = context.getPackageName();
        Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
        while (it.hasNext()) {
            String str = it.next().activityInfo.packageName;
            if (!packageName.equals(str)) {
                Intent intent2 = new Intent(intent);
                intent2.setPackage(str);
                arrayList.add(intent2);
            }
        }
        return arrayList;
    }

    private static List<ShareTarget> queryShareTargets(Context context, Intent intent) {
        Drawable drawableLoadIcon;
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = packageManagerAccessor.getPackageManager(context);
        List<ResolveInfo> listQueryIntentActivities = MAMPackageManagement.queryIntentActivities(packageManager, intent, 0);
        String packageName = context.getPackageName();
        for (ResolveInfo resolveInfo : listQueryIntentActivities) {
            String str = resolveInfo.activityInfo.packageName;
            if (intent.getPackage() != null || !packageName.equals(str)) {
                CharSequence charSequenceLoadLabel = resolveInfo.loadLabel(packageManager);
                if (charSequenceLoadLabel != null && (drawableLoadIcon = resolveInfo.loadIcon(packageManager)) != null) {
                    arrayList.add(new ShareTarget(str, charSequenceLoadLabel.toString(), drawableLoadIcon, "android.intent.action.VIEW".equals(intent.getAction()) ? ShareAction.VIEW : ShareAction.SEND));
                }
            }
        }
        return arrayList;
    }

    public static void showShareTargetDetails(Context context, ShareTarget shareTarget) {
        context.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + shareTarget.getPackageName())));
    }

    public static ShareTarget getShareTarget(Context context, ShareAction shareAction, String str) {
        return getShareTarget(context, shareAction, str, null);
    }

    public static Intent getShareIntent(Context context, Uri uri, ShareTarget shareTarget) {
        uw.a(context, "context", null);
        uw.a(uri, "shareUri", null);
        Intent shareIntent = getShareIntent(context, uri, shareTarget.getShareAction());
        if (shareIntent != null) {
            shareIntent.setPackage(shareTarget.getPackageName());
        }
        return shareIntent;
    }

    public static Intent getShareIntent(Context context, ShareAction shareAction, String str) {
        Uri.Builder builderAuthority = new Uri.Builder().authority(DocumentSharingProvider.getDocumentProviderAuthority(context));
        if (str == null) {
            str = "custom.pdf";
        }
        return getShareIntent(context, builderAuthority.appendPath(str).build(), shareAction);
    }
}

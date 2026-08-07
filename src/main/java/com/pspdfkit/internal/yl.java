package com.pspdfkit.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.media3.common.MimeTypes;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.pspdfkit.document.sharing.DocumentSharingProvider;
import com.pspdfkit.utils.BundleExtensions;
import com.pspdfkit.utils.PackageManagerExtensions;
import com.pspdfkit.utils.PdfLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\b"}, d2 = {"Lcom/pspdfkit/internal/yl;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "c", "d", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class yl extends Fragment {
    public static final /* synthetic */ int k = 0;
    public boolean a;
    public c b;
    public a c;
    public Intent d;
    public Intent e;
    public String f;
    public Uri g;
    public final am h;
    public ActivityResultLauncher<String> i;
    public ActivityResultLauncher<Intent> j;

    public static final class a {
        public final int a;
        public final Uri b;

        public a(int i, Uri uri) {
            this.a = i;
            this.b = uri;
        }
    }

    public static final class b {
        @JvmStatic
        public static Intent a(Context context, CharSequence charSequence, ArrayList arrayList) {
            Object next;
            String str;
            context.getClass();
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("image/*");
            intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{MimeTypes.IMAGE_JPEG, MimeTypes.IMAGE_PNG});
            PackageManager packageManager = context.getPackageManager();
            packageManager.getClass();
            List<ResolveInfo> listQueryIntentActivities = PackageManagerExtensions.queryIntentActivities(packageManager, intent);
            Iterator<T> it = listQueryIntentActivities.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                str = ((ResolveInfo) next).activityInfo.packageName;
                str.getClass();
            } while (!StringsKt.contains$default((CharSequence) str, (CharSequence) "providers.media", false, 2, (Object) null));
            if (next == null) {
                arrayList.add(intent);
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listQueryIntentActivities, 10));
            for (ResolveInfo resolveInfo : listQueryIntentActivities) {
                Intent intent2 = new Intent(intent);
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                intent2.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
                intent2.setPackage(resolveInfo.activityInfo.packageName);
                arrayList2.add(intent2);
            }
            CollectionsKt.addAll(arrayList, arrayList2);
            if (arrayList.isEmpty()) {
                return null;
            }
            if (arrayList.size() == 1) {
                Intent intent3 = (Intent) arrayList.get(0);
                intent3.setFlags(67);
                return intent3;
            }
            Intent intentCreateChooser = Intent.createChooser((Intent) arrayList.remove(0), charSequence);
            intentCreateChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Intent[0]));
            intentCreateChooser.setFlags(67);
            return intentCreateChooser;
        }
    }

    public interface c {
        void onImagePicked(Uri uri);

        void onImagePickerCancelled();

        void onImagePickerUnknownError();
    }

    public static final class d extends ActivityResultContract<Intent, a> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Intent createIntent(Context context, Intent intent) {
            Intent intent2 = intent;
            context.getClass();
            intent2.getClass();
            return intent2;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final a parseResult(int i, Intent intent) {
            return new a(i, intent != null ? intent.getData() : null);
        }
    }

    public yl() {
        j0 j0Var;
        synchronized (ar.class) {
            if (ar.a == null) {
                Context context = n5.a;
                if (context == null) {
                    throw new IllegalStateException("The application context should not be null. Please call fun setApplicationContext(context: Context) first");
                }
                ar.a = new j0(context);
            }
            j0Var = ar.a;
        }
        j0Var.getClass();
        this.h = j0Var;
    }

    public static final void a(yl ylVar, Boolean bool) {
        Intent intent;
        bool.getClass();
        ylVar.a = false;
        if (bool.booleanValue() && (intent = ylVar.d) != null) {
            ylVar.a(intent, (Intent) null);
            ylVar.d = null;
            ylVar.e = null;
        } else {
            if (ylVar.e != null) {
                if (ylVar.b != null) {
                    ylVar.shouldShowRequestPermissionRationale("android.permission.CAMERA");
                }
                ylVar.a((Intent) null, ylVar.e);
                ylVar.d = null;
                ylVar.e = null;
                return;
            }
            ylVar.d = null;
            ylVar.e = null;
            ylVar.c = null;
            FragmentManager parentFragmentManager = ylVar.getParentFragmentManager();
            parentFragmentManager.getClass();
            fi.a(parentFragmentManager, (Fragment) ylVar, false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DocumentSharingProvider.checkProviderConfiguration(requireContext(), "capturing images from camera");
        if (bundle != null) {
            this.d = (Intent) BundleExtensions.getSupportParcelable(bundle, "PENDING_INTENT_FOR_RESULT", Intent.class);
            this.e = (Intent) BundleExtensions.getSupportParcelable(bundle, "PENDING_INTENT_NO_CAMERA_FOR_RESULT", Intent.class);
            this.g = (Uri) BundleExtensions.getSupportParcelable(bundle, "TEMP_IMAGE_URI", Uri.class);
        }
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: com.pspdfkit.internal.yl$$ExternalSyntheticLambda0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                yl.a(this.f$0, (Boolean) obj);
            }
        });
        activityResultLauncherRegisterForActivityResult.getClass();
        this.i = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new d(), new ActivityResultCallback() { // from class: com.pspdfkit.internal.yl$$ExternalSyntheticLambda1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                yl.a(this.f$0, (yl.a) obj);
            }
        });
        activityResultLauncherRegisterForActivityResult2.getClass();
        this.j = activityResultLauncherRegisterForActivityResult2;
        if (!(this.d == null && this.e == null) && a()) {
            a(this.d, this.e);
            this.d = null;
            this.e = null;
            this.a = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.getClass();
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("TEMP_IMAGE_URI", this.g);
        bundle.putParcelable("PENDING_INTENT_FOR_RESULT", this.d);
    }

    public static final void a(yl ylVar, a aVar) {
        aVar.getClass();
        ylVar.c = aVar;
        ylVar.a(aVar);
    }

    public final void a(ArrayList arrayList) {
        s8 s8VarA = ((j0) this.h).a(new Function0() { // from class: com.pspdfkit.internal.yl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return yl.a(this.f$0);
            }
        });
        if (s8VarA instanceof s8.c) {
            s8.c cVar = (s8.c) s8VarA;
            this.g = cVar.b;
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            intent.setFlags(cVar.a);
            intent.putExtra("output", cVar.b);
            arrayList.add(intent);
            return;
        }
        if (Intrinsics.areEqual(s8VarA, s8.a.a)) {
            return;
        }
        if (Intrinsics.areEqual(s8VarA, s8.b.a)) {
            PdfLog.w("Nutri.IChooserIPickFrag", "The device doesn't have a camera.", new Object[0]);
            return;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Uri a(yl ylVar) {
        Context contextRequireContext = ylVar.requireContext();
        contextRequireContext.getClass();
        return a(contextRequireContext);
    }

    public final void a(Intent intent, Intent intent2) {
        DocumentSharingProvider.checkProviderConfiguration(requireContext(), "capturing images from camera");
        if (intent == null && intent2 == null) {
            return;
        }
        ActivityResultLauncher<Intent> activityResultLauncher = null;
        if (isAdded() && !((j0) this.h).a() && intent2 != null) {
            ActivityResultLauncher<Intent> activityResultLauncher2 = this.j;
            if (activityResultLauncher2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imagePickerLauncher");
            } else {
                activityResultLauncher = activityResultLauncher2;
            }
            activityResultLauncher.launch(intent2);
            return;
        }
        if (isAdded() && a() && intent != null) {
            ActivityResultLauncher<Intent> activityResultLauncher3 = this.j;
            if (activityResultLauncher3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imagePickerLauncher");
            } else {
                activityResultLauncher = activityResultLauncher3;
            }
            activityResultLauncher.launch(intent);
            return;
        }
        this.d = intent;
        this.e = intent2;
    }

    public final void a(a aVar) {
        c cVar = this.b;
        if (cVar != null) {
            int i = aVar.a;
            Uri uri = aVar.b;
            if (i == -1) {
                Uri uri2 = this.g;
                if (uri != null) {
                    cVar.onImagePicked(uri);
                } else if (uri2 != null) {
                    cVar.onImagePicked(uri2);
                    this.g = null;
                } else {
                    cVar.onImagePickerUnknownError();
                    Context contextRequireContext = requireContext();
                    contextRequireContext.getClass();
                    if (uri2 != null) {
                        DocumentSharingProvider.deleteFile(contextRequireContext, uri2);
                    }
                }
            } else if (i != 0) {
                cVar.onImagePickerUnknownError();
                Context contextRequireContext2 = requireContext();
                contextRequireContext2.getClass();
                Uri uri3 = this.g;
                if (uri3 != null) {
                    DocumentSharingProvider.deleteFile(contextRequireContext2, uri3);
                }
            } else {
                cVar.onImagePickerCancelled();
                Context contextRequireContext3 = requireContext();
                contextRequireContext3.getClass();
                Uri uri4 = this.g;
                if (uri4 != null) {
                    DocumentSharingProvider.deleteFile(contextRequireContext3, uri4);
                }
            }
            this.c = null;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            parentFragmentManager.getClass();
            fi.a(parentFragmentManager, (Fragment) this, false);
        }
    }

    public static Uri a(Context context) {
        return DocumentSharingProvider.createTemporaryFile(context, "Signature_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date()), ".jpg");
    }

    public final boolean a() {
        try {
            PackageManager packageManager = requireContext().getPackageManager();
            packageManager.getClass();
            String packageName = requireContext().getPackageName();
            packageName.getClass();
            String[] strArr = PackageManagerExtensions.getSupportPackageInfo(packageManager, packageName, 4096).requestedPermissions;
            if (strArr != null) {
                for (String str : strArr) {
                    if (Intrinsics.areEqual(str, "android.permission.CAMERA")) {
                        if (ContextCompat.checkSelfPermission(requireContext(), "android.permission.CAMERA") != -1 || this.a) {
                            break;
                            break;
                        }
                        this.a = true;
                        ActivityResultLauncher<String> activityResultLauncher = this.i;
                        if (activityResultLauncher == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("requiredPermissionsCheckLauncher");
                            activityResultLauncher = null;
                        }
                        activityResultLauncher.launch("android.permission.CAMERA");
                        return false;
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return true;
    }
}

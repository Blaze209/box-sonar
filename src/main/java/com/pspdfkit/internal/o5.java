package com.pspdfkit.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.util.TypedValue;
import android.widget.Toast;
import com.microsoft.intune.mam.client.app.MAMAlertDialogBuilder;
import com.microsoft.intune.mam.client.widget.MAMTextView;
import com.pspdfkit.R;
import com.pspdfkit.document.providers.AssetDataProvider;
import com.pspdfkit.exceptions.NutrientInitializationFailedException;
import com.pspdfkit.internal.document.DataProviderShim;
import com.pspdfkit.internal.jni.NativeAlertOptions;
import com.pspdfkit.internal.jni.NativeApplicationService;
import com.pspdfkit.internal.jni.NativeAssetDescriptor;
import com.pspdfkit.internal.jni.NativeDataProvider;
import com.pspdfkit.internal.jni.NativeOcrLanguage;
import com.pspdfkit.utils.PdfLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes3.dex */
public final class o5 extends NativeApplicationService {
    public final Context a;
    public final Context b;
    public final String c;
    public final String d;
    public final ArrayList e;
    public final HashMap f;

    @DebugMetadata(c = "com.pspdfkit.internal.core.ApplicationServiceImpl$showAlert$1", f = "ApplicationServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ o5 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ boolean e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, boolean z, o5 o5Var, String str2, boolean z2, Continuation<? super a> continuation) {
            super(2, continuation);
            this.a = str;
            this.b = z;
            this.c = o5Var;
            this.d = str2;
            this.e = z2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.a, this.b, this.c, this.d, this.e, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AlertDialog alertDialogCreate;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            try {
                WeakReference<Activity> weakReference = j.a;
                Activity activity = weakReference != null ? weakReference.get() : null;
                if (activity != null) {
                    MAMAlertDialogBuilder mAMAlertDialogBuilder = new MAMAlertDialogBuilder(activity);
                    mAMAlertDialogBuilder.setTitle(this.a);
                    boolean z = this.b;
                    String str = this.d;
                    if (z) {
                        alertDialogCreate = o5.a(mAMAlertDialogBuilder, activity, str);
                    } else {
                        boolean z2 = this.e;
                        mAMAlertDialogBuilder.setMessage(str);
                        if (z2) {
                            mAMAlertDialogBuilder.setNegativeButton("Dismiss", (DialogInterface.OnClickListener) null);
                        } else {
                            mAMAlertDialogBuilder.setCancelable(false);
                        }
                        alertDialogCreate = mAMAlertDialogBuilder.create();
                        alertDialogCreate.getClass();
                    }
                    alertDialogCreate.show();
                } else {
                    Toast.makeText(this.c.b, this.a + ": " + this.d, 1).show();
                }
            } catch (Exception e) {
                PdfLog.e("Nutri.AppServiceImpl", this.a + " " + this.d + e.getMessage(), new Object[0]);
            }
            return Unit.INSTANCE;
        }
    }

    public o5(Context context) {
        this.a = context;
        Context applicationContext = context.getApplicationContext();
        applicationContext.getClass();
        this.b = applicationContext;
        File file = new File(context.getCacheDir(), "nutrient");
        file.mkdirs();
        String absolutePath = file.getAbsolutePath();
        absolutePath.getClass();
        this.c = absolutePath;
        String absolutePath2 = context.getFilesDir().getAbsolutePath();
        absolutePath2.getClass();
        this.d = absolutePath2;
        ArrayList arrayList = new ArrayList();
        this.e = arrayList;
        HashMap map = new HashMap();
        map.put(NativeAssetDescriptor.PSPDFKIT_LOGO, "digital-signatures-watermark.pdf");
        map.put(NativeAssetDescriptor.NOTE_ICON_COMMENT, "note_comment.pdf");
        map.put(NativeAssetDescriptor.NOTE_ICON_RIGHT_ARROW, "note_rightarrow.pdf");
        map.put(NativeAssetDescriptor.NOTE_ICON_RIGHT_POINTER, "note_rightpointer.pdf");
        map.put(NativeAssetDescriptor.NOTE_ICON_CHECK, "note_check.pdf");
        map.put(NativeAssetDescriptor.NOTE_ICON_CIRCLE, "note_circle.pdf");
        map.put(NativeAssetDescriptor.NOTE_ICON_CROSS, "note_cross.pdf");
        map.put(NativeAssetDescriptor.NOTE_ICON_INSERT, "note_insert.pdf");
        map.put(NativeAssetDescriptor.NOTE_ICON_NEW_PARAGRAPH, "note_newparagraph.pdf");
        map.put(NativeAssetDescriptor.NOTE_ICON_NOTE, "note_note.pdf");
        map.put(NativeAssetDescriptor.NOTE_ICON_PARAGRAPH, "note_paragraph.pdf");
        map.put(NativeAssetDescriptor.NOTE_ICON_HELP, "note_help.pdf");
        map.put(NativeAssetDescriptor.NOTE_ICON_STAR, "note_star.pdf");
        map.put(NativeAssetDescriptor.NOTE_ICON_KEY, "note_key.pdf");
        this.f = map;
        j.a = new WeakReference<>(a80.a(context));
        arrayList.clear();
        String absolutePath3 = context.getCacheDir().getAbsolutePath();
        absolutePath3.getClass();
        arrayList.add(absolutePath3);
        String absolutePath4 = context.getFilesDir().getAbsolutePath();
        absolutePath4.getClass();
        arrayList.add(absolutePath4);
        String str = context.getApplicationInfo().dataDir;
        str.getClass();
        arrayList.add(str);
        File[] externalCacheDirs = context.getExternalCacheDirs();
        externalCacheDirs.getClass();
        for (File file2 : externalCacheDirs) {
            if (file2 != null) {
                ArrayList arrayList2 = this.e;
                String absolutePath5 = file2.getAbsolutePath();
                absolutePath5.getClass();
                arrayList2.add(absolutePath5);
            }
        }
        ArrayList arrayList3 = this.e;
        String absolutePath6 = Environment.getExternalStorageDirectory().getAbsolutePath();
        absolutePath6.getClass();
        arrayList3.add(absolutePath6);
    }

    public static AlertDialog a(AlertDialog.Builder builder, final Activity activity, String str) {
        int iApplyDimension = (int) TypedValue.applyDimension(1, 24, activity.getResources().getDisplayMetrics());
        MAMTextView mAMTextView = new MAMTextView(activity);
        mAMTextView.setText(str);
        mAMTextView.setMovementMethod(LinkMovementMethod.getInstance());
        Linkify.addLinks(mAMTextView, 1);
        mAMTextView.setPadding(iApplyDimension, iApplyDimension, iApplyDimension, iApplyDimension);
        builder.setView(mAMTextView).setNeutralButton("Contact Support", new DialogInterface.OnClickListener() { // from class: com.pspdfkit.internal.o5$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                o5.a(activity, dialogInterface, i);
            }
        }).setCancelable(false);
        AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.getClass();
        return alertDialogCreate;
    }

    @Override // com.pspdfkit.internal.jni.NativeApplicationService
    public final String appName() {
        return "Nutrient";
    }

    @Override // com.pspdfkit.internal.jni.NativeApplicationService
    public final String computerReadableVersion() {
        return "11.3.0";
    }

    @Override // com.pspdfkit.internal.jni.NativeApplicationService
    public final String databaseDirectory() {
        return this.d;
    }

    @Override // com.pspdfkit.internal.jni.NativeApplicationService
    public final NativeDataProvider getAsset(NativeAssetDescriptor nativeAssetDescriptor) {
        nativeAssetDescriptor.getClass();
        if (!this.f.containsKey(nativeAssetDescriptor)) {
            return null;
        }
        String str = (String) this.f.get(nativeAssetDescriptor);
        str.getClass();
        return new DataProviderShim(new AssetDataProvider(wg.b(str)));
    }

    @Override // com.pspdfkit.internal.jni.NativeApplicationService
    public final Float getMaxImageMemoryRatio() {
        float f;
        Resources resources = this.a.getResources();
        resources.getClass();
        int i = R.dimen.pspdf__max_image_memory_ratio;
        try {
            TypedValue typedValue = new TypedValue();
            resources.getValue(i, typedValue, true);
            f = typedValue.getFloat();
        } catch (Exception e) {
            String localizedMessage = e.getLocalizedMessage();
            if (localizedMessage != null) {
                PdfLog.e("Nutri.AppServiceImpl", localizedMessage, new Object[0]);
            }
            f = 0.0f;
        }
        if (f <= 0.0f || f > 1.0f) {
            return null;
        }
        PdfLog.i("Nutri.AppServiceImpl", "Max allowed image document memory set to " + f + "% of device memory", new Object[0]);
        return Float.valueOf(f);
    }

    @Override // com.pspdfkit.internal.jni.NativeApplicationService
    public final String getOcrTrainedDataPath(NativeOcrLanguage nativeOcrLanguage) {
        nativeOcrLanguage.getClass();
        try {
            String canonicalPath = new File(this.b.getFilesDir(), wg.b("ocr/trained-data")).getCanonicalPath();
            canonicalPath.getClass();
            return canonicalPath;
        } catch (IOException unused) {
            throw new NutrientInitializationFailedException("Unable to read trained data from assets.");
        }
    }

    @Override // com.pspdfkit.internal.jni.NativeApplicationService
    public final long getPhysicalMemory() {
        Object systemService = this.b.getSystemService("activity");
        systemService.getClass();
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    @Override // com.pspdfkit.internal.jni.NativeApplicationService
    public final String getPspdfkitLibraryPath() {
        return "";
    }

    @Override // com.pspdfkit.internal.jni.NativeApplicationService
    public final ArrayList<String> getSystemFontPaths() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("/system/fonts");
        return arrayList;
    }

    @Override // com.pspdfkit.internal.jni.NativeApplicationService
    public final String humanReadableVersion() {
        return "Nutrient for Android (11.3.0, 146948)";
    }

    @Override // com.pspdfkit.internal.jni.NativeApplicationService
    public final boolean isDevelopmentBuild() {
        return (this.b.getApplicationInfo().flags & 2) != 0;
    }

    @Override // com.pspdfkit.internal.jni.NativeApplicationService
    public final boolean isSimulator() {
        String str = Build.FINGERPRINT;
        str.getClass();
        return StringsKt.contains$default((CharSequence) str, (CharSequence) "generic", false, 2, (Object) null);
    }

    @Override // com.pspdfkit.internal.jni.NativeApplicationService
    public final String osName() {
        return "Android";
    }

    @Override // com.pspdfkit.internal.jni.NativeApplicationService
    public final String removeApplicationPath(String str) {
        String strSubstring;
        str.getClass();
        ArrayList arrayList = this.e;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            String str2 = (String) obj;
            if (StringsKt.startsWith$default(str, str2, false, 2, (Object) null) && str.length() > str2.length()) {
                strSubstring = str.substring(str2.length() + 1);
                PdfLog.d("Nutri.AppServiceImpl", "Remove path %s => %s.", str, strSubstring);
                return strSubstring;
            }
        }
        strSubstring = str;
        PdfLog.d("Nutri.AppServiceImpl", "Remove path %s => %s.", str, strSubstring);
        return strSubstring;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0037  */
    /* JADX WARN: Code duplicated, block: B:16:0x003b  */
    @Override // com.pspdfkit.internal.jni.NativeApplicationService
    public final void showAlert(String str, String str2, EnumSet<NativeAlertOptions> enumSet) {
        String str3;
        boolean z;
        String str4;
        str.getClass();
        str2.getClass();
        enumSet.getClass();
        if (!enumSet.contains(NativeAlertOptions.ONLY_ON_DEVELOPMENT) || isDevelopmentBuild()) {
            if (StringsKt.contains((CharSequence) str, (CharSequence) "licensing", true)) {
                str3 = str2;
                if (StringsKt.contains((CharSequence) str3, (CharSequence) "evaluation", true)) {
                    z = true;
                }
                if (z) {
                    str4 = "Your evaluation period has expired";
                } else {
                    str4 = str;
                }
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new a(str4, z, this, str3, !enumSet.contains(NativeAlertOptions.NOT_DISMISSABLE), null), 3, null);
            }
            str3 = str2;
            z = false;
            if (z) {
                str4 = "Your evaluation period has expired";
            } else {
                str4 = str;
            }
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new a(str4, z, this, str3, !enumSet.contains(NativeAlertOptions.NOT_DISMISSABLE), null), 3, null);
        }
    }

    @Override // com.pspdfkit.internal.jni.NativeApplicationService
    public final String temporaryDirectory() {
        return this.c;
    }

    public static final void a(Activity activity, DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("https://nutrient.io/support/request"));
        activity.startActivity(intent);
    }
}

package com.pspdfkit.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.fragment.app.Fragment;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.pspdfkit.document.sharing.DocumentSharingIntentHelper;
import java.io.File;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/pspdfkit/internal/mc;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class mc extends Fragment {
    public static final /* synthetic */ int g = 0;
    public boolean a;
    public String b;
    public Function1<? super Uri, Unit> c;
    public String d = "android.intent.action.OPEN_DOCUMENT";
    public final Uri e;
    public ActivityResultLauncher<String[]> f;

    public static final class a extends ActivityResultContract<String[], Uri> {
        public final String a;
        public final String b;
        public final Uri c;

        public a(String str, String str2, Uri uri) {
            str2.getClass();
            this.a = str;
            this.b = str2;
            this.c = uri;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Intent createIntent(Context context, String[] strArr) {
            String[] strArr2 = strArr;
            context.getClass();
            strArr2.getClass();
            Intent intent = new Intent(this.b);
            intent.addCategory("android.intent.category.OPENABLE");
            intent.putExtra("android.intent.extra.MIME_TYPES", strArr2);
            String str = this.a;
            if (str != null) {
                intent.putExtra("android.intent.extra.TITLE", wg.a(str));
            }
            intent.putExtra("android.provider.extra.INITIAL_URI", this.c);
            intent.setType(DocumentSharingIntentHelper.MIME_TYPE_PDF);
            return intent;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Uri parseResult(int i, Intent intent) {
            Uri data;
            if (intent == null || (data = intent.getData()) == null || i != -1) {
                return null;
            }
            return data;
        }
    }

    public mc() {
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        externalStoragePublicDirectory.getClass();
        this.e = Uri.fromFile(externalStoragePublicDirectory);
    }

    public static final void a(mc mcVar, Uri uri) {
        wg.a(mcVar.getContext(), false, Arrays.asList(uri));
        Function1<? super Uri, Unit> function1 = mcVar.c;
        if (function1 != null) {
            function1.invoke(uri);
        }
        if (!mcVar.isResumed()) {
            mcVar.a = true;
        } else if (mcVar.isAdded()) {
            mcVar.getParentFragmentManager().beginTransaction().remove(mcVar).commit();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityResultLauncher<String[]> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new a(this.b, this.d, this.e), new ActivityResultCallback() { // from class: com.pspdfkit.internal.mc$$ExternalSyntheticLambda0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                mc.a(this.f$0, (Uri) obj);
            }
        });
        activityResultLauncherRegisterForActivityResult.getClass();
        this.f = activityResultLauncherRegisterForActivityResult;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.a) {
            this.a = false;
            if (isAdded()) {
                getParentFragmentManager().beginTransaction().remove(this).commit();
            }
        }
    }
}

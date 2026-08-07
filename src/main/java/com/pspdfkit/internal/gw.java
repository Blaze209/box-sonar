package com.pspdfkit.internal;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import com.pspdfkit.R;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class gw extends Fragment {
    public final String[] a;
    public boolean b;
    public Function1<? super Boolean, Unit> c;
    public ActivityResultLauncher<String[]> d;
    public ActivityResultLauncher<Intent> e;
    public int f;
    public boolean g;

    public gw(String[] strArr) {
        this.a = strArr;
    }

    public static final void a(ActivityResult activityResult) {
        activityResult.getClass();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = bundle != null ? bundle.getBoolean("hasPendingRequest", false) : false;
        ActivityResultLauncher<String[]> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback() { // from class: com.pspdfkit.internal.gw$$ExternalSyntheticLambda0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                gw.a(this.f$0, (Map) obj);
            }
        });
        activityResultLauncherRegisterForActivityResult.getClass();
        this.d = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.pspdfkit.internal.gw$$ExternalSyntheticLambda1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                gw.a((ActivityResult) obj);
            }
        });
        activityResultLauncherRegisterForActivityResult2.getClass();
        this.e = activityResultLauncherRegisterForActivityResult2;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.g) {
            this.g = false;
            if (isAdded()) {
                getParentFragmentManager().beginTransaction().remove(this).commit();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.getClass();
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("hasPendingRequest", this.b);
    }

    public final void a(boolean z) {
        Function1<? super Boolean, Unit> function1 = this.c;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z));
        }
        if (!isResumed()) {
            this.g = true;
        } else if (isAdded()) {
            getParentFragmentManager().beginTransaction().remove(this).commit();
        }
    }

    public static final void a(gw gwVar, Map map) {
        map.getClass();
        String[] strArr = gwVar.a;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i < length) {
                String str = strArr[i];
                l0.a();
                str.getClass();
                if (!StringsKt.contains$default((CharSequence) str, (CharSequence) str, false, 2, (Object) null)) {
                    if (map.size() != gwVar.a.length) {
                        break;
                    }
                    if (!map.isEmpty()) {
                        Iterator it = map.entrySet().iterator();
                        do {
                            if (it.hasNext()) {
                            }
                        } while (((Boolean) ((Map.Entry) it.next()).getValue()).booleanValue());
                    }
                    gwVar.a(true);
                    return;
                }
                i++;
            } else {
                if (!map.isEmpty()) {
                    Iterator it2 = map.entrySet().iterator();
                    while (it2.hasNext()) {
                        if (((Boolean) ((Map.Entry) it2.next()).getValue()).booleanValue()) {
                            gwVar.a(true);
                            return;
                        }
                    }
                    break;
                }
                break;
            }
        }
        if (!gwVar.shouldShowRequestPermissionRationale((String) ArraysKt.first(gwVar.a))) {
            gwVar.a(gwVar.getContext());
        }
        gwVar.a(false);
    }

    public final void a(final Context context) {
        if (context == null) {
            return;
        }
        new AlertDialog.Builder(context).setMessage(context.getString(this.f)).setNegativeButton(context.getString(R.string.pspdf__cancel), new DialogInterface.OnClickListener() { // from class: com.pspdfkit.internal.gw$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                gw.a(dialogInterface, i);
            }
        }).setPositiveButton(context.getString(R.string.pspdf__open_settings), new DialogInterface.OnClickListener() { // from class: com.pspdfkit.internal.gw$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                gw.a(context, this, dialogInterface, i);
            }
        }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.pspdfkit.internal.gw$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                gw.a(this.f$0, dialogInterface);
            }
        }).setCancelable(true).show();
    }

    public static final void a(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }

    public static final void a(Context context, gw gwVar, DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        ActivityResultLauncher<Intent> activityResultLauncher = null;
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        ActivityResultLauncher<Intent> activityResultLauncher2 = gwVar.e;
        if (activityResultLauncher2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsMenuLauncher");
        } else {
            activityResultLauncher = activityResultLauncher2;
        }
        activityResultLauncher.launch(intent);
    }

    public static final void a(gw gwVar, DialogInterface dialogInterface) {
        gwVar.a(false);
    }
}

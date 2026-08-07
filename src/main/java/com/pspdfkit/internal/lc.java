package com.pspdfkit.internal;

import android.net.Uri;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.pspdfkit.document.editor.FilePicker;
import com.pspdfkit.document.sharing.DocumentSharingIntentHelper;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.subjects.MaybeSubject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class lc implements FilePicker {
    public final AppCompatActivity a;
    public final k0 b;
    public final String[] c;
    public MaybeSubject<Uri> d;

    public lc(AppCompatActivity appCompatActivity, k0 k0Var) {
        appCompatActivity.getClass();
        this.a = appCompatActivity;
        this.b = k0Var;
        this.c = new String[]{DocumentSharingIntentHelper.MIME_TYPE_PDF};
    }

    public static final Unit a(lc lcVar, Uri uri) {
        MaybeSubject<Uri> maybeSubject = lcVar.d;
        if (maybeSubject == null) {
            Intrinsics.throwUninitializedPropertyAccessException("maybeSubject");
            maybeSubject = null;
        }
        if (uri == null) {
            maybeSubject.onComplete();
        } else {
            maybeSubject.onSuccess(uri);
        }
        return Unit.INSTANCE;
    }

    @Override // com.pspdfkit.document.editor.FilePicker
    public final Maybe<Uri> getDestinationUri(String str, String str2) {
        str.getClass();
        if (!Intrinsics.areEqual(str, "android.intent.action.OPEN_DOCUMENT") && !Intrinsics.areEqual(str, "android.intent.action.CREATE_DOCUMENT")) {
            throw new IllegalArgumentException("Nutri.FilePicker: Unsupported intent, action may be equal to Intent.ACTION_OPEN_DOCUMENT or Intent.ACTION_CREATE_DOCUMENT.");
        }
        FragmentManager fragmentManagerB = a80.b(this.a);
        if (fragmentManagerB == null) {
            throw new IllegalArgumentException("Nutri.FilePicker: Failed to get the FragmentManager.");
        }
        MaybeSubject<Uri> maybeSubjectCreate = MaybeSubject.create();
        maybeSubjectCreate.getClass();
        this.d = maybeSubjectCreate;
        int i = mc.g;
        String[] strArr = this.c;
        Function1<? super Uri, Unit> function1 = new Function1() { // from class: com.pspdfkit.internal.lc$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return lc.a(this.f$0, (Uri) obj);
            }
        };
        Fragment fragmentFindFragmentByTag = fragmentManagerB.findFragmentByTag("com.pspdfkit.internal.document.editor.DefaultFilePickerHandler.FRAGMENT_TAG");
        if (fragmentFindFragmentByTag == null) {
            fragmentFindFragmentByTag = new mc();
        }
        mc mcVar = (mc) fragmentFindFragmentByTag;
        mcVar.b = str2;
        mcVar.c = function1;
        mcVar.d = str;
        if (!mcVar.isAdded()) {
            fragmentManagerB.beginTransaction().add(mcVar, "com.pspdfkit.internal.document.editor.DefaultFilePickerHandler.FRAGMENT_TAG").commitNow();
        }
        ActivityResultLauncher<String[]> activityResultLauncher = mcVar.f;
        if (activityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePickerLauncher");
            activityResultLauncher = null;
        }
        activityResultLauncher.launch(strArr);
        MaybeSubject<Uri> maybeSubject = this.d;
        if (maybeSubject != null) {
            return maybeSubject;
        }
        Intrinsics.throwUninitializedPropertyAccessException("maybeSubject");
        return null;
    }

    public static final Unit a(MaybeSubject maybeSubject, Uri uri, boolean z) {
        maybeSubject.onSuccess(uri);
        return Unit.INSTANCE;
    }
}

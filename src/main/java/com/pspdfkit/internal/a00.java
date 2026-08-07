package com.pspdfkit.internal;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import com.pspdfkit.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/pspdfkit/internal/a00;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class a00 extends DialogFragment {
    public static final /* synthetic */ int b = 0;
    public kb a;

    public static final void a(a00 a00Var, DialogInterface dialogInterface, int i) {
        kb kbVar = a00Var.a;
        if (kbVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            kbVar = null;
        }
        kb.a aVar = kb.a.SAVE;
        kbVar.getClass();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(kbVar), null, null, new lb(kbVar, aVar, null), 3, null);
    }

    public static final void b(a00 a00Var, DialogInterface dialogInterface, int i) {
        kb kbVar = a00Var.a;
        if (kbVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            kbVar = null;
        }
        kb.a aVar = kb.a.DISCARD;
        kbVar.getClass();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(kbVar), null, null, new lb(kbVar, aVar, null), 3, null);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Fragment fragmentRequireParentFragment = requireParentFragment();
        fragmentRequireParentFragment.getClass();
        this.a = (kb) new ViewModelProvider(fragmentRequireParentFragment).get(kb.class);
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        String string;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("message")) == null) {
            string = "";
        }
        AlertDialog alertDialogCreate = new AlertDialog.Builder(requireContext()).setMessage(string).setPositiveButton(R.string.pspdf__save, new DialogInterface.OnClickListener() { // from class: com.pspdfkit.internal.a00$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                a00.a(this.f$0, dialogInterface, i);
            }
        }).setNegativeButton(R.string.pspdf__discard_changes, new DialogInterface.OnClickListener() { // from class: com.pspdfkit.internal.a00$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                a00.b(this.f$0, dialogInterface, i);
            }
        }).setNeutralButton(R.string.pspdf__cancel, (DialogInterface.OnClickListener) null).setCancelable(true).create();
        alertDialogCreate.getClass();
        return alertDialogCreate;
    }
}

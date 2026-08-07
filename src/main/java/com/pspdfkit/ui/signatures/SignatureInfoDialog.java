package com.pspdfkit.ui.signatures;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.style.ImageSpan;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.pspdfkit.R;
import com.pspdfkit.internal.a80;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.e20;
import com.pspdfkit.internal.g60;
import com.pspdfkit.internal.m0;
import com.pspdfkit.internal.no;
import com.pspdfkit.internal.q10;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.yz;
import com.pspdfkit.signatures.DigitalSignatureInfo;
import com.pspdfkit.signatures.DigitalSignatureValidationResult;
import com.pspdfkit.signatures.ValidationStatus;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Calendar;
import java.util.Iterator;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public class SignatureInfoDialog extends DialogFragment {
    private static final String FRAGMENT_TAG = "com.pspdfkit.ui.dialog.SignatureInfoDialog.FRAGMENT_TAG";
    private static final String STATE_SIGNER = "com.pspdfkit.ui.dialog.SignatureInfoDialog.STATE_SIGNER";
    private static final String STATE_SIGNING_DATE = "com.pspdfkit.ui.dialog.SignatureInfoDialog.STATE_SIGNING_DATE";
    private static final String STATE_VALIDATION_RESULT = "com.pspdfkit.ui.dialog.SignatureInfoDialog.STATE_VALIDATION_RESULT";
    private e20 layout;
    private String signer;
    private Calendar signingDate;
    private DigitalSignatureValidationResult validationResult = null;
    private Disposable validationSubscription = null;
    private Drawable warnIcon;

    /* JADX INFO: renamed from: com.pspdfkit.ui.signatures.SignatureInfoDialog$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$pspdfkit$signatures$ValidationStatus;

        static {
            int[] iArr = new int[ValidationStatus.values().length];
            $SwitchMap$com$pspdfkit$signatures$ValidationStatus = iArr;
            try {
                iArr[ValidationStatus.VALID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$pspdfkit$signatures$ValidationStatus[ValidationStatus.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$pspdfkit$signatures$ValidationStatus[ValidationStatus.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void addMessage(SpannableStringBuilder spannableStringBuilder, int i) {
        addMessage(spannableStringBuilder, i, (Drawable) null);
    }

    private void addWarning(SpannableStringBuilder spannableStringBuilder, int i) {
        addMessage(spannableStringBuilder, i, this.warnIcon);
    }

    private SpannableStringBuilder getSignatureSummary(String str, Calendar calendar, DigitalSignatureValidationResult digitalSignatureValidationResult) {
        String strA;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int i = AnonymousClass1.$SwitchMap$com$pspdfkit$signatures$ValidationStatus[digitalSignatureValidationResult.getValidationStatus().ordinal()];
        if (i == 1) {
            addMessage(spannableStringBuilder, R.string.pspdf__digital_signature_valid);
        } else if (i == 2) {
            addWarning(spannableStringBuilder, R.string.pspdf__digital_signature_valid_warnings);
        } else if (i == 3) {
            addWarning(spannableStringBuilder, R.string.pspdf__digital_signature_invalid);
        }
        Iterator<DigitalSignatureValidationResult.ValidationProblem> it = digitalSignatureValidationResult.getProblems().iterator();
        while (it.hasNext()) {
            addWarning(spannableStringBuilder, it.next().getLocalizedDescription(requireContext()));
        }
        addWarning(spannableStringBuilder, digitalSignatureValidationResult.getDocumentIntegrityStatus().getLocalizedDescription(requireContext()));
        if (digitalSignatureValidationResult.getCertificateChainValidationStatus() != null) {
            addWarning(spannableStringBuilder, digitalSignatureValidationResult.getCertificateChainValidationStatus().getLocalizedDescription(requireContext()));
        }
        String strA2 = calendar != null ? DateFormat.getLongDateFormat(requireContext()).format(calendar.getTime()) : no.a(requireContext(), R.string.pspdf__unknown_date, null);
        String strA3 = calendar != null ? DateFormat.getTimeFormat(requireContext()).format(calendar.getTime()) : no.a(requireContext(), R.string.pspdf__unknown_time, null);
        boolean z = digitalSignatureValidationResult.getValidationStatus() != ValidationStatus.ERROR;
        String signatureType = digitalSignatureValidationResult.getSignatureType();
        if (signatureType.equals("CADES")) {
            signatureType = signatureType + " " + digitalSignatureValidationResult.getPadesSignatureLevel();
        }
        if (TextUtils.isEmpty(str)) {
            strA = no.a(requireContext(), z ? R.string.pspdf__digital_signature_signed_without_name : R.string.pspdf__digital_signature_signed_without_name_invalid, (View) null, strA2, strA3);
        } else {
            strA = no.a(requireContext(), z ? R.string.pspdf__digital_signature_signed_with_info : R.string.pspdf__digital_signature_signed_with_info_valid, (View) null, signatureType, str, strA2, strA3);
        }
        addMessage(spannableStringBuilder, strA);
        String signatureAlgorithm = digitalSignatureValidationResult.getSignatureAlgorithm();
        String hashAlgorithm = digitalSignatureValidationResult.getHashAlgorithm();
        if (signatureAlgorithm != null && hashAlgorithm != null) {
            addMessage(spannableStringBuilder, no.a(requireContext(), R.string.pspdf__digital_signature_signed_with_algo, (View) null, hashAlgorithm, signatureAlgorithm));
        }
        DigitalSignatureValidationResult.DocumentIntegrityStatus documentIntegrityStatus = digitalSignatureValidationResult.getDocumentIntegrityStatus();
        DigitalSignatureValidationResult.DocumentIntegrityStatus documentIntegrityStatus2 = DigitalSignatureValidationResult.DocumentIntegrityStatus.OK;
        if (documentIntegrityStatus == documentIntegrityStatus2 && z) {
            addMessage(spannableStringBuilder, digitalSignatureValidationResult.wasDocumentModified() ? R.string.pspdf__digital_signature_explanation_valid_modified : R.string.pspdf__digital_signature_explanation_valid_not_modified);
            return spannableStringBuilder;
        }
        if (digitalSignatureValidationResult.getDocumentIntegrityStatus() != documentIntegrityStatus2) {
            addMessage(spannableStringBuilder, R.string.pspdf__digital_signature_explanation_invalid);
        }
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateDialog$2(e20 e20Var) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setDigitalSignatureInfo$0(Runnable runnable, DigitalSignatureValidationResult digitalSignatureValidationResult) throws Throwable {
        this.validationResult = digitalSignatureValidationResult;
        showSignatureInformation(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setDigitalSignatureInfo$1(Throwable th) throws Throwable {
        showSignatureValidationError();
    }

    private void prepareWarnIcon() {
        Drawable drawableB = a80.b(requireContext(), R.drawable.pspdf__ic_warning);
        this.warnIcon = drawableB;
        if (drawableB != null) {
            drawableB.setBounds(0, 0, drawableB.getIntrinsicWidth(), this.warnIcon.getIntrinsicHeight());
        }
    }

    private void setDigitalSignatureInfo(final DigitalSignatureInfo digitalSignatureInfo, final Runnable runnable) {
        g60 g60VarC;
        this.signer = digitalSignatureInfo.getName();
        this.signingDate = digitalSignatureInfo.getCreationDate();
        Single singleFromCallable = Single.fromCallable(new Callable() { // from class: com.pspdfkit.ui.signatures.SignatureInfoDialog$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return digitalSignatureInfo.validate();
            }
        });
        synchronized (ar.class) {
            g60VarC = q10.c();
        }
        this.validationSubscription = singleFromCallable.subscribeOn(((m0) g60VarC).a()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: com.pspdfkit.ui.signatures.SignatureInfoDialog$$ExternalSyntheticLambda2
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                this.f$0.lambda$setDigitalSignatureInfo$0(runnable, (DigitalSignatureValidationResult) obj);
            }
        }, new Consumer() { // from class: com.pspdfkit.ui.signatures.SignatureInfoDialog$$ExternalSyntheticLambda3
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                this.f$0.lambda$setDigitalSignatureInfo$1((Throwable) obj);
            }
        });
    }

    public static void show(FragmentManager fragmentManager, DigitalSignatureInfo digitalSignatureInfo, Runnable runnable) {
        uw.a(digitalSignatureInfo, "signatureInfo", null);
        SignatureInfoDialog signatureInfoDialog = (SignatureInfoDialog) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (signatureInfoDialog == null) {
            signatureInfoDialog = new SignatureInfoDialog();
            signatureInfoDialog.setDigitalSignatureInfo(digitalSignatureInfo, runnable);
        }
        if (signatureInfoDialog.isAdded()) {
            return;
        }
        signatureInfoDialog.show(fragmentManager, FRAGMENT_TAG);
    }

    private void showSignatureInformation(Runnable runnable) {
        e20 e20Var = this.layout;
        if (e20Var == null || this.validationResult == null) {
            return;
        }
        e20Var.setOnDeleteSignatureHandler(runnable);
        this.layout.setStatus(this.validationResult.getValidationStatus());
        this.layout.setSummary(getSignatureSummary(this.signer, this.signingDate, this.validationResult));
        this.layout.c();
    }

    private void showSignatureValidationError() {
        e20 e20Var = this.layout;
        if (e20Var == null) {
            return;
        }
        e20Var.d();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        prepareWarnIcon();
        if (bundle != null) {
            DigitalSignatureValidationResult digitalSignatureValidationResult = (DigitalSignatureValidationResult) bundle.getParcelable(STATE_VALIDATION_RESULT);
            this.validationResult = digitalSignatureValidationResult;
            if (digitalSignatureValidationResult == null) {
                dismiss();
                return;
            }
            this.signer = bundle.getString(STATE_SIGNER);
            long j = bundle.getLong(STATE_SIGNING_DATE, -1L);
            if (j != -1) {
                Calendar calendar = Calendar.getInstance();
                this.signingDate = calendar;
                calendar.setTimeInMillis(j);
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        this.layout = new e20(requireContext(), new e20.b() { // from class: com.pspdfkit.ui.signatures.SignatureInfoDialog$$ExternalSyntheticLambda0
            @Override // com.pspdfkit.internal.e20.b
            public final void a(e20 e20Var) {
                this.f$0.lambda$onCreateDialog$2(e20Var);
            }
        });
        showSignatureInformation(null);
        return new AlertDialog.Builder(requireContext()).setCancelable(true).setView(this.layout).create();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        yz.a(this.validationSubscription);
        this.validationSubscription = null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        String str = this.signer;
        if (str != null) {
            bundle.putString(STATE_SIGNER, str);
        }
        Calendar calendar = this.signingDate;
        if (calendar != null) {
            bundle.putLong(STATE_SIGNING_DATE, calendar.getTimeInMillis());
        }
        DigitalSignatureValidationResult digitalSignatureValidationResult = this.validationResult;
        if (digitalSignatureValidationResult != null) {
            bundle.putParcelable(STATE_VALIDATION_RESULT, digitalSignatureValidationResult);
        }
    }

    private void addMessage(SpannableStringBuilder spannableStringBuilder, String str) {
        addMessage(spannableStringBuilder, str, (Drawable) null);
    }

    private void addWarning(SpannableStringBuilder spannableStringBuilder, String str) {
        addMessage(spannableStringBuilder, str, this.warnIcon);
    }

    private void addMessage(SpannableStringBuilder spannableStringBuilder, int i, Drawable drawable) {
        addMessage(spannableStringBuilder, no.a(requireContext(), i, null), drawable);
    }

    private void addMessage(SpannableStringBuilder spannableStringBuilder, String str, Drawable drawable) {
        if (str == null) {
            return;
        }
        if (spannableStringBuilder.length() > 0) {
            spannableStringBuilder.append("\n\n");
        }
        if (drawable != null) {
            spannableStringBuilder.append("#", new ImageSpan(this.warnIcon), 17).append("  ");
        }
        spannableStringBuilder.append((CharSequence) str);
    }
}

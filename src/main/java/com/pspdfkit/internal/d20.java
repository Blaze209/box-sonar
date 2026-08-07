package com.pspdfkit.internal;

import androidx.fragment.app.FragmentManager;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.internal.jni.NativeLicense;
import com.pspdfkit.internal.jni.NativeSignatureFeatureAvailability;
import com.pspdfkit.signatures.listeners.OnSignaturePickedListener;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.signatures.ElectronicSignatureFragment;
import com.pspdfkit.ui.signatures.ElectronicSignatureOptions;
import com.pspdfkit.ui.signatures.SignatureOptions;
import com.pspdfkit.ui.signatures.SignaturePickerFragment;

/* JADX INFO: loaded from: classes3.dex */
public final class d20 {
    public static final void a(PdfFragment pdfFragment, OnSignaturePickedListener onSignaturePickedListener) {
        pdfFragment.getClass();
        PdfConfiguration configuration = pdfFragment.getConfiguration();
        configuration.getClass();
        synchronized (ar.b()) {
            if (NativeLicense.license().signatureFeatureAvailability() == NativeSignatureFeatureAvailability.ELECTRONICSIGNATURES) {
                ElectronicSignatureFragment.show(pdfFragment.getParentFragmentManager(), onSignaturePickedListener, new ElectronicSignatureOptions(configuration.getSignatureSavingStrategy(), configuration.getSignatureColorOptions(), configuration.getSignatureCreationModes()), pdfFragment.getSignatureStorage());
                return;
            }
            SignaturePickerFragment.Companion companion = SignaturePickerFragment.INSTANCE;
            FragmentManager parentFragmentManager = pdfFragment.getParentFragmentManager();
            parentFragmentManager.getClass();
            companion.show(parentFragmentManager, onSignaturePickedListener, new SignatureOptions(configuration.getSignaturePickerOrientation(), configuration.getSignatureSavingStrategy()), pdfFragment.getSignatureStorage());
        }
    }
}

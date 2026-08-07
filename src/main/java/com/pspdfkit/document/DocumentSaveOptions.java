package com.pspdfkit.document;

import com.pspdfkit.exceptions.InvalidNutrientLicenseException;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public class DocumentSaveOptions {
    private boolean applyRedactions;
    private boolean incremental;
    private String password;
    private PdfVersion pdfVersion;
    private EnumSet<DocumentPermissions> permissions;
    private boolean rewriteAndOptimizeFileSize;

    public DocumentSaveOptions(String str, EnumSet<DocumentPermissions> enumSet, boolean z, PdfVersion pdfVersion) {
        this.password = str;
        this.permissions = enumSet == null ? EnumSet.noneOf(DocumentPermissions.class) : enumSet;
        this.incremental = z;
        this.pdfVersion = pdfVersion == null ? PdfVersion.PDF_1_7 : pdfVersion;
    }

    public String getPassword() {
        return this.password;
    }

    public PdfVersion getPdfVersion() {
        return this.pdfVersion;
    }

    public EnumSet<DocumentPermissions> getPermissions() {
        return this.permissions;
    }

    public boolean isIncremental() {
        return this.incremental;
    }

    public void setApplyRedactions(boolean z) {
        if (!ar.b().a(NativeLicenseFeatures.REDACTION)) {
            throw new InvalidNutrientLicenseException("Redacting requires Redaction License.");
        }
        this.applyRedactions = z;
    }

    public void setIncremental(boolean z) {
        this.incremental = z;
        if (z) {
            this.rewriteAndOptimizeFileSize = false;
        }
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setPdfVersion(PdfVersion pdfVersion) {
        if (pdfVersion == null) {
            pdfVersion = PdfVersion.PDF_1_7;
        }
        this.pdfVersion = pdfVersion;
    }

    public void setPermissions(EnumSet<DocumentPermissions> enumSet) {
        if (enumSet == null) {
            enumSet = EnumSet.noneOf(DocumentPermissions.class);
        }
        this.permissions = enumSet;
    }

    public void setRewriteAndOptimizeFileSize(boolean z) {
        this.rewriteAndOptimizeFileSize = z;
        if (z) {
            this.incremental = false;
        }
    }

    public boolean shouldApplyRedactions() {
        return this.applyRedactions;
    }

    public boolean shouldRewriteAndOptimizeFileSize() {
        return this.rewriteAndOptimizeFileSize;
    }
}

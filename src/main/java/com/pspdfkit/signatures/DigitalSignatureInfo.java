package com.pspdfkit.signatures;

import com.pspdfkit.datastructures.Range;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.internal.jni.NativeFormField;
import com.pspdfkit.internal.jni.NativeSignatureBuildData;
import com.pspdfkit.internal.jni.NativeSignatureInfo;
import com.pspdfkit.internal.jni.NativeSignatureReference;
import com.pspdfkit.internal.jni.NativeSignatureReferenceTransformMethod;
import com.pspdfkit.internal.lm;
import com.pspdfkit.internal.nv;
import com.pspdfkit.internal.uw;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public class DigitalSignatureInfo {
    public static final String BUILD_DATA_APP_KEY = "App";
    public static final String BUILD_DATA_FILTER_KEY = "Filter";
    public static final String BUILD_DATA_PUB_SEC_KEY = "PubSec";
    public static final String BUILD_DATA_SIGQ_KEY = "SigQ";
    private final Map<String, BuildData> buildProperties;
    private final List<Long> byteRange;
    private final byte[] contents;
    private final Calendar creationDate;
    private final lm document;
    private final int documentSourceIndex;
    private final String filter;
    private final String location;
    private final String name;
    private final String reason;
    private final List<Reference> references;
    private final NativeFormField signedFormField;
    private final String subFilter;

    public static class BuildData {
        private final String date;
        private final Integer minimumVersion;
        private final String name;
        private final boolean nonEmbeddedFontNoWarn;
        private final String operatingSystem;
        private final boolean preRelease;
        private final Integer revision;
        private final String revisionText;
        private final boolean trustedMode;

        public BuildData(String str, String str2, Integer num, String str3, String str4, boolean z, boolean z2, boolean z3, Integer num2) {
            this.name = str;
            this.date = str2;
            this.revision = num;
            this.revisionText = str3;
            this.operatingSystem = str4;
            this.preRelease = z;
            this.nonEmbeddedFontNoWarn = z2;
            this.trustedMode = z3;
            this.minimumVersion = num2;
        }

        public String getDate() {
            return this.date;
        }

        public Integer getMinimumVersion() {
            return this.minimumVersion;
        }

        public String getName() {
            return this.name;
        }

        public String getOperatingSystem() {
            return this.operatingSystem;
        }

        public Integer getRevision() {
            return this.revision;
        }

        public String getRevisionText() {
            return this.revisionText;
        }

        public boolean isNonEmbeddedFontNoWarn() {
            return this.nonEmbeddedFontNoWarn;
        }

        public boolean isPreRelease() {
            return this.preRelease;
        }

        public boolean isTrustedMode() {
            return this.trustedMode;
        }

        public String toString() {
            return "BuildData{name='" + this.name + "', date='" + this.date + "', revision=" + this.revision + ", revisionText='" + this.revisionText + "', operatingSystem='" + this.operatingSystem + "', preRelease=" + this.preRelease + ", nonEmbeddedFontNoWarn=" + this.nonEmbeddedFontNoWarn + ", trustedMode=" + this.trustedMode + ", minimumVersion=" + this.minimumVersion + AbstractJsonLexerKt.END_OBJ;
        }
    }

    public static class Reference {
        private final String dataName;
        private final Range digestLocation;
        private final String digestMethod;
        private final String digestValue;
        private final ReferenceTransformMethod transformMethod;

        public Reference(NativeSignatureReferenceTransformMethod nativeSignatureReferenceTransformMethod, String str, String str2, Range range, String str3) {
            uw.a(nativeSignatureReferenceTransformMethod, "transformMethod", null);
            this.transformMethod = ReferenceTransformMethod.values()[nativeSignatureReferenceTransformMethod.ordinal()];
            this.digestMethod = str;
            this.digestValue = str2;
            this.digestLocation = range;
            this.dataName = str3;
        }

        public String getDataName() {
            return this.dataName;
        }

        public Range getDigestLocation() {
            return this.digestLocation;
        }

        public String getDigestMethod() {
            return this.digestMethod;
        }

        public String getDigestValue() {
            return this.digestValue;
        }

        public ReferenceTransformMethod getTransformMethod() {
            return this.transformMethod;
        }

        public String toString() {
            return nv.a(new StringBuilder("Reference{transformMethod=").append(this.transformMethod).append(", digestMethod='").append(this.digestMethod).append("', digestValue='").append(this.digestValue).append("', digestLocation=").append(this.digestLocation).append(", dataName='"), this.dataName, "'}");
        }
    }

    public enum ReferenceTransformMethod {
        DOCMDP,
        UR,
        FIELDMDP,
        IDENTITY
    }

    public DigitalSignatureInfo(lm lmVar, int i, NativeFormField nativeFormField) {
        uw.a(lmVar, "document", null);
        uw.a(nativeFormField, "signedFormField", null);
        this.document = lmVar;
        this.documentSourceIndex = i;
        this.signedFormField = nativeFormField;
        NativeSignatureInfo signatureInfo = nativeFormField.getSignatureInfo();
        this.name = signatureInfo.getName();
        this.contents = signatureInfo.getContents();
        this.byteRange = signatureInfo.getByteRange();
        if (signatureInfo.getCreationDate() != null) {
            Calendar calendar = Calendar.getInstance();
            this.creationDate = calendar;
            calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
            calendar.setTime(signatureInfo.getCreationDate());
        } else {
            this.creationDate = null;
        }
        this.reason = signatureInfo.getReason();
        this.location = signatureInfo.getLocation();
        this.filter = signatureInfo.getFilter();
        this.subFilter = signatureInfo.getSubFilter();
        this.references = new ArrayList();
        ArrayList<NativeSignatureReference> references = signatureInfo.getReferences();
        int size = references.size();
        int i2 = 0;
        while (i2 < size) {
            NativeSignatureReference nativeSignatureReference = references.get(i2);
            i2++;
            NativeSignatureReference nativeSignatureReference2 = nativeSignatureReference;
            this.references.add(new Reference(nativeSignatureReference2.getTransformMethod(), nativeSignatureReference2.getDigestMethod(), nativeSignatureReference2.getDigestValue(), nativeSignatureReference2.getDigestLocation(), nativeSignatureReference2.getDataName()));
        }
        this.buildProperties = new TreeMap();
        if (signatureInfo.getBuildProperties() != null) {
            for (Map.Entry<String, NativeSignatureBuildData> entry : signatureInfo.getBuildProperties().getSignatureBuildData().entrySet()) {
                NativeSignatureBuildData value = entry.getValue();
                this.buildProperties.put(entry.getKey(), new BuildData(value.getName(), value.getDate(), value.getRevision(), value.getRevisionText(), value.getOperatingSystem(), value.getPreRelease(), value.getNonEmbeddedFontNoWarn(), value.getTrustedMode(), value.getMinimumVersion()));
            }
        }
    }

    public Map<String, BuildData> getBuildProperties() {
        return this.buildProperties;
    }

    public List<Long> getByteRange() {
        return this.byteRange;
    }

    public byte[] getContents() {
        return this.contents;
    }

    public Calendar getCreationDate() {
        return this.creationDate;
    }

    public PdfDocument getDocument() {
        return this.document;
    }

    public lm getDocumentInternal() {
        return this.document;
    }

    public int getDocumentSourceIndex() {
        return this.documentSourceIndex;
    }

    public String getFilter() {
        return this.filter;
    }

    public NativeFormField getFormField() {
        return this.signedFormField;
    }

    public String getLocation() {
        return this.location;
    }

    public String getName() {
        return this.name;
    }

    public String getReason() {
        return this.reason;
    }

    public List<Reference> getReferences() {
        return this.references;
    }

    public String getSubFilter() {
        return this.subFilter;
    }

    public boolean isSigned() {
        byte[] bArr = this.contents;
        return bArr != null && bArr.length > 0;
    }

    public String toString() {
        return "DigitalSignatureInfo{name='" + this.name + "', byteRange=" + this.byteRange + ", creationDate=" + this.creationDate + ", location='" + this.location + ", reason='" + this.reason + "', filter='" + this.filter + "', subFilter='" + this.subFilter + "', references=" + this.references + ", buildProperties=" + this.buildProperties + AbstractJsonLexerKt.END_OBJ;
    }

    public DigitalSignatureValidationResult validate() {
        return DigitalSignatureValidator.validateSignature(this);
    }

    public DigitalSignatureInfo(DigitalSignatureInfo digitalSignatureInfo) {
        this(digitalSignatureInfo.document, digitalSignatureInfo.documentSourceIndex, digitalSignatureInfo.signedFormField);
    }
}

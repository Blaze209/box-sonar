package com.pspdfkit.internal;

import android.content.Context;
import com.pspdfkit.R;
import com.pspdfkit.annotations.stamps.PredefinedStampType;
import com.pspdfkit.internal.jni.NativeDigitalSignatureLocalizableString;
import com.pspdfkit.internal.jni.NativeJavaScriptLocalizableString;
import com.pspdfkit.internal.jni.NativeLocalizationService;
import com.pspdfkit.internal.jni.NativeStampType;
import com.pspdfkit.utils.PdfLog;

/* JADX INFO: loaded from: classes3.dex */
public final class mo extends NativeLocalizationService {
    public final Context a;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[NativeStampType.values().length];
            c = iArr;
            try {
                iArr[NativeStampType.ACCEPTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[NativeStampType.APPROVED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[NativeStampType.ASIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                c[NativeStampType.COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                c[NativeStampType.CONFIDENTIAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                c[NativeStampType.DEPARTMENTAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                c[NativeStampType.DRAFT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                c[NativeStampType.EXPERIMENTAL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                c[NativeStampType.EXPIRED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                c[NativeStampType.FINAL.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                c[NativeStampType.FORCOMMENT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                c[NativeStampType.FORPUBLICRELEASE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                c[NativeStampType.INFORMATIONONLY.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                c[NativeStampType.INITIALHERE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                c[NativeStampType.NOTAPPROVED.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                c[NativeStampType.NOTFORPUBLICRELEASE.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                c[NativeStampType.PRELIMINARYRESULTS.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                c[NativeStampType.REJECTED.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                c[NativeStampType.REVISED.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                c[NativeStampType.SIGNHERE.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                c[NativeStampType.SOLD.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                c[NativeStampType.TOPSECRET.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                c[NativeStampType.VOID.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                c[NativeStampType.WITNESS.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            int[] iArr2 = new int[NativeJavaScriptLocalizableString.values().length];
            b = iArr2;
            try {
                iArr2[NativeJavaScriptLocalizableString.INVALIDDATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                b[NativeJavaScriptLocalizableString.INVALIDVALUEFORMAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                b[NativeJavaScriptLocalizableString.INVALIDVALUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                b[NativeJavaScriptLocalizableString.INVALIDVALUEGREATERTHANANDLESSTHAN.ordinal()] = 4;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                b[NativeJavaScriptLocalizableString.INVALIDVALUEGREATERTHANOREQUALTO.ordinal()] = 5;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                b[NativeJavaScriptLocalizableString.INVALIDVALUELESSTHANOREQUALTO.ordinal()] = 6;
            } catch (NoSuchFieldError unused30) {
            }
            int[] iArr3 = new int[NativeDigitalSignatureLocalizableString.values().length];
            a = iArr3;
            try {
                iArr3[NativeDigitalSignatureLocalizableString.DIGITALLYSIGNEDBY.ordinal()] = 1;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                a[NativeDigitalSignatureLocalizableString.SIGNATUREDATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                a[NativeDigitalSignatureLocalizableString.SIGNATUREREASON.ordinal()] = 3;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                a[NativeDigitalSignatureLocalizableString.SIGNATURELOCATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                a[NativeDigitalSignatureLocalizableString.SIGN.ordinal()] = 5;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                a[NativeDigitalSignatureLocalizableString.SIGNED.ordinal()] = 6;
            } catch (NoSuchFieldError unused36) {
            }
        }
    }

    public mo(Context context) {
        this.a = context.getApplicationContext();
    }

    @Override // com.pspdfkit.internal.jni.NativeLocalizationService
    public final String getDigitalSignatureLocalizedString(NativeDigitalSignatureLocalizableString nativeDigitalSignatureLocalizableString) {
        int i;
        PdfLog.d("Nutri.LocalServImpl", "Asking for localized string %s", nativeDigitalSignatureLocalizableString.toString());
        switch (a.a[nativeDigitalSignatureLocalizableString.ordinal()]) {
            case 1:
                i = R.string.pspdf__digital_signature_signed_by;
                break;
            case 2:
                i = R.string.pspdf__digital_signature_signed_date;
                break;
            case 3:
                i = R.string.pspdf__digital_signature_signed_reason;
                break;
            case 4:
                i = R.string.pspdf__digital_signature_signed_location;
                break;
            case 5:
                i = R.string.pspdf__digital_signature_sign;
                break;
            case 6:
                i = R.string.pspdf__digital_signature_signed;
                break;
            default:
                return "";
        }
        return no.a(this.a, i, null).replaceAll("%\\d*\\$(\\w)", "%$1");
    }

    @Override // com.pspdfkit.internal.jni.NativeLocalizationService
    public final String getJavaScriptLocalizedString(NativeJavaScriptLocalizableString nativeJavaScriptLocalizableString) {
        int i;
        PdfLog.d("Nutri.LocalServImpl", "Asking for localized string %s", nativeJavaScriptLocalizableString.toString());
        switch (a.b[nativeJavaScriptLocalizableString.ordinal()]) {
            case 1:
                i = R.string.pspdf__invalid_date_time;
                break;
            case 2:
                i = R.string.pspdf__invalid_value_format;
                break;
            case 3:
                i = R.string.pspdf__invalid_value;
                break;
            case 4:
                i = R.string.pspdf__invalid_value_greater_than_and_less_than;
                break;
            case 5:
                i = R.string.pspdf__invalid_value_greater_than_or_equal;
                break;
            case 6:
                i = R.string.pspdf__invalid_value_less_than_or_equal;
                break;
            default:
                return "";
        }
        return no.a(this.a, i, null).replaceAll("%\\d*\\$(\\w)", "%$1");
    }

    @Override // com.pspdfkit.internal.jni.NativeLocalizationService
    public final String getStampLocalizedString(NativeStampType nativeStampType) {
        PredefinedStampType predefinedStampType;
        PdfLog.d("Nutri.LocalServImpl", "Asking for localized string for stamp type %s", nativeStampType.toString());
        switch (a.c[nativeStampType.ordinal()]) {
            case 1:
                predefinedStampType = PredefinedStampType.ACCEPTED;
                break;
            case 2:
                predefinedStampType = PredefinedStampType.APPROVED;
                break;
            case 3:
                predefinedStampType = PredefinedStampType.AS_IS;
                break;
            case 4:
                predefinedStampType = PredefinedStampType.COMPLETED;
                break;
            case 5:
                predefinedStampType = PredefinedStampType.CONFIDENTIAL;
                break;
            case 6:
                predefinedStampType = PredefinedStampType.DEPARTMENTAL;
                break;
            case 7:
                predefinedStampType = PredefinedStampType.DRAFT;
                break;
            case 8:
                predefinedStampType = PredefinedStampType.EXPERIMENTAL;
                break;
            case 9:
                predefinedStampType = PredefinedStampType.EXPIRED;
                break;
            case 10:
                predefinedStampType = PredefinedStampType.FINAL;
                break;
            case 11:
                predefinedStampType = PredefinedStampType.FOR_COMMENT;
                break;
            case 12:
                predefinedStampType = PredefinedStampType.FOR_PUBLIC_RELEASE;
                break;
            case 13:
                predefinedStampType = PredefinedStampType.INFORMATION_ONLY;
                break;
            case 14:
                predefinedStampType = PredefinedStampType.INITIAL_HERE;
                break;
            case 15:
                predefinedStampType = PredefinedStampType.NOT_APPROVED;
                break;
            case 16:
                predefinedStampType = PredefinedStampType.NOT_FOR_PUBLIC_RELEASE;
                break;
            case 17:
                predefinedStampType = PredefinedStampType.PRELIMINARY_RESULTS;
                break;
            case 18:
                predefinedStampType = PredefinedStampType.REJECTED;
                break;
            case 19:
                predefinedStampType = PredefinedStampType.REVISED;
                break;
            case 20:
                predefinedStampType = PredefinedStampType.SIGN_HERE;
                break;
            case 21:
                predefinedStampType = PredefinedStampType.SOLD;
                break;
            case 22:
                predefinedStampType = PredefinedStampType.TOP_SECRET;
                break;
            case 23:
                predefinedStampType = PredefinedStampType.VOID;
                break;
            case 24:
                predefinedStampType = PredefinedStampType.WITNESS;
                break;
            default:
                throw new IncompatibleClassChangeError();
        }
        return no.a(this.a, predefinedStampType.getTitleResId(), null).replaceAll("%\\d*\\$(\\w)", "%$1");
    }
}

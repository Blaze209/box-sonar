package com.pspdfkit.internal;

import android.content.Context;
import com.pspdfkit.internal.jni.NativeDigitalSignatureMetadata;
import com.pspdfkit.internal.jni.NativeDigitalSignatureType;
import com.pspdfkit.internal.jni.NativeSignatureAppearance;
import com.pspdfkit.internal.jni.NativeSignatureAppearanceMode;
import com.pspdfkit.internal.jni.NativeSignatureBiometricProperties;
import com.pspdfkit.internal.jni.NativeSignatureInputMethod;
import com.pspdfkit.internal.jni.NativeX509Certificate;
import com.pspdfkit.signatures.BiometricSignatureData;
import com.pspdfkit.signatures.DigitalSignatureMetadata;
import com.pspdfkit.signatures.DigitalSignatureType;
import com.pspdfkit.signatures.HashAlgorithm;
import com.pspdfkit.signatures.SignatureAppearance;
import com.pspdfkit.signatures.SignatureGraphic;
import com.pspdfkit.signatures.SignerOptions;
import com.pspdfkit.signatures.TrustedKeyStore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes3.dex */
public final class xq {
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public static final Object a(Context context, SignerOptions signerOptions, List list, ContinuationImpl continuationImpl) {
        vq vqVar;
        NativeSignatureAppearanceMode nativeSignatureAppearanceMode;
        NativeDigitalSignatureType nativeDigitalSignatureType;
        NativeDigitalSignatureMetadata nativeDigitalSignatureMetadata;
        NativeDigitalSignatureMetadata nativeDigitalSignatureMetadata2;
        ArrayList arrayList;
        NativeSignatureInputMethod nativeSignatureInputMethod;
        if (continuationImpl instanceof vq) {
            vqVar = (vq) continuationImpl;
            int i = vqVar.j;
            if ((i & Integer.MIN_VALUE) != 0) {
                vqVar.j = i - Integer.MIN_VALUE;
            } else {
                vqVar = new vq(continuationImpl);
            }
        } else {
            vqVar = new vq(continuationImpl);
        }
        Object objAwait = vqVar.i;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = vqVar.j;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objAwait);
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : list) {
                if (((NativeX509Certificate) obj).isCACertificate()) {
                    arrayList2.add(obj);
                }
            }
            DigitalSignatureMetadata metadata = signerOptions.getMetadata();
            if (metadata == null) {
                metadata = new DigitalSignatureMetadata(null, null, null, null, null, null, null, 127, null);
            }
            context.getClass();
            NativeDigitalSignatureMetadata nativeDigitalSignatureMetadataCreate = NativeDigitalSignatureMetadata.create();
            nativeDigitalSignatureMetadataCreate.getClass();
            SignatureAppearance signatureAppearance = metadata.getSignatureAppearance();
            if (signatureAppearance == null) {
                signatureAppearance = new SignatureAppearance(null, false, false, false, false, null, null, false, false, false, 1023, null);
            }
            SignatureAppearance.SignatureAppearanceMode signatureAppearanceMode = signatureAppearance.getSignatureAppearanceMode();
            signatureAppearanceMode.getClass();
            int i3 = j20.a.b[signatureAppearanceMode.ordinal()];
            if (i3 == 1) {
                nativeSignatureAppearanceMode = NativeSignatureAppearanceMode.DESCRIPTION_ONLY;
            } else if (i3 == 2) {
                nativeSignatureAppearanceMode = NativeSignatureAppearanceMode.SIGNATURE_AND_DESCRIPTION;
            } else {
                if (i3 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                nativeSignatureAppearanceMode = NativeSignatureAppearanceMode.SIGNATURE_ONLY;
            }
            NativeSignatureAppearance nativeSignatureAppearanceCreate = NativeSignatureAppearance.create(nativeSignatureAppearanceMode);
            nativeSignatureAppearanceCreate.setReuseExistingSignatureAppearanceStream(signatureAppearance.getReuseExistingSignatureAppearanceStream());
            nativeSignatureAppearanceCreate.setShowSignatureReason(signatureAppearance.getShowSignatureReason());
            nativeSignatureAppearanceCreate.setShowSignDate(signatureAppearance.getShowSignDate());
            nativeSignatureAppearanceCreate.setShowSignerName(signatureAppearance.getShowSignerName());
            nativeSignatureAppearanceCreate.setShowWatermark(signatureAppearance.getShowWatermark());
            SignatureGraphic signatureGraphic = signatureAppearance.getSignatureGraphic();
            if (signatureGraphic != null) {
                nativeSignatureAppearanceCreate.setSignatureGraphic(mr.a(context, signatureGraphic));
            }
            SignatureGraphic signatureWatermark = signatureAppearance.getSignatureWatermark();
            if (signatureWatermark != null) {
                nativeSignatureAppearanceCreate.setSignatureWatermark(mr.a(context, signatureWatermark));
            }
            nativeDigitalSignatureMetadataCreate.setAppearance(nativeSignatureAppearanceCreate);
            Integer estimatedSize = metadata.getEstimatedSize();
            if (estimatedSize != null) {
                nativeDigitalSignatureMetadataCreate.setEstimatedSize(estimatedSize.intValue());
            }
            HashAlgorithm hashAlgorithm = metadata.getHashAlgorithm();
            if (hashAlgorithm != null) {
                nativeDigitalSignatureMetadataCreate.setHashAlgorithm(mr.a(hashAlgorithm));
            }
            String reason = metadata.getReason();
            if (reason != null) {
                nativeDigitalSignatureMetadataCreate.setReason(reason);
            }
            String location = metadata.getLocation();
            if (location != null) {
                nativeDigitalSignatureMetadataCreate.setLocation(location);
            }
            BiometricSignatureData biometricData = metadata.getBiometricData();
            if (biometricData != null) {
                List<Float> pressurePoints = biometricData.getPressurePoints();
                if (pressurePoints == null) {
                    pressurePoints = null;
                } else if (pressurePoints.size() > 3) {
                    ArrayList arrayList3 = new ArrayList(3);
                    arrayList3.add(pressurePoints.get(0));
                    arrayList3.add(pressurePoints.get(pressurePoints.size() / 2));
                    arrayList3.add(pressurePoints.get(pressurePoints.size() - 1));
                    pressurePoints = arrayList3;
                }
                List<Long> timePoints = biometricData.getTimePoints();
                if (timePoints == null) {
                    timePoints = null;
                } else if (timePoints.size() > 3) {
                    ArrayList arrayList4 = new ArrayList(3);
                    arrayList4.add(timePoints.get(0));
                    arrayList4.add(timePoints.get(timePoints.size() / 2));
                    arrayList4.add(timePoints.get(timePoints.size() - 1));
                    timePoints = arrayList4;
                }
                if (timePoints == null) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList(timePoints.size());
                    Iterator<Long> it = timePoints.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Float.valueOf(it.next().floatValue()));
                    }
                }
                ArrayList arrayList5 = pressurePoints == null ? null : pressurePoints instanceof ArrayList ? (ArrayList) pressurePoints : new ArrayList(pressurePoints);
                if (arrayList == null) {
                    arrayList = null;
                }
                Float touchRadius = biometricData.getTouchRadius();
                BiometricSignatureData.InputMethod inputMethod = biometricData.getInputMethod();
                if (inputMethod != null) {
                    int i4 = mr.b.f[inputMethod.ordinal()];
                    if (i4 == 1) {
                        nativeSignatureInputMethod = NativeSignatureInputMethod.FINGER;
                    } else if (i4 == 2) {
                        nativeSignatureInputMethod = NativeSignatureInputMethod.THIRDPARTYSTYLUS;
                    } else if (i4 == 3) {
                        nativeSignatureInputMethod = NativeSignatureInputMethod.MOUSE;
                    } else {
                        if (i4 != 4) {
                            throw new NoWhenBranchMatchedException();
                        }
                        nativeSignatureInputMethod = NativeSignatureInputMethod.APPLEPENCIL;
                    }
                } else {
                    nativeSignatureInputMethod = null;
                }
                nativeDigitalSignatureMetadataCreate.setBiometricProperties(new NativeSignatureBiometricProperties(arrayList5, arrayList, touchRadius, nativeSignatureInputMethod));
            }
            DigitalSignatureType type = signerOptions.getType();
            type.getClass();
            int i5 = j20.a.a[type.ordinal()];
            if (i5 == 1) {
                nativeDigitalSignatureType = NativeDigitalSignatureType.CADES;
            } else {
                if (i5 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                nativeDigitalSignatureType = NativeDigitalSignatureType.BASIC;
            }
            nativeDigitalSignatureMetadataCreate.setType(nativeDigitalSignatureType);
            if (!signerOptions.getEnableLtv() || arrayList2.isEmpty() || signerOptions.getType() != DigitalSignatureType.CADES) {
                return nativeDigitalSignatureMetadataCreate;
            }
            nativeDigitalSignatureMetadataCreate.setTrustedKeyStore(TrustedKeyStore.toNativeKeystore());
            nativeDigitalSignatureMetadataCreate.getTrustedKeyStore().addCertificates(new ArrayList<>(arrayList2));
            Deferred deferredAsync$default = BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new wq(signerOptions, list, nativeDigitalSignatureMetadataCreate, null), 3, null);
            vqVar.a = SpillingKt.nullOutSpilledVariable(context);
            vqVar.b = SpillingKt.nullOutSpilledVariable(signerOptions);
            vqVar.c = SpillingKt.nullOutSpilledVariable(list);
            vqVar.d = SpillingKt.nullOutSpilledVariable(arrayList2);
            vqVar.e = nativeDigitalSignatureMetadataCreate;
            vqVar.f = SpillingKt.nullOutSpilledVariable(nativeDigitalSignatureMetadataCreate);
            vqVar.g = SpillingKt.nullOutSpilledVariable(deferredAsync$default);
            vqVar.h = nativeDigitalSignatureMetadataCreate;
            vqVar.j = 1;
            objAwait = deferredAsync$default.await(vqVar);
            if (objAwait == coroutine_suspended) {
                return coroutine_suspended;
            }
            nativeDigitalSignatureMetadata = nativeDigitalSignatureMetadataCreate;
            nativeDigitalSignatureMetadata2 = nativeDigitalSignatureMetadata;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            nativeDigitalSignatureMetadata = vqVar.h;
            nativeDigitalSignatureMetadata2 = vqVar.e;
            ResultKt.throwOnFailure(objAwait);
        }
        nativeDigitalSignatureMetadata.setHttpRevocationResponses((String) objAwait);
        return nativeDigitalSignatureMetadata2;
    }
}

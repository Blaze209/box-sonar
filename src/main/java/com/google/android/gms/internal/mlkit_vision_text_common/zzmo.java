package com.google.android.gms.internal.mlkit_vision_text_common;

import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.margelo.nitro.boxcontext.MessengerBus;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-text-recognition-common@@19.1.0 */
/* JADX INFO: loaded from: classes11.dex */
final class zzmo implements ObjectEncoder {
    static final zzmo zza = new zzmo();

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder(ReactNativeFeatureActivity.RESULT_EXTRA_KEY);
        zzct zzctVar = new zzct();
        zzctVar.zza(1);
        builder.withProperty(zzctVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder(MessengerBus.STATUS_OK);
        zzct zzctVar2 = new zzct();
        zzctVar2.zza(2);
        builder2.withProperty(zzctVar2.zzb()).build();
    }

    private zzmo() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}

package com.google.android.gms.internal.mlkit_common;

import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.margelo.nitro.boxcontext.MessengerBus;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.11.0 */
/* JADX INFO: loaded from: classes13.dex */
final class zzkp implements ObjectEncoder {
    static final zzkp zza = new zzkp();

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder(ReactNativeFeatureActivity.RESULT_EXTRA_KEY);
        zzay zzayVar = new zzay();
        zzayVar.zza(1);
        builder.withProperty(zzayVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder(MessengerBus.STATUS_OK);
        zzay zzayVar2 = new zzay();
        zzayVar2.zza(2);
        builder2.withProperty(zzayVar2.zzb()).build();
    }

    private zzkp() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}

package androidx.camera.video;

import android.content.Context;
import android.net.Uri;
import androidx.core.util.Consumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Recorder$RecordingRecord$$ExternalSyntheticLambda2 implements Consumer {
    public final /* synthetic */ MediaStoreOutputOptions f$0;
    public final /* synthetic */ Context f$1;

    public /* synthetic */ Recorder$RecordingRecord$$ExternalSyntheticLambda2(MediaStoreOutputOptions mediaStoreOutputOptions, Context context) {
        this.f$0 = mediaStoreOutputOptions;
        this.f$1 = context;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object obj) throws Throwable {
        Recorder.RecordingRecord.lambda$initializeRecording$4(this.f$0, this.f$1, (Uri) obj);
    }
}

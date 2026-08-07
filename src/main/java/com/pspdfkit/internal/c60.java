package com.pspdfkit.internal;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.widget.Toast;
import com.pspdfkit.R;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableEmitter;
import io.reactivex.rxjava3.core.CompletableOnSubscribe;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public final class c60 {
    public static a a;

    public static final class a implements TextToSpeech.OnInitListener {
        public final Context a;
        public final TextToSpeech b;
        public final String c;
        public Disposable d;

        /* JADX INFO: renamed from: com.pspdfkit.internal.c60$a$a, reason: collision with other inner class name */
        public class C0256a extends UtteranceProgressListener {
            public final /* synthetic */ CompletableEmitter a;

            public C0256a(CompletableEmitter completableEmitter) {
                this.a = completableEmitter;
            }

            @Override // android.speech.tts.UtteranceProgressListener
            public final void onDone(String str) {
                this.a.onComplete();
            }

            @Override // android.speech.tts.UtteranceProgressListener
            public final void onError(String str) {
            }

            @Override // android.speech.tts.UtteranceProgressListener
            public final void onStart(String str) {
            }
        }

        public a(Context context, String str) {
            this.a = context.getApplicationContext();
            this.b = new TextToSpeech(context, this);
            Charset charset = u40.a;
            this.c = str.replaceAll("[\r\n]+", "");
        }

        public final /* synthetic */ void a(CompletableEmitter completableEmitter) throws Throwable {
            this.b.setOnUtteranceProgressListener(new C0256a(completableEmitter));
            this.b.speak(this.c, 0, null, null);
        }

        @Override // android.speech.tts.TextToSpeech.OnInitListener
        public final void onInit(int i) {
            g60 g60VarC;
            if (i == -1) {
                Toast.makeText(this.a, R.string.pspdf__tts_not_available, 0).show();
                return;
            }
            Completable completableCreate = Completable.create(new CompletableOnSubscribe() { // from class: com.pspdfkit.internal.c60$a$$ExternalSyntheticLambda0
                @Override // io.reactivex.rxjava3.core.CompletableOnSubscribe
                public final void subscribe(CompletableEmitter completableEmitter) throws Throwable {
                    this.f$0.a(completableEmitter);
                }
            });
            synchronized (ar.class) {
                g60VarC = q10.c();
            }
            this.d = completableCreate.subscribeOn(((m0) g60VarC).a()).subscribe(new Action() { // from class: com.pspdfkit.internal.c60$a$$ExternalSyntheticLambda1
                @Override // io.reactivex.rxjava3.functions.Action
                public final void run() {
                    this.f$0.a();
                }
            });
        }

        public final void a() {
            yz.a(this.d);
            this.d = null;
            this.b.stop();
            this.b.shutdown();
        }
    }
}

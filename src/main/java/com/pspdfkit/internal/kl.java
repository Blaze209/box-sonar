package com.pspdfkit.internal;

import com.pspdfkit.instant.exceptions.InstantException;
import com.pspdfkit.instant.internal.jni.NativeInstantJWT;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableEmitter;
import io.reactivex.rxjava3.core.CompletableOnSubscribe;

/* JADX INFO: loaded from: classes3.dex */
public final class kl {
    public final gm a;

    public kl(gm gmVar) {
        this.a = gmVar;
    }

    public final Completable a(final String str) {
        try {
            gm gmVar = this.a;
            final wl wlVarA = wl.a(str, gmVar.d, gmVar.e);
            NativeInstantJWT jwt = this.a.c.getJWT();
            return (jwt == null || !str.equals(jwt.rawValue())) ? Completable.create(new CompletableOnSubscribe() { // from class: com.pspdfkit.internal.kl$$ExternalSyntheticLambda0
                @Override // io.reactivex.rxjava3.core.CompletableOnSubscribe
                public final void subscribe(CompletableEmitter completableEmitter) throws Throwable {
                    this.f$0.a(str, wlVarA, completableEmitter);
                }
            }) : Completable.complete();
        } catch (InstantException e) {
            return Completable.error(e);
        }
    }

    public final void a(String str, wl wlVar, CompletableEmitter completableEmitter) throws Throwable {
        jl jlVar = new jl(this, completableEmitter, str);
        pl plVarA = this.a.a();
        plVarA.getClass();
        plVarA.b.a(jlVar);
        this.a.c.updateAuthenticationToken(wlVar.a);
    }
}

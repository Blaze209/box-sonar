package com.pspdfkit.internal;

import android.graphics.Typeface;
import com.pspdfkit.annotations.FreeTextAnnotation;
import com.pspdfkit.ui.fonts.Font;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.ui.fonts.SystemFontManager$resolveTypefaceForAnnotation$2", f = "SystemFontManager.kt", i = {0, 1, 1, 1}, l = {Token.LETEXPR, Token.DEBUGGER}, m = "invokeSuspend", n = {"$this$withContext", "$this$withContext", "defaultTypeface", "annotationFontName"}, nl = {160, Token.YIELD_STAR}, s = {"L$0", "L$0", "L$1", "L$2"}, v = 2)
public final class g50 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Typeface>, Object> {
    public Typeface a;
    public String b;
    public e50 c;
    public int d;
    public /* synthetic */ Object e;
    public final /* synthetic */ e50 f;
    public final /* synthetic */ FreeTextAnnotation g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g50(e50 e50Var, FreeTextAnnotation freeTextAnnotation, Continuation<? super g50> continuation) {
        super(2, continuation);
        this.f = e50Var;
        this.g = freeTextAnnotation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        g50 g50Var = new g50(this.f, this.g, continuation);
        g50Var.e = obj;
        return g50Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Typeface> continuation) {
        return ((g50) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x006a  */
    /* JADX WARN: Code duplicated, block: B:25:0x0074  */
    /* JADX WARN: Code duplicated, block: B:28:0x007b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x007c  */
    /* JADX WARN: Code duplicated, block: B:32:0x008c  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x00a2 A[SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        e50 e50Var;
        Typeface typeface;
        Font fontA;
        FreeTextAnnotation freeTextAnnotation;
        Iterator<T> it;
        Object next;
        File file;
        Object objM14780constructorimpl;
        Object obj2;
        Typeface defaultTypeface;
        CoroutineScope coroutineScope = (CoroutineScope) this.e;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.d;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Deferred<Font> deferred = this.f.d;
            this.e = coroutineScope;
            this.d = 1;
            obj = deferred.await(this);
            if (obj != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            e50Var = this.c;
            str = this.b;
            Typeface typeface2 = this.a;
            ResultKt.throwOnFailure(obj);
            typeface = typeface2;
        }
        fontA = e50.a(e50Var, (List) obj, str);
        if (fontA != null) {
            if (Intrinsics.areEqual(fontA.getName(), str)) {
                defaultTypeface = fontA.getDefaultTypeface();
                if (defaultTypeface == null) {
                    return defaultTypeface;
                }
            } else {
                List<File> fontFiles = fontA.getFontFiles();
                freeTextAnnotation = this.g;
                it = fontFiles.iterator();
                do {
                    if (it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(FilesKt.getNameWithoutExtension((File) next), freeTextAnnotation.getFontName()));
                file = (File) next;
                if (file != null) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        objM14780constructorimpl = Result.m14780constructorimpl(Typeface.createFromFile(file));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objM14780constructorimpl = Result.m14780constructorimpl(ResultKt.createFailure(th));
                    }
                    obj2 = typeface;
                    if (Result.m14783exceptionOrNullimpl(objM14780constructorimpl) == null) {
                        obj2 = objM14780constructorimpl;
                    }
                    return (Typeface) obj2;
                }
            }
        }
        return typeface;
        Typeface defaultTypeface2 = ((Font) obj).getDefaultTypeface();
        String fontName = this.g.getFontName();
        if (fontName == null) {
            return defaultTypeface2;
        }
        e50 e50Var2 = this.f;
        Deferred<List<Font>> deferred2 = e50Var2.b;
        this.e = coroutineScope;
        this.a = defaultTypeface2;
        this.b = fontName;
        this.c = e50Var2;
        this.d = 2;
        Object objAwait = deferred2.await(this);
        if (objAwait != coroutine_suspended) {
            str = fontName;
            obj = objAwait;
            e50Var = e50Var2;
            typeface = defaultTypeface2;
            fontA = e50.a(e50Var, (List) obj, str);
            if (fontA != null) {
                if (Intrinsics.areEqual(fontA.getName(), str)) {
                    defaultTypeface = fontA.getDefaultTypeface();
                    if (defaultTypeface == null) {
                        return defaultTypeface;
                    }
                } else {
                    List<File> fontFiles2 = fontA.getFontFiles();
                    freeTextAnnotation = this.g;
                    it = fontFiles2.iterator();
                    do {
                        if (it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (!Intrinsics.areEqual(FilesKt.getNameWithoutExtension((File) next), freeTextAnnotation.getFontName()));
                    file = (File) next;
                    if (file != null) {
                        Result.Companion companion3 = Result.INSTANCE;
                        objM14780constructorimpl = Result.m14780constructorimpl(Typeface.createFromFile(file));
                        obj2 = typeface;
                        if (Result.m14783exceptionOrNullimpl(objM14780constructorimpl) == null) {
                            obj2 = objM14780constructorimpl;
                        }
                        return (Typeface) obj2;
                    }
                }
            }
            return typeface;
        }
        return coroutine_suspended;
    }
}

package com.pspdfkit.internal;

import com.pspdfkit.internal.jni.NativeContentEditingCommand;
import com.pspdfkit.internal.jni.NativeContentEditingResult;
import com.pspdfkit.internal.jni.NativeContentEditor;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ga<InputType, ResultType> {

    public static final /* synthetic */ class a extends FunctionReferenceImpl implements Function2<ResultType, NativeContentEditingResult, Unit> {
        public a(ga gaVar) {
            super(2, gaVar, ga.class, "onResultConverted", "onResultConverted(Ljava/lang/Object;Lcom/pspdfkit/internal/jni/NativeContentEditingResult;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Object obj, NativeContentEditingResult nativeContentEditingResult) {
            NativeContentEditingResult nativeContentEditingResult2 = nativeContentEditingResult;
            nativeContentEditingResult2.getClass();
            ((ga) this.receiver).a(obj, nativeContentEditingResult2);
            return Unit.INSTANCE;
        }
    }

    public void a(ResultType resulttype, NativeContentEditingResult nativeContentEditingResult) {
        nativeContentEditingResult.getClass();
    }

    public abstract InputType b();

    public abstract SerializationStrategy<InputType> c();

    public abstract NativeContentEditingCommand d();

    public za<ResultType> e() {
        return new za<>(f(), new a(this));
    }

    public abstract DeserializationStrategy<ResultType> f();

    public String a() {
        return "";
    }

    public final NativeContentEditingResult a(NativeContentEditor nativeContentEditor) {
        nativeContentEditor.getClass();
        NativeContentEditingResult nativeContentEditingResultExecuteCommand = nativeContentEditor.executeCommand(d(), ra.a.encodeToString(c(), b()));
        nativeContentEditingResultExecuteCommand.getClass();
        return nativeContentEditingResultExecuteCommand;
    }
}

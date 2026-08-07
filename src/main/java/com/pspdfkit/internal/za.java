package com.pspdfkit.internal;

import com.pspdfkit.exceptions.NutrientException;
import com.pspdfkit.internal.jni.NativeContentEditingResult;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlinx.serialization.DeserializationStrategy;

/* JADX INFO: loaded from: classes3.dex */
public class za<ResultType> {
    public final DeserializationStrategy<ResultType> a;
    public final Function2<ResultType, NativeContentEditingResult, Unit> b;

    /* JADX WARN: Multi-variable type inference failed */
    public za(DeserializationStrategy<? extends ResultType> deserializationStrategy, Function2<? super ResultType, ? super NativeContentEditingResult, Unit> function2) {
        deserializationStrategy.getClass();
        function2.getClass();
        this.a = deserializationStrategy;
        this.b = function2;
    }

    public static final Unit a(Object obj, NativeContentEditingResult nativeContentEditingResult) {
        nativeContentEditingResult.getClass();
        return Unit.INSTANCE;
    }

    public String a(NativeContentEditingResult nativeContentEditingResult) {
        String jsonData = nativeContentEditingResult.getJsonData();
        if (jsonData == null || jsonData.length() == 0) {
            jsonData = null;
        }
        if (jsonData != null) {
            return jsonData;
        }
        throw new NutrientException("ContentEditing - JSON response == " + nativeContentEditingResult.getJsonData());
    }

    public /* synthetic */ za(DeserializationStrategy deserializationStrategy) {
        this(deserializationStrategy, new Function2() { // from class: com.pspdfkit.internal.za$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return za.a(obj, (NativeContentEditingResult) obj2);
            }
        });
    }
}

package com.pspdfkit.internal;

import com.pspdfkit.internal.jni.NativeContentEditingCommand;
import java.util.List;
import kotlin.Unit;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.builtins.BuiltinSerializersKt;

/* JADX INFO: loaded from: classes3.dex */
public final class b7 extends ga<Unit, List<? extends pg>> {
    public final NativeContentEditingCommand a = NativeContentEditingCommand.AVAILABLE_FACES;
    public final Unit b;
    public final SerializationStrategy<Unit> c;
    public final DeserializationStrategy<List<pg>> d;

    public b7() {
        Unit unit = Unit.INSTANCE;
        this.b = unit;
        this.c = BuiltinSerializersKt.serializer(unit);
        this.d = BuiltinSerializersKt.ListSerializer(pg.Companion.serializer());
    }

    @Override // com.pspdfkit.internal.ga
    public final Unit b() {
        return this.b;
    }

    @Override // com.pspdfkit.internal.ga
    public final SerializationStrategy<Unit> c() {
        return this.c;
    }

    @Override // com.pspdfkit.internal.ga
    public final NativeContentEditingCommand d() {
        return this.a;
    }

    @Override // com.pspdfkit.internal.ga
    public final DeserializationStrategy<List<? extends pg>> f() {
        return this.d;
    }
}

package io.opentelemetry.api.baggage.propagation;

import io.opentelemetry.api.baggage.BaggageBuilder;
import io.opentelemetry.api.baggage.BaggageEntryMetadata;
import java.nio.charset.StandardCharsets;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
class Parser {
    private final String baggageHeader;
    private String meta;
    private int metaStart;
    private boolean skipToNext;
    private State state;
    private final Element key = Element.createKeyElement();
    private final Element value = Element.createValueElement();

    private enum State {
        KEY,
        VALUE,
        META
    }

    public Parser(String str) {
        this.baggageHeader = str;
        reset(0);
    }

    void parseInto(BaggageBuilder baggageBuilder) {
        int length = this.baggageHeader.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = this.baggageHeader.charAt(i);
            if (this.skipToNext) {
                if (cCharAt == ',') {
                    reset(i + 1);
                }
            } else if (cCharAt == ',') {
                int i2 = AnonymousClass1.$SwitchMap$io$opentelemetry$api$baggage$propagation$Parser$State[this.state.ordinal()];
                if (i2 == 1) {
                    this.value.tryTerminating(i, this.baggageHeader);
                } else if (i2 == 2) {
                    this.meta = this.baggageHeader.substring(this.metaStart, i).trim();
                }
                putBaggage(baggageBuilder, this.key.getValue(), this.value.getValue(), this.meta);
                reset(i + 1);
            } else if (cCharAt != ';') {
                if (cCharAt == '=') {
                    if (this.state == State.KEY) {
                        if (this.key.tryTerminating(i, this.baggageHeader)) {
                            setState(State.VALUE, i + 1);
                        } else {
                            this.skipToNext = true;
                        }
                    } else if (this.state == State.VALUE) {
                        this.skipToNext = !this.value.tryNextChar(cCharAt, i);
                    }
                } else {
                    int i3 = AnonymousClass1.$SwitchMap$io$opentelemetry$api$baggage$propagation$Parser$State[this.state.ordinal()];
                    if (i3 == 1) {
                        this.skipToNext = !this.value.tryNextChar(cCharAt, i);
                    } else if (i3 == 3) {
                        this.skipToNext = !this.key.tryNextChar(cCharAt, i);
                    }
                }
            } else if (this.state == State.VALUE) {
                this.skipToNext = !this.value.tryTerminating(i, this.baggageHeader);
                setState(State.META, i + 1);
            }
        }
        int i4 = AnonymousClass1.$SwitchMap$io$opentelemetry$api$baggage$propagation$Parser$State[this.state.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                return;
            }
            putBaggage(baggageBuilder, this.key.getValue(), this.value.getValue(), this.baggageHeader.substring(this.metaStart).trim());
            return;
        }
        if (this.skipToNext) {
            return;
        }
        this.value.tryTerminating(this.baggageHeader.length(), this.baggageHeader);
        putBaggage(baggageBuilder, this.key.getValue(), this.value.getValue(), null);
    }

    /* JADX INFO: renamed from: io.opentelemetry.api.baggage.propagation.Parser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$opentelemetry$api$baggage$propagation$Parser$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$opentelemetry$api$baggage$propagation$Parser$State = iArr;
            try {
                iArr[State.VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$opentelemetry$api$baggage$propagation$Parser$State[State.META.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$opentelemetry$api$baggage$propagation$Parser$State[State.KEY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static void putBaggage(BaggageBuilder baggageBuilder, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        BaggageEntryMetadata baggageEntryMetadataEmpty;
        String strDecodeValue = decodeValue(str2);
        String strDecodeValue2 = decodeValue(str3);
        if (strDecodeValue2 != null) {
            baggageEntryMetadataEmpty = BaggageEntryMetadata.create(strDecodeValue2);
        } else {
            baggageEntryMetadataEmpty = BaggageEntryMetadata.empty();
        }
        if (str == null || strDecodeValue == null) {
            return;
        }
        baggageBuilder.put(str, strDecodeValue, baggageEntryMetadataEmpty);
    }

    @Nullable
    private static String decodeValue(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return BaggageCodec.decode(str, StandardCharsets.UTF_8);
    }

    private void reset(int i) {
        this.skipToNext = false;
        this.state = State.KEY;
        this.key.reset(i);
        this.value.reset(i);
        this.meta = "";
        this.metaStart = 0;
    }

    private void setState(State state, int i) {
        this.state = state;
        this.metaStart = i;
    }
}

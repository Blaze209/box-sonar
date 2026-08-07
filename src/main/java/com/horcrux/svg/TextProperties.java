package com.horcrux.svg;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.facebook.react.uimanager.ViewProps;
import com.microsoft.identity.common.java.marker.PerfConstants;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes14.dex */
class TextProperties {

    enum Direction {
        ltr,
        rtl
    }

    enum FontStyle {
        normal,
        italic,
        oblique
    }

    enum FontVariantLigatures {
        normal,
        none
    }

    enum TextAnchor {
        start,
        middle,
        end
    }

    enum TextLengthAdjust {
        spacing,
        spacingAndGlyphs
    }

    enum TextPathMethod {
        align,
        stretch
    }

    enum TextPathMidLine {
        sharp,
        smooth
    }

    enum TextPathSide {
        left,
        right
    }

    enum TextPathSpacing {
        auto,
        exact
    }

    TextProperties() {
    }

    enum AlignmentBaseline {
        baseline("baseline"),
        textBottom("text-bottom"),
        alphabetic("alphabetic"),
        ideographic("ideographic"),
        middle("middle"),
        central("central"),
        mathematical("mathematical"),
        textTop("text-top"),
        bottom(ViewProps.BOTTOM),
        center(TtmlNode.CENTER),
        top(ViewProps.TOP),
        textBeforeEdge("text-before-edge"),
        textAfterEdge("text-after-edge"),
        beforeEdge("before-edge"),
        afterEdge("after-edge"),
        hanging("hanging");

        private static final Map<String, AlignmentBaseline> alignmentToEnum = new HashMap();
        private final String alignment;

        static {
            for (AlignmentBaseline alignmentBaseline : values()) {
                alignmentToEnum.put(alignmentBaseline.alignment, alignmentBaseline);
            }
        }

        AlignmentBaseline(String str) {
            this.alignment = str;
        }

        static AlignmentBaseline getEnum(String str) {
            Map<String, AlignmentBaseline> map = alignmentToEnum;
            if (!map.containsKey(str)) {
                throw new IllegalArgumentException("Unknown String Value: " + str);
            }
            return map.get(str);
        }

        @Override // java.lang.Enum
        @Nonnull
        public String toString() {
            return this.alignment;
        }
    }

    enum FontWeight {
        Normal(SemanticAttributes.MessagingRocketmqMessageTypeValues.NORMAL),
        Bold("bold"),
        w100(PerfConstants.ScenarioConstants.SCENARIO_NON_BROKERED_ACQUIRE_TOKEN_SILENTLY),
        w200(PerfConstants.ScenarioConstants.SCENARIO_BROKERED_ACQUIRE_TOKEN_SILENTLY),
        w300(PerfConstants.ScenarioConstants.SCENARIO_GENERATE_AT_POP_ASYMMETRIC_KEYPAIR),
        w400("400"),
        w500("500"),
        w600("600"),
        w700("700"),
        w800("800"),
        w900("900"),
        Bolder("bolder"),
        Lighter("lighter");

        private static final Map<String, FontWeight> weightToEnum = new HashMap();
        private final String weight;

        static {
            for (FontWeight fontWeight : values()) {
                weightToEnum.put(fontWeight.weight, fontWeight);
            }
        }

        FontWeight(String str) {
            this.weight = str;
        }

        static boolean hasEnum(String str) {
            return weightToEnum.containsKey(str);
        }

        static FontWeight get(String str) {
            return weightToEnum.get(str);
        }

        @Override // java.lang.Enum
        @Nonnull
        public String toString() {
            return this.weight;
        }
    }

    enum TextDecoration {
        None("none"),
        Underline("underline"),
        Overline("overline"),
        LineThrough("line-through"),
        Blink("blink");

        private static final Map<String, TextDecoration> decorationToEnum = new HashMap();
        private final String decoration;

        static {
            for (TextDecoration textDecoration : values()) {
                decorationToEnum.put(textDecoration.decoration, textDecoration);
            }
        }

        TextDecoration(String str) {
            this.decoration = str;
        }

        static TextDecoration getEnum(String str) {
            Map<String, TextDecoration> map = decorationToEnum;
            if (!map.containsKey(str)) {
                throw new IllegalArgumentException("Unknown String Value: " + str);
            }
            return map.get(str);
        }

        @Override // java.lang.Enum
        @Nonnull
        public String toString() {
            return this.decoration;
        }
    }
}

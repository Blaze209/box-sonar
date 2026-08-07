package io.split.android.engine.experiments;

import io.split.android.client.dtos.Split;
import io.split.android.client.dtos.Status;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public class SplitParser implements Parser<Split, ParsedSplit> {
    private final ParserCommons mParserCommons;

    public SplitParser(ParserCommons parserCommons) {
        this.mParserCommons = (ParserCommons) Utils.checkNotNull(parserCommons);
    }

    public ParsedSplit parse(Split split) {
        return parse(split, (String) null);
    }

    @Override // io.split.android.engine.experiments.Parser
    public ParsedSplit parse(Split split, String matchingKey) {
        try {
            return parseWithoutExceptionHandling(split, matchingKey);
        } catch (Throwable th) {
            Logger.e(th, "Could not parse feature flag: %s", split != null ? split.name : AbstractJsonLexerKt.NULL);
            return null;
        }
    }

    private ParsedSplit parseWithoutExceptionHandling(Split split, String matchingKey) {
        List<ParsedCondition> parsedConditions;
        if (split == null || split.status != Status.ACTIVE || (parsedConditions = this.mParserCommons.getParsedConditions(matchingKey, split.conditions, "Dropping feature flag name=" + split.name + " due to large number of conditions (" + split.conditions.size() + ")")) == null) {
            return null;
        }
        return new ParsedSplit(split.name, split.seed, split.killed, split.defaultTreatment, parsedConditions, split.trafficTypeName, split.changeNumber, split.trafficAllocation.intValue(), split.trafficAllocationSeed.intValue(), split.algo, split.configurations, split.sets, split.impressionsDisabled, new ArrayList(split.getPrerequisites()));
    }
}

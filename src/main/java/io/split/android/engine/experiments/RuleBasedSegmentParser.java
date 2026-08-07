package io.split.android.engine.experiments;

import io.split.android.client.dtos.Condition;
import io.split.android.client.dtos.Excluded;
import io.split.android.client.dtos.RuleBasedSegment;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class RuleBasedSegmentParser implements Parser<RuleBasedSegment, ParsedRuleBasedSegment> {
    private final ParserCommons mParserCommons;

    public RuleBasedSegmentParser(ParserCommons parserCommons) {
        this.mParserCommons = parserCommons;
    }

    @Override // io.split.android.engine.experiments.Parser
    public ParsedRuleBasedSegment parse(RuleBasedSegment input, String matchingKey) {
        String name = input.getName();
        Excluded excluded = input.getExcluded();
        List<Condition> conditions = input.getConditions();
        List<ParsedCondition> parsedConditions = this.mParserCommons.getParsedConditions(matchingKey, conditions, "Dropping rule based segment name=" + name + " due to large number of conditions (" + conditions.size() + ")");
        if (parsedConditions == null) {
            parsedConditions = new ArrayList<>();
        }
        List<ParsedCondition> list = parsedConditions;
        if (excluded == null) {
            excluded = Excluded.createEmpty();
        }
        return new ParsedRuleBasedSegment(name, excluded.getKeys(), excluded.getSegments(), list, input.getTrafficTypeName(), input.getChangeNumber());
    }
}

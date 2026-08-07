package io.split.android.client.storage.common;

import io.split.android.client.storage.mysegments.MySegmentsStorageContainer;
import io.split.android.client.storage.rbs.PersistentRuleBasedSegmentStorage;
import io.split.android.client.storage.rbs.RuleBasedSegmentStorage;
import io.split.android.client.storage.rbs.RuleBasedSegmentStorageImpl;
import io.split.android.engine.experiments.ParserCommons;
import io.split.android.engine.experiments.RuleBasedSegmentParser;

/* JADX INFO: loaded from: classes4.dex */
class RuleBasedSegmentStorageInitializer {
    RuleBasedSegmentStorageInitializer() {
    }

    static Result initialize(MySegmentsStorageContainer mySegmentsStorageContainer, MySegmentsStorageContainer myLargeSegmentsStorageContainer, PersistentRuleBasedSegmentStorage persistentRuleBasedSegmentStorage) {
        ParserCommons parserCommons = new ParserCommons(mySegmentsStorageContainer, myLargeSegmentsStorageContainer);
        return initialize(parserCommons, new RuleBasedSegmentStorageImpl(persistentRuleBasedSegmentStorage, new RuleBasedSegmentParser(parserCommons)));
    }

    static Result initialize(ParserCommons parserCommons, RuleBasedSegmentStorage ruleBasedSegmentStorage) {
        parserCommons.setRuleBasedSegmentStorage(ruleBasedSegmentStorage);
        return new Result(ruleBasedSegmentStorage, parserCommons);
    }

    static class Result {
        private final ParserCommons mParserCommons;
        private final RuleBasedSegmentStorage mRuleBasedSegmentStorage;

        Result(RuleBasedSegmentStorage ruleBasedSegmentStorage, ParserCommons parserCommons) {
            this.mRuleBasedSegmentStorage = ruleBasedSegmentStorage;
            this.mParserCommons = parserCommons;
        }

        ParserCommons getParserCommons() {
            return this.mParserCommons;
        }

        RuleBasedSegmentStorage getRuleBasedSegmentStorage() {
            return this.mRuleBasedSegmentStorage;
        }
    }
}

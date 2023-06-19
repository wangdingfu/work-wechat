package com.wdf.response.kf;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wdf.dto.kf.IntentAnswer;
import com.wdf.dto.kf.IntentQuestion;
import com.wdf.dto.kf.SimilarQuestion;
import com.wdf.response.BaseResponse;

import java.util.List;
import java.util.StringJoiner;

/**
 * @author ddshuai
 * date 2022-09-01 17:31
 **/
public class KnowledgeIntentResponse extends BaseResponse {

    @JsonProperty(value = "intent_list")
    private List<IntentItem> intentItems;

    public static class IntentItem {
        @JsonProperty(value = "group_id")
        private String groupId;

        @JsonProperty(value = "intent_id")
        private String intentId;

        private IntentQuestion question;

        @JsonProperty(value = "similar_questions")
        private SimilarQuestion similarQuestions;

        private List<IntentAnswer> answers;

        public String getGroupId() {
            return groupId;
        }

        public void setGroupId(String groupId) {
            this.groupId = groupId;
        }

        public IntentQuestion getQuestion() {
            return question;
        }

        public void setQuestion(IntentQuestion question) {
            this.question = question;
        }

        public SimilarQuestion getSimilarQuestions() {
            return similarQuestions;
        }

        public void setSimilarQuestions(SimilarQuestion similarQuestions) {
            this.similarQuestions = similarQuestions;
        }

        public List<IntentAnswer> getAnswers() {
            return answers;
        }

        public void setAnswers(List<IntentAnswer> answers) {
            this.answers = answers;
        }

        public String getIntentId() {
            return intentId;
        }

        public void setIntentId(String intentId) {
            this.intentId = intentId;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", IntentItem.class.getSimpleName() + "[", "]")
                    .add("groupId='" + groupId + "'")
                    .add("intentId='" + intentId + "'")
                    .add("question=" + question)
                    .add("similarQuestions=" + similarQuestions)
                    .add("answers=" + answers)
                    .toString();
        }
    }

    public List<IntentItem> getIntentItems() {
        return intentItems;
    }

    public void setIntentItems(List<IntentItem> intentItems) {
        this.intentItems = intentItems;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", KnowledgeIntentResponse.class.getSimpleName() + "[", "]")
                .add("intentItems=" + intentItems)
                .toString();
    }
}

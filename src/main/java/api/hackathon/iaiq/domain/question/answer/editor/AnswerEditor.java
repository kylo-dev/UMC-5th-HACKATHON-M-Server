package api.hackathon.iaiq.domain.question.answer.editor;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

@Getter
@RequiredArgsConstructor
public class AnswerEditor {
    private final String content;
    private final String formatDate;

    public static AnswerEditorBuilder builder() {
        return new AnswerEditorBuilder();
    }

    public static class AnswerEditorBuilder {
        private String content;
        private String formatDate;

        AnswerEditorBuilder() {
        }

        public AnswerEditorBuilder content(final String content) {
            if (StringUtils.hasText(content)) {
                this.content = content;
            }
            return this;
        }

        public AnswerEditorBuilder formatDate(final String formatDate) {
            if (StringUtils.hasText(formatDate)) {
                this.formatDate = formatDate;
            }
            return this;
        }

        public AnswerEditor build() {
            return new AnswerEditor(content, formatDate);
        }
    }
}

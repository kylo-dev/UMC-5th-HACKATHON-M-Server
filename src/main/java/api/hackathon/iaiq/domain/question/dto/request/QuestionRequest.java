package api.hackathon.iaiq.domain.question.dto.request;

import api.hackathon.iaiq.domain.question.domain.Category;
import api.hackathon.iaiq.global.exception.ApiException;
import api.hackathon.iaiq.global.exception.ErrorType;
import io.swagger.v3.oas.annotations.media.Schema;

public class QuestionRequest {

    @Schema(description = "카테고리 종류", example = "9가지 중 하나")
    private String category;

    public Category getCategory() {
        try {
            return Category.valueOf(category.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ApiException(ErrorType._CATEGORY_INVALID_REQUEST);
        }
    }
}
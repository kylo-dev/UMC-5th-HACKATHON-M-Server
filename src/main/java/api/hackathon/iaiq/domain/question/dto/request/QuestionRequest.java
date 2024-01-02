package api.hackathon.iaiq.domain.question.dto.request;

import api.hackathon.iaiq.domain.question.domain.Category;
import api.hackathon.iaiq.global.exception.ApiException;
import api.hackathon.iaiq.global.exception.ErrorType;

public class QuestionRequest {
    private String category;

    public Category getCategory() {
        try {
            return Category.valueOf(category.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ApiException(ErrorType._CATEGORY_INVALID_REQUEST);
        }
    }
}
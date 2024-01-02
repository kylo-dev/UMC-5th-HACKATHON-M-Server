package api.hackathon.iaiq.domain.question.controller;

import api.hackathon.iaiq.domain.question.dto.request.QuestionRequest;
import api.hackathon.iaiq.domain.question.dto.request.QuestionResponse;
import api.hackathon.iaiq.domain.question.service.QuestionService;
import api.hackathon.iaiq.global.success.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/question")
    public SuccessResponse<QuestionResponse> getQuestion(@RequestBody QuestionRequest questionRequest) {
        QuestionResponse response = questionService.findByCategory(questionRequest);
        return new SuccessResponse<>(response);
    }
}

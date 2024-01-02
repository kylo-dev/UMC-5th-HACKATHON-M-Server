package api.hackathon.iaiq.domain.question.controller;

import api.hackathon.iaiq.domain.question.answer.dto.request.AnswerRequest;
import api.hackathon.iaiq.domain.question.answer.dto.response.AnswerResponse;
import api.hackathon.iaiq.domain.question.dto.request.QuestionRequest;
import api.hackathon.iaiq.domain.question.dto.request.QuestionResponse;
import api.hackathon.iaiq.domain.question.service.QuestionService;
import api.hackathon.iaiq.global.success.SuccessResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/question")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @Operation(summary = "질문 생성", description = "랜덤한 질문을 뽑습니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "질문 생성 성공",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = QuestionResponse.class)))
    })
    @GetMapping
    public SuccessResponse<QuestionResponse> getQuestion(@RequestBody QuestionRequest questionRequest) {
        QuestionResponse response = questionService.findByCategory(questionRequest);
        return new SuccessResponse<>(response);
    }

    @Operation(summary = "질문에 대한 답 생성", description = "질문에 대한 답을 작성합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "답변 생성 성공",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = AnswerResponse.class)))
    })
    @PostMapping("/answer")
    public SuccessResponse<AnswerResponse> register(@RequestBody AnswerRequest answerRequest) {
        AnswerResponse response = questionService.register(answerRequest);
        return new SuccessResponse<>(response);
    }

    @Operation(summary = "질문에 대한 답 수정", description = "질문에 대한 답변을 수정합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "답변 수정 성공",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = AnswerResponse.class)))
    })
    @PatchMapping("/answer/{answerId}")
    public SuccessResponse<AnswerResponse> edit(@PathVariable Long answerId,
                                                @RequestBody AnswerRequest answerRequest) {
        AnswerResponse response = questionService.edit(answerId, answerRequest);
        return new SuccessResponse<>(response);
    }
}

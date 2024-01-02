package api.hackathon.iaiq.domain.question.controller;

import api.hackathon.iaiq.domain.question.answer.dto.request.AnswerRequest;
import api.hackathon.iaiq.domain.question.answer.dto.response.AnswerListResponse;
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
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    @Operation(summary = "카테고리로 질문 뽑기", description = "랜덤한 질문을 뽑습니다.")
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

    @Operation(summary = "질문에 대한 답 조회", description = "질문에 대한 답을 페이징처리하여 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "답변 조회 성공",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = AnswerListResponse.class)))
    })
    @GetMapping("/answer")
    public SuccessResponse<AnswerListResponse> find(Pageable pageable) {
        AnswerListResponse response = questionService.findPaging(pageable);
        return new SuccessResponse<>(response);
    }


    @Operation(summary = "질문에 대한 답 단건 조회", description = "질문에 대한 답을 단건 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "답변 단건 조회 성공",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = AnswerResponse.class)))
    })
    @GetMapping("/answer/{answerId}")
    public SuccessResponse<AnswerResponse> find(@PathVariable Long answerId) {
        AnswerResponse response = questionService.findById(answerId);
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


    @Operation(summary = "질문에 대한 답 삭제", description = "질문에 대한 답변을 삭제합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "답변 삭제 성공",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Long.class)))
    })
    @DeleteMapping("/answer/{answerId}")
    public SuccessResponse<Long> delete(@PathVariable Long answerId) {
        Long deleteId = questionService.delete(answerId);
        return new SuccessResponse<>(deleteId);
    }
}

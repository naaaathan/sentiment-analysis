package com.llm.sentiment.analysis.sentiment_analysis_application.controller

import com.llm.sentiment.analysis.sentiment_task_orchestrator.RawTextOrchestrator
import com.llm.sentiment.analysis.sentiment_analysis_application.data.ProcessedTextStreamResponse
import com.llm.sentiment.analysis.sentiment_analysis_application.data.TextProcessData
import org.springframework.ai.chat.model.ChatResponse
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import java.time.Duration

@RestController
@RequestMapping("/text-processor")
class TextProcessorController(
    private val rawTextOrchestrator: RawTextOrchestrator
) {

    @PostMapping("/start-process-text", produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun startProcessText(@RequestBody textData: TextProcessData): Flux<ChatResponse> {
        return rawTextOrchestrator.orchestrate(
                textData.text,
                textData.task.name
            ).fluxResponse.delayElements(Duration.ofMillis(500))
    }

    @GetMapping("/text-processor/{taskId}")
    fun getProcessTaskStream(@PathVariable("taskId") taskId: String): Flux<ProcessedTextStreamResponse> {
        return Flux.fromIterable(listOf(ProcessedTextStreamResponse("1", "2")))
    }


}
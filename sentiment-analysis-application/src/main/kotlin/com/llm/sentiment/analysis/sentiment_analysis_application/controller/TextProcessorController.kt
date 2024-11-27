package com.llm.sentiment.analysis.sentiment_analysis_application.controller

import com.llm.sentiment.analysis.sentiment_task_orchestrator.RawTextOrchestrator
import com.llm.sentiment.analysis.sentiment_analysis_application.data.ProcessedTextStreamResponse
import com.llm.sentiment.analysis.sentiment_analysis_application.data.TaskProcessResponse
import com.llm.sentiment.analysis.sentiment_analysis_application.data.TextProcessData
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import reactor.core.publisher.Flux

@Controller("/text-processor")
class TextProcessorController(
    private val rawTextOrchestrator: RawTextOrchestrator
) {

    @PostMapping("/start-process-text")
    fun startProcessText(textData: TextProcessData): TaskProcessResponse {
        return TaskProcessResponse(
            rawTextOrchestrator.orchestrate(
                textData.text,
                textData.task.name
            ).taskId
        )
    }

    @GetMapping("/text-processor/{taskId}")
    fun getProcessTaskStream(@PathVariable("taskId") taskId: String): Flux<ProcessedTextStreamResponse> {
        return Flux.fromIterable(listOf(ProcessedTextStreamResponse("1", "2")))
    }


}
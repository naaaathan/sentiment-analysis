package com.llm.sentiment.analysis.sentiment_analysis_application.controller

import com.llm.sentiment.analysis.sentiment_task_orchestrator.RawTextOrchestrator
import com.llm.sentiment.analysis.sentiment_analysis_application.data.TextProcessData
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
    fun startProcessText(@RequestBody textData: TextProcessData): Flux<String?> {

        return rawTextOrchestrator.orchestrate(
            textData.text,
            textData.task.name
        ).fluxResponse
            .mapNotNull { it.result.output.content }
            .filter {it.isNotBlank() }
            .map { it.trim().replace(Regex("\\s+"), " ") }
            .bufferUntil( { it.endsWith(".") }) //Bufferizar até encontrar uma frase completa que termine com .
            .map { it.joinToString(" ") }
            .delayElements(Duration.ofMillis(100))
            .onErrorResume { throwable ->
                Flux.just("Error: ${throwable.message}")
            }
            .concatWith(Flux.just("Stream Completed"))
    }

}
package com.llm.sentiment.analysis.sentiment_task_orchestrator.strategy

import com.llm.sentiment.analysis.sentiment_llm_engine.SummarizeTextPrompt
import org.springframework.ai.chat.model.ChatResponse
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
class SummaryStrategy(
    private val summaryTextPrompt: SummarizeTextPrompt
) : Strategy {
    override fun execute(text: String): Flux<ChatResponse> {
        return summaryTextPrompt.callModel(text)
    }
}
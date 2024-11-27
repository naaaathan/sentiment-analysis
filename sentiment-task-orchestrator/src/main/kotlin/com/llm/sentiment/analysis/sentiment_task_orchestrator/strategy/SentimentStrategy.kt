package com.llm.sentiment.analysis.sentiment_task_orchestrator.strategy

import com.llm.sentiment.analysis.sentiment_llm_engine.AnalyzeSentimentPrompt
import org.springframework.ai.chat.model.ChatResponse
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
class SentimentStrategy(
    private val analyzeSentimentPrompt: AnalyzeSentimentPrompt
) : Strategy {
    override fun execute(text: String) : Flux<ChatResponse> {
        return analyzeSentimentPrompt.callModel(text)
    }

}
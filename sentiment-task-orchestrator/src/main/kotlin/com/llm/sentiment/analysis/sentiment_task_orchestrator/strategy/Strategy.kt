package com.llm.sentiment.analysis.sentiment_task_orchestrator.strategy

import org.springframework.ai.chat.model.ChatResponse
import reactor.core.publisher.Flux

interface Strategy {
    fun execute(text: String): Flux<ChatResponse>
}
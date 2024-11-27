package com.llm.sentiment.analysis.sentiment_task_orchestrator

import com.llm.sentiment.analysis.sentiment_task_orchestrator.strategy.Strategy
import org.springframework.ai.chat.model.ChatResponse
import reactor.core.publisher.Flux

data class ChainData(
    val text: String = "",
    val task: String = "",
    var chunkList: List<String> = emptyList(),
    var fluxResponse: Flux<ChatResponse> = Flux.empty(),
    var strategy: Strategy? = null
)
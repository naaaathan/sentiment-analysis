package com.llm.sentiment.analysis.sentiment_task_orchestrator

import org.springframework.ai.chat.model.ChatResponse
import reactor.core.publisher.Flux

data class TextOrchestratorData(val fluxResponse: Flux<ChatResponse>)

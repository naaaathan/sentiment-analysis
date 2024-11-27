package com.llm.sentiment.analysis.sentiment_task_orchestrator

import com.llm.sentiment.analysis.sentiment_task_orchestrator.handlers.TextHandlerChain
import org.springframework.stereotype.Service

@Service
class RawTextOrchestrator(
    private val textHandlerChain: TextHandlerChain,
) {

    fun orchestrate(text: String, task: String): TextOrchestratorData {

        val chainData = ChainData(text = text, task = task)
        textHandlerChain.handle(chainData)

        return TextOrchestratorData(chainData.fluxResponse)
    }

}
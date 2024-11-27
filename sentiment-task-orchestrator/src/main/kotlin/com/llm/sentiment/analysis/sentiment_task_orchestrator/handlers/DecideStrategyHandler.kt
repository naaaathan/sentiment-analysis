package com.llm.sentiment.analysis.sentiment_task_orchestrator.handlers

import com.llm.sentiment.analysis.sentiment_task_orchestrator.ChainData
import com.llm.sentiment.analysis.sentiment_task_orchestrator.TextOrchestratorData
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Component
@Order(2)
class DecideStrategyHandler: TextProcessorHandler {

    private val textProcessorHandler : TextProcessorHandler? = null

    override fun handle(chainData: ChainData) : TextOrchestratorData {
        return textProcessorHandler?.handle(chainData)!!
    }

    override fun setNextHandler(nextHandler: TextProcessorHandler) {
        textProcessorHandler?.setNextHandler(nextHandler)
    }
}
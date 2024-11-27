package com.llm.sentiment.analysis.sentiment_task_orchestrator.handlers

import com.llm.sentiment.analysis.sentiment_task_orchestrator.ChainData
import com.llm.sentiment.analysis.sentiment_task_orchestrator.TextOrchestratorData

class TextHandlerChain(
    firstHandler: TextProcessorHandler
) {

    private var textProcessorHandler: TextProcessorHandler? = null

    init {
        this.textProcessorHandler = firstHandler
    }

    fun handle(chainData: ChainData) : TextOrchestratorData {
        return textProcessorHandler?.handle(chainData)!!
    }


}
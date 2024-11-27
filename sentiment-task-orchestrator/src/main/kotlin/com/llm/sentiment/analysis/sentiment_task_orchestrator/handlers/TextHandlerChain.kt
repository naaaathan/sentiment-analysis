package com.llm.sentiment.analysis.sentiment_task_orchestrator.handlers

import com.llm.sentiment.analysis.sentiment_task_orchestrator.ChainData

class TextHandlerChain(
    firstHandler: TextProcessorHandler
) {

    private var textProcessorHandler: TextProcessorHandler? = null

    init {
        this.textProcessorHandler = firstHandler
    }

    fun handle(chainData: ChainData) {
        return textProcessorHandler?.handle(chainData)!!
    }


}
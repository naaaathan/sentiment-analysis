package com.llm.sentiment.analysis.sentiment_task_orchestrator.handlers

import com.llm.sentiment.analysis.sentiment_task_orchestrator.ChainData
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component


@Component
@Order(3)
class ProcessChunksHandler : TextProcessorHandler {

    private lateinit var textProcessorHandler: TextProcessorHandler

    override fun handle(chainData: ChainData) {

        val flowResponse = chainData.strategy?.execute(chainData.text)

        if (flowResponse != null)
            chainData.fluxResponse = flowResponse

        if (::textProcessorHandler.isInitialized) {
            textProcessorHandler.handle(chainData)
        }
    }

    override fun setNextHandler(nextHandler: TextProcessorHandler) {
        textProcessorHandler = nextHandler
    }
}
package com.llm.sentiment.analysis.sentiment_task_orchestrator.handlers

import com.llm.sentiment.analysis.sentiment_llm_engine.SplitChunksText
import com.llm.sentiment.analysis.sentiment_task_orchestrator.ChainData
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Component
@Order(1)
class SplitChunksHandler(
    private val splitChunksText: SplitChunksText
) : TextProcessorHandler {

    private lateinit var textProcessorHandler: TextProcessorHandler

    override fun handle(chainData: ChainData) {

        val chunkList = splitChunksText.transformTextInChunks(text = chainData.text, chunkSize = CHUNK_SIZE)
        chainData.chunkList = chunkList

        if (::textProcessorHandler.isInitialized) {
            textProcessorHandler.handle(chainData)
        }
    }

    override fun setNextHandler(nextHandler: TextProcessorHandler) {
        textProcessorHandler = nextHandler
    }

    companion object {
        const val CHUNK_SIZE = 10
    }


}
package com.llm.sentiment.analysis.sentiment_task_orchestrator.handlers

import com.llm.sentiment.analysis.sentiment_llm_engine.SplitChunksText
import com.llm.sentiment.analysis.sentiment_task_orchestrator.ChainData
import com.llm.sentiment.analysis.sentiment_task_orchestrator.TextOrchestratorData
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Component
@Order(1)
class SplitChunksHandler(
    private val splitChunksText: SplitChunksText
): TextProcessorHandler {

    private val textProcessorHandler : TextProcessorHandler? = null

    override fun handle(chainData: ChainData) : TextOrchestratorData {

        val chunkList = splitChunksText.transformTextInChunks(text = chainData.text, chunkSize = CHUNK_SIZE)
        chainData.chunkList = chunkList

        return textProcessorHandler?.handle(chainData)!!
    }

    override fun setNextHandler(nextHandler: TextProcessorHandler) {
        textProcessorHandler?.setNextHandler(nextHandler)
    }

    companion object {
        const val CHUNK_SIZE = 10
    }


}
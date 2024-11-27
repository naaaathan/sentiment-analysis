package com.llm.sentiment.analysis.sentiment_task_orchestrator.handlers

import com.llm.sentiment.analysis.sentiment_task_orchestrator.strategy.SentimentStrategy
import com.llm.sentiment.analysis.sentiment_task_orchestrator.strategy.SummaryStrategy
import com.llm.sentiment.analysis.sentiment_task_orchestrator.ChainData
import com.llm.sentiment.analysis.sentiment_task_orchestrator.TextOrchestratorData
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Component
@Order(3)
class ProcessChunksHandler(
    private val sentimentStrategy: SentimentStrategy,
    private val summaryStrategy: SummaryStrategy
) : TextProcessorHandler {

    private val textProcessorHandler: TextProcessorHandler? = null

    override fun handle(chainData: ChainData): TextOrchestratorData {

        val strategy = when (chainData.task) {
            "SUMMARY" -> summaryStrategy
            "SENTIMENT" -> sentimentStrategy
            else -> throw IllegalArgumentException("Invalid task")
        }

        strategy.execute()

        return textProcessorHandler?.handle(chainData)!!
    }

    override fun setNextHandler(nextHandler: TextProcessorHandler) {
        textProcessorHandler?.setNextHandler(nextHandler)
    }
}
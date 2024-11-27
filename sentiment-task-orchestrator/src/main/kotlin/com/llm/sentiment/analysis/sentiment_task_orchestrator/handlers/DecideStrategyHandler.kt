package com.llm.sentiment.analysis.sentiment_task_orchestrator.handlers

import com.llm.sentiment.analysis.sentiment_task_orchestrator.ChainData
import com.llm.sentiment.analysis.sentiment_task_orchestrator.strategy.SentimentStrategy
import com.llm.sentiment.analysis.sentiment_task_orchestrator.strategy.SummaryStrategy
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Component
@Order(2)
class DecideStrategyHandler(
    private val sentimentStrategy: SentimentStrategy,
    private val summaryStrategy: SummaryStrategy
) : TextProcessorHandler {

    private lateinit var textProcessorHandler: TextProcessorHandler

    override fun handle(chainData: ChainData) {

        val strategy = when (chainData.task) {
            "SUMMARIZE" -> summaryStrategy
            "SENTIMENT" -> sentimentStrategy
            else -> throw IllegalArgumentException("Invalid task")
        }

        chainData.strategy = strategy

        if (::textProcessorHandler.isInitialized) {
            textProcessorHandler.handle(chainData)
        }
    }

    override fun setNextHandler(nextHandler: TextProcessorHandler) {
        textProcessorHandler = nextHandler
    }
}
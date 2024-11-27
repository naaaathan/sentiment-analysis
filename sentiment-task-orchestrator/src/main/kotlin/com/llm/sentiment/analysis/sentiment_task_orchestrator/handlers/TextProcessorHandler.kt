package com.llm.sentiment.analysis.sentiment_task_orchestrator.handlers

import com.llm.sentiment.analysis.sentiment_task_orchestrator.ChainData
import com.llm.sentiment.analysis.sentiment_task_orchestrator.TextOrchestratorData

interface TextProcessorHandler {
    fun handle(chainData: ChainData) : TextOrchestratorData
    fun setNextHandler(nextHandler: TextProcessorHandler)
}
package com.llm.sentiment.analysis.sentiment_task_orchestrator.handlers

import com.llm.sentiment.analysis.sentiment_task_orchestrator.ChainData

interface TextProcessorHandler {
    fun handle(chainData: ChainData)
    fun setNextHandler(nextHandler: TextProcessorHandler)
}
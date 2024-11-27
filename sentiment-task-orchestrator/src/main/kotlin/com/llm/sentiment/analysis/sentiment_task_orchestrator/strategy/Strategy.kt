package com.llm.sentiment.analysis.sentiment_task_orchestrator.strategy

interface Strategy {
    fun execute(): String
}
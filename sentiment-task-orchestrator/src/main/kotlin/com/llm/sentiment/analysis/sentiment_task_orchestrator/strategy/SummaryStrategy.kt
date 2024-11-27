package com.llm.sentiment.analysis.sentiment_task_orchestrator.strategy

import org.springframework.stereotype.Component

@Component
class SummaryStrategy : Strategy {
    override fun execute(): String {
        return "Executing Summary Strategy"
    }
}
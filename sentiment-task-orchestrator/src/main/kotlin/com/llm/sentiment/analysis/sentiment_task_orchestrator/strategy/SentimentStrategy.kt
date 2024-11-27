package com.llm.sentiment.analysis.sentiment_task_orchestrator.strategy

import org.springframework.stereotype.Component

@Component
class SentimentStrategy : Strategy {
    override fun execute() : String {
        return "Executing Sentiment Strategy"
    }

}
package com.llm.sentiment.analysis.sentiment_analysis_application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = [
	"com.llm.sentiment.analysis.sentiment_analysis_application",
	"com.llm.sentiment.analysis.sentiment_task_orchestrator",
	"com.llm.sentiment.analysis.sentiment_llm_engine"
])
class SentimentAnalysisApplication

fun main(args: Array<String>) {
	runApplication<SentimentAnalysisApplication>(*args)
}

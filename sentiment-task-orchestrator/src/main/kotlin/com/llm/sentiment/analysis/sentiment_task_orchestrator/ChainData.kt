package com.llm.sentiment.analysis.sentiment_task_orchestrator

data class ChainData(val text: String, val task: String, var chunkList: List<String>)

package com.llm.sentiment.analysis.sentiment_analysis_application.data

data class ProcessedTextStreamResponse(
    val chunkId : String,
    val summarizedText: String? = null,
    val sentiment : String? = null,
)

package com.llm.sentiment.analysis.sentiment_analysis_application.data

import com.llm.sentiment.analysis.sentiment_analysis_application.data.enums.Task

data class TextProcessData(val text: String, val task: Task){
    override fun toString(): String {
        return "TextProcessData(text='$text', task=$task)"
    }
}

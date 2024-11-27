package com.llm.sentiment.analysis.sentiment_llm_engine

import org.springframework.stereotype.Component

@Component
class SplitChunksText {

    fun transformTextInChunks(text: String, chunkSize: Int): List<String> {
        val chunks = mutableListOf<String>()
        val words = text.split(" ")
        var chunk = ""
        for (word in words) {
            if (chunk.length + word.length < chunkSize) {
                chunk += "$word "
            } else {
                chunks.add(chunk)
                chunk = "$word "
            }
        }
        chunks.add(chunk)
        return chunks
    }
}
package sentiment_analysis_application

import com.llm.sentiment.analysis.sentiment_analysis_application.SentimentAnalysisApplication
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [SentimentAnalysisApplication::class])
class SentimentAnalysisApplicationTests {

	@Test
	fun contextLoads() {
	}

}

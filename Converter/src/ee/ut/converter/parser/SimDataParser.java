package ee.ut.converter.parser;

import java.util.HashMap;

public interface SimDataParser {

	public String getTaskDuration(String id);

	public HashMap<String,String> getDistribution(String id);

	public String getTotalTokens();

	public String getTokensPerBundle();

	public String getStartTime();

	public String getEndTime();
}

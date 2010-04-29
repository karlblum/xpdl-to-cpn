package ee.ut.converter.parser;

import java.util.HashMap;

public interface SimDataParser {

	public String getTaskDuration(String id);

	public HashMap<String, String> getDistribution(String id);

	public String getTotalTokens();

	public String getTokensPerBundle();

	public String getStartTime();

	public String getEndTime();

	public String getWaitTimeDuration(String elementId);

	public String getResources(String elementId);

	public HashMap<String, Integer> getResourceData();

	public String getTimeBetweenBundles();

	public int getBoundEventProbability(String elementId);
}

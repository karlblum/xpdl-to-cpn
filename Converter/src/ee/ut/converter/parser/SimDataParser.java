package ee.ut.converter.parser;

import java.util.HashMap;

/**
 * @author karl
 * 
 *         Interface for the simulation data parser.
 * 
 */
public interface SimDataParser {

	/**
	 * Method returns the task duration.
	 * 
	 * @param id
	 *            Task identifier.
	 * @return Task duration.
	 */
	public String getTaskDuration(String id);

	/**
	 * Gets the branching probability distribution.
	 * 
	 * @param id
	 *            Branching element identifier.
	 * @return HashMap of branchings.
	 */
	public HashMap<String, String> getDistribution(String id);

	/**
	 * Gets the total number of simulation tokens.
	 * 
	 * @return Total number of tokens.
	 */
	public String getTotalTokens();

	/**
	 * Gets the number of tokens in a bundle.
	 * 
	 * @return Tokens in a bundle.
	 */
	public String getTokensPerBundle();

	/**
	 * Method returns the simulation start date and time.
	 * 
	 * @return Start date and time.
	 */
	public String getStartTime();

	/**
	 * Method returns the simulation end date and time.
	 * 
	 * @return End date and time.
	 */
	public String getEndTime();

	/**
	 * Method returns the name of the resources used by the given acitivity.
	 * 
	 * @param elementId
	 *            Activity element identifier.
	 * @return Used resource name.
	 */
	public String getResources(String elementId);

	/**
	 * Method returns the amount of available resources.
	 * 
	 * @return Number and type of resources.
	 */
	public HashMap<String, Integer> getResourceData();

	/**
	 * Method returns the time delay between bundles.
	 * 
	 * @return Time between bundles.
	 */
	public String getTimeBetweenBundles();

	/**
	 * Method returns the probability for message arrival for bound event.
	 * 
	 * @param elementId
	 *            Bound event.
	 * @return Probability of receiving the message.
	 */
	public int getBoundMessageEventProbability(String elementId);

	/**
	 * Boundary timer time.
	 * 
	 * @param elementId
	 *            Boundary element.
	 * @return Time.
	 */
	public int getBoundTimer(String elementId);

	/**
	 * Whether or not the simulation data is included.
	 * 
	 * @return
	 */
	public boolean hasData();

	/**
	 * Time for receiving a message.
	 * 
	 * @param elementId
	 *            Message event.
	 * @return Time for message arrival.
	 */
	public String getMessageTime(String elementId);
}

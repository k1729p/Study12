package kp.cdi.alternatives;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.inject.Inject;

/**
 * The implementation of the {@link BasicBean} with Qualifier '@Script'.
 * <p>
 * Uses the Unicode Mathematical Alphanumeric Symbols.
 */
@Script
public class BasicBeanImplScript implements BasicBean {
	@Inject
	private Logger logger;

	@Inject
	private List<List<String>> report;

	private static final String CLASS_NAME = BasicBeanImplScript.class.getSimpleName();

	/**
	 * The constructor.
	 */
	public BasicBeanImplScript() {
		super();
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void show(String content) {

		final String asScript = content.toUpperCase().replace("A", "𝒜").replace("B", "ℬ").replace("C", "𝒞")
				.replace("D", "𝒟").replace("E", "ℰ").replace("F", "ℱ").replace("G", "𝒢").replace("H", "ℋ")
				.replace("I", "ℐ").replace("J", "𝒥").replace("K", "𝒦").replace("L", "ℒ").replace("M", "ℳ")
				.replace("N", "𝒩").replace("O", "𝒪").replace("P", "𝒫").replace("Q", "𝒬").replace("R", "ℛ")
				.replace("S", "𝒮").replace("T", "𝒯").replace("U", "𝒰").replace("V", "𝒱").replace("W", "𝒲")
				.replace("X", "𝒳").replace("Y", "𝒴").replace("Z", "𝒵");

		report.add(List.of(CLASS_NAME, "show", String.format("content[%s]", asScript)));
		if (logger.isLoggable(Level.INFO)) {
			logger.info(String.format("show(): content[%s]", content));
		}
	}
}
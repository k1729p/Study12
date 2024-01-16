package kp.cdi;

import static kp.cdi.producers.ForeseeableDate.NEAR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

import jakarta.enterprise.event.Event;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Instance;
import jakarta.enterprise.util.AnnotationLiteral;
import jakarta.inject.Inject;
import kp.cdi.alternatives.BasicBean;
import kp.cdi.alternatives.Script;
import kp.cdi.decorators.PlainBean;
import kp.cdi.events.Payload;
import kp.cdi.interceptors.ElapsedBean;
import kp.cdi.producers.Foreseeable;

/**
 * The bean for CDI research.
 *
 */
public class ResearchCDIBean {

	/**
	 * The constructor.
	 */
	public ResearchCDIBean() {
		super();
	}

	@SuppressWarnings("java:S6813") // switch off Sonarqube rule 'Avoid field dependency injection'
	@Inject
	private Logger logger;

	@SuppressWarnings("java:S6813") // switch off Sonarqube rule 'Avoid field dependency injection'
	@Inject
	private List<List<String>> report;

	@SuppressWarnings("java:S6813") // switch off Sonarqube rule 'Avoid field dependency injection'
	@Inject
	private ResearchCDIHelper researchCDIHelper;

	@SuppressWarnings("java:S6813") // switch off Sonarqube rule 'Avoid field dependency injection'
	@Inject
	private BasicBean basicBean;

	@SuppressWarnings("java:S6813") // switch off Sonarqube rule 'Avoid field dependency injection'
	@Inject
	@Script
	private BasicBean basicBeanWithQualifier;

	@SuppressWarnings("java:S6813") // switch off Sonarqube rule 'Avoid field dependency injection'
	@Inject
	@Any
	private Instance<BasicBean> basicBeanInstance;

	@SuppressWarnings("java:S6813") // switch off Sonarqube rule 'Avoid field dependency injection'
	@Inject
	private PlainBean plainBean;

	@SuppressWarnings("java:S6813") // switch off Sonarqube rule 'Avoid field dependency injection'
	@Inject
	private Event<Payload> payloadEvent;

	@SuppressWarnings("java:S6813") // switch off Sonarqube rule 'Avoid field dependency injection'
	@Inject
	private Event<List<Payload>> payloadListEvent;

	@SuppressWarnings("java:S6813") // switch off Sonarqube rule 'Avoid field dependency injection'
	@Inject
	private Event<List<String>> textListEvent;

	@SuppressWarnings("java:S6813") // switch off Sonarqube rule 'Avoid field dependency injection'
	@Inject
	@Foreseeable
	private String foreseeableF;

	@SuppressWarnings("java:S6813") // switch off Sonarqube rule 'Avoid field dependency injection'
	@Inject
	@Foreseeable(NEAR)
	private String foreseeableN;

	@SuppressWarnings("java:S6813") // switch off Sonarqube rule 'Avoid field dependency injection'
	@Inject
	@Foreseeable(pattern = "dd MMM HH:mm")
	private Instance<String> foreseeableInstance;

	@SuppressWarnings("java:S6813") // switch off Sonarqube rule 'Avoid field dependency injection'
	@Inject
	private ElapsedBean elapsedBean;

	@SuppressWarnings(value = { "all" })
	private static class ScriptQualifier extends AnnotationLiteral<Script> implements Script {
	}

	private static final String CLASS_NAME = ResearchCDIBean.class.getSimpleName();
	private static final List<String> EMPTY_ROW = Arrays.asList(new String[3]);

	/**
	 * Processes the CDI beans.
	 *
	 */
	public void process() {

		boolean loopFlag = true;
		while (loopFlag) {
			int result = researchCDIHelper.showButtons();
			switch (result) {
			case 0:
				alternativeAndQualifiedBeans();
				break;
			case 1:
				decoratedBeans();
				break;
			case 2:
				interceptedBeans();
				break;
			case 3:
				fireEvents();
				break;
			default:
				// Go Back
				loopFlag = false;
			}
		}
	}

	/**
	 * Researches the alternative and the qualified beans.
	 * 
	 */
	private void alternativeAndQualifiedBeans() {

		/*- switch off alternative by commenting out '<alternatives>' element in the 'beans.xml' file */
		report.clear();
		basicBean.show("ABC");
		basicBeanWithQualifier.show("KLM");
		/*- getting bean from instance with qualifier (equivalent to injected 'basicBeanWithQualifier') */
		final BasicBean basicBeanSelected = basicBeanInstance.select(new ScriptQualifier()).get();
		basicBeanSelected.show("XYZ");

		report.add(EMPTY_ROW);

		note();

		researchCDIHelper.showResults(ResearchCDIHelper.MENU_ARR[0]);
		if (logger.isLoggable(Level.INFO)) {
			logger.info("alternativeAndQualifiedBeans():");
		}
	}

	/**
	 * Takes notes about foreseeable items.
	 * 
	 */
	private void note() {

		report.add(List.of(CLASS_NAME, "note", String.format("foreseeable[%s](String)", foreseeableF)));
		report.add(List.of(CLASS_NAME, "note", String.format("foreseeable[%s](String)", foreseeableN)));
		report.add(List.of(CLASS_NAME, "note",
				String.format("foreseeable[%s](Instance<String>)", foreseeableInstance.get())));
	}

	/**
	 * Researches the decorated beans.
	 * 
	 */
	private void decoratedBeans() {

		/*- switch off by commenting out <decorators> element in the beans.xml file */
		report.clear();
		plainBean.show("ABC");
		researchCDIHelper.showResults(ResearchCDIHelper.MENU_ARR[1]);
		if (logger.isLoggable(Level.INFO)) {
			logger.info("decoratedBeans():");
		}
	}

	/**
	 * Researches the intercepted beans.
	 * 
	 */
	private void interceptedBeans() {

		report.clear();
		IntStream.rangeClosed(1, 10).sequential().forEach(arg -> {
			elapsedBean.pausedMilli();
			elapsedBean.pausedMicro();
			elapsedBean.pausedNano();
			elapsedBean.notPaused();
			report.add(EMPTY_ROW);
		});
		researchCDIHelper.showResults(ResearchCDIHelper.MENU_ARR[2]);
		if (logger.isLoggable(Level.INFO)) {
			logger.info("interceptedBeans():");
		}
	}

	/**
	 * Researches firing the events.
	 * 
	 */
	private void fireEvents() {

		report.clear();

		final Payload payload = new Payload("ABC");
		payloadEvent.fire(payload);
		report.add(EMPTY_ROW);

		final List<Payload> payloadList = new ArrayList<>();
		payloadList.add(new Payload("KLM"));
		payloadListEvent.fire(payloadList);
		report.add(EMPTY_ROW);

		final List<String> textList = new ArrayList<>();
		textList.add("XYZ");
		textListEvent.fire(textList);

		researchCDIHelper.showResults(ResearchCDIHelper.MENU_ARR[3]);
		if (logger.isLoggable(Level.INFO)) {
			logger.info("fireEvents():");
		}
	}
}
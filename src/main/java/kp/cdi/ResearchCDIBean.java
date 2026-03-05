package kp.cdi;

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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

import static kp.cdi.producers.ForeseeableDate.NEAR;

/**
 * The bean for CDI research.
 */
public class ResearchCDIBean {
    private final Logger logger;
    private final List<List<String>> report;
    private final ResearchCDIHelper researchCDIHelper;
    private final BasicBean basicBean;
    private final BasicBean basicBeanWithQualifier;
    private final Instance<BasicBean> basicBeanInstance;
    private final PlainBean plainBean;
    private final Event<Payload> payloadEvent;
    private final Event<List<Payload>> payloadListEvent;
    private final Event<List<String>> textListEvent;
    private final String foreseeableF;
    private final String foreseeableN;
    private final Instance<String> foreseeableInstance;
    private final ElapsedBean elapsedBean;

    @SuppressWarnings(value = {"all"})
    private static class ScriptQualifier extends AnnotationLiteral<Script> implements Script {
    }

    private static final String CLASS_NAME = ResearchCDIBean.class.getSimpleName();
    private static final List<String> EMPTY_ROW = Arrays.asList(new String[3]);

    /**
     * Parameterized constructor.
     *
     * @param logger                 the {@link Logger}
     * @param report                 the report list
     * @param researchCDIHelper      the {@link ResearchCDIHelper}
     * @param basicBean              the {@link BasicBean}
     * @param basicBeanWithQualifier the {@link BasicBean} with qualifier {@link Script}
     * @param basicBeanInstance      the {@link Instance} of the {@link BasicBean}
     * @param plainBean              the {@link PlainBean}
     * @param payloadEvent           the {@link Event} of the {@link Payload}
     * @param payloadListEvent       the {@link Event} of the list of {@link Payload}
     * @param textListEvent          the {@link Event} of the list of {@link String}
     * @param foreseeableF           the foreseeable near date
     * @param foreseeableN           the foreseeable far away date
     * @param foreseeableInstance    the {@link Instance} of foreseeable near date
     * @param elapsedBean            the {@link ElapsedBean}
     */
    @Inject
    public ResearchCDIBean(Logger logger,
                           List<List<String>> report,
                           ResearchCDIHelper researchCDIHelper,
                           BasicBean basicBean,
                           @Script BasicBean basicBeanWithQualifier,
                           @Any Instance<BasicBean> basicBeanInstance,
                           PlainBean plainBean,
                           Event<Payload> payloadEvent,
                           Event<List<Payload>> payloadListEvent,
                           Event<List<String>> textListEvent,
                           @Foreseeable String foreseeableF,
                           @Foreseeable(NEAR) String foreseeableN,
                           @Foreseeable(pattern = "dd MMM HH:mm") Instance<String> foreseeableInstance,
                           ElapsedBean elapsedBean) {
        this.logger = logger;
        this.report = report;
        this.researchCDIHelper = researchCDIHelper;
        this.basicBean = basicBean;
        this.basicBeanWithQualifier = basicBeanWithQualifier;
        this.basicBeanInstance = basicBeanInstance;
        this.plainBean = plainBean;
        this.payloadEvent = payloadEvent;
        this.payloadListEvent = payloadListEvent;
        this.textListEvent = textListEvent;
        this.foreseeableF = foreseeableF;
        this.foreseeableN = foreseeableN;
        this.foreseeableInstance = foreseeableInstance;
        this.elapsedBean = elapsedBean;
    }

    /**
     * Processes the CDI beans.
     */
    public void process() {

        boolean loopFlag = true;
        while (loopFlag) {
            int chosenOption = researchCDIHelper.showButtons();
            switch (chosenOption) {
                case 0 -> alternativeAndQualifiedBeans();
                case 1 -> decoratedBeans();
                case 2 -> interceptedBeans();
                case 3 -> fireEvents();
                default -> loopFlag = false; // Go Back
            }
        }
    }

    /**
     * Researches the alternative and the qualified beans.
     */
    private void alternativeAndQualifiedBeans() {

        report.clear();
        show();
        report.add(EMPTY_ROW);
        note();
        researchCDIHelper.showResults(ResearchCDIHelper.MENU_LIST.getFirst());
        if (logger.isLoggable(Level.INFO)) {
            logger.info("alternativeAndQualifiedBeans():");
        }
    }

    /**
     * Shows basic beans.
     */
    private void show() {

        /*- switch off alternative by commenting out '<alternatives>' element in the 'beans.xml' file */
        basicBean.show("ABC");
        basicBeanWithQualifier.show("KLM");
        /*- getting bean from instance with qualifier (equivalent to injected 'basicBeanWithQualifier') */
        final BasicBean basicBeanSelected = basicBeanInstance.select(new ScriptQualifier()).get();
        basicBeanSelected.show("XYZ");
    }

    /**
     * Takes notes about foreseeable items.
     */
    private void note() {

        report.add(List.of(CLASS_NAME, "note", "foreseeable[%s](String)".formatted(foreseeableF)));
        report.add(List.of(CLASS_NAME, "note", "foreseeable[%s](String)".formatted(foreseeableN)));
        report.add(List.of(CLASS_NAME, "note", "foreseeable[%s](Instance<String>)".formatted(foreseeableInstance.get())));
    }

    /**
     * Researches the decorated beans.
     */
    private void decoratedBeans() {

        /*- switch off by commenting out <decorators> element in the beans.xml file */
        report.clear();
        plainBean.show("ABC");
        researchCDIHelper.showResults(ResearchCDIHelper.MENU_LIST.get(1));
        if (logger.isLoggable(Level.INFO)) {
            logger.info("decoratedBeans():");
        }
    }

    /**
     * Researches the intercepted beans.
     */
    private void interceptedBeans() {

        report.clear();
        IntStream.rangeClosed(1, 10).sequential().forEach(_ -> {
            elapsedBean.pausedMilli();
            elapsedBean.pausedMicro();
            elapsedBean.pausedNano();
            elapsedBean.notPaused();
            report.add(EMPTY_ROW);
        });
        researchCDIHelper.showResults(ResearchCDIHelper.MENU_LIST.get(2));
        if (logger.isLoggable(Level.INFO)) {
            logger.info("interceptedBeans():");
        }
    }

    /**
     * Researches firing the events.
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

        researchCDIHelper.showResults(ResearchCDIHelper.MENU_LIST.get(3));
        if (logger.isLoggable(Level.INFO)) {
            logger.info("fireEvents():");
        }
    }
}
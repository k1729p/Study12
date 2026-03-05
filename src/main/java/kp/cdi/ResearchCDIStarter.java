package kp.cdi;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.jboss.weld.inject.WeldInstance;

/**
 * Starter for CDI research.
 * <ul>
 * <li>Weld 6 / CDI 4.</li>
 * <li>Weld is executed in a Java SE environment.</li>
 * <li>EJB beans are not supported.</li>
 * </ul>
 */
public class ResearchCDIStarter {

    /**
     * Boots the <b>Weld SE</b> container.
     */
    public void startIt() {

        try (WeldContainer container = new Weld().initialize()) {
            final WeldInstance<ResearchCDIBean> weldInstance = container.select(ResearchCDIBean.class);
            final ResearchCDIBean researchCDIBean = weldInstance.get();
            /*-
             * run in container
             */
            researchCDIBean.process();
        }
    }
}
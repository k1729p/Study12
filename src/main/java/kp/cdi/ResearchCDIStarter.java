package kp.cdi;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.jboss.weld.inject.WeldInstance;

/**
 * The starter for CDI research.
 * <p>
 * Weld 5 / CDI 4.
 * <p>
 * Weld is executed in Java SE environment: EJB beans are not supported.
 */
public class ResearchCDIStarter {

	/**
	 * The constructor.
	 */
	public ResearchCDIStarter() {
		super();
	}

	/**
	 * Boots the <B>Weld SE</B> container.
	 * 
	 */
	public void startIt() {

		final Weld weld = new Weld();
		try (WeldContainer container = weld.initialize()) {
			final WeldInstance<ResearchCDIBean> weldInstance = container.select(ResearchCDIBean.class);
			final ResearchCDIBean researchCDIBean = weldInstance.get();
			/*
			 * run in container
			 */
			researchCDIBean.process();
		}
	}
}
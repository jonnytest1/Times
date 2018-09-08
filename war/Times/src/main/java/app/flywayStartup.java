package app;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.flywaydb.core.Flyway;

@Singleton
@Startup
public class flywayStartup {

	@PostConstruct
	void init() {
		System.out.println("starting flyway");
		Flyway flyway = new Flyway();
		flyway.setDataSource("jdbc:mariadb://192.168.99.100:13306/times", "root", "123");
		flyway.setBaselineOnMigrate(true);
		int migrations = flyway.migrate();
		System.out.println("ran flyway with " + migrations + " successful");
	}

}

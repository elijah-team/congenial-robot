package tripleo.elijah.lang;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@RunWith(ArchUnitRunner.class) // Remove this line for JUnit 5!!
@AnalyzeClasses(packages = "tripleo.elijah")
public class Lang_ArchUnit_Test {

	//@Test
	@ArchTest
	public void langTest(JavaClasses importedClasses) {

		ArchRule rule = noClasses().that() // see next section
				.resideInAPackage("tripleo.elijah.lang")
				.should()

				.onlyDependOnClassesThat()
					.resideOutsideOfPackage("tripleo.elijah.lang")
				.orShould()
					.onlyDependOnClassesThat()
						.resideInAPackage("tripleo.elijah.comp.internal")
				;

		if (true || false) {
			rule.check(importedClasses);
		}
	}
}

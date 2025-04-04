package tripleo.vendor.batoull22;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah.util.Operation;
import tripleo.elijah.util.Mode;

import java.io.InputStream;

import org.junit.Test;

import static org.junit.Assert.assertNotSame;

public class ExpertSystemTest {

	//@Ignore
	@Test
	public void testOpenfile() {
		final EK_ExpertSystem i = new EK_ExpertSystem();

		final Operation<EK_Reader> ovo2 = createReaderFromResource(i);
		assertNotSame(ovo2.mode(), Mode.FAILURE);


		final EK_Reader reader = ovo2.success();

		reader.readfile();
		//reader.print();
		reader.closefile();

		//System.out.println("------------------------");
		boolean f = i.Forwardchaining();
		//System.out.println(" ");
		System.out.println("Result of Forwardchaining: " + f);

		//System.out.println(" ");
		//i.print();

		//System.out.println("------------------------");
		boolean b = i.Backwardchaining();
		System.out.println("Result of Backwardchaining: " + b);
		System.out.println(" ");
	}

	private @NotNull Operation<EK_Reader> createReaderFromResource(final @NotNull EK_ExpertSystem aSystem) {
		//try {
			final InputStream stream = aSystem.getClass().getResourceAsStream("KB3.txt");
			if (stream == null) {
				return Operation.failure(new IllegalStateException("Resource KB3.txt not found"));
			}
			return Operation.success(new EK_Reader1(aSystem, stream));
		//} catch (Exception ex) {
		//	return Operation.failure(ex);
		//}
	}
}

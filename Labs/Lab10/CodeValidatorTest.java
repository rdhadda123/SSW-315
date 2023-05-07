import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

class CodeValidatorTest {

	@Test
	void falseGroupingTest() throws FileNotFoundException { //Test for intentional mistake made in grouping
		String[] args = {"C:\\ssw315\\Lab10Test\\DirectoryUtil.java"};
		CodeValidator.main(new String[] {args[0]});
		File file = new File(args[0]);
		assertEquals(CodeValidator.readLines(file), false);
	}

	@Test
	void trueGroupingTest() throws FileNotFoundException { //Test for no mistakes in grouping
		String[] args = {"C:\\ssw315\\Lab10Test\\TaxCalculator.java"};
		CodeValidator.main(new String[] {args[0]});
		File file = new File(args[0]);
		assertEquals(CodeValidator.readLines(file), true);
	}
}

package widthFirstTreeTraversal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestTreeCustom {

	private static TestEmp[] testEmps = new TestEmp[] {

			new TestEmp(1, 0),

			new TestEmp(2, 1),

			new TestEmp(3, 1),

			new TestEmp(4, 1),

			new TestEmp(5, 1),

			new TestEmp(6, 2),

			new TestEmp(7, 3),

			new TestEmp(8, 3),

			new TestEmp(9, 5),

			new TestEmp(10, 6),

			new TestEmp(11, 6),

			new TestEmp(12, 8),

			new TestEmp(13, 9),

			new TestEmp(14, 10),

			new TestEmp(15, 10),

			new TestEmp(16, 10),

			new TestEmp(17, 13),

			new TestEmp(18, 15),

			new TestEmp(19, 17),

			new TestEmp(20, 19) };

	private static List<TestEmp> testEmpList = Arrays.asList(testEmps).stream().collect(Collectors.toList());

	private static Map<TestEmp, List<TestEmp>> hierarch = new HashMap<>();

	public static void main(String[] args) {

		TestEmp parent = testEmpList.stream().filter(e -> e.getPid() == 0).findFirst().get();
		List<TestEmp> mainSlaves = testEmpList.stream().filter(e -> e.getPid() == parent.getId())
				.collect(Collectors.toList());

		hierarch.put(parent, mainSlaves);

		testEmpList.remove(parent);

		hierarchySetup(hierarch);

	}

	private static void hierarchySetup(Map<TestEmp, List<TestEmp>> hierarch) {

		if (testEmpList.size() == 0) {
			for (TestEmp e : hierarch.keySet()) {
				System.out.print(" xxxID: " + e.getId() + " PID " + e.getPid() + " xxx ");
			}
			return;
		}

		Map<TestEmp, List<TestEmp>> newHierarch = new HashMap<>();

		for (TestEmp e : hierarch.keySet()) {

			TestEmp parent = e;
			List<TestEmp> mainSlaves = hierarch.get(e);

			System.out.print(" xxxID: " + e.getId() + " PID " + e.getPid() + " xxx ");

			parent.setSlaves(mainSlaves);

			testEmpList.removeAll(mainSlaves);

			for (TestEmp slave : mainSlaves) {
				List<TestEmp> newMainSlaves = testEmpList.stream().filter(sve -> sve.getPid() == slave.getId())
						.collect(Collectors.toList());

				newHierarch.put(slave, newMainSlaves);
			}

		}

		System.gc();

		System.out.println("");

		hierarchySetup(newHierarch);

	}

}

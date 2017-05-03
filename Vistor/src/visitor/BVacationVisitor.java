package visitor;

public class BVacationVisitor extends Visitor {
	int total_days;

	public BVacationVisitor() {
		total_days = 0;
	}

	// -----------------------------
	public int getTotalDays() {
		return total_days;
	}

	// --------------------------------
	public void visit(Boss boss) {
		total_days += boss.getVacDays();
		total_days += boss.getBonusDays();
	}

	// -----------------------------
	public void visit(Employee emp) {
		total_days += emp.getVacDays();
	}
}

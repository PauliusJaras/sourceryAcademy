import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Program
 */
public class Program {

	/* class Main(String[]) */
	public static void main(String[] args) {

		/* example case */
		printBonusDatesBetween(2010, 2015);

		/* test cases */
		// printBonusDatesBetween(-2000, 2015);
		// printBonusDatesBetween(2000, -2015);
		// printBonusDatesBetween(2000, 1999);
		// printBonusDatesBetween(0, 999);
		// printBonusDatesBetween(2010, 2010);

	}

	/* class printBonusDatesBetween(int, int) */
	public static void printBonusDatesBetween(int fromYear, int toYear) {

		if (fromYear > toYear) {
			System.out.println("Please specify a higher end year than the start year");
			return;
		}

		if (fromYear < 0 || toYear < 0) {
			System.out.println("Please provide non negative values for years");
			return;
		}

		LocalDate startDate = LocalDate.of(fromYear, 1, 1);
		LocalDate endDate = LocalDate.of(toYear, 12, 31);
		List<LocalDate> allDates = startDate.datesUntil(endDate).collect(Collectors.toList());

		for (LocalDate oneDate : allDates) {
			String[] date = oneDate.toString().split("-", 0);
			String year = date[0];
			String dayMonthReversed = new StringBuilder(date[2]).reverse().toString()
					+ new StringBuilder(date[1]).reverse().toString();

			if (year.equals(dayMonthReversed)) {
				System.out.println(oneDate);
			}
		}

	}

}
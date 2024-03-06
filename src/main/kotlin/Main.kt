import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.Scanner

/**
 * This program calculates and displays information about the user's birthday.
 * It prompts the user for their birthdate, compares it with the current date,
 * and provides details about the upcoming birthday or wishes a happy birthday if today is the user's birthday.
 *
 * @param args The command-line arguments (not used in this program).
 * @author Jyotsna Agarwal
 */
fun main(args: Array<String>) {


    val scanner = Scanner(System.`in`)

    // Use parentheses to call the now() function
    val today = LocalDate.now()

    // Fixing variable name (textToday instead of TextToday)
    val formatter = DateTimeFormatter.ofPattern("M/d/yyyy")
    val textToday = today.format(formatter)
    println("Today's date is: $textToday")

    println("What month were you born in? (Enter as a number: January = 1)")
    val myMonth = scanner.nextInt()

    println("What day were you born?")
    val myDay = scanner.nextInt()

    // Fixing method call: use getYear() instead of getYears()
    val myYear = today.year

    // Using the built-in month value instead of getMonthValue() function
    val thisMonth = today.monthValue

    var birthday = LocalDate.of(myYear, myMonth, myDay)

    // Fixing the condition to check if the birthday has already happened this year
    if (birthday.isBefore(today)) {
        birthday = birthday.plusYears(1)
    }

    val nextBirthday = birthday.format(formatter)

    /* Calculate days until next birthday using ChronosUnit.DAYS */
    val daysToBirthday = ChronoUnit.DAYS.between(today, birthday)

    if (myMonth == thisMonth && myDay == today.dayOfMonth) {
        println("Happy Birthday!")
    } else {
        println("Your next birthday is: $nextBirthday")
        println("There are $daysToBirthday days until your next birthday!")
    }
}

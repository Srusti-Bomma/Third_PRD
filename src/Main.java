import java.util.Scanner;

/**
 * CampusTrack - Student Academic Management System
 *
 * A beginner-level Java console application built using only core
 * fundamentals: Scanner, primitive data types, operators, if/else,
 * switch, ternary operator, while/for/do-while loops, break/continue
 * and printf-based formatted output.
 *
 * No arrays, collections, user-defined methods, additional classes,
 * constructors, exception handling, file handling, database
 * connectivity, inheritance, streams or lambdas are used.
 * The entire program runs inside main().
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // FR-01: Welcome screen (shown once, when the program starts)
        System.out.println("========================================================");
        System.out.println("                    CAMPUSTRACK");
        System.out.println("========================================================");
        System.out.println("       Student Academic Management System");
        System.out.println("--------------------------------------------------------");

        int processAnother; // 1 = yes, 0 = no

        do {
            // ---------------------------------------------------------
            // FR-02: Student Profile
            // ---------------------------------------------------------
            System.out.print("\nEnter student ID: ");
            String studentId = sc.next();
            sc.nextLine(); // consume pending newline before nextLine()

            System.out.print("Enter full name: ");
            String fullName = sc.nextLine();

            int age;
            System.out.print("Enter age: ");
            age = sc.nextInt();
            while (age < 15 || age > 35) {
                System.out.println("Invalid age. Enter a value between 15 and 35.");
                System.out.print("Enter age: ");
                age = sc.nextInt();
            }
            System.out.println("Age accepted.");

            System.out.print("Enter email: ");
            String email = sc.next();

            // Course selection
            String courseName = "";
            double baseSemesterFee = 0.0;
            int courseChoice;
            do {
                System.out.println("\nSelect course:");
                System.out.println("1. BCA");
                System.out.println("2. B.Sc Computer Science");
                System.out.println("3. B.E/B.Tech");
                System.out.println("4. MCA");
                System.out.println("5. Other");
                System.out.print("Enter course choice: ");
                courseChoice = sc.nextInt();

                switch (courseChoice) {
                    case 1:
                        courseName = "BCA";
                        baseSemesterFee = 35000.0;
                        break;
                    case 2:
                        courseName = "B.Sc Computer Science";
                        baseSemesterFee = 30000.0;
                        break;
                    case 3:
                        courseName = "B.E/B.Tech";
                        baseSemesterFee = 50000.0;
                        break;
                    case 4:
                        courseName = "MCA";
                        baseSemesterFee = 45000.0;
                        break;
                    case 5:
                        courseName = "Other";
                        baseSemesterFee = 25000.0;
                        break;
                    default:
                        System.out.println("Invalid course choice. Select a value from 1 to 5.");
                }
            } while (courseChoice < 1 || courseChoice > 5);
            System.out.println("Course selected: " + courseName);

            int semester;
            System.out.print("Enter semester (1-8): ");
            semester = sc.nextInt();
            while (semester < 1 || semester > 8) {
                System.out.println("Invalid semester. Enter a value between 1 and 8.");
                System.out.print("Enter semester (1-8): ");
                semester = sc.nextInt();
            }
            sc.nextLine(); // consume pending newline before nextLine()

            System.out.print("Enter career goal: ");
            String careerGoal = sc.nextLine();

            // ---------------------------------------------------------
            // FR-03: Subject Marks (five separate variables, no arrays)
            // ---------------------------------------------------------
            int javaMarks;
            System.out.print("Enter Java marks: ");
            javaMarks = sc.nextInt();
            while (javaMarks < 0 || javaMarks > 100) {
                System.out.println("Invalid marks. Enter a value between 0 and 100.");
                System.out.print("Enter Java marks: ");
                javaMarks = sc.nextInt();
            }
            System.out.println("Java marks accepted.");

            int sqlMarks;
            System.out.print("Enter SQL marks: ");
            sqlMarks = sc.nextInt();
            while (sqlMarks < 0 || sqlMarks > 100) {
                System.out.println("Invalid marks. Enter a value between 0 and 100.");
                System.out.print("Enter SQL marks: ");
                sqlMarks = sc.nextInt();
            }
            System.out.println("SQL marks accepted.");

            int webTechMarks;
            System.out.print("Enter Web Technology marks: ");
            webTechMarks = sc.nextInt();
            while (webTechMarks < 0 || webTechMarks > 100) {
                System.out.println("Invalid marks. Enter a value between 0 and 100.");
                System.out.print("Enter Web Technology marks: ");
                webTechMarks = sc.nextInt();
            }
            System.out.println("Web Technology marks accepted.");

            int aptitudeMarks;
            System.out.print("Enter Aptitude marks: ");
            aptitudeMarks = sc.nextInt();
            while (aptitudeMarks < 0 || aptitudeMarks > 100) {
                System.out.println("Invalid marks. Enter a value between 0 and 100.");
                System.out.print("Enter Aptitude marks: ");
                aptitudeMarks = sc.nextInt();
            }
            System.out.println("Aptitude marks accepted.");

            int communicationMarks;
            System.out.print("Enter Communication marks: ");
            communicationMarks = sc.nextInt();
            while (communicationMarks < 0 || communicationMarks > 100) {
                System.out.println("Invalid marks. Enter a value between 0 and 100.");
                System.out.print("Enter Communication marks: ");
                communicationMarks = sc.nextInt();
            }
            System.out.println("Communication marks accepted.");

            // ---------------------------------------------------------
            // FR-04: Total and Percentage
            // ---------------------------------------------------------
            int totalMarks = javaMarks + sqlMarks + webTechMarks + aptitudeMarks + communicationMarks;
            double percentage = (double) totalMarks / 5;

            // ---------------------------------------------------------
            // FR-05: Subject and Academic Result
            // ---------------------------------------------------------
            boolean allSubjectsPassed = javaMarks >= 35 && sqlMarks >= 35 && webTechMarks >= 35
                    && aptitudeMarks >= 35 && communicationMarks >= 35;
            boolean academicPassed = allSubjectsPassed && percentage >= 40;
            String academicResult = academicPassed ? "PASSED" : "FAILED";

            // ---------------------------------------------------------
            // FR-06: Grade Classification (if-else-if ladder)
            // ---------------------------------------------------------
            String grade;
            if (!academicPassed) {
                grade = "F";
            } else if (percentage >= 85) {
                grade = "A+";
            } else if (percentage >= 75) {
                grade = "A";
            } else if (percentage >= 65) {
                grade = "B";
            } else if (percentage >= 50) {
                grade = "C";
            } else {
                grade = "D"; // 40 - 49.99
            }

            // ---------------------------------------------------------
            // FR-07: Attendance
            // ---------------------------------------------------------
            int totalClasses;
            System.out.print("\nEnter total classes conducted: ");
            totalClasses = sc.nextInt();
            while (totalClasses < 1 || totalClasses > 300) {
                System.out.println("Invalid value. Total classes must be between 1 and 300.");
                System.out.print("Enter total classes conducted: ");
                totalClasses = sc.nextInt();
            }

            int classesAttended;
            System.out.print("Enter classes attended: ");
            classesAttended = sc.nextInt();
            while (classesAttended < 0 || classesAttended > totalClasses) {
                System.out.println("Invalid attendance. Attended classes cannot exceed " + totalClasses + ".");
                System.out.print("Enter classes attended: ");
                classesAttended = sc.nextInt();
            }
            System.out.println("Attendance accepted.");

            double attendancePercentage = ((double) classesAttended / totalClasses) * 100;
            String attendanceStatus = attendancePercentage >= 75 ? "REGULAR" : "SHORTAGE";

            // ---------------------------------------------------------
            // FR-08: Assignment Score Processing
            // ---------------------------------------------------------
            int numAssignments;
            System.out.print("\nHow many assignment scores do you want to enter (1-10)? ");
            numAssignments = sc.nextInt();
            while (numAssignments < 1 || numAssignments > 10) {
                System.out.println("Invalid value. Enter a number between 1 and 10.");
                System.out.print("How many assignment scores do you want to enter (1-10)? ");
                numAssignments = sc.nextInt();
            }

            int assignmentTotal = 0;
            int validAssignmentCount = 0;

            for (int i = 1; i <= numAssignments; i++) {
                System.out.print("Enter score for assignment " + i + " (0-10, -1 to finish): ");
                int score = sc.nextInt();

                if (score == -1) {
                    System.out.println("Assignment entry completed early.");
                    break;
                }

                if (score < -1 || score > 10) {
                    System.out.println("Assignment " + i + " skipped: Score must be from 0 to 10.");
                    continue;
                }

                assignmentTotal += score;
                validAssignmentCount++;
                System.out.println("Assignment " + i + " accepted.");
            }

            double assignmentAverage;
            if (validAssignmentCount > 0) {
                assignmentAverage = (double) assignmentTotal / validAssignmentCount;
            } else {
                assignmentAverage = 0.00;
            }

            boolean assignmentPassed = validAssignmentCount > 0 && assignmentAverage >= 5;
            String assignmentStatus = assignmentPassed ? "SATISFACTORY" : "NEEDS IMPROVEMENT";

            // ---------------------------------------------------------
            // FR-09: Scholarship Calculation
            // ---------------------------------------------------------
            int scholarshipPercentage;
            if (academicPassed && percentage >= 85 && attendancePercentage >= 85) {
                scholarshipPercentage = 10;
            } else if (academicPassed && percentage >= 75 && attendancePercentage >= 75) {
                scholarshipPercentage = 5;
            } else {
                scholarshipPercentage = 0;
            }

            double scholarshipAmount = baseSemesterFee * scholarshipPercentage / 100;
            double finalPayableFee = baseSemesterFee - scholarshipAmount;

            // ---------------------------------------------------------
            // FR-10: Fee Payment
            // ---------------------------------------------------------
            double amountPaid;
            System.out.print("\nFinal payable fee: \u20B9" + String.format("%.2f", finalPayableFee) + "\n");
            System.out.print("Enter amount paid: ");
            amountPaid = sc.nextDouble();
            while (amountPaid < 0 || amountPaid > finalPayableFee) {
                System.out.println("Invalid amount. Enter a value between 0 and " + String.format("%.2f", finalPayableFee) + ".");
                System.out.print("Enter amount paid: ");
                amountPaid = sc.nextDouble();
            }

            double feeBalance = finalPayableFee - amountPaid;
            String feeStatus = (feeBalance == 0) ? "PAID" : "PENDING";

            // ---------------------------------------------------------
            // FR-11: Final Semester Clearance
            // ---------------------------------------------------------
            boolean cleared = academicPassed && attendancePercentage >= 75
                    && assignmentPassed && feeBalance == 0;
            String clearanceStatus = cleared ? "CLEARED FOR NEXT SEMESTER" : "ACTION REQUIRED";

            // ---------------------------------------------------------
            // Print the complete student report
            // ---------------------------------------------------------
            System.out.println();
            System.out.println("========================================================");
            System.out.println("                 STUDENT SEMESTER REPORT");
            System.out.println("========================================================");
            System.out.printf("%-28s: %s%n", "Student ID", studentId);
            System.out.printf("%-28s: %s%n", "Student Name", fullName);
            System.out.printf("%-28s: %d%n", "Age", age);
            System.out.printf("%-28s: %s%n", "Email", email);
            System.out.printf("%-28s: %s%n", "Course", courseName);
            System.out.printf("%-28s: %d%n", "Semester", semester);
            System.out.printf("%-28s: %s%n", "Career Goal", careerGoal);

            System.out.println();
            System.out.println("---------------- ACADEMIC SUMMARY --------------------");
            System.out.printf("%-28s: %d%n", "Java Marks", javaMarks);
            System.out.printf("%-28s: %d%n", "SQL Marks", sqlMarks);
            System.out.printf("%-28s: %d%n", "Web Technology Marks", webTechMarks);
            System.out.printf("%-28s: %d%n", "Aptitude Marks", aptitudeMarks);
            System.out.printf("%-28s: %d%n", "Communication Marks", communicationMarks);
            System.out.printf("%-28s: %d/500%n", "Total Marks", totalMarks);
            System.out.printf("%-28s: %.2f%%%n", "Percentage", percentage);
            System.out.printf("%-28s: %s%n", "Academic Result", academicResult);
            System.out.printf("%-28s: %s%n", "Grade", grade);

            System.out.println();
            System.out.println("---------------- ATTENDANCE SUMMARY ------------------");
            System.out.printf("%-28s: %d%n", "Classes Conducted", totalClasses);
            System.out.printf("%-28s: %d%n", "Classes Attended", classesAttended);
            System.out.printf("%-28s: %.2f%%%n", "Attendance Percentage", attendancePercentage);
            System.out.printf("%-28s: %s%n", "Attendance Status", attendanceStatus);

            System.out.println();
            System.out.println("---------------- ASSIGNMENT SUMMARY ------------------");
            System.out.printf("%-28s: %d%n", "Valid Assignments", validAssignmentCount);
            System.out.printf("%-28s: %d%n", "Assignment Total", assignmentTotal);
            System.out.printf("%-28s: %.2f%n", "Assignment Average", assignmentAverage);
            System.out.printf("%-28s: %s%n", "Assignment Status", assignmentStatus);

            System.out.println();
            System.out.println("---------------- FEE SUMMARY -------------------------");
            System.out.printf("%-28s: \u20B9%.2f%n", "Base Semester Fee", baseSemesterFee);
            System.out.printf("%-28s: %d%%%n", "Scholarship Percentage", scholarshipPercentage);
            System.out.printf("%-28s: \u20B9%.2f%n", "Scholarship Amount", scholarshipAmount);
            System.out.printf("%-28s: \u20B9%.2f%n", "Final Payable Fee", finalPayableFee);
            System.out.printf("%-28s: \u20B9%.2f%n", "Amount Paid", amountPaid);
            System.out.printf("%-28s: \u20B9%.2f%n", "Fee Balance", feeBalance);
            System.out.printf("%-28s: %s%n", "Fee Status", feeStatus);

            System.out.println();
            System.out.println("---------------- FINAL STATUS ------------------------");
            System.out.printf("%-28s: %s%n", "Semester Clearance", clearanceStatus);

            // ---------------------------------------------------------
            // FR-12: Failed Conditions
            // ---------------------------------------------------------
            System.out.println();
            System.out.println("---------------- FAILED CONDITIONS -------------------");
            boolean anyFailure = false;

            if (javaMarks < 35) {
                System.out.println("- Java marks are below 35.");
                anyFailure = true;
            }
            if (sqlMarks < 35) {
                System.out.println("- SQL marks are below 35.");
                anyFailure = true;
            }
            if (webTechMarks < 35) {
                System.out.println("- Web Technology marks are below 35.");
                anyFailure = true;
            }
            if (aptitudeMarks < 35) {
                System.out.println("- Aptitude marks are below 35.");
                anyFailure = true;
            }
            if (communicationMarks < 35) {
                System.out.println("- Communication marks are below 35.");
                anyFailure = true;
            }
            if (percentage < 40) {
                System.out.println("- Overall percentage is below 40%.");
                anyFailure = true;
            }
            if (attendancePercentage < 75) {
                System.out.println("- Attendance is below 75%.");
                anyFailure = true;
            }
            if (validAssignmentCount == 0) {
                System.out.println("- No valid assignment score was entered.");
                anyFailure = true;
            } else if (assignmentAverage < 5) {
                System.out.println("- Assignment average is below 5.00.");
                anyFailure = true;
            }
            if (feeBalance != 0) {
                System.out.println("- Semester fee is pending.");
                anyFailure = true;
            }
            if (!anyFailure) {
                System.out.println("None");
            }

            // ---------------------------------------------------------
            // FR-13: Recommendations
            // ---------------------------------------------------------
            System.out.println();
            System.out.println("---------------- RECOMMENDATIONS ---------------------");
            boolean anyRecommendation = false;

            if (javaMarks < 35 || sqlMarks < 35 || webTechMarks < 35
                    || aptitudeMarks < 35 || communicationMarks < 35) {
                System.out.println("Revisit the failed subject and complete additional practice.");
                anyRecommendation = true;
            }
            if (percentage < 40) {
                System.out.println("Improve overall academic performance.");
                anyRecommendation = true;
            }
            if (attendancePercentage < 75) {
                System.out.println("Attend classes regularly and clear the attendance shortage.");
                anyRecommendation = true;
            }
            if (!assignmentPassed) {
                System.out.println("Complete assignments consistently and maintain an average of at least 5.00.");
                anyRecommendation = true;
            }
            if (feeBalance != 0) {
                System.out.println("Pay the pending semester fee before clearance.");
                anyRecommendation = true;
            }
            if (!anyRecommendation) {
                System.out.println("Maintain the current performance in the next semester.");
            }
            System.out.println("========================================================");

            // ---------------------------------------------------------
            // FR-14: Process Another Student
            // ---------------------------------------------------------
            System.out.println("\nDo you want to process another student?");
            System.out.println("1. Yes");
            System.out.println("0. No");
            System.out.print("Enter choice: ");
            processAnother = sc.nextInt();
            while (processAnother != 0 && processAnother != 1) {
                System.out.println("Invalid choice. Enter 1 for Yes or 0 for No.");
                System.out.print("Enter choice: ");
                processAnother = sc.nextInt();
            }

        } while (processAnother == 1);

        System.out.println("\nThank you for using CampusTrack.");
        sc.close();
    }
}

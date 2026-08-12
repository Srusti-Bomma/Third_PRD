# CampusTrack — Student Academic Management System

## 1. Project Title

**CampusTrack** — a beginner-level Java console application that generates a complete
semester report for one student at a time.

## 2. Problem Statement

A college regularly needs to review a student's academic progress. It must maintain the
student's basic details, marks, attendance, assignment performance, scholarship
eligibility, fee payment and semester-clearance status.

CampusTrack collects and processes:

1. Student profile
2. Course and semester details
3. Marks in five subjects
4. Overall result, percentage and grade
5. Attendance information
6. Assignment scores
7. Scholarship eligibility
8. Semester-fee payment
9. Final clearance status
10. Detailed recommendations

The application validates every numeric input, performs the required calculations, and
displays the exact reason whenever a student does not satisfy a rule.

## 3. Features

- Collects a full student profile (ID, name, age, email, course, semester, career goal).
- Menu-driven course selection using `switch`, which also sets the base semester fee.
- Validates marks for five subjects (Java, SQL, Web Technology, Aptitude,
  Communication), each from 0–100.
- Calculates total marks (out of 500), percentage, academic result and letter grade.
- Calculates attendance percentage and status from classes conducted/attended.
- Processes 1–10 assignment scores using a `for` loop with `break`/`continue` handling.
- Calculates scholarship eligibility and amount based on percentage and attendance.
- Validates fee payment and calculates the remaining balance.
- Determines final semester-clearance status from four independent conditions.
- Lists every individual failed condition and a matching recommendation.
- Prints a complete, aligned semester report using `printf`.
- Repeats the entire flow for another student using a `do-while` loop.

## 4. Concepts Used

- Java program structure (single `main` method, no additional classes/methods)
- Variables and primitive data types (`int`, `double`, `boolean`, `String`)
- `Scanner` for runtime input (`next()`, `nextLine()`, `nextInt()`, `nextDouble()`)
- Handling the pending newline before `nextLine()`
- Arithmetic, assignment, relational and logical operators
- Explicit type casting for decimal division (percentage, attendance, averages)
- `if`, `else if`, `else` and compound/nested conditions
- `switch` for the course menu
- Ternary operator for status assignments (attendance, assignment, fee, clearance)
- `while` loops for input validation
- `for` loop for processing assignment scores
- `break` and `continue` inside the assignment loop
- `do-while` loop for course selection retry and for repeating the whole program
- `print`, `println` and `printf` for aligned report output

No arrays, collections, user-defined methods, additional classes, constructors,
exception handling, file handling, database connectivity, inheritance, streams or
lambda expressions are used. All logic lives inside `main()`.

## 5. Input Details

| Field | Type | Read using |
|---|---|---|
| Student ID | `String` | `next()` |
| Full name | `String` | `nextLine()` |
| Age | `int` | `nextInt()` |
| Email | `String` | `next()` |
| Course choice | `int` | `nextInt()` |
| Semester | `int` | `nextInt()` |
| Career goal | `String` | `nextLine()` |
| Subject marks (×5) | `int` | `nextInt()` |
| Total classes conducted | `int` | `nextInt()` |
| Classes attended | `int` | `nextInt()` |
| Number of assignments | `int` | `nextInt()` |
| Assignment scores | `int` | `nextInt()` |
| Amount paid | `double` | `nextDouble()` |
| Process another student? | `int` (0/1) | `nextInt()` |

## 6. Validation Rules

| Field | Valid range |
|---|---|
| Age | 15–35 |
| Course choice | 1–5 |
| Semester | 1–8 |
| Each subject mark | 0–100 |
| Total classes conducted | 1–300 |
| Classes attended | 0 to total classes conducted |
| Number of assignments | 1–10 |
| Assignment score | 0–10 (or `-1` to finish early) |
| Amount paid | 0 to final payable fee |
| Continue-another-student choice | 0 or 1 |

Every rule above is enforced with a `while` re-entry loop (or a `do-while` loop for the
course menu) that keeps asking until a valid value is entered.

## 7. Academic-Result Rules

- Minimum pass mark per subject: **35**.
- The student passes the academic criteria only when **all five** subject marks are
  ≥ 35 **and** the overall percentage is ≥ 40. A high percentage never hides a failed
  subject.
- Grade is assigned with an `if-else-if` ladder, checked **after** the academic result:

  | Condition | Grade |
  |---|---|
  | Academic criteria failed | F |
  | Percentage ≥ 85 | A+ |
  | Percentage 75–84.99 | A |
  | Percentage 65–74.99 | B |
  | Percentage 50–64.99 | C |
  | Percentage 40–49.99 | D |

## 8. Attendance Rules

```
Attendance % = ((double) classes attended / total classes conducted) * 100
```

- Attendance criteria passes when attendance % ≥ 75.
- Status is assigned with a ternary operator: `REGULAR` or `SHORTAGE`.
- Classes attended can never exceed classes conducted (validated by a loop).

## 9. Assignment Rules

- Operator chooses how many scores to enter (1–10), processed with a `for` loop.
- `-1` ends entry early using `break`.
- A score below `-1` or above `10` is skipped using `continue` (does not affect the
  total/average).
- A valid score (0–10) is added to the total and increases the valid-assignment count.
- If no valid score was entered, the average is `0.00` (no division by zero).
- Assignment criteria passes only when at least one valid score was entered **and**
  the average is ≥ 5. Status uses a ternary operator: `SATISFACTORY` or
  `NEEDS IMPROVEMENT`.

## 10. Scholarship and Fee Rules

| Condition | Scholarship |
|---|---:|
| Academic passed, percentage ≥ 85, attendance ≥ 85 | 10% |
| Academic passed, percentage ≥ 75, attendance ≥ 75 | 5% |
| All other cases | 0% |

The 10% condition is checked first so a student who qualifies for 10% is never
under-awarded 5%.

```
Scholarship amount   = Base semester fee × Scholarship % / 100
Final payable fee    = Base semester fee - Scholarship amount
Fee balance           = Final payable fee - Amount paid
```

Amount paid must be between 0 and the final payable fee. Fee status uses a ternary
operator: `PAID` when the balance is exactly 0, otherwise `PENDING`. All monetary
values are displayed with exactly two decimal places.

## 11. Final-Clearance Rules

The student is cleared for the next semester only when **all four** are true
(checked independently, combined with a compound Boolean expression):

```
Academic criteria passed
AND Attendance percentage >= 75
AND Assignment criteria passed
AND Fee balance == 0
```

A ternary operator assigns `CLEARED FOR NEXT SEMESTER` or `ACTION REQUIRED`. Every
applicable failure reason is printed separately (never a single generic message), each
paired with a matching recommendation.

## 12. Pseudocode

See [`pseudocode/pseudocode.txt`](pseudocode/pseudocode.txt).

## 13. Test Cases

Eight test cases were executed; outputs are saved in [`output/`](output/):

| # | Scenario | File |
|---|---|---|
| 1 | All conditions passed | `output/test-case-1.txt` |
| 2 | One subject failed despite a high percentage | `output/test-case-2.txt` |
| 3 | Exact boundary values (marks = 40, attendance = 75) | `output/test-case-3.txt` |
| 4 | Attendance shortage and pending fee | `output/test-case-4.txt` |
| 5 | Assignment `continue` and `break` behaviour | `output/test-case-5.txt` |
| 6 | No valid assignment entered (avoids divide-by-zero) | `output/test-case-6.txt` |
| 7 | Ten-percent scholarship eligibility | `output/test-case-7.txt` |
| 8 | Invalid input re-entry (age, course, marks, attendance) | `output/test-case-8.txt` |

## 14. Sample Input and Output

### Sample input

```text
Enter student ID: STU101
Enter full name: Ananya Rao
Enter age: 20
Enter email: ananya@gmail.com

Select course:
1. BCA
2. B.Sc Computer Science
3. B.E/B.Tech
4. MCA
5. Other

Enter course choice: 3
Enter semester (1-8): 4
Enter career goal: Become a Java backend developer

Enter Java marks: 88
Enter SQL marks: 82
Enter Web Technology marks: 79
Enter Aptitude marks: 76
Enter Communication marks: 80

Enter total classes conducted: 120
Enter classes attended: 102

How many assignment scores do you want to enter (1-10)? 5
Enter score for assignment 1 (0-10, -1 to finish): 8
Enter score for assignment 2 (0-10, -1 to finish): 9
Enter score for assignment 3 (0-10, -1 to finish): 7
Enter score for assignment 4 (0-10, -1 to finish): 8
Enter score for assignment 5 (0-10, -1 to finish): 9

Enter amount paid: 47500
```

### Expected output (excerpt)

```text
========================================================
                 STUDENT SEMESTER REPORT
========================================================
Student ID                  : STU101
Student Name                : Ananya Rao
...
Total Marks                 : 405/500
Percentage                  : 81.00%
Academic Result             : PASSED
Grade                       : A
...
Attendance Percentage       : 85.00%
Attendance Status           : REGULAR
...
Assignment Average          : 8.20
Assignment Status           : SATISFACTORY
...
Scholarship Percentage      : 5%
Fee Status                  : PAID
...
Semester Clearance          : CLEARED FOR NEXT SEMESTER

---------------- FAILED CONDITIONS -------------------
None

---------------- RECOMMENDATIONS ---------------------
Maintain the current performance in the next semester.
========================================================
```

The full, unedited console output for this exact run is saved at
[`output/test-case-1.txt`](output/test-case-1.txt).

## 15. Screenshots / Copied Console Outputs

All eight completed test runs were copied directly from the console into the `output/`
folder (see Section 13 above) rather than as screenshots.

## 16. Technical Note

The JDK is used to develop and compile the Java program. The Java compiler converts
source code into bytecode. The JRE provides the environment required to run the
program. The JVM executes the generated bytecode. The same bytecode can run on
different operating systems that have a compatible JVM, making Java
platform-independent.

## 17. Repository Structure

```text
Third-PRD/
├── README.md
├── src/
│   └── Main.java
├── pseudocode/
│   └── pseudocode.txt
└── output/
    ├── test-case-1.txt
    ├── test-case-2.txt
    ├── test-case-3.txt
    ├── test-case-4.txt
    ├── test-case-5.txt
    ├── test-case-6.txt
    ├── test-case-7.txt
    └── test-case-8.txt
```

## 18. How to Compile and Run

```bash
cd src
javac Main.java
java Main
```

If the ₹ symbol does not render correctly in your terminal, run with UTF-8 output
encoding explicitly:

```bash
java -Dstdout.encoding=UTF-8 Main
```

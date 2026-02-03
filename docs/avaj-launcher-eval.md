## Guidelines

*   You may only evaluate whatever is in the GiT submission directory of the student you are grading.
*   Make sure to check wether the GiT submission directory belongs to the student (or group) you're grading, and that it's the right project.
*   Make sure no mischievous aliases have been used to trick you into correcting something that is not actually in the official submitted directory.
*   Any script created to make this evaluation session easier - whether it was produced by you or the student being graded - must be checked rigorously in order to avoid bad surprises.
*   If the student who is grading this project hasn't done the project him/herself yet, he/she must read the whole topic before starting the evaluation session.
*   Use the flags available to you on this scale in order to report a submission directory that is empty, non-functional, that contains a norm errors or a case of cheating, etc... In this case, the evaluation session ends and the final grade is 0 (or -42, in case of cheating). However, unless the student has cheated, we advise you to go through the project together in order for the two (or more) of you to identify the problems that may have led for this project to fail, and avoid repeating those mistakes for future projects.

---

## Attachments

*   [subject.pdf](../avaj-launcher.pdf)
*   [avaj_uml.png](../avaj_uml.png)
*   [scenario.txt](../scenario.txt)

---

## Preliminaries

### Compilation
Compile the program with the commands described in the subject. Does the project compile?
[ ] Yes [ ] No

### Program design
Does project respect the UML class diagram to the letter? It is not a problem if there are additional classes or private attributes and methods added by the student.
[ ] Yes [ ] No

---

## Functionality

### Validation
Check if the program validates the input file. Try running the program without an input file present, with inconsistent data, missing values or out of range values. Does the validation work?
[ ] Yes [ ] No

### Simulation
Is the simulation.txt file generated acording to the specifications? Check to see if the ID is unique and if all messages are logged correctly.
[ ] Yes [ ] No

---

## Bonus

### Exception handling
Does the project contain custom exceptions for treating abnormarl behaviour specific to the program? Are they relevant? Do they have good messages?
[ ] Yes [ ] No

### Security
Feed the program with a valid input file, where the contents where previously encrypted with MD5. Does the program have the same behaviour as with the non-encrypted file?
[ ] Yes [ ] No

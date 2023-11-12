---
layout: default.md
title: "Hanjoo's Project Portfolio Page"
---

### Project: MedBook

**Overview**: Medbook streamlines patient management for healthcare professionals. It simplifies the process of accessing patients' contact information and medical records, making it easier for healthcare providers to efficiently coordinate care.

**Contributions**: Click [here](https://nus-cs2103-ay2324s1.github.io/tp-dashboard/?search=hjoneweek&breakdown=false&sort=groupTitle%20dsc&sortWithin=title&since=2023-09-22&timeframe=commit&mergegroup=&groupSelect=groupByRepos) to view my contribution to the project

- **Enhancement 1**: Add Patient

  - Added more attributes to the person so that it would be more suitable to hospital/clinic setting and easier for the doctors to know about their patients. Updated attributes include blood type, age, gender, and allergy.

- **New Feature 1**: Add Record

  - Allows doctors to add a medical record to a patient after visit. The record would include information about date and time of the visit, conditions of the patient, and prescribed medicine for the patient.
  - Created the parser class and the command class to execute the adding record command.

- **New Feature 2**: Search Record

  - Allow doctors to search for the past records of the patient that they are currently viewing using keywords.
  - Created the parser class and the command class to execute the searching record command.

- **New Feature 3** Delete Record

  - Allow doctors to delete records of patients if necessary
  - Created the parser class and the command class to execute the deleting record command.

- **Project management**

- **Documentation**

  - User Guide
    - Added new sections explaining how to use the new features and commands I implemented, which are `addrecord` and `searchrecord`
      command.
    - Modified `addpatient` command (originally `addperson` command) section following to the updated attributes of the patient.
  - Developer Guide
    - Added implementation details for `addrecord` command.
    - Created a sequence diagram of the execution of the `addrecord` command.
    - Created a class diagram of the **Record** class

- **Community**
  - PRs reviewed
  - Reported bugs and suggestions for other teams in the class.

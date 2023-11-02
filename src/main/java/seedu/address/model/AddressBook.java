package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.appointment.Appointment;
import seedu.address.model.appointment.UniqueAppointmentList;
import seedu.address.model.patient.Patient;
import seedu.address.model.patient.UniquePatientList;
import seedu.address.model.record.Record;
import seedu.address.model.record.UniqueRecordList;

/**
 * Wraps all data at the address-book level
 * Duplicates are not allowed (by .isSamePatient comparison)
 */
public class AddressBook implements ReadOnlyAddressBook {

    private final UniquePatientList patients;
    private final UniquePatientList patientBeingViewed;
    private final UniqueRecordList records;
    private final UniqueAppointmentList appointments;
    /*
     * The 'unusual' code block below is a non-static initialization block,
     * sometimes used to avoid duplication
     * between constructors. See
     * https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other
     * ways to avoid duplication
     * among constructors.
     */
    {
        patients = new UniquePatientList();
        records = new UniqueRecordList();
        appointments = new UniqueAppointmentList();
        patientBeingViewed = new UniquePatientList();
    }

    public AddressBook() {
    }

    /**
     * Creates an AddressBook using the Patients in the {@code toBeCopied}
     */
    public AddressBook(ReadOnlyAddressBook toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the patient list with {@code patients}.
     * {@code patients} must not contain duplicate patients.
     */
    public void setPatients(List<Patient> patients) {
        this.patients.setPatients(patients);
    }

    public void setRecords(Patient patient) {
        ArrayList<Patient> beingViewed = new ArrayList<>();
        beingViewed.add(patient);
        this.patientBeingViewed.setPatients(beingViewed);
        this.records.setRecords(patient.getRecords());
    }

    /**
     * Resets the existing data of this {@code AddressBook} with {@code newData}.
     */
    public void resetData(ReadOnlyAddressBook newData) {
        requireNonNull(newData);

        List<Patient> fullList = newData.getPatientList();
        setPatients(fullList);
    }

    //// patient-level operations

    /**
     * Returns true if a patient with the same identity as {@code patient} exists in
     * the address book.
     */
    public boolean hasPatient(Patient patient) {
        requireNonNull(patient);
        return patients.contains(patient);
    }

    /**
     * Adds a patient to the address book.
     * The patient must not already exist in the address book.
     */
    public void addPatient(Patient p) {
        patients.add(p);
    }

    /**
     * Replaces the given patient {@code target} in the list with
     * {@code editedPatient}.
     * {@code target} must exist in the address book.
     * The patient identity of {@code editedPatient} must not be the same as another
     * existing patient in the address book.
     */
    public void setPatient(Patient target, Patient editedPatient) {
        requireNonNull(editedPatient);

        patients.setPatient(target, editedPatient);
    }

    /**
     * Removes {@code key} from this {@code AddressBook}.
     * {@code key} must exist in the address book.
     */
    public void removePatient(Patient key) {
        patients.remove(key);
    }

    //// util methods

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("patients", patients)
                .toString();
    }

    @Override
    public ObservableList<Patient> getPatientList() {
        return patients.asUnmodifiableObservableList();
    }

    public ObservableList<Record> getRecordList() {
        return records.asUnmodifiableObservableList();
    }

    public ObservableList<Appointment> getAppointmentList() {
        resetAppointmentList();
        return appointments.asUnmodifiableObservableList();
    }

    /**
     * Resets the appointment list to include all appointments from all patients.
     */
    public void resetAppointmentList() {
        UniqueAppointmentList newList = new UniqueAppointmentList();
        for (Patient patient : patients) {
            for (Appointment appointment : patient.getAppointments()) {
                newList.add(appointment);
            }
        }
        appointments.setAppointments(newList);
    }

    public ObservableList<Patient> getPatientBeingViewed() {
        return patientBeingViewed.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof AddressBook)) {
            return false;
        }

        AddressBook otherAddressBook = (AddressBook) other;
        return patients.equals(otherAddressBook.patients);
    }

    @Override
    public int hashCode() {
        return patients.hashCode();
    }
}

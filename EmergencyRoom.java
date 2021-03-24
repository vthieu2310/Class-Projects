/*
 * represents an emergency room in a hospital
 */

public class EmergencyRoom {

	private PriorityQueue patients;

	/*
 	 * constructor that initializes patients to a default-sized priority queue
	 */
	public EmergencyRoom() {
		patients = new HeapPriorityQueue();
		// TODO: implement this
	}

	/*
	 * constructor that initializes patients to a priority queue of given size
	 * Precondition: size > 0
	 */
	public EmergencyRoom(int size) {
		patients = new HeapPriorityQueue(size);
		// TODO: implement this
	}


	/* Purpose: add given Patient p to patients or prints
	 *          a notification message if patients is full
	 * Parameters: Patient p - the patient who just arrived at
	 *             the emergency room and needs to be added
	 * Returns: void - nothing
	 */
	public void addPatient(Patient p) {
		// TODO: implement this
		try{
			patients.insert(p);
		}catch(HeapFullException e){
			System.out.println("Heap is full now");
		}

	}


	/* Purpose: gets the number of patients waiting to be helped
	 * Parameters: none
	 * Returns: int - number of patients waiting to be helped
	 */
	public int numPatientsWaiting() {
		// TODO: implement this
		return patients.size(); // so it compiles
	}


	/* Purpose: removes and returns the next patient from patients
	 * Parameters: none
	 * Returns: Patient - the next patient, null if there is no more patients.
	 */
	public Patient nextPatient() {
		// TODO: implement this
		Patient result = null;
		if(patients.isEmpty()){
			return null;
		}
		result = (Patient) patients.removeMin();
		return result; // so it compiles
	}
}

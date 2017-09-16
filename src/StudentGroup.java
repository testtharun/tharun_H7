import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		return students;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
        			for(int i=0;i<students.length;i++)
			this.students[i] = new Student(students[i].getId(), students[i].getFullName(), students[i].getBirthDate(), students[i].getAvgMark());
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
			return students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
				if(student == null)
			throw new IllegalArgumentException("Illegal argument");
		if(index<0 || index>=students.length)
			throw new IllegalArgumentException("Illegal argument");
 
		students[index] = student;
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
				if(student == null)
			throw new IllegalArgumentException("Illegal argument");
 
		Student temp[] = new Student[students.length+1];
 
		temp[0] = student;
		for(int i=0;i<students.length;i++)
			temp[i+1] = students[i];
		students = temp;
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
				if(student == null)
			throw new IllegalArgumentException("Illegal argument");
 
		Student temp[] = new Student[students.length+1];
		for(int i=0;i<students.length;i++)
			temp[i] = students[i];
		temp[students.length] = student;
		students = temp;
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
				if(student == null)
			throw new IllegalArgumentException("Illegal argument");
		if(index<0 || index>=students.length)
			throw new IllegalArgumentException("Illegal argument");
 
		Student temp[] = new Student[students.length+1];
 
		for(int i=0;i<index;i++)
			temp[i] = students[i];
 
		temp[index] = student;
 
		for(int i=index;i<students.length;i++)
			temp[i+1] = students[i];
 
		students = new Student[temp.length];
		students = temp;
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
				if(index<0 || index>=students.length)
			throw new IllegalArgumentException("Invalid length");
		Student temp[] = new Student[students.length-1];
		int count = 0;
		for(int i=0;i<students.length;i++)
			if(i!=index)
				temp[count++] = students[i];
 
		students = temp;
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
				if(student == null)
			throw new IllegalArgumentException("Null value");
 
		boolean contains = false;
		for(int i=0;i<students.length;i++)
			if(students[i].equals(student))
			{
				contains = true;
				break;
			}
		if(!contains)
			throw new IllegalArgumentException("Student not exist");
		else
		{
			Student temp[] = new Student[students.length-1];
			int count = 0;
			for(int i=0;i<students.length;i++)
				if(!students[i].equals(student))
					temp[count++] = students[i];
			students = temp;			
		}
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
				if(index<0 || index>=students.length)
			throw new IllegalArgumentException("Illegal value");
		Student temp[] = new Student[index+1];
		for(int i=0;i<=index;i++)
			temp[i] = students[i];
		students = temp;
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
				if(student == null)
			throw new IllegalArgumentException("Null value");
		int pos = 0;
		for(int i=0;i<students.length;i++)
			if(students[i].equals(student))
			{
				pos = i;
				break;
			}
		Student temp[] = new Student[pos+1];
		for(int i=0;i<=pos;i++)
			temp[i] = students[i];
		students = temp;
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
				if(index<0 || index>=students.length)
			throw new IllegalArgumentException("Illegal value");
		Student temp[] = new Student[students.length-index];
		int count = 0;
		for(int i=index;i<students.length;i++)
			temp[count++] = students[i];
		students = temp;
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
				if(student == null)
			throw new IllegalArgumentException("Null Value");
		int pos = 0;
		for(int i=0;i<students.length;i++)
			if(students[i].equals(student))
			{
				pos = i;
				break;
			}
		Student temp[] = new Student[students.length-pos];
		int count = 0;
		for(int i=pos;i<students.length;i++)
			temp[count++] = students[i];
		students = temp;
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		int n=this.students.length;
		for(int i=0;i<n-1;i++)
			for(int j=0;j<n-i-1;j++)
				if((this.students[j]).isGreaterThan(this.students[j+1]))
				{
                                   Student student= new Student();
				    student=this.students[i];
				    this.students[i]=this.students[j];
		    		    this.students[j]=student;	
                                 }
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
				int count = 0;
		for(int i=0;i<students.length;i++)
			if(students[i].getBirthDate().equals(date))
				count++;
		Student temp[] = new Student[count];
		count = 0;
		for(int i=0;i<students.length;i++)
			if(students[i].getBirthDate().equals(date))
				temp[count++] = students[i];
		return temp;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
				double max = -1;
		for(int i=0;i<students.length;i++)
			if(max < students[i].getAvgMark())
				max = students[i].getAvgMark;
 
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
				if(student == null)
			throw new IllegalArgumentException("Illegal");
		int pos = 0;
		for(int i=0;i<students.length;i++)
			if(students[i].equals(student))
			{
				pos = i;
				break;
			}
			return students[pos+1];
	}
	}
}

package labcodeinspection;

import java.util.Locale;

public class Email {

	private final String m_firstName;
	private final String m_lastName;
	private String password;
	private String department;
	private final int defaultpasswordLength = 8;
	private String email;

	/**
	 * Constructs an Email object with the specified first and last names.
	 *
	 * @param firstName the first name of the user
	 * @param lastName  the last name of the user
	 */
	public Email(String firstName, String lastName) {
		this.m_firstName = firstName;
		this.m_lastName = lastName;
	}

	/**
	 * Displays the user's information, including first name, last name, department,
	 * email, and password.
	 */
	public void showInfo() {
		System.out.println("\nFIRST NAME= " + m_firstName + "\nLAST NAME= " + m_lastName);
		System.out.println("DEPARMENT= " + department + "\nEMAIL= " + email + "\nPASSWORD= " + password);
	}

	/**
	 * Sets the department based on the department choice code.
	 *
	 * @param depChoice the department choice code (1 for sales, 2 for development,
	 *                  3 for accounting)
	 */
	public void setDeparment(int depChoice) {
		switch (depChoice) {
		case 1:
			this.department = "sales";
			break;
		case 2:
			this.department = "dev";
			break;
		case 3:
			this.department = "acct";
			break;
		default:
			this.department = "unknown";
			break;
		}
	}

	private String randomPassword(int length) {
		String set = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890#$&@*";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * set.length());
			password[i] = set.charAt(rand);
		}
		return new String(password);
	}

	/**
	 * Generates the email address and password for the user. The email address is
	 * created by combining the user's first and last names with the department
	 * name.
	 */
	public void generateEmail() {
		this.password = this.randomPassword(this.defaultpasswordLength);
		this.email = this.m_firstName.toLowerCase(Locale.ROOT) + this.m_lastName.toLowerCase(Locale.ROOT) + "@" + this.department
				+ ".espol.edu.ec";
	}
}

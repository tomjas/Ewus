package pl.gov.nfz.ewus.component;

import org.springframework.stereotype.Component;

import pl.gov.nfz.ewus.model.Person;
import pl.gov.nfz.ewus.model.Person.Sex;

/**
 * @author Tomasz Lubinski www.algorym.org (c) 2005
 *
 *         Class for PESEL validating
 */

@Component
public class PeselValidatorImpl implements PeselValidator {

	public PeselValidatorImpl() {
	}

	private byte PESEL[] = new byte[11];
	private boolean valid = false;

	@Override
	public void validate(String PESELNumber) {
		if (PESELNumber.length() != 11) {
			valid = false;
		} else {
			for (int i = 0; i < 11; i++) {
				PESEL[i] = Byte.parseByte(PESELNumber.substring(i, i + 1));
			}
			if (checkSum() && checkMonth() && checkDay()) {
				valid = true;
			} else {
				valid = false;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pl.gov.nfz.ewus.PeselValidator#isValid()
	 */
	@Override
	public boolean isValid() {
		return valid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pl.gov.nfz.ewus.PeselValidator#getBirthYear()
	 */
	@Override
	public int getBirthYear() {
		int year;
		int month;
		year = 10 * PESEL[0];
		year += PESEL[1];
		month = 10 * PESEL[2];
		month += PESEL[3];
		if (month > 80 && month < 93) {
			year += 1800;
		} else if (month > 0 && month < 13) {
			year += 1900;
		} else if (month > 20 && month < 33) {
			year += 2000;
		} else if (month > 40 && month < 53) {
			year += 2100;
		} else if (month > 60 && month < 73) {
			year += 2200;
		}
		return year;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pl.gov.nfz.ewus.PeselValidator#getBirthMonth()
	 */
	@Override
	public int getBirthMonth() {
		int month;
		month = 10 * PESEL[2];
		month += PESEL[3];
		if (month > 80 && month < 93) {
			month -= 80;
		} else if (month > 20 && month < 33) {
			month -= 20;
		} else if (month > 40 && month < 53) {
			month -= 40;
		} else if (month > 60 && month < 73) {
			month -= 60;
		}
		return month;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pl.gov.nfz.ewus.PeselValidator#getBirthDay()
	 */
	@Override
	public int getBirthDay() {
		int day;
		day = 10 * PESEL[4];
		day += PESEL[5];
		return day;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pl.gov.nfz.ewus.PeselValidator#getSex()
	 */
	@Override
	public Sex getSex() {
		if (valid) {
			if (PESEL[9] % 2 == 1) {
				return Sex.MALE;
			} else {
				return Sex.FEMALE;
			}
		} else {
			return Sex.UNDEFINED;
		}
	}

	public boolean checkSum() {
		int sum = 1 * PESEL[0] + 3 * PESEL[1] + 7 * PESEL[2] + 9 * PESEL[3] + 1 * PESEL[4] + 3 * PESEL[5] + 7 * PESEL[6]
				+ 9 * PESEL[7] + 1 * PESEL[8] + 3 * PESEL[9];
		sum %= 10;
		sum = 10 - sum;
		sum %= 10;

		if (sum == PESEL[10]) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkMonth() {
		int month = getBirthMonth();
		int day = getBirthDay();
		if (month > 0 && month < 13) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkDay() {
		int year = getBirthYear();
		int month = getBirthMonth();
		int day = getBirthDay();
		if ((day > 0 && day < 32)
				&& (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)) {
			return true;
		} else if ((day > 0 && day < 31) && (month == 4 || month == 6 || month == 9 || month == 11)) {
			return true;
		} else if ((day > 0 && day < 30 && leapYear(year)) || (day > 0 && day < 29 && !leapYear(year))) {
			return true;
		} else {
			return false;
		}
	}

	public boolean leapYear(int year) {
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
			return true;
		else
			return false;
	}

}

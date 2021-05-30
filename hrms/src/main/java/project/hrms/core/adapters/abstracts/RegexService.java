package project.hrms.core.adapters.abstracts;

public interface RegexService {

	boolean isPhoneNumberFormat(String phoneNumberFormat);
	boolean isEmailFormat(String emailFormat);
	boolean isNameFormat(String nameFormat);
	boolean isBirthYearFormat(String birthYearFormat);
}

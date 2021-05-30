package project.hrms.business.concretes;

public class constMessages {

	//For User , common messages
	public static String emailCanNotBeNullOrEmpty = "Email boş bırakılamaz";
	public static String passwordCanNotBeNullOrEmpty = "Parola boş bırakılamaz";
	public static String passwordLeastCharacter = "Parola `n` karakterden az olamaz";
	public static String emailNotValid = "Email geçerli değil";
	public static String emailAlreadyExists = "Email sistemde kayıtlı";
	public static String succesfulUserAdd = "Kullanıcı başarıyla kaydedildi";
	
	
	//For Real Users
	public static String firstNameCanNotBeNullOrEmpty = "İsim boş bırakılamaz";
	public static String lastNameCanNotBeNullOrEmpty = "Soyad boş bırakılamaz";
	public static String birtDateCanNotBeNullOrEmpty = "Doğum tarihi boş bırakılamaz";
	public static String identityNumberCanNotBeNullOrEmpty = "TC Kimlik boş bırakılamaz veya 11 karakterden farklı olamaz";
	public static String firstNameLeastCharacter = "İsim `n` karakterden az olamaz";
	public static String lastNameLeastCharacter = "Soyad `n` karakterden az olamaz";
	public static String identityNumberAlreadyExists = "Tc Kimlik no sistemde kayıtlı";
	
	
	//For Companies
	public static String companyNameCanNotBeNullOrEmpty = "Şirket ismi boş bırakalamaz";
	public static String websiteCanNotBeNullOrEmpty = "Website adresi boş bırakalamaz";
	public static String telCanNotBeNullOrEmpty = "Telefon numarası boş bırakılamaz";
	public static String employerEmailAndWebsiteNotMatch = "Şirket websitesi ile mail uyuşmuyor";
	public static String employerIsExist = "Bu mail adresiyle bir şirket kayıtlı";
	public static String employerTempAdded = "Şirket profili oluşturuldu. Lütfen mailinizi kontrol ediniz ve HR onayı bekleyiniz";
	
	//For Jobs
	public static String jobTitleIsExist = "Bu tanımda başka bir iş ilanı mevcuttur";
	public static String jobTitleAdded = "İş ilanı başarıyla eklenmiştir";
	public static String jobFieldAdded = "İş alanı başarıyla eklenmiştir";
	public static String jobOwnerIsNtExist = "Girilen ID'de iş veren bulunmamaktadır";
	public static String jobFieldIsNotExistForAdding = "Bu tanımda iş alanı bulunmamaktadır";
	public static String jobDetailIsExist = "Bu  iş ilanı bulunmaktadır";
	public static String jobDetailIsEmpty = "İş detayı doldurulmalıdır";
	public static String jobLocationIsOk = "İş ilanının şehir bilgisini geçerli giriniz";
	public static String jobSalaryIsOk = "Minimum maaş, maksimum maaştan çok olamaz. İki değer de sıfır olamaz";
	public static String jobQuotaIsOk = "İş ilanı için geçerli pozisyon en az 1 olabilir";

	
	
	public static String userActivated = "user is activated, now you can login."; 
	public static String activationCodeNotFound = "Activation Code not found.";
	public static String googleSignUpSuccessful = "Google Sign-Up authentication Successful"; 
	public static String googleSignUpFailed = "Google Sign-Up authentication Failed";
	public static String userLoggedIn = "User logged in.";
	public static String userEmailOrPasswordNotFound = "Email or Password not found."; 
	
}

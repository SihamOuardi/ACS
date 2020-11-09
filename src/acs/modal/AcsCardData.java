package acs.modal;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;

public class AcsCardData implements java.io.Serializable {

	private static final long serialVersionUID = 7470290554061640612L;
	private AcsCardDataId id;
	private Character statusCard;
	private Date statusDate;
	private String statusReason;
	private String productCode;
	private String familyName;
	private String firstName;
	private String mobileNumber;
	private Date expiryDate;
	private Character lastActionCode;
	private Date lastActionDate;
	private Character vbvActivationStatus;
	private Date vbvActivationDate;
	private String cardNbrTrunk;
	private String documentType;
	private String documentCode;
	private String adressEmail;
	private Character authenType;
	private String staticPassword;
	private Date cardCapturingDate;
	private Character recordOrigine;
	private Character firstAuthen;
	private Character hasQuestion;
	private String question;
	private String answer;

	public AcsCardData() {
	}

	public AcsCardData(AcsCardDataId id) {
		this.id = id;
	}

	public AcsCardData(AcsCardDataId id, Character statusCard, Date statusDate,
			String statusReason, String productCode, String familyName,
			String firstName, String mobileNumber, Date expiryDate,
			Character lastActionCode, Date lastActionDate,
			Character vbvActivationStatus, Date vbvActivationDate,
			String cardNbrTrunk, String documentType, String documentCode,
			String adressEmail, Character authenType, String staticPassword,
			Date cardCapturingDate, Character recordOrigine,
			Character firstAuthen, Character hasQuestion, String question,
			String answer) {
		this.id = id;
		this.statusCard = statusCard;
		this.statusDate = statusDate;
		this.statusReason = statusReason;
		this.productCode = productCode;
		this.familyName = familyName;
		this.firstName = firstName;
		this.mobileNumber = mobileNumber;
		this.expiryDate = expiryDate;
		this.lastActionCode = lastActionCode;
		this.lastActionDate = lastActionDate;
		this.vbvActivationStatus = vbvActivationStatus;
		this.vbvActivationDate = vbvActivationDate;
		this.cardNbrTrunk = cardNbrTrunk;
		this.documentType = documentType;
		this.documentCode = documentCode;
		this.adressEmail = adressEmail;
		this.authenType = authenType;
		this.staticPassword = staticPassword;
		this.cardCapturingDate = cardCapturingDate;
		this.recordOrigine = recordOrigine;
		this.firstAuthen = firstAuthen;
		this.hasQuestion = hasQuestion;
		this.question = question;
		this.answer = answer;
	}

	@EmbeddedId
	@AttributeOverrides({			
		    @AttributeOverride(name = "cardNumber", column = @Column(name = "CARD_NUMBER", length = 22)),
			@AttributeOverride(name = "institutionCode", column = @Column(name = "INSTITUTION_CODE", length = 5)), 
			})
	public AcsCardDataId getId() {
		return this.id;
	}

	public void setId(AcsCardDataId id) {
		this.id = id;
	}

	@Column(name = "STATUS_CARD", length = 1)
	public Character getStatusCard() {
		return this.statusCard;
	}

	public void setStatusCard(Character statusCard) {
		this.statusCard = statusCard;
	}
	@Column(name = "STATUS_DATE", length = 7)
	public Date getStatusDate() {
		return this.statusDate;
	}

	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}
	@Column(name = "STATUS_REASON", length = 2)

	public String getStatusReason() {
		return this.statusReason;
	}

	public void setStatusReason(String statusReason) {
		this.statusReason = statusReason;
	}
	@Column(name = "PRODUCT_CODE", length = 3)
	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	@Column(name = "FAMILY_NAME", length = 1000)
	public String getFamilyName() {
		return this.familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	@Column(name = "FIRST_NAME", length = 1000)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "MOBILE_NUMBER", length = 1000)
	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	@Column(name = "EXPIRY_DATE", length = 1000)
	public Date getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	@Column(name = "LAST_ACTION_CODE", length = 1000)
	public Character getLastActionCode() {
		return this.lastActionCode;
	}

	public void setLastActionCode(Character lastActionCode) {
		this.lastActionCode = lastActionCode;
	}
	
	@Column(name = "LAST_ACTION_DATE", length = 1000)
	public Date getLastActionDate() {
		return this.lastActionDate;
	}

	public void setLastActionDate(Date lastActionDate) {
		this.lastActionDate = lastActionDate;
	}
	
	@Column(name = "VBV_ACTIVATION_STATUS", length = 1000)
	public Character getVbvActivationStatus() {
		return this.vbvActivationStatus;
	}

	public void setVbvActivationStatus(Character vbvActivationStatus) {
		this.vbvActivationStatus = vbvActivationStatus;
	}
	
	@Column(name = "VBV_ACTIVATION_DATE", length = 1000)
	public Date getVbvActivationDate() {
		return this.vbvActivationDate;
	}

	public void setVbvActivationDate(Date vbvActivationDate) {
		this.vbvActivationDate = vbvActivationDate;
	}
	
	@Column(name = "CARD_NBR_TRUNK", length = 1000)
	public String getCardNbrTrunk() {
		return this.cardNbrTrunk;
	}

	public void setCardNbrTrunk(String cardNbrTrunk) {
		this.cardNbrTrunk = cardNbrTrunk;
	}
	
	@Column(name = "DOCUMENT_TYPE", length = 1000)
	public String getDocumentType() {
		return this.documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	
	@Column(name = "DOCUMENT_CODE", length = 1000)
	public String getDocumentCode() {
		return this.documentCode;
	}

	public void setDocumentCode(String documentCode) {
		this.documentCode = documentCode;
	}
	
	@Column(name = "ADRESS_EMAIL", length = 1000)
	public String getAdressEmail() {
		return this.adressEmail;
	}

	public void setAdressEmail(String adressEmail) {
		this.adressEmail = adressEmail;
	}
	
	@Column(name = "AUTHEN_TYPE", length = 1000)
	public Character getAuthenType() {
		return this.authenType;
	}

	public void setAuthenType(Character authenType) {
		this.authenType = authenType;
	}
	
	@Column(name = "STATIC_PASSWORD", length = 1000)
	public String getStaticPassword() {
		return this.staticPassword;
	}

	public void setStaticPassword(String staticPassword) {
		this.staticPassword = staticPassword;
	}
	
	@Column(name = "CARD_CAPTURING_DATE", length = 1000)
	public Date getCardCapturingDate() {
		return this.cardCapturingDate;
	}

	public void setCardCapturingDate(Date cardCapturingDate) {
		this.cardCapturingDate = cardCapturingDate;
	}
	
	@Column(name = "RECORD_ORIGINE", length = 1)
	public Character getRecordOrigine() {
		return this.recordOrigine;
	}

	public void setRecordOrigine(Character recordOrigine) {
		this.recordOrigine = recordOrigine;
	}
	
	@Column(name = "FIRST_AUTHEN", length = 1)
	public Character getFirstAuthen() {
		return this.firstAuthen;
	}

	public void setFirstAuthen(Character firstAuthen) {
		this.firstAuthen = firstAuthen;
	}
	
	@Column(name = "HAS_QUESTION", length = 1000)
	public Character getHasQuestion() {
		return this.hasQuestion;
	}

	public void setHasQuestion(Character hasQuestion) {
		this.hasQuestion = hasQuestion;
	}
	
	@Column(name = "QUESTION", length = 1000)
	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	@Column(name = "ANSWER", length = 1000)
	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}

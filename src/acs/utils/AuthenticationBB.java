package acs.utils;


import jBitsLib.iso.ISOUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.PhaseId;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


import org.apache.commons.logging.impl.Log4JLogger;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import acs.dao.DAO;
import acs.modal.AcsCardData;
import acs.modal.AcsCardDataId;
import acs.modal.AcsInstitution;
import acs.modal.AcsPageParams;
import acs.modal.AcsProduct;
import acs.modal.CurrencyCountry;
import acs.modal.FieldDefinition;
import acs.tools.AbstractBB;
import acs.tools.Css;



public class AuthenticationBB  {
	
	
/*	extends AbstractBB {

	
	boolean isTest=false;

	public final Log4JLogger logger = new Log4JLogger(this.getClass().getName());

	private List<FieldDefinition> htmlFields = new ArrayList<>();
	private HashMap<String, Object> tagMap = new HashMap<>();

	private Date trxDAte;
	
	private String cardNumber;
	private String cardTruncated;
	private String amount;
	private String currency;
	private String merchant;
	private String bank;
	private String otpSent;
	private String otpReceived;
	private String merchantUrl;
	private String desc;
	private boolean otpChecked = false;
	private AcsProduct acsProduct;
	private Css style = new Css();
	private Byte numberTries = 0;
	private int currencyExponent = 0;
	private String gsm;
	private String email;
	private String xmlData = "";
	private String xmlPATransReq = "";
	private Document xmlPAReq;
	private String termUrl;
	private String md;
	private String encodedPares;
	boolean isErrorVEReqPareq;  
	private  CurrencyCountry currencyCountry;  
	private DAO dao = new DAO();

	AuthenticationData authenticationData;

	HttpSession httpSsession;
	private final String SESSION_REPOSITORY = "SessionRepository";

	private boolean navigate;
	private String pareq;
	private String cavv;

	private AcsCardData acsCardData = new AcsCardData(new AcsCardDataId());
	// AcsCardOperation cardOp = new AcsCardOperation(new AcsCardOperationId());

	public AuthenticationBB(HttpSession httpSsession) {
		this.httpSsession = httpSsession;
	}

	public void onPageLoad(ComponentSystemEvent event) {
		logger.debug("init - start");
		// FacesContext fc = FacesContext.getCurrentInstance();
		// HttpServletRequest req = (HttpServletRequest)
		// fc.getCurrentInstance().getre

		FacesContext facesContext = FacesContext.getCurrentInstance();
		httpSsession = (HttpSession) facesContext.getExternalContext().getSession(true);
		
		sessionRepository = (SessionRepository) httpSsession.getAttribute(SESSION_REPOSITORY);
		
		// FacesContext facesContext = FacesContext.getCurrentInstance();
		// ExternalContext ec = facesContext.getExternalContext();
		// ServletContext servletContext = (ServletContext) ec.getContext();/
		// sessionRepository =(SessionRepository)
		// servletContext.getAttribute(SESSION_REPOSITORY);

		if (sessionRepository != null) {
			logger.debug("sessionRepository != null");
			authenticationData = sessionRepository.getAuthenticationData();
			if (authenticationData != null) {
				logger.debug("authenticationData != null");
				buildAuthenticationBB();

				getCurrencyWording();
				tagMap.put("BANK", authenticationData.getBank());
				tagMap.put("MERCHANT", authenticationData.getMerchant());
				tagMap.put("AMOUNT", authenticationData.getAmount() + " " + this.currency);
				// tagMap.put("CURRENCY", this.currency);
				tagMap.put("TRX_DATE", authenticationData.getTrxDAte());
				tagMap.put("CARD_NUMBER", this.cardTruncated);
				tagMap.put("MOBILE", authenticationData.getGsm());
				tagMap.put("EMAIL", "");
				tagMap.put("QUESTION", "");
				tagMap.put("ANSWER", "");

				DAO dao = new DAO();

				RangeParameters range = check.getRange(authenticationData.getCardNumber(), dao);
				
				if (range != null) {
					logger.debug("range != null");
					AcsCardDataId id = new AcsCardDataId();
					id.setInstitutionCode(range.getId().getBankCode());
					id.setCardNumber(authenticationData.getCardNumber());
					acsCardData = (AcsCardData) dao.findByIdObject(
							AcsCardData.class, id);
					if (acsCardData != null) {
						logger.debug("acsCardData != null");
						loadAcsProduct(range.getId().getBankCode(),
								acsCardData.getProductCode());
						
						if (authenticationData.isSuccessfulQst()) {
							logger.debug("isSuccessfulQst ");
							if (acsProduct != null) {
								logger.debug(" acsProduct != null ");
								loadCss();
								getCurrencyWording();
								buildFIelds("authentication");
								checkCumulWronPing();
								sendOTP(authenticationData.getAcctID());
							}
						} else {
							logger.debug("  else 111 ");
							checkOTPCode();
						}
					}
				}
			}
		}

		logger.debug("init - end");
	}

	public AuthenticationBB() {
	}

	public void buildAuthenticationBB() {
		logger.debug("buildAuthenticationBB ->");
		this.amount = authenticationData.getAmount(); // this.amount = new
														// BigDecimal(authenticationData.getAmount());
		this.currency = authenticationData.getCurrency();

		this.cardNumber = authenticationData.getCardNumber();
		this.cardTruncated = this.cardNumber.substring(0, 4)
				+ "********"
				+ this.cardNumber.substring(this.cardNumber.length() - 4,
						this.cardNumber.length());
		this.trxDAte = authenticationData.getTrxDAte();
		this.merchant = authenticationData.getMerchant();
		this.merchantUrl = authenticationData.getMerchantUrl();
		this.gsm = authenticationData.getGsm();
		logger.info(this.gsm);
		logger.debug("<- buildAuthenticationBB");
	}

	public void sendOTP(String acctID) {
		logger.debug("sendOTP ->");
		logger.debug("<- sendOTP");
	}

	@SuppressWarnings("unchecked")
	private List<FieldDefinition> buildFIelds(String page) {
		logger.debug("buildFIelds ->");
		htmlFields.clear();

		DAO dao = new DAO();

		List<FieldDefinition> fields = dao.findByGenCriteria(
				FieldDefinition.class, " where page ='" + page
						+ "' order by position asc");

		for (FieldDefinition field : fields) {
			if (field.getStatus().equals('1')) {
				if (tagMap.get(field.getId().getTag()) != null) {
					if (field.getType().equals("DATE")) {
						Date date = (Date) tagMap.get(field.getId().getTag());
						field.setDateValue(date);
					} else
						field.setValue(tagMap.get(field.getId().getTag())
								.toString());
				}
				htmlFields.add(field);
				// logger.info("label " + field.getTitle() + " name "+
				// field.getValue() + " val " + field.getTitle());
			}
		}
		logger.debug("<- buildFIelds");
		return htmlFields;
	}

	public void getCurrencyWording() {
		logger.debug("getCurrencyWording ->");
		DAO dao = new DAO();
		CurrencyCountry currencyCountry = (CurrencyCountry) dao
				.findByGenCriteriaUniqueResult(
						CurrencyCountry.class,
						" where id.currencyCode='"
								+ this.authenticationData.getCurrency() + "'");
		if (currencyCountry != null)
			this.currency = currencyCountry.getId().getIsoCurrencyAlpha();
		logger.debug("<- getCurrencyWording");
	}

	public void loadCss() {
		logger.debug("LoadCss ->");
		DAO dao = new DAO();
		dao.findByIdObject(AcsPageParams.class, "001");
		String cretiria = " as model where 1=1 ";
		List<AcsPageParams> params = dao.findByGenCriteria(AcsPageParams.class,
				cretiria);
		for (Object obj : params) {
			AcsPageParams param = (AcsPageParams) obj;
			switch (param.getTagCode()) {
			case "ITX":
				style.setFldTextSize(param.getTaqPixel());
				style.setFldFontFamily(param.getTaqFont());
				style.setFldBgColor(param.getTaqBgColor());
				style.setFldStyle(param.getTaqFont());
				style.setFldWeight(param.getTagWeight());
				style.setFldColor(param.getTaqFgColor());
				break;
			case "TXT":
				style.setsTextSize(param.getTaqPixel());
				style.setsFontFamily(param.getTaqFont());
				style.setsBgColor(param.getTaqBgColor());
				style.setsStyle(param.getTaqFont());
				style.setsWeight(param.getTagWeight());
				style.setsColor(param.getTaqFgColor());
				break;
			case "LNK":
				style.setlTextSize(param.getTaqPixel());
				style.setlFontFamily(param.getTaqFont());
				style.setlBgColor(param.getTaqBgColor());
				style.setlStyle(param.getTaqFont());
				style.setlWeight(param.getTagWeight());
				style.setlColor(param.getTaqFgColor());
				break;
			case "BTL":
				style.settTextSize(param.getTaqPixel());
				style.settFontFamily(param.getTaqFont());
				style.settBgColor(param.getTaqBgColor());
				style.settStyle(param.getTaqFont());
				style.settWeight(param.getTagWeight());
				style.settColor(param.getTaqFgColor());
				break;
			case "STL":
				style.setsTTextSize(param.getTaqPixel());
				style.setsTFontFamily(param.getTaqFont());
				style.setsTBgColor(param.getTaqBgColor());
				style.setsTStyle(param.getTaqFont());
				style.setsTWeight(param.getTagWeight());
				style.setsTColor(param.getTaqFgColor());
				break;
			case "BTN":
				style.setbTextSize(param.getTaqPixel());
				style.setbFontFamily(param.getTaqFont());
				style.setbBgColor(param.getTaqBgColor());
				style.setbStyle(param.getTaqFont());
				style.setbWeight(param.getTagWeight());
				style.setbColor(param.getTaqFgColor());
				break;
			default:
				break;
			}

		}
		logger.debug("<- LoadCss");
	}

	public void loadAcsProduct(String instCode, String productCode) {
		logger.debug("loadAcsProduct -> instCode" + instCode + " ProdCode " + productCode);
		DAO dao = new DAO();
		AcsProductId id = new AcsProductId(instCode, productCode);
		this.acsProduct = (AcsProduct) dao.findByIdObject(AcsProduct.class, id);
		if(this.acsProduct!=null) {
		logger.info("this.acsProduct " + this.acsProduct.getAcsId());}
		else {
			logger.info("this.acsProduct null " );}
	}

	public StreamedContent getImage() {
		logger.debug("getImage ->");
		FacesContext context = FacesContext.getCurrentInstance();
		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			return new DefaultStreamedContent();
		} else {
			DAO dao = new DAO();
			AcsInstitution inst = (AcsInstitution) dao.findByIdObject(
					AcsInstitution.class, "00100");
			try {
				return new DefaultStreamedContent(inst.getLogo()
						.getBinaryStream(), "image/png");
			} catch (SQLException e) {
				logger.debug(e);
				logger.debug(e.getMessage() + " <- getImage");
				return null;
			}
		}
	}

	public StreamedContent getProductLogo() {
		logger.debug("getProductLogo ->");
		FacesContext context = FacesContext.getCurrentInstance();
		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			return new DefaultStreamedContent();
		} else {
			try {
				return new DefaultStreamedContent(acsProduct.getLogoVisa()
						.getBinaryStream(), "image/png");
			} catch (SQLException e) {
				logger.debug(e.getMessage() + " <- getProductLogo");
				logger.debug(e);
				return null;
			}
		}
	}

	private void checkCumulWronPing() {
		logger.debug("checkCumulWronPing ->");
		if (!authenticationData.isSuccessfulQst()) {
			logger.info("cardOp is null = " + this.cardOp == null);
			logger.info("cardOp.getId().getNumberWrongPin() = "
					+ cardOp.getId().getNumberWrongPin());
			logger.info("has question "
					+ acsCardData.getHasQuestion().equals('Y'));
			logger.info(this.acsProduct.getNumberTries() <= cardOp.getId()
					.getNumberWrongPin());
			if (this.acsProduct.getNumberTries() <= cardOp.getId()
					.getNumberWrongPin()
					&& acsCardData.getHasQuestion().equals('Y')) {
				logger.info("has question "
						+ acsCardData.getHasQuestion().equals('Y'));
				sessionRepository.setAuthenticationData(authenticationData);
				sessionRepository.setCard(acsCardData);
				httpSsession
						.setAttribute(SESSION_REPOSITORY, sessionRepository);
				ActivityLogging.saveSecretQuestionStatus(authenticationData
						.getAcctID()); // CHECK
				navigateTo("checkQuestion");
			} else {
				logger.info("doesn't have question");
				buildPAResXml(GlobalData.AuthenticationSuccessful, GlobalData.acsAuthentFailed);

				navigateTo("authenChecked");
			}
		}
		logger.debug("<- checkCumulWronPing");
	}

	public void checkOTPCode() {
		onPageLoad(null);
		logger.debug("checkOTPCode ->");
		if (acsProduct == null) {
			logger.debug("acsProduct == null");
			// return null;
		} else if (acsProduct.getNumberTries() == null) {
			logger.debug("acsProduct.getNumberTries() == null");
			// return null;
		} else {
			/*
			 * FacesContext fc = FacesContext.getCurrentInstance(); session =
			 * (HttpSession) fc.getExternalContext().getSession( true);
			 * 
			 * SessionRepository sessionRepository = (SessionRepository) session
			 * .getAttribute("SessionRepository");
			 
			OtpEntry otpEntry = sessionRepository.getOtpEntry(otpSent);
			logger.info(" *** authenticationData.isSuccessfulQst()  ****");
			if (authenticationData.isSuccessfulQst()) {
				logger.debug("authenticationData.isSuccessfulQst()");
				if (isValidOtp(otpEntry)) {
					// OTP CODE HASN'T EXPIRED
					logger.info(" otpSent " + otpSent +" otpReceived " + otpReceived);
					if (otpSent.equals(otpReceived)) { // OTP CODE IS CORRECT
						logger.info("CODE IS GOOD");

						//genCavv("1");
						logger.info("PAN: "
								+ StringUtils.leftPad(this.cardNumber.substring(this.cardNumber.length() - 4),this.cardNumber.length() - 4, '0'));
						// String pares = makePaRes();
						genCavv("0", this.cardNumber);
						
						/**
						buildPAResXml(GlobalData.AuthenticationSuccessful,
								GlobalData.acsAuthentOk);
						// this.xmlData = Signing.signXML(xmlData);						
						
						
						PaResMessage paResMessage = checkPaReqDataMatchVeReq(authenticationData.getVeReq(), authenticationData.getPaReqMessage());
						
						paResMessage.setStatus("U");
						paResMessage.setStatusAuth('Y');
						paResMessage.setStatusDesc("");
						paResMessage.setCavv(this.cavv);
						
						paResMessage.setPan(StringUtils.leftPad("", authenticationData.getCardNumber().length(), "0"));
						
						String paResXML = XMLParser.buildPAResXml(
								paResMessage, authenticationData,
								GlobalData.AuthenticationAttempted);
						
						logger.debug("paResXML " + paResXML);
						this.xmlData = paResXML;
						
						encapsulateXML();
					
						// this.xmlData = Signing.signPaRes(xmlData);
						this.xmlData = Signing.signPaResURI(xmlData);
						
						logger.info(this.xmlData); // pares
						
						sendPATransReq();
						//HistoryServerSender.makePost("https://3dsecuretestfacility.com:9660/cth/md/Easy3DSecureLinuxV10",xmlPATransReq);
						Runnable r =  new HistoryThreading(xmlPATransReq);
						new Thread(r).start();
						logger.info("xmlPATransReq " + xmlPATransReq);
						// String pares = Check3D.compress(this.xmlData);

						PaResMessage paresMessage = new PaResMessage();
						paresMessage.setPaRes(this.xmlData);
						
						/** MAW20200627
						paresMessage.setStatusAuth('Y');
						paresMessage.setStatusDesc("");
						paresMessage.setCavv(this.cavv);
						
						
						// saveSuccessActivity();
						// ActivityLogging.saveParesActivity(authenticationData.getAcctID(),
						// paresMessage);
						// buildPAResXml(GlobalData.AuthenticationSuccessful,GlobalData.acsAuthentOk);
						navigate = true;
					} else { // OTP CODE IS WRONG
					//	if (false) { // TODO : uncomment the following
							 if (isNumberOfTriesOK()) { // NUMBER OF TRIES IS
							// OKAY, CAN TRY AGAIN
							numberTries++;
							authenticationData.setNumberTries(this.numberTries);
							saveFailedActivity();
							navigate = false;
						} else { // NUMBER OF TRIES ISN'T OKAY, REJECTED
							// String pares = makePaRes();
							logger.info(" CODE IS NOT GOOD ");
							authenticationData.setNumberTries(this.numberTries);

							PaResMessage paresMessage = new PaResMessage();
							paresMessage.setStatus("N");
							paresMessage.setStatusAuth('N');
							paresMessage.setStatusDesc("NUMBER OF TRIES " + this.numberTries);
							paresMessage.setCavv(getCavv());
							paresMessage.setPan(StringUtils
									.leftPad("", authenticationData
											.getCardNumber().length(), "0"));
							this.xmlData = XMLParser.buildPAResXml(
									paresMessage, authenticationData,
									GlobalData.AuthenticationFailed);
							encapsulateXML();
							this.xmlData = Signing.signPaRes(xmlData);
							logger.info(this.xmlData);
							
							String xmlPATransReq = XMLParser.buildPATransReqXml(authenticationData,this.xmlData);
							//HistoryServerSender.makePost("https://3dsecuretestfacility.com:9660/cth/md/Easy3DSecureLinuxV10",xmlPATransReq);
							Runnable r =  new HistoryThreading(xmlPATransReq);
							new Thread(r).start();

							this.xmlData = Signing.signPaRes(xmlData);

							paresMessage.setPaRes(this.xmlData);
							ActivityLogging.saveParesActivity(
									authenticationData.getAcctID(),
									paresMessage);
							navigate = true;
						}
					}
				} else {
					logger.info("********* else " + numberTries++);
					numberTries++;
					authenticationData.setNumberTries(this.numberTries);
					saveFailedActivity();
					navigate = false;
				}
			} else {
				String pares = makePaRes();

				PaResMessage paresMessage = new PaResMessage();
				paresMessage.setPaRes(pares);
				paresMessage.setStatusAuth('N');
				paresMessage.setStatusDesc("QUESTION IS WRONG");
				paresMessage.setCavv(getCavv());

				ActivityLogging.saveParesActivity(
						authenticationData.getAcctID(), paresMessage);
				authenticationData.setNumberTries(this.numberTries);
				saveFailedActivity();
				navigate = true;
			}

			if (navigate) {
				// this.xmlData = Signing.signXML(xmlData);
				// encapsulateXML();
				// logger.info(this.xmlData);

				// navigateTo("authenChecked");
			
			 logger.debug("signedPaRes " + this.xmlData);
			byte[] compressedPares = Compressor.compress(this.xmlData);
			// logger.debug("compressedPares " + compressedPares);
			encodedPares = DatatypeConverter
					.printBase64Binary(compressedPares);
			 logger.debug("encodedPares " + encodedPares);

			
			 logger.debug("checkOTPCode :: Send reply to client");

			
		
		    this.termUrl = authenticationData.getTermUrl();
		    this.md = authenticationData.getMd();
		    
		    if(!isTest) { // testing with Visa CTH or PIT
			    try {
			    	FacesContext fc = FacesContext.getCurrentInstance();
				    ExternalContext ec = fc.getExternalContext();

					 ec.redirect(ec.getRequestContextPath()+"/redirect.xhtml");
				}catch (IOException e) {
				    // TODO Auto-generated catch block
				    logger.fatal("",e);
				}
		    }
			}
		    logger.debug("<- checkOTPCode");
			
			// return "";
		}
	}

	private String makePaRes() {
		buildPAResXml(GlobalData.AuthenticationSuccessful,
				GlobalData.acsAuthentFailed);
		return Check3D.compress(this.xmlData);
	}

	private boolean isNumberOfTriesOK() {
		logger.debug("isNumberOfTriesOK ->");
		if (this.acsProduct.getNumberTries() > this.numberTries) {
			logger.info("WRONG CODE NUMBER OF TIES LESS THAN MAX");
			String pwdError = BuildMessage.getMessageResourceString(
					"i18n.messages", "pwdError", null, FacesContext
							.getCurrentInstance().getViewRoot().getLocale());
			BuildMessage.addMessage(null, "",
					(this.acsProduct.getNumberTries() - this.numberTries) + " "
							+ pwdError, FacesMessage.SEVERITY_ERROR);
			logger.debug((this.acsProduct.getNumberTries() - this.numberTries)
					+ " " + pwdError);
			return true;
		} else {
			logger.info("WRONG CODE NUMBER OF TRIES HIGH THAN MAX");
			buildPAResXml(GlobalData.AuthenticationFailed,
					GlobalData.acsAuthentFailed);
			logger.debug("WRONG CODE NUMBER OF TRIES HIGH THAN MAX");
			return false;
		}
	}

	public void sendPATransReq() {
		logger.debug("sendPATransReq ->");
		buildPATransReqXml();
		logger.debug("<- sendPATransReq");
	}

	/*
	 * public void checkOTP() throws IOException { logger.debug("checkOTP"); //
	 * boolean navigate = false; if (this.acsProduct != null) {
	 * logger.debug("this.acsProduct != null"); /* FacesContext fc =
	 * FacesContext.getCurrentInstance();
	 * 
	 * session = (HttpSession) fc.getExternalContext() .getSession(true);
	 * SessionRepository sessionRepository = (SessionRepository) session
	 * .getAttribute("SessionRepository");
	 */
	/*
	 * OtpEntry otpEntry = sessionRepository.getOtpEntry(otpSent);
	 * 
	 * if (isValidOtp(otpEntry)) { logger.debug("isValidOtp(otpEntry)"); if
	 * (otpSent.equals(otpReceived)) { logger.info("CODE IS GOOD");
	 * buildXml(GlobalData.AuthenticationSuccessful, GlobalData.acsAuthentOk);
	 * //saveSuccessActivity(); navigate = true; // NavigateTo("authenChecked");
	 * } else if (this.acsProduct.getNumberTries() > this.numberTries) {
	 * logger.info("WRONG CODE NUMBER OF TIES LESS THAN MAX"); String pwdError =
	 * BuildMessage.getMessageResourceString( "i18n.messages", "pwdError", null,
	 * FacesContext .getCurrentInstance().getViewRoot() .getLocale());
	 * BuildMessage .addMessage( null, "", (this.acsProduct.getNumberTries() -
	 * this.numberTries) + " " + pwdError, FacesMessage.SEVERITY_ERROR);
	 * numberTries++; authenticationData.setNumberTries(this.numberTries);
	 * //saveFailedActivity(); } else if (this.acsProduct.getNumberTries() <=
	 * this.numberTries) {
	 * logger.info("WRONG CODE NUMBER OF TRIES HIGH THAN MAX");
	 * buildXml(GlobalData.AuthenticationFailed, GlobalData.acsAuthentFailed);
	 * authenticationData.setNumberTries(this.numberTries);
	 * //saveFailedActivity(); navigate = true; // NavigateTo("authenChecked");
	 * } } else { /* logger.info("OTP EXPIRED"); String pwdError =
	 * BuildMessage.getMessageResourceString( "i18n.messages", "pwdError", null,
	 * FacesContext .getCurrentInstance().getViewRoot() .getLocale());
	 * BuildMessage .addMessage( null, "", (this.acsproduct.getNumberTries() -
	 * this.numberTries) + " OTP HAS EXPIRED ", FacesMessage.SEVERITY_ERROR);
	 * numberTries++; authenticationData.setNumberTries(this.numberTries);
	 * saveFailedActivity(); navigate = false;
	 */
	/*
	 * navigate = false; }
	 */
	/*
	 * } else { logger.info("BAD OTP"); String pwdError = BuildMessage
	 * .getMessageResourceString("i18n.messages", "pwdError", null,
	 * FacesContext.getCurrentInstance() .getViewRoot().getLocale());
	 * BuildMessage.addMessage(null, "", (this.acsproduct.getNumberTries() -
	 * this.numberTries) + " WRONG OTP CODE ", FacesMessage.SEVERITY_ERROR);
	 * numberTries++; authenticationData.setNumberTries(this.numberTries);
	 * saveFailedActivity(); navigate = false; }
	 */

	/*
	 * } else { logger.info("PRODUCT NOT FOUND");
	 * buildXml(GlobalData.AuthenticationFailed, GlobalData.acsAuthentFailed); }
	 * logger.info("xmldata " + xmlData);
	 * authenticationData.setPaRes(this.xmlData);
	 * Check3D.saveAuthenticationActivity(authenticationData); if (navigate)
	 * NavigateTo("authenChecked"); logger.debug(""); }
	 

	public void saveSuccessActivity() {
		logger.debug("saveSuccessActivity ->");
		DAO dao = new DAO();

		Set<String> keySet = authenticationData.getQuestionAnswer().keySet();
		for (String key : keySet) {
			String answer = authenticationData.getQuestionAnswer().get(key);
			if (answer != null) {
				acsCardData.setQuestion(key);
				acsCardData.setAnswer(answer);
			}
		}

		acsCardData.setLastActionDate(new Date());

		/*
		 * AcsCardData cardFromDB = (AcsCardData) dao
		 * .findByGenCriteriaUniqueResult(AcsCardData.class,
		 * " where id.cardNumber = '" + acsCardData.getId().getCardNumber() +
		 * "' and id.institutionCode='" +
		 * acsCardData.getId().getInstitutionCode() + "'");
		 * 
		 * logger.info(" where id.cardNumber = '" +
		 * acsCardData.getId().getCardNumber() + "' and id.institutionCode='" +
		 * acsCardData.getId().getInstitutionCode() + "'");
		 
		constructCardOp(cardOp);
		/*
		 * if (cardFromDB == null) logger.info("cardFromDB is null"); else {
		 * cardFromDB.setFirstAuthen('N'); cardFromDB.setHasQuestion('Y');
		 * cardFromDB.setLastActionCode('Q');
		 * 
		 * 
		 * }
		 
		cardOp.getId().setNumberWrongPin(Byte.valueOf("0"));
		dao.saveOrUpdate(acsCardData);
		dao.saveOrUpdate(cardOp);
		logger.debug("<- saveSuccessActivity");
	}

	public void saveFailedActivity() {
		logger.debug("saveFailedActivity ->");
		DAO dao = new DAO();
		// acsCardData.setFirstAuthen('N');
		// acsCardData.setHasQuestion('N');
		acsCardData.setLastActionCode('9');
		acsCardData.setLastActionDate(new Date());
		if (numberTries > 2) {
			int cumulWrongPin = cardOp.getCumulWrongPin().intValue() + 1;
			cardOp.setCumulWrongPin(Byte.valueOf(cumulWrongPin + ""));
		}

		constructCardOp(cardOp);
		dao.saveOrUpdate(acsCardData);
		dao.saveOrUpdate(cardOp);
		logger.debug("<- saveFailedActivity");
	}

	@SuppressWarnings("unchecked")
	private AcsCardOperation getCardOperation() {
		logger.debug("getCardOperation ->");
		DAO dao = new DAO();

		List<AcsCardOperation> results = dao.findByGenCriteria(
				AcsCardOperation.class, " where id.cardNumber = '"
						+ acsCardData.getId().getCardNumber()
						+ "' order by id.lastAuthorizationDatetime desc");
		logger.info("results " + results.size());
		for (AcsCardOperation card : results) {
			cardOp = card;
		}
		/*
		 * cardOp = (AcsCardOperation) dao.findByGenCriteriaUniqueResult(
		 * AcsCardOperation.class, " where id.cardNumber = '" +
		 * acsCardData.getId().getCardNumber() +
		 * "' order by id.lastAuthorizationDatetime desc");
		 

		if (cardOp != null)
			this.numberTries = cardOp.getId().getNumberWrongPin();
		logger.debug("<- getCardOperation");
		return cardOp;
	}

	public void constructCardOp(AcsCardOperation cardOp) {
		logger.debug("constructCardOp ->");
		cardOp.getId().setCardNumber(acsCardData.getId().getCardNumber());
		cardOp.setCardNbrTrunk(acsCardData.getCardNbrTrunk());
		cardOp.setCardProduct(acsCardData.getProductCode());

		cardOp.getId().setNumberWrongPin(
				(byte) authenticationData.getNumberTries());
		cardOp.setExpiryDate(acsCardData.getExpiryDate());
		cardOp.setLastAuthorizationDate((new Date()));
		cardOp.getId().setLastAuthorizationDatetime(
				new Timestamp(Calendar.getInstance().getTimeInMillis()));
		// cardOp.getId().setLastAuthorizationMcc(lastAuthorizationMcc(acsCardData.get));
		// cardOp.getId().setLastAuthorizationResponse(lastAuthorizationResponse(acsCardData.get));
		// cardOp.getId().setLastCountryCode(lastCountryCode(authenticationData.getPaReqMessage().get));
		cardOp.setLastCurrencyCode(authenticationData.getCurrency());
		cardOp.setLastDatePinError(new Date());
		cardOp.getId().setLastTransactionArn(
				authenticationData.getPaReqMessage().getAcctId());
		cardOp.setLastTransactionDate(new Date());
		logger.debug("<- constructCardOp");
	}

	public boolean isValidOtp(OtpEntry otpEntry) {
		logger.debug("isValidOtp ->");
		if (otpEntry != null && otpEntry.getTime() != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(otpEntry.getTime().getTime());
			cal.add(Calendar.MINUTE, 10);
			Timestamp later = new Timestamp(cal.getTime().getTime());
			Timestamp now = new Timestamp(Calendar.getInstance().getTime()
					.getTime());
			if (now.before(later)) {
				logger.debug("now.before(later)");
				return true;
			} else {
				logger.info("OTP EXPIRED");
				BuildMessage.addMessage(null, "",
						(this.acsProduct.getNumberTries() - this.numberTries)
								+ " OTP HAS EXPIRED ",
						FacesMessage.SEVERITY_ERROR);
				numberTries++;
				authenticationData.setNumberTries(this.numberTries);
				navigate = false;
				logger.debug("EXPIRED <- isValidOtp");
				return false;
			}

		} else {
			logger.info("BAD OTP");
			BuildMessage.addMessage(null, "",
					(this.acsProduct.getNumberTries() - this.numberTries)
							+ " WRONG OTP CODE ", FacesMessage.SEVERITY_ERROR);
			numberTries++;
			authenticationData.setNumberTries(this.numberTries);
			navigate = false;
			logger.debug("WRONG <- isValidOtp");
			return false;
		}
	}

	public void cancel() {
		onPageLoad(null);
		logger.debug("Cancel ->");
		PaResMessage paresMessage = new PaResMessage();
		paresMessage.setStatus("N");
		paresMessage.setStatusAuth('N');
		paresMessage.setStatusDesc("Canceled");
		paresMessage.setCavv(getCavv());
		paresMessage.setPan(StringUtils.leftPad("", authenticationData.getCardNumber().length(), "0"));
		this.xmlData = XMLParser.buildPAResXml(	paresMessage, authenticationData,GlobalData.AuthenticationCancel);
		encapsulateXML();
		this.xmlData = Signing.signPaResURI(xmlData);
		
		 logger.debug("signedPaRes " + this.xmlData);
			byte[] compressedPares = Compressor.compress(this.xmlData);
			// logger.debug("compressedPares " + compressedPares);
			encodedPares = DatatypeConverter
					.printBase64Binary(compressedPares);
			 logger.debug("encodedPares " + encodedPares);
		
		
		logger.info(this.xmlData);
		String xmlPATransReq = XMLParser.buildPATransReqXml(authenticationData,this.xmlData);
		//HistoryServerSender.makePost("https://3dsecuretestfacility.com:9660/cth/md/Easy3DSecureLinuxV10",xmlPATransReq);
		
	    this.termUrl = authenticationData.getTermUrl();
		this.md = authenticationData.getMd();
		
		Runnable r =  new HistoryThreading(xmlPATransReq);
		new Thread(r).start();
		paresMessage.setPaRes(this.xmlData);
		ActivityLogging.saveParesActivity(
				authenticationData.getAcctID(),
				paresMessage);
		
		FacesContext fc = FacesContext.getCurrentInstance();
	    ExternalContext ec = fc.getExternalContext();

		 try {
			ec.redirect(ec.getRequestContextPath()+"/redirect.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		//navigate = true;
		//buildPAResXml("3", "N");
		//navigateTo("authenChecked");
		logger.debug("<- Cancel");
	}

	public void resendCode() {
		logger.debug("resendCode ->");
		if (this.gsm == null) {
			printMessage("Mobile phonne isn't defined",
					FacesMessage.SEVERITY_ERROR);
		} else {
			sendOTP(authenticationData.getAcctID());
			printMessage("Code resent", FacesMessage.SEVERITY_INFO);
		}
		logger.debug("<- resendCode");
	}

	public void buildPAResXml(String eci, String status) {
		logger.debug("buildXml ->");
		String xml = "";
		// xml += "<ThreeDSecure> ";
		xml += "<Message id='"
				+ authenticationData.getPaReqMessage().getMessageId() + "'>";
		xml += "<PARes id='id" + RandomStringUtils.randomAlphanumeric(10)
				+ "'>";
		xml += "<version>" + GlobalData.versionNumber // authenticationData.getPaReqMessage().getVersion()
				+ "</version>";
		xml += "<Merchant>";
		xml += "	<acqBIN>" + authenticationData.getPaReqMessage().getAcqBIN()
				+ "</acqBIN>";
		xml += "	<merID>" + authenticationData.getPaReqMessage().getMerId()
				+ "</merID>";
		xml += "</Merchant>";
		xml += "<Purchase>";
		xml += "	<xid>" + authenticationData.getXid() + "</xid>";
		// xml += "	<date>" + authenticationData.getTrxDAte() + "</date>";
		xml += "	<date>"
				+ new SimpleDateFormat("yyyyMMdd HH:mm:ss").format(trxDAte)
				+ "</date>";
		xml += "	<purchAmount>" + this.amount + "</purchAmount>";
		xml += "	<currency>"
				+ authenticationData.getPaReqMessage().getCurrency()
				+ "</currency>";
		xml += "	<exponent>"
				+ authenticationData.getPaReqMessage().getExponent()
				+ "</exponent>";
		xml += "</Purchase>";
		int len = this.cardNumber.length();
		xml += "	<pan>"
				+ StringUtils.leftPad(this.cardNumber.substring(len - 4), len,
						'0') + "</pan>";
		xml += "	<TX>";
		xml += "		<time>" + getCurrentTimeStamp() + "</time>";
		xml += "		<status>" + status + "</status>";
		if (status.equals("Y") || status.equals("A")) {
			// byte[] compressedCavv = Compressor.compress(getCavv());
			logger.debug("gencavv " + getCavv());
			String dumpCavv = "";
			if (authenticationData.getCardNumber().equals("4881001011000"))
				dumpCavv = "0000010501799396022310347279930000000000";
			if (authenticationData.getCardNumber().equals("4012001011000771"))
				dumpCavv = "0000010127799396022310347279930000000000";
			if (authenticationData.getCardNumber()
					.equals("4882001011000771000"))
				dumpCavv = "0000010426799396022310347279930000000000"; // 19

			logger.debug("gencavv " + getCavv() + " " + dumpCavv);
			byte[] compressedCavv = ISOUtil.hex2byte(dumpCavv);
			xml += "		<cavv>"
					+ DatatypeConverter.printBase64Binary(compressedCavv)
					+ "</cavv>";
			xml += "		<eci>" + eci + "</eci>";
			xml += "		<cavvAlgorithm>3</cavvAlgorithm>";
		}
		xml += "	</TX>";
		// xml += "<PaReq>" + authenticationData.getPaReq() + "</PaReq>";
		xml += "</PARes>";
		xml += "</Message>";
		// xml += "</ThreeDSecure>";

		this.xmlData = xml;
		/** MOVING IT
		sendPATransReq();
		HistoryServerSender
				.makePost(
						"https://3dsecuretestfacility.com:9660/cth/md/Easy3DSecureLinuxV10",
						xmlPATransReq);
		logger.info("xmlPATransReq " + xmlPATransReq);
		
		logger.debug("<- buildXml");
	}

	private void encapsulateXML() {
		String data = "<?xml version='1.0' encoding='UTF-8'?>";
		data += "<ThreeDSecure>";
		data += this.xmlData;
		data += "</ThreeDSecure>";
		this.xmlData = data;
		logger.info("xml " + this.xmlData);
	}

	public void buildPATransReqXml() {
		logger.debug("buildXml ->");

		PATransReqMessage paTransReqMessage = new PATransReqMessage();
		// paTransReqMessage.setVersion(authenticationData.getPaReqMessage().getVersion());
		paTransReqMessage.setVersion(GlobalData.versionNumber);
		// logger.debug("mer name " +
		// StringEscapeUtils.escapeHtml4(authenticationData.getPaReqMessage().getMerchantName()));
		
		paTransReqMessage.setMerchantName(authenticationData.getPaReqMessage().getMerchantName());
		//paTransReqMessage.setMerchantName(authenticationData.getPaReqMessage().getMerchantName());
		paTransReqMessage.setMerchantCountry(authenticationData
				.getPaReqMessage().getMerchantCountry());
		paTransReqMessage.setMerchantUrl(authenticationData.getPaReqMessage()
				.getMerchantUrl());
		paTransReqMessage.setAmount(authenticationData.getPaReqMessage()
				.getAmount());
		paTransReqMessage.setDesc(authenticationData.getPaReqMessage()
				.getDesc());
		paTransReqMessage.setRecurFrequeny(authenticationData.getPaReqMessage()
				.getRecurFrequency());
		paTransReqMessage.setEndRecur(authenticationData.getPaReqMessage()
				.getRecurEndRecur());
		paTransReqMessage.setInstall(authenticationData.getPaReqMessage()
				.getInstall());

		paTransReqMessage.setChName(acsCardData.getFirstName() + " "
				+ acsCardData.getFamilyName());
		paTransReqMessage.setChPAN(acsCardData.getId().getCardNumber());
		paTransReqMessage.setChExpiry(authenticationData.getPaReqMessage()
				.getExpiry());
		paTransReqMessage.setAcsID(acsProduct.getAcsId());
		paTransReqMessage.setLoginId(acsProduct.getAcsLogin());
		paTransReqMessage.setPassword(acsProduct.getAcsPassword());
		// paTransReqMessage.setSignature(acsProduct.getsignature);

		authenticationData.setPaTransReqMessage(paTransReqMessage);

		String messageId = checkMessageId(authenticationData.getPaReqMessage().getMessageId());
		
		String xml = "<?xml version='1.0' encoding='UTF-8'?>";
		xml += "<ThreeDSecure>";
		xml += "   <Message id='"
				+ messageId + "'>";
		xml += "      <PATransReq>";
		xml += "         <version>"
				+ authenticationData.getPaTransReqMessage().getVersion()
				+ "</version>";
		xml += "         <Merchant>";
		xml += "            <name>"
				+ authenticationData.getPaTransReqMessage().getMerchantName()
				+ "</name>";
		xml += "            <country>"
				+ authenticationData.getPaTransReqMessage()
						.getMerchantCountry() + "</country>";
		xml += "            <url>"
				+ authenticationData.getPaTransReqMessage().getMerchantUrl()
				+ "</url>";
		xml += "         </Merchant>";
		xml += "         <Purchase>";
		xml += "            <amount>"
				+ authenticationData.getPaTransReqMessage().getAmount()
				+ "</amount>";
		logger.info("desc: "
				+ authenticationData.getPaTransReqMessage().getDesc());

		if (authenticationData.getPaTransReqMessage().getDesc() != null
				&& !authenticationData.getPaTransReqMessage().getDesc()
						.isEmpty())
			xml += "<desc>"
					+ authenticationData.getPaTransReqMessage().getDesc()
					+ "</desc>";
		if (authenticationData.getPaTransReqMessage().getInstall() != null)
			xml += "            <install>"
					+ authenticationData.getPaTransReqMessage().getInstall()
					+ "</install>";

		if (authenticationData.getPaTransReqMessage().getRecurFrequeny() != null
				&& authenticationData.getPaTransReqMessage().getEndRecur() != null) {
			xml += "<Recur>";
			xml += "		<frequency>"
					+ authenticationData.getPaTransReqMessage()
							.getRecurFrequeny() + "</frequency>";
			xml += "		<endRecur>"
					+ authenticationData.getPaTransReqMessage().getEndRecur()
					+ "</endRecur>";
			xml += "</Recur>";
		}

		xml += "         </Purchase>";
		xml += "         <CH>";
		xml += "            <name>"
				+ authenticationData.getPaTransReqMessage().getChName()
				+ "</name>";
		xml += "            <fullPAN>"
				+ authenticationData.getPaTransReqMessage().getChPAN()
				+ "</fullPAN>";
		xml += "            <expiry>"
				+ authenticationData.getPaTransReqMessage().getChExpiry()
				+ "</expiry>";
		xml += "         </CH>";
		xml += "         <ACSAuth>";
		xml += "            <acsId>PITTestACS"
		// + authenticationData.getPaTransReqMessage().getAcsID()
				+ "</acsId>";
		xml += "            <loginId>PITTestACS"
		// + authenticationData.getPaTransReqMessage().getLoginId()
				+ "</loginId>";
		xml += "            <password>" // +
												// authenticationData.getPaTransReqMessage().getPassword()
				+ "</password>";
		xml += "         </ACSAuth>";
		logger.debug("authenticationData.getPaReqMessage().getPaReqXML() " + authenticationData.getPaReqMessage().getPaReqXML());
		logger.debug("authenticationData.getPaReqXML() " + authenticationData.getPaReqXML());
		if(unescape(authenticationData.getPaReqMessage().getMerchantName())) // || hasWhiteSpace(authenticationData.getPaReqMessage().getPaReqXML()))
			xml += "         <SignedPARes>" + this.xmlData.substring(this.xmlData.indexOf("<PARes")).replace("</Message></ThreeDSecure>", "")+ "</SignedPARes>";
		else
			xml += authenticationData.getPaReqMessage().getPaReqXML().substring(authenticationData.getPaReqMessage().getPaReqXML().indexOf("<PAReq")).replace("</Message>","").replace("</ThreeDSecure>", "");
		//xml += "         <PAReq>" + PATransReqPAReq(authenticationData.getPaReqXML()).replace("\"", "&amp;quot;").replace("à", new String(ISOUtil.hex2byte("C3A0"))).replace("Ã ", "&amp;#xE0").replace("&amp;quot;true&amp;quot;", "\"true\"").replace("&amp;quot;false&amp;quot;", "\"false\"").replace("&amp;quot;id&amp;quot;", "\"id\"");
		//xml += authenticationData.getPaReqXML().substring(authenticationData.getPaReqXML().indexOf("?>")+2).replace("\"", "&amp;quot;").replace("à", new String(ISOUtil.hex2byte("C3A0"))).replace("Ã ", "&amp;#xE0").replace("&amp;quot;true&amp;quot;", "\"true\"").replace("&amp;quot;false&amp;quot;", "\"false\"").replace("&amp;quot;id&amp;quot;", "\"id\"");
		// xml += "         </PAReq>";
		xml += "      </PATransReq>";
		xml += "   </Message>";
		xml += "</ThreeDSecure>";

		logger.info("xml " + xml);

		this.xmlPATransReq = xml;
		logger.debug("<- buildXml");
	}

	private boolean unescape(String merchantName) {
		String out = StringEscapeUtils.escapeHtml4(merchantName);
		logger.debug("unescape " + merchantName + " " + merchantName.length() + " " + out.length());
		if (out.length() == merchantName.length())
			return false;
		else
			return true;
	}
	
	private boolean hasWhiteSpace(String pareq) {
		return (pareq.trim().contains("> "));			
	}

	public String PATransReqPAReq(String xmlIN) {
		DocumentBuilder db;
		Document doc = null;
		String output = "";
		try {
			db = DocumentBuilderFactory.newInstance().newDocumentBuilder();

			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(xmlIN));

			doc = db.parse(is);

			NodeList nodes = doc.getElementsByTagName("PAReq");
			Element el = null;
			for (int i = 0; i < nodes.getLength(); i++) {
				Element element = (Element) nodes.item(i).getChildNodes();
				el = element;
			}

			/*
			 * if (el.getElementsByTagName("desc").getLength() == 0) { Element
			 * desc = doc.createElement("desc"); Node purchase =
			 * doc.getElementsByTagName("Purchase").item(0);
			 * purchase.appendChild(desc); }
			 

			StringWriter buf = new StringWriter();
			Transformer xform = TransformerFactory.newInstance()
					.newTransformer();
			xform.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			xform.setOutputProperty(OutputKeys.INDENT, "no");
			xform.transform(new DOMSource(el), new StreamResult(buf));
			System.out.println(); // your string

			output = buf.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	}

	private void genCavv(String authCode, String cardNumber) {
		String myClearCVK = "0123456789ABCDEFFEDCBA9876543210";
		//String pan = "4123456789012345";
		
		String atn = genATN(); //"9602231034727993";
		String upn = atn.substring(atn.length()-4, atn.length());
		//String arc = "7";
		String sfarc = "00";
		String cki = "01";
		
		String cvv2 = "0"+GenAcsCvv2.genCvv2(myClearCVK, cardNumber, upn, authCode, sfarc);
		System.out.println(cvv2);
		String cavv1 = "0"+authCode+sfarc+cki+cvv2+upn+atn;
		System.out.println(cavv1);
		cavv = StringUtils.rightPad(cavv1,40, "0") ;
	}
	
	private String genATN(){						
		return RandomStringUtils.randomNumeric(16);
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getGsm() {
		return gsm;
	}

	public void setGsm(String gsm) {
		this.gsm = gsm;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getMerchant() {
		return merchant;
	}

	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}

	public String getBank() {
		return bank;
	}

	
	public String getMd() {
		return md;
	}

	public void setMd(String md) {
		this.md = md;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getOtpSent() {
		return otpSent;
	}

	public void setOtpSent(String otpSent) {
		this.otpSent = otpSent;
	}

	public String getOtpReceived() {
		return otpReceived;
	}

	public void setOtpReceived(String otpReceived) {
		this.otpReceived = otpReceived;
	}

	public boolean isOtpChecked() {
		return otpChecked;
	}

	public void setOtpChecked(boolean otpChecked) {
		this.otpChecked = otpChecked;
	}

	public AcsProduct getAcsproduct() {
		return acsProduct;
	}

	public void setAcsproduct(AcsProduct acsproduct) {
		this.acsProduct = acsproduct;
	}

	public Css getStyle() {
		return style;
	}

	public void setStyle(Css style) {
		this.style = style;
	}

	public String getMerchantUrl() {
		return merchantUrl;
	}

	public void setMerchantUrl(String merchantUrl) {
		this.merchantUrl = merchantUrl;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Byte getNumberTries() {
		return numberTries;
	}

	public void setNumberTries(Byte numberTries) {
		this.numberTries = numberTries;
	}

	public String getXmlData() {
		return xmlData;
	}

	public void setXmlData(String xmlData) {
		this.xmlData = xmlData;
	}

	public static HttpServletRequest getRequest() {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		if (request == null) {
			throw new RuntimeException(
					"Sorry. Got a null request from faces context");
		}
		return request;
	}

	public int getCurrencyExponent() {
		return currencyExponent;
	}

	public void setCurrencyExponent(int currencyExponent) {
		this.currencyExponent = currencyExponent;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Document getXmlPAReq() {
		return xmlPAReq;
	}

	public void setXmlPAReq(Document xmlPAReq) {
		this.xmlPAReq = xmlPAReq;
	}

	public String getCardTruncated() {
		return cardTruncated;
	}

	public void setCardTruncated(String cardTruncated) {
		this.cardTruncated = cardTruncated;
	}

	public Date getTrxDAte() {
		return trxDAte;
	}

	public void setTrxDAte(Date trxDAte) {
		this.trxDAte = trxDAte;
	}

	public String getPareq() {
		return pareq;
	}

	public void setPareq(String pareq) {
		this.pareq = pareq;
	}

	public AuthenticationData getAuthenticationData() {
		return authenticationData;
	}

	public void setAuthenticationData(AuthenticationData authenticationData) {
		this.authenticationData = authenticationData;
	}

	public List<FieldDefinition> getHtmlFields() {
		return htmlFields;
	}

	public void setHtmlFields(List<FieldDefinition> htmlFields) {
		this.htmlFields = htmlFields;
	}

	public String getCavv() {
		return cavv;
	}

	public void setCavv(String cavv) {
		this.cavv = cavv;
	}
	public String checkMessageId(String id) {
		logger.debug("checkMessageId ->");
		String messageId = "";
		if (!id.isEmpty()) {
			logger.debug("StringUtils.isAlpha(element.getAttribute(attribute) "
					+ StringUtils.isAlpha(id.substring(0, 1)));
			if (!StringUtils.isAlpha(id.substring(0, 1))) {
				messageId = "id" + RandomStringUtils.randomAlphanumeric(10);

			}
			else
				messageId = id;
		}else
			messageId = id;
		
		return messageId;
	}

	public HashMap<String, Object> getTagMap() {
		return tagMap;
	}

	public void setTagMap(HashMap<String, Object> tagMap) {
		this.tagMap = tagMap;
	}

	public String getTermUrl() {
		return termUrl;
	}

	public void setTermUrl(String termUrl) {
		this.termUrl = termUrl;
	}

	public String getEncodedPares() {
		return encodedPares;
	}

	public void setEncodedPares(String encodedPares) {
		this.encodedPares = encodedPares;
	}
	
	
	private PaResMessage checkPaReqDataMatchVeReq(VeReqMessage veReq,
			PaReqMessage paReq) {
		logger.debug("checkPaReqDataMatchVeReq ->");
		PaResMessage PaRes = new PaResMessage();

		// PaRes.setiReqCode("");
		PaRes.setiReqDetail("");
		PaRes.setVendorCode("");
		logger.debug("checkVersion(veReq.getVersion() "
				+ checkVersion(veReq.getVersion()));
		
		if (!veReq.getVersion().equals(paReq.getVersion())
				|| !checkVersion(veReq.getVersion())) {
			PaRes.setiReqCode("55");
			PaRes.setiReqDetail("PAReq.version");
			isErrorVEReqPareq = true;

		}

		if (!veReq.getAcqBin().equals(paReq.getAcqBIN())) {
			PaRes.setiReqCode("55");
			PaRes.setiReqDetail("PAReq.Merchant.acqBIN");
			isErrorVEReqPareq = true;
		}
		
		if (!veReq.getMerId().equals(paReq.getMerId())) {
			PaRes.setiReqCode("55");
			PaRes.setiReqDetail("PAReq.Merchant.merID");
			isErrorVEReqPareq = true;
		}
		// if (!paReq.getMerchantCountry().equals("")) // check is ISO
		// veRes.setiReqCode("54");

		// TODO check if currency and expononet are

		// getCountry(paReq.getCountry());

		getCurrency(paReq.getCurrency());
		
		if (currencyCountry == null) { // check is ISO
			PaRes.setiReqCode("54");
			PaRes.setiReqDetail("PAReq.Purchase.currency");
			isErrorVEReqPareq = true;
		}
		
		if (!isErrorVEReqPareq && getCountry(paReq.getCountry())) { // check is
																	// ISO
			logger.debug("getCountry currencyCountry == null");
			PaRes.setiReqCode("54");
			PaRes.setiReqDetail("PAReq.Merchant.country");
			isErrorVEReqPareq = true;
		}
		
		if (!isErrorVEReqPareq && currencyCountry != null && !paReq.getExponent().equals(
					currencyCountry.getId().getExponent().toString())) {
			logger.debug("paReq.getExponent().equals(currencyCountry.getId().getExponent())");
				// Exponent doesn't match currency
				PaRes.setiReqCode("55");
				//PaRes.setiReqDetail("PAReq.Purchase.currency, PAReq.Purchase.exponent");
				PaRes.setiReqDetail("PAReq.Purchase.exponent");
				isErrorVEReqPareq = true;			
		}

		if (paReq.getRecurEndRecur() != null && (paReq.getRecurEndRecur().length() == 0 || paReq
						.getRecurEndRecur().length() == 8)) {
			logger.debug("endRecurS.length() == 0 || endRecurS.length() == 8");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyMMdd");
			sdf.setLenient(false);
			sdf2.setLenient(false);
			try {
				Date exp = sdf2.parse(paReq.getExpiry() + "01");
				Date endRecur = sdf.parse(paReq.getRecurEndRecur());
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(exp);
				int lastday = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

				Date expiry = sdf2.parse(paReq.getExpiry() + lastday);
				if (endRecur.after(expiry)) {
					PaRes.setiReqCode("55");
					PaRes.setiReqDetail("Purchase.Recur.endRecur");
					isErrorVEReqPareq = false;
				}

			} catch (ParseException e) {
				e.printStackTrace();
				PaRes.setiReqCode("55");
				PaRes.setiReqDetail("Purchase.Recur.endRecur");
				isErrorVEReqPareq = true;
			}
		}

		logger.debug("isErrorVEReqPareq " + isErrorVEReqPareq);
		logger.debug("code   " + PaRes.getiReqCode());
		logger.debug("detail "+PaRes.getiReqDetail());
		logger.debug("<- checkPaReqDataMatchVeReq");
		return PaRes;
	}

	private boolean checkVersion(String version) {
		logger.debug("checkVersion>");
		String[] versionR = version.split("\\.");
		String[] versionS = GlobalData.versionNumber.split("\\.");
		logger.debug(Arrays.toString(versionR) + " " + Arrays.toString(versionS));
		if (versionR.length != 3
				|| (versionR[0] == ""
						|| versionR[1] == ""
						|| versionR[2] == ""
						|| Integer.valueOf(versionS[0]) > Integer
								.valueOf(versionR[0])
						|| Integer.valueOf(versionS[1]) > Integer
								.valueOf(versionR[1]) || Integer
						.valueOf(versionS[2]) > Integer.valueOf(versionR[2]))) {
			return false;
		} else
			return true;
	}

	public  void getCurrency(String currency) {
		logger.debug("getCurrency->");
		currencyCountry = null;
		currencyCountry = (CurrencyCountry) dao.findByGenCriteriaUniqueResult( 
				CurrencyCountry.class, " where id.currencyCode='" + currency + "'");
		logger.debug("currencyCountry " + currencyCountry );
		logger.debug("<-getCurrency");
	}

	public  boolean getCountry(String country) {
		logger.debug("getCountry-> " + country);
		DAO dao = new DAO();
		
		 currencyCountry = (CurrencyCountry) dao.findByGenCriteriaUniqueResult( 
				CurrencyCountry.class, " where id.countryCode='" + country + "'");

		logger.debug("<-getCountry");
		return currencyCountry == null ? true : false;
	}
	*/
}

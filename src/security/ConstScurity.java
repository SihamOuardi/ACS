package security;

public class ConstScurity {

	public final static String Msg_Deprecated    ="2.0.0";
	public final static String Msg_Active_1    ="2.1.0";
	public final static String Msg_Active_2    ="2.2.0";

	public final static String messageTypeAReq ="AReq";
	public final static String messageTypeARes ="ARes";
	public final static String messageTypeCReq ="CReq";
	public final static String messageTypeCRes ="CRes";
	public final static String messageTypePReq ="PReq";
	public final static String messageTypePRes ="PRes";
	public final static String messageTypeRReq ="RReq";
	public final static String messageTypeRRes ="RRes";
	public final static String messageTypeErro ="Erro";
			
	public final static String browserColorDepth1="1";
	public final static String browserColorDepth4="4";
	public final static String browserColorDepth8="8";
	public final static String browserColorDepth15="15";
	public final static String browserColorDepth16="16";
	public final static String browserColorDepth24="24";
	public final static String browserColorDepth32="32";
	public final static String browserColorDepth48="48";

	public final static String deviceChannelAPP="01";
	public final static String deviceChannelBRW="02";
	public final static String deviceChannel3RI="03";

	public final static String transStatusY="Y"; // Auth success
	public final static String transStatusN="N"; // Not auth
	public final static String transStatusU="U"; // not be performed
	public final static String transStatusA="A"; // Attempts processing
	public final static String transStatusC="C"; // challange required addition auth is required using CReq / CRes
	public final static String transStatusD="D"; // challange Required , Decoupled authentication confirmed
	public final static String transStatusR="R"; // authen account rejected
	public final static String transStatusI="I"; // Informational

	
	public final static String transType01="01";
	public final static String transType03="03";
	public final static String transType10="10";
	public final static String transType11="10";
	public final static String transType28="11";

	 
	public final static String messageCategoryPA="01";
	public final static String messageCategoryNPA="02";
	
	public final static String ACSURLBRW= "http://localhost:8080/FIMEACS/ChallengeFlow";
	
	public final static String actionIndA = "A"; // add card range to the cache PRes msg 
	public final static String actionIndD = "D"; // delete the card range from the cache 
	public final static String actionIndM = "M"; // modify the card range data
	
	public final static String AuthType01="01";//Static 
	public final static String AuthType02="02";// Dynamiq
	public final static String AuthType03="03";// OOB
	public final static String AuthType04="04";// Decoupled
	public final static String AuthType05="05";// Reserved for future EMVCo use
	public final static String AuthType06="80";// for DS

	public final static String AuthMethod01="01";//Static Passcode
	public final static String AuthMethod02="02";// SMS OTP
	public final static String AuthMethod03="03";// ey fob or EMV card reader OTP
	public final static String AuthMethod04="04";// App OTP
	public final static String AuthMethod05="05";// OTP Other
	public final static String AuthMethod06="06";// KBA
	public final static String AuthMethod07="07";// OOB Biometrics
	public final static String AuthMethod08="08";// OOB Login
	public final static String AuthMethod09="09";// OOB Other
	public final static String AuthMethod10="10";//  Other Push Confirmation
	public final static String AuthMethod11="11";// Push Confirmation
	public final static String AuthMethod12="12-79"; // Reserved for future EMVCo use
	public final static String AuthMethod80="80-90";// for DS

}

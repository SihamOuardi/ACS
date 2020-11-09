package acs.message.detailMsg;

public class SdkEphemPubKey {
	 private  String kty;
	 private  String crv; 
	 private  String x;
	 private  String y;
 
		 public SdkEphemPubKey() {
				super();				
			}
 
		public SdkEphemPubKey(String kty, String crv, String x, String y) {
			super();
			this.kty = kty;
			this.crv = crv;
			this.x = x;
			this.y = y;
		}
		public String getKty() {
			return kty;
		}
		public void setKty(String kty) {
			this.kty = kty;
		}
		public String getCrv() {
			return crv;
		}
		public void setCrv(String crv) {
			this.crv = crv;
		}
		public String getX() {
			return x;
		}
		public void setX(String x) {
			this.x = x;
		}
		public String getY() {
			return y;
		}
		public void setY(String y) {
			this.y = y;
		}

}
